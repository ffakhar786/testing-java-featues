package how2do.injava;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class EmployeeDemo {
	List<Employee> empList = new ArrayList<>(15);

	public EmployeeDemo() {
		try {
			DateFormat df = new SimpleDateFormat("yyyyMMdd");
			Date d = null;

			d = df.parse("19990605");
			empList.add(new Employee(8, "emp8", d));
			d = df.parse("19690205");
			empList.add(new Employee(5, "emp5", d));
			d = df.parse("19890215");
			empList.add(new Employee(1, "emp1", d));
			d = df.parse("20020905");
			empList.add(new Employee(9, "emp9", d));
			d = df.parse("19780315");
			empList.add(new Employee(2, "emp2", d));
			d = df.parse("20030105");
			empList.add(new Employee(11, "emp11", d));
			d = df.parse("19960725");
			empList.add(new Employee(4, "emp4", d));			
			d = df.parse("19790305");
			empList.add(new Employee(6, "emp6", d));
			d = df.parse("19910314");
			empList.add(new Employee(3, "emp3", d));
			d = df.parse("19890105");
			empList.add(new Employee(7, "emp7", d));
			d = df.parse("19990405");
			empList.add(new Employee(10, "emp10", d));
		} catch (Exception e) {

		}
	}

	public static void main(String[] args) throws Exception {
		EmployeeDemo obj = new EmployeeDemo();
		obj.doIt();
	}
	
	public void doIt() {
		// filter out employee joined after 1991  
		///empList.stream().filter(null)
		System.out.println(empList);
		Comparator<Employee> c = ( e1, e2) -> {return e1.getId() - e2.getId() ;};
		//Collections.sort(empList, ( e1, e2) -> {return e1.getId() - e2.getId() ;});
		//Collections.sort(empList, c); 		System.out.println(empList);
		List<Employee> sbList = empList.stream().filter(e-> e.getId()>8).collect(Collectors.toList());
		/*List<Employee> sbList1 = empList.stream().filter(
				(Employee e1, Employee e2) ->  e1.getJoinDate().getTime() - e2.getJoinDate().getTime()
				).collect(Collectors.toList());*/
		System.out.println(sbList);

		
	}

}

class Employee // implements Comparator<Employee>
{
	private Integer id;
	private String name;
	private Date joinDate;

	public Employee(Integer id, String name, Date joinDate) {
		this.id = id;
		this.name = name;
		this.joinDate = joinDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	@Override
	public String toString() {
		DateFormat df = new SimpleDateFormat("MM/dd/yy");
		String d = df.format(joinDate);
		return "Employee [id=" + id + ", name=" + name + ", joinDate=" + d + "]";
	}

	/*@Override
	public int compare(Employee o1, Employee o2) {
		return o1.joinDate.getTime() > o2.joinDate.getTime() ? 1: o1.joinDate.getTime() == o2.joinDate.getTime() ? 0 : -1 ;
	}*/
	
	
}