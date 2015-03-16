package my.ostamatii.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import my.ostamatii.abstracts.Name;

public class NameValidator implements ConstraintValidator<Named, Name> {
	 
	@Override
	public boolean isValid(Name name, ConstraintValidatorContext arg1) {
		if(name == null) {
            return false;
        }
		return (name.getFirstName().matches( "[A-Z][a-zA-Z]*" )&&
				name.getLastName().matches( "[A-Z][a-zA-Z]*" ));
	}

	@Override
	public void initialize(Named arg0) {	
	}

	
 
}
