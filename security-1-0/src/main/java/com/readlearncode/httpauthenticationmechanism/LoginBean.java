
package com.readlearncode.httpauthenticationmechanism;

import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.SecurityContext;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.Password;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static javax.faces.annotation.FacesConfig.Version.JSF_2_3;
import static javax.faces.application.FacesMessage.SEVERITY_ERROR;
import static javax.security.enterprise.AuthenticationStatus.SEND_CONTINUE;
import static javax.security.enterprise.AuthenticationStatus.SEND_FAILURE;
import static javax.security.enterprise.authentication.mechanism.http.AuthenticationParameters.withParams;

@FacesConfig(version = JSF_2_3)
@Named
@RequestScoped
public class LoginBean {
    
    @Inject
    private SecurityContext securityContext;

    @Inject
    private FacesContext facesContext;

    private String username, password;
    
    public void login() {
        
        Credential credential = new UsernamePasswordCredential(username, new Password(password));
        
        AuthenticationStatus status = securityContext.authenticate(
            getRequestFrom(facesContext),
            getResponseFrom(facesContext),
            withParams().credential(credential));
        
        if (status.equals(SEND_CONTINUE)) {
            facesContext.responseComplete();
        } else if (status.equals(SEND_FAILURE)) {
            addError(facesContext, "Authentication failed");
        }
        
    }
    
    private static HttpServletResponse getResponseFrom(FacesContext context) {
        return (HttpServletResponse) context
            .getExternalContext()
            .getResponse();
    }
    
    private static HttpServletRequest getRequestFrom(FacesContext context) {
        return (HttpServletRequest) context
            .getExternalContext()
            .getRequest();
    }
    
    private static void addError(FacesContext context, String message) {
        context
            .addMessage(
                null, 
                new FacesMessage(SEVERITY_ERROR, message, null));
    }

    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
