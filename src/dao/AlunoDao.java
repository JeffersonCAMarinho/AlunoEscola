package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import modelo.Aluno;
import modelo.Escola;

public class AlunoDao {
	
	public void adiciona(Aluno p) throws ClassNotFoundException, SQLException {
		String sql = 
			"INSERT INTO aluno ( nomeAluno, cpfAluno, telefone, email, idNomeEscola )" +
		"VALUES (?, ?, ?, ?, ?)";
		
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setString(1,  p.getNome());
		comandoSql.setString(2, p.getCPF());
		comandoSql.setString(3, p.getTelefone());
		comandoSql.setString(4, p.getEmail());
		comandoSql.setInt(5, p.getEscola().getIdEscola());
		
		comandoSql.execute();
		Conexao.getInstance().commit();
	}

	public void atualiza(Aluno p) throws ClassNotFoundException, SQLException {
		String sql = 
			"UPDATE aluno SET nomeAluno=?, cpfAluno=?, telefone=?, "
			+ "email=?, idNomeEscola=? WHERE idAluno=?";
		
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setString(1,  p.getNome());
		comandoSql.setString(2, p.getCPF());
		comandoSql.setString(3, p.getTelefone());
		comandoSql.setString(4, p.getEmail());
		comandoSql.setInt(5, p.getEscola().getIdEscola());
		comandoSql.setInt(6, p.getId());
		
		comandoSql.execute();
		Conexao.getInstance().commit();
	}
	
	public void remove(int id) throws ClassNotFoundException, SQLException {
		String sql = 
			"DELETE FROM aluno WHERE idAluno=?";
		
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setInt(1, id);
		
		comandoSql.execute();
		Conexao.getInstance().commit();
	}
	
	public List<Aluno> listaTodos() throws ClassNotFoundException, SQLException{
		List<Aluno> lista = new LinkedList<Aluno>();
		
		String sql = "SELECT * FROM aluno inner join escola on " +
					"aluno.idNomeEscola = escola.idEscola";
		
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		
		ResultSet rs = comandoSql.executeQuery();
		
		while (rs.next()) {
			Aluno p = new Aluno();
			p.setId(rs.getInt("idAluno"));
			p.setNome(rs.getString("nomeAluno"));
			p.setCPF(rs.getString("cpfAluno"));
			p.setTelefone(rs.getString("telefone"));
			p.setEmail(rs.getString("email"));
			
			Escola t = new Escola();
			t.setIdEscola(rs.getInt("idEscola"));
			t.setNomeEscola(rs.getString("nomeEscola"));
			
			p.setEscola(t);
			
			lista.add(p);
		}
		
		return lista;
	}
	
	public Aluno listaPorId(int id) throws ClassNotFoundException, SQLException{
		String sql = "SELECT * FROM aluno WHERE idAluno=?";
		
		PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
		comandoSql.setInt(1, id);
		
		ResultSet rs = comandoSql.executeQuery();
		
		Aluno p = null;
		
		if (rs.next()) {
			p = new Aluno();
			p.setId(rs.getInt("idAluno"));
			p.setNome(rs.getString("nomeAluno"));
			p.setCPF(rs.getString("cpfAluno"));
			p.setTelefone(rs.getString("telefone"));
			p.setEmail(rs.getString("email"));
		}
		
		return p;
	}
}
