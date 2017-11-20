package com.readlearncode.identitystore;

import javax.annotation.security.DeclareRoles;
import javax.security.enterprise.identitystore.LdapIdentityStoreDefinition;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
@LdapIdentityStoreDefinition(
        url = "ldap://localhost:33389/",
        callerBaseDn = "ou=caller,dc=jsr375,dc=net",
        groupSearchBase = "ou=group,dc=jsr375,dc=net"
)
@DeclareRoles({"admin", "user", "demo"})
@WebServlet("/admin")
public class AdminServlet extends HttpServlet {

    // Servlet Code

}
