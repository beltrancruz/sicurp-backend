package mx.edu.iebem.sicurp.repository;

import mx.edu.iebem.sicurp.model.Wscurp;

public interface MainRepository {

    public Wscurp getDataByCurp(String curp);

    public void doCurpTAlumnos(int lote, int times);
    
}
