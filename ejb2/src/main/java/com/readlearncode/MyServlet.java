package com.readlearncode;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
@WebServlet(name = "FrontControllerServlet", urlPatterns = {"/*"},
        initParams = {@WebInitParam(name = "defaultPage", value = "default.jsp")})
public class MyServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String language = req.getHeader("Accept-Language");
        resp.addHeader("X-Pingback", "http://www.example.org/xmlrpc/");
        resp.sendError(HttpServletResponse.SC_FORBIDDEN, "Access Forbidden");
    }
}