import my.ostamatii.abstracts.Name;
import my.ostamatii.components.Child;
import my.ostamatii.components.Dog;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	
	
	public static void main( String[] args )
    {
		
		ApplicationContext context = 
        		new ClassPathXmlApplicationContext("SpringBean.xml");
	    
        Child child = (Child) context.getBean("childBean");
        Dog dog = (Dog) context.getBean("dogBean");
        Name namep = (Name) context.getBean("personNameBean");
        Name named = (Name) context.getBean("dogNameBean");
		
		namep.setFirstName("Kateryna");
        namep.setLastName("Ostamatii");
        child.setName(namep);
        child.learn("Poems");
        child.learn("Playing Piano");
        child.showSkills();
        
        System.out.println("");
        
        named.setFirstName("Rex");
        named.setLastName("");
        dog.setName(named);
        dog.learn("sit");
        dog.learn("roar");
        dog.showSkills();

    }
	
}
