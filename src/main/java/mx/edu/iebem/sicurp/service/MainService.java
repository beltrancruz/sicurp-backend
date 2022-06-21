package mx.edu.iebem.sicurp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;

import mx.edu.iebem.sicurp.mapper.TAlumnosValidaCurpMapper;
import mx.edu.iebem.sicurp.model.TAlumnosValidaCurp;
import mx.edu.iebem.sicurp.model.Wscurp;
import mx.edu.iebem.sicurp.repository.MainRepository;
import mx.edu.iebem.sicurp.util.RestClient;

@Service
// @Transactional
public class MainService implements MainRepository {

    @Autowired
    private RestClient rest;

    @Autowired
    private JdbcTemplate jdbc;

    @Autowired
    private TAlumnosValidaCurpMapper tAlumnosValidaCurpMapper;

    @Override
    public Wscurp getDataByCurp(String curp) {
        return this.rest.getDataByCurp(curp);
    }

    @Override
    public void doCurpTAlumnos(int lote, int times) {
        for (int i = 0; i < times; i++) {
            final String SQL_UPDATE_CURP = "UPDATE TAlumnosValidaCurp SET VALIDADO = 1 WHERE ID = ?;";
            final String SQL_CURPS = "SELECT TOP(?) ID, CURP, SEGMENTO, VALIDADO FROM TAlumnosValidaCurp WHERE VALIDADO = 0;";
            final String SQL_SAVE_CURP = "INSERT INTO TCurpValidacionRenapo(" +
            "curpLocal, " +"curpRenapo, " +"nombreRenapo, " +"apellidoPaterno, " +
            "apellidoMaterno, " +"sexo, " +"fechaNacimiento, " +"Segmento, " +
            "claveEntidadNacimiento, " +"claveEntidadRegistro, " +"claveMunicipioRegistro, " +
            "documentoProbatorio, " +"estatusCurp, " +
            "anioRegistro) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
    
            List<TAlumnosValidaCurp> curps = this.jdbc.query(SQL_CURPS, tAlumnosValidaCurpMapper, lote);
            for(TAlumnosValidaCurp curp : curps) {
                Wscurp newcurp = this.rest.getDataByCurp(curp.getCurp());
    
                if (newcurp.getEstatusOperacion().equalsIgnoreCase("EXITOSO")) {
                    this.jdbc.update(SQL_SAVE_CURP,
                    curp.getCurp(),
                    newcurp.getCurp(),
                    newcurp.getNombre(),
                    newcurp.getApellidoPaterno(),
                    newcurp.getApellidoMaterno(),
                    newcurp.getSexo(),
                    newcurp.getFechaNacimiento(),
                    curp.getSegmento(),
                    newcurp.getClaveEntidadNacimiento(),
                    newcurp.getClaveEntidadRegistro(),
                    newcurp.getClaveMunicipioRegistro(),
                    newcurp.getDocumentoProbatorio(),
                    newcurp.getEstatusCurp(),
                    newcurp.getAnioRegistro());
    
                    this.jdbc.update(SQL_UPDATE_CURP, curp.getId());
                }
            }
        }
    }

}