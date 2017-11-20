package com.readlearncode.identitystore;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
import javax.security.enterprise.identitystore.PasswordHash;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
@DatabaseIdentityStoreDefinition(
        dataSourceLookup = "${'java:global/permissions_db'}",
        callerQuery = "#{'select password from caller where name = ?'}",
        groupsQuery = "select group_name from caller_groups where caller_name = ?",
        hashAlgorithm = PasswordHash.class,
        priority = 10
)
@ApplicationScoped
@Named
public class ApplicationConfig {

    // Config code

}
