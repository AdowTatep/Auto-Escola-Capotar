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
import negocio.Config;

/**
 *
 * @author adowt
 */
public class configDAO {

    public void alterar(Config obj) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnection();
        
        String sql = "UPDATE config SET "
                + "preco_aula = ?, "
                + "minutos_aula = ?, "
                + "preco_simulado = ?";
        
        PreparedStatement stm = c.prepareStatement(sql);
        
        stm.setFloat(1, obj.getPrecoAula());
        stm.setInt(2, obj.getMinutosAula());
        stm.setFloat(3, obj.getPrecoSimulado());
        
        System.out.println(stm);
        stm.executeUpdate();
    }
    
    public Config buscar(Config obj) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnection();
        
        String sql = "SELECT * FROM config;";
        
        PreparedStatement stm = c.prepareStatement(sql);
        
        System.out.println(stm);
        ResultSet rs = stm.executeQuery();
        
        if(rs.next()) {
            Config cf = new Config(rs.getFloat("preco_aula"), rs.getInt("minutos_aula"), rs.getFloat("preco_simulado"));            
            return cf;
        } else {
            return null;
        }
    }
    
}
