package com.readlearncode.EJB2;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public interface BookShopRemote extends EJBObject {
     List<Book> listBooks() throws RemoteException;
}
