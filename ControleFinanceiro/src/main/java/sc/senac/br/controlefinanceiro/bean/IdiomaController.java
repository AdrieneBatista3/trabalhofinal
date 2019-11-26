package sc.senac.br.controlefinanceiro.bean;

import java.io.Serializable;
import java.util.Locale;

import javax.faces.context.FacesContext;

public class IdiomaController implements Serializable {

	private static final long serialVersionUID = 1L;

	private String idiomaSelecionado;

	public void setIdiomaSelecionado(String idiomaSelecionado) {
		FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(idiomaSelecionado));
	}

}
