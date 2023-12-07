package br.com.escuderodev.parking.api.dto.condutor;

import br.com.escuderodev.parking.api.models.Condutor;
import br.com.escuderodev.parking.api.models.Veiculo;
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
