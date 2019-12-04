package sc.senac.br.controlefinanceiro.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import sc.senac.br.controlefinanceiro.dao.util.JPAUtil;
import sc.senac.br.controlefinanceiro.dto.EmpresasPorCategoriaDTO;
import sc.senac.br.controlefinanceiro.model.Empresa;

public class EmpresaDao extends BaseDao<Empresa> {

	public List<EmpresasPorCategoriaDTO> buscaCategoriasPorEmpresa() {
		EntityManager manager = JPAUtil.getEntityManager();

		StringBuilder jpqlBuider = new StringBuilder();
		jpqlBuider.append("select new sc.senac.br.controlefinanceiro.dto.EmpresasPorCategoriaDTO( ");
		jpqlBuider.append(" cat.descricao, ");
		jpqlBuider.append(" count(em) ");
		jpqlBuider.append(" ) ");
		jpqlBuider.append("from Empresa em ");
		jpqlBuider.append("right join em.categoria cat ");
		jpqlBuider.append("group by cat.descricao ");

		TypedQuery<EmpresasPorCategoriaDTO> query = manager.createQuery(jpqlBuider.toString(),
				EmpresasPorCategoriaDTO.class);

		List<EmpresasPorCategoriaDTO> resultado = query.getResultList();

		manager.close();

		return resultado;
	}

			

	
}
