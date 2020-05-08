package br.com.unicid.cadastroaluno.model;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import br.com.unicid.cadastroaluno.DAO.AlunoDAO;
import br.com.unicid.cadastroaluno.DAO.CursoDAO;
import br.com.unicid.cadastroaluno.view.frmAluno;

public class Aluno extends Pessoa{

	/*ATRIBUTOS*/
	/*------------------------------------*/

	private int rgm;
	private String nomeCurso;
	private String periodo;
	private String campus;
	public Curso curso;
	private AlunoDAO DAOaluno;
	private CursoDAO cursoDAO;

	/*CONSTRUTORES*/
	/*------------------------------------*/

	public Aluno() {
		curso = new Curso();
	}

	public Aluno(String nomeAluno, String cpfAluno){
		super(nomeAluno, cpfAluno);
		curso = new Curso();
	}

	/*GETTERS & SETTERS*/
	/*------------------------------------*/

	public int getRgm() {
		return rgm;
	}

	public void setRgm(int rgm) {
		this.rgm = rgm;
	}

	public String getNomeCurso() {
		return this.nomeCurso;
	} 

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public String getCampus() {
		return this.campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	public String getPeriodo() {
		return this.periodo;
	}

	public void getPeriodo(JRadioButton matutino, JRadioButton vespertino, JRadioButton noturno) {

		boolean selecionado = true;


		if(periodo == "Matutino") {
			matutino.setSelected(selecionado);
		}
		else 
			if(periodo == "Vespertino") {
				vespertino.setSelected(selecionado);
			}
			else 
				if(periodo == "Noturno") {
					noturno.setSelected(selecionado);
				}

	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public void setPeriodo(JRadioButton matutino, JRadioButton vespertino, JRadioButton noturno) {

		if(matutino.isSelected()) {
			this.periodo = "Matutino";
		} else 
			if(vespertino.isSelected()) {
				this.periodo = "Vespertino";
			} else 
				if(noturno.isSelected()) {
					this.periodo = "Noturno";
				}
	}

	/*MÉTODOS DA CLASSE*/

	public void salvarAluno() {

		try {
			salvarCadastro();
			DAOaluno = new AlunoDAO();
			DAOaluno.salvarAluno(frmAluno.aluno);
			JOptionPane.showMessageDialog(null, "Salvo com Sucesso");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* O método salvarAluno() deve criar um Objeto do tipo AlunoDAO() e utilizar o método salvarAluno() da classe AlunoDAO.
	 * O método salvarAluno(), da classe AlunoDAO, deve recer um objeto do tipo Aluno(), 
	 * que neste caso foi criado no formulário frmAluno, para receber
	 * as informações que foram setadas nos atributos da classe Aluno.
	 */

	public void consultarAluno(int rgmAluno){

		try {
			DAOaluno = new AlunoDAO();
			DAOaluno.consultarAluno(rgmAluno);
			connsultarCadastro();
			//System.out.println(frmAluno.aluno.curso.getCodCurso());
			cursoDAO = new CursoDAO();
			cursoDAO.getNomeCurso(frmAluno.aluno.curso.getCodCurso());
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void alteraeAluno(){

		try {
			alterarCadastro();
			DAOaluno = new AlunoDAO();
			DAOaluno.alterarAluno(frmAluno.aluno);
			JOptionPane.showMessageDialog(null, "Alterado com Sucesso");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluirAluno(int rgmAluno){

		try {
			DAOaluno = new AlunoDAO();
			DAOaluno.excluirAluno(rgmAluno);
			excluirCadastrato();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
