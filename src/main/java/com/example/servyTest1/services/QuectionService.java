package com.example.servyTest1.services;

import com.example.servyTest1.Repository.QuectionRepository;
import com.example.servyTest1.payload.requests.QuectionUpdateRequest;
import com.example.servyTest1.payload.requests.QuestionCreateRequest;
import com.example.servyTest1.models.Quection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class QuectionService {
    @Autowired
    private QuectionRepository quectionRepository;

    public List<Quection> getallquections() {
        return quectionRepository.findAll();
    }
    
    public Quection addQuestion(QuestionCreateRequest questionCreateRequest) {
        Quection quection = new Quection();
        quection.setQuectionNo(questionCreateRequest.questionNo());
        quection.setQuectionName(questionCreateRequest.quectionName());
        quection.setDate(new Date());
        quection.setAnswers(questionCreateRequest.answer());
        return quectionRepository.save(quection);
    }

    public void deleteQuection(String id){
        Optional<Quection> foundQection = quectionRepository.findById(id);
        if(foundQection.isPresent())
        {
            quectionRepository.deleteById(id);
        }


    }
    public void deleteAllQuection(){
        quectionRepository.deleteAll();
    }
    public Quection updateQuection(String id,QuectionUpdateRequest quectionUpdateRequest){
        Optional<Quection> foundQuection=quectionRepository.findById(id);

        if(foundQuection.isPresent()){
            Quection quection =foundQuection.get();
            quection.setQuectionName(quectionUpdateRequest.quectionName());
            quection.setAnswers(quectionUpdateRequest.answer());

            return quectionRepository.save(quection);
        }
        return null;

    }
    public Quection getStudentById(String id){
        Optional<Quection> foundQuection =quectionRepository.findById(id);

        if(foundQuection.isPresent()){
            Quection quection = foundQuection.get();
            return quection;
        }
        return null;
    }
    
}
