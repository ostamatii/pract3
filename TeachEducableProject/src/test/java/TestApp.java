import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import my.ostamatii.abstracts.Educable;
import my.ostamatii.abstracts.Name;
import my.ostamatii.components.Child;
import my.ostamatii.components.Dog;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestApp {

	private static ValidatorFactory vf;
	private static Validator validator;
	private static Child child;
	private static Dog dog;
	private static Name name;
	private static ApplicationContext context;
		
	 /**
	   * Setting up the validator and model data.
	 **/
	
	@BeforeClass
	public static void setup(){
	    vf = Validation.buildDefaultValidatorFactory();
	    validator = vf.getValidator();
	    context = new ClassPathXmlApplicationContext("SpringBean.xml");
        child = (Child) context.getBean("childBean");
        dog = (Dog) context.getBean("dogBean");
        name = (Name) context.getBean("personNameBean");
	}
	 		 
	@Test
	public void testRightChild() {
		System.out.println("Testing right child name: ");
        name.setFirstName("Kateryna");
        name.setLastName("Ostamatii");
        child.setName(name);
        validateAndPrintErrors(child);    
	}
	
	@Test
	public void testWrongChild() {
		System.out.println("Testing wrong child name: ");
        child.setName(null);
        validateAndPrintErrors(child);
        
        name.setFirstName("9032a");
        name.setLastName("Ost//matii");
        child.setName(name);
        validateAndPrintErrors(child);       
	}
	
	@Test
	public void testWrongName() {
		System.out.println("Testing wrong last and first names: ");
        name.setFirstName(null);
        name.setLastName(null);
        validateAndPrintErrorsName(name);  
	}

	@Test
	public void testRightDog() {
		System.out.println("Testing right dog name: ");
        name.setFirstName("Tuzik");
        dog.setName(name);
        validateAndPrintErrors(dog);  
	}
	
	@Test
	public void testWrongDog() {
		System.out.println("Testing wrong dog name: ");
		dog.setName(null);
        validateAndPrintErrors(dog);
        
        name.setFirstName("9032a");
        dog.setName(name);
        validateAndPrintErrors(dog);
	}
	
	private static void validateAndPrintErrors(Educable ed){
		Set<ConstraintViolation<Educable>> violations = validator.validate(ed);
		for ( ConstraintViolation<Educable> viol : violations){
			      System.out.println(viol.getMessage());
		}
		assertEquals(0, violations.size());
	}
	
	private static void validateAndPrintErrorsName(Name ed){
		Set<ConstraintViolation<Name>> violations = validator.validate(ed);
		for ( ConstraintViolation<Name> viol : violations){
			      System.out.println(viol.getMessage());
		}
		assertEquals(0, violations.size());
	}
	
}
