package dev.dhanush.EcomProductService.Client;

import dev.dhanush.EcomProductService.DTO.FakeStoreProductResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Component
public class FakeStoreClient {
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    @Value("${fakestore.api.base.url}")
    private String fakeStoreAPIBaseUrl;
    @Value("${fakestore.api.product.path}")
    private String getFakeStoreAPIPath;

    public List<FakeStoreProductResponseDTO> getAllProducts(){
        String fakeStoreGetAllProductURL = fakeStoreAPIBaseUrl.concat(getFakeStoreAPIPath);
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO[]> productResponseList = restTemplate.getForEntity(fakeStoreGetAllProductURL, FakeStoreProductResponseDTO[].class);
        return List.of(productResponseList.getBody());
    }
}
