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
        setVariaveis(horario);
    }
    
    public void setVariaveis(int horario){
        switch(horario){
            case 1:
                tempoEsperaCarro = 0.5;
                tempoBalsaParada = 15;
                tempoBalsaMovimento = 5;
                numCarros = 2;
                System.out.println("Sistema simulando horário das 12:30 - 17:00; baixo tráfego");
                break;
            case 2:
                tempoEsperaCarro = 0.25;
                tempoBalsaParada = 15;
                tempoBalsaMovimento = 5;
                numCarros = 10;
                System.out.println("Sistema simulando horário das 17:30 - 18:30; alto tráfego");
                break;
            default:
                tempoEsperaCarro = 0.5;
                tempoBalsaParada = 15;
                tempoBalsaMovimento = 5;
                numCarros = 2;
                System.out.println("Horário não definido; sistema em baixo tráfego");
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
