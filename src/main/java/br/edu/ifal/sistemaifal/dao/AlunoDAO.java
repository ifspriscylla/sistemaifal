package br.edu.ifal.sistemaifal.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import br.edu.ifal.sistemaifal.modelo.Aluno;

public class AlunoDAO implements DAOInterface<Aluno, String>{
	
	private Session currentSession;

	private Transaction currentTransaction;

	public AlunoDAO() {
	}
	
	private static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
		return sessionFactory;
	}
	
	public Session openCurrentSession() {
		currentSession = getSessionFactory().openSession();
		return currentSession;
	}

	public Session openCurrentSessionwithTransaction() {
		currentSession = getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		return currentSession;
	}
	
	public void closeCurrentSession() {
		currentSession.close();
	}
	
	public void closeCurrentSessionwithTransaction() {
		currentTransaction.commit();
		currentSession.close();
	}
	
	public Session getCurrentSession() {
		return currentSession;
	}

	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}

	public Transaction getCurrentTransaction() {
		return currentTransaction;
	}

	public void setCurrentTransaction(Transaction currentTransaction) {
		this.currentTransaction = currentTransaction;
	}

	public void salvar(Aluno entity) {
		getCurrentSession().save(entity);
	}

	public void atualizar(Aluno entity) {
		// TODO Auto-generated method stub
		
	}

	public Aluno buscarPorId(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deletar(Aluno entity) {
		// TODO Auto-generated method stub
		
	}

	public List<Aluno> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	public void deletarTodos() {
		// TODO Auto-generated method stub
		
	}

}