package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Time;

public class TimesDAO implements ITimeDAO<Time>{

	private GenericDAO gDao;
	
	public TimesDAO(GenericDAO gDao) {
		this.gDao = gDao;
	}
	@Override
	public List<Time> listar() throws SQLException, ClassNotFoundException {
	    List<Time> times = new ArrayList<>();
	    
	    Connection c = gDao.getConnection();
	    String sql = "SELECT CodigoTime, NomeTime, Cidade, Estadio, MaterialEsportivo FROM Times ORDER BY NomeTime";
	    PreparedStatement ps = c.prepareStatement(sql);
	    ResultSet rs = ps.executeQuery();
	    
	    while(rs.next()) {
	    	Time time = new Time();
	    	time.setCodigoTime(rs.getInt("CodigoTime"));
	    	time.setNomeTime(rs.getString("NomeTime"));
	    	time.setCidade(rs.getString("Cidade"));
	    	time.setEstadio(rs.getString("Estadio"));
	    	times.add(time);
	    }
	    rs.close();
	    ps.close();
	    c.close();
		return times;
	}

}
