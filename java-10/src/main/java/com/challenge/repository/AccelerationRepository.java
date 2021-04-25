package com.challenge.repository;

import com.challenge.entity.Acceleration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccelerationRepository extends CrudRepository<Acceleration, Long> {

    @Query(value = "SELECT * FROM acceleration a" +
            " INNER JOIN candidate ca ON a.id = ca.acceleration_id" +
            " INNER JOIN company co ON ca.company_id = co.id" +
            " WHERE co.id = :companyId",
            nativeQuery = true)
    List<Acceleration> findByCompanyId(@Param("companyId") Long companyId);
}
