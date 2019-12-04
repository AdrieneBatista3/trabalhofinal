package sc.senac.br.controlefinanceiro.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.pie.PieChartDataSet;
import org.primefaces.model.charts.pie.PieChartModel;

import sc.senac.br.controlefinanceiro.dao.EmpresaDao;
import sc.senac.br.controlefinanceiro.dto.EmpresasPorCategoriaDTO;
@ManagedBean
//@RequestScoped
public class DashboardController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	 private EmpresaDao empresaDao;
	 private List<EmpresasPorCategoriaDTO> empresasPorCategoriaDTOs;
	 private PieChartModel empresasPorCategoriaModel;
	 
	 private final List<String> cores = Arrays.asList(
			 "#ff8a73", "#e8cd74", "#74d5e8", "#a2ff8c", "#c8a3ff");
	 
	 public DashboardController() {
		 empresaDao = new EmpresaDao();
		 empresasPorCategoriaDTOs = empresaDao.buscaCategoriasPorEmpresa();
		 inicializaGraficoCategoriasPorEmpresa();
	
	 }
	 
	 private void inicializaGraficoCategoriasPorEmpresa() {
		 empresasPorCategoriaModel = new PieChartModel();
		 
		 List<Number> valores = new ArrayList<>();
		 List<String> rotulos = new ArrayList<>();
		 
		 for(EmpresasPorCategoriaDTO dto : empresasPorCategoriaDTOs) {
			 rotulos.add(dto.getCategoria());
			 valores.add(dto.getQuantidadesCategorias());
			 
		 }
		 
		 PieChartDataSet dataset = new PieChartDataSet();
		 dataset.setData(valores);
		 dataset.setBackgroundColor(cores);
		 
		 ChartData dados =  new ChartData();
		 dados.addChartDataSet(dataset);
		 dados.setLabels(rotulos);
		 
		 empresasPorCategoriaModel.setData(dados);
		 
	 }
	
	public PieChartModel getEmpresasPorCategoriaModel() {
		return empresasPorCategoriaModel;
	}
	

}
