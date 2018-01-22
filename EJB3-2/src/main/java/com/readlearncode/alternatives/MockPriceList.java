package com.readlearncode.alternatives;

import javax.enterprise.inject.Alternative;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
@Alternative
public class MockPriceList implements PriceList {
    public String priceList() {
        // use hard code prices for testing
        return "Mock Price List";
    }
}