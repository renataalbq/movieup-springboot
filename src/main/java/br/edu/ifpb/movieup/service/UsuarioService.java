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
    public Usuario inserir(Usuario usuario) {
        //Usuario existeUsuario = this.usuarioRepository.findByEmail(usuario.getEmail());
        //if (existeUsuario != null){
        //    throw new Error("Usuario já cadastrado");
        //}
        Usuario inserirUsuario = this.usuarioRepository.save(usuario);
        return inserirUsuario;
    }

    public void apagar(Long id) {
        this.usuarioRepository.deleteById(id);
    }
}

