package br.edu.ifal.sistemaifal.servico;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import br.edu.ifal.sistemaifal.modelo.Aluno;
import br.edu.ifal.sistemaifal.modelo.Disciplina;
import br.edu.ifal.sistemaifal.modelo.Nota;
import br.edu.ifal.sistemaifal.modelo.Professor;

public class RelatorioTest {
	
	private List<Aluno> alunos;
	private Disciplina disciplina;
	private Professor professor;
	private List<Nota> notas;
	
	public void criacaoDasEntidadesParaOsTestes() {
		this.alunos = new ArrayList<Aluno>();
		this.professor = new Professor(1, "Maria", "informática");
		this.disciplina = new Disciplina(1, "POO", alunos, professor);
		this.notas = new ArrayList<Nota>();
		
		Aluno ze = new Aluno(1, "2018A1", "Zé");
		Aluno ana = new Aluno(2, "2018A2", "Ana");
		Aluno joao = new Aluno(3, "2018A3", "João");
		Aluno monica = new Aluno(2, "2018A2", "Monica");
		this.alunos.add(ze);
		this.alunos.add(ana);
		this.alunos.add(joao);
		this.alunos.add(monica);
	}
	
	
	@Test
	public void deveFuncionarParaAsNotasNaOrdemAleatoria() {
		criacaoDasEntidadesParaOsTestes();
				
		this.notas.add(new Nota(1, alunos.get(0), disciplina, 2.5));
		this.notas.add(new Nota(2, alunos.get(1), disciplina, 9.5));
		this.notas.add(new Nota(3, alunos.get(2), disciplina, 7.5));
		
		Relatorio relatorio = new Relatorio();
		relatorio.gerar(notas);
		
		double maiorNotaEsperada = 9.5;
		double menorNotaEsperada = 2.5;
		
		assertEquals(maiorNotaEsperada, relatorio.getMaiorNota(), 0000.1);
		assertEquals(menorNotaEsperada, relatorio.getMenorNota(), 0000.1);
	}
	
	@Test
	public void deveFuncionarParaAsNotasNaOrdemCrescente() {
		criacaoDasEntidadesParaOsTestes();
				
		notas.add(new Nota(1, alunos.get(0), disciplina, 2.5));
		notas.add(new Nota(2, alunos.get(1), disciplina, 7.5));
		notas.add(new Nota(3, alunos.get(2), disciplina, 9.5));
		
		Relatorio relatorio = new Relatorio();
		relatorio.gerar(notas);
		
		double maiorNotaEsperada = 9.5;
		double menorNotaEsperada = 2.5;
		
		assertEquals(maiorNotaEsperada, relatorio.getMaiorNota(), 0000.1);
		assertEquals(menorNotaEsperada, relatorio.getMenorNota(), 0000.1);
	
	}

	
	@Test
	public void deveFuncionarParaAsNotasNaOrdemDecrescente() {
		criacaoDasEntidadesParaOsTestes();
					
		notas.add(new Nota(1, alunos.get(0), disciplina, 9.5));
		notas.add(new Nota(1, alunos.get(1), disciplina, 7.5));
		notas.add(new Nota(1, alunos.get(2), disciplina, 2.5));
		
		Relatorio relatorio = new Relatorio();
		relatorio.gerar(notas);
		
		double maiorNotaEsperada = 9.5;
		double menorNotaEsperada = 2.5;
		
		assertEquals(maiorNotaEsperada, relatorio.getMaiorNota(), 0.001);
		assertEquals(menorNotaEsperada, relatorio.getMenorNota(), 0.001);
	}
	
	
	@Test
	public void deveFuncionarComUmaUnicaNota(){
		criacaoDasEntidadesParaOsTestes();
		
		this.notas.add(new Nota(1, alunos.get(0), disciplina, 2.0));

		Relatorio relatorio = new Relatorio();
		relatorio.gerar(notas);
		
		double maiorNotaEsperada = 2.0;
		double menorNotaEsperada = 2.0;
		
		assertEquals(maiorNotaEsperada, relatorio.getMaiorNota(), 0.0001);
		assertEquals(menorNotaEsperada, relatorio.getMenorNota(), 0.0001);
		
	}
	
