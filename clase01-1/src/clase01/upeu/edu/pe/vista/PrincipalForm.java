package clase01.upeu.edu.pe.vista;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;

public class PrincipalForm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalForm frame = new PrincipalForm();
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
	public PrincipalForm() {
		setFont(new Font("Dialog", Font.PLAIN, 11));
		setTitle("SysLogin");
		setIconImage(Toolkit.getDefaultToolkit().getImage(PrincipalForm.class.getResource("/imagenes/Synchronize_16x16.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 774, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorder(new LineBorder(new Color(0, 0, 0)));
		menuBar.setBackground(new Color(240, 240, 240));
		menuBar.setBounds(0, 0, 1920, 56);
		contentPane.add(menuBar);
		setExtendedState(MAXIMIZED_BOTH);
		JMenu mnFile = new JMenu("");
		mnFile.setBorder(new LineBorder(Color.GRAY, 1, true));
		mnFile.setIcon(new ImageIcon(PrincipalForm.class.getResource("/imagenes/Folder_32x32.png")));
		menuBar.add(mnFile);
		
		JMenuItem mntmSalir = new JMenuItem("SALIR");
		mntmSalir.setIcon(new ImageIcon(PrincipalForm.class.getResource("/imagenes/Log Out_24x24.png")));
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnFile.add(mntmSalir);
		
		JMenu mnUsuario = new JMenu("");
		mnUsuario.setBorder(new LineBorder(Color.GRAY));
		mnUsuario.setIcon(new ImageIcon(PrincipalForm.class.getResource("/imagenes/User_32x32.png")));
		menuBar.add(mnUsuario);
		
		JMenuItem mntmCrud = new JMenuItem("CRUD");
		mntmCrud.setIcon(new ImageIcon(PrincipalForm.class.getResource("/imagenes/User_24x24.png")));
		mntmCrud.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioForm uf = new UsuarioForm();
				uf.setVisible(true);
			}
		});
		mnUsuario.add(mntmCrud);
	}
}
