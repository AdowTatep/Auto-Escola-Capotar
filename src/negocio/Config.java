/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author adowt
 */
public class Config {
    private float precoAula;
    private int minutosAula;
    private float precoSimulado;

    public Config() {
    }

    public Config(float precoAula, int minutosAula, float precoSimulado) {
        this.precoAula = precoAula;
        this.minutosAula = minutosAula;
        this.precoSimulado = precoSimulado;
    }

    public float getPrecoAula() {
        return precoAula;
    }

    public void setPrecoAula(float precoAula) {
        this.precoAula = precoAula;
    }

    public int getMinutosAula() {
        return minutosAula;
    }

    public void setMinutosAula(int minutosAula) {
        this.minutosAula = minutosAula;
    }

    public float getPrecoSimulado() {
        return precoSimulado;
    }

    public void setPrecoSimulado(float precoSimulado) {
        this.precoSimulado = precoSimulado;
    }
    
    
}
