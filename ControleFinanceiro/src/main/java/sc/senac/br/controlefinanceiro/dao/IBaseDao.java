package sc.senac.br.controlefinanceiro.dao;

import java.util.List;

import sc.senac.br.controlefinanceiro.model.IBaseModel;

public interface IBaseDao<T extends IBaseModel> {

	public abstract void salvar(T model);

	public abstract void alterar(T model);

	public abstract void excluir(T model);

	public abstract T buscarPorID(Long id);

	public abstract List<T> buscarTodos();

}
