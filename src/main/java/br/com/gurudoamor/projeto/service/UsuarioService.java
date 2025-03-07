package br.com.gurudoamor.projeto.service;

import br.com.gurudoamor.projeto.entity.Usuario;
import br.com.gurudoamor.projeto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }


    public void deleteUser (final Long id){
        final Usuario usuario = this.usuarioRepository.findById(id).orElse(null);

        if (usuario == null){
            throw new RuntimeException();
        }
        this.usuarioRepository.delete(usuario);
    }

}
