package br.com.unicid.cadastroaluno.model;

import javax.swing.JRadioButton;

import com.mysql.cj.jdbc.exceptions.NotUpdatable;

import br.com.unicid.cadastroaluno.DAO.AlunoDAO;
import br.com.unicid.cadastroaluno.view.frmAluno;

public class Aluno extends Pessoa{

	/*ATRIBUTOS*/
	/*------------------------------------*/

	private int rgm;
	private String nomeCurso;
	private String periodo;
	private String campus;
	private String nomeDisciplinaAluno;
	private String notaDisciplinaAluno;
	private int faltasDisciplinaAluno;
	private int codPessoa;

	/*CONSTRUTORES*/
	/*------------------------------------*/

	public Aluno() {

	}

	public Aluno(String nomeAluno, String cpfAluno){
		super(nomeAluno, cpfAluno);
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

	public boolean getPeriodo(JRadioButton matutino, JRadioButton vespertino, JRadioButton noturno) {

		boolean selecionado = true;
		String periodo = this.periodo;

		if(periodo == "Matutino") {
			matutino.isSelected();
		}
		else 
			if(periodo == "Vespertino") {
				vespertino.isSelected();
			}
			else 
				if(periodo == "Noturno") {
					noturno.isSelected();
				}

		return selecionado;
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

	public String getNomeDisciplina() {
		return nomeDisciplinaAluno;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplinaAluno = nomeDisciplina;
	}

	public String getNotaDisciplina() {
		return notaDisciplinaAluno;
	}

	public void setNotaDisciplina(String notaDisciplina) {
		this.notaDisciplinaAluno = notaDisciplina;
	}

	public int getFaltasDisciplina() {
		return faltasDisciplinaAluno;
	}

	public void setFaltasDisciplina(int faltasDisciplina) {
		this.faltasDisciplinaAluno = faltasDisciplina;
	}

	public int getCodPessoa() {
		return this.codPessoa;
	}

	public void setCodPessoa(int codPessoa) {
		this.codPessoa = codPessoa;
	}


	/*MÉTODOS DA CLASSE*/

	public void salvarAluno() throws Exception {

		salvarCadastro();
		AlunoDAO DAOaluno = new AlunoDAO();
		DAOaluno.salvarAluno(frmAluno.aluno);

	}

	public void consultarAluno(int rgmAluno) throws Exception{

		AlunoDAO DAOaluno = new AlunoDAO();
		DAOaluno.consultarAluno(rgmAluno);
		connsultarCadastro();

	}
}
