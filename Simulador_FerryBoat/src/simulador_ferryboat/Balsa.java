/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulador_ferryboat;

import java.util.ArrayList;

/**
 *
 * @author Cris
 */
public class Balsa {
    
    private int limite;
    private int qntd;
    private int tempo;
    ArrayList<Cliente> clientes = new ArrayList<>();

    public Balsa(int limite, int tempo) {
        this.limite = limite;
        this.tempo = tempo;
    }
    
    

    
    
    public boolean adicionar(Cliente cliente){
        clientes.add(cliente);
        if(cliente.getClass().getName().substring(cliente.getClass().getName().lastIndexOf(".")+1)=="Pessoa"){
            if(qntd + 1 > limite){
                return false;
            }
            qntd++;
        }else if(cliente.getClass().getName().substring(cliente.getClass().getName().lastIndexOf(".")+1)=="Carro"){
            if(qntd + 10 > limite){
                return false;
            }
            qntd = qntd + 10;
        }else if(cliente.getClass().getName().substring(cliente.getClass().getName().lastIndexOf(".")+1)=="Moto"){
            if(qntd + 3 > limite){
                return false;
            }
            qntd = qntd + 3;
        }
        return true;
    }


    public int getTempo() {
        return tempo;
    }
    
    
}
