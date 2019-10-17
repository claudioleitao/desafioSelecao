package br.com.sefaz.desafio.dados;

import java.util.List;

import br.com.sefaz.desafio.modelo.Usuario;

public class CRUDUsuario implements ICRUDUsuario {
	
	private DAO dao;
	
	public CRUDUsuario() {
		this.dao = new DAO();
	}
	
	private boolean achou(String email) {
		Usuario usuario = consultarUsuario(email);
		if(usuario == null)
			return false;
		else
			return true;
	}
	
	public Usuario fazerLogin(String email, String senha) {
		List<Usuario> lista = this.listarUsuario();
		for(Usuario usuario : lista) {
			if(usuario.getEmail().equalsIgnoreCase(email) && usuario.getSenha().equalsIgnoreCase(senha))
				return usuario;
		}
		
		return null;
	}
	
	public Usuario consultarUsuario(String email) {
		List<Usuario> lista = this.listarUsuario();
		for(Object obj : lista) {
			Usuario usuario = (Usuario) obj;
			if(usuario.getEmail().equalsIgnoreCase(email))
				return usuario;
		}
		
		return null;
	}
	
	private Integer pegarIDUsuario(List<Usuario> usuarios, String email) {
		Integer id = -1;
		for(Usuario usuario : usuarios) {
			if(usuario.getEmail().equalsIgnoreCase(email)) {
				id = usuario.getId();
			}
		}
		
		return id;
	}
	
	public List<Usuario> listarUsuario() {
		return this.dao.retornar();
	}
	
	public Usuario consultarUsuario(Long id) {
		return dao.retornar(id);
	}
		
	public void incluirUsuario(Usuario novoUsuario) {
		if(!this.achou(novoUsuario.getEmail())) {
			this.dao.salvar(novoUsuario);
		}
	}
	
	public void alterarUsuario(Usuario altUsuario) {
		List<Usuario> usuarios = this.listarUsuario();
		
		if(this.achou(altUsuario.getEmail())) {
			altUsuario.setId(pegarIDUsuario(usuarios, altUsuario.getEmail()));
			this.dao.update(altUsuario);
		}
	}
	
	public void excluirUsuario(Usuario usuario) {
		if(this.achou(usuario.getEmail())) {
			this.dao.remove(usuario);
		}
	}
}
