package br.com.gurudoamor.projeto.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MapsService {

    private static final String API_KEY = "AIzaSyA-xybdKKaWtEjHKwTh6Anm3uWwfTi06OU";

    public String calcularRota(String origem, String destino) {
        String url = String.format("https://maps.googleapis.com/maps/api/directions/json?origin=%s&destination=%s&key=%s",
                origem, destino, API_KEY);

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);

        return processarRota(response);
    }

    private String processarRota(String response) {
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
