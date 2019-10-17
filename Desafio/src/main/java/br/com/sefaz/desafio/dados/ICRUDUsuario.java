package br.com.sefaz.desafio.dados;

import java.util.List;

import br.com.sefaz.desafio.modelo.Usuario;

public interface ICRUDUsuario {
	public Usuario fazerLogin(String email, String senha);
	public Usuario consultarUsuario(String email);
	public List<Usuario> listarUsuario();
	public Usuario consultarUsuario(Long id);
	public void incluirUsuario(Usuario novoUsuario);
	public void alterarUsuario(Usuario altUsuario);
	public void excluirUsuario(Usuario excUsuario);
}
