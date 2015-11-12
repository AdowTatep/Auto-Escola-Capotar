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
import pessoa.Aluno;
import pessoa.Pessoa;

/**
 *
 * @author aluno
 */
public class alunoDAO implements genericsDAO<Aluno>{

    @Override
    public void inserir(Aluno obj) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();
        
        usuarioDAO usuDAO = new usuarioDAO();
        
        //Busca o usuário na tabela usuario se já existir usuario
        //com essas informações ele somente insere na tabela
        //aluno matricula
        if(usuDAO.getByLoginSenha(obj) != null) {
            String sql = "INSERT INTO aluno_matricula(login, saldo) VALUES(?,?);";
            
            PreparedStatement stm = c.prepareStatement(sql);
            
            stm.setString(1, obj.getLogin());
            stm.setFloat(2, obj.getMatricula().getSaldo());
            
            //Imprime o statement no console
            System.out.println(stm);
            stm.executeUpdate();
        } else {
            //Se nenhum usuario existir na tabela usuario
            //Insira um usuario
            usuDAO.inserir(obj);
            
            //E só depois insira na tabela matrícula
            String sql = "INSERT INTO aluno_matricula(login, saldo) VALUES(?,?);";            
            
            PreparedStatement stm = c.prepareStatement(sql);
            
            stm.setString(1, obj.getLogin());
            stm.setFloat(2, obj.getMatricula().getSaldo());
            
            //Imprime o statement no console
            System.out.println(stm);
            stm.executeUpdate();
        }
        
    }

    @Override
    public void alterar(Aluno obj) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnection();
        
        //Todos os alunos tem que ter um login então
        //ao alterar na tabela aluno_matricula
        //será alterado na tabela usuario tambem
        usuarioDAO usuDAO = new usuarioDAO();
        
        usuDAO.alterar(obj);
        
        
        String sql = "UPDATE aluno_matricula SET "
                + "login = ? , "                
                + "saldo = ? "
                + "WHERE login = ?;";
        
        PreparedStatement stm = c.prepareStatement(sql);
        stm.setString(1, obj.getLogin());
        stm.setFloat(2, obj.getMatricula().getSaldo());
        stm.setString(3, obj.getLogin());
        
        //Imprime o statement no console
        System.out.println(stm);
        stm.executeUpdate();
    }

    @Override
    public void apagar(Aluno obj) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();
        
        String sql =  "DELETE FROM aluno_matricula "
                + "WHERE login = ?;";
        
        PreparedStatement stm = c.prepareStatement(sql);
        stm.setString(1, obj.getLogin());
        stm.executeUpdate();
        
        usuarioDAO usuDAO = new usuarioDAO();
        usuDAO.apagar(obj);
    }

    @Override
    public Aluno getByLoginSenha(Aluno obj) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();
        
        String sql = "SELECT * FROM usuario u, aluno_matricula a "
                + "WHERE u.login=a.login "
                + "AND a.login = ? AND u.senha = ?";
        
        PreparedStatement stm = c.prepareStatement(sql);
        stm.setString(1, obj.getLogin());
        stm.setString(2, obj.getSenha());
        
        ResultSet rs = stm.executeQuery();
        System.out.println(stm);
        if (rs.next()){
            Aluno alu = new Aluno(rs.getString("login"), rs.getString("senha"),
                    rs.getString("nome"), rs.getString("cpf"), rs.getString("tipo"), 
                    rs.getInt("numero_matricula"), rs.getFloat("saldo"));
            return alu;
        } else {
            return null;
        }
    }
    
    public ArrayList<Aluno> procurar(Aluno obj) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();
        
        String sql = "SELECT * FROM usuario u, aluno_matricula a "
                + "WHERE u.login=a.login ";        
        
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
        if (obj.getMatricula().getNumero() != 0) {
            sql += "AND numero_matricula = '"+obj.getMatricula().getNumero()+"' ";
        }
        
        PreparedStatement stm = c.prepareStatement(sql);
        
        System.out.println("Query: "+sql);
        ResultSet rs = stm.executeQuery();
        
        if (rs.next()){
            ArrayList<Aluno> aluReturn = new ArrayList<>();
           
            Aluno alu = new Aluno(rs.getString("login"), rs.getString("senha"),
                    rs.getString("nome"), rs.getString("cpf"), rs.getString("tipo"), 
                    rs.getInt("numero_matricula"), rs.getFloat("saldo"));
            
            aluReturn.add(alu);
            
            return aluReturn;
        } else {
            return null;
        }
    }
    
}
