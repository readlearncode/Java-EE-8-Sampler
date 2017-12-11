package com.readlearncode.httpauthenticationmechanism;

import javax.annotation.security.DeclareRoles;
import javax.security.enterprise.authentication.mechanism.http.BasicAuthenticationMechanismDefinition;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
@BasicAuthenticationMechanismDefinition(realmName = "user-realm")
@WebServlet("/user")
@DeclareRoles({"admin", "user", "demo"})
@ServletSecurity(@HttpConstraint(rolesAllowed = "user"))
public class UserServlet extends HttpServlet {

    // Servlet Code

}
