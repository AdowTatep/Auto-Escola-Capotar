/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pessoa;

import aula.Aula;
import aula.Simulado;
import java.util.ArrayList;
import negocio.Matricula;

/**
 *
 * @author adowt
 */
public class Aluno extends Pessoa {
    private ArrayList<Simulado> simulados;
    private ArrayList<Aula> aulas;
    private Matricula matricula;

    public Aluno() {
        super();
    }

    public Aluno(String login, String senha, String nome, String tipo) {
        super(login, senha, nome, tipo);
    }

    public Aluno(ArrayList<Simulado> simulados, ArrayList<Aula> aulas, Matricula matricula, String login, String senha, String nome, String tipo) {
        super(login, senha, nome, tipo);
        this.simulados = simulados;
        this.aulas = aulas;
        this.matricula = matricula;
    }
    
    public Aluno(String login, String senha, String nome, String tipo, int numeroMat, float saldoMat) {
        super(login, senha, nome, tipo);
        this.simulados = null;
        this.aulas = null;
        this.matricula = new Matricula(numeroMat, saldoMat);
    }

    public Aluno(String login, String senha, String nome, String tipo, int numeroMat, float saldoMat, ArrayList<Simulado> simulados, ArrayList<Aula> aulas) {
        super(login, senha, nome, tipo);
        this.simulados = simulados;
        this.aulas = aulas;
        this.matricula = new Matricula(numeroMat, saldoMat);
    }
    
    

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
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
