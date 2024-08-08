package com.slama.instadata.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.slama.instadata.model.Follower;
import com.slama.instadata.repository.FollowerRepository;

@Service
public class FollowerService {

    private final FollowerRepository followerRepository;
    private final InstagramService instagramService;

    private final String userId = "YOUR_USER_ID"; // Reemplaza con tu ID de usuario de Instagram

    public FollowerService(FollowerRepository followerRepository, InstagramService instagramService) {
        this.followerRepository = followerRepository;
        this.instagramService = instagramService;
    }

    public Mono<Void> transferFollowers() {
        Flux<Follower> followers = instagramService.getFollowers(userId);
        return saveAllFollowers(followers).then();
    }

    public Flux<Follower> getAllFollowers() {
        return followerRepository.findAll();
    }

    public Mono<Follower> saveFollower(Follower follower) {
        return followerRepository.save(follower);
    }

    public Flux<Follower> saveAllFollowers(Flux<Follower> followers) {
        return followerRepository.saveAll(followers);
    }

    public Mono<Void> deleteFollower(String id) {
        return followerRepository.deleteById(id);
    }
}
