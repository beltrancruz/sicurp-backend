package mx.edu.iebem.sicurp.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import mx.edu.iebem.sicurp.model.TAlumnosValidaCurp;

@Component
public class TAlumnosValidaCurpMapper implements RowMapper<TAlumnosValidaCurp> {
    
    @Override
    public TAlumnosValidaCurp mapRow(ResultSet rs, int count) throws SQLException {
        TAlumnosValidaCurp tAlumnosValidaCurp = new TAlumnosValidaCurp();
        tAlumnosValidaCurp.setId(rs.getInt("ID"));
        tAlumnosValidaCurp.setCurp(rs.getString("CURP"));
        tAlumnosValidaCurp.setSegmento(rs.getString("SEGMENTO"));
        tAlumnosValidaCurp.setValidado(rs.getShort("VALIDADO"));
        return tAlumnosValidaCurp;
    }
    
}
