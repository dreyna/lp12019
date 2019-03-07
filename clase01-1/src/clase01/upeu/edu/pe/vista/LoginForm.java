package clase01.upeu.edu.pe.vista;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clase01.upeu.edu.pe.dao.UsuarioDao;
import clase01.upeu.edu.pe.daoImp.UsuarioDaoImp;
import clase01.upeu.edu.pe.entity.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class LoginForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtusuario;
	private JPasswordField txtpassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm frame = new LoginForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginForm() {
		UsuarioDao dao = new UsuarioDaoImp();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Jonas");
		setLocationRelativeTo(null);
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setBounds(104, 36, 68, 14);
		contentPane.add(lblNewLabel);
		dao.create(new Usuario("dreyna","123"));
		txtusuario = new JTextField();
		txtusuario.setBounds(182, 36, 103, 20);
		contentPane.add(txtusuario);
		txtusuario.setColumns(10);
		
		JButton btnenviar = new JButton("Calcular");
		btnenviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String user = txtusuario.getText();
					String pass = new String(txtpassword.getPassword());
					if(user.equals("") || pass.equals("")) {
						JOptionPane.showMessageDialog(null,"Ingresar Datos");
					}else {
						if(dao.validar(new Usuario(user,pass))==1) {
							PrincipalForm pf = new PrincipalForm();
							pf.setVisible(true);
							dispose();
						}else {
							JOptionPane.showMessageDialog(null,"Datos Incorrectos...!");							
						}
					}
				   
				} catch (Exception e) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null,"Datas Incorrectos");
				}
				
			
			}
			
		});
		btnenviar.setBounds(182, 96, 103, 23);
		contentPane.add(btnenviar);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(104, 61, 68, 14);
		contentPane.add(lblPassword);
		
		txtpassword = new JPasswordField();
		txtpassword.setBounds(182, 61, 103, 20);
		contentPane.add(txtpassword);
	}
}
