package com.example.servyTest1.payload.requests;
import com.example.servyTest1.models.Answer;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public record QuestionCreateRequest(
        @JsonProperty("quectionNo")
        int questionNo,
        @JsonProperty("quectionName")
        String quectionName,
        @JsonProperty("answer")
        List<Answer> answer
){}
