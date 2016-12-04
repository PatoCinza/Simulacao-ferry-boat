package simulador_ferryboat;

/**
 *
 * @author PatoCinza
 */
public class variaveisDoSistema {
    
    private double tempoEsperaCarro;
    private double tempoBalsaParada;
    private double tempoBalsaMovimento;
    private int numCarros;

    public variaveisDoSistema(int horario) {
        switch(horario){
            case 1:
                tempoEsperaCarro = 0.5;
                tempoBalsaParada = 15;
                tempoBalsaMovimento = 5;
                numCarros = 2;
                break;
            case 2:
                tempoEsperaCarro = 0.25;
                tempoBalsaParada = 15;
                tempoBalsaMovimento = 5;
                numCarros = 5;
                break;
        }
        
    }

    public int getNumCarros() {
        return numCarros;
    }

    public double getTempoEsperaCarro() {
        return tempoEsperaCarro;
    }

    public double getTempoBalsaParada() {
        return tempoBalsaParada;
    }

    public double getTempoBalsaMovimento() {
        return tempoBalsaMovimento;
    }
    
}
