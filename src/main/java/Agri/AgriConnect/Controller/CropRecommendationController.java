package Agri.AgriConnect.Controller;

import Agri.AgriConnect.Dto.CropRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/crop")
public class CropRecommendationController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/predict")
    public ResponseEntity<?> predictCrop(
            @RequestBody CropRequestDTO request) {

        try {

            String apiUrl =
                    "https://croprecommendationapi-uvob.onrender.com/predict";

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<CropRequestDTO> entity =
                    new HttpEntity<>(request, headers);

            ResponseEntity<String> response =
                    restTemplate.exchange(
                            apiUrl,
                            HttpMethod.POST,
                            entity,
                            String.class
                    );

            return ResponseEntity.ok(response.getBody());

        } catch (Exception e) {

            e.printStackTrace();

            return ResponseEntity.status(500)
                    .body(e.getMessage());
        }
    }
}