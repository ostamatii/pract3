package my.ostamatii.components;

import javax.validation.constraints.*;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import my.ostamatii.abstracts.Name;

@Component("dogNameBean")
@Scope("prototype")
public class DogName implements Name{

	@NotNull(message = "   Error: first name can't be null")
	private String firstName;
	private String lastName;

	@Override
	public String getName() {
		return lastName+"  "+firstName;
	}

	public void setFirstName(String name) {
		this.firstName = name;
	}
	
	public void setLastName(String name) {
		this.lastName = name;
	}

	@Override
	public String getFirstName() {
		
		return firstName;
	}

	@Override
	public String getLastName() {
		return lastName;
	}
	
}
