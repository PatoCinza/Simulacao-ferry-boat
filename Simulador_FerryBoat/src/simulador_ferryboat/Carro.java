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
public class Carro extends Cliente{

    @Override
    public void agir() {
        try {
            Thread.sleep(2);
        } catch (InterruptedException ex) {
            Logger.getLogger(Carro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
