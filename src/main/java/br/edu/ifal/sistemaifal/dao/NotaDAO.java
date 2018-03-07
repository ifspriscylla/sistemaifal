package br.edu.ifal.sistemaifal.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.ifal.sistemaifal.modelo.Nota;

public class NotaDAO implements DAOInterface<Nota, String>{
	
	private final String PERSISTENCE_UNIT_NAME = "psunit1";
	private EntityManagerFactory factory;
	private EntityManager em;
	
	public NotaDAO() {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	}
	
	public void iniciarConexao() {
		em = factory.createEntityManager();
		em.getTransaction().begin();			
	}
	
	public void fecharConexao() {
		em.getTransaction().commit();
		em.close();	
	}

	public void salvar(Nota nota) {
		iniciarConexao();
		em.persist(nota);
		fecharConexao();
	}

	public void atualizar(Nota nota) {
		iniciarConexao();
		em.merge(nota);
		fecharConexao();
	}

	public Nota buscarPorId(String id) {
		iniciarConexao();
		int identificador = Integer.parseInt(id);
		Nota nota = em.find(Nota.class, identificador);
		fecharConexao();
		return nota;
	}

	public void deletar(Nota nota) {
		iniciarConexao();
		em.remove(nota);
		fecharConexao();
	}

	public List<Nota> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	public void deletarTodos() {
		// TODO Auto-generated method stub
		
	}

}
