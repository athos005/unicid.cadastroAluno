package br.com.unicid.cadastroaluno.view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import br.com.unicid.cadastroaluno.model.Aluno;
import br.com.unicid.cadastroaluno.model.Disciplina;
import br.com.unicid.cadastroaluno.model.DisciplinasAluno;
import br.com.unicid.cadastroaluno.model.Pessoa;
import jdk.nashorn.internal.ir.BreakableNode;

import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.JTextArea;
import java.awt.TextArea;
import javax.swing.JFormattedTextField;
import java.awt.ComponentOrientation;

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
	public JSpinner txtFaltas;
	public JLabel lblNome_3;
	public JTextField txtNota;
	public JLabel lblNota;
	public JPanel panel;
	public JPanel pnlBoletim;
	public JPanel panel_1;
	public JButton btnSalvar;
	public JButton btnConsultar;
	public JButton btnCancelar;
	public JLabel lblNewLabel_1;
	public JLabel lblNome_4;
	public JLabel lblDisciplina_1;
	public JLabel lblNomeAluno;
	public JLabel lblRgm;
	public JLabel lblCurso;
	public JLabel lblNome_5;
	public JLabel lblNome_6;
	public JLabel lblCampus;
	public JLabel lblPeriodo;
	public TextArea txtBoletim;

	public static Pessoa pessoa;
	public static Disciplina disciplina;
	public static DisciplinasAluno disciplinaAluno;
	private FerramentasFormulario f;
	protected boolean habilitarCampos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmNotasFaltas frame = new frmNotasFaltas();
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
	 */
	public frmNotasFaltas() {
		setTitle("Notas & Faltas");
		setMinimumSize(new Dimension(450, 600));
		setMaximumSize(new Dimension(450, 600));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		pnlNotasFaltas.setBackground(new Color(240, 240, 240));
		tabbedPane.addTab("NOTAS E FALTAS", null, pnlNotasFaltas, null);
		pnlNotasFaltas.setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(240, 240, 240));
		panel.setBounds(22, 10, 300, 385);
		pnlNotasFaltas.add(panel);
		panel.setLayout(null);

		lblNewLabel = new JLabel("RGM");
		lblNewLabel.setBounds(0, 0, 29, 17);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Malgun Gothic", Font.BOLD, 12));

		txtRgm = new JTextField();
		txtRgm.setBorder(new LineBorder(new Color(0, 0, 255)));
		txtRgm.setBounds(0, 25, 150, 30);
		panel.add(txtRgm);
		txtRgm.setColumns(10);

		lblNome = new JLabel("NOME");
		lblNome.setBounds(0, 66, 37, 17);
		panel.add(lblNome);
		lblNome.setFont(new Font("Malgun Gothic", Font.BOLD, 12));

		txtNome = new JTextField();
		txtNome.setBorder(new LineBorder(Color.LIGHT_GRAY));
		txtNome.setDisabledTextColor(Color.GRAY);
		txtNome.setEnabled(false);
		txtNome.setBounds(0, 91, 300, 30);
		panel.add(txtNome);
		txtNome.setColumns(10);

		lblDisciplina = new JLabel("CURSO");
		lblDisciplina.setBounds(0, 132, 41, 17);
		panel.add(lblDisciplina);
		lblDisciplina.setFont(new Font("Malgun Gothic", Font.BOLD, 12));

		txtCurso = new JTextField();
		txtCurso.setBorder(new LineBorder(Color.LIGHT_GRAY));
		txtCurso.setDisabledTextColor(Color.GRAY);
		txtCurso.setEnabled(false);
		txtCurso.setBounds(0, 157, 300, 30);
		panel.add(txtCurso);
		txtCurso.setColumns(10);

		cmbDiscplina = new JComboBox();
		cmbDiscplina.setBorder(new LineBorder(Color.LIGHT_GRAY));
		cmbDiscplina.setEnabled(false);
		cmbDiscplina.setModel(new DefaultComboBoxModel(new String[] {"Selecione -"}));
		cmbDiscplina.setBackground(Color.WHITE);
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
		cmbSemestre.setBorder(new LineBorder(Color.LIGHT_GRAY));
		cmbSemestre.setEnabled(false);
		cmbSemestre.setModel(new DefaultComboBoxModel(new String[] {"Selecione -", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10"}));
		cmbSemestre.setBackground(Color.WHITE);
		cmbSemestre.setBounds(0, 289, 150, 30);
		panel.add(cmbSemestre);

		txtFaltas = new JSpinner();
		txtFaltas.setBorder(new LineBorder(Color.LIGHT_GRAY));
		txtFaltas.setEnabled(false);
		txtFaltas.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		txtFaltas.setBounds(80, 355, 70, 30);
		panel.add(txtFaltas);

		lblNome_3 = new JLabel("FALTAS");
		lblNome_3.setBounds(80, 330, 42, 17);
		panel.add(lblNome_3);
		lblNome_3.setFont(new Font("Malgun Gothic", Font.BOLD, 12));

		txtNota = new JTextField();
		txtNota.setBorder(new LineBorder(Color.LIGHT_GRAY));
		txtNota.setEnabled(false);
		txtNota.setBackground(Color.WHITE);
		txtNota.setBounds(0, 355, 70, 30);
		panel.add(txtNota);
		txtNota.setColumns(10);

		lblNota = new JLabel("NOTA");
		lblNota.setBounds(0, 330, 34, 17);
		panel.add(lblNota);
		lblNota.setFont(new Font("Malgun Gothic", Font.BOLD, 12));

		pnlBoletim = new JPanel();
		pnlBoletim.setBackground(Color.WHITE);
		tabbedPane.addTab("BOLETIM", null, pnlBoletim, null);
		tabbedPane.setEnabledAt(1, false);
		pnlBoletim.setLayout(null);

		lblNewLabel_1 = new JLabel("RGM");
		lblNewLabel_1.setFont(new Font("Malgun Gothic", Font.BOLD, 12));
		lblNewLabel_1.setBounds(34, 41, 29, 17);
		pnlBoletim.add(lblNewLabel_1);

		lblNome_4 = new JLabel("NOME");
		lblNome_4.setFont(new Font("Malgun Gothic", Font.BOLD, 12));
		lblNome_4.setBounds(26, 12, 37, 17);
		pnlBoletim.add(lblNome_4);

		lblDisciplina_1 = new JLabel("CURSO");
		lblDisciplina_1.setFont(new Font("Malgun Gothic", Font.BOLD, 12));
		lblDisciplina_1.setBounds(22, 70, 41, 17);
		pnlBoletim.add(lblDisciplina_1);

		lblNomeAluno = new JLabel("");
		lblNomeAluno.setBackground(Color.WHITE);
		lblNomeAluno.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNomeAluno.setBounds(73, 13, 260, 16);
		pnlBoletim.add(lblNomeAluno);

		lblRgm = new JLabel("");
		lblRgm.setBackground(Color.WHITE);
		lblRgm.setFont(new Font("Arial", Font.PLAIN, 12));
		lblRgm.setBounds(73, 42, 117, 16);
		pnlBoletim.add(lblRgm);

		lblCurso = new JLabel("");
		lblCurso.setBackground(Color.WHITE);
		lblCurso.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCurso.setBounds(73, 71, 260, 16);
		pnlBoletim.add(lblCurso);

		lblNome_5 = new JLabel("PER\u00CDODO");
		lblNome_5.setFont(new Font("Malgun Gothic", Font.BOLD, 12));
		lblNome_5.setBounds(137, 99, 52, 17);
		pnlBoletim.add(lblNome_5);

		lblNome_6 = new JLabel("CAMPUS");
		lblNome_6.setFont(new Font("Malgun Gothic", Font.BOLD, 12));
		lblNome_6.setBounds(12, 99, 51, 17);
		pnlBoletim.add(lblNome_6);

		lblCampus = new JLabel("");
		lblCampus.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCampus.setBackground(Color.WHITE);
		lblCampus.setBounds(73, 100, 75, 16);
		pnlBoletim.add(lblCampus);

		lblPeriodo = new JLabel("");
		lblPeriodo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblPeriodo.setBackground(Color.WHITE);
		lblPeriodo.setBounds(201, 100, 75, 16);
		pnlBoletim.add(lblPeriodo);

		txtBoletim = new TextArea();
		txtBoletim.setForeground(Color.BLACK);
		txtBoletim.setBackground(Color.WHITE);
		txtBoletim.setEditable(false);
		txtBoletim.setBounds(10, 122, 325, 288);
		pnlBoletim.add(txtBoletim);

		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(52, 472, 340, 60);
		contentPane.add(panel_1);

		btnSalvar = new JButton("");
		btnSalvar.setEnabled(false);
		btnSalvar.setIcon(new ImageIcon(getClass().getResource("save.png")));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				f = new FerramentasFormulario();
				
				double nota = 0.0;
				boolean validaNota;
				String n = txtNota.getText().replaceAll(",", ".");

				try {
					nota = Double.parseDouble(n);
					validaNota = true;
				} catch (Exception e) {
					validaNota = false;
				}
				if(f.validaCombo(cmbDiscplina, cmbSemestre) == false) {
					JOptionPane.showMessageDialog(null, "\tCampos obrigatórios" + "\n" + "não foram selecionados");
				}
				else {

				} if(nota < 0 || nota > 10 || validaNota == false) {
					JOptionPane.showMessageDialog(null, "Nota inválida!" + "\n" + "Digite novamente");
					txtNota.setText(null);
				}
				else {
					disciplina = new Disciplina();
					disciplina.setCodDisciplina(cmbDiscplina.getSelectedItem().toString());
					disciplina.setNomeDisciplina(cmbDiscplina.getSelectedItem().toString());
					disciplina.setNotaDisciplina(nota);
					disciplina.setFaltasDisciplina(Integer.parseInt(txtFaltas.getValue().toString()));
					disciplina.setSemestre(cmbSemestre.getSelectedItem().toString());
					disciplinaAluno = new DisciplinasAluno();
					disciplinaAluno.salvarNotaFaltas();
					txtBoletim.setText(null);
					disciplinaAluno = new DisciplinasAluno();
					disciplinaAluno.exbirNotasFaltas(txtBoletim);
				}
			}
		});
		btnSalvar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSalvar.setToolTipText("Salvar");
		btnSalvar.setMargin(new Insets(0, 0, 0, 0));
		btnSalvar.setFont(new Font("Malgun Gothic", Font.PLAIN, 11));
		btnSalvar.setBorder(null);
		btnSalvar.setBackground(Color.WHITE);
		btnSalvar.setBounds(136, 1, 60, 60);
		panel_1.add(btnSalvar);

		btnConsultar = new JButton("");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int rgm = 0;

				try {
					rgm = Integer.parseInt(txtRgm.getText());					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "RGM inválido");
					txtRgm.setText(null);
				}

				frmAluno.aluno = new Aluno();
				frmAluno.aluno.setRgm(rgm);

				if(frmAluno.aluno.getRgm() != 0) {

					if(frmAluno.aluno.consultarAluno(frmAluno.aluno.getRgm()) == true) {

						txtNome.setText(frmAluno.aluno.getNome());
						txtCurso.setText(frmAluno.aluno.curso.getNomeCurso());
						cmbDiscplina.setModel(new DefaultComboBoxModel(frmAluno.aluno.curso.buscarDisciplinas(cmbDiscplina).toArray()));

						lblNomeAluno.setText(frmAluno.aluno.getNome());
						lblRgm.setText(Integer.toString(frmAluno.aluno.getRgm()));
						lblCurso.setText(frmAluno.aluno.curso.getNomeCurso());
						lblCampus.setText(frmAluno.aluno.getCampus());
						lblPeriodo.setText(frmAluno.aluno.getPeriodo());

						disciplinaAluno = new DisciplinasAluno();
						disciplinaAluno.exbirNotasFaltas(txtBoletim);

						f = new FerramentasFormulario();
						f.habilitaComponentes(cmbDiscplina, cmbSemestre);

						f.habilitaComponentes(txtNota);
						txtFaltas.setEnabled(true);
						btnSalvar.setEnabled(true);
						tabbedPane.setEnabledAt(1, true);


					} else {
						JOptionPane.showMessageDialog(null, "RGM não localizado");
						txtRgm.setText(null);
					}
				}
			}
		}
				);
		btnConsultar.setSelectedIcon(new ImageIcon());
		btnConsultar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConsultar.setIcon(new ImageIcon(getClass().getResource("search.png")));
		btnConsultar.setToolTipText("Pesquisar");
		btnConsultar.setMargin(new Insets(0, 0, 0, 0));
		btnConsultar.setFont(new Font("Malgun Gothic", Font.PLAIN, 11));
		btnConsultar.setBorderPainted(false);
		btnConsultar.setBorder(null);
		btnConsultar.setBackground(Color.WHITE);
		btnConsultar.setBounds(208, 1, 60, 60);
		panel_1.add(btnConsultar);

		btnCancelar = new JButton("");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f = new FerramentasFormulario();
				f.limpaComponentes(txtRgm, txtNota, txtNome, txtCurso);
				f.resetCombo(cmbDiscplina, cmbSemestre);
				f.desabilitaComponentes(cmbDiscplina, cmbSemestre);
				f.desabilitaComponentes(txtNota);
				txtFaltas.setEnabled(false);
				txtFaltas.setValue(0);
			}
		});
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setIcon(new ImageIcon(getClass().getResource("cancel.png")));
		btnCancelar.setToolTipText("Cancelar");
		btnCancelar.setMargin(new Insets(0, 0, 0, 0));
		btnCancelar.setFont(new Font("Malgun Gothic", Font.PLAIN, 11));
		btnCancelar.setBorder(null);
		btnCancelar.setBackground(Color.WHITE);
		btnCancelar.setBounds(280, 0, 60, 60);
		panel_1.add(btnCancelar);
	}
}
