// Java program to illustrate creating an array of objects 

class Employee {
	public int empNo;
	public String name;
	Employee (int empNo, String name) {
		this.empNo = empNo;
		this.name = name;
	}
}

// Elements of array are objects of a class Employee.
class ArrayofObjects {
	public static void main(String [] args) {
		// Declare an array of Employee
		Employee [] arr;

		// allocating memory for 2 objects of type Employee
		arr = new Employee[5];

		// initialize array elements 
		arr[0] = new Employee(1, "Mukul");
		arr[1] = new Employee(2, "Milind");
		arr[2] = new Employee(3, "Pratibha");
		arr[3] = new Employee(4, "Aparna");
		arr[4] = new Employee(5, "Uday");

		for (int i=0; i<arr.length; i++){
			System.out.println("Name of Employee ID : " + arr[i].empNo + " - " + arr[i].name);
		}
	}
}