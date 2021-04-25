package com.challenge.repository;

import com.challenge.entity.Challenge;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChallengeRepository extends CrudRepository<Challenge, Long> {
    @Query(value = "SELECT * FROM challenge ch" +
            " INNER JOIN acceleration a ON ch.id = a.challenge_id" +
            " INNER JOIN candidate ca ON a.id = ca.acceleration_id" +
            " INNER JOIN users u ON ca.user_id = u.id" +
            " WHERE a.id = :accelerationId AND u.id = :userId",
            nativeQuery = true)
    List<Challenge> findByAccelerationIdAndUserId(
            @Param("accelerationId") Long accelerationId,
            @Param("userId") Long userId);


}