package br.edu.ifal.sistemaifal.servico;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifal.sistemaifal.modelo.Aluno;
import br.edu.ifal.sistemaifal.modelo.Disciplina;
import br.edu.ifal.sistemaifal.modelo.Nota;
import br.edu.ifal.sistemaifal.modelo.Professor;

public class TesteDoRelatorio {
	
	public static void main(String[] args) {
		
		List<Aluno> alunos = new ArrayList<Aluno>();
		Aluno ze = new Aluno(1, "2018A1", "Zé");
		Aluno ana = new Aluno(2, "2018A2", "Ana");
		Aluno joao = new Aluno(3, "2018A3", "João");
		alunos.add(ze);
		alunos.add(ana);
		alunos.add(joao);
		
		Professor maria = new Professor(1, "Maria", "informática");
		
		Disciplina poo = new Disciplina(1, "POO", alunos, maria);
		
		List<Nota> notas = new ArrayList<Nota>();
		notas.add(new Nota(1, ze, poo, 7.5));
		notas.add(new Nota(1, ana, poo, 9.5));
		notas.add(new Nota(1, joao, poo, 2.5));
		
		Relatorio relatorio = new Relatorio();
		relatorio.gerar(notas);
		
		// imprimir 9.5
		System.out.println(relatorio.getMaiorNota());
		
	}

}
