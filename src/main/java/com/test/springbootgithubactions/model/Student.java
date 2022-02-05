package com.test.springbootgithubactions.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {

    @Id
    @Generated
    private int id;
    private String name;
    private String subject;

}
