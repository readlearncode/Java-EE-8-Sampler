package com.readlearncode.EJB2;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class BookShopBean implements SessionBean {

    public List<Book> listBooks() throws RemoteException, NamingException {
        Object obj = new InitialContext().lookup("java:comp/env/ejb/BookHomeRemote");
        BookHomeRemote home = (BookHomeRemote) PortableRemoteObject.narrow(obj, BookHomeRemote.class);
        return home.listBooks();
    }


    @Override
    public void setSessionContext(SessionContext sessionContext) throws EJBException, RemoteException {

    }

    @Override
    public void ejbRemove() throws EJBException, RemoteException {

    }

    @Override
    public void ejbActivate() throws EJBException, RemoteException {

    }

    @Override
    public void ejbPassivate() throws EJBException, RemoteException {

    }
}