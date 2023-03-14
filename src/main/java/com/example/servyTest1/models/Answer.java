package com.example.servyTest1.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Answer {
    @Id
    private String id;
    private int answerNo;
    private String answerText;
    private int weight;

}
