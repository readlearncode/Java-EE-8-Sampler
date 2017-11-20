package com.readlearncode.EJB2;

import javax.ejb.EJBHome;
import javax.ejb.EJBObject;
import javax.ejb.Handle;
import javax.ejb.RemoveException;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class BookHomeRemote implements BookShopRemote{
    @Override
    public List<Book> listBooks() throws RemoteException {
        return null;
    }

    @Override
    public EJBHome getEJBHome() throws RemoteException {
        return null;
    }

    @Override
    public Object getPrimaryKey() throws RemoteException {
        return null;
    }

    @Override
    public void remove() throws RemoteException, RemoveException {

    }

    @Override
    public Handle getHandle() throws RemoteException {
        return null;
    }

    @Override
    public boolean isIdentical(EJBObject obj) throws RemoteException {
        return false;
    }
}