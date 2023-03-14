package com.example.servyTest1.controller;

import com.example.servyTest1.payload.requests.ServeyCreateReqest;
import com.example.servyTest1.models.Servey;
import com.example.servyTest1.services.ServerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/api/servey")
public class ServeyControl {

    private final ServerService serverService;
    @Autowired
    public ServeyControl(ServerService serverService) {
        this.serverService = serverService;
    }


    @GetMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Servey>>allServeyDetails(){
    try{
        return new ResponseEntity<>(serverService.getAllServeyDetails(), HttpStatus.OK);
    }
    catch (Exception e){
        return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<Servey>getServeyByServeyId(@PathVariable("id") String id){
        try{
            if(serverService.getServeyByServeyId(id)==null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(serverService.getServeyByServeyId(id),HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
        }
    }


    @PostMapping("/")
   @PreAuthorize("hasRole('USER') ")
    public ResponseEntity<Servey>createServey(@RequestBody @Validated ServeyCreateReqest serveyCreateReqest){
        log.info("ServeyControler");
    try {
        return new ResponseEntity<>(serverService.createServey(serveyCreateReqest),HttpStatus.OK);
    }catch (Exception e){
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
    }


    @GetMapping("/user/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<Servey>>getServeyByUserId(@PathVariable ("id") String id){
        try{
            return new ResponseEntity<>(serverService.getServeyByUserId(id), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }


}




