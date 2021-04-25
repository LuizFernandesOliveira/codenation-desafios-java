package com.challenge.repository;

import com.challenge.entity.Submission;
import com.challenge.entity.SubmissionId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface SubmissionRepository extends CrudRepository<Submission, SubmissionId> {

    @Query(value = "SELECT MAX(su.score) FROM Submission su" +
            " WHERE su.challenge_id = :challengeId ",
            nativeQuery = true)
    BigDecimal findHigherScoreByChallengeId(@Param("challengeId") Long challengeId);

    @Query(value = "SELECT * FROM Challenge ch" +
            " INNER JOIN Submission su" +
            " ON ch.id = su.challenge_id" +
            " INNER JOIN Acceleration ac" +
            " ON ch.id = ac.challenge_id" +
            " WHERE ch.id = :challenge_id AND ac.id =:acceleration_id",
            nativeQuery = true)
    List<Submission> findByChallengeIdAndAccelerationId(
            @Param("challenge_id") Long challengeId,
            @Param("acceleration_id") Long accelerationId);
}
