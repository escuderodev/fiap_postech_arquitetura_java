package br.com.escuderodev.fiap.gradle.api.usuarios_pettech.dto;

import java.time.LocalDate;

public record UsuarioDTO(
        Long id,
        String nome,
        String email,
        String cpf,
        LocalDate dataNascimento
) {
}