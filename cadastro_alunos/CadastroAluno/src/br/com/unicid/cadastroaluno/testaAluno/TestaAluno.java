package br.com.unicid.cadastroaluno.testaAluno;

import br.com.unicid.cadastroaluno.curso.modelo.Aluno;

public class TestaAluno {

	public static void main(String[] args) {
		
		Aluno novoAluno;
		novoAluno = new Aluno(123, "Athos", "48483147807", "24/01/1998", "Masc", "ADS", 1);
		novoAluno.setTelefone("(11)95910-2838");
		novoAluno.setTelefone(null);
		novoAluno.setEmail("athosphelipe005@gmail.com");
		
		System.out.println(novoAluno.getNome());
	}

}