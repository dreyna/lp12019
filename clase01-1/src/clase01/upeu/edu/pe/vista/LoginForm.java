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
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class LoginForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtusuario;
	private JPasswordField txtpassword;
	private UsuarioDao dao = new UsuarioDaoImp();
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginForm.class.getResource("/imagenes/Synchronize_16x16.png")));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 292, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Jonas");
		setLocationRelativeTo(null);	    
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 256, 431);
		contentPane.add(panel);
		panel.setLayout(null);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setIcon(new ImageIcon(LoginForm.class.getResource("/imagenes/User_24x24.png")));
		lblNewLabel.setBounds(15, 277, 24, 24);
		panel.add(lblNewLabel);
		txtusuario = new JTextField();
		txtusuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_ENTER){
					txtpassword.requestFocus();
				}
			}
		});
		txtusuario.setHorizontalAlignment(SwingConstants.CENTER);
		txtusuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtusuario.setBounds(49, 277, 180, 40);
		panel.add(txtusuario);
		txtusuario.setColumns(10);
		JButton btnenviar = new JButton("Login");
		btnenviar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				registrar();
			}
		});
		txtpassword = new JPasswordField();
		txtpassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_ENTER){
					btnenviar.requestFocus();
					}
				}
			
		});
		txtpassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtpassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtpassword.setBounds(49, 326, 180, 40);
		panel.add(txtpassword);
		
		JLabel lblPassword = new JLabel("");
		lblPassword.setIcon(new ImageIcon(LoginForm.class.getResource("/imagenes/Key_24x24.png")));
		lblPassword.setBounds(10, 326, 29, 33);
		panel.add(lblPassword);		
		
		btnenviar.setHorizontalTextPosition(SwingConstants.LEFT);
		btnenviar.setIcon(new ImageIcon(LoginForm.class.getResource("/imagenes/Right3Green.png")));
		btnenviar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnenviar.setHorizontalAlignment(SwingConstants.RIGHT);
		btnenviar.setBounds(49, 374, 180, 46);
		panel.add(btnenviar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(LoginForm.class.getResource("/imagenes/user.png")));
		label.setBounds(0, 0, 240, 279);
		panel.add(label);		
		btnenviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registrar();
			}
			
		});
		
	}
	public void registrar() {
		try {
			String user = txtusuario.getText();
			String pass = new String(txtpassword.getPassword());
			if(user.equals("") || pass.equals("")) {
				JOptionPane.showMessageDialog(null,"Ingresar Datos");
			}else {
				if(dao.validar(new Usuario(user,pass))==1) {
					PrincipalForm pf = new PrincipalForm();
					pf.setVisible(true);
					setVisible(false);
					System.out.println();
				}else {
					JOptionPane.showMessageDialog(null,"Datos Incorrectos...!");							
				}
			}
		   
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null,"Datas Incorrectos");
		}
	}
}
