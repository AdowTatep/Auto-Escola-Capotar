/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula;

/**
 *
 * @author adowt
 */
public class Simulado {
    public String data;
    public int resultado;

    public Simulado() {
    }

    public Simulado(String data, int resultado) {
        this.data = data;
        this.resultado = resultado;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }
}
