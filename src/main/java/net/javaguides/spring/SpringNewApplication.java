package net.javaguides.spring;

import net.javaguides.spring.model.Employee;
import net.javaguides.spring.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringNewApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringNewApplication.class, args);
	}

	@Autowired
	private EmpRepository empRepository;
//varargs
	@Override
	public void run(String[] args) throws Exception {
		Employee employee=new Employee();
		employee.setFirstName("Ratnadip");
		employee.setLastName("Debray");
		employee.setAge(22L);
		empRepository.save(employee);

		Employee employee1=new Employee();
		employee1.setFirstName("Simran");
		employee1.setLastName("Das");
		employee1.setAge(22L);
		empRepository.save(employee1);
	}
}
