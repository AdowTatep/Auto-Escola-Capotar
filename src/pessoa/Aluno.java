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
    
    public Aluno(Pessoa pess) {
        //Esse construtor cria um aluno vazio recebendo uma pessoa
        super(pess.getLogin(), pess.getSenha(), pess.getNome(), pess.getCpf(), pess.getTipo());
        this.simulados = null;
        this.aulas = null;
        this.matricula = new Matricula(0, 0);
    }
    public Aluno(Pessoa pess, Matricula matricula, ArrayList<Simulado> simulados, ArrayList<Aula> aulas) {
        //Esse construtor cria um aluno completo recebendo pessoa
        super(pess.getLogin(), pess.getSenha(), pess.getNome(), pess.getCpf(), pess.getTipo());
        this.simulados = simulados;
        this.aulas = aulas;
        this.matricula = matricula;
    }
    

    public Aluno(String login, String senha, String nome, String cpf, String tipo) {
        //Esse construtor cria um aluno nulo com infos de pessoa
        super(login, senha, nome, cpf, tipo);
        this.simulados = null;
        this.aulas = null;
        this.matricula = new Matricula(0, 0);
    }

    public Aluno(String login, String senha, String nome, String cpf, String tipo, Matricula matricula, ArrayList<Simulado> simulados, ArrayList<Aula> aulas) {
        //Esse construtor cria um aluno com tudo preenchido
        super(login, senha, nome, cpf, tipo);
        this.simulados = simulados;
        this.aulas = aulas;
        this.matricula = matricula;
    }
    
    public Aluno(String login, String senha, String nome, String cpf, String tipo, int numeroMat, float saldoMat) {
        //Esse construtor cria um aluno preenchendo a matricula
        super(login, senha, nome, cpf, tipo);
        this.simulados = null;
        this.aulas = null;
        this.matricula = new Matricula(numeroMat, saldoMat);
    }
    
    public Aluno(Pessoa pess, int numeroMat, float saldoMat) {
        //Esse construtor recebe uma pessoa e cria um aluno preenchendo a matricula
        super(pess.getLogin(), pess.getSenha(), pess.getNome(), pess.getCpf(), pess.getTipo());
        this.simulados = null;
        this.aulas = null;
        this.matricula = new Matricula(numeroMat, saldoMat);
    }

    public Aluno(String login, String senha, String nome, String cpf, String tipo, int numeroMat, float saldoMat, ArrayList<Simulado> simulados, ArrayList<Aula> aulas) {
        //Esse construtor cria um aluno completo
        super(login, senha, nome, cpf, tipo);
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
