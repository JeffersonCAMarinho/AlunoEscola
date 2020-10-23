package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import modelo.Escola;


public class EscolaDao {

	public List<Escola> listaTodos() throws ClassNotFoundException, SQLException{
		List<Escola> lista = new LinkedList<Escola>();
		
		String sql = "SELECT * FROM escola";
		
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		
		ResultSet rs = comandoSql.executeQuery();
		
		while (rs.next()) {
			Escola t = new Escola();
			t.setIdEscola(rs.getInt("idEscola"));
			t.setNomeEscola(rs.getString("nomeEscola"));
			
			lista.add(t);
		}
		
		return lista;
	}
	
	public Escola listaPorId(int id) throws ClassNotFoundException, SQLException{
		String sql = "SELECT * FROM escola WHERE idEscola=?";
		
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setInt(1, id);
		
		ResultSet rs = comandoSql.executeQuery();
		
		Escola t = null;
		
		if (rs.next()) {
			t = new Escola();
			t.setIdEscola(rs.getInt("idEscola"));
			t.setNomeEscola(rs.getString("nomeEscola"));
			
		}
		
		return t;
	}
	
}
