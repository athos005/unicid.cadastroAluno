package br.com.unicid.cadastroaluno.frames;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class frmNotasFaltas extends JFrame {

	private JPanel contentPane;
	public JTabbedPane tabbedPane;
	public JPanel pnlNotasFaltas;
	public JLabel lblNewLabel;
	public JTextField txtRgm;
	public JLabel lblNome;
	public JTextField txtNome;
	public JLabel lblDisciplina;
	public JTextField txtCurso;
	public JComboBox cmbDiscplina;
	public JLabel lblNome_1;
	public JLabel lblNome_2;
	public JComboBox cmbSemestre;
	public JSpinner spinner;
	public JLabel lblNome_3;
	public JTextField textField;
	public JLabel lblNota;
	public JPanel panel;
	public JPanel pnlBoletim;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmNotasFaltas frame = new frmNotasFaltas();
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
	public frmNotasFaltas() {
		setMinimumSize(new Dimension(450, 600));
		setMaximumSize(new Dimension(450, 600));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 535);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(42, 11, 350, 450);
		contentPane.add(tabbedPane);
		
		pnlNotasFaltas = new JPanel();
		pnlNotasFaltas.setBackground(Color.WHITE);
		tabbedPane.addTab("NOTAS E FALTAS", null, pnlNotasFaltas, null);
		pnlNotasFaltas.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(22, 10, 300, 385);
		pnlNotasFaltas.add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("RGM");
		lblNewLabel.setBounds(0, 0, 29, 17);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Malgun Gothic", Font.BOLD, 12));
		
		txtRgm = new JTextField();
		txtRgm.setBounds(0, 25, 150, 30);
		panel.add(txtRgm);
		txtRgm.setColumns(10);
		
		lblNome = new JLabel("NOME");
		lblNome.setBounds(0, 66, 37, 17);
		panel.add(lblNome);
		lblNome.setFont(new Font("Malgun Gothic", Font.BOLD, 12));
		
		txtNome = new JTextField();
		txtNome.setBounds(0, 91, 300, 30);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		lblDisciplina = new JLabel("CURSO");
		lblDisciplina.setBounds(0, 132, 41, 17);
		panel.add(lblDisciplina);
		lblDisciplina.setFont(new Font("Malgun Gothic", Font.BOLD, 12));
		
		txtCurso = new JTextField();
		txtCurso.setBounds(0, 157, 300, 30);
		panel.add(txtCurso);
		txtCurso.setColumns(10);
		
		cmbDiscplina = new JComboBox();
		cmbDiscplina.setBounds(0, 223, 300, 30);
		panel.add(cmbDiscplina);
		
		lblNome_1 = new JLabel("DICIPLINA");
		lblNome_1.setBounds(0, 198, 60, 17);
		panel.add(lblNome_1);
		lblNome_1.setFont(new Font("Malgun Gothic", Font.BOLD, 12));
		
		lblNome_2 = new JLabel("SEMESTRE");
		lblNome_2.setBounds(0, 264, 59, 17);
		panel.add(lblNome_2);
		lblNome_2.setFont(new Font("Malgun Gothic", Font.BOLD, 12));
		
		cmbSemestre = new JComboBox();
		cmbSemestre.setBounds(0, 289, 150, 30);
		panel.add(cmbSemestre);
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner.setBounds(80, 355, 70, 30);
		panel.add(spinner);
		
		lblNome_3 = new JLabel("FALTAS");
		lblNome_3.setBounds(80, 330, 42, 17);
		panel.add(lblNome_3);
		lblNome_3.setFont(new Font("Malgun Gothic", Font.BOLD, 12));
		
		textField = new JTextField();
		textField.setBounds(0, 355, 70, 30);
		panel.add(textField);
		textField.setColumns(10);
		
		lblNota = new JLabel("NOTA");
		lblNota.setBounds(0, 330, 34, 17);
		panel.add(lblNota);
		lblNota.setFont(new Font("Malgun Gothic", Font.BOLD, 12));
		
		pnlBoletim = new JPanel();
		pnlBoletim.setBackground(Color.WHITE);
		tabbedPane.addTab("BOLETIM", null, pnlBoletim, null);
	}
}
