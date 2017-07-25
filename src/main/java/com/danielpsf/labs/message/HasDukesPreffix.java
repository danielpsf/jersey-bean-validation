package com.danielpsf.labs.message;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = HasDukesPreffix.Validator.class)
public @interface HasDukesPreffix {

    String message() default "{message.error.invalid_prefix}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    public class Validator implements ConstraintValidator<HasDukesPreffix, Message> {

        @Override
        public void initialize(HasDukesPreffix constraintAnnotation) {
        }

        @Override
        public boolean isValid(Message message, ConstraintValidatorContext context) {
            return message.getContent().toLowerCase().startsWith("duke: ") ? true : false;
        }

    }
}
