package com.techragesh.sprinbootmongodemo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "roles")
@Data
public class Role {

    @Id
    private String id;
    @Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)
    private String role;
}

