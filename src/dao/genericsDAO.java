/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author adowt
 * @param <C>
 * @param <K>
 */
public interface genericsDAO<C, K> {
   public void inserir(C obj) throws ClassNotFoundException, SQLException;
   public void alterar(C obj) throws SQLException, ClassNotFoundException;
   public void apagar(C obj) throws ClassNotFoundException, SQLException;
   public C getByID(K ID) throws ClassNotFoundException, SQLException;
   public ArrayList<C> getAll() throws ClassNotFoundException, SQLException;
   public int getQuant() throws ClassNotFoundException, SQLException;
}