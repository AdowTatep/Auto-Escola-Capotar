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

    
    public void alterar(Aula obj, Aula mod) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnection();
        
        String sql = "UPDATE aulas SET ";
        if (!obj.getTipo().equals("")) {
            sql += "tipo = '"+obj.getTipo()+"' ";
        }
        if (!obj.getProf().getLogin().equals("")) {
            sql += ", login_professor = '"+obj.getProf().getLogin()+"' ";
        }
        if (!obj.getProf().getNome().equals("")) {
            sql += ", nome_professor = '"+obj.getProf().getNome()+"' ";
        }
        if (!obj.getHoraInicio().equals("")) {
            sql += ", hora_inicio = '"+obj.getHoraInicio()+"' ";
        }   
        if (!obj.getHoraFim().equals("")) {
            sql += ", hora_fim = '"+obj.getHoraFim()+"' ";
        }
        if (!obj.getData().equals("")) {
            sql += ", data_aula = '"+obj.getData()+"' ";
        }
        sql += "WHERE id_aula = ?;";
        
        PreparedStatement stm = c.prepareStatement(sql);
        
        stm.setInt(1, mod.getId());
        
        System.out.println(stm);
        stm.executeUpdate();
    }

    @Override
    public void apagar(Aula obj) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();
        
        String sql = "DELETE FROM aulas "
                + "WHERE id_aula = ?;";
        
        PreparedStatement stm = c.prepareStatement(sql);
        
        stm.setInt(1, obj.getId());
        
        System.out.println(stm);
        stm.executeUpdate();
    }

    @Override
    public Aula getByLoginSenha(Aula obj) throws ClassNotFoundException, SQLException {
        //Aulas não precisam de pegar por login
        return null;
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
            sql += "AND data_aula = '"+obj.getData()+"' ";
        }
        
        PreparedStatement stm = c.prepareStatement(sql);
        
        System.out.println(stm);
        ResultSet rs = stm.executeQuery();
        
        ArrayList<Aula> aulaReturn = new ArrayList<>();
        
        while(rs.next()){
            //NECESSARIO CRIAR PROFESSOR NO BANCO E MESCLAR PARA PEGAR TODAS AS INFORMAÇÕES DO PROFESSOR
            Professor profAdd = new Professor(rs.getString("login_professor"), "", rs.getString("nome_professor"), "", "Professor", "");
            
            profDAO proDAO = new profDAO();
            
            if(proDAO.getByLoginSenha(profAdd)!= null) {
                profAdd = proDAO.getByLoginSenha(profAdd);
            }
            
            Aula aula = new Aula(rs.getInt("id_aula"), rs.getString("tipo"), profAdd, rs.getString("hora_inicio"), rs.getString("hora_fim"), rs.getString("data_aula"), false);
            
            aulaReturn.add(aula);
        }
        return aulaReturn;
    }
    
    public ArrayList<Aula> procurarTodas() throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();
        
        String sql = "SELECT * FROM aulas WHERE id_aula IS NOT NULL "; 
        
        PreparedStatement stm = c.prepareStatement(sql);
        
        System.out.println(stm);
        ResultSet rs = stm.executeQuery();
        
        ArrayList<Aula> aulaReturn = new ArrayList<>();
        
        while(rs.next()){
            //NECESSARIO CRIAR PROFESSOR NO BANCO E MESCLAR PARA PEGAR TODAS AS INFORMAÇÕES DO PROFESSOR
            Professor profAdd = new Professor(rs.getString("login_professor"), "", rs.getString("nome_professor"), "", "Professor", "");
            
            profDAO proDAO = new profDAO();
            
            if(proDAO.getByLoginSenha(profAdd)!= null) {
                profAdd = proDAO.getByLoginSenha(profAdd);
            }            
            
            Aula aula = new Aula(rs.getInt("id_aula"), rs.getString("tipo"), profAdd, rs.getString("hora_inicio"), rs.getString("hora_fim"), rs.getString("data_aula"), false);
            
            aulaReturn.add(aula);
        }
        return aulaReturn;
    }
}
