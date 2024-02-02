package com.pblgllgs.batch.entities;
/*
 *
 * @author pblgl
 * Created on 02-02-2024
 *
 */

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "persons")
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "last_name")
    private String lastName;
    private int age;
    @Column(name = "insertion_date")
    private String insertionDate;
}
