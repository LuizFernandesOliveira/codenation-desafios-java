package com.challenge.endpoints;

import com.challenge.entity.Acceleration;
import com.challenge.service.impl.AccelerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/acceleration")
public class AccelerationController {

    @Autowired
    private AccelerationService accelerationService;

    @GetMapping("/{id}")
    Optional<Acceleration> findById(@PathVariable("id") Long id){
        return accelerationService.findById(id);
    }

    @GetMapping
    List<Acceleration> findByCompanyId(@RequestParam Long companyId){
        return accelerationService.findByCompanyId(companyId);
    }

}
