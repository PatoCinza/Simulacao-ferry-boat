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
public class ContadorTempo {
    private long inicio = 0;
    private long fim = 0;
    public void iniciar(){
        inicio = System.currentTimeMillis();
    }
    
    
    public int tempoDecorrido(){
        fim = System.currentTimeMillis();
        return (int) ((int)fim - inicio) / 1000;
    }
}
