/**
 * 
 */
package br.com.makersweb.appjsf.web.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import br.com.makersweb.appjsf.web.entity.Usuario;
import br.com.makersweb.appjsf.web.model.UsuarioModel;
import br.com.makersweb.appjsf.web.repository.UsuarioRepository;
import br.com.makersweb.appjsf.web.util.MessageUtils;

/**
 *
 * @author anderson.aristides
 *
 */
@Named(value = "usuarioController")
@SessionScoped
public class UsuarioController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5866362200899185037L;

	@Inject
	private UsuarioModel usuarioModel;

	@Inject
	private UsuarioRepository usuarioRepository;

	@Inject
	private Usuario usuarioEntity;

	public UsuarioModel getUsuarioModel() {
		return usuarioModel;
	}

	public void setUsuarioModel(UsuarioModel usuarioModel) {
		this.usuarioModel = usuarioModel;
	}

	public UsuarioModel GetUsuarioSession() {
		FacesContext facesContext = FacesContext.getCurrentInstance();

		return (UsuarioModel) facesContext.getExternalContext().getSessionMap().get("usuarioAutenticado");
	}

	public String Logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

		return "/index.xhtml?faces-redirect=true";
	}

	public String EfetuarLogin() {

		if (StringUtils.isEmpty(usuarioModel.getUsuario()) || StringUtils.isBlank(usuarioModel.getUsuario())) {

			MessageUtils.Mensagem("Favor informar o login!");
			return null;
		} else if (StringUtils.isEmpty(usuarioModel.getSenha()) || StringUtils.isBlank(usuarioModel.getSenha())) {

			MessageUtils.Mensagem("Favor informara senha!");
			return null;
		} else {

			usuarioEntity = usuarioRepository.ValidaUsuario(usuarioModel);

			if (usuarioEntity != null) {

				usuarioModel.setSenha(null);
				usuarioModel.setId(usuarioEntity.getId());

				FacesContext facesContext = FacesContext.getCurrentInstance();

				facesContext.getExternalContext().getSessionMap().put("usuarioAutenticado", usuarioModel);

				return "sistema/home?faces-redirect=true";
			} else {

				MessageUtils.Mensagem("Não foi possível efetuar o login com esse usuário e senha!");
				return null;
			}
		}

	}

}
