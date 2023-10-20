package br.com.escuderodev.fiap.models;

public class Acumulador extends Thread {
    private static int Acc;
    private int valorSomar;

    public Acumulador() {
        this.valorSomar = 1;
    }

    public Acumulador(int valor) {
        this.valorSomar = valor;
    }

    public int getAcc() {
        return Acc;
    }

    public int getValorSomar() {
        return valorSomar;
    }

    public synchronized void run() {

        try {
            this.Acc = this.Acc + this.valorSomar;
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
