package com.sda.usersservice.domain;

import lombok.*;

import javax.persistence.*;

@Data
@Table(name = "USERS")
@Entity
public class Users {

    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private BloodGroup bloodGroup;
}
