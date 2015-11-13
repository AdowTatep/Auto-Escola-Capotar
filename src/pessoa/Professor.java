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
    
    private int registro;
    private float pagamento;

    public Professor() {
    }

    public Professor(String login, String senha, String nome, String cpf, String tipo, int registro, float pagamento) {
        super(login, senha, nome, cpf, tipo);
        this.registro = registro;
        this.pagamento = pagamento;
    }
    
    public Professor(Pessoa pess, int registro, float pagamento) {
        super(pess.getLogin(), pess.getSenha(), pess.getNome(), pess.getCpf(), pess.getTipo());
        this.registro = registro;
        this.pagamento = pagamento;
    }

    public int getRegistro() {
        return registro;
    }

    public void setRegistro(int registro) {
        this.registro = registro;
    }

    public float getPagamento() {
        return pagamento;
    }

    public void setPagamento(float pagamento) {
        this.pagamento = pagamento;
    }
    
    
}
