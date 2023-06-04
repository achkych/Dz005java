import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.List;
import java.util.HashMap;


public class PhoneBook {
    private Map<String, List<String>> phoneBook = new HashMap<>();
    
    public void addContact(String lastName, String phoneNumber) {
        if (phoneBook.containsKey(lastName)) {
            List<String> numbers = phoneBook.get(lastName);
            numbers.add(phoneNumber);
            phoneBook.put(lastName, numbers);
        } else {
            List<String> numbers = new ArrayList<>();
            numbers.add(phoneNumber);
            phoneBook.put(lastName, numbers);
        }
    }
    
    public List<String> getPhoneNumbers(String lastName) {
        return phoneBook.getOrDefault(lastName, new ArrayList<>());
    }
    
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addContact("Иванов", "1234567");
        phoneBook.addContact("Иванов", "0234567");
        List<String> numbers = phoneBook.getPhoneNumbers("Иванов");
        System.out.println(numbers);
    }
}