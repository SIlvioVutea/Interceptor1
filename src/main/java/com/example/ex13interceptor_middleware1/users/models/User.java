package com.example.ex13interceptor_middleware1.users.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

//    @Id
//    @GeneratedValue
    private long id;

    private String name;
    private String surname;
}
