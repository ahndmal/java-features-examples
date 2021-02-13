package com.anma.java.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/")
public class GetServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String scheme = req.getScheme();
        String serverName = req.getServerName();
        int portNumber = req.getServerPort();
        String contextPath = req.getContextPath();
        String servletPath = req.getServletPath();
        String pathInfo = req.getPathInfo();
        String remoteHost = req.getRemoteHost();
        String URI = req.getRequestURI();
        String URL = req.getRequestURL().toString();

        req.setAttribute("scheme", scheme);
        req.setAttribute("serverName", serverName);
        req.setAttribute("portNumber", portNumber);
        req.setAttribute("contextPath", contextPath);
        req.setAttribute("servletPath", servletPath);
        req.setAttribute("pathInfo", pathInfo);
        req.setAttribute("remoteHost", remoteHost);
        req.setAttribute("URI", URI);
        req.setAttribute("URL", URL);

//        resp.getWriter().write("Remote host is " + remoteHost);
//        req.getRequestDispatcher("/web/html_pages/index.html").forward(req, resp);
        req.getRequestDispatcher("/web/jsp/index.jsp").forward(req, resp);
    }


    private String getHost(HttpServletRequest req) {

        String scheme = req.getScheme();

        String serverName = req.getServerName();
        int portNumber = req.getServerPort();
        String contextPath = req.getContextPath();

        return scheme + "://" + serverName + ":" + portNumber + contextPath;
    }
}
