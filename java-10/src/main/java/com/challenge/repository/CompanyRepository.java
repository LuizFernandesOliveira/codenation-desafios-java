package com.challenge.repository;

import com.challenge.entity.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CompanyRepository extends CrudRepository<Company, Long> {

    @Query(value = "SELECT * FROM company co" +
            " INNER JOIN candidate ca ON co.id = ca.company_id" +
            " INNER JOIN acceleration ac ON ca.acceleration_id = ac.id" +
            " WHERE ac.id = :accelerationId" +
            " LIMIT 1",
            nativeQuery = true)
    List<Company> findByAccelerationId(@Param("accelerationId") Long accelerationId);

    @Query(value = "SELECT * FROM company co" +
            " INNER JOIN candidate ca ON co.id = ca.company_id" +
            " INNER JOIN users u ON ca.user_id = u.id" +
            " WHERE u.id = :userId",
            nativeQuery = true)
    List<Company> findByUserId(@Param("userId") Long userId);
}
