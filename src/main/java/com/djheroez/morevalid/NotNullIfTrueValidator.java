package com.djheroez.morevalid;

import java.lang.reflect.Field;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NotNullIfTrueValidator  implements ConstraintValidator<NotNullIfTrue, Object> {
    private static final Logger logger = LoggerFactory.getLogger(NotNullIfTrueValidator.class);
    private String ifTrue;
    private String notNull;

    @Override
    public void initialize(final NotNullIfTrue constraintAnnotation) {
        this.ifTrue = constraintAnnotation.ifTrue();
        this.notNull = constraintAnnotation.notNull();
    }

    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext context) {
        boolean isValid = false;

        if (value != null) {
            
            try {
                Field ifTrueField = value.getClass().getDeclaredField(this.ifTrue);
                ifTrueField.setAccessible(true);

                Boolean ifTrueValue = Boolean.valueOf(String.valueOf(ifTrueField.get(value)));

                Field notNullField = value.getClass().getDeclaredField(this.notNull);
                notNullField.setAccessible(true);
                Object notNullFieldValue = notNullField.get(value);

                if(!ifTrueValue) {
                    isValid = true;
                } else if(ifTrueValue && notNullFieldValue != null) {
                    isValid = true;
                }
                
            } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
                logger.error("Ocurrió un error al realizar la validación", e);
            } 
        } else {
            isValid = true;
        }
        return isValid;
    }
}