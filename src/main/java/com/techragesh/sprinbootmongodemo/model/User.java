package com.techragesh.sprinbootmongodemo.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document(collection = "users")
@Data
public class User {

    @Id
    private String id;

    @Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)
    private String username;

    private String password;

    private boolean enabled;

    @DBRef
    private Set<Role> roles;

}
