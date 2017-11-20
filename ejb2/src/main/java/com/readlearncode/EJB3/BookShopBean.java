package com.readlearncode.EJB3;

import com.readlearncode.EJB2.Book;

import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.List;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
@Stateless
public class BookShopBean {

    public List<Book> listBooks() throws NamingException {
        Object obj = new InitialContext().lookup("java:comp/env/ejb/BookShop");
        return ((BookShop) obj).listBooks();
    }

}