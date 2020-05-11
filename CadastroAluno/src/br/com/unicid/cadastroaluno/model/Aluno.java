package br.com.unicid.cadastroaluno.model;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import br.com.unicid.cadastroaluno.DAO.AlunoDAO;
import br.com.unicid.cadastroaluno.DAO.CursoDAO;
import br.com.unicid.cadastroaluno.DAO.DisciplinaDAO;
import br.com.unicid.cadastroaluno.view.frmAluno;

public class Aluno extends Pessoa{

	/*ATRIBUTOS*/
	/*------------------------------------*/

	private int rgm;
	private String nomeCurso;
	private String periodo;
	private String campus;
	public Curso curso;
	public DisciplinasAluno disciplinasAluno;
	private AlunoDAO DAOaluno;
	private CursoDAO cursoDAO;

	/*CONSTRUTORES*/
	/*------------------------------------*/

	public Aluno() {
		curso = new Curso();
		disciplinasAluno = new DisciplinasAluno();
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

	public int getCampus(JComboBox combo) {

		int index = 0;

		if(this.campus == "Pinheiros") {
			index = 1;
		} else {
			index = 2;
		}

		combo.setSelectedIndex(index);

		return index;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	public String getPeriodo() {
		return this.periodo;
	}

	public void getPeriodo(JRadioButton matutino, JRadioButton vespertino, JRadioButton noturno) {

		String periodo = this.periodo;	

		if(periodo.equals("Matutino")) {
			matutino.setSelected(true);
		}
		else 
			if(periodo.equals("Vespertino")) {
				vespertino.setSelected(true);
			}
			else 
				if(periodo.equals("Noturno")) {
					noturno.setSelected(true);
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

	public boolean consultarAluno(int rgmAluno){

		boolean verificaConsulta = false;

		try {
			DAOaluno = new AlunoDAO();
			if(DAOaluno.consultarAluno(rgmAluno) == null) {
				verificaConsulta = false;
			}
			else {
				DAOaluno.consultarAluno(rgmAluno);
				connsultarCadastro();

				cursoDAO = new CursoDAO();
				setNomeCurso(cursoDAO.getNomeCurso(frmAluno.aluno.curso.getCodCurso()));
				verificaConsulta = true;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return verificaConsulta;
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

			DisciplinasAluno disciplina = new DisciplinasAluno();
			disciplina.excluirNotas(rgmAluno);

			DAOaluno = new AlunoDAO();
			DAOaluno.excluirAluno(rgmAluno);
			excluirCadastrato();

			JOptionPane.showMessageDialog(null, "Excluido com Sucesso");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int geraRGM() {

		int rgm = 0;

		try {
			DAOaluno = new AlunoDAO();
			rgm = DAOaluno.geraRGM();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rgm;
	}
}
