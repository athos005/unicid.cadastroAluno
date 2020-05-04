package br.com.unicid.cadastroaluno.view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.ImageIcon;
import java.awt.Cursor;

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
	public JPanel panel_1;
	public JButton btnNovo;
	public JButton btnConsultar;
	public JButton btnAlterar;
	public JButton btnExcluir;
	public JButton btnCancelar;

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
		setTitle("Notas & Faltas");
		setMinimumSize(new Dimension(450, 600));
		setMaximumSize(new Dimension(450, 600));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 535);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(47, 11, 350, 450);
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
		pnlBoletim.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(52, 472, 340, 60);
		contentPane.add(panel_1);
		
		btnNovo = new JButton("");
		btnNovo.setSelectedIcon(new ImageIcon("C:\\Users\\athos\\Google Drive\\Analise e desenvolvimento de sistemas\\3\u00BA Semestre\\Tecnicas de Programa\u00E7\u00E3o\\cadastro_alunos\\unicid.cadastroAluno\\CadastroAluno\\icons\\new.png"));
		btnNovo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNovo.setToolTipText("Novo");
		btnNovo.setMargin(new Insets(0, 0, 0, 0));
		btnNovo.setFont(new Font("Malgun Gothic", Font.PLAIN, 11));
		btnNovo.setBorder(null);
		btnNovo.setBackground(Color.WHITE);
		btnNovo.setBounds(0, 0, 60, 60);
		panel_1.add(btnNovo);
		
		btnConsultar = new JButton("");
		btnConsultar.setSelectedIcon(new ImageIcon("C:\\Users\\athos\\Google Drive\\Analise e desenvolvimento de sistemas\\3\u00BA Semestre\\Tecnicas de Programa\u00E7\u00E3o\\cadastro_alunos\\unicid.cadastroAluno\\CadastroAluno\\icons\\search.png"));
		btnConsultar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConsultar.setIcon(new ImageIcon("C:\\Users\\athos\\Google Drive\\Analise e desenvolvimento de sistemas\\3\u00BA Semestre\\Tecnicas de Programa\u00E7\u00E3o\\cadastro_alunos\\unicid.cadastroAluno\\CadastroAluno\\icons\\search.png"));
		btnConsultar.setToolTipText("Pesquisar");
		btnConsultar.setMargin(new Insets(0, 0, 0, 0));
		btnConsultar.setFont(new Font("Malgun Gothic", Font.PLAIN, 11));
		btnConsultar.setBorderPainted(false);
		btnConsultar.setBorder(null);
		btnConsultar.setBackground(Color.WHITE);
		btnConsultar.setBounds(70, 0, 60, 60);
		panel_1.add(btnConsultar);
		
		btnAlterar = new JButton("");
		btnAlterar.setSelectedIcon(new ImageIcon("C:\\Users\\athos\\Google Drive\\Analise e desenvolvimento de sistemas\\3\u00BA Semestre\\Tecnicas de Programa\u00E7\u00E3o\\cadastro_alunos\\unicid.cadastroAluno\\CadastroAluno\\icons\\edit.png"));
		btnAlterar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAlterar.setIcon(new ImageIcon("C:\\Users\\athos\\Google Drive\\Analise e desenvolvimento de sistemas\\3\u00BA Semestre\\Tecnicas de Programa\u00E7\u00E3o\\cadastro_alunos\\unicid.cadastroAluno\\CadastroAluno\\icons\\edit.png"));
		btnAlterar.setToolTipText("Alterar");
		btnAlterar.setMargin(new Insets(0, 0, 0, 0));
		btnAlterar.setFont(new Font("Malgun Gothic", Font.PLAIN, 11));
		btnAlterar.setBorder(null);
		btnAlterar.setBackground(Color.WHITE);
		btnAlterar.setBounds(140, 0, 60, 60);
		panel_1.add(btnAlterar);
		
		btnExcluir = new JButton("");
		btnExcluir.setSelectedIcon(new ImageIcon("C:\\Users\\athos\\Google Drive\\Analise e desenvolvimento de sistemas\\3\u00BA Semestre\\Tecnicas de Programa\u00E7\u00E3o\\cadastro_alunos\\unicid.cadastroAluno\\CadastroAluno\\icons\\delete.png"));
		btnExcluir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExcluir.setIcon(new ImageIcon("C:\\Users\\athos\\Google Drive\\Analise e desenvolvimento de sistemas\\3\u00BA Semestre\\Tecnicas de Programa\u00E7\u00E3o\\cadastro_alunos\\unicid.cadastroAluno\\CadastroAluno\\icons\\delete.png"));
		btnExcluir.setToolTipText("Excluir");
		btnExcluir.setMargin(new Insets(0, 0, 0, 0));
		btnExcluir.setFont(new Font("Malgun Gothic", Font.PLAIN, 11));
		btnExcluir.setBorder(null);
		btnExcluir.setBackground(Color.WHITE);
		btnExcluir.setBounds(210, 0, 60, 60);
		panel_1.add(btnExcluir);
		
		btnCancelar = new JButton("");
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setIcon(new ImageIcon("C:\\Users\\athos\\Google Drive\\Analise e desenvolvimento de sistemas\\3\u00BA Semestre\\Tecnicas de Programa\u00E7\u00E3o\\cadastro_alunos\\unicid.cadastroAluno\\CadastroAluno\\icons\\cancel.png"));
		btnCancelar.setToolTipText("Cancelar");
		btnCancelar.setMargin(new Insets(0, 0, 0, 0));
		btnCancelar.setFont(new Font("Malgun Gothic", Font.PLAIN, 11));
		btnCancelar.setBorder(null);
		btnCancelar.setBackground(Color.WHITE);
		btnCancelar.setBounds(280, 0, 60, 60);
		panel_1.add(btnCancelar);
	}
}
