/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pessoa;

/**
 *
 * @author adowt
 */
public class Professor extends Pessoa {
    
    private String registro;

    public Professor(Pessoa pess, String registro) {
        super(pess.getLogin(), pess.getSenha(), pess.getNome(), pess.getCpf(), pess.getTipo());
        this.registro = registro;
    }
    
    public Professor(String registro, String login, String senha, String nome, String cpf, String tipo) {
        super(login, senha, nome, cpf, tipo);
        this.registro = registro;
    }

    public Professor() {
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }
}
