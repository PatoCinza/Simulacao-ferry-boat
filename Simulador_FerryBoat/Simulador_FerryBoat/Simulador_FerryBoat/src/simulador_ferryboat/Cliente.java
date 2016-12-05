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
    private int id;
    private long tempoEntrada;
    private long tempoSaida;
    private static int aux = 0;

    public Cliente() {
        this.id = aux;
        this.tempoEntrada = 0;
        this.tempoSaida = 0;
        aux++;
    }

    
    public int getId(){
        return id;
    }

    public long tempoFila(){
        return tempoEntrada-tempoSaida;
    }

    public void setTempoEntrada(long tempoEntrada) {
        this.tempoEntrada = tempoEntrada;
    }

    public void setTempoSaida(long tempoSaida) {
        this.tempoSaida = tempoSaida;
    }

    
    public abstract void agir();
    
    
}
