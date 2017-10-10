package com.readlearncode.hashtag100DaysOfJavaEE8;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.EAN;
import org.hibernate.validator.constraints.time.DurationMax;

import javax.validation.constraints.Email;
import javax.validation.constraints.NegativeOrZero;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.time.Year;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class BeanValidationChallenge {

    /*
    The Bean Validation 2.0 API introduces new constraint.
    Which of the following are among those new constraints?
     */

    @NotBlank String id;                // 1
    @EAN String barcode;                // 2
    @Email String email;                // 3
    @DurationMax int length;            // 4
    @NegativeOrZero int daysToRelease;  // 5
    @PastOrPresent Year released;       // 6
    @CreditCardNumber String ccNumber;  // 7




    /*
    Answer: 1, 3, 5, 6
     */
}