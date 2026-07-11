package Agri.AgriConnect.Service;

import Agri.AgriConnect.Dto.ChatRequestDTO;
import Agri.AgriConnect.Dto.ChatResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ChatService {

    @Value("${groq.api.key}")
    private String apiKey;
    @Value("${groq.api.url}")
    private String apiUrl;
    @Value("${groq.model}")
    private String model;

    @Autowired
    private RestTemplate restTemplate;

    public ChatResponseDTO chat(ChatRequestDTO request) {

        Map<String, Object> body = new HashMap<>();
        body.put("model", model);

        List<Map<String, String>> messages = new ArrayList<>();

        Map<String, String> systemMsg = new HashMap<>();
        systemMsg.put("role", "system");
        systemMsg.put("content",
                "You are AgriConnect AI Assistant, a specialized agricultural expert for Indian farmers. " +
                        "You ONLY answer questions related to: " +
                        "1. Soil health, soil types, and soil management. " +
                        "2. Weather conditions and their impact on crops. " +
                        "3. Indian Government schemes for farmers (PM-KISAN, Fasal Bima Yojana, etc.). " +
                        "4. Crop recommendations based on season, soil, and region. " +
                        "5. Agricultural tools and machinery suggestions. " +
                        "6. Crop disease detection and prevention. " +
                        "7. Fertilizers, pesticides, and irrigation techniques. " +
                        "If a user asks anything outside agriculture, politely reply: " +
                        "'I am AgriConnect Assistant. I can only help with farming and agriculture related questions.' " +
                        "Always respond in simple language. If user writes in Hindi, reply in Hindi."
        );
        messages.add(systemMsg);

        Map<String, String> userMsg = new HashMap<>();
        userMsg.put("role", "user");
        userMsg.put("content", request.getMessage());
        messages.add(userMsg);

        body.put("messages", messages);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(apiKey);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);

        ResponseEntity<Map> response = restTemplate.postForEntity(apiUrl, entity, Map.class);

        List<Map> choices = (List<Map>) response.getBody().get("choices");
        Map message = (Map) choices.get(0).get("message");
        String aiReply = (String) message.get("content");

        return new ChatResponseDTO(aiReply);
    }
}