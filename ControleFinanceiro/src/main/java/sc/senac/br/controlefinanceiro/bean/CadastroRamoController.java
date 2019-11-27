package sc.senac.br.controlefinanceiro.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import sc.senac.br.controlefinanceiro.dao.IBaseDao;
import sc.senac.br.controlefinanceiro.dao.RamoDao;
import sc.senac.br.controlefinanceiro.model.Ramo;

@ViewScoped
@ManagedBean
public class CadastroRamoController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Ramo ramo;
	private IBaseDao<Ramo> dao;
	private List<Ramo> ramos;
	private List<Ramo> ramosFiltros;

	@PostConstruct
	public void init() {
		dao = new RamoDao();
		limpar();
		buscar();
	}

	public void salvar() {
		if (ramo.getCodigo() == null) {
			dao.salvar(ramo);
		} else {
			dao.alterar(ramo);
		}
		limpar();
		buscar();
	}

	public void excluir() {
		dao.excluir(ramo);

		FacesMessage mensagem = new FacesMessage();
		mensagem.setSeverity(FacesMessage.SEVERITY_INFO);
		mensagem.setSummary("Ramo Excluído com sucesso! ");

		FacesContext.getCurrentInstance().addMessage(null, mensagem);
	}

	public void limpar() {
		ramo = new Ramo();
	}
	
	public void buscar() {
		ramos = dao.buscarTodos();
	}
	
	public Ramo getRamo() {
		return ramo;
		
	}
	
	public void setRamo(Ramo ramo) {
		this.ramo = ramo;
	}
	
	public List<Ramo> getRamos(){
		return ramos;
	}

	public List<Ramo> getRamosFiltros() {
		return ramosFiltros;
	}

	public void setRamosFiltros(List<Ramo> ramosFiltros) {
		this.ramosFiltros = ramosFiltros;
	}
	
}
