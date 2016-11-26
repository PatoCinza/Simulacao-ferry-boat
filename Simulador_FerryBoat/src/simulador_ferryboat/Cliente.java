/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulador_ferryboat;

/**
 *
 * @author Cris
 */
public abstract class Cliente {
    
    private double tempoEntrada;
    private double tempoSaida;

    public Cliente(double tempoEntrada) {
        this.tempoEntrada = tempoEntrada;
    }

    public double tempoFila(){
        return tempoSaida-tempoEntrada;
    }

    public void setTempoEntrada(double tempoEntrada) {
        this.tempoEntrada = tempoEntrada;
    }

    public void setTempoSaida(double tempoSaida) {
        this.tempoSaida = tempoSaida;
    }

    
    public abstract void agir();
    
    
}
