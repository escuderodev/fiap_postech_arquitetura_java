package br.com.escuderodev.parking.api.models.condutor;

import br.com.escuderodev.parking.api.models.condutor.Condutor;
import jakarta.validation.constraints.NotBlank;

public record DadosListagemCondutor(
        Long id,
        @NotBlank
        String nome,
        @NotBlank
        String cpf,
        @NotBlank
        String telefone
) {
        public DadosListagemCondutor(Condutor condutor) {
                this(condutor.getId(), condutor.getNome(), condutor.getCpf(), condutor.getTelefone());
        }
}
