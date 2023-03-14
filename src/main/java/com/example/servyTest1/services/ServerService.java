package com.example.servyTest1.services;

import com.example.servyTest1.Repository.ServeyRepository;
import com.example.servyTest1.payload.requests.ServeyCreateReqest;
import com.example.servyTest1.models.EResult;
import com.example.servyTest1.models.Servey;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Slf4j
@Service
public class ServerService {
@Autowired
private ServeyRepository serverREpository;



public List<Servey> getAllServeyDetails(){
    return serverREpository.findAll();
}


public Servey getServeyByServeyId(String id){
    Optional<Servey> foundServey =serverREpository.findById(id);
    if(foundServey.isPresent()){
        Servey servey=foundServey.get();
        return servey;
    }
    return null;
}

public Servey createServey(ServeyCreateReqest serveyCreateReqest){
    log.info("ServeyService");
    Servey servey=new Servey();
    servey.setUserid(serveyCreateReqest.userId());
    servey.setUserAnswerdQuection(serveyCreateReqest.answers());
    servey.setDate(new Date());
    servey.setUserResult(calculateResult(servey));
    serverREpository.save(servey);
    return servey;
}

public List<Servey> getServeyByUserId(String id){
    List<Servey> foundServeys =serverREpository.findByUserid(id);
    return foundServeys;
}


public EResult calculateResult(Servey servey){
    List<Integer>listOfAnswer =new ArrayList<>();
    // iterate through each Map in the userAnswerdQuection list
    for (Map<String, Integer> map : servey.getUserAnswerdQuection()) {
        // iterate through each entry in the Map

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            // retrieve the Integer value associated with the current key
            int value = entry.getValue();
            // do something with the value (e.g. print it)
            listOfAnswer.add(value);

        }
}
    //Reduce 1from each element to get the weight of it
    for (Integer answerUpdated :listOfAnswer )
    {
        answerUpdated=answerUpdated-1;
    }
    //geting sum of arrayList element(sum of weight)
    int sum = listOfAnswer.stream()
            .reduce(0, (a, b) -> a + b);
    int reslutFromNumber=sum*100/40;
    
    EResult resultFromString;
    if(reslutFromNumber>75){
        resultFromString=EResult.NORMAL;
    } else if (reslutFromNumber>50) {
        resultFromString=EResult.LOW_STRESS;
    } else if (reslutFromNumber>25) {
        resultFromString=EResult.MEDIUM_STRESS;
    }  else if (reslutFromNumber>0) {
        resultFromString=EResult.HIGH_STRESS;
    }else {
        resultFromString=EResult.CALCULATION_ERROR;
    }
  return resultFromString;
}


}
