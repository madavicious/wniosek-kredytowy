/*
package pl.javaskills.creditapp.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.javaskills.creditapp.core.bik.BikApi;
import pl.javaskills.creditapp.core.bik.ErrorResponse;
import pl.javaskills.creditapp.core.bik.ScoringRequest;
import pl.javaskills.creditapp.core.bik.ScoringResponse;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static pl.javaskills.creditapp.core.Constants.BIK_API_URL_ENDPOINT;

public class BikApiAdapter implements BikApi {
    private static final Logger log = LoggerFactory.getLogger(BikApiAdapter.class);
    private static final HttpClient client = HttpClient.newBuilder().build();
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private String token;

    {
        token =System.getenv("API_TOKEN");
        if(token == null){
            throw new IllegalStateException("Missing env variable");
        }
    }

    @Override
    public ScoringResponse getScoring(ScoringRequest request) {
        try {
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(new URI(BIK_API_URL_ENDPOINT))
                    .header("x-token", token)
                    .POST(HttpRequest.BodyPublishers.ofString(objectMapper.writeValueAsString(request)))
                    .build();
            log.info(httpRequest.toString());
            HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            if(response.statusCode() != 200){
                ErrorResponse errorResponse = objectMapper.readValue(response.body(), ErrorResponse.class);
                throw new IllegalStateException(errorResponse.getError());
            }
            return objectMapper.readValue(response.body(), ScoringResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalStateException("Unexpected error during communication with BIK API");
        }
    }
}

 */
