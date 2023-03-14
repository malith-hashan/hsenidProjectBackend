package com.example.servyTest1.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Data
@Document(collection = "users")
public class User {

    @Id
    private String id;

    @NotBlank
    @Size(max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(max = 120)
    private String password;

    @DBRef
    private Set<Role> roles = new HashSet<>();

    private int userId1;


    public User() {
    }

    public User(String username, String email, String password, Set<Role> roles) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;

        try{
            int userId = Integer.parseInt(this.id);
            this.userId1=userId;
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }





    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;

        try{
            int userId = Integer.parseInt(this.id);
            this.userId1=userId;
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }
    }


}
