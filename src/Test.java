import org.codehaus.jackson.map.ObjectMapper;

import com.app.Employee;

public class Test {

	public static void main(String[] args) {

		Employee emp = new Employee();
		emp.setEmpId(4545);
		emp.setEmpName("AAA");
		emp.setEmpSal(56.36);

		ObjectMapper om = new ObjectMapper();

		try {
			String json = om.writeValueAsString(emp);
			// System.out.println(json);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String json2 = "{\"empName\":\"AA\",\"empId\":99988,\"empSal\":65.36}";
		try {
			Employee emp2 = om.readValue(json2, Employee.class);
			System.out.println(emp2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}