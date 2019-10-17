package br.com.sefaz.desafio.controle;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.Application;
import javax.faces.application.ViewHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.component.html.HtmlInputSecret;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;

import br.com.sefaz.desafio.dados.CRUDUsuario;
import br.com.sefaz.desafio.dados.ICRUDUsuario;
import br.com.sefaz.desafio.modelo.Usuario;

@RequestScoped
@ManagedBean(name="controleUsuario")
public class ControleUsuario {
	private ICRUDUsuario crudUsuario = new CRUDUsuario();
	
	private List<Usuario> listaUsuario = this.crudUsuario.listarUsuario();
	private Usuario usuario = new Usuario();
	
	private HtmlOutputLabel outputErrorMessage;
	private HtmlOutputLabel outputSuccessMessage;
	
	private HtmlInputText inputNome;
	private HtmlInputText inputEmail;
	private HtmlInputSecret inputSenha;
	
	//Referente ao primeiro contato
	private HtmlInputText inputDDD1;
	private HtmlInputText inputNumero1;
	private HtmlSelectOneMenu selectTipo1;
	
	//Referente ao segundo contato
	private HtmlInputText inputDDD2;
	private HtmlInputText inputNumero2;
	private HtmlSelectOneMenu selectTipo2;
	
	private HtmlOutputText outputgetId;

