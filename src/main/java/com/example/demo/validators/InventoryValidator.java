package com.example.demo.validators;

import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 *
 *
 *
 */
public class InventoryValidator implements ConstraintValidator<ValidInventory, Part> {
    @Autowired
    private ApplicationContext context;
    public static  ApplicationContext myContext;
    @Override
    public void initialize(ValidInventory constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Part part, ConstraintValidatorContext constraintValidatorContext) {
        if(part.getInv() > part.getMaxInv()){
            constraintValidatorContext.buildConstraintViolationWithTemplate("Inventory maxed out").addConstraintViolation();
            return false;
        }
        if(part.getInv() < part.getMinInv()){
            constraintValidatorContext.buildConstraintViolationWithTemplate("Inventory below minimum allowed").addConstraintViolation();
            return false;
        }

        return true;
    }
}
