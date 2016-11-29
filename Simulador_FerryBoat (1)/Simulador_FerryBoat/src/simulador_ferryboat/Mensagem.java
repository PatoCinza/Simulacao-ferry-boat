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
public class Mensagem {

    private Principal frame;

    public Mensagem(Principal frame) {
        this.frame = frame;
    }
    
    public void m(int campo, String s){
        System.out.println(" - "+s);
        System.out.println("");
        switch(campo){
            case 1: frame.setjTextArea1(s);
                break;
            case 2: frame.setjTextArea2(s);
                break;
            case 3: frame.setjTextArea3(s);
                break;
            case 4: frame.setjTextArea4(s);
                break;
        }

            
        
        
    }
}
