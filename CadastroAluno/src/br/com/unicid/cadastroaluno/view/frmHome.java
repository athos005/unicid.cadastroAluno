package br.com.unicid.cadastroaluno.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.sun.glass.ui.Window;
import com.sun.org.apache.bcel.internal.generic.FMUL;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Window.Type;
import java.awt.Frame;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.Cursor;

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

	public String local;
	public JMenuItem mntmNewMenuItem;
	public JMenuItem mntmNewMenuItem_1;
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
		menuBar.setBorder(null);
		menuBar.setBackground(Color.LIGHT_GRAY);
		setJMenuBar(menuBar);

		mnAluno = new JMenu("ALUNO");
		mnAluno.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnAluno.setFont(new Font("Malgun Gothic", Font.BOLD, 14));
		mnAluno.setBorder(null);
		menuBar.add(mnAluno);

		mntmSalvar = new JMenuItem("Novo");
		mntmSalvar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mntmSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					FerramentasFormulario f = new FerramentasFormulario();
					frmAluno novoAluno = new frmAluno();
					novoAluno.txtRgm.setText(Integer.toString(novoAluno.aluno.geraRGM()));
					if(novoAluno.habilitarCampos == false)
					{
						f.limparTudoAluno();
						f.habilitaTudoAluno();
						novoAluno.txtRgm.setEnabled(false);
						novoAluno.txtRgm.setBorder(null);
						novoAluno.btnNovo.setToolTipText("Cadastrar");
						f.desabilitaComponentes(novoAluno.btnConsultar, novoAluno.btnAlterar, novoAluno.btnExcluir);

						novoAluno.habilitarCampos = true;
					}

					novoAluno.setLocationRelativeTo(null);
					novoAluno.setVisible(true);

				} catch (ParseException e) {

					e.printStackTrace();
				}
			}
		});
		mnAluno.add(mntmSalvar);

		mntmConsultar = new JMenuItem("Consultar");
		mntmConsultar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mntmConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					FerramentasFormulario f = new FerramentasFormulario();
					frmAluno novoAluno = new frmAluno();

					if(novoAluno.habilitarCampos == false) {
						
						f.limparTudoAluno();
						f.desabilitaTudo();
						f.desabilitaComponentes(novoAluno.btnAlterar, novoAluno.btnExcluir, novoAluno.btnNovo);
						novoAluno.txtRgm.setBorder(new LineBorder(Color.BLUE));
						novoAluno.txtRgm.setEnabled(true);
						novoAluno.txtRgm.setText(null);
						novoAluno.habilitarCampos = true;
						local = "consultar";
					}
					
					novoAluno.setLocationRelativeTo(null);
					novoAluno.setVisible(true);

				} catch (ParseException e1) {

					e1.printStackTrace();
				}
			}
		});
		mnAluno.add(mntmConsultar);

		mntmAlterar = new JMenuItem("Alterar");
		mntmAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {

					FerramentasFormulario f = new FerramentasFormulario();
					frmAluno novoAluno = new frmAluno();

					if(novoAluno.habilitarCampos == false) {
						
						f.limparTudoAluno();
						f.desabilitaTudo();
						f.desabilitaComponentes(novoAluno.btnAlterar, novoAluno.btnExcluir, novoAluno.btnNovo);
						novoAluno.txtRgm.setBorder(new LineBorder(Color.BLUE));
						novoAluno.txtRgm.setEnabled(true);
						novoAluno.txtRgm.setText(null);
						novoAluno.habilitarCampos = true;
						local = "consultar";
					}
					
					novoAluno.setLocationRelativeTo(null);
					novoAluno.setVisible(true);

				} catch (ParseException e1) {

					e1.printStackTrace();
				}
				
			}
		});
		mnAluno.add(mntmAlterar);

		mntmExcluir = new JMenuItem("Excluir");
		mntmExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					FerramentasFormulario f = new FerramentasFormulario();
					frmAluno novoAluno = new frmAluno();

					if(novoAluno.habilitarCampos == false) {
						
						f.limparTudoAluno();
						f.desabilitaTudo();
						f.desabilitaComponentes(novoAluno.btnAlterar, novoAluno.btnExcluir, novoAluno.btnNovo);
						novoAluno.txtRgm.setBorder(new LineBorder(Color.BLUE));
						novoAluno.txtRgm.setEnabled(true);
						novoAluno.txtRgm.setText(null);
						novoAluno.habilitarCampos = true;
						local = "consultar";
					}
					
					novoAluno.setLocationRelativeTo(null);
					novoAluno.setVisible(true);

				} catch (ParseException e1) {

					e1.printStackTrace();
				}
			}
		});
		mnAluno.add(mntmExcluir);

		mnNotasEFaltas = new JMenu("NOTAS & FALTAS");
		mnNotasEFaltas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnNotasEFaltas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		mnNotasEFaltas.setFont(new Font("Malgun Gothic", Font.BOLD, 14));
		mnNotasEFaltas.setBorder(null);
		menuBar.add(mnNotasEFaltas);
		
		mntmNewMenuItem = new JMenuItem("Cadastrar/Consultar");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmNotasFaltas notasEfaltas = new frmNotasFaltas();
				notasEfaltas.setLocationRelativeTo(null);
				notasEfaltas.setVisible(true);
			}
		});
		mnNotasEFaltas.add(mntmNewMenuItem);

		mnAjuda = new JMenu("AJUDA");
		mnAjuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		mnAjuda.setFont(new Font("Malgun Gothic", Font.BOLD, 14));
		mnAjuda.setBorder(null);
		menuBar.add(mnAjuda);
		
		mntmNewMenuItem_1 = new JMenuItem("Suporte");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Entre em contato no e-mail \n athosphelipe005@gmail.com");
			}
		});
		mnAjuda.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
