package controller;

import dao.MedicoDao;
import modelo.Medico;

public class MedicoController {
	
	public int cadastrar(int crm,String nome, int cpf, int telefone) {
		
		Medico m = new Medico(crm, nome, cpf, telefone);
		MedicoDao mDao = new MedicoDao();
		return (mDao.create(m));
	}
	
	
}