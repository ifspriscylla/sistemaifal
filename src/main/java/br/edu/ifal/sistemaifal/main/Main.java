/**
 * 
 */
package br.edu.ifal.sistemaifal.main;

import br.edu.ifal.sistemaifal.dao.AlunoDAO;
import br.edu.ifal.sistemaifal.modelo.Aluno;

/**
 * @author priscylla
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Aluno aluno = new Aluno(1, "2018B123", "Luke Skywalker");
		AlunoDAO alunoDAO = new AlunoDAO();
		alunoDAO.salvar(aluno);

	}

}
