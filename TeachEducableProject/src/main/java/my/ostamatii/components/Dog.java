package my.ostamatii.components;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.validation.constraints.NotNull;

import my.ostamatii.abstracts.Educable;
import my.ostamatii.abstracts.Name;
import my.ostamatii.validation.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("dogBean")
@Scope("prototype")
public class Dog implements Educable {

	@Named
	private Name name;
	List<String> skills =new ArrayList<String>();
	
	@Autowired
	@Qualifier("dogNameBean")
	@Override
	public void setName(Name name) {
		this.name = name;
	}

	@Override
	public Name getName() {
		return name;
	}

	@Override
	public void learn(String task) {
		skills.add(task);	
	}
	
	@Override
	public void showSkills() {
		System.out.println("My nickname is " + name.getName()+".\nMy skills are:");
		int n = 1;
		for(Iterator<String> i = skills.iterator(); i.hasNext(); ) {
		    String item = i.next();
		    System.out.println(n+". "+item);
		    n++;
		}
	}
}
