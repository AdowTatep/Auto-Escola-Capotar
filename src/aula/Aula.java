/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula;

import pessoa.Professor;

/**
 *
 * @author adowt
 */
public class Aula {
    private int id;//Identificador
    private String tipo;//Prática ou teórica
    private Professor prof;//Professor
    private String horaInicio;//Hora início
    private String horaFim;//Hora término
    private String data;//Dia da aula
    private float valor;//Preço por essa aula
    private boolean pago;//Pago ou não

    public Aula() {
    }

    public Aula(int id, String tipo, Professor prof, String horaInicio, String horaFim, String data) {
        this.id = id;
        this.tipo = tipo;
        this.prof = prof;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Professor getProf() {
        return prof;
    }

    public void setProf(Professor prof) {
        this.prof = prof;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(String horaFim) {
        this.horaFim = horaFim;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    
}
