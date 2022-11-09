package com.example.reddit.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Collection;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue
    private long id;

    @NonNull
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Collection<User> users;

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    public Role(String name) {
        this.name = name;
    }
}
