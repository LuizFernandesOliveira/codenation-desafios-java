package com.challenge.endpoints;

import com.challenge.entity.Company;
import com.challenge.service.impl.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class CompanyController {

    private CompanyService service;

    @GetMapping("/company/{id}")
    public Company findById(@PathVariable("id") Long id) {
        return service.findById(id).orElse(null);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/company")
    public List<Company> findAll(@RequestParam Optional<Long> accelerationId, @RequestParam Optional<Long> userId) {
        return accelerationId.map(service::findByAccelerationId)
                .orElseGet(() -> userId.map(service::findByUserId).orElse(new ArrayList<>()));
    }

}
