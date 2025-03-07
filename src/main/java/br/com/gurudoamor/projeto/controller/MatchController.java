package br.com.gurudoamor.projeto.controller;
import br.com.gurudoamor.projeto.entity.Usuario;
import br.com.gurudoamor.projeto.repository.UsuarioRepository;
import br.com.gurudoamor.projeto.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/match")
public class MatchController {

    @Autowired
    UsuarioRepository usuarioRepository;
    private final MatchService matchService;
    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @PostMapping
    public Map<String, Object> match(@RequestBody Map<String, Usuario> usuarios) {
        Usuario usuario1 = usuarios.get("usuario1");
        Usuario usuario2 = usuarios.get("usuario2");
        return matchService.matchUsuarios(usuario1, usuario2);
    }
}
