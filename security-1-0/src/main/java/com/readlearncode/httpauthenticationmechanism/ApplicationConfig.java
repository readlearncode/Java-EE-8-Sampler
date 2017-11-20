package com.readlearncode.httpauthenticationmechanism;

import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.authentication.mechanism.http.FormAuthenticationMechanismDefinition;
import javax.security.enterprise.authentication.mechanism.http.LoginToContinue;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
@FormAuthenticationMechanismDefinition(
        loginToContinue = @LoginToContinue(
                loginPage = "/login-servlet",
                errorPage = "${applicationConfigImmediate.loginPage}",
                useForwardToLogin = false
        )
)
@ApplicationScoped
public class ApplicationConfig {

    // Config Code

}
