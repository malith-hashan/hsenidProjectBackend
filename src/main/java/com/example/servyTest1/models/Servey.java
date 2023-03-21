package com.example.servyTest1.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Servey {
    @Id
    private String id;
    private String userid;
    private List<Map<String, Integer>> userAnswerdQuection = new ArrayList<>();
    private EResult userResult;
    private Date date;


}
