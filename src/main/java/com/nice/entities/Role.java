package com.nice.entities;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="ROLE")
public class Role {

    @Id
    private Long id=Long.valueOf(1234);
    String name;

    Role() {}

    public Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}