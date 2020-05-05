package br.com.unicid.cadastroaluno.view;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import br.com.unicid.cadastroaluno.DAO.AlunoDAO;
import br.com.unicid.cadastroaluno.model.Aluno;
import br.com.unicid.cadastroaluno.model.Pessoa;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.DebugGraphics;

public class frmAluno extends JFrame {

	private JPanel contentPane;
	public JTabbedPane tabbedPane;
	public JPanel pnlDadosPessoais;
	public JTextField txtRgm;
	public JLabel lblNewLabel;
	public JTextField txtNome;
	public JLabel lblNome;
	public JLabel lblCpf;
	public JFormattedTextField txtCpf;
	private final ButtonGroup Sexo = new ButtonGroup();
	public JLabel lblSexo;
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
	public JTextField txtNumero;
	public JLabel lblNome_2;
	public JLabel lblNome_3;
	public JTextField txtComplemento;
	public JLabel lblNome_4;
	public JTextField txtCidade;
	public JComboBox cmbUF;
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
	public JButton btnNovo;
	public JButton btnConsultar;
	public JButton btnAlterar;
	public JButton btnExcluir;
	public JButton btnCancelar;
	public JPanel panel_3;
	public JComboBox cmbGenero;

	public static Aluno aluno;
	public static Pessoa pessoa;
	private FerramentasFormulario f;
	protected boolean habilitarCampos;
	public JLabel lblCelular_1;
	public JFormattedTextField txtDataNascimento;


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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 268, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(47, 11, 350, 450);
		tabbedPane.setBorder(null);
		tabbedPane.setBackground(Color.WHITE);
		contentPane.add(tabbedPane);

