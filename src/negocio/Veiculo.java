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
public class Veiculo {
    private String placa;
    private int ano;
    private String modelo;

    public Veiculo(String placa, int ano, String modelo) {
        this.placa = placa;
        this.ano = ano;
        this.modelo = modelo;
    }

    public Veiculo() {
    }
    
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }


}
