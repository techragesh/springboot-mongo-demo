package com.techragesh.sprinbootmongodemo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "students")
@Data
public class Students {

    @Id
    @Field(value = "_id")
    private Long studentId;

    @Indexed
    @Field(value = "studName")
    private String studentName;

    @Field(value = "branch")
    private String branch;

    @Field(value = "college")
    private String college;

}
