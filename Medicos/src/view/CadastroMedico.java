package view;

import modelo.Medico;
import controller.MedicoController;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.MedicoController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;

public class CadastroMedico extends JFrame {

	private JPanel contentPane;
	private JTextField txtCrm;
	public JLabel lblNome;
	private JTextField txtNome;
	public JLabel lblCPF;
	private JTextField txtCPF;
	private JLabel lblEspecialidade;
	private JTextField txtTelefone;
	public JButton btnLimpar;
	public JButton btnEnviar;
	public JLabel lblCrm;
	public JLabel lblTelefone;

	
	public CadastroMedico() {
		/**
		 * Molde da pagina Cadastro Medicos
		 * @author Bee Alves
		 */
		
		setTitle("Cadastro Medicos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 283, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/**
		 * implementação do metodo ouvinte
		 */
		Ouvinte ouvinte=new Ouvinte();
		
		lblCrm = new JLabel("CRM");
		lblCrm.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCrm.setBounds(33, 11, 46, 14);
		contentPane.add(lblCrm);
		
		txtCrm = new JTextField();
		txtCrm.setBounds(33, 25, 186, 20);
		contentPane.add(txtCrm);
		txtCrm.setColumns(10);
		
		lblNome = new JLabel("NOME");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNome.setBounds(33, 67, 46, 14);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(33, 81, 186, 20);
		contentPane.add(txtNome);
		
		lblCPF = new JLabel("CPF");
		lblCPF.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCPF.setBounds(33, 121, 46, 14);
		contentPane.add(lblCPF);
		
		txtCPF = new JTextField();
		txtCPF.setColumns(10);
		txtCPF.setBounds(33, 135, 186, 20);
		contentPane.add(txtCPF);
		
		lblEspecialidade = new JLabel("ESPECIALIDADE");
		lblEspecialidade.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEspecialidade.setBounds(33, 174, 118, 14);
		contentPane.add(lblEspecialidade);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Cardiologista", "Cl\u00EDnico Geral", "Dermatologista", "Endocrinologista", " Neurologista"}));
		comboBox.setBounds(33, 188, 186, 20);
		contentPane.add(comboBox);
		
		lblTelefone = new JLabel("TELEFONE");
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTelefone.setBounds(33, 231, 118, 14);
		contentPane.add(lblTelefone);
		
		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(33, 245, 186, 20);
		contentPane.add(txtTelefone);
		
		btnLimpar = new JButton("LIMPAR");
		btnLimpar.setForeground(Color.RED);
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnLimpar.setBounds(33, 297, 89, 23);
		btnLimpar.addActionListener(ouvinte);
		contentPane.add(btnLimpar);
		
		btnEnviar = new JButton("ENVIAR");
		btnEnviar.setForeground(Color.BLUE);
		btnEnviar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnEnviar.setBounds(130, 298, 89, 23);
		btnEnviar.addActionListener(ouvinte);
		contentPane.add(btnEnviar);
		
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
	/**
	 * criando o método Limpar
	 * @author Bee Alves
	 */
	public void limpar() {
		txtCPF.setText("");
		txtCrm.setText("");
		txtNome.setText("");
		txtTelefone.setText("");
		
	}
	public class Ouvinte implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			/**
			 * criação de ação no botão enviar
			 */
			if((e.getSource()==btnEnviar)) {
				/**
				 * transformar JText em legiveis
				 */
				String crm= txtCrm.getText();
				String nome=txtNome.getText();
				String cpf=txtCPF.getText();
				String telefone=txtTelefone.getText();
				
				if(crm.equals("")||nome.equals("")||cpf.equals("")||telefone.equals("")) {
				 	JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos", "ATENÇÃO", 3);
			 	}else {
					MedicoController mcontrol = new MedicoController();
					if(mcontrol.cadastrar(Integer.parseInt(crm),nome
							, Integer.parseInt(cpf), Integer.parseInt(telefone))==1) {
					JOptionPane.showMessageDialog(null, "CADASTRO DE PRODUTO FEITO COM SUCESSO", "SUCESSO",2);
					limpar();
					}
					else {
						JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar", "ERRO", 2);
					}
			}
			
		}
		
	}
}
	
}
