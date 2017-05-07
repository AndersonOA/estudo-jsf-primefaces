/**
 * 
 */
package br.com.makersweb.appjsf.web.model;

import java.io.Serializable;

/**
 *
 * @author anderson.aristides
 *
 */
public class UsuarioModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2478465218866434274L;

	private Long id;
	private String usuario;
	private String senha;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @param senha
	 *            the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

}
