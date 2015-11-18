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
 */
public interface genericsDAO<C> {
   public void inserir(C obj) throws ClassNotFoundException, SQLException;
   
   public void apagar(C obj) throws ClassNotFoundException, SQLException;
   public C getByLoginSenha(C obj) throws ClassNotFoundException, SQLException;
   public ArrayList<C> procurar(C obj) throws ClassNotFoundException, SQLException;
}