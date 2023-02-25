package com.example.servyTest1.payload.responses;

import lombok.Data;

@Data
public class MessageRespones {

    private String message;

    public MessageRespones(String message) {
        this.message = message;
    }
}
