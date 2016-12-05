/*
    Só fiz para carros.
 */
package simulador_ferryboat;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cris
 */


/*INFORMAÇÕES SOBRE O FERRYBOAT QUE PEGUEI COM A MINHA MAE:
    Cada estação tem um par.
    Cada estação tem uma balsa.
    Quando uma balsa sai de uma estação, a outra balsa da estação que é par tbm sai.
    A balsa obrigatoriamente fica 15 minutos parada na estação. Só saí antes quando entra uma emergencia, como uma ambulancia por exmeplo.
    

INFORMAÇÕES SOBRE COMO FIZ ESSE SIMULADOR
    Pra medir o tempo uso sempre variavel inteira pra facilitar. E utilizo apenas segundos pra facilitar.
    Cada segundo vale 1 minuto na vida real.
    Pra medir o limite de pessoas numa balsa, fiz o seguinte:
    Quando criamos uma balsa, temos que definir o tamanho limite dela.
    uma pessoa sozinha vale 1 unidade desse tamanho.
    um carro, vale 10 unidades desse tamanho
    uma moto, vale 3 unidade desse tamanho.



*/
public class Simulador_FerryBoat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        iniciar();
        

    }
    
    public static void iniciar(){
        int horario = 1;
                
        Principal janela1 = new Principal();
        janela1.setVisible(true);
        ContadorTempo cont = new ContadorTempo();
        NucleoDeTravessia nucleo1 = new NucleoDeTravessia();
        nucleo1.setBalsas(new Balsa(300, 10), new Balsa(350, 10));
        try {
            nucleo1.iniciar(janela1, horario);
        } catch (InterruptedException ex) {
            Logger.getLogger(Simulador_FerryBoat.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
