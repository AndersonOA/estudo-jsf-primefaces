/**
 * 
 */
package br.com.makersweb.appjsf.web.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.makersweb.appjsf.web.model.UsuarioModel;

/**
 *
 * @author anderson.aristides
 *
 */
@WebFilter("/sistema/*")
public class AutenticacaoFilter implements Filter {

	public AutenticacaoFilter() {

	}

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpSession httpSession = ((HttpServletRequest) request).getSession();
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;

		if (httpServletRequest.getRequestURI().indexOf("index.xhtml") <= -1) {

			UsuarioModel usuarioModel = (UsuarioModel) httpSession.getAttribute("usuarioAutenticado");

			if (usuarioModel == null) {
				httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/index.xhtml");
			} else {
				chain.doFilter(request, response);
			}
		} else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
