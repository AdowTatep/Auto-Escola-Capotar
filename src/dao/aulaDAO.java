/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import aula.Aula;
import conexaoBD.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pessoa.Professor;

/**
 *
 * @author adowt
 */
public class aulaDAO implements genericsDAO<Aula>{

    @Override
    public void inserir(Aula obj) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();
        
        String sql = "INSERT INTO aulas(tipo, login_professor, nome_professor, hora_inicio, hora_fim, data_aula)"
                + " VALUES(?,?,?,?,?,?);";
        
        PreparedStatement stm = c.prepareStatement(sql);
        
        stm.setString(1, obj.getTipo());
        stm.setString(2, obj.getProf().getLogin());
        stm.setString(3, obj.getProf().getNome());
        stm.setString(4, obj.getHoraInicio());
        stm.setString(5, obj.getHoraFim());
        stm.setString(6, obj.getData());
        
        System.out.println(stm);
        stm.executeUpdate();
    }

    @Override
    public void alterar(Aula obj) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnection();
        
        String sql = "UPDATE aulas SET "
                + "tipo = ?, "
                + "login_professor = ?, "
                + "nome_professor = ?, "
                + "hora_inicio = ?, "
                + "hora_fim = ?, "
                + "data_aula = ? "
                + "WHERE id_aula = ?;";
        
        PreparedStatement stm = c.prepareStatement(sql);
        
        stm.setString(1, obj.getTipo());
        stm.setString(2, obj.getProf().getLogin());
        stm.setString(3, obj.getProf().getNome());
        stm.setString(4, obj.getHoraInicio());
        stm.setString(5, obj.getHoraFim());
        stm.setString(6, obj.getData());
        stm.setInt(7, obj.getId());
        
        System.out.println(stm);
        stm.executeUpdate();
    }

    @Override
    public void apagar(Aula obj) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();
        
        String sql = "DELETE FROM aulas"
                + "WHERE id_aula = ?;";
        
        PreparedStatement stm = c.prepareStatement(sql);
        
        stm.setInt(1, obj.getId());
        
        System.out.println(stm);
        stm.executeUpdate();
    }

    @Override
    public Aula getByLoginSenha(Aula obj) throws ClassNotFoundException, SQLException {
        //Aulas não precisam de pegar por login
    }

    @Override
    public ArrayList<Aula> procurar(Aula obj) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();
        
        String sql = "SELECT * FROM aulas WHERE id_aula IS NOT NULL ";        
        
        if (obj.getId() != 0) {
            sql += "AND id_aula = '"+obj.getId()+"' ";
        }         
        if (!obj.getTipo().equals("")) {
            sql += "AND tipo = '"+obj.getTipo()+"' ";
        }
        if (!obj.getProf().getLogin().equals("")) {
            sql += "AND login_professor = '"+obj.getProf().getLogin()+"' ";
        }
        if (!obj.getProf().getNome().equals("")) {
            sql += "AND nome_professor = '"+obj.getProf().getNome()+"' ";
        }
        if (!obj.getHoraInicio().equals("")) {
            sql += "AND hora_inicio = '"+obj.getHoraInicio()+"' ";
        }   
        if (!obj.getHoraFim().equals("")) {
            sql += "AND hora_fim = '"+obj.getHoraFim()+"' ";
        }
        if (!obj.getData().equals("")) {
            sql += "AND data = '"+obj.getData()+"' ";
        }
        
        PreparedStatement stm = c.prepareStatement(sql);
        
        System.out.println("Query: "+sql);
        ResultSet rs = stm.executeQuery();
        
        if (rs.next()){
            ArrayList<Aula> aulaReturn = new ArrayList<>();
           
            
            //NECESSARIO CRIAR PROFESSOR NO BANCO E MESCLAR PARA PEGAR TODAS AS INFORMAÇÕES DO PROFESSOR
            Professor profAdd = new Professor(rs.getString("login_professor"), "", rs.getString("nome_professor"), "", "Professor", 0,0);
            
            Aula aula = new Aula(rs.getInt("id_aula"), rs.getString("tipo"), profAdd, rs.getString("hora_inicio"), sql, sql)
            
            aluReturn.add(alu);
            
            return aluReturn;
        } else {
            return null;
        }
    }
    
}
