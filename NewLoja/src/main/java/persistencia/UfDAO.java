package persistencia;

import java.io.Serializable;
import java.util.List;
import org.hibernate.*;
import beans.Estado;

public class UfDAO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void inserir(Estado estado) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.save(estado);
		t.commit();
		sessao.close();
	}

	public static void alterar(Estado estado) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.update(estado);
		t.commit();
		sessao.close();
	}

	public static void excluir(Estado estado) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.delete(estado);
		t.commit();
		sessao.close();
	}

	public static List<Estado> listagem(String filtro) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Query consulta;
		if (filtro.trim().length() == 0) {
			consulta = sessao.createQuery("from Estado order by est_nome");
		} else {
			consulta = sessao.createQuery("from Estado " + "where est_nome like :parametro order by est_nome");
			consulta.setString("parametro", "%" + filtro + "%");
		}

		List lista = consulta.list();
		sessao.close();
		return lista;
	}

}