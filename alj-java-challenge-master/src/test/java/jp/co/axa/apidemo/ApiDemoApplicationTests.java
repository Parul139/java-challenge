package jp.co.axa.apidemo;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.repositories.EmployeeRepository;



@RunWith(SpringRunner.class)
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class ApiDemoApplicationTests {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Test
	public void contextLoads() {
	}

	// JUnit test for saveEmployee
	@Test
	@Order(1)
	public void saveEmployeeTest(){

		Employee employee = Employee.builder()
				.name("Ramesh")
				.salary("10000")
				.department("Cyber Security")
				.build();

		employeeRepository.save(employee);

		Assertions.assertThat(employee.getId()).isGreaterThan(0);
	}

	// JUnit test for getEmployee
	@Test
	@Order(2)
	public void getEmployeeTest(){

		Employee employee = employeeRepository.findById(1L).get();

		Assertions.assertThat(employee.getId()).isEqualTo(1L);

	}

	// JUnit test to retrieve all Employees
	@Test
	@Order(3)
	public void getListOfEmployeesTest(){

		List<Employee> employees = employeeRepository.findAll();

		Assertions.assertThat(employees.size()).isGreaterThan(0);

	}

	// JUnit test to update Employee details
	@Test
	@Order(4)
	@Rollback(value = false)
	public void updateEmployeeTest(){

		Employee employee = employeeRepository.findById(1L).get();

		employee.setName("Parul");

		Employee employeeUpdated =  employeeRepository.save(employee);

		Assertions.assertThat(employeeUpdated.getName()).isEqualTo("Parul");

	}

	// JUnit test to update Employee details
	@Test
	@Order(5)
	@Rollback(value = false)
	public void deleteEmployeeTest(){


		employeeRepository.deleteById(1L);
		Assertions.assertThat(employeeRepository.existsById(1L)).isFalse();
	}
}
