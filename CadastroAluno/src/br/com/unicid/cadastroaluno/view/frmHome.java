package br.com.unicid.cadastroaluno.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.org.apache.bcel.internal.generic.FMUL;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Window.Type;
import java.awt.Frame;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class frmHome extends JFrame {

	private JPanel contentPane;
	public JMenuBar menuBar;
	public JMenu mnAluno;
	public JMenu mnAjuda;
	public JMenuItem mntmSalvar;
	public JMenuItem mntmAlterar;
	public JMenuItem mntmConsultar;
	public JMenuItem mntmExcluir;
	public JMenu mnNotasEFaltas;
	public JMenuItem mntmSalvar_1;
	public JMenuItem mntmAlterar_1;
	public JMenuItem mntmConsultar_1;
	public JMenuItem mntmExcluir_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmHome frame = new frmHome();
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH); //Inicializa o formulário Máximazido
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmHome() {
		setTitle("Cadastro Aluno");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 471);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnAluno = new JMenu("Aluno");
		menuBar.add(mnAluno);

		mntmSalvar = new JMenuItem("Novo");
		mntmSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					FerramentasFormulario f = new FerramentasFormulario();
					frmAluno novoAluno = new frmAluno();
					novoAluno.setVisible(true);
					f.desabilitaComponentes(novoAluno.btnAlterar, novoAluno.btnConsultar, novoAluno.btnExcluir);

				} catch (ParseException e) {

					e.printStackTrace();
				}
			}
		});
		mnAluno.add(mntmSalvar);

		mntmConsultar = new JMenuItem("Consultar");
		mntmConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					FerramentasFormulario f = new FerramentasFormulario();
					frmAluno novoAluno = new frmAluno();
					novoAluno.setVisible(true);
					f.desabilitaComponentes(novoAluno.btnAlterar, novoAluno.btnNovo, novoAluno.btnExcluir);

				} catch (ParseException e1) {

					e1.printStackTrace();
				}
			}
		});
		mnAluno.add(mntmConsultar);

		mntmAlterar = new JMenuItem("Alterar");
		mnAluno.add(mntmAlterar);

		mntmExcluir = new JMenuItem("Excluir");
		mnAluno.add(mntmExcluir);

		mnNotasEFaltas = new JMenu("Notas e Faltas");
		menuBar.add(mnNotasEFaltas);

		mntmSalvar_1 = new JMenuItem("Cadastrar");
		mnNotasEFaltas.add(mntmSalvar_1);

		mntmAlterar_1 = new JMenuItem("Alterar");
		mnNotasEFaltas.add(mntmAlterar_1);

		mntmConsultar_1 = new JMenuItem("Consultar");
		mnNotasEFaltas.add(mntmConsultar_1);

		mntmExcluir_1 = new JMenuItem("Excluir");
		mnNotasEFaltas.add(mntmExcluir_1);

		mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
