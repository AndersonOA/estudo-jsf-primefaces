/**
 * 
 */
package br.com.makersweb.appjsf.web.util;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author anderson.aristides
 *
 */
public class EntityManagerUtils {

	/**
	 * Método para recuperar o EntityManger que vai ser criado no nosso
	 * JPAFilter
	 * 
	 * @return EntityManager
	 */
	public static EntityManager jpaEntityManager() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();

		return (EntityManager) request.getAttribute("entityManager");
	}

}
