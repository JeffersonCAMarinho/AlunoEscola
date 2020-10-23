package controller;

import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dao.AlunoDao;
import dao.EscolaDao;
import modelo.Aluno;
import modelo.Escola;

@ManagedBean
@ViewScoped
public class AlunoController {
	
	private Aluno aluno = new Aluno();
	private Integer idEscola;
	
	public void salvar() {
		
	System.out.println("Salvando..." + aluno);
		
		AlunoDao dao = new AlunoDao();
		
		//dao.adiciona(aluno);
		try {
			
			Escola t = new EscolaDao().listaPorId(idEscola);
			aluno.setEscola(t);
			
			
			if (aluno.getId() == null) {
			dao.adiciona(aluno);
			}
			else {
			dao.atualiza(aluno);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		aluno = new Aluno();
		idEscola = null;
	}
	
	public void cancelar() {
		aluno = new Aluno();
		idEscola = null;
	}
	
	public List<Aluno> getTodosAlunos(){
		List<Aluno> lista = null;
		try {
			lista = new AlunoDao().listaTodos();	
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;	
	}
	
	
	public Aluno getAluno() {
		return aluno;
	}
	
	public void remover(Aluno p) {
		try {	
			new AlunoDao().remove(p.getId());			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}	
		
	}
	
	public void carregar(Aluno p) {
		aluno = p;
		
		idEscola = p.getEscola().getIdEscola();
	}
	
	public List<Escola> getTodasEscolas(){
		
		List<Escola> lista = null;
		try {
		lista = new EscolaDao().listaTodos();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {	
			e.printStackTrace();
		}
		
		
		
		return lista;
	}
//	public void setAluno(Aluno aluno) {
//		this.aluno = aluno;
//	}

	public Integer getIdEscola() {
		return idEscola;
	}

	public void setIdEscola(Integer idEscola) {
		this.idEscola = idEscola;
	}
}
