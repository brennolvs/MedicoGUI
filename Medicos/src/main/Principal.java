package main;

import java.sql.Connection;

import javax.swing.JOptionPane;

import conection.FabricaDeConexao;
import view.CadastroMedico;

public class Principal {

	public static void main(String[] args) {
		Connection con= null;
		con = FabricaDeConexao.getConnection();
		if(con!=null) {
			JOptionPane.showMessageDialog(null, "Cadastrado com sucesso", "Sucesso", 2);
		}

	}

}
