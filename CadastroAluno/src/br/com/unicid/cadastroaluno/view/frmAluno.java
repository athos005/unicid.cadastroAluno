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
import br.com.unicid.cadastroaluno.DAO.DisciplinaAlunoDAO;
import br.com.unicid.cadastroaluno.model.Aluno;
import br.com.unicid.cadastroaluno.model.Curso;
import br.com.unicid.cadastroaluno.model.DisciplinasAluno;
import br.com.unicid.cadastroaluno.model.Endereco;
import br.com.unicid.cadastroaluno.model.Pessoa;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.DebugGraphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmAluno extends JFrame {

	private JPanel contentPane;
	public JTabbedPane tabbedPane;
	public static JPanel pnlDadosPessoais;
	public static JTextField txtRgm;
	public static JLabel lblNewLabel;
	public static JTextField txtNome;
	public static JLabel lblNome;
	public static JLabel lblCpf;
	public static JFormattedTextField txtCpf;
	private final ButtonGroup Sexo = new ButtonGroup();
	public static JLabel lblSexo;
	public static JPanel panel;
	public static JTextField txtEmail;
	public static JLabel lblEmail;
	public static JFormattedTextField txtCelular;
	public static JLabel lblCelular;
	public JLabel lblTelefone;
	public static JFormattedTextField txtTelefone;
	public static JPanel panel_1;
	public static JPanel pnlEndereco;
	public static JLabel lblCep;
	public static JFormattedTextField txtCep;
	public static JTextField txtEndereco;
	public static JLabel lblNome_1;
	public static JTextField txtNumero;
	public static JLabel lblNome_2;
	public static JLabel lblNome_3;
	public static JTextField txtComplemento;
	public static JLabel lblNome_4;
	public static JTextField txtCidade;
	public static JComboBox cmbUF;
	public static JLabel lblNome_5;
	public static JPanel panel_2;
	public static JPanel pnlCurso;
	public static JLabel lblNome_6;
	public static JComboBox cmbCurso;
	public static JComboBox cmbUnidade;
	public static JLabel lblNome_7;
	public static JRadioButton rdbMatutino;
	private final ButtonGroup Periodo = new ButtonGroup();
	public static JRadioButton rdbVespertino;
	public static JRadioButton rdbNoturno;
	public static JLabel lblNome_8;
	public static JPanel panel_4;
	public static JLabel lblNome_9;
	public static JTextField txtBairro;
	public static JButton btnNovo;
	public static JButton btnConsultar;
	public static JButton btnAlterar;
	public static JButton btnExcluir;
	public static JButton btnCancelar;
	public static JPanel panel_3;
	public static JComboBox cmbGenero;
	public JLabel lblCelular_1;
	public static JFormattedTextField txtNascimento;

	public static Aluno aluno;
	public static Pessoa pessoa;
	public DisciplinasAluno disciplinasAluno;
	private FerramentasFormulario f;
	protected boolean habilitarCampos;
	public JLabel lblNomeCurso;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmAluno frame = new frmAluno();
					frame.setLocationRelativeTo(null);
					frame.setVisible(false);
					
					frmHome home = new frmHome();
					home.setVisible(true);
					home.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
		setLocationByPlatform(true);
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
		txtRgm.setBorder(new LineBorder(Color.LIGHT_GRAY));
		txtRgm.setDisabledTextColor(Color.LIGHT_GRAY);
		txtRgm.setBackground(Color.WHITE);
		txtRgm.setEnabled(false);
		txtRgm.setBounds(0, 25, 150, 30);
		panel.add(txtRgm);
		txtRgm.setColumns(10);

		lblNewLabel = new JLabel("RGM");
		lblNewLabel.setBounds(0, 0, 34, 17);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Malgun Gothic", Font.BOLD, 12));

		txtNome = new JTextField();
		txtNome.setBorder(new LineBorder(Color.LIGHT_GRAY));
		txtNome.setDisabledTextColor(Color.GRAY);
		txtNome.setBackground(Color.WHITE);
		txtNome.setEnabled(false);
		txtNome.setBounds(0, 160, 300, 30);
		panel.add(txtNome);
		txtNome.setColumns(10);

		lblNome = new JLabel("NOME*");
		lblNome.setBounds(0, 135, 42, 17);
		panel.add(lblNome);
		lblNome.setFont(new Font("Malgun Gothic", Font.BOLD, 12));

		lblCpf = new JLabel("CPF*");
		lblCpf.setBounds(0, 66, 26, 17);
		panel.add(lblCpf);
		lblCpf.setFont(new Font("Malgun Gothic", Font.BOLD, 12));

		txtCpf = new JFormattedTextField();
		txtCpf.setBorder(new LineBorder(Color.LIGHT_GRAY));
		txtCpf.setDisabledTextColor(Color.GRAY);
		txtCpf.setBackground(Color.WHITE);
		txtCpf.setEnabled(false);
		txtCpf.setBounds(0, 94, 150, 30);
		panel.add(txtCpf);
		txtCpf.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("###.###.###-##")));

		lblSexo = new JLabel("G\u00CANERO*");
		lblSexo.setBounds(140, 201, 53, 17);
		panel.add(lblSexo);
		lblSexo.setFont(new Font("Malgun Gothic", Font.BOLD, 12));

		cmbGenero = new JComboBox();
		cmbGenero.setBackground(Color.WHITE);
		cmbGenero.setBorder(new LineBorder(Color.LIGHT_GRAY));
		cmbGenero.setModel(new DefaultComboBoxModel(new String[] {"- Selecione", "Masculino", "Feminino"}));
		cmbGenero.setEnabled(false);
		cmbGenero.setBounds(140, 229, 160, 30);
		panel.add(cmbGenero);

		lblCelular_1 = new JLabel("NASCIMENTO*");
		lblCelular_1.setFont(new Font("Malgun Gothic", Font.BOLD, 12));
		lblCelular_1.setBounds(0, 201, 86, 17);
		panel.add(lblCelular_1);

		txtNascimento = new JFormattedTextField();
		txtNascimento.setBorder(new LineBorder(Color.LIGHT_GRAY));
		txtNascimento.setDisabledTextColor(Color.GRAY);
		txtNascimento.setBackground(Color.WHITE);
		txtNascimento.setEnabled(false);
		txtNascimento.setBounds(0, 229, 130, 30);
		panel.add(txtNascimento);
		txtNascimento.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 240, 240));
		panel_1.setBounds(22, 281, 300, 124);
		pnlDadosPessoais.add(panel_1);
		panel_1.setLayout(null);

		txtEmail = new JTextField();
		txtEmail.setBorder(new LineBorder(Color.LIGHT_GRAY));
		txtEmail.setDisabledTextColor(Color.GRAY);
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
		txtCelular.setBorder(new LineBorder(Color.LIGHT_GRAY));
		txtCelular.setDisabledTextColor(Color.GRAY);
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
		txtTelefone.setBorder(new LineBorder(Color.LIGHT_GRAY));
		txtTelefone.setDisabledTextColor(Color.GRAY);
		txtTelefone.setBackground(Color.WHITE);
		txtTelefone.setEnabled(false);
		txtTelefone.setBounds(140, 94, 130, 30);
		panel_1.add(txtTelefone);
		txtTelefone.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("(##) ####-####")));

		pnlEndereco = new JPanel();
		pnlEndereco.setBackground(new Color(240, 240, 240));
		tabbedPane.addTab("ENDERE\u00C7O", null, pnlEndereco, null);
		pnlEndereco.setLayout(null);

		panel_2 = new JPanel();
		panel_2.setBackground(new Color(240, 240, 240));
		panel_2.setBounds(22, 11, 300, 355);
		pnlEndereco.add(panel_2);
		panel_2.setLayout(null);

		lblCep = new JLabel("CEP*");
		lblCep.setBounds(0, 0, 26, 17);
		panel_2.add(lblCep);
		lblCep.setFont(new Font("Malgun Gothic", Font.BOLD, 12));

		txtCep = new JFormattedTextField();
		txtCep.setBorder(new LineBorder(Color.LIGHT_GRAY));
		txtCep.setBackground(Color.WHITE);
		txtCep.setDisabledTextColor(Color.GRAY);
		txtCep.setEnabled(false);
		txtCep.setBounds(0, 28, 150, 30);
		panel_2.add(txtCep);
		txtCep.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("#####-###")));

		txtEndereco = new JTextField();
		txtEndereco.setBorder(new LineBorder(Color.LIGHT_GRAY));
		txtEndereco.setBackground(Color.WHITE);
		txtEndereco.setDisabledTextColor(Color.GRAY);
		txtEndereco.setEnabled(false);
		txtEndereco.setBounds(0, 94, 240, 30);
		panel_2.add(txtEndereco);
		txtEndereco.setColumns(10);

		lblNome_1 = new JLabel("ENDERE\u00C7O*");
		lblNome_1.setBounds(0, 69, 67, 17);
		panel_2.add(lblNome_1);
		lblNome_1.setFont(new Font("Malgun Gothic", Font.BOLD, 12));

		txtNumero = new JTextField();
		txtNumero.setBorder(new LineBorder(Color.LIGHT_GRAY));
		txtNumero.setBackground(Color.WHITE);
		txtNumero.setDisabledTextColor(Color.GRAY);
		txtNumero.setEnabled(false);
		txtNumero.setBounds(250, 94, 50, 30);
		panel_2.add(txtNumero);
		txtNumero.setColumns(10);

		lblNome_2 = new JLabel("N\u00BA*");
		lblNome_2.setBounds(250, 69, 21, 17);
		panel_2.add(lblNome_2);
		lblNome_2.setFont(new Font("Malgun Gothic", Font.BOLD, 12));

		lblNome_3 = new JLabel("COMPLEMENTO");
		lblNome_3.setBounds(0, 135, 92, 17);
		panel_2.add(lblNome_3);
		lblNome_3.setFont(new Font("Malgun Gothic", Font.BOLD, 12));

		txtComplemento = new JTextField();
		txtComplemento.setBorder(new LineBorder(Color.LIGHT_GRAY));
		txtComplemento.setBackground(Color.WHITE);
		txtComplemento.setDisabledTextColor(Color.GRAY);
		txtComplemento.setEnabled(false);
		txtComplemento.setBounds(0, 160, 300, 30);
		panel_2.add(txtComplemento);
		txtComplemento.setColumns(10);

		lblNome_4 = new JLabel("CIDADE*");
		lblNome_4.setBounds(0, 267, 49, 17);
		panel_2.add(lblNome_4);
		lblNome_4.setFont(new Font("Malgun Gothic", Font.BOLD, 12));

		txtCidade = new JTextField();
		txtCidade.setBorder(new LineBorder(Color.LIGHT_GRAY));
		txtCidade.setBackground(Color.WHITE);
		txtCidade.setDisabledTextColor(Color.GRAY);
		txtCidade.setEnabled(false);
		txtCidade.setBounds(0, 292, 200, 30);
		panel_2.add(txtCidade);
		txtCidade.setColumns(10);

		Endereco uf = new Endereco();
		cmbUF = new JComboBox();
		cmbUF.setBorder(new LineBorder(Color.LIGHT_GRAY));
		cmbUF.setBackground(Color.WHITE);
		cmbUF.setEnabled(false);
		cmbUF.setModel(new DefaultComboBoxModel(uf.buscarUF().toArray()));
		cmbUF.setBounds(210, 292, 90, 30);
		panel_2.add(cmbUF);

		lblNome_5 = new JLabel("UF*");
		lblNome_5.setBounds(210, 267, 44, 17);
		panel_2.add(lblNome_5);
		lblNome_5.setFont(new Font("Malgun Gothic", Font.BOLD, 12));

		lblNome_9 = new JLabel("BAIRRO*");
		lblNome_9.setFont(new Font("Malgun Gothic", Font.BOLD, 12));
		lblNome_9.setBounds(0, 201, 50, 17);
		panel_2.add(lblNome_9);

		txtBairro = new JTextField();
		txtBairro.setBorder(new LineBorder(Color.LIGHT_GRAY));
		txtBairro.setBackground(Color.WHITE);
		txtBairro.setDisabledTextColor(Color.GRAY);
		txtBairro.setEnabled(false);
		txtBairro.setColumns(10);
		txtBairro.setBounds(0, 226, 300, 30);
		panel_2.add(txtBairro);

		pnlCurso = new JPanel();
		pnlCurso.setBackground(new Color(240, 240, 240));
		tabbedPane.addTab("CURSO", null, pnlCurso, null);
		pnlCurso.setLayout(null);

		panel_4 = new JPanel();
		panel_4.setBackground(new Color(240, 240, 240));
		panel_4.setBounds(22, 11, 300, 252);
		pnlCurso.add(panel_4);
		panel_4.setLayout(null);

		lblNome_6 = new JLabel("CURSO*");
		lblNome_6.setBounds(0, 0, 46, 17);
		panel_4.add(lblNome_6);
		lblNome_6.setFont(new Font("Malgun Gothic", Font.BOLD, 12));

		aluno = new Aluno();
		lblNomeCurso = new JLabel("");
		lblNomeCurso.setEnabled(false);
		lblNomeCurso.setBorder(new LineBorder(Color.LIGHT_GRAY));
		lblNomeCurso.setBackground(Color.WHITE);
		lblNomeCurso.setVisible(false);
		lblNomeCurso.setBounds(0, 25, 300, 30);
		panel_4.add(lblNomeCurso);
		cmbCurso = new JComboBox();
		cmbCurso.setBackground(Color.WHITE);
		cmbCurso.setEnabled(false);
		cmbCurso.setModel(new DefaultComboBoxModel(aluno.curso.buscarCurso(cmbCurso).toArray()));
		cmbCurso.setBounds(0, 25, 300, 30);
		panel_4.add(cmbCurso);

		cmbUnidade = new JComboBox();
		cmbUnidade.setBorder(new LineBorder(Color.LIGHT_GRAY));
		cmbUnidade.setBackground(Color.WHITE);
		cmbUnidade.setEnabled(false);
		cmbUnidade.setModel(new DefaultComboBoxModel(new String[] {"- Selecione", "Pinheiros", "Tatuap\u00E9"}));
		cmbUnidade.setToolTipText("");
		cmbUnidade.setBounds(0, 91, 300, 30);
		panel_4.add(cmbUnidade);

		lblNome_7 = new JLabel("CAMPUS*");
		lblNome_7.setBounds(0, 66, 56, 17);
		panel_4.add(lblNome_7);
		lblNome_7.setFont(new Font("Malgun Gothic", Font.BOLD, 12));

		rdbMatutino = new JRadioButton("MATUTINO");
		rdbMatutino.setBorder(null);
		rdbMatutino.setEnabled(false);
		rdbMatutino.setBounds(0, 152, 90, 30);
		panel_4.add(rdbMatutino);
		rdbMatutino.setHorizontalAlignment(SwingConstants.CENTER);
		Periodo.add(rdbMatutino);

		rdbVespertino = new JRadioButton("VESPERTINO");
		rdbVespertino.setBorder(null);
		rdbVespertino.setEnabled(false);
		rdbVespertino.setBounds(102, 152, 95, 30);
		panel_4.add(rdbVespertino);
		Periodo.add(rdbVespertino);
		rdbVespertino.setHorizontalAlignment(SwingConstants.CENTER);

		rdbNoturno = new JRadioButton("NOTURNO");
		rdbNoturno.setBorder(null);
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
		btnNovo.setIcon(new ImageIcon(getClass().getResource("new.png")));
		btnNovo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNovo.setBorder(null);
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				txtRgm.setText(Integer.toString(aluno.geraRGM()));
				f = new FerramentasFormulario();

				if(habilitarCampos == true) {
					if (f.validaText(txtRgm, txtCpf, txtNome, txtNascimento, txtCep, txtEndereco, txtCidade) == false || f.validaCombo(cmbGenero, cmbUF, cmbCurso, cmbUnidade) == false) {
						JOptionPane.showMessageDialog(null, "Campos obrigatórios" + "\n" + "estão vazios ou não foram selecionados");
					}
					else {
						aluno = new Aluno(); //VARIAVEL ALUNO CRIADA NA LINHA 99
						aluno.setNome(txtNome.getText()); 
						aluno.setCpf(txtCpf.getText());
						aluno.setDataNascimento(txtNascimento.getText());
						aluno.setGenero(cmbGenero);
						aluno.setEmail(txtEmail.getText());
						aluno.setCelular(txtCelular.getText());
						aluno.setTelefone(txtTelefone.getText());
						aluno.setRgm(Integer.parseInt(txtRgm.getText()));
						aluno.setPeriodo(rdbMatutino, rdbVespertino, rdbNoturno);
						aluno.setCampus(cmbUnidade.getSelectedItem().toString());
						aluno.setCep(txtCep.getText());
						aluno.setEndereco(txtEndereco.getText());
						aluno.setNumero(txtNumero.getText());
						aluno.setComplemento(txtComplemento.getText());
						aluno.setBairro(txtBairro.getText());
						aluno.setCidade(txtCidade.getText());
						aluno.setUf(cmbUF.getSelectedItem().toString());
						aluno.curso.setNomeCurso(cmbCurso.getSelectedItem().toString());
						aluno.curso.buscaIdCurso();

						aluno.salvarAluno(); //MÉTODO DA CLASSE ALUNO
						disciplinasAluno = new DisciplinasAluno();
						disciplinasAluno.salvarDisciplinasAluno();

						f = new FerramentasFormulario();
						f.limparTudoAluno();
						txtRgm.setText(null);
						habilitarCampos = false;
					}
				} 
				else if(habilitarCampos == false)
				{
					f.limparTudoAluno();
					f.habilitaTudoAluno();
					txtRgm.setEnabled(false);
					txtRgm.setBorder(null);
					btnNovo.setToolTipText("Cadastrar");
					f.desabilitaComponentes(btnConsultar, btnAlterar, btnExcluir);

					habilitarCampos = true;
				}
			}
		}
				);

		/*CONSULTAR*/

		btnNovo.setMargin(new Insets(0, 0, 0, 0));
		btnNovo.setFont(new Font("Malgun Gothic", Font.PLAIN, 11));
		btnNovo.setBackground(Color.WHITE);
		btnNovo.setBounds(0, 0, 60, 60);
		panel_3.add(btnNovo);

		btnConsultar = new JButton("");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				f = new FerramentasFormulario();

				if(habilitarCampos == true) {

					int rgm = 0;

					try {
						rgm = Integer.parseInt(txtRgm.getText());					
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "RGM inválido");
						txtRgm.setText(null);
					}

					aluno = new Aluno(); //VARIAVEL ALUNO CRIADA NA LINHA 99
					aluno.setRgm(rgm);

					if(aluno.getRgm() != 0) {

						if(aluno.consultarAluno(aluno.getRgm()) == true) {

							txtCpf.setText(aluno.getCpf());
							txtNome.setText(aluno.getNome());
							txtNascimento.setText(aluno.getDataNascimento());
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
							cmbUF.setSelectedIndex(aluno.getUF(cmbUF));
							cmbCurso.setVisible(false);
							lblNomeCurso.setText(aluno.getNomeCurso());
							lblNomeCurso.setVisible(true);
							cmbCurso.setSelectedIndex(aluno.getCampus(cmbUnidade));
							aluno.getPeriodo(rdbMatutino, rdbVespertino, rdbNoturno);
							
							f.habilitaComponentes(btnAlterar, btnExcluir);

							habilitarCampos = false;
						}
						else {
							JOptionPane.showMessageDialog(null, "RGM não localizado");
							txtRgm.setText(null);
						}
					}
				}
				else {

					f.limparTudoAluno();
					f.desabilitaTudo();
					f.desabilitaComponentes(btnAlterar, btnExcluir, btnNovo);
					txtRgm.setBorder(new LineBorder(Color.BLUE));
					txtRgm.setEnabled(true);
					txtRgm.setText(null);

					habilitarCampos = true;
				}
			}
		});
		btnConsultar.setBorderPainted(false);
		btnConsultar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConsultar.setBorder(null);
		btnConsultar.setIcon(new ImageIcon(getClass().getResource("search.png")));
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

				txtRgm.setBorder(null);

				if(habilitarCampos == true) {

					aluno.setNome(txtNome.getText()); 
					aluno.setCpf(txtCpf.getText());
					aluno.setDataNascimento(txtNascimento.getText());
					aluno.setGenero(cmbGenero);
					aluno.setEmail(txtEmail.getText());
					aluno.setCelular(txtCelular.getText());
					aluno.setTelefone(txtTelefone.getText());
					aluno.setRgm(Integer.parseInt(txtRgm.getText()));
					aluno.setPeriodo(rdbMatutino, rdbVespertino, rdbNoturno);
					aluno.setCep(txtCep.getText());
					aluno.setEndereco(txtEndereco.getText());
					aluno.setNumero(txtNumero.getText());
					aluno.setComplemento(txtComplemento.getText());
					aluno.setBairro(txtBairro.getText());
					aluno.setCidade(txtCidade.getText());
					aluno.setUf(cmbUF.getSelectedItem().toString());
					aluno.setCampus(cmbUnidade.getSelectedItem().toString());

					aluno.alteraeAluno();
					f = new FerramentasFormulario();
					f.desabilitaTudo();
					f.habilitaComponentes(btnNovo, btnConsultar);
					habilitarCampos = false;
				}

				else {
					f = new FerramentasFormulario();
					f.habilitaTudoAluno();
					f.desabilitaComponentes(btnConsultar);
					txtRgm.setEnabled(false);
					txtRgm.setBorder(null);
					habilitarCampos = true;
				}

			}
		});
		btnAlterar.setIcon(new ImageIcon(getClass().getResource("edit.png")));
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
				f = new FerramentasFormulario();
				f.limparTudoAluno();
				lblNomeCurso.setText(null);
				lblNomeCurso.setVisible(false);
				txtRgm.setText(null);
			}
		});

		btnExcluir.setIcon(new ImageIcon(getClass().getResource("delete.png")));
		btnExcluir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExcluir.setBorder(null);
		btnExcluir.setToolTipText("Excluir");
		btnExcluir.setFont(new Font("Malgun Gothic", Font.PLAIN, 11));
		btnExcluir.setMargin(new Insets(0, 0, 0, 0));
		btnExcluir.setBackground(Color.WHITE);
		btnExcluir.setBounds(210, 0, 60, 60);
		panel_3.add(btnExcluir);

		/*CANCELAR*/

		btnCancelar = new JButton("");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				f = new FerramentasFormulario();
				f.limparTudoAluno();
				f.resetCombo(cmbCurso, cmbUF, cmbUnidade, cmbGenero);
				f.desabilitaTudo();
				f.habilitaComponentes(btnCancelar, btnConsultar, btnNovo);
				txtRgm.setBorder(new LineBorder(Color.LIGHT_GRAY));
				txtRgm.setText(null);
				lblNomeCurso.setText(null);
				lblNomeCurso.setVisible(false);
				
				habilitarCampos = false;

			}
		});
		btnCancelar.setToolTipText("Cancelar");
		btnCancelar.setIcon(new ImageIcon(getClass().getResource("cancel.png")));
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setBorder(null);
		btnCancelar.setFont(new Font("Malgun Gothic", Font.PLAIN, 11));
		btnCancelar.setMargin(new Insets(0, 0, 0, 0));
		btnCancelar.setBackground(Color.WHITE);
		btnCancelar.setBounds(280, 0, 60, 60);
		panel_3.add(btnCancelar);


	}
}
