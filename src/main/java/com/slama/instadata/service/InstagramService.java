package com.slama.instadata.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import com.slama.instadata.model.Follower;

@Service
public class InstagramService {

    private final WebClient webClient;
    private final String accessToken = "YOUR_ACCESS_TOKEN"; // Reemplaza con tu token de acceso

    public InstagramService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Flux<Follower> getFollowers(String userId) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/{user-id}/followers")
                        .queryParam("access_token", accessToken)
                        .build(userId))
                .retrieve()
                .bodyToFlux(Follower.class);
    }
}