	public HtmlOutputLabel getOutputErrorMessage() {
		return outputErrorMessage;
	}
	public void setOutputErrorMessage(HtmlOutputLabel outputErrorMessage) {
		this.outputErrorMessage = outputErrorMessage;
	}
	public HtmlOutputLabel getOutputSuccessMessage() {
		return outputSuccessMessage;
	}
	public void setOutputSuccessMessage(HtmlOutputLabel outputSuccessMessage) {
		this.outputSuccessMessage = outputSuccessMessage;
	}
	public HtmlInputText getInputNome() {
		return inputNome;
	}
	public void setInputNome(HtmlInputText inputNome) {
		this.inputNome = inputNome;
	}
	public HtmlInputText getInputEmail() {
		return inputEmail;
	}
	public void setInputEmail(HtmlInputText inputEmail) {
		this.inputEmail = inputEmail;
	}
	public HtmlInputSecret getInputSenha() {
		return inputSenha;
	}
	public void setInputSenha(HtmlInputSecret inputSenha) {
		this.inputSenha = inputSenha;
	}
	public HtmlInputText getInputDDD1() {
		return inputDDD1;
	}
	public void setInputDDD1(HtmlInputText inputDDD1) {
		this.inputDDD1 = inputDDD1;
	}
	public HtmlInputText getInputNumero1() {
		return inputNumero1;
	}
	public void setInputNumero1(HtmlInputText inputNumero1) {
		this.inputNumero1 = inputNumero1;
	}
	public HtmlSelectOneMenu getSelectTipo1() {
		return selectTipo1;
	}
	public void setSelectTipo1(HtmlSelectOneMenu selectTipo1) {
		this.selectTipo1 = selectTipo1;
	}
	public HtmlInputText getInputDDD2() {
		return inputDDD2;
	}
	public void setInputDDD2(HtmlInputText inputDDD2) {
		this.inputDDD2 = inputDDD2;
	}
	public HtmlInputText getInputNumero2() {
		return inputNumero2;
	}
	public void setInputNumero2(HtmlInputText inputNumero2) {
		this.inputNumero2 = inputNumero2;
	}
	public HtmlSelectOneMenu getSelectTipo2() {
		return selectTipo2;
	}
	public void setSelectTipo2(HtmlSelectOneMenu selectTipo2) {
		this.selectTipo2 = selectTipo2;
	}
	public HtmlOutputText getOutputgetId() {
		return outputgetId;
	}
	public void setOutputgetId(HtmlOutputText outputgetId) {
		this.outputgetId = outputgetId;
	}
	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}
	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	//Tela de cadastro de usuário
	public String incluirUsuario() {
		if(this.inputNome.getValue().toString().equalsIgnoreCase("") && this.inputEmail.getValue().toString().equalsIgnoreCase("") &&
				this.inputSenha.getValue().toString().equalsIgnoreCase("") && this.inputDDD1.getValue().toString().equalsIgnoreCase("") &&
				this.inputNumero1.getValue().toString().equalsIgnoreCase("")) {
			this.outputErrorMessage.setStyle("background-color:red; display:show");
			this.outputErrorMessage.setValue("Os Campos Estão em Branco.");
		} else if(this.inputNome.getValue().toString().equalsIgnoreCase("")) {
			this.outputErrorMessage.setStyle("background-color:red; display:show");
			this.outputErrorMessage.setValue("Campo Nome em Branco.");
		} else if(this.inputEmail.getValue().toString().equalsIgnoreCase("")) {
			this.outputErrorMessage.setStyle("background-color:red; display:show");
			this.outputErrorMessage.setValue("Campo E-mail em Branco.");
		} else if(this.inputSenha.getValue().toString().equalsIgnoreCase("")) {
			this.outputErrorMessage.setStyle("background-color:red; display:show");
			this.outputErrorMessage.setValue("Campo Senha em Branco.");
		} else if(this.inputDDD1.getValue().toString().equalsIgnoreCase("")) {
			this.outputErrorMessage.setStyle("background-color:red; display:show");
			this.outputErrorMessage.setValue("Campo DDD em Branco.");
		} else if(this.inputNumero1.getValue().toString().equalsIgnoreCase("")) {
			this.outputErrorMessage.setStyle("background-color:red; display:show");
			this.outputErrorMessage.setValue("Campo Número de Telefone em Branco.");
		} else if(this.selectTipo1.getValue().toString().equalsIgnoreCase("")) {
			this.outputErrorMessage.setStyle("background-color:red; display:show");
			this.outputErrorMessage.setValue("Campo Tipo de contato Não Selecionado.");
		} else {
			this.outputErrorMessage.setStyle("display:none");
			String nome = inputNome.getValue().toString();
			String email = inputEmail.getValue().toString();
			String senha = inputSenha.getValue().toString();
			int ddd1 = Integer.parseInt(inputDDD1.getValue().toString());
			String numero1 = inputNumero1.getValue().toString();
			String tipo1 = selectTipo1.getValue().toString();
			int ddd2 = Integer.parseInt(inputDDD2.getValue().toString());
			String numero2 = inputNumero2.getValue().toString();
			String tipo2 = selectTipo2.getValue().toString();
			Usuario usuario = new Usuario();
			usuario.setNome(nome);
			usuario.setEmail(email);
			usuario.setSenha(senha);
			usuario.setDddTelefone(ddd1);
			usuario.setNumeroTelefone(numero1);
			usuario.setTipo1(tipo1);
			usuario.setDddCelular(ddd2);
			usuario.setNumeroCelular(numero2);
			usuario.setTipo2(tipo2);
			
			this.limparCampos();
			
			this.crudUsuario.incluirUsuario(usuario);
			this.outputSuccessMessage.setStyle("background-color: green; display:show");
			
			this.refresh();
			
			return "cadastrousuario";
		}
		
		return "";
	}
	
	public void alterarUsuario() {
		if(this.inputNome.getValue().toString().equalsIgnoreCase("") && this.inputEmail.getValue().toString().equalsIgnoreCase("") &&
				this.inputSenha.getValue().toString().equalsIgnoreCase("") && this.inputDDD1.getValue().toString().equalsIgnoreCase("") &&
				this.inputNumero1.getValue().toString().equalsIgnoreCase("") && this.selectTipo1.getValue().toString().equalsIgnoreCase("")) {
			this.outputErrorMessage.setStyle("background-color:red; display:show");
			this.outputErrorMessage.setValue("Os Campos Estão em Branco.");
		} else if(inputNome.getValue().toString().equalsIgnoreCase("")) {
			this.outputErrorMessage.setStyle("background-color:red; display:show");
			this.outputErrorMessage.setValue("Campo Nome em Branco.");
		} else if(inputEmail.getValue().toString().equalsIgnoreCase("")) {
			this.outputErrorMessage.setStyle("background-color:red; display:show");
			this.outputErrorMessage.setValue("Campo E-mail em Branco.");
		} else if(inputSenha.getValue().toString().equalsIgnoreCase("")) {
			this.outputErrorMessage.setStyle("background-color:red; display:show");
			this.outputErrorMessage.setValue("Campo Senha em Branco.");
		} else if(inputDDD1.getValue().toString().equalsIgnoreCase("")) {
			this.outputErrorMessage.setStyle("background-color:red; display:show");
			this.outputErrorMessage.setValue("Campo DDD em Branco.");
		} else if(inputNumero1.getValue().toString().equalsIgnoreCase("")) {
			this.outputErrorMessage.setStyle("background-color:red; display:show");
			this.outputErrorMessage.setValue("Campo Número de Telefone em Branco.");
		} else if(selectTipo1.getValue().toString().equalsIgnoreCase("")) {
			this.outputErrorMessage.setStyle("background-color:red; display:show");
			this.outputErrorMessage.setValue("Campo Tipo de contato Não Selecionado.");
		} else {
			this.outputErrorMessage.setStyle("display:none");
			String nome = inputNome.getValue().toString();
			String email = inputEmail.getValue().toString();
			String senha = inputSenha.getValue().toString();
			int ddd1 = Integer.parseInt(inputDDD1.getValue().toString());
			String numero1 = inputNumero1.getValue().toString();
			String tipo1 = selectTipo1.getValue().toString();
			int ddd2 = Integer.parseInt(inputDDD2.getValue().toString());
			String numero2 = inputNumero2.getValue().toString();
			String tipo2 = selectTipo2.getValue().toString();
			Usuario usuario = new Usuario();
			usuario.setNome(nome);
			usuario.setEmail(email);
			usuario.setSenha(senha);
			usuario.setDddTelefone(ddd1);
			usuario.setNumeroTelefone(numero1);
			usuario.setTipo1(tipo1);
			usuario.setDddCelular(ddd2);
			usuario.setNumeroCelular(numero2);
			usuario.setTipo2(tipo2);			
			this.crudUsuario.alterarUsuario(usuario);
		}
	}
		
	private void limparCampos() {
		inputNome.resetValue();
		inputEmail.resetValue();
		inputSenha.resetValue();
		inputDDD1.resetValue();
		inputNumero1.resetValue();
		selectTipo1.resetValue();
		inputDDD2.resetValue();
		inputNumero2.resetValue();
		selectTipo2.resetValue();
	}
	
	public String voltar() {
		return "cadastrousuario";
	}
	//Fim da tela de cadastro de usuário
	//Tela de login
	public String fazerLogin() {
		if(this.inputEmail.getValue().toString().equalsIgnoreCase("") && this.inputSenha.getValue().toString().equalsIgnoreCase("")) {
			this.outputErrorMessage.setStyle("background-color:red; display:show");
			this.outputErrorMessage.setValue("Os Campos E-mail e Senha em Branco.");
		} else if(inputEmail.getValue().toString().equalsIgnoreCase("")) {
			this.outputErrorMessage.setStyle("background-color:red; display:show");
			this.outputErrorMessage.setValue("Campo E-mail em Branco.");
		} else if (inputSenha.getValue().toString().equalsIgnoreCase("")) {
			this.outputErrorMessage.setStyle("background-color:red; display:show");
			this.outputErrorMessage.setValue("Campo Senha em Branco.");
		} else {
			this.outputErrorMessage.setStyle("display:none");
			String email = inputEmail.getValue().toString();
			String senha = inputSenha.getValue().toString();
			Usuario usuario = this.crudUsuario.fazerLogin(email, senha);
			if(usuario == null) {
				this.outputErrorMessage.setStyle("background-color:red; display:show");
				this.outputErrorMessage.setValue("Usuário ou senha inválido.");
			} else {
				this.limparCamposIndex();
				return "cadastrousuario";
			}
		}
		
		return "";
		
	}
	
	public String telaDeUsuario() {
		return "usuario";
	}
	
	private void limparCamposIndex() {
		inputEmail.resetValue();
		inputSenha.resetValue();
	}
	//Fim da Tela de Login
	//Tela de Alteração de Usuário
	public String telaDeUsuarioAlt() {
		return "usuario";
	}
	
	public String telaAlterarUsuario() {
		Integer id = (Integer) outputgetId.getValue();
		
		for(Usuario usuario : this.listaUsuario) {
			if(usuario.getId() == id) {
				this.usuario = usuario;
			}
		}
		
		
		
		return "alterarusuario";
	}
	
	public String excluirUsuario() {
		Integer id = (Integer) outputgetId.getValue();
		int index = -1;
		for(Usuario usuario : this.listaUsuario) {
			index++;
			if(usuario.getId() == id)
				this.crudUsuario.excluirUsuario(usuario);
		}
		
		this.listaUsuario.remove(index);
		
		this.refresh();
		
		if (this.listaUsuario.isEmpty())
			return "index";
		
		return "";
	}
	
	private void refresh() {
		FacesContext context = FacesContext.getCurrentInstance();
		Application application = context.getApplication();
		ViewHandler viewHandler = application.getViewHandler();
		UIViewRoot viewRoot = viewHandler.createView(context, context.getViewRoot().getViewId());
		context.setViewRoot(viewRoot);
		context.renderResponse();
	}
	
	public String sair() {
		return "index";
	}
}
