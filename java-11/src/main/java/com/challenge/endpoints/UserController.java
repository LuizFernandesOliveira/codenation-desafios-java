package com.challenge.endpoints;

import com.challenge.entity.User;
import com.challenge.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    Optional<User> findById(@PathVariable("id") Long userId){
        return userService.findById(userId);
    }

    @GetMapping
    List<User> findByAccelerationNameOrCompanyId(
            @RequestParam(value = "accelerationName", required = false) String name,
            @RequestParam(value = "companyId", required = false) Long companyId
    ){
        if (companyId != null){
            return userService.findByCompanyId(companyId);
        }
        return userService.findByAccelerationName(name);
    }

}
