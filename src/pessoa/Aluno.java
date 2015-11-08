/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pessoa;

import aula.Aula;
import aula.Simulado;
import java.util.ArrayList;

/**
 *
 * @author adowt
 */
public class Aluno extends Pessoa {
    private ArrayList<Simulado> simulados;
    private ArrayList<Aula> aulas;

    public Aluno() {
        super();
    }

    public Aluno(String login, String senha, String nome, String tipo) {
        super(login, senha, nome, tipo);
    }

    public ArrayList<Simulado> getSimulados() {
        return simulados;
    }

    public void setSimulados(ArrayList<Simulado> simulados) {
        this.simulados = simulados;
    }

    public ArrayList<Aula> getAulas() {
        return aulas;
    }

    public void setAulas(ArrayList<Aula> aulas) {
        this.aulas = aulas;
    }
    
    
}
