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

/**
 *
 * @author adowt
 */
public class usuarioDAO implements genericsDAO<Pessoa>{

    @Override
    public void inserir(Pessoa obj) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();
        
        String sql = "INSERT INTO usuario VALUES(?,?,?,?,?);";
        PreparedStatement stm = c.prepareStatement(sql);
        stm.setString(1, obj.getLogin());
        stm.setString(2, obj.getSenha());
        stm.setString(3, obj.getNome());
        stm.setString(4, obj.getCpf());
        stm.setString(5, obj.getTipo());
        
        //Imprime o statement no console
        System.out.println(stm);
        stm.executeUpdate();
    }

    
    public void alterar(Pessoa obj, Pessoa mod) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnection();
        
        String sql = "UPDATE usuario SET "
                + "login = ?, "
                + "senha = ?, "
                + "nome = ?, "
                + "tipo = ? "
                + "WHERE login = ?";
        
        PreparedStatement stm = c.prepareStatement(sql);
        stm.setString(1, obj.getLogin());
        stm.setString(2, obj.getSenha());
        stm.setString(3, obj.getNome());
        stm.setString(4, obj.getTipo());
        stm.setString(5, mod.getLogin());
        
        //Imprime o statement no console
        System.out.println(stm);
        stm.executeUpdate();
    }

    @Override
    public void apagar(Pessoa obj) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();
        
        String sql = "DELETE FROM usuario WHERE login = ?";
        
        PreparedStatement stm = c.prepareStatement(sql);
        stm.setString(1, obj.getLogin());
        
        //Imprime o statement no console
        System.out.println(stm);
        stm.executeUpdate();
    }

    @Override
    public Pessoa getByLoginSenha(Pessoa obj) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();
        
        String sql = "SELECT * FROM usuario WHERE login = ? AND senha = ?";
        
        PreparedStatement stm = c.prepareStatement(sql);
        stm.setString(1, obj.getLogin());
        stm.setString(2, obj.getSenha());
        
        //Imprime o statement no console
        System.out.println(stm);
        ResultSet rs = stm.executeQuery();
        
        if (rs.next()){
            Pessoa usu = new Pessoa(rs.getString("login"), rs.getString("senha"), rs.getString("nome"), rs.getString("cpf"), rs.getString("tipo"));
            return usu;
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<Pessoa> procurar(Pessoa obj) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();
        
        String sql = "SELECT * FROM usuario WHERE login is not null ";
                
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
        
        PreparedStatement stm = c.prepareStatement(sql);
        
        //Imprime o statement no console
        System.out.println(stm);
        ResultSet rs = stm.executeQuery();
        
        ArrayList<Pessoa> pessReturn = new ArrayList<>();
        while(rs.next()){
            Pessoa alu = new Pessoa(rs.getString("login"), rs.getString("senha"),
                    rs.getString("nome"), rs.getString("cpf"), rs.getString("tipo"));
            pessReturn.add(alu);
        }
        return pessReturn;
    }
    
    public ArrayList<Pessoa> procurarTodos() throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();
        
        String sql = "SELECT * FROM usuario WHERE login is not null ";
                
        PreparedStatement stm = c.prepareStatement(sql);
        
        //Imprime o statement no console
        System.out.println(stm);
        ResultSet rs = stm.executeQuery();
        
        ArrayList<Pessoa> pessReturn = new ArrayList<>();
        while(rs.next()){
            Pessoa alu = new Pessoa(rs.getString("login"), rs.getString("senha"),
                    rs.getString("nome"), rs.getString("cpf"), rs.getString("tipo"));
            pessReturn.add(alu);
        }
        return pessReturn;
    }
    
}
