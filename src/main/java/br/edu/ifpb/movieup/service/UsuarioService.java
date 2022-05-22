package br.edu.ifpb.movieup.service;

import br.edu.ifpb.movieup.model.Usuario;
import br.edu.ifpb.movieup.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getUsuarios() {
        return this.usuarioRepository.findAll();
    }

    public Usuario getUsuarioPorId(Long idUsuario) {
        return this.usuarioRepository.findById(idUsuario).orElse(null);
    }

    @Transactional
    public Usuario inserirOuAtualizar(Usuario usuario) {
        Usuario usuarioInserido = this.usuarioRepository.save(usuario);
        return usuarioInserido;
    }

    public void apagar(Long id) {
        this.usuarioRepository.deleteById(id);
    }
}

