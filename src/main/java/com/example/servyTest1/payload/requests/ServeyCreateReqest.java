package com.example.servyTest1.payload.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

public record ServeyCreateReqest(
        @JsonProperty("userId")
        String userId,
        @JsonProperty("answers")
        List<Map<String, Integer>> answers

) {
}
