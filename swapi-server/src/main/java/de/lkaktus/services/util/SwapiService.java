package de.lkaktus.services.util;

import de.lkaktus.entities.SwapiCollectionResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SwapiService{

    private final WebClient webClient;

    @Autowired
    public SwapiService(@Value("${app.env.swapi_url}") String url){
        this.webClient = WebClient.create(url);
    }

    public <R> List<R> getAll(String endpoint, ParameterizedTypeReference<SwapiCollectionResponseDTO<R>> reference){
        SwapiCollectionResponseDTO<R> response = this.getAllFromPage(1, endpoint, reference);
        List<R> result = response.results();
        for(int i = 2; response.next() != null && !response.next().isEmpty(); i++){
            response = this.getAllFromPage(i, endpoint, reference);
            result.addAll(response.results());
        }
        return result;
    }

    private <R> SwapiCollectionResponseDTO<R> getAllFromPage(int page, String endpoint, ParameterizedTypeReference<SwapiCollectionResponseDTO<R>> reference){
        WebClient.ResponseSpec responseSpec = this.webClient.get().uri(String.format(endpoint, page)).retrieve();
        try{
            ResponseEntity<SwapiCollectionResponseDTO<R>> result = responseSpec.toEntity(reference).block();
            return result.getBody();
        } catch (WebClientResponseException webClientResponseException){
            this.handleError(webClientResponseException);
        } catch (NullPointerException nullPointerException){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Response is empty.");
        }
        return null;
    }

    public <R> R get(String id, String endpoint, ParameterizedTypeReference<R> reference){
        try{
            Integer.parseInt(id);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id is not a number. id: " + id);
        }
        WebClient.ResponseSpec responseSpec = this.webClient.get().uri(String.format(endpoint, id)).retrieve();
        try{
            ResponseEntity<R> result = responseSpec.toEntity(reference).block();
            return result.getBody();
        } catch (WebClientResponseException webClientResponseException){
            this.handleError(webClientResponseException);
        } catch (NullPointerException nullPointerException){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Response is empty.");
        }
        return null;
    }

    private void handleError(WebClientResponseException webClientResponseException){
        if(webClientResponseException.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The requested item could not be found.");
        }else if(webClientResponseException.getStatusCode().is5xxServerError()){
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Swapi is broken.");
        }else{
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unknown error occurred.");
        }
    }
}
