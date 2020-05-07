package br.com.unicid.cadastroaluno.view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class FerramentasFormulario {

	public void limpaComponentes(JTextField... args) {

		for(JTextField componentes: args) {
			componentes.setText(null);
		}
	}

	public void habilitaComponentes(JTextField... args) {
		for(JTextField componentes: args) {
			componentes.setEnabled(true);
		}
	}

	public void habilitaComponentes(JComboBox... args) {
		for(JComboBox componentes: args) {
			componentes.setEnabled(true);
		}
	}

	public void habilitaComponentes(JRadioButton... args) {
		for(JRadioButton componentes: args) {
			componentes.setEnabled(true);
		}
	}

	public void habilitaComponentes(JButton... args) {
		for(JButton componentes: args) {
			componentes.setEnabled(true);
		}
	}


	public void desabilitaComponentes(JTextField... args) {
		for(JTextField componentes: args) {
			componentes.setEnabled(false);
		}
	}

	public void desabilitaComponentes(JComboBox... args) {
		for(JComboBox componentes: args) {
			componentes.setEnabled(false);
		}
	}

	public void desabilitaComponentes(JRadioButton... args) {
		for(JRadioButton componentes: args) {
			componentes.setEnabled(false);
		}
	}

	public void desabilitaComponentes(JButton... args) {
		for(JButton componentes: args) {
			componentes.setEnabled(false);
		}
	}

	public void resetCombo(JComboBox... args) {
		for(JComboBox componentes: args) {
			componentes.setSelectedIndex(0);
		}
	}

	public String removeMascara(String arg) {
		arg = arg.replaceAll("[\\D]", "");
		return arg;
	}

	public void limparTudoAluno() {

		limpaComponentes(frmAluno.txtRgm, frmAluno.txtNome, frmAluno.txtNascimento, frmAluno.txtCpf, frmAluno.txtEmail, frmAluno.txtEmail, frmAluno.txtCelular, frmAluno.txtTelefone);
		limpaComponentes(frmAluno.txtCep, frmAluno.txtEndereco, frmAluno.txtNumero, frmAluno.txtComplemento, frmAluno.txtBairro, frmAluno.txtCidade);
		resetCombo(frmAluno.cmbUF, frmAluno.cmbUnidade, frmAluno.cmbGenero, frmAluno.cmbCurso);
	}

	public void habilitaTudoAluno() {

		habilitaComponentes(frmAluno.txtRgm, frmAluno.txtNome, frmAluno.txtCpf, frmAluno.txtNascimento, frmAluno.txtEmail, frmAluno.txtCelular, frmAluno.txtTelefone); //Habilita os campos do panel Alunos
		habilitaComponentes(frmAluno.txtCep, frmAluno.txtEndereco, frmAluno.txtNumero, frmAluno.txtComplemento, frmAluno.txtBairro, frmAluno.txtCidade); //Habilita os campos do panel Endereço
		habilitaComponentes(frmAluno.cmbCurso, frmAluno.cmbUF, frmAluno.cmbUnidade);
		habilitaComponentes(frmAluno.rdbMatutino, frmAluno.rdbNoturno, frmAluno.rdbVespertino);

	}

}
