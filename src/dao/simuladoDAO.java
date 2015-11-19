/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import aula.Simulado;
import conexaoBD.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pessoa.Aluno;

/**
 *
 * @author adowt
 */
public class simuladoDAO {

    
    public void inserir(Simulado obj, Aluno alu) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();
        
        String sql = "INSERT INTO aluno_simulados(login,data_simulado,nota_resultado,preco_simulado) "
                + "VALUES(?,?,?,?)";
        
        PreparedStatement stm = c.prepareStatement(sql);
        
        stm.setString(1, alu.getLogin());
        stm.setString(2, obj.getData());
        stm.setInt(3, obj.getResultado());
        stm.setFloat(4, obj.getPreco());
        
        System.out.println(stm);
        stm.executeUpdate();
    }

    public void alterar(Simulado obj, Aluno alu) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();
        
        String sql = "UPDATE aluno_simulados SET "
                + "data_simulado = ?, "
                + "nota_resultado = ? "
                + "WHERE login = ? OR id = ?";
        
        PreparedStatement stm = c.prepareStatement(sql);
        
        stm.setString(1, obj.getData());
        stm.setInt(2, obj.getResultado());
        stm.setString(3, alu.getLogin());
        stm.setInt(4, obj.getId());
        
        System.out.println(stm);
        stm.executeUpdate();
    }
    
    public void alterar(Simulado obj) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();
        
        String sql = "UPDATE aluno_simulados SET "
                + "data_simulado = ?, "
                + "nota_resultado = ? "
                + "WHERE  id_simulado = ?";
        
        PreparedStatement stm = c.prepareStatement(sql);
        
        stm.setString(1, obj.getData());
        stm.setInt(2, obj.getResultado());
        stm.setInt(3, obj.getId());
        
        System.out.println(stm);
        stm.executeUpdate();
    }
    
    public void apagar(Simulado obj, Aluno alu) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();
        
        String sql = "DELETE FROM aluno_simulados" 
                + "WHERE login = ? AND data = ?;";
        
        PreparedStatement stm = c.prepareStatement(sql);
        
        stm.setString(1, alu.getLogin());
        stm.setString(2, obj.getData());
        
        System.out.println(stm);
        stm.executeUpdate();
    }

    
    public ArrayList<Simulado> procurar(Simulado obj, Aluno alu) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();
        
        String sql = "SELECT * FROM aluno_simulados WHERE login = ? ";
        
        if(!obj.getData().equals("")){
            sql += "AND data_simulado = '"+obj.getData()+"' ";
        }
        
        if(obj.getResultado() != -1){
            sql += "AND nota_resultado = "+obj.getResultado()+" ";
        }
        
        PreparedStatement stm = c.prepareStatement(sql);
        
        stm.setString(1, alu.getLogin());
        
        System.out.println(stm);
        ResultSet rs = stm.executeQuery();
        
        ArrayList<Simulado> simuList = new ArrayList<>();
        while(rs.next()){
            Simulado simuAdd = new Simulado(rs.getInt("id_simulado"), rs.getString("data_simulado"), rs.getInt("nota_resultado"), rs.getInt("preco_simulado"));
            simuList.add(simuAdd);
        }
        return simuList;
    }    
    
    public ArrayList<Simulado> procurarTodos() throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();
        
        String sql = "SELECT * FROM aluno_simulados WHERE login IS NOT NULL  ";
        
        PreparedStatement stm = c.prepareStatement(sql);
        
        System.out.println(stm);
        ResultSet rs = stm.executeQuery();
        
        ArrayList<Simulado> simuList = new ArrayList<>();
        while(rs.next()){
            Simulado simuAdd = new Simulado(rs.getInt("id_simulado"), rs.getString("data_simulado"), rs.getInt("nota_resultado"), rs.getInt("preco_simulado"));
            simuList.add(simuAdd);
        }
        return simuList;
    }    
}
