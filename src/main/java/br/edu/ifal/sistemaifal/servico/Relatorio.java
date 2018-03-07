package br.edu.ifal.sistemaifal.servico;

import java.util.List;

import br.edu.ifal.sistemaifal.modelo.Nota;

public class Relatorio {
	
	private double maiorNota = Double.NEGATIVE_INFINITY;
	
	public void gerar(List<Nota> notas){
		for (Nota nota : notas) {
			if(nota.getValor() > maiorNota){
				maiorNota = nota.getValor();
			}
		}
	}

	public double getMaiorNota() {
		return maiorNota;
	}	

}
