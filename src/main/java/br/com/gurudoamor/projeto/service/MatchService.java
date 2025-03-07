package br.com.gurudoamor.projeto.service;
import br.com.gurudoamor.projeto.entity.Usuario;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class MatchService {

    private final MapsService mapsService;
    public MatchService(MapsService mapsService) {
        this.mapsService = mapsService;
    }



    public Map<String, Object> matchUsuarios(Usuario usuario1, Usuario usuario2) {
        Map<String, Object> resultado = new HashMap<>();
        int compatibilidade = new Random().nextInt(100) + 1;
        String distanciaInfo = mapsService.calcularRota(usuario1.getEndereco(), usuario2.getEndereco());
        String combinacaoSignos = usuario1.getSignoUsuario().name() + " + " + usuario2.getSignoUsuario().name();

        resultado.put("usuario1", usuario1.getNomeUsuario());
        resultado.put("usuario2", usuario2.getNomeUsuario());
        resultado.put("compatibilidade", compatibilidade + "%");
        resultado.put("signos", combinacaoSignos);
        resultado.put("distancia", distanciaInfo);

        return resultado;
    }
}
