package sc.senac.br.controlefinanceiro.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import sc.senac.br.controlefinanceiro.dao.CategoriaDao;
import sc.senac.br.controlefinanceiro.dao.IBaseDao;
import sc.senac.br.controlefinanceiro.model.Categoria;

@ViewScoped
@ManagedBean
public class CadastroCategoriaController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Categoria categoria;
	private IBaseDao<Categoria> dao;
	private List<Categoria> categorias;
	private List<Categoria> categoriasFiltros;

	@PostConstruct
	public void init() {
		dao = new CategoriaDao();
		limpar();
		buscar();
	}

	public void salvar() {
		if (categoria.getCodigo() == null) {
			dao.salvar(categoria);
		} else {
			dao.alterar(categoria);
		}
		limpar();
		buscar();
	}

	public void excluir() {
		dao.excluir(categoria);

		FacesMessage mensagem = new FacesMessage();
		mensagem.setSeverity(FacesMessage.SEVERITY_INFO);

		FacesContext.getCurrentInstance().addMessage(null, mensagem);
	}

	public void limpar() {
		categoria = new Categoria();
	}

	public void buscar() {
		categorias = dao.buscarTodos();
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public IBaseDao<Categoria> getDao() {
		return dao;
	}

	public void setDao(IBaseDao<Categoria> dao) {
		this.dao = dao;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public List<Categoria> getCategoriasFiltros() {
		return categoriasFiltros;
	}

	public void setCategoriasFiltros(List<Categoria> categoriasFiltros) {
		this.categoriasFiltros = categoriasFiltros;
	}

}
