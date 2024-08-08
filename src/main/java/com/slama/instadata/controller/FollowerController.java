package com.slama.instadata.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import com.slama.instadata.model.Follower;
import com.slama.instadata.service.FollowerService;

@RestController
@RequestMapping("/api/followers")
public class FollowerController {

    private final FollowerService followerService;

    public FollowerController(FollowerService followerService) {
        this.followerService = followerService;
    }

    @GetMapping
    public Flux<Follower> getAllFollowers() {
        return followerService.getAllFollowers();
    }

    @PostMapping
    public Mono<Follower> saveFollower(@RequestBody Follower follower) {
        return followerService.saveFollower(follower);
    }

    @PostMapping("/transfer")
    public Mono<Void> transferFollowers() {
        return followerService.transferFollowers();
    }
}
