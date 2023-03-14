package com.example.servyTest1.controller;

import com.example.servyTest1.payload.requests.QuectionUpdateRequest;
import com.example.servyTest1.payload.requests.QuestionCreateRequest;
import com.example.servyTest1.models.Quection;
import com.example.servyTest1.services.QuectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/question")
public class QuectionControl {
    QuectionService quectionService;

    @Autowired
    public QuectionControl(QuectionService quectionService) {
        this.quectionService = quectionService;
    }

    @GetMapping("/")
     @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Quection>> getAllQuections() {
        try {
            return new ResponseEntity<>(quectionService.getallquections(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }
    @GetMapping("/serveyQuection/")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<Quection>> getAllQuectionsForServey() {
        try {
            return new ResponseEntity<>(quectionService.getallquections(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Quection> addQuection(@RequestBody @Validated QuestionCreateRequest questionCreateRequest) {
        try {
            return new ResponseEntity<>(quectionService.addQuestion(questionCreateRequest), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteQuection(@PathVariable("id") String id) {
        try {

            quectionService.deleteQuection(id);
            return new ResponseEntity<>("Delete success!", HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>("Delete unsuccess!", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteAll() {
        try {

            quectionService.deleteAllQuection();
            return new ResponseEntity<>("All Quections deleted!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Quection> updateQuection(@PathVariable("id") String id, @RequestBody @Validated QuectionUpdateRequest quectionUpdateRequest) {
        try {
            Quection quection = quectionService.updateQuection(id,quectionUpdateRequest);
            if(quection == null) {
                return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
            }
            else {
                return new ResponseEntity<>(quectionService.updateQuection(id, quectionUpdateRequest), HttpStatus.OK);

            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Quection> getQuestionById(@PathVariable("id") String id){
        try{
            Quection quection=quectionService.getStudentById(id);
            if(quection==null){
                return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
            }
            else {
                return new ResponseEntity<>(quectionService.getStudentById(id),HttpStatus.OK);
            }

        }
        catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
        }
    }


}
