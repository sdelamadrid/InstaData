package com.slama.instadata.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import com.slama.instadata.model.Follower;

public interface FollowerRepository extends ReactiveMongoRepository<Follower, String> {
}
