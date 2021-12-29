package com.example.demo.maven.filter;

import com.example.demo.maven.LOG;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
@Order(1)
public class TransactionFilter implements Filter {

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        LOG.info(
                "Starting a transaction for req : %s",
                req.getRequestURI());

        chain.doFilter(request, response);
        LOG.info(
                "Committing a transaction for req : %s",
                req.getRequestURI());
    }

    // other methods
}