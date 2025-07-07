package com.foodorderbe.foodorderbe_artifact.constraints.validators;

import com.foodorderbe.foodorderbe_artifact.constraints.annotations.CheckUserType;
import com.foodorderbe.foodorderbe_artifact.constraints.constraint_utils.UserTypeAuthority;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CheckUserTypeValidator implements ConstraintValidator<CheckUserType, String> {
    private UserTypeAuthority[] userType;

    @Override
    public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
        boolean isValid = false;
        for (UserTypeAuthority userType : userType) {
            if (userType.name().equals(arg0))
                isValid = true;
        }
        if ( !isValid ) {
            arg1.disableDefaultConstraintViolation();
            arg1.buildConstraintViolationWithTemplate(
                    "{com.foodorderbe.foodorderbe_artifact.constraints.annotations."
                            + "constraintvalidatorcontext.CheckUserType.message}"
            ).addConstraintViolation();
        }
        return isValid;
    }

    @Override
    public void initialize(CheckUserType constraintAnnotation) {
        userType = constraintAnnotation.value();
    }
    
}
