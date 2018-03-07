package br.edu.ifal.sistemaifal.servico;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.edu.ifal.sistemaifal.modelo.Aluno;
import br.edu.ifal.sistemaifal.modelo.Disciplina;
import br.edu.ifal.sistemaifal.modelo.Nota;
import br.edu.ifal.sistemaifal.modelo.Professor;

public class RelatorioTest {

	@Test
	public void deveEntenderAsNotasEmOrdemCrescente() {
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
		notas.add(new Nota(1, ze, poo, 2.0));
		notas.add(new Nota(1, ana, poo, 4.5));
		notas.add(new Nota(1, joao, poo, 7.0));
		
		Relatorio relatorio = new Relatorio();
		relatorio.gerar(notas);
		
		double maiorNotaEsperada = 7.0;
		double menorNotaEsperada = 2.0;
		
		Assert.assertEquals(maiorNotaEsperada, relatorio.getMaiorNota(), 0000.1);
		Assert.assertEquals(menorNotaEsperada, relatorio.getMenorNota(), 0000.1);
	}
	
	@Test
	public void deveEntenderUmUnicaNota(){
		
		List<Aluno> alunos = new ArrayList<Aluno>();
		Aluno ze = new Aluno(1, "2018A1", "Zé");
		alunos.add(ze);
		
		Professor maria = new Professor(1, "Maria", "informática");
		
		Disciplina poo = new Disciplina(1, "POO", alunos, maria);
		
		List<Nota> notas = new ArrayList<Nota>();
		notas.add(new Nota(1, ze, poo, 2.0));

		
		Relatorio relatorio = new Relatorio();
		relatorio.gerar(notas);
		
		double maiorNotaEsperada = 2.0;
		double menorNotaEsperada = 2.0;
		
		Assert.assertEquals(maiorNotaEsperada, relatorio.getMaiorNota(), 0000.1);
		Assert.assertEquals(menorNotaEsperada, relatorio.getMenorNota(), 0000.1);
		
	}

}
