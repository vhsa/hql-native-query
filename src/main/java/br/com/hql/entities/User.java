package br.com.hql.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String password;
}
