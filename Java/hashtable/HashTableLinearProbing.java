/**
 * @author Mukul Milind Mishra [mukulmilind23@gmail.com]
 * Hash Table also called as maps, dictionary, is ADT where data can be accessed via key
 * Very fast and efficient data structure to provide speedy retrival of data using key.
 * Hashing is a technique to map every key of the object to int.
 * Linear probing is done by incrementing the hash array index untill we find an emplty slot.
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

class StoredEmployee {
    public String key;
    public Employee employee;

    public StoredEmployee(String key, Employee employee) {
        this.key = key;
        this.employee = employee;
    }   
}

class SimpleHashTable {
    private StoredEmployee[] hashTable;
    
    public SimpleHashTable() {
        hashTable = new StoredEmployee[10]; 
    }

    public void put(String key, Employee employee) {
        int hashedKey = hashKey(key);
        if (occupied(hashedKey)) {
            int stopIndex = hashedKey;
            if (hashedKey == hashTable.length - 1) {
                hashedKey = 0;
            } else {
                hashedKey++;
            }
            while(occupied(hashedKey) && hashedKey != stopIndex) {
                hashedKey = (hashedKey + 1) % hashTable.length;
            }
        }

        if (occupied(hashedKey)) {
            System.out.println("Sorry, there is already an employee at position: " + hashedKey);
        } else {
            hashTable[hashedKey] = new StoredEmployee(key, employee);
        } 
    }

    public Employee get(String key) {
        int hashedKey = findKey(key);
        if (hashedKey == -1) return null;

        return hashTable[hashedKey].employee;
    }

    public Employee remove(String key) {
        int hashedKey = findKey(key);
        if (hashedKey == -1) {
            return null;
        }

        Employee employee = hashTable[hashedKey].employee;
        hashTable[hashedKey] = null;
        return employee;
    }

    private int findKey(String key) {
        int hashedKey = hashKey(key);
        if (hashTable[hashedKey] != null && hashTable[hashedKey].key.equals(key)) {
            return hashedKey;
        } 
        int stopIndex = hashedKey;
        if (hashedKey == hashTable.length - 1) {
            hashedKey = 0;
        } else {
            hashedKey++;
        }
        while(hashedKey != stopIndex && hashTable[hashedKey] != null 
            && !hashTable[hashedKey].key.equals(key)) {
            hashedKey = (hashedKey + 1) % hashTable.length;
        }

        if (hashTable[hashedKey] != null && hashTable[hashedKey].key.equals(key)) {
            return hashedKey;
        } else {
            return -1;
        }
    }

    private int hashKey(String key) {
        return key.length() % hashTable.length;
    }

    private boolean occupied(int index) {
        return hashTable[index] != null;
    }

    public void printHashTable() {
        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i] == null) {
                System.out.println("Empty");
            } else {
                System.out.println("Position " + i + " : " + hashTable[i].employee);
            }
        }
    }
}

public class HashTableLinearProbing {
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
        ht.put("uday", uday);
        ht.put("poonam", poonam);

        ht.printHashTable();

        System.out.println("Retrieve employee with key mukul " + ht.get("mukul"));
        System.out.println("Retrieve employee with key mukul " + ht.get("poonam"));

        ht.remove("poonam");
        ht.remove("uday");

        ht.printHashTable();

        ht.put("uday", uday);
        ht.put("poonam", poonam);

        ht.printHashTable();
    }
}