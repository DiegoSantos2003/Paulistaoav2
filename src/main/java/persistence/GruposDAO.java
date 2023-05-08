package persistence;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import model.Grupo;

public class GruposDAO implements IGruposDAO<Grupo>{

	private GenericDAO gDao;
	
	public GruposDAO(GenericDAO gDao) {
		this.gDao = gDao;
	}
	
	
	@Override
	public List<Grupo> sorteio() throws SQLException, ClassNotFoundException {
		List<Grupo> grupos = new ArrayList<>();
		Connection c = gDao.getConnection();
		
		String proc_sql = "{CALL p_sorteio}";
		
		String sql = " SELECT t.NomeTime, g.Grupo\r\n" + 
				                 " FROM Grupos g, Times t\r\n" + 
				                 " WHERE t.CodigoTime = g.CodigoTime";
		
		
		try {
		CallableStatement cs = c.prepareCall(proc_sql);
		cs.execute();
		
		
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			Grupo grupo = new Grupo();
			grupo.setNomeTime(rs.getString("NomeTime"));
			grupo.setGrupo(rs.getString("Grupo"));
			grupos.add(grupo);
		}
		
		rs.close();
		ps.close();
		cs.close();
		
		
		} catch(Exception e) {
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Grupo grupo = new Grupo();
				grupo.setNomeTime(rs.getString("NomeTime"));
				grupo.setGrupo(rs.getString("Grupo"));
				grupos.add(grupo);
			}
			
			rs.close();
			ps.close();
			
		}
		c.close();
		
		
		return grupos;
	}

	@Override
	public List<Grupo> vergrupoA() throws SQLException, ClassNotFoundException {
		List<Grupo> gruposA = new ArrayList<>();
		Connection c = gDao.getConnection();
		
		String sql = " SELECT t.NomeTime, g.Grupo\r\n" + 
                " FROM Grupos g, Times t\r\n" + 
                " WHERE t.CodigoTime = g.CodigoTime" +
                " AND Grupo = 'A'";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		
		while (rs.next()) {
			Grupo grupoA = new Grupo();
			grupoA.setNomeTime(rs.getString("NomeTime"));
			grupoA.setGrupo(rs.getString("Grupo"));
			gruposA.add(grupoA);
		}
		
		rs.close();
		ps.close();
		c.close();
		return gruposA;
	}

	@Override
	public List<Grupo> vergrupoB() throws SQLException, ClassNotFoundException {
		List<Grupo> gruposB = new ArrayList<>();
		Connection c = gDao.getConnection();
		
		String sql = " SELECT t.NomeTime, g.Grupo\r\n" + 
                " FROM Grupos g, Times t\r\n" + 
                " WHERE t.CodigoTime = g.CodigoTime" +
                " AND Grupo = 'B'";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Grupo grupoB = new Grupo();
			grupoB.setNomeTime(rs.getString("NomeTime"));
			grupoB.setGrupo(rs.getString("Grupo"));
			gruposB.add(grupoB);
		}
		
		rs.close();
		ps.close();
		c.close();
		return gruposB;
	}
	

	@Override
	public List<Grupo> vergrupoC() throws SQLException, ClassNotFoundException {
		List<Grupo> gruposC = new ArrayList<>();
		Connection c = gDao.getConnection();
		
		String sql = " SELECT t.NomeTime, g.Grupo\r\n" + 
                " FROM Grupos g, Times t\r\n" + 
                " WHERE t.CodigoTime = g.CodigoTime" +
                " AND Grupo = 'C'";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Grupo grupoC = new Grupo();
			grupoC.setNomeTime(rs.getString("NomeTime"));
			grupoC.setGrupo(rs.getString("Grupo"));
			gruposC.add(grupoC);
		}
		
		rs.close();
		ps.close();
		c.close();
		return gruposC;
	}
	@Override
	public List<Grupo> vergrupoD() throws SQLException, ClassNotFoundException {
		List<Grupo> gruposD = new ArrayList<>();
		Connection c = gDao.getConnection();
		
		String sql = " SELECT t.NomeTime, g.Grupo\r\n" + 
                " FROM Grupos g, Times t\r\n" + 
                " WHERE t.CodigoTime = g.CodigoTime" +
                " AND Grupo = 'D'";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Grupo grupoD = new Grupo();
			grupoD.setNomeTime(rs.getString("NomeTime"));
			grupoD.setGrupo(rs.getString("Grupo"));
			gruposD.add(grupoD);
		}
		
		rs.close();
		ps.close();
		c.close();
		return gruposD;
	}

}
