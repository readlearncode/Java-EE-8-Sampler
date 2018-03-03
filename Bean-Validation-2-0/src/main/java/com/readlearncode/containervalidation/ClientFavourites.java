package com.readlearncode.containervalidation;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class ClientFavourites {

    private List<@Valid Favourite> favourites = new ArrayList<>();

    public List<Favourite> getFavourites() {
        return favourites;
    }

    public void addFavourites(Favourite favourite) {
        favourites.add(favourite);
    }
}