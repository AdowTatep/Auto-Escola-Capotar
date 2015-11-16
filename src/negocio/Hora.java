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
public class Hora {
    private int hora;
    private int minuto;

    public Hora(int hora, int minuto) {
        this.hora = hora;
        this.minuto = minuto;
    }
    
    public String getHora() {
        return hora+":"+minuto;
    }

    public void setHora(int hora, int minuto) {
        this.hora = hora;
        this.minuto = minuto;
    }
    
    public void addMinutos(int valor){
        //Adiciona os minutos a uma variável auxiliar
        int minAdd = minuto + valor;
        
        //Se minutos passarem de 59
        if(minAdd > 59) {
            //Adicionamos um à hora
            hora++;
            
            if (hora >= 24) {
                //Se hora passar de 24, ela zera, pois ja é outro dia
                hora = 00;
            }
            //Guardamos o minuto para calcular o tempo excedido
            minAdd = minuto;
            
            //Zeramos o minuto
            minuto = 00;
            
            //Adicionamos o tempo excedido
            minuto += valor-minAdd;
        } else {
            minuto = minAdd;
        }
    }
    
}
