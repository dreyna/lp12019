package clase01.upeu.edu.pe.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import clase01.upeu.edu.pe.dao.UsuarioDao;
import clase01.upeu.edu.pe.daoImp.UsuarioDaoImp;
import clase01.upeu.edu.pe.entity.Usuario;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UsuarioForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtuser;
	private JTextField txtclave;
    private UsuarioDao udo = new UsuarioDaoImp();
    private JTable tbdatos;
    private DefaultTableModel model;
    private int fila;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UsuarioForm frame = new UsuarioForm();
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
	public UsuarioForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 158);
		panel.setBorder(new TitledBorder(null, "Datos Usuario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setBounds(20, 23, 68, 14);
		panel.add(lblNewLabel);
		
		txtuser = new JTextField();
		txtuser.setBounds(104, 20, 300, 20);
		panel.add(txtuser);
		txtuser.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(20, 51, 68, 14);
		panel.add(lblPassword);
		
		txtclave = new JTextField();
		txtclave.setColumns(10);
		txtclave.setBounds(104, 48, 300, 20);
		panel.add(txtclave);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.setBounds(10, 76, 89, 70);
		panel.add(btnSearch);
		
		JButton btnCreate = new JButton("CREATE");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = txtuser.getText();
				String clave = txtclave.getText();
				udo.create(new Usuario(user,clave));
				borrar();
				limpiar();
				listar();
			}
		});
		btnCreate.setBounds(114, 76, 89, 70);
		panel.add(btnCreate);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setBounds(214, 76, 89, 70);
		panel.add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fila>=0){
					
				}else{
					JOptionPane.showMessageDialog(null,"Seleccionar Fila");
				}
			}
		});
		btnDelete.setBounds(315, 76, 89, 70);
		panel.add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 180, 382, 209);
		contentPane.add(scrollPane);
		
		tbdatos = new JTable();
		tbdatos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				fila = tbdatos.getSelectedRow();
				txtuser.setText(tbdatos.getValueAt(fila, 1).toString());
				txtclave.setText(tbdatos.getValueAt(fila, 2).toString());
				
			}
		});
		tbdatos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"N\u00B0", "Usuario", "password"
			}
		));
		tbdatos.getColumnModel().getColumn(0).setPreferredWidth(65);
		tbdatos.getColumnModel().getColumn(0).setMinWidth(30);
		tbdatos.getColumnModel().getColumn(1).setMinWidth(150);
		tbdatos.getColumnModel().getColumn(2).setPreferredWidth(15);
		tbdatos.getColumnModel().getColumn(2).setMinWidth(150);
		scrollPane.setViewportView(tbdatos);
		setTitle("Principal");
		setLocationRelativeTo(null);
		
	}
	public void listar(){
		List<Usuario> lts = new ArrayList<>();
		model = (DefaultTableModel) tbdatos.getModel();
		lts = udo.readAll();
		System.out.println(lts.size());
		Object[] datos = new Object[3];
		for(int i=0;i<lts.size();i++){
			datos[0]= i+1;
			datos[1]= lts.get(i).getNomuser();
			datos[2]=lts.get(i).getClave();
			model.addRow(datos);
		}
		tbdatos.setModel(model);
	}
	public void limpiar(){
		for (int i = 0; i < tbdatos.getRowCount(); i++) {
			model.removeRow(i);
			i-=1;
	}
	}
    public void borrar(){
    	txtuser.setText(null);
    	txtclave.setText(null);
    	txtuser.requestFocus();
    }
	
}
