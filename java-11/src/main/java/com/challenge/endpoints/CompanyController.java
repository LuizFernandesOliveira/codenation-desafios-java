package com.challenge.endpoints;

import com.challenge.entity.Company;
import com.challenge.service.impl.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/{id}")
    Optional<Company> findById(@PathVariable("id") Long id){
        return companyService.findById(id);
    }

    @GetMapping
    List<Company> findByUserOrAcceleration(
            @RequestParam(value = "accelerationId", required = false) Long accelerationId,
            @RequestParam(value = "userId", required = false) Long userId
    ) {
        if (userId != null){
            return companyService.findByUserId(userId);
        }
        return companyService.findByAccelerationId(accelerationId);
    }

}
