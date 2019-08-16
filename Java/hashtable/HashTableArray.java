/**
 * @author Mukul Milind Mishra [mukulmilind23@gmail.com]
 * Hash Table also called as maps, dictionary, is ADT where data can be accessed via key
 * Very fast and efficient data structure to provide speedy retrival of data using key.
 * Hashing is a technique to map every key of the object to int.
 * Load factor tells how full the has table is and is important to decide when to resize the
 * backing array containing the hash values[keys].
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

class SimpleHashTable {
    private Employee[] hashTable;
    
    public SimpleHashTable() {
        hashTable = new Employee[10]; 
    }

    public void put(String key, Employee employee) {
        int hashedKey = hashKey(key);
        if (hashTable[hashedKey] != null) {
            System.out.println("Sorry, there is already an employee at position: " + hashedKey);
        } else {
            hashTable[hashedKey] = employee;
        } 
    }

    public Employee get(String key) {
        int hashedKey = hashKey(key);
        return hashTable[hashedKey];
    }

    private int hashKey(String key) {
        return key.length() % hashTable.length;
    }

    public void printHashTable() {
        for (int i = 0; i < hashTable.length; i++) {
            System.out.println(hashTable[i]);
        }
    }
}

public class HashTableArray {
    public static void main(String [] args) {
        Employee mukul = new Employee("Mukul", "Mishra", 123);
        Employee pratibha = new Employee("Pratibha", "Mishra", 234);
        Employee aparna = new Employee("Aparna", "Mishra", 345);
        Employee uday = new Employee("Uday", "Mishra", 456);
        Employee poonam = new Employee("Poonam", "Mishra", 567);

        SimpleHashTable ht = new SimpleHashTable();
        
        ht.put("mukul", mukul);
        ht.put("pratibha", pratibha);
        ht.put("aparna", aparna);
        // This would print the sorry message
        // ht.put("mukul", mukul);

        ht.put("uday", uday);
        ht.put("poonammis", poonam);

        // ht.printHashTable();

        System.out.println("Retrieve employee with key mukul " + ht.get("mukul"));
    }
}