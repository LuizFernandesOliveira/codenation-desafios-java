package com.challenge.repository;

import com.challenge.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query(value = "SELECT * FROM users us" +
            " INNER JOIN candidate ca ON us.id = ca.user_id" +
            " INNER JOIN acceleration ac ON ca.acceleration_id = ac.id" +
            " WHERE ac.name like %:accelerationName%",
            nativeQuery = true)
    List<User> findByAccelerationName(@Param("accelerationName") String accelerationName);

    @Query(value = "SELECT * FROM users us" +
            " INNER JOIN candidate ca ON us.id = ca.user_id" +
            " INNER JOIN company co ON ca.company_id = co.id" +
            " WHERE co.id = :companyId",
            nativeQuery = true)
    List<User> findByCompanyId(@Param("companyId") Long companyId);
}