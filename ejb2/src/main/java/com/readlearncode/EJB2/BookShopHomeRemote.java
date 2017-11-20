package com.readlearncode.EJB2;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public interface BookShopHomeRemote extends EJBHome {
    BookShopRemote create() throws RemoteException, CreateException;
}
