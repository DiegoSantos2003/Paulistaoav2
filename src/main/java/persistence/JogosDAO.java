package persistence;


import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Jogo;

public class JogosDAO implements IJogosDAO<Jogo>{

	private GenericDAO gDao;
	
	public JogosDAO (GenericDAO gDao) {
		this.gDao = gDao;
	}
	@Override
	public List<Jogo> listarJogos() throws SQLException, ClassNotFoundException {
		List<Jogo> jogos = new ArrayList<>();
		
		Connection c = gDao.getConnection();
		
		String proc_sql = "{CALL p_gerar_rodadas}";
		
		String sql = "SELECT ta.NomeTime AS NomeTimeA, j.GolsTimeA, tb.NomeTime AS NomeTimeB, j.GolsTimeB, j.Data \r\n"
				+ "FROM Jogos j, Times ta, Times tb\r\n"
				+ "WHERE ta.CodigoTime = j.CodigoTimeA AND tb.CodigoTime = j.CodigoTimeB \r\n"
				+ "";
		
		CallableStatement cs = c.prepareCall(proc_sql);
		cs.execute();
		
		PreparedStatement ps = c.prepareStatement(sql);	
		
		ResultSet rs = ps.executeQuery();		
		while(rs.next()) {
			Jogo j = new Jogo();
			j.setNomeTimeA(rs.getString("NomeTimeA"));
			j.setGolsTimeA(rs.getInt("GolsTimeA"));			
			j.setNomeTimeB(rs.getString("NomeTimeB"));
			j.setGolsTimeB(rs.getInt("GolsTimeB"));
			j.setData(LocalDate.parse(rs.getString("Data"))); 
			
			jogos.add(j);
		}
		rs.close();
		ps.close();	
		cs.close();
		c.close();
		return jogos;
	}
	
	public List<Jogo> buscarJogos(String data_string) throws SQLException, ClassNotFoundException {
		List<Jogo> tabelasjogos = new ArrayList<>();
		
		Connection c = gDao.getConnection();
		String sql = "SELECT ta.NomeTime AS NomeTimeA, j.GolsTimeA, tb.NomeTime AS NomeTimeB, j.GolsTimeB, j.Data \r\n"
				+ "FROM Jogos j, Times ta, Times tb\r\n"
				+ "WHERE ta.CodigoTime = j.CodigoTimeA AND tb.CodigoTime = j.CodigoTimeB \r\n"
				+ "AND Data = ?";
	
		PreparedStatement ps = c.prepareStatement(sql);	
		ps.setString(1, data_string);

		
		ResultSet rs = ps.executeQuery();		
		while(rs.next()) {
			Jogo tabjogo = new Jogo();
			tabjogo.setNomeTimeA(rs.getString("NomeTimeA"));
			tabjogo.setGolsTimeA(rs.getInt("GolsTimeA"));			
			tabjogo.setNomeTimeB(rs.getString("NomeTimeB"));
			tabjogo.setGolsTimeB(rs.getInt("GolsTimeB"));
			tabjogo.setData(LocalDate.parse(rs.getString("Data"))); 
			
			tabelasjogos.add(tabjogo);
		}
		rs.close();
		ps.close();		
		c.close();
		return tabelasjogos;
	}

}
