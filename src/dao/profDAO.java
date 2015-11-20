/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexaoBD.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pessoa.Pessoa;
import pessoa.Professor;

/**
 *
 * @author adowt
 */
public class profDAO implements genericsDAO<Professor>{

    @Override
    public void inserir(Professor obj) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();
        
        usuarioDAO usuDAO = new usuarioDAO();
        
        //Busca o usuário na tabela usuario se já existir usuario
        //com essas informações ele somente insere na tabela
        //professor
        if(usuDAO.getByLoginSenha(obj) != null) {
            String sql = "INSERT INTO professor VALUES(?,?);";
            
            PreparedStatement stm = c.prepareStatement(sql);
            
            stm.setString(1, obj.getLogin());
            stm.setString(2, obj.getRegistro());
            
            //Imprime o statement no console
            System.out.println(stm);
            stm.executeUpdate();
        } else {
            //Se nenhum usuario existir na tabela usuario
            //Insira um usuario
            usuDAO.inserir(obj);
            
            //E só depois insira na tabela professor
            String sql = "INSERT INTO professor VALUES(?,?);";
            
            PreparedStatement stm = c.prepareStatement(sql);
            
            stm.setString(1, obj.getLogin());
            stm.setString(2, obj.getRegistro());
            
            //Imprime o statement no console
            System.out.println(stm);
            stm.executeUpdate();
        }
    }

    
    public void alterar(Professor obj, Pessoa mod) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnection();
        
        //Todos os professores tem que ter um login então
        //ao alterar na tabela professor
        //será alterado na tabela usuario tambem
        usuarioDAO usuDAO = new usuarioDAO();
        
        usuDAO.alterar(obj, mod);
        
        String sql = "UPDATE professor SET "
                + "login = ?, "
                + "registro = ? "
                + "WHERE login = ?;";
        
        PreparedStatement stm = c.prepareStatement(sql);
        
        stm.setString(1, obj.getLogin());
        stm.setString(2, obj.getRegistro());
        stm.setString(3, mod.getLogin());
        
        //Imprime o statement no console
        System.out.println(stm);
        stm.executeUpdate();
    }

    @Override
    public void apagar(Professor obj) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();
        
        String sql =  "DELETE FROM professor "
                + "WHERE login = ?;";
        
        PreparedStatement stm = c.prepareStatement(sql);
        stm.setString(1, obj.getLogin());
        stm.executeUpdate();
        
        usuarioDAO usuDAO = new usuarioDAO();
        usuDAO.apagar(obj);
    }

    @Override
    public Professor getByLoginSenha(Professor obj) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();
        
        String sql = "SELECT * FROM usuario u, professor p "
                + "WHERE u.login=p.login "
                + "AND p.login = ? AND u.senha = ?";
        
        PreparedStatement stm = c.prepareStatement(sql);
        stm.setString(1, obj.getLogin());
        stm.setString(2, obj.getSenha());
        
        ResultSet rs = stm.executeQuery();
        System.out.println(stm);
        if (rs.next()){
            Professor prof = new Professor(rs.getString("login"), rs.getString("senha"),
                    rs.getString("nome"), rs.getString("cpf"), rs.getString("tipo"), 
                    rs.getString("registro"));
            return prof;
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<Professor> procurar(Professor obj) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();
        
        String sql = "SELECT * FROM usuario u, professor p "
                + "WHERE u.login=p.login ";        
        
        if (!obj.getLogin().equals("")) {
            sql += "AND login = '"+obj.getLogin()+"' ";
        }         
        if (!obj.getSenha().equals("")) {
            sql += "AND senha = '"+obj.getSenha()+"' ";
        }
        if (!obj.getNome().equals("")) {
            sql += "AND nome = '"+obj.getNome()+"' ";
        }   
        if (!obj.getCpf().equals("")) {
            sql += "AND cpf = '"+obj.getCpf()+"' ";            
        }
        if (!obj.getTipo().equals("")) {
            sql += "AND tipo = '"+obj.getTipo()+"' ";
        }
        if (!obj.getRegistro().equals("")) {
            sql += "AND registro = '"+obj.getRegistro()+"' ";
        }
        
        PreparedStatement stm = c.prepareStatement(sql);
        
        System.out.println(stm);
        ResultSet rs = stm.executeQuery();
        
        ArrayList<Professor> profReturn = new ArrayList<>();
        
        while (rs.next()){
           Professor prof = new Professor(rs.getString("login"), rs.getString("senha"),
                    rs.getString("nome"), rs.getString("cpf"), rs.getString("tipo"), 
                    rs.getString("registro"));
            
            profReturn.add(prof);
        }    
        
        return profReturn;
    }
    
}
