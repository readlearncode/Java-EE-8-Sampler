package com.readlearncode.identitystore;

import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import javax.security.enterprise.identitystore.IdentityStore;
import java.util.HashSet;

import static java.util.Arrays.asList;
import static javax.security.enterprise.identitystore.CredentialValidationResult.INVALID_RESULT;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
@ApplicationScoped
public class LiteWeightIdentityStore implements IdentityStore {

    public CredentialValidationResult validate(UsernamePasswordCredential userCredential) {

        if (userCredential.compareTo("admin", "pwd1")) {
            return new CredentialValidationResult("admin", new HashSet<>(asList("admin", "user", "demo")));
        }

        return INVALID_RESULT;
    }

}

