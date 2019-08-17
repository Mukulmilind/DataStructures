import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Mukul Milind Mishra [mukulmilind23@gmail.com]
 * Java Implements Hash Table internally using maps. No two key can have same value.
 */

class Employee {
    private String firstName;
    private String lastName;
    private int id;

    public Employee(String firstName, String lastName, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee [firstName=" + firstName + ", id=" + id + ", lastName=" + lastName + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + id;
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        if (firstName == null) {
            if (other.firstName != null)
                return false;
        } else if (!firstName.equals(other.firstName))
            return false;
        if (id != other.id)
            return false;
        if (lastName == null) {
            if (other.lastName != null)
                return false;
        } else if (!lastName.equals(other.lastName))
            return false;
        return true;
    }
}

public class HashMapJDK {
    public static void main (String [] args) {
        Employee mukul = new Employee("Mukul", "Mishra", 123);
        Employee milind = new Employee("Mukul", "Milind", 321);
        Employee pratibha = new Employee("Pratibha", "Mishra", 234);
        Employee aparna = new Employee("Aparna", "Mishra", 345);
        Employee uday = new Employee("Uday", "Mishra", 456);
        Employee poonam = new Employee("Poonam", "Mishra", 567);

        Map<String, Employee> newHash = new HashMap<String, Employee>();

        newHash.put("mukul", mukul);
        newHash.put("pratibha", pratibha);
        newHash.put("aparna", aparna);

        System.out.println(newHash.containsKey("mukul"));
        System.out.println(newHash.containsValue(mukul));

        Employee employee = newHash.putIfAbsent("mukul", milind);
        System.out.println(employee);
        
        // Iterator<Employee> iter = newHash.values().iterator();
        // while(iter.hasNext()) {
        //     System.out.println(iter.next());
        // }
        
        newHash.forEach((k, v) -> System.out.println("Key: " + k + "Value: " + v)); 

    }
}
