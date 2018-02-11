package com.readlearncode.constraints.negative;

import javax.validation.constraints.Negative;
import java.math.BigDecimal;
import java.util.concurrent.atomic.LongAdder;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class Numbers {

    @Negative
    private int aPrimitiveNumber;
    @Negative
    private BigDecimal aBigDecimal;
    @Negative
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