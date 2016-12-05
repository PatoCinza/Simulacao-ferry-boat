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
    private int qntd = 0;
    private int tempo;
    ArrayList<Cliente> clientes = new ArrayList<>();
    private long tempoDeSaida = 0;

    public long getTempoDeSaida() {
        return tempoDeSaida;
    }

    public void setTempoDeSaida(long tempoDeSaida) {
        this.tempoDeSaida = tempoDeSaida;
    }
    
    

    public Balsa(int limite, int tempo) {
        this.limite = limite;
        this.tempo = tempo;
    }
    
    

    public void resetar(){
        clientes.clear();
        qntd=0;
    }
    
    public boolean adicionar(Cliente cliente){
        String aux = cliente.getClass().getName().substring(cliente.getClass().getName().lastIndexOf(".")+1);
        if(aux.equals("Pessoa")){
            if(qntd + 1 > limite){
                return false;
            }
            qntd++;
        }else if(aux.equals("Carro")){
            if(qntd + 10 > limite){
                return false;
            }
            qntd = qntd + 10;
        }else if(aux.equals("Moto")){
            if(qntd + 3 > limite){
                return false;
            }
            qntd = qntd + 3;
        }
        clientes.add(cliente);
        return true;
    }


    public int getTempo() {
        return tempo;
    }
    
    
}
