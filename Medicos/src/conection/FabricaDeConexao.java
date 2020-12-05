package conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

public class FabricaDeConexao {
		private final static String url = "jdbc:mysql://localhost:1433;databaseName=medicogui";
		private final static String username="root";
		private final static String password="";

		public static Connection getConnection() {
			try {
				return DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro ao conectar com o Bancdo de Dados"+e.getMessage(), "Erro", 2 );
			}
			return null;
		}
		public static void closeConnection(Connection con) {
			if(con !=null) {
			try {
				con.close();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro ao conectar com o Bancdo de Dados"+e.getMessage(), "Erro", 2 );
			}
			
			}
		}
		
		public static void closeConnection(Connection con, PreparedStatement stmt) {
		closeConnection(con);
		if (stmt !=null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro ao finalizar a conexão", "ERRO", 3);
				e.printStackTrace();
			}
		}
		}
}
