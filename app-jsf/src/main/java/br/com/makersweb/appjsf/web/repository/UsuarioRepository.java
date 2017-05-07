/**
 * 
 */
package br.com.makersweb.appjsf.web.repository;

import java.io.Serializable;

import javax.persistence.Query;

import br.com.makersweb.appjsf.web.entity.Usuario;
import br.com.makersweb.appjsf.web.model.UsuarioModel;
import br.com.makersweb.appjsf.web.util.EntityManagerUtils;

/**
 *
 * @author anderson.aristides
 *
 */
public class UsuarioRepository implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1188244504348116589L;

	public Usuario ValidaUsuario(UsuarioModel usuarioModel) {

		try {

			// QUERY QUE VAI SER EXECUTADA (UsuarioEntity.findUser)
			Query query = EntityManagerUtils.jpaEntityManager().createNamedQuery("Usuario.findUser");

			// PARÂMETROS DA QUERY
			query.setParameter("usuario", usuarioModel.getUsuario());
			query.setParameter("senha", usuarioModel.getSenha());

			// RETORNA O USUÁRIO SE FOR LOCALIZADO
			return (Usuario) query.getSingleResult();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
