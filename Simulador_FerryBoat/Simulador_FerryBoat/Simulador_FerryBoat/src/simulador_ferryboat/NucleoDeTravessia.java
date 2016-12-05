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

/**
 *
 * @author Cris
 Nucleo de travessia significa a parte em que um carro entra na fila para uma balsa1, até a hora que ela sai.
 */
public class NucleoDeTravessia {
    private Balsa balsa1;
    private Balsa balsa2;
    private float tempoEspera;
    private Queue fila1 = new ArrayDeque(500);
    private Queue fila2 = new ArrayDeque(500);
    
    public void setBalsas(Balsa balsa1, Balsa balsa2){
        this.balsa1 = balsa1;
        this.balsa2 = balsa2;
    }

    public void setTempoEspera(float tempoEspera) {
        this.tempoEspera = tempoEspera;
    }
    
    
    public void iniciar(Principal frame, int horario) throws InterruptedException{
        variaveisDoSistema variaveis = new variaveisDoSistema(horario);
        
        ContadorTempo contadorGeral = new ContadorTempo();
        ContadorTempo contadorPontual = new ContadorTempo();
        ContadorTempo controleFila1 = new ContadorTempo();
        ContadorTempo controleFila2 = new ContadorTempo();
        int tempoLockFila1 = 0, tempoLockFila2 = 0;

        Mensagem m = new Mensagem(frame);
        //ContadorTempo contadorEntrada = new ContadorTempo();
        
        contadorGeral.iniciar();
        contadorPontual.iniciar();
        controleFila1.iniciar(); 
        controleFila2.iniciar();
        
        for(int i = 0;; i++){
            
            //BALSA 1
            int aleatorio = (int)(Math.random()*1000)%variaveis.getNumCarros(); //Gera um numero aleatorio de carros a ser adicionado na fila
            if (controleFila1.tempoDecorridoSec()> tempoLockFila1) { // Testa se o tempo de trancamento foi excedido para poder adicionar os carros
                for(int j = 0; j < aleatorio; j++){
                    Carro car = new Carro();
                    car.setTempoEntrada(contadorGeral.tempoDecorridoMillis());
                    fila1.add(car); //Adiciona carros a fila
                    m.m(1,"Carro "+car.getId()+" adicionado a fila.");
                    controleFila1.iniciar();  
                    tempoLockFila1 = (int) ((int)(Math.random()*10000)%variaveis.getTempoEsperaCarro()+1); //Define um tempo aleatório dentro dos padrões pros próximos carros chegarem
                    
                }
            }
            
            //BALSA 2
            int aleatorio2 = (int)(Math.random()*1000)% variaveis.getNumCarros(); //Gera um numero aleatorio de carros a ser adicionado na fila
            if (controleFila2.tempoDecorridoSec()> tempoLockFila2) {
                for(int j = 0; j < aleatorio; j++){
                    Carro car = new Carro();
                    car.setTempoEntrada(contadorGeral.tempoDecorridoMillis());
                    fila2.add(car); //Adiciona carros a fila
                    m.m(2, "Carro "+car.getId()+" adicionado a fila.");
                    controleFila2.iniciar();  
                    tempoLockFila2 = (int) ((int)(Math.random()*10000)%variaveis.getTempoEsperaCarro()+1);
                    
                }
            }
            
            if(!(balsa1.getTempoDeSaida()+variaveis.getTempoBalsaMovimento() > contadorGeral.tempoSistemaSec())) {
                //Se o tempo de carga/descarga esgotar: balsa1 e 2 saem
                if(balsa1.getTempo()<=contadorPontual.tempoDecorridoSec()){ 
                    System.out.println("Tempo de balsa esgotou! Balsa partiu!");

                    System.out.println("");
                    balsa1.setTempoDeSaida(contadorGeral.tempoSistemaSec());
                    balsa1.resetar();
                    balsa2.resetar();
                    frame.setjTextArea3(";");
                    frame.setjTextArea3("Travessia de 5 minutos");
                    frame.setjTextArea4(";");
                    frame.setjTextArea4("Travessia de 5 minutos");
                    contadorPontual.iniciar();


                }else{
                    //BALSA 1
                    if (!(fila1.isEmpty())){
                        Cliente c = (Cliente) fila1.peek();

                        c.agir();



                        if(balsa1.adicionar(c)){
                            fila1.poll();
                            c.setTempoSaida(contadorGeral.tempoDecorridoSec());
                            m.m(3, "Cliente "+c.getId()+" entrou na BALSA1 depois de "+c.tempoFila()+" tempo na fila!");
                        }else{
                            
                        }
                    }
                        
                    //BALSA 2
                    if (!(fila2.isEmpty())) {
                        Cliente c2 = (Cliente) fila2.peek();
                        
                        c2.agir();

                        if(balsa2.adicionar(c2)){
                            fila2.poll();
                            c2.setTempoSaida(contadorGeral.tempoDecorridoSec());
                            m.m(4, "Cliente "+c2.getId()+" entrou na BALSA2 depois de "+c2.tempoFila()+" tempo na fila!");
                        }else{
                           
                        }
                    }
                }
            }
        }
        
       
    }
}
