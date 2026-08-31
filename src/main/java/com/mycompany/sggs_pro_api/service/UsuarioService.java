package com.mycompany.sggs_pro_api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mycompany.sggs_pro_api.dto.UsuarioRequestDTO;
import com.mycompany.sggs_pro_api.dto.UsuarioResponseDTO;
import com.mycompany.sggs_pro_api.entity.Usuario;
import com.mycompany.sggs_pro_api.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(
            UsuarioRepository repository,
            PasswordEncoder passwordEncoder) {

        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<UsuarioResponseDTO> listarTodos() {

        return repository.findAll()
                .stream()
                .map(this::converterParaResponseDTO)
                .toList();
    }

    public Optional<UsuarioResponseDTO> buscarPorId(Long id) {

        return repository.findById(id)
                .map(this::converterParaResponseDTO);
    }

    public UsuarioResponseDTO salvar(UsuarioRequestDTO dto) {

        Usuario usuario = new Usuario();

        usuario.setNome(dto.getNome());
        usuario.setLogin(dto.getLogin());

        String senhaCriptografada =
                passwordEncoder.encode(dto.getSenha());

        usuario.setSenha(senhaCriptografada);

        Usuario usuarioSalvo = repository.save(usuario);

        return converterParaResponseDTO(usuarioSalvo);
    }

    public UsuarioResponseDTO atualizar(
            Long id,
            UsuarioRequestDTO dto) {

        Usuario usuario = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Usuário não encontrado"));

        usuario.setNome(dto.getNome());
        usuario.setLogin(dto.getLogin());

        if (dto.getSenha() != null && !dto.getSenha().isBlank()) {

            String senhaCriptografada =
                    passwordEncoder.encode(dto.getSenha());

            usuario.setSenha(senhaCriptografada);
        }

        Usuario usuarioAtualizado = repository.save(usuario);

        return converterParaResponseDTO(usuarioAtualizado);
    }

    public void excluir(Long id) {

        repository.deleteById(id);
    }

    private UsuarioResponseDTO converterParaResponseDTO(Usuario usuario) {

        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getLogin()
        );
    }
}