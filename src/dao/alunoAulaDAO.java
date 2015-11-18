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
import pessoa.Aluno;
import pessoa.Professor;

/**
 *
 * @author adowt
 */
public class alunoAulaDAO{
    
    public void inserir(Aula obj, Aluno alu) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();
        
        String sql = "INSERT INTO aulas_aluno VALUES (?,?)";
        
        PreparedStatement stm = c.prepareStatement(sql);
        
        stm.setInt(1, obj.getId());
        stm.setString(2, alu.getLogin());
        
        System.out.println(stm);
        stm.executeUpdate();
    }
    
    public ArrayList<Aula> procurar(Aula obj, Aluno alu) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();
        
        String sql = "SELECT * FROM aulas au, aulas_aluno alu WHERE au.id_aula=alu.id_aula AND login = ? ";        
        
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
        stm.setString(1, alu.getLogin());
        
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
            
            Aula aula = new Aula(rs.getInt("id_aula"), rs.getString("tipo"), profAdd, rs.getString("hora_inicio"), rs.getString("hora_fim"), rs.getString("data_aula"));
            
            aulaReturn.add(aula);
        }
        return aulaReturn;
    }
}
