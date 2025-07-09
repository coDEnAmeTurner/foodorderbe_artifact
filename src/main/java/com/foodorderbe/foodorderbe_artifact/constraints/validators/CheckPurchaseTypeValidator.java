package com.foodorderbe.foodorderbe_artifact.constraints.validators;

import com.foodorderbe.foodorderbe_artifact.constraints.annotations.CheckPurchaseType;
import com.foodorderbe.foodorderbe_artifact.constraints.constraint_utils.PurchaseType;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CheckPurchaseTypeValidator implements ConstraintValidator<CheckPurchaseType, String> {
    private PurchaseType[] purchaseType;

    @Override
    public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
        boolean isValid = false;
        for (PurchaseType purchaseType2 : purchaseType) {
            if (purchaseType2.name().equals(arg0))
                isValid = true;
        }
        
        return isValid;
    }

    @Override
    public void initialize(CheckPurchaseType constraintAnnotation) {
        purchaseType = constraintAnnotation.value();
    }
    
}
