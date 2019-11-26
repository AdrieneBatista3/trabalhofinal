package sc.senac.br.controlefinanceiro.dto;

public class EmpresaPorRamoDTO {

	private String ramo;

	private Long quantidadeRamos;

	public EmpresaPorRamoDTO(String ramo, Long quantidadeRamos) {
		this.ramo = ramo;
		this.quantidadeRamos = quantidadeRamos;
	}

	public String getRamo() {
		return ramo;
	}

	public void setRamo(String ramo) {
		this.ramo = ramo;
	}

	public Long getQuantidadeRamos() {
		return quantidadeRamos;
	}

	public void setQuantidadeRamos(Long quantidadeRamos) {
		this.quantidadeRamos = quantidadeRamos;
	}

}
