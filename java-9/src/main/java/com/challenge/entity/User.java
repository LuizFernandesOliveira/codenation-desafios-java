package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@EntityListeners(EntityListeners.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(max = 100)
    private String fullName;

    @NotNull
    @Email
    @Size(max = 100)
    private String email;

    @Column(nullable = false, unique = true)
    @Size(max = 50)
    @NotNull
    private String nickname;

    @Column(nullable = false)
    @Size(max = 255)
    @NotNull
    private String password;

    @CreatedDate
    private LocalDateTime createdAt;

    @OneToMany
    private List<Candidate> candidateList;

    @OneToMany
    private List<Submission> submissionList;

}
