package sc.senac.br.controlefinanceiro.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import sc.senac.br.controlefinanceiro.dao.CategoriaDao;
import sc.senac.br.controlefinanceiro.dao.EmpresaDao;
import sc.senac.br.controlefinanceiro.dao.IBaseDao;
import sc.senac.br.controlefinanceiro.dao.RamoDao;
import sc.senac.br.controlefinanceiro.model.Categoria;
import sc.senac.br.controlefinanceiro.model.Empresa;
import sc.senac.br.controlefinanceiro.model.Ramo;

@ViewScoped
@ManagedBean
public class CadastroEmpresaController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Empresa empresa;
	private List<Empresa> empresas;
	private List<Empresa> empresasFiltros;
	private List<Ramo> ramos;
	private List<Categoria> categorias;
	private IBaseDao<Empresa> dao;
	private IBaseDao<Ramo> ramoDao;
	private IBaseDao<Categoria> categoriaDao;

	@PostConstruct
	public void init() {
		dao = new EmpresaDao();
		ramoDao = new RamoDao();
		categoriaDao = new CategoriaDao();
		limpar();
		buscar();

	}

	public void salvar() {
		if (empresa.getCodigo() == null) {
			dao.salvar(empresa);

			FacesMessage mensagem = new FacesMessage();
			mensagem.setSeverity(FacesMessage.SEVERITY_INFO);
			mensagem.setSummary("Empresa salva com sucesso!");

			FacesContext.getCurrentInstance().addMessage(null, mensagem);

		} else {
			dao.alterar(empresa);

			FacesMessage mensagem = new FacesMessage();
			mensagem.setSeverity(FacesMessage.SEVERITY_INFO);
			mensagem.setSummary("Empresa alterada com sucesso!");

			FacesContext.getCurrentInstance().addMessage(null, mensagem);

		}

		limpar();
		buscar();

	}

	public void excluir() {
		dao.excluir(empresa);
		limpar();
		buscar();

		FacesMessage mensagem = new FacesMessage();
		mensagem.setSeverity(FacesMessage.SEVERITY_INFO);
		mensagem.setSummary("Empresa excluída com sucesso!");

		FacesContext.getCurrentInstance().addMessage(null, mensagem);
	}

	public void limpar() {
		empresa = new Empresa();
	}

	public void buscar() {
		empresas = dao.buscarTodos();
		ramos = ramoDao.buscarTodos();
		categorias = categoriaDao.buscarTodos();
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public List<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}

	public List<Ramo> getRamos() {
		return ramos;
	}

	public void setRamos(List<Ramo> ramos) {
		this.ramos = ramos;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public IBaseDao<Empresa> getDao() {
		return dao;
	}

	public void setDao(IBaseDao<Empresa> dao) {
		this.dao = dao;
	}

	public IBaseDao<Ramo> getRamoDao() {
		return ramoDao;
	}

	public void setRamoDao(IBaseDao<Ramo> ramoDao) {
		this.ramoDao = ramoDao;
	}

	public IBaseDao<Categoria> getCategoriaDao() {
		return categoriaDao;
	}

	public void setCategoriaDao(IBaseDao<Categoria> categoriaDao) {
		this.categoriaDao = categoriaDao;
	}

	public List<Empresa> getEmpresasFiltros() {
		return empresasFiltros;
	}

	public void setEmpresasFiltros(List<Empresa> empresasFiltros) {
		this.empresasFiltros = empresasFiltros;
	}

}
