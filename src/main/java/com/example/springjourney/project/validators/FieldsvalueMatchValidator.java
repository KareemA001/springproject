package com.example.springjourney.project.validators;

import com.example.springjourney.project.annotations.FiledsValueMatch;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;

public class FieldsvalueMatchValidator implements ConstraintValidator<FiledsValueMatch,Object> {

    private String field;
    private String fieldMatch;

    public void initialize(FiledsValueMatch filedsValueMatch ) {
        this.field = filedsValueMatch.field();
        this.fieldMatch = filedsValueMatch.fieldMatch();
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext cVC){
        Object fiedlValue = new BeanWrapperImpl(object).getPropertyValue(field);
        Object fieldValueMatch = new BeanWrapperImpl(object).getPropertyValue(fieldMatch);

        if(fieldValueMatch != null){
            return fieldValueMatch.equals(fiedlValue);
        }else
            return fieldValueMatch == null ;
    }


}
