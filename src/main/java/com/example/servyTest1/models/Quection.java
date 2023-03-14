package com.example.servyTest1.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Quection {
    @Id
    private String id;
    private int quectionNo;
    private String quectionName;
    private Date date;

    private List<Answer> answers = new ArrayList<Answer>();


}



