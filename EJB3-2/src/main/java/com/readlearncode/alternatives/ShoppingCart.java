package com.readlearncode.alternatives;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
@ManagedBean
public class ShoppingCart {

    @Inject
    private PriceList priceList;

    public String ObtainPriceList(){
        return priceList.priceList();
    }

}