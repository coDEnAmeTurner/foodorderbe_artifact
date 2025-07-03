package com.foodorderbe.foodorderbe_artifact.constraints.annotations;

import java.lang.annotation.Target;

import com.foodorderbe.foodorderbe_artifact.constraints.constraint_utils.PurchaseType;
import com.foodorderbe.foodorderbe_artifact.constraints.validators.CheckPurchaseTypeValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;

@Target({ FIELD, METHOD })
@Retention(RUNTIME)
@Constraint(validatedBy = CheckPurchaseTypeValidator.class)
@Documented
public @interface CheckPurchaseType {
    String message() default "{com.foodorderbe.foodorderbe_artifact.constraints.annotations." +
            "message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    PurchaseType[] value();
}