	@Test
	public void deveFuncionarAIdentificacaoDas3MaioresNotas() {
		criacaoDasEntidadesParaOsTestes();
		
		notas.add(new Nota(1, alunos.get(0), disciplina, 9.0));
		notas.add(new Nota(1, alunos.get(1), disciplina, 10.0));
		notas.add(new Nota(1, alunos.get(2), disciplina, 8.0));
		
		Relatorio relatorio = new Relatorio();
		relatorio.gerar(notas);
		
		int quantidadeDeNotasEsperadas = 3;
		double primeiraNotaEsperada = 10.0;
		double segundaNotaEsperada = 9.0;
		double terceiraNotaEsperada = 8.0;
		
		assertEquals(quantidadeDeNotasEsperadas, relatorio.getTop3Notas().size());
		assertEquals(primeiraNotaEsperada, relatorio.getTop3Notas().get(0).getValor(), 0000.1);
		assertEquals(segundaNotaEsperada, relatorio.getTop3Notas().get(1).getValor(), 0000.1);
		assertEquals(terceiraNotaEsperada, relatorio.getTop3Notas().get(2).getValor(), 0000.1);
	}
	
	@Test
	public void deveFuncionarParaIdentificarAs3MaioresNotasParaUmUnicoAluno() {
		criacaoDasEntidadesParaOsTestes();
		
		List<Nota> notas = new ArrayList<Nota>();
		notas.add(new Nota(1, alunos.get(0), disciplina, 2.0));

		Relatorio relatorio = new Relatorio();
		relatorio.gerar(notas);
		
		int quantidadeDeNotasEsperadas = 1;
		double primeiraNotaEsperada = 2.0;
		
		assertEquals(quantidadeDeNotasEsperadas, relatorio.getTop3Notas().size());
		assertEquals(primeiraNotaEsperada, relatorio.getTop3Notas().get(0).getValor(), 0000.1);
		
		
	}
	
	@Test
	public void deveFuncionarParaIdentificarAs3MaioresNotasDeUmaTurmaSemAlunos() {
		criacaoDasEntidadesParaOsTestes();
		
		Relatorio relatorio = new Relatorio();
		relatorio.gerar(notas);
		
		int quantidadeDeNotasEsperadas = 0;
		
		assertEquals(quantidadeDeNotasEsperadas, relatorio.getTop3Notas().size());
		
	}
	
	
	@Test
	public void deveFuncionarAIdentificacaoDas3MaioresNotasParaDoisAlunos() {
		criacaoDasEntidadesParaOsTestes();

		notas.add(new Nota(1, alunos.get(0), disciplina, 9.5));
		notas.add(new Nota(2, alunos.get(1), disciplina, 7.5));
		
		Relatorio relatorio = new Relatorio();
		relatorio.gerar(notas);
		
		int quantidadeDeNotasEsperadas = 2;
		double primeiraNotaEsperada = 9.5;
		double segundaNotaEsperada = 7.5;
		
		assertEquals(quantidadeDeNotasEsperadas, relatorio.getTop3Notas().size());
		assertEquals(primeiraNotaEsperada, relatorio.getTop3Notas().get(0).getValor(), 000.1);
		assertEquals(segundaNotaEsperada, relatorio.getTop3Notas().get(1).getValor(), 000.1);
		
	}
	
	@Test
	public void deveFuncionarAIdentificacaoDas3MaioresNotasParaQuatroAlunos() {
		criacaoDasEntidadesParaOsTestes();

		notas.add(new Nota(1, alunos.get(0), disciplina, 9.5));
		notas.add(new Nota(2, alunos.get(1), disciplina, 7.5));
		notas.add(new Nota(2, alunos.get(2), disciplina, 6.5));
		notas.add(new Nota(2, alunos.get(3), disciplina, 6.0));
		
		Relatorio relatorio = new Relatorio();
		relatorio.gerar(notas);
		
		int quantidadeDeNotasEsperadas = 3;
		double primeiraNotaEsperada = 9.5;
		double segundaNotaEsperada = 7.5;
		double terceiraNotaEsperada = 6.5;
		
		assertEquals(quantidadeDeNotasEsperadas, relatorio.getTop3Notas().size());
		assertEquals(primeiraNotaEsperada, relatorio.getTop3Notas().get(0).getValor(), 000.1);
		assertEquals(segundaNotaEsperada, relatorio.getTop3Notas().get(1).getValor(), 000.1);
		assertEquals(terceiraNotaEsperada, relatorio.getTop3Notas().get(2).getValor(), 000.1);
	}
	
	

}