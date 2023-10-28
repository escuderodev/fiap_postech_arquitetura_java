package br.com.escuderodev.fiap.gradle.api.usuarios_pettech.service;

import br.com.escuderodev.fiap.gradle.api.usuarios_pettech.controller.exception.NotFoundExceptionController;
import br.com.escuderodev.fiap.gradle.api.usuarios_pettech.dto.UsuarioDTO;
import br.com.escuderodev.fiap.gradle.api.usuarios_pettech.entities.Usuario;
import br.com.escuderodev.fiap.gradle.api.usuarios_pettech.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repo;

    public Page<UsuarioDTO> findAll(Pageable pageable) {
        Page<Usuario> usuarios = repo.findAll(pageable);
        return usuarios.map(this::toDTO);
    }

    public UsuarioDTO findById(Long id) {
        Usuario usuario = repo.findById(id).orElseThrow(() -> new NotFoundExceptionController("Usuário não encontrado!"));

        return toDTO(usuario);
    }

    public UsuarioDTO save(UsuarioDTO usuarioDTO) {
        Usuario usuario = toEntity(usuarioDTO);
        usuario = repo.save(usuario);

        return toDTO(usuario);
    }

    public UsuarioDTO update(Long id, UsuarioDTO usuarioDTO) {
        try {
            Usuario usuario = repo.getReferenceById(id);

            usuario.setNome(usuarioDTO.nome());
            usuario.setDataNascimento(usuarioDTO.dataNascimento());
            usuario.setEmail(usuarioDTO.email());
            usuario.setCpf(usuarioDTO.cpf());

            usuario = repo.save(usuario);

            return toDTO(usuario);

        } catch (EntityNotFoundException e) {
            throw new NotFoundExceptionController("Usuário não encontrado!");
        }
    }

    public void delete(long id) {
        repo.deleteById(id);
    }

    private UsuarioDTO toDTO(Usuario usuario) {
        return new UsuarioDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getCpf(),
                usuario.getDataNascimento()
        );
    }

    private Usuario toEntity(UsuarioDTO usuarioDTO) {
        return new Usuario(
                usuarioDTO.id(),
                usuarioDTO.nome(),
                usuarioDTO.email(),
                usuarioDTO.cpf(),
                usuarioDTO.dataNascimento()
        );
    }

}
