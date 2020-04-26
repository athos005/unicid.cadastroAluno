package br.com.unicid.cadastroaluno.frames;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import java.awt.Color;
import javax.swing.JTabbedPane;
import java.awt.SystemColor;
import java.text.ParseException;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;

public class frmAluno extends JFrame {

	private JPanel contentPane;
	public JTabbedPane tabbedPane;
	public JPanel pnlDadosPessoais;
	public JTextField txtRgm;
	public JLabel lblNewLabel;
	public JTextField textField;
	public JLabel lblNome;
	public JLabel lblCpf;
	public JFormattedTextField txtCpf;
	public JFormattedTextField txtDataNascimento;
	public JLabel lblDataNascimento;
	private final ButtonGroup Sexo = new ButtonGroup();
	public JLabel lblSexo;
	public JToggleButton btnMasculino;
	public JToggleButton btnFeminino;
	public JPanel panel;
	public JTextField txtEmail;
	public JLabel lblEmail;
	public JFormattedTextField txtCelular;
	public JLabel lblCelular;
	public JLabel lblTelefone;
	public JFormattedTextField txtTelefone;
	public JPanel panel_1;
	public JPanel pnlEndereco;
	public JLabel lblCep;
	public JFormattedTextField txtCep;
	public JTextField txtEndereco;
	public JLabel lblNome_1;
	public JTextField textField_1;
	public JLabel lblNome_2;
	public JLabel lblNome_3;
	public JTextField txtComplemento;
	public JLabel lblNome_4;
	public JTextField txtCidade;
	public JComboBox cmbEstado;
	public JLabel lblNome_5;
	public JPanel panel_2;
	public JPanel pnlCurso;
	public JLabel lblNome_6;
	public JComboBox cmbCurso;
	public JComboBox cmbUnidade;
	public JLabel lblNome_7;
	public JRadioButton rdbMatutino;
	private final ButtonGroup Periodo = new ButtonGroup();
	public JRadioButton rdbVespertino;
	public JRadioButton rdbNoturno;
	public JLabel lblNome_8;
	public JPanel panel_4;
	public JLabel lblNome_9;
	public JTextField txtBairro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmAluno frame = new frmAluno();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public frmAluno() throws ParseException {
		setMinimumSize(new Dimension(450, 600));
		setResizable(false);
		setTitle("Aluno");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 268, 600);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(43, 11, 350, 450);
		tabbedPane.setBorder(null);
		tabbedPane.setBackground(Color.WHITE);
		contentPane.add(tabbedPane);
		
		pnlDadosPessoais = new JPanel();
		pnlDadosPessoais.setBackground(Color.WHITE);
		tabbedPane.addTab("DADOS PESSOAIS", null, pnlDadosPessoais, null);
		pnlDadosPessoais.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(22, 11, 300, 259);
		pnlDadosPessoais.add(panel);
		panel.setLayout(null);
		
		txtRgm = new JTextField();
		txtRgm.setBounds(0, 25, 150, 30);
		panel.add(txtRgm);
		txtRgm.setColumns(10);
		
		lblNewLabel = new JLabel("RGM");
		lblNewLabel.setBounds(0, 0, 29, 17);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Malgun Gothic", Font.BOLD, 12));
		
		textField = new JTextField();
		textField.setBounds(0, 160, 300, 30);
		panel.add(textField);
		textField.setColumns(10);
		
		lblNome = new JLabel("NOME");
		lblNome.setBounds(0, 135, 37, 17);
		panel.add(lblNome);
		lblNome.setFont(new Font("Malgun Gothic", Font.BOLD, 12));
		
		lblCpf = new JLabel("CPF");
		lblCpf.setBounds(0, 66, 21, 17);
		panel.add(lblCpf);
		lblCpf.setFont(new Font("Malgun Gothic", Font.BOLD, 12));
		
