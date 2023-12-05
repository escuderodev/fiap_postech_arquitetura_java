package br.com.escuderodev.parking.api.models;

import br.com.escuderodev.parking.api.dto.condutor.DadosCadastroCondutor;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Condutor {
    private String nome;
    private String cpf;
    private String telefone;

    public Condutor(DadosCadastroCondutor dados) {
        this.nome = dados.nome();
        this.cpf = dados.cpf();
        this.telefone = dados.telefone();
    }

    public void atualizaDados(DadosCadastroCondutor dados) {
        this.nome = dados.nome();
        this.cpf = dados.cpf();
        this.telefone = dados.telefone();
    }
}
