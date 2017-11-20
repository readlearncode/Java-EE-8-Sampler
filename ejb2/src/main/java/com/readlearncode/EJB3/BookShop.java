package com.readlearncode.EJB3;

import com.readlearncode.EJB2.Book;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
@Stateless
@Remote
@Local
public class BookShop {

    public List<Book> listBooks() {
        return new ArrayList<>();
    }
}