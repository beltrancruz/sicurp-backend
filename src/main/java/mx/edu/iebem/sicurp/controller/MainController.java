package mx.edu.iebem.sicurp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.iebem.sicurp.model.Wscurp;
import mx.edu.iebem.sicurp.service.MainService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/iebem")
public class MainController {
    
    @Autowired
    private MainService mainService;

    @GetMapping("/curp/{curp}")
    public ResponseEntity<Wscurp> getDataByCurp(@PathVariable("curp") String curp) {
        return new ResponseEntity<>(mainService.getDataByCurp(curp), HttpStatus.OK);
    }

    @GetMapping("/curp/talumnos/{lote}/times/{times}")
    public ResponseEntity<Void> doCurpTAlumnos(@PathVariable("lote") int lote, @PathVariable("times") int times) {
        mainService.doCurpTAlumnos(lote, times);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
