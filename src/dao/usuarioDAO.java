/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexaoBD.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import pessoa.Pessoa;

/**
 *
 * @author adowt
 */
public class usuarioDAO implements genericsDAO<Pessoa, Integer>{

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void apagar(Pessoa obj) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pessoa getByID(Integer ID) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Pessoa> getAll() throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getQuant() throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
