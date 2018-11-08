package ohtu.ohtuvarasto.main;

import ohtu.ohtuvarasto.Varasto;

public class Main {

    public static void main(String[] args) {
        Varasto varasto = new Varasto(1);
        varasto.otaVarastosta(1);
        System.out.println("Tyhjennetty'd");
        
    }
}
