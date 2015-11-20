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
import negocio.Veiculo;

/**
 *
 * @author adowt
 */
public class veiculoDAO implements genericsDAO<Veiculo>{

    @Override
    public void inserir(Veiculo obj) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();
        
        String sql = "INSERT INTO veiculos VALUES (?,?,?)";
        
        PreparedStatement stm = c.prepareStatement(sql);
        stm.setString(1, obj.getPlaca());
        stm.setInt(2, obj.getAno());
        stm.setString(3, obj.getModelo());
        
        System.out.println(stm);
        
        stm.executeUpdate();
        
    }

    
    public void alterar(Veiculo obj, Veiculo mod) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnection();
        
        String sql = "UPDATE veiculos SET "
                + "placa = ?, "
                + "ano = ?, "
                + "modelo = ? "
                + "WHERE placa = ?";
        
        PreparedStatement stm = c.prepareStatement(sql);
        stm.setString(1, obj.getPlaca());
        stm.setInt(2, obj.getAno());
        stm.setString(3, obj.getModelo());
        stm.setString(4, mod.getPlaca());
        
        System.out.println(stm);
        
        stm.executeUpdate();
    }

    @Override
    public void apagar(Veiculo obj) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();
        
        String sql = "DELETE FROM veiculos "
                + "WHERE placa = ?";
        
        PreparedStatement stm = c.prepareStatement(sql);
        stm.setString(1, obj.getPlaca());
        
        System.out.println(stm);
        
        stm.executeUpdate();
    }

    @Override
    public Veiculo getByLoginSenha(Veiculo obj) throws ClassNotFoundException, SQLException {
        //Nao implementado.
        return null;
    }

    @Override
    public ArrayList<Veiculo> procurar(Veiculo obj) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();
        
        String sql = "SELECT * FROM veiculos WHERE placa is not null ";
        
        if(!obj.getPlaca().equals("")){
            sql += "AND placa = '" +obj.getPlaca()+ "' ";  
        }
        if(obj.getAno() != 0 ){
            sql += "AND ano = '" +obj.getAno()+ "' ";              
        }
        if(!obj.getModelo().equals("")){
            sql += "AND modelo = '" +obj.getModelo()+ "' ";  
        }
        
        PreparedStatement stm = c.prepareStatement(sql);
        System.out.println(stm);
        
        
        ResultSet rs = stm.executeQuery();
        
        ArrayList<Veiculo> listaVeiculos = new ArrayList<>();
        while(rs.next()){
            Veiculo add = new Veiculo(rs.getString("placa"), rs.getInt("ano"), rs.getString("modelo"));
            listaVeiculos.add(add);
        }
        
        return listaVeiculos;
                
        
              
    }
    
}
