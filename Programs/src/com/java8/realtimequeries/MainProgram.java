package com.java8.realtimequeries;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

import com.java8.models.Employee;

public class MainProgram {
	public static void main(String[] args) {
		List<Employee> list = getEmployeeList();
		
		//Count of Male & Female Employees
		System.out.println("===== Count of Male & Female Employees");
		Map<String, Long> collect = list.stream().collect(Collectors.groupingBy(e-> e.getGender(), Collectors.counting()));
		for(Entry<String, Long> entry : collect.entrySet() ) {
			System.out.println(entry.getKey()+ " " + entry.getValue());
		}
		//Print name of all department
		System.out.println("===== Name of all department");
		list.stream().map(e-> e.getDepartment()).distinct().forEach(System.out::println);
		
		System.out.println("===== Average Age of Male and Female employees");
		Map<String, Double> collect2 = list.stream().collect(Collectors.groupingBy(e->e.getGender(), Collectors.averagingInt(e->e.getAge())));
		for(Entry<String, Double> entry : collect2.entrySet() ) {
			System.out.println(entry.getKey()+ " " + entry.getValue());
		}
		System.out.println("===== Details of Highest paid employee");
		Employee employee = list.stream().max(Comparator.comparingDouble(e-> e.getSalary())).get();
		System.out.println(employee);

		//Another way
		Optional<Employee> collect6 = list.stream()
				.collect(Collectors.maxBy(Comparator.comparingDouble(e -> e.getSalary())));
		System.out.println(collect6.get());
		
		System.out.println("===== Employee names who have joined after 2015");
		list.stream().filter(e->e.getYearofJoining() > 2015).map(e-> e.getName()).forEach(System.out::println);
		
		System.out.println("===== Count of Employees in Each Department");
		Map<String, Long> collect3 = list.stream().collect(Collectors.groupingBy(e->e.getDepartment(), Collectors.counting()));
		collect3.forEach((k,v)-> System.out.println(k + "-" + v));
		
		System.out.println("===== Average salary in Each Department");
		Map<String, Double> collect4 = list.stream().collect(Collectors.groupingBy(e->e.getDepartment(), Collectors.averagingDouble(e->e.getSalary())));
		collect4.forEach((k,v) -> System.out.println(k + "-" + v));
		
		System.out.println("===== Details of youngest employee in IT Department");
		Employee employee2 = list.stream()
				.filter(e -> e.getDepartment().equalsIgnoreCase("IT") && e.getGender().equalsIgnoreCase("male"))
				.min(Comparator.comparingInt(e -> e.getAge())).get();
		System.out.println(employee2);
		
		System.out.println("===== Employee who has most working experience");
		Employee employee3 = list.stream().min(Comparator.comparingInt(e->e.getYearofJoining())).get();
		System.out.println(employee3);
		
		//Another way
		Employee employee4 = list.stream().sorted(Comparator.comparingInt(e -> e.getYearofJoining())).findFirst().get();
		System.out.println(employee4);
		
		System.out.println("===== Male and Female employees in TV");
		Map<String, Long> collect5 = list.stream().filter(e -> e.getDepartment() == "TV")
				.collect(Collectors.groupingBy(e -> e.getGender(), Collectors.counting()));
		System.out.println(collect5);
		
		System.out.println("===== Average Salary of male & female employee");
		Map<String, Double> collect7 = list.stream().collect(Collectors.groupingBy(e->e.getGender(), Collectors.averagingDouble(e->e.getSalary())));
		System.out.println(collect7);
		
		System.out.println("===== All Employees in each department");
		Map<String, List<Employee>> collect8 = list.stream().collect(Collectors.groupingBy(e->e.getDepartment()));
		collect8.forEach((k,v)-> {
			System.out.println("Department :"+ k);
			v.forEach(e-> e.getName());
		});
	}
	
	public static List<Employee> getEmployeeList() {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(111, "Ravi Sharma", 32, "Male", "IT", 2011, 25000.0));
		employees.add(new Employee(112, "Shivam Shukla", 25, "Male", "Farji", 2010, 55000.0));
		employees.add(new Employee(113, "Prashant Chouksey", 45, "Male", "IT", 2011, 55000.0));
		employees.add(new Employee(114, "Glenn Maxwell", 56, "Male", "Sports", 2015, 15000.0));
		employees.add(new Employee(115, "Sachin Tendulkar", 90, "Male", "Sports", 2001, 75000.0));
		employees.add(new Employee(116, "Virat Kohli", 31, "Male", "Sports", 2011, 45000.0));
		employees.add(new Employee(117, "Sir Jadeja", 34, "Male", "Sports", 2011, 15000.0));
		employees.add(new Employee(118, "Ashvin Srinivasan", 12, "Male", "Sports", 2011, 25000.0));
		employees.add(new Employee(119, "Nitin Joshi", 18, "Male", "HR", 2001, 15000.0));
		employees.add(new Employee(120, "Nima Roy", 54, "Female", "HR", 2018, 35000.0));
		employees.add(new Employee(121, "Jasna Thakur", 78, "Female", "HR", 1978, 28000.0));
		employees.add(new Employee(122, "Prince Thakur", 23, "Male", "Finance", 2000, 45000.0));
		employees.add(new Employee(123, "Kapil Sharma", 27, "Male", "Finance", 2015, 15000.0));
		employees.add(new Employee(124, "Sumona Joshi", 44, "Female", "Finance", 1989, 15000.0));
		employees.add(new Employee(125, "Ali Baig", 34, "Male", "Blue Collar", 1901, 25000.0));
		employees.add(new Employee(126, "Murali Gowda", 98, "Male", "Blue Collar", 1995, 55000.0));
		employees.add(new Employee(127, "Paul walker", 33, "Male", "TV", 2018, 75000.0));
		employees.add(new Employee(128, "vin deseal", 56, "Male", "TV", 2015, 78000.0));
		employees.add(new Employee(129, "Emma Stone", 78, "Female", "TV", 2023, 25000.0));
		employees.add(new Employee(130, "Ryan raynolds", 77, "Male", "TV", 2003, 45000.0));
		employees.add(new Employee(130, "Akash Parmar", 18, "Male", "Farji", 2020, 45000.0));
		return employees;
	}
}
