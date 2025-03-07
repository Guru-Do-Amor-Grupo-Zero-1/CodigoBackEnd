package br.com.gurudoamor.projeto.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MapsController {

    private static final String API_KEY = "AIzaSyA-xybdKKaWtEjHKwTh6Anm3uWwfTi06OU"; // chave da api maps no google cloud

    @GetMapping("/rota")
    public String getRoute(@RequestParam String origem, @RequestParam String destino) {
        String url = String.format("https://maps.googleapis.com/maps/api/directions/json?origin=%s&destination=%s&key=%s",
                origem, destino, API_KEY);

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);

        return processRouteResponse(response);
    }

    private String processRouteResponse(String response) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(response);

            if (jsonNode.has("routes") && jsonNode.get("routes").size() > 0) {
                JsonNode route = jsonNode.get("routes").get(0);
                JsonNode leg = route.get("legs").get(0);

                String distance = leg.get("distance").get("text").asText();
                String duration = leg.get("duration").get("text").asText();
                String polyline = route.get("overview_polyline").get("points").asText();

                return String.format("Distância: %s\nTempo Estimado: %s\nPolyline: %s", distance, duration, polyline);
            }
        } catch (Exception e) {
            return "Erro ao processar a resposta da API";
        }

        return "Nenhuma rota encontrada!";
    }
}
