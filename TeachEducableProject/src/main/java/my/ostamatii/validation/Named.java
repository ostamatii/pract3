package my.ostamatii.validation;

 
import java.lang.annotation.Documented;

import static java.lang.annotation.ElementType.*;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
 
@Documented
@Constraint(validatedBy = NameValidator.class)
@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@NotNull (message = "   Error: Name can't be null")
public @interface Named {
    String message() default "   Error: Name can contain only letters and can't be null";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}