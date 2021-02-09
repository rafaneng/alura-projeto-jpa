package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TestaMediaDasMovimentacoesComDataGenerico {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		String jpql = "select avg(m.valor), day(m.data), month(m.data) from Movimentacao m group by day(m.data), month(m.data), year(m.data)";

		Query query = em.createQuery(jpql);
		List<Object[]> mediaDasMovimentacoes = query.getResultList();

		for (Object[] resultado : mediaDasMovimentacoes) {
			System.out.println(
					"A m�dia das movimenta��es da data " + resultado[1] + "/" + resultado[2] + " � R$" + resultado[0]);

		}

	}
}
