package com.example.splitwisedec22prep.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date lastModifiedAt;
}


// Last session of LLD 3 Module
// Agenda
// Implement
    // Models
    // Set up or codebase of SettleUpUser
    // Commands

// HW
    // Strategy => Heap algorithm
    // completing the controller and make the code working
    // By Friday evening : Push on github
    // register user
    // add user in the group
    // add a particular expense in the group