package modelo;

public class Aluno {
	private Integer id;
	private String nomeAluno;
	private String cpfAluno; 
	private String telefone;
	private String email;
	private Escola escola;

	public Aluno() {
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nomeAluno;
	}

	public void setNome(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public String getCPF() {
		return cpfAluno;
	}

	public void setCPF(String cpfAluno) {
		this.cpfAluno = cpfAluno;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "aluno [id=" + id + ", nomeAluno=" + nomeAluno + ", cpfAluno=" + cpfAluno + ", telefone=" + telefone + ", email=" + email  
				+ "]";
	}

	public Escola getEscola() {
		return escola;
	}

	public void setEscola(Escola escola) {
		this.escola = escola;
	}
}

