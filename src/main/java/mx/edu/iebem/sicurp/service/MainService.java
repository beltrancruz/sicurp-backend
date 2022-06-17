package mx.edu.iebem.sicurp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.iebem.sicurp.model.Wscurp;
import mx.edu.iebem.sicurp.util.RestClient;

@Service
public class MainService {

    @Autowired
    private RestClient rest;

    public Wscurp getDataByCurp(String curp) {
        return rest.getDataByCurp(curp);
    }
    
}