		txtCpf = new JFormattedTextField();
		txtCpf.setBounds(0, 94, 150, 30);
		panel.add(txtCpf);
		txtCpf.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("###.###.###-##")));
		
		lblDataNascimento = new JLabel("DATA NASCIMENTO");
		lblDataNascimento.setBounds(0, 201, 117, 17);
		panel.add(lblDataNascimento);
		lblDataNascimento.setFont(new Font("Malgun Gothic", Font.BOLD, 12));
		
		txtDataNascimento = new JFormattedTextField();
		txtDataNascimento.setBounds(0, 229, 125, 30);
		panel.add(txtDataNascimento);
		txtDataNascimento.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));
		
		lblSexo = new JLabel("G\u00CANERO");
		lblSexo.setBounds(135, 201, 48, 17);
		panel.add(lblSexo);
		lblSexo.setFont(new Font("Malgun Gothic", Font.BOLD, 12));
		
		btnMasculino = new JToggleButton("MASCULINO");
		btnMasculino.setBounds(135, 229, 80, 30);
		panel.add(btnMasculino);
		btnMasculino.setBackground(Color.LIGHT_GRAY);
		btnMasculino.setBorder(null);
		btnMasculino.setSelected(true);
		Sexo.add(btnMasculino);
		
		btnFeminino = new JToggleButton("FEMININO");
		btnFeminino.setBounds(220, 229, 80, 30);
		panel.add(btnFeminino);
		btnFeminino.setBackground(Color.LIGHT_GRAY);
		btnFeminino.setBorder(null);
		Sexo.add(btnFeminino);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(22, 281, 300, 124);
		pnlDadosPessoais.add(panel_1);
		panel_1.setLayout(null);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(0, 25, 300, 30);
		panel_1.add(txtEmail);
		txtEmail.setColumns(10);
		
		lblEmail = new JLabel("E-MAIL");
		lblEmail.setBounds(0, 0, 41, 17);
		panel_1.add(lblEmail);
		lblEmail.setFont(new Font("Malgun Gothic", Font.BOLD, 12));
		
		txtCelular = new JFormattedTextField();
		txtCelular.setBounds(0, 94, 130, 30);
		panel_1.add(txtCelular);
		txtCelular.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("(##) #####-####")));
		
		lblCelular = new JLabel("CELULAR");
		lblCelular.setBounds(0, 66, 62, 17);
		panel_1.add(lblCelular);
		lblCelular.setFont(new Font("Malgun Gothic", Font.BOLD, 12));
		
		lblTelefone = new JLabel("TELEFONE");
		lblTelefone.setBounds(140, 66, 62, 17);
		panel_1.add(lblTelefone);
		lblTelefone.setFont(new Font("Malgun Gothic", Font.BOLD, 12));
		
		txtTelefone = new JFormattedTextField();
		txtTelefone.setBounds(140, 94, 130, 30);
		panel_1.add(txtTelefone);
		txtTelefone.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("(##) ####-####")));
		
		pnlEndereco = new JPanel();
		pnlEndereco.setBackground(Color.WHITE);
		tabbedPane.addTab("ENDERE\u00C7O", null, pnlEndereco, null);
		pnlEndereco.setLayout(null);
		
		panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(22, 11, 300, 355);
		pnlEndereco.add(panel_2);
		panel_2.setLayout(null);
		
		lblCep = new JLabel("CEP");
		lblCep.setBounds(0, 0, 21, 17);
		panel_2.add(lblCep);
		lblCep.setFont(new Font("Malgun Gothic", Font.BOLD, 12));
		
		txtCep = new JFormattedTextField();
		txtCep.setBounds(0, 28, 150, 30);
		panel_2.add(txtCep);
		txtCep.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("#####-###")));
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(0, 94, 240, 30);
		panel_2.add(txtEndereco);
		txtEndereco.setColumns(10);
		
		lblNome_1 = new JLabel("ENDERE\u00C7O");
		lblNome_1.setBounds(0, 69, 62, 17);
		panel_2.add(lblNome_1);
		lblNome_1.setFont(new Font("Malgun Gothic", Font.BOLD, 12));
		
		textField_1 = new JTextField();
		textField_1.setBounds(250, 94, 50, 30);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		lblNome_2 = new JLabel("N\u00BA");
		lblNome_2.setBounds(250, 69, 16, 17);
		panel_2.add(lblNome_2);
		lblNome_2.setFont(new Font("Malgun Gothic", Font.BOLD, 12));
		
		lblNome_3 = new JLabel("COMPLEMENTO");
		lblNome_3.setBounds(0, 135, 92, 17);
		panel_2.add(lblNome_3);
		lblNome_3.setFont(new Font("Malgun Gothic", Font.BOLD, 12));
		
		txtComplemento = new JTextField();
		txtComplemento.setBounds(0, 160, 300, 30);
		panel_2.add(txtComplemento);
		txtComplemento.setColumns(10);
		
		lblNome_4 = new JLabel("CIDADE");
		lblNome_4.setBounds(0, 267, 44, 17);
		panel_2.add(lblNome_4);
		lblNome_4.setFont(new Font("Malgun Gothic", Font.BOLD, 12));
		
		txtCidade = new JTextField();
		txtCidade.setBounds(0, 292, 200, 30);
		panel_2.add(txtCidade);
		txtCidade.setColumns(10);
		
		cmbEstado = new JComboBox();
		cmbEstado.setBounds(210, 292, 90, 30);
		panel_2.add(cmbEstado);
		
		lblNome_5 = new JLabel("UF");
		lblNome_5.setBounds(210, 267, 44, 17);
		panel_2.add(lblNome_5);
		lblNome_5.setFont(new Font("Malgun Gothic", Font.BOLD, 12));
		
		lblNome_9 = new JLabel("BAIRRO");
		lblNome_9.setFont(new Font("Malgun Gothic", Font.BOLD, 12));
		lblNome_9.setBounds(0, 201, 45, 17);
		panel_2.add(lblNome_9);
		
		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		txtBairro.setBounds(0, 226, 300, 30);
		panel_2.add(txtBairro);
		
		pnlCurso = new JPanel();
		pnlCurso.setBackground(Color.WHITE);
		tabbedPane.addTab("CURSO", null, pnlCurso, null);
		pnlCurso.setLayout(null);
		
		panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(22, 11, 300, 186);
		pnlCurso.add(panel_4);
		panel_4.setLayout(null);
		
		lblNome_6 = new JLabel("CURSO");
		lblNome_6.setBounds(0, 0, 41, 17);
		panel_4.add(lblNome_6);
		lblNome_6.setFont(new Font("Malgun Gothic", Font.BOLD, 12));
		
		cmbCurso = new JComboBox();
		cmbCurso.setBounds(0, 25, 300, 30);
		panel_4.add(cmbCurso);
		
		cmbUnidade = new JComboBox();
		cmbUnidade.setBounds(0, 91, 300, 30);
		panel_4.add(cmbUnidade);
		
		lblNome_7 = new JLabel("CAMPUS");
		lblNome_7.setBounds(0, 66, 51, 17);
		panel_4.add(lblNome_7);
		lblNome_7.setFont(new Font("Malgun Gothic", Font.BOLD, 12));
		
		rdbMatutino = new JRadioButton("MATUTINO");
		rdbMatutino.setBounds(0, 156, 90, 30);
		panel_4.add(rdbMatutino);
		rdbMatutino.setHorizontalAlignment(SwingConstants.CENTER);
		Periodo.add(rdbMatutino);
		
		rdbVespertino = new JRadioButton("VESPERTINO");
		rdbVespertino.setBounds(102, 156, 95, 30);
		panel_4.add(rdbVespertino);
		Periodo.add(rdbVespertino);
		rdbVespertino.setHorizontalAlignment(SwingConstants.CENTER);
		
		rdbNoturno = new JRadioButton("NOTURNO");
		rdbNoturno.setBounds(210, 156, 90, 30);
		panel_4.add(rdbNoturno);
		Periodo.add(rdbNoturno);
		rdbNoturno.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblNome_8 = new JLabel("PER\u00CDODO");
		lblNome_8.setBounds(0, 132, 52, 17);
		panel_4.add(lblNome_8);
		lblNome_8.setFont(new Font("Malgun Gothic", Font.BOLD, 12));
	}
}
