package sc.senac.br.controlefinanceiro.dto;

public class EmpresasPorCategoriaDTO {

	private String categoria;

	private Long quantidadeCategorias;

	public EmpresasPorCategoriaDTO(String categoria, Long quantidadesCategorias) {
		this.categoria = categoria;
		this.quantidadeCategorias = quantidadesCategorias;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Long getQuantidadesCategorias() {
		return quantidadeCategorias;
	}

	public void setQuantidadesCategorias(Long quantidadesCategorias) {
		this.quantidadeCategorias = quantidadesCategorias;
	}
	
	
}
