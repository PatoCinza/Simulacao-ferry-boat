/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulador_ferryboat;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cris
 */
public class Moto extends Cliente{

    public Moto(double tempoEntrada) {
        super(tempoEntrada);
    }

    @Override
    public void agir() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Carro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
