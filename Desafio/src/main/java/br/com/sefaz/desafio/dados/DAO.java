package br.com.sefaz.desafio.dados;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.sefaz.desafio.modelo.Usuario;

public class DAO {
	
	public void salvar(Usuario usuario) {
		Transaction transaction = null;
		Session session = null;
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Integer id = (Integer) session.save(usuario);
			usuario.setId(id);
			transaction.commit();
		} catch(Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			if(session != null)
				session.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> retornar() {
		Session session = null;
		List<Usuario> lista = null;
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			List<Object> objList = session.createSQLQuery("SELECT * FROM Public.Usuario").list();
			Iterator itr = objList.iterator();
			lista = new ArrayList<Usuario>();
			while(itr.hasNext()) {
				Object[] obj = (Object[]) itr.next();
				Usuario usuario = new Usuario();
				usuario.setId(Integer.parseInt(String.valueOf(obj[0])));
				usuario.setDddCelular(Integer.parseInt(String.valueOf(obj[1])));
				usuario.setDddTelefone(Integer.parseInt(String.valueOf(obj[2])));
				usuario.setEmail(String.valueOf(obj[3]));
				usuario.setNome(String.valueOf(obj[4]));
				usuario.setNumeroCelular(String.valueOf(obj[5]));
				usuario.setNumeroTelefone(String.valueOf(obj[6]));
				usuario.setSenha(String.valueOf(obj[7]));
				usuario.setTipo1(String.valueOf(obj[8]));
				usuario.setTipo2(String.valueOf(obj[9]));
				
				lista.add(usuario);				
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null)
				session.close();
		}
		
		return lista;
	}
	
	public Usuario retornar(Long id) {
		Session session = null;
		Usuario usuario = null;
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			usuario = (Usuario) session.get(Usuario.class, id);
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null)
				session.close();
		}
		
		return usuario;
	}
	
	public void update(Usuario usuario) {
		Transaction transaction = null;
		Session session = null;
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(usuario);
			transaction.commit();
		} catch(Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			if(session != null)
				session.close();
		}		
	}
	
	public void remove(Usuario usuario) {
		Transaction transaction = null;
		Session session = null;
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.delete(usuario);
			transaction.commit();
		} catch(Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			if(session != null)
				session.close();
		}
	}
}
