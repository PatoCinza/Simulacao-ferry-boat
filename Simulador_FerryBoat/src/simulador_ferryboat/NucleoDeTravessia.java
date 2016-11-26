/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulador_ferryboat;

import java.util.AbstractQueue;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.DelayQueue;

/**
 *
 * @author Cris
 * Nucleo de travessia significa a parte em que um carro entra na fila para uma balsa, até a hora que ela sai.
 */


public class NucleoDeTravessia {
    private Balsa balsa;
    private float tempoEspera;
    private Queue fila = new ArrayDeque(500);
    
    public void setBalsa(Balsa balsa){
        this.balsa = balsa;
    }

    public void setTempoEspera(float tempoEspera) {
        this.tempoEspera = tempoEspera;
    }
    
    
    public void iniciar() throws InterruptedException{
        ContadorTempo contadorGeral = new ContadorTempo();
        Mensagem m = new Mensagem();
        //ContadorTempo contadorEntrada = new ContadorTempo();
        
        contadorGeral.iniciar();
        
        for(int i = 0;; i++){
            
            int aleatorio = (int)(Math.random()*1000)%5+1; //Gera um numero aleatorio de carros a ser adicionado na fila
            for(int j = 0; j < aleatorio; j++){
                Carro car = new Carro(contadorGeral.tempoDecorrido());
                fila.add(car); //Adiciona carros a fila
                m.m("1 carro adicionado a fila.");
            }
            
            
             if(balsa.getTempo()<=contadorGeral.tempoDecorrido()){ //Se o tempo de carga/descarga esgotar: balsa sai.
                 m.m("Tempo de balsa esgotou! Balsa partiu!");
                 Thread.sleep(10000);
                 System.out.println(contadorGeral.tempoDecorrido());
                 
             }else{
                 Cliente c = (Cliente) fila.remove();
                 m.m("Um cliente vai entrar na balsa!");
                 c.agir();
                 
                 if(balsa.adicionar(c)){
                     c.setTempoSaida(contadorGeral.tempoDecorrido());
                     m.m("Cliente entrou na balsa depois de "+c.tempoFila()+" tempo na fila!");//CONSERTAR ESSE TEMPO DE FILA!!
                     
                     //?
                 }else{
                     m.m("Cliente não pode entrar na balsa pois está lotada!");
                     continue;
                 }

             }
        }
        
       
    }
}
