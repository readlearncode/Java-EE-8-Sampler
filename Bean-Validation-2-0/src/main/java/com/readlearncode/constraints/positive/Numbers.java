package com.readlearncode.constraints.positive;

import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.concurrent.atomic.LongAdder;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class Numbers {

    @Positive
    private int aPrimitiveNumber;
    @Positive
    private BigDecimal aBigDecimal;
    @Positive
    private LongAdder aLongAdder;


    public int getAPrimitiveNumber() {
        return aPrimitiveNumber;
    }

    public void setAPrimitiveNumber(int aPrimitiveNumber) {
        this.aPrimitiveNumber = aPrimitiveNumber;
    }

    public BigDecimal getABigDecimal() {
        return aBigDecimal;
    }

    public void setABigDecimal(BigDecimal aBigDecimal) {
        this.aBigDecimal = aBigDecimal;
    }

    public LongAdder getALongAdder() {
        return aLongAdder;
    }

    public void setALongAdder(LongAdder aLongAdder) {
        this.aLongAdder = aLongAdder;
    }


}