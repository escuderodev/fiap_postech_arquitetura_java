package br.com.escuderodev.parking.api.models.condutor;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@Entity(name = "Condutor")
@Table(name = "condutores")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Condutor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String telefone;

    public Condutor(@Valid DadosCadastroCondutor dados) {
        this.nome = dados.nome();
        this.cpf = dados.cpf();
        this.telefone = dados.telefone();
    }

    public void atualizaDados(DadosAtualizaCondutor dados) {
        this.nome = dados.nome();
        this.cpf = dados.cpf();
        this.telefone = dados.telefone();
    }
}
