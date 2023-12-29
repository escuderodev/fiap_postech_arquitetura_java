package br.com.escuderodev.parking.api.models.estacionamento;

public class FormaPagamento {
    private String metodoPagamento;

    public FormaPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }
}
