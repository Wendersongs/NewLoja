package persistencia;

import java.io.Serializable;
import java.util.List;
import org.hibernate.*;
import beans.Cidade;

public class CidadeDAO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void inserir(Cidade cidade) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.save(cidade);
		t.commit();
		sessao.close();
	}

	public static void alterar(Cidade cidade) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.update(cidade);
		t.commit();
		sessao.close();
	}

	public static void excluir(Cidade cidade) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.delete(cidade);
		t.commit();
		sessao.close();
	}

	public static List<Cidade> listagem(String filtro) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Query consulta;
		if (filtro.trim().length() == 0) {
			consulta = sessao.createQuery("from Cidade order by cid_nome");
		} else {
			consulta = sessao.createQuery("from Cidade " + "where cid_nome like :parametro order by cid_nome");
			consulta.setString("parametro", "%" + filtro + "%");
		}

		List lista = consulta.list();
		sessao.close();
		return lista;
	}
        
       /* public static List<Cidade> listaFiltrado(int filtro) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Query consulta;
		if (String.valueOf(filtro).trim().length() == 0) {
			consulta = sessao.createQuery("from Cidade order by cid_nome");
		} else {
			consulta = sessao.createQuery("from Cidade " + "where est_id = :parametro order by cid_nome");
			consulta.setInteger("parametro",  filtro );
		}

		List lista = consulta.list();
		sessao.close();
		return lista;
	}*/

}