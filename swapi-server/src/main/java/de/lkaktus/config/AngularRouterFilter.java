package de.lkaktus.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AngularRouterFilter implements Filter {

    private final String[] angularRoutes = {"/details/"};

    private boolean isAngularRoute(String path) {
        boolean isAngularRoute = false;
        for (String angularRoute: this.angularRoutes){
            if (path.startsWith(angularRoute)) {
                isAngularRoute = true;
                break;
            }
        }
        return isAngularRoute;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        String path = req.getRequestURI();

        if(this.isAngularRoute(path)){
            req = new HttpServletRequestWrapper((HttpServletRequest) servletRequest) {
                @Override
                public String getRequestURI() {
                    return "/index.html";
                }
            };
        }

        filterChain.doFilter(req, res);
    }
}
