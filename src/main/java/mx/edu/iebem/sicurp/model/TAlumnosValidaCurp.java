package mx.edu.iebem.sicurp.model;

public class TAlumnosValidaCurp {

    private int id;
    private String segmento;
    private String curp;
    private short validado;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSegmento() {
        return this.segmento;
    }

    public void setSegmento(String segmento) {
        this.segmento = segmento;
    }

    public String getCurp() {
        return this.curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public short getValidado() {
        return this.validado;
    }

    public void setValidado(short validado) {
        this.validado = validado;
    }

}
