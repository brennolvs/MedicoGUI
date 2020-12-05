package modelo;

public class Medico {
	private int crm;
	private String nome;
	private int cpf;
	private int telefone; 
	
	public Medico() {
	}

	public Medico(int crm, String nome, int cpf, int telefone) {
		super();
		this.crm = crm;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
	}

	public int getCrm() {
		return crm;
	}

	public void setCrm(int crm) {
		this.crm = crm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	
	
}
