package dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

import conection.FabricaDeConexao;
import modelo.Medico;

public class MedicoDao {
	
	public int create(Medico m) {
		Connection con = null;
		java.sql.PreparedStatement stmt = null;
		String sqlInsert = "INSERT INTO medicogui(crm,nome,cpf, telefone) "
				+ "values (?,?,?,?)";
		
		con = FabricaDeConexao.getConnection();
		try {
			stmt=con.prepareStatement(sqlInsert);
			stmt.setInt(1, m.getCrm());
			stmt.setString(2, m.getNome());
			stmt.setInt(3, m.getCpf());
			stmt.setInt(4, m.getTelefone());
			stmt.execute();
			return 1;
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro na inserção do medico", "ERRO", 4);
			return 0;
		}
		finally{
			FabricaDeConexao.closeConnection(con);
		}
	}
}
