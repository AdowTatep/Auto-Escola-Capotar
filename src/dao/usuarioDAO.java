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
        
        String sql = "INSERT INTO usuario VALUES(?,?,?,?);";
        PreparedStatement stm = c.prepareStatement(sql);
        stm.setString(1, obj.getLogin());
        stm.setString(2, obj.getSenha());
        stm.setString(3, obj.getNome());
        stm.setString(4, obj.getTipo());
        
        stm.executeUpdate();
    }

    @Override
    public void alterar(Pessoa obj) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnection();
        
        String sql = "UPDATE usuario "
                + "login = ?"
                + "senha = ?"
                + "nome = ?"
                + "tipo = ?"
                + "WHERE login = ?";
        
        PreparedStatement stm = c.prepareStatement(sql);
        stm.setString(1, obj.getLogin());
        stm.setString(2, obj.getSenha());
        stm.setString(3, obj.getNome());
        stm.setString(4, obj.getTipo());
        stm.setString(5, obj.getLogin());
        
        stm.executeUpdate();
    }

    @Override
    public void apagar(Pessoa obj) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();
        
        String sql = "DELETE FROM usuario WHERE login = ?";
        
        PreparedStatement stm = c.prepareStatement(sql);
        stm.setString(1, obj.getLogin());
    }

    @Override
    public Pessoa getByLoginSenha(Pessoa obj) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();
        
        String sql = "SELECT * FROM usuario WHERE login = ? AND senha = ?";
        
        PreparedStatement stm = c.prepareStatement(sql);
        stm.setString(1, obj.getLogin());
        stm.setString(2, obj.getSenha());
        
        ResultSet rs = stm.executeQuery();
        
        if (rs.next()){
            Pessoa usu = new Pessoa(rs.getString("login"), rs.getString("senha"), rs.getString("nome"), rs.getString("tipo"));
            return usu;
        } else {
            return null;
        }
    }
    
}
