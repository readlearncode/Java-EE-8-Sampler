package com.readlearncode.securitycontext;

import javax.inject.Inject;
import javax.security.enterprise.SecurityContext;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
@WebServlet("/securityContextServlet")
@ServletSecurity(@HttpConstraint(rolesAllowed = "admin"))
public class SecurityContextServlet extends HttpServlet {

    @Inject
    private SecurityContext securityContext;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // Example 1: Is the caller is one of the three roles: admin, user and demo
        PrintWriter pw = response.getWriter();
        boolean role = securityContext.isCallerInRole("admin");
        pw.write("User has role 'admin': " + role + "\n");

        role = securityContext.isCallerInRole("user");
        pw.write("User has role 'user': " + role + "\n");

        role = securityContext.isCallerInRole("demo");
        pw.write("User has role 'demo': " + role + "\n");

        // Example 2: What is the caller principal name
        String contextName = null;
        if (securityContext.getCallerPrincipal() != null) {
            contextName = securityContext.getCallerPrincipal().getName();
        }
        response.getWriter().write("context username: " + contextName + "\n");

        // Example 3: Retrieve all CustomPrincipal
        Set<CustomPrincipal> customPrincipals = securityContext.getPrincipalsByType(CustomPrincipal.class);
        for (CustomPrincipal customPrincipal : customPrincipals) {
            response.getWriter().write((customPrincipal.getName()));
        }

    }

}