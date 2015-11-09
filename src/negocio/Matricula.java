/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import pessoa.Aluno;

/**
 *
 * @author Design-01
 */
public class Matricula {
    private int numero;
    private int valorTotalPago;

    public Matricula() {
    }

    public Matricula(int numero, int valorTotalPago) {
        this.numero = numero;
        this.valorTotalPago = valorTotalPago;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getValorTotalPago() {
        return valorTotalPago;
    }

    public void setValorTotalPago(int valorTotalPago) {
        this.valorTotalPago = valorTotalPago;
    }
}
