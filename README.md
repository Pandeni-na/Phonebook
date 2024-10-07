# Phonebook

### Efficient Phonebook Management System for a Namibian Telecommunications Company

## Group Members
[List all group members here along with their GitHub usernames]

## Project Overview
This project aims to implement an efficient phonebook system for a Namibian telecommunications company using basic linear data structures such as arrays or lists. 

The key operations include:
- Inserting contacts
- Searching contacts
- Deleting contacts
- Updating contacts
- Displaying contacts
- Sorting contacts (optional)

Additionally, search efficiency analysis is performed by analyzing the number of comparisons made.

### Project Sections
- **Section A**: Pseudocode and flowchart representations of the phonebook functionalities.
- **Section B**: Practical implementation using Java.

---

## 1. Project Objectives
1. **Insert Contact**: Add a new contact to the phonebook.
2. **Search Contact**: Search for a contact by name.
3. **Delete Contact**: Remove a contact from the phonebook.
4. **Update Contact**: Update the phone number of an existing contact.
5. **Display All Contacts**: Display all contacts in the phonebook.
6. **Sort Contacts**: Sort contacts alphabetically (optional).
7. **Analyze Search Efficiency**: Analyze search algorithm performance based on the number of comparisons.

---

## 2. Technologies Used
- **Programming Language**: Java
- **Data Structure**: ArrayList (for storing contact objects)
- **Development Environment**: IntelliJ IDEA, Eclipse, or any other Java IDE
- **Version Control**: Git and GitHub for collaboration

---

## 3. Algorithm Design (Section A)

### 3.1 Pseudocode

#### Insert Contact:
```plaintext
Function InsertContact(phonebook, contact):
    If phonebook is full:
        Display "Phonebook is full"
    Else:
        Add contact to phonebook
        Display "Contact added successfully"

#### Search Contact:
Function SearchContact(phonebook, name):
    For each contact in phonebook:
        If contact.name equals name:
            Return contact
    Return "Contact not found"

#### Display All Contacts
Function DisplayAllContacts(phonebook):
    If phonebook is empty:
        Display "Phonebook is empty"
    Else:
        For each contact in phonebook:
            Display contact.name and contact.number

#### Delete Contacts
Function DeleteContact(phonebook, name):
    For each contact in phonebook:
        If contact.name equals name:
            Remove contact from phonebook
            Display "Contact deleted"
            Return
    Display "Contact not found"

#### Update Contacts
Function UpdateContact(phonebook, name, newNumber):
    For each contact in phonebook:
        If contact.name equals name:
            contact.number = newNumber
            Display "Contact updated successfully"
            Return
    Display "Contact not found"
#### Sort Contacts
Function SortContacts(phonebook):
    Sort phonebook by contact.name
    Display "Contacts sorted"

#### Efficeincy Analysis of Searcg Algorithm
Function AnalyzeSearchEfficiency(phonebook, name):
    Initialize comparisonCount = 0
    For each contact in phonebook:
        comparisonCount = comparisonCount + 1
        If contact.name equals name:
            Display "Number of comparisons: ", comparisonCount
            Return
    Display "Contact not found. Number of comparisons: ", comparisonCount

 ## 4. Practical Implementation (Section B)

### Contact Class:
class Contact {
    String name;
    String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phoneNumber;
    }
}

### PhoneBook Class:
import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
    List<Contact> contacts;

    public PhoneBook() {
        contacts = new ArrayList<>();
    }

    // Methods for phonebook operations here (as described in previous sections)
}

### Main Class:
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("PhoneBook Menu:");
            System.out.println("1. Insert Contact");
            System.out.println("2. Search Contact");
            System.out.println("3. Display All Contacts");
            System.out.println("4. Delete Contact");
            System.out.println("5. Update Contact");
            System.out.println("6. Sort Contacts");
            System.out.println("7. Analyze Search Efficiency");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    phoneBook.insertContact(name, phoneNumber);
                    break;
                // Other cases for search, display, delete, update, etc.
            }
        }

        scanner.close();
    }
}

## 4.2 Compilation and Execution
### Compile the code:
javac Main.java

###Run the program:
java Main

## 4.3 Testing
1.** Insert Contact**: Test adding multiple contacts.
2.** Search Contact**: Test searching for both existing and non-existing contacts.
3.** Delete Contact**: Test removing contacts and verifying deletion.
4.** Update Contact** : Test updating the phone number of a contact.
5.** Display All Contacts** : Ensure contacts are displayed correctly.
6.** Sort Contacts** : Verify that contacts are sorted alphabetically.
7.** Analyze Search Efficiency** : Check the number of comparisons during search.

## 5. GitHub Repository
The source code and documentation can be found in our GitHub repository: [Link to GitHub repository]

## 7. Conclusion
This project successfully implements a basic phonebook system using linear data structures in Java. The solution demonstrates efficient performance for key phonebook operations and includes optional features like sorting and search efficiency analysis.