		pnlDadosPessoais = new JPanel();
		pnlDadosPessoais.setBorder(null);
		pnlDadosPessoais.setBackground(new Color(240, 240, 240));
		tabbedPane.addTab("DADOS PESSOAIS", null, pnlDadosPessoais, null);
		pnlDadosPessoais.setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(240, 240, 240));
		panel.setBounds(22, 11, 300, 259);
		pnlDadosPessoais.add(panel);
		panel.setLayout(null);

		txtRgm = new JTextField();
		txtRgm.setBackground(Color.WHITE);
		txtRgm.setEnabled(false);
		txtRgm.setBounds(0, 25, 150, 30);
		panel.add(txtRgm);
		txtRgm.setColumns(10);

		lblNewLabel = new JLabel("RGM");
		lblNewLabel.setBounds(0, 0, 29, 17);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Malgun Gothic", Font.BOLD, 12));

		txtNome = new JTextField();
		txtNome.setBackground(Color.WHITE);
		txtNome.setEnabled(false);
		txtNome.setBounds(0, 160, 300, 30);
		panel.add(txtNome);
		txtNome.setColumns(10);

		lblNome = new JLabel("NOME");
		lblNome.setBounds(0, 135, 37, 17);
		panel.add(lblNome);
		lblNome.setFont(new Font("Malgun Gothic", Font.BOLD, 12));

		lblCpf = new JLabel("CPF");
		lblCpf.setBounds(0, 66, 21, 17);
		panel.add(lblCpf);
		lblCpf.setFont(new Font("Malgun Gothic", Font.BOLD, 12));

		txtCpf = new JFormattedTextField();
		txtCpf.setBackground(Color.WHITE);
		txtCpf.setEnabled(false);
		txtCpf.setBounds(0, 94, 150, 30);
		panel.add(txtCpf);
		txtCpf.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("###.###.###-##")));

		lblSexo = new JLabel("G\u00CANERO");
		lblSexo.setBounds(140, 201, 48, 17);
		panel.add(lblSexo);
		lblSexo.setFont(new Font("Malgun Gothic", Font.BOLD, 12));

		cmbGenero = new JComboBox();
		cmbGenero.setBackground(Color.WHITE);
		cmbGenero.setBorder(null);
		cmbGenero.setModel(new DefaultComboBoxModel(new String[] {"- Selecione", "Masculino", "Feminino"}));
		cmbGenero.setEnabled(false);
		cmbGenero.setBounds(140, 229, 160, 30);
		panel.add(cmbGenero);

		lblCelular_1 = new JLabel("NASCIMENTO");
		lblCelular_1.setFont(new Font("Malgun Gothic", Font.BOLD, 12));
		lblCelular_1.setBounds(0, 201, 81, 17);
		panel.add(lblCelular_1);

		txtDataNascimento = new JFormattedTextField();
		txtDataNascimento.setBackground(Color.WHITE);
		txtDataNascimento.setEnabled(false);
		txtDataNascimento.setBounds(0, 229, 130, 30);
		panel.add(txtDataNascimento);
		txtDataNascimento.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 240, 240));
		panel_1.setBounds(22, 281, 300, 124);
		pnlDadosPessoais.add(panel_1);
		panel_1.setLayout(null);

		txtEmail = new JTextField();
		txtEmail.setBackground(Color.WHITE);
		txtEmail.setEnabled(false);
		txtEmail.setBounds(0, 25, 300, 30);
		panel_1.add(txtEmail);
		txtEmail.setColumns(10);

		lblEmail = new JLabel("E-MAIL");
		lblEmail.setBounds(0, 0, 41, 17);
		panel_1.add(lblEmail);
		lblEmail.setFont(new Font("Malgun Gothic", Font.BOLD, 12));

		txtCelular = new JFormattedTextField();
		txtCelular.setBackground(Color.WHITE);
		txtCelular.setEnabled(false);
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
		txtTelefone.setBackground(Color.WHITE);
		txtTelefone.setEnabled(false);
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
		txtCep.setEnabled(false);
		txtCep.setBounds(0, 28, 150, 30);
		panel_2.add(txtCep);
		txtCep.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("#####-###")));

		txtEndereco = new JTextField();
		txtEndereco.setEnabled(false);
		txtEndereco.setBounds(0, 94, 240, 30);
		panel_2.add(txtEndereco);
		txtEndereco.setColumns(10);

		lblNome_1 = new JLabel("ENDERE\u00C7O");
		lblNome_1.setBounds(0, 69, 62, 17);
		panel_2.add(lblNome_1);
		lblNome_1.setFont(new Font("Malgun Gothic", Font.BOLD, 12));

		txtNumero = new JTextField();
		txtNumero.setEnabled(false);
		txtNumero.setBounds(250, 94, 50, 30);
		panel_2.add(txtNumero);
		txtNumero.setColumns(10);

		lblNome_2 = new JLabel("N\u00BA");
		lblNome_2.setBounds(250, 69, 16, 17);
		panel_2.add(lblNome_2);
		lblNome_2.setFont(new Font("Malgun Gothic", Font.BOLD, 12));

		lblNome_3 = new JLabel("COMPLEMENTO");
		lblNome_3.setBounds(0, 135, 92, 17);
		panel_2.add(lblNome_3);
		lblNome_3.setFont(new Font("Malgun Gothic", Font.BOLD, 12));

		txtComplemento = new JTextField();
		txtComplemento.setEnabled(false);
		txtComplemento.setBounds(0, 160, 300, 30);
		panel_2.add(txtComplemento);
		txtComplemento.setColumns(10);

		lblNome_4 = new JLabel("CIDADE");
		lblNome_4.setBounds(0, 267, 44, 17);
		panel_2.add(lblNome_4);
		lblNome_4.setFont(new Font("Malgun Gothic", Font.BOLD, 12));

		txtCidade = new JTextField();
		txtCidade.setEnabled(false);
		txtCidade.setBounds(0, 292, 200, 30);
		panel_2.add(txtCidade);
		txtCidade.setColumns(10);

		cmbUF = new JComboBox();
		cmbUF.setEnabled(false);
		cmbUF.setModel(new DefaultComboBoxModel(new String[] {"- Selecione", "SP"}));
		cmbUF.setBounds(210, 292, 90, 30);
		panel_2.add(cmbUF);

		lblNome_5 = new JLabel("UF");
		lblNome_5.setBounds(210, 267, 44, 17);
		panel_2.add(lblNome_5);
		lblNome_5.setFont(new Font("Malgun Gothic", Font.BOLD, 12));

		lblNome_9 = new JLabel("BAIRRO");
		lblNome_9.setFont(new Font("Malgun Gothic", Font.BOLD, 12));
		lblNome_9.setBounds(0, 201, 45, 17);
		panel_2.add(lblNome_9);

		txtBairro = new JTextField();
		txtBairro.setEnabled(false);
		txtBairro.setColumns(10);
		txtBairro.setBounds(0, 226, 300, 30);
		panel_2.add(txtBairro);

		pnlCurso = new JPanel();
		pnlCurso.setBackground(Color.WHITE);
		tabbedPane.addTab("CURSO", null, pnlCurso, null);
		pnlCurso.setLayout(null);

		panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(22, 11, 300, 252);
		pnlCurso.add(panel_4);
		panel_4.setLayout(null);

		lblNome_6 = new JLabel("CURSO");
		lblNome_6.setBounds(0, 0, 41, 17);
		panel_4.add(lblNome_6);
		lblNome_6.setFont(new Font("Malgun Gothic", Font.BOLD, 12));

		cmbCurso = new JComboBox();
		cmbCurso.setEnabled(false);
		cmbCurso.setModel(new DefaultComboBoxModel(new String[] {"- Selecione"}));
		cmbCurso.setBounds(0, 25, 300, 30);
		panel_4.add(cmbCurso);

		cmbUnidade = new JComboBox();
		cmbUnidade.setEnabled(false);
		cmbUnidade.setModel(new DefaultComboBoxModel(new String[] {"- Selecione"}));
		cmbUnidade.setToolTipText("");
		cmbUnidade.setBounds(0, 91, 300, 30);
		panel_4.add(cmbUnidade);

		lblNome_7 = new JLabel("CAMPUS");
		lblNome_7.setBounds(0, 66, 51, 17);
		panel_4.add(lblNome_7);
		lblNome_7.setFont(new Font("Malgun Gothic", Font.BOLD, 12));

		rdbMatutino = new JRadioButton("MATUTINO");
		rdbMatutino.setEnabled(false);
		rdbMatutino.setBounds(0, 152, 90, 30);
		panel_4.add(rdbMatutino);
		rdbMatutino.setHorizontalAlignment(SwingConstants.CENTER);
		Periodo.add(rdbMatutino);

		rdbVespertino = new JRadioButton("VESPERTINO");
		rdbVespertino.setEnabled(false);
		rdbVespertino.setBounds(102, 152, 95, 30);
		panel_4.add(rdbVespertino);
		Periodo.add(rdbVespertino);
		rdbVespertino.setHorizontalAlignment(SwingConstants.CENTER);

		rdbNoturno = new JRadioButton("NOTURNO");
		rdbNoturno.setEnabled(false);
		rdbNoturno.setBounds(210, 152, 90, 30);
		panel_4.add(rdbNoturno);
		Periodo.add(rdbNoturno);
		rdbNoturno.setHorizontalAlignment(SwingConstants.CENTER);

		lblNome_8 = new JLabel("PER\u00CDODO");
		lblNome_8.setBounds(0, 128, 52, 17);
		panel_4.add(lblNome_8);
		lblNome_8.setFont(new Font("Malgun Gothic", Font.BOLD, 12));

		panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(52, 475, 340, 60);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		/*CADASTRAR*/

		btnNovo = new JButton("");
		btnNovo.setToolTipText("Novo");
		btnNovo.setIcon(new ImageIcon("C:\\Users\\athos\\Google Drive\\Analise e desenvolvimento de sistemas\\3\u00BA Semestre\\Tecnicas de Programa\u00E7\u00E3o\\cadastro_alunos\\unicid.cadastroAluno\\CadastroAluno\\icons\\new.png"));
		btnNovo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNovo.setBorder(null);
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if(habilitarCampos == true) {

					aluno = new Aluno(); //CRIA UM NOVO OBEJTO DO TIPO ALUNO
					aluno.setNome(txtNome.getText()); 
					aluno.setCpf(txtCpf.getText());
					aluno.setDataNascimento(txtDataNascimento.getText());
					aluno.setGenero(cmbGenero);
					aluno.setEmail(txtEmail.getText());
					aluno.setCelular(txtCelular.getText());
					aluno.setTelefone(txtTelefone.getText());
					aluno.setRgm(Integer.parseInt(txtRgm.getText()));
					aluno.setPeriodo(rdbMatutino, rdbNoturno, rdbNoturno);
					aluno.setCep(txtCep.getText());
					aluno.setEndereco(txtEndereco.getText());
					aluno.setNumero(txtNumero.getText());
					aluno.setComplemento(txtComplemento.getText());
					aluno.setBairro(txtBairro.getText());
					aluno.setCidade(txtCidade.getText());
					aluno.setUf(cmbUF.getSelectedItem().toString());

					aluno.salvarAluno(); //MÉTODO DA CLASSE ALUNO

					habilitarCampos = false;
				} 
				else if(habilitarCampos == false)
				{
					f = new FerramentasFormulario();
					f.limpaComponentes(txtRgm, txtNome, txtCpf, txtEmail, txtEmail, txtCelular, txtTelefone); //Limpa os campos do panel Alunos
					f.limpaComponentes(txtCep, txtEndereco, txtNumero, txtComplemento, txtBairro, txtCidade); //Limpa os campos do panel Endereço
					f.habilitaComponentes(txtRgm, txtNome, txtCpf, txtDataNascimento, txtEmail, txtCelular, txtTelefone); //Habilita os campos do panel Alunos
					f.habilitaComponentes(txtCep, txtEndereco, txtNumero, txtComplemento, txtBairro, txtCidade); //Habilita os campos do panel Endereço
					f.habilitaComponentes(cmbCurso, cmbUF, cmbUnidade);
					f.habilitaComponentes(rdbMatutino, rdbNoturno, rdbVespertino);
					f.resetCombo(cmbCurso, cmbUF, cmbUnidade); //Coloca os combos do formulário na posição inicial
					cmbGenero.setEnabled(true);
					btnNovo.setText("Cadastrar"); 
					habilitarCampos = true;
				}
			}
		});

		/*CONSULTAR*/

		btnNovo.setMargin(new Insets(0, 0, 0, 0));
		btnNovo.setFont(new Font("Malgun Gothic", Font.PLAIN, 11));
		btnNovo.setBackground(Color.WHITE);
		btnNovo.setBounds(0, 0, 60, 60);
		panel_3.add(btnNovo);

		btnConsultar = new JButton("");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(habilitarCampos == true) {

					aluno = new Aluno();
					aluno.setRgm(Integer.parseInt(txtRgm.getText()));
					aluno.consultarAluno(aluno.getRgm());

					txtCpf.setText(aluno.getCpf());
					txtNome.setText(aluno.getNome());
					txtDataNascimento.setText(aluno.getDataNascimento());
					cmbGenero.setSelectedIndex(aluno.getGenero(cmbGenero));
					txtEmail.setText(aluno.getEmail());
					txtCelular.setText(aluno.getCelular());
					txtTelefone.setText(aluno.getTelefone());
					txtCep.setText(aluno.getCep());
					txtEndereco.setText(aluno.getEndereco());
					txtNumero.setText(aluno.getNumero());
					txtComplemento.setText(aluno.getComplemento());
					txtBairro.setText(aluno.getBairro());
					txtCidade.setText(aluno.getCidade());
					//cmbUF.setSelectedIndex(anIndex);
					aluno.getPeriodo(rdbMatutino, rdbVespertino, rdbNoturno);
					habilitarCampos = false;
				} 
				else {
					f = new FerramentasFormulario();
					f.limpaComponentes(txtRgm, txtNome, txtCpf, txtEmail, txtEmail, txtCelular, txtTelefone);
					f.limpaComponentes(txtCep, txtEndereco, txtNumero, txtComplemento, txtBairro, txtCidade); 
					f.desabilitaComponentes(txtNome, txtEmail, txtCelular, txtTelefone); 
					f.desabilitaComponentes(txtCep, txtEndereco, txtNumero, txtComplemento, txtBairro, txtCidade); 
					f.desabilitaComponentes(cmbCurso, cmbUF, cmbUnidade);
					f.desabilitaComponentes(rdbMatutino, rdbNoturno, rdbVespertino);
					f.resetCombo(cmbCurso, cmbUF, cmbUnidade);
					cmbGenero.setEnabled(false);
					txtRgm.setEnabled(true);
					txtCpf.setEnabled(true);

					habilitarCampos = true;
				}
			}
		});
		btnConsultar.setBorderPainted(false);
		btnConsultar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConsultar.setBorder(null);
		btnConsultar.setIcon(new ImageIcon("C:\\Users\\athos\\Google Drive\\Analise e desenvolvimento de sistemas\\3\u00BA Semestre\\Tecnicas de Programa\u00E7\u00E3o\\cadastro_alunos\\unicid.cadastroAluno\\CadastroAluno\\icons\\search.png"));
		btnConsultar.setToolTipText("Pesquisar");
		btnConsultar.setFont(new Font("Malgun Gothic", Font.PLAIN, 11));
		btnConsultar.setMargin(new Insets(0, 0, 0, 0));
		btnConsultar.setBackground(Color.WHITE);
		btnConsultar.setBounds(70, 0, 60, 60);
		panel_3.add(btnConsultar);

		/*ALTERAR*/

		btnAlterar = new JButton("");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if(habilitarCampos == true) {

					aluno.setNome(txtNome.getText()); 
					aluno.setCpf(txtCpf.getText());
					aluno.setDataNascimento(txtDataNascimento.getText());
					aluno.setGenero(cmbGenero);
					aluno.setEmail(txtEmail.getText());
					aluno.setCelular(txtCelular.getText());
					aluno.setTelefone(txtTelefone.getText());
					aluno.setRgm(Integer.parseInt(txtRgm.getText()));
					aluno.setPeriodo(rdbMatutino, rdbNoturno, rdbNoturno);
					aluno.setCep(txtCep.getText());
					aluno.setEndereco(txtEndereco.getText());
					aluno.setNumero(txtNumero.getText());
					aluno.setComplemento(txtComplemento.getText());
					aluno.setBairro(txtBairro.getText());
					aluno.setCidade(txtCidade.getText());
					aluno.setUf(cmbUF.getSelectedItem().toString());

					aluno.alteraeAluno();
				}
				else {
					f = new FerramentasFormulario();
					f.habilitaComponentes(txtRgm, txtNome, txtCpf, txtDataNascimento, txtEmail, txtCelular, txtTelefone); //Habilita os campos do panel Alunos
					f.habilitaComponentes(txtCep, txtEndereco, txtNumero, txtComplemento, txtBairro, txtCidade); //Habilita os campos do panel Endereço
					f.habilitaComponentes(cmbCurso, cmbUF, cmbUnidade);
					f.habilitaComponentes(rdbMatutino, rdbNoturno, rdbVespertino);
					cmbGenero.setEnabled(true);

					habilitarCampos = true;
				}

			}
		});
		btnAlterar.setIcon(new ImageIcon("C:\\Users\\athos\\Google Drive\\Analise e desenvolvimento de sistemas\\3\u00BA Semestre\\Tecnicas de Programa\u00E7\u00E3o\\cadastro_alunos\\unicid.cadastroAluno\\CadastroAluno\\icons\\edit.png"));
		btnAlterar.setToolTipText("Alterar");
		btnAlterar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAlterar.setBorder(null);
		btnAlterar.setFont(new Font("Malgun Gothic", Font.PLAIN, 11));
		btnAlterar.setMargin(new Insets(0, 0, 0, 0));
		btnAlterar.setBackground(Color.WHITE);
		btnAlterar.setBounds(140, 0, 60, 60);
		panel_3.add(btnAlterar);

		/*EXCLUIR*/

		btnExcluir = new JButton("");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				aluno.excluirAluno(aluno.getRgm());

			}
		});

		btnExcluir.setIcon(new ImageIcon("C:\\Users\\athos\\Google Drive\\Analise e desenvolvimento de sistemas\\3\u00BA Semestre\\Tecnicas de Programa\u00E7\u00E3o\\cadastro_alunos\\unicid.cadastroAluno\\CadastroAluno\\icons\\delete.png"));
		btnExcluir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExcluir.setBorder(null);
		btnExcluir.setToolTipText("Excluir");
		btnExcluir.setFont(new Font("Malgun Gothic", Font.PLAIN, 11));
		btnExcluir.setMargin(new Insets(0, 0, 0, 0));
		btnExcluir.setBackground(Color.WHITE);
		btnExcluir.setBounds(210, 0, 60, 60);
		panel_3.add(btnExcluir);

		btnCancelar = new JButton("");
		btnCancelar.setToolTipText("Cancelar");
		btnCancelar.setIcon(new ImageIcon("C:\\Users\\athos\\Google Drive\\Analise e desenvolvimento de sistemas\\3\u00BA Semestre\\Tecnicas de Programa\u00E7\u00E3o\\cadastro_alunos\\unicid.cadastroAluno\\CadastroAluno\\icons\\cancel.png"));
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setBorder(null);
		btnCancelar.setFont(new Font("Malgun Gothic", Font.PLAIN, 11));
		btnCancelar.setMargin(new Insets(0, 0, 0, 0));
		btnCancelar.setBackground(Color.WHITE);
		btnCancelar.setBounds(280, 0, 60, 60);
		panel_3.add(btnCancelar);


	}
}
