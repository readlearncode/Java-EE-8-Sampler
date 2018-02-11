package com.readlearncode.constraints.positiveorzero;

import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.util.concurrent.atomic.LongAdder;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class Numbers {

    @PositiveOrZero
    private int aPrimitiveNumber;
    @PositiveOrZero
    private BigDecimal aBigDecimal;
    @PositiveOrZero
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