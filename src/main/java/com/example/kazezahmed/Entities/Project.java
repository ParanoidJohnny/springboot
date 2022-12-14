package com.example.kazezahmed.Entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String description;

    @OneToMany(mappedBy = "project",cascade = CascadeType.PERSIST)
    private List<Sprint> sprints;

    @ManyToMany(mappedBy = "projectList")
    private List<User> users;
}
