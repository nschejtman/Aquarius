package security;

import org.securityfilter.filter.SecurityFilter;

import javax.servlet.*;
import java.io.IOException;

public class Secured implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        SecurityFilter filter = new SecurityFilter();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        filterChain.doFilter(servletRequest, servletResponse);



    }

    @Override
    public void destroy() {

    }

    /**
     * Que quiero?
     * Quiero que cuando un cliente solicite una pagina, que se fije en la sesión si el usuario es un usuario registrado
     * o no.
     *
     * Como funcionaría?
     * Un usuario no registrado accede a una página filtrada. Al no estar registrado el security filter lo redirige al
     * login.jsp
     *
     * Yo recibo un request con los distintos inputs y su determinado valor. Lo que hago es leer ese input y fijarme si
     * realmente esta registrado en la base de datos.
     *
     * Idea: usar un booleano a ver si esta registrado para no tener que hacer la verificación cada vez que recargo una
     * página. Problema: La seguridad con ese booleano.
     *
     *
     * ATENCIÓN
     * Un problema típico de seguridad es la inyección de código SQL para simular el registro del usuario. Para evitar
     * esto se debe buscar una manera de proteger y restringir la base de datos del cliente.
     *
     *
     */
}
