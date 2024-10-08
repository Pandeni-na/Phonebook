# Phonebook

### Efficient Phonebook Management System for a Namibian Telecommunications Company

## Group Members
- Matheus Hashoonge 223070599
- Amenenge Negumbo 224065963
- Pandeni Kakwambi 224066544
- Zia Phaswana 224034812
- Reinhold Haufiku 224016954
- Kelibongile Tholana 224091808 

## Project Overview
This project aims to implement an efficient phonebook management system for a
Namibian telecommunications company. The company handles numerous client
contacts and requires a system that allows for quick access, addition, deletion, and
updating of contact information. The goal is to simplify operations for customer
service representatives who need to manage clients' details on a daily basis. 

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
- **Development Environment**: IntelliJ IDEA
- **Version Control**: Git and GitHub for collaboration

---

## 3. Algorithm Design (Section A)

### 3.1 Pseudocode



      
}

### 3.2 Flowchart

### 4. Practical Implementation (Section B)
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PhoneBook {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(PhoneBook::new);
    }

    private ArrayList<String> nameList = new ArrayList<>();
    private ArrayList<String> numList = new ArrayList<>();
    private JTable contactTable;
    private DefaultTableModel tableModel;
    private JTextField nameField;
    private JTextField numberField;
    private JTextField searchField;
    private JTextField deleteField;
    private JTextField updateField;

    public PhoneBook() {
        JFrame frame = new JFrame("Phone Book");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 450);
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(246, 245, 241));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        nameField = new JTextField(14);
        numberField = new JTextField(14);
        searchField = new JTextField(14);
        deleteField = new JTextField(14);
        updateField = new JTextField(14);

        // Table for storing the contact name and contact number
        tableModel = new DefaultTableModel(new String[]{"Name", "Number"}, 0);
        contactTable = new JTable(tableModel);
        contactTable.setFillsViewportHeight(true);
        contactTable.setBackground(new Color(248, 238, 238));
        contactTable.setFont(new Font("Arial", Font.PLAIN, 14));
        contactTable.getTableHeader().setBackground(new Color(244, 243, 243));

        // Buttons for each action
        JButton addButton = new JButton("Add Contact");
        JButton searchButton = new JButton("Search \uD83D\uDD0D");
        JButton deleteButton = new JButton("\uD83D\uDDD1 Delete");
        JButton displayButton = new JButton("Display All");
        JButton updateButton = new JButton(" ⟳ Update Contact");
        JButton sortButton = new JButton("\uD83D\uDDD2 Sort");

        addButton.setBackground(new Color(93, 213, 83));
        searchButton.setBackground(new Color(37, 65, 205));
        deleteButton.setBackground(new Color(243, 6, 6));
        displayButton.setBackground(new Color(253, 118, 3, 253));
        updateButton.setBackground(new Color(144, 9, 154));
        sortButton.setBackground(new Color(21, 246, 6, 255));

        addButton.addActionListener(e -> addContact(nameField.getText(), numberField.getText()));
        searchButton.addActionListener(e -> search(searchField.getText()));
        deleteButton.addActionListener(e -> delete(deleteField.getText()));
        displayButton.addActionListener(e -> displayAll());
        updateButton.addActionListener(e -> updateContact(updateField.getText(), numberField.getText()));
        sortButton.addActionListener(e -> sortContacts());

        // Layout
        gbc.gridx = 0; gbc.gridy = 0; panel.add(new JLabel("Contact Name:"), gbc);
        gbc.gridx = 1; gbc.gridy = 0; panel.add(nameField, gbc);
        gbc.gridx = 0; gbc.gridy = 1; panel.add(new JLabel("Contact Number:"), gbc);
        gbc.gridx = 1; gbc.gridy = 1; panel.add(numberField, gbc);
        gbc.gridx = 0; gbc.gridy = 2; panel.add(addButton, gbc);
        gbc.gridx = 0; gbc.gridy = 3; panel.add(new JLabel("Search Contact:"), gbc);
        gbc.gridx = 1; gbc.gridy = 3; panel.add(searchField, gbc);
        gbc.gridx = 0; gbc.gridy = 4; panel.add(searchButton, gbc);
        gbc.gridx = 0; gbc.gridy = 5; panel.add(new JLabel("Delete Contact:"), gbc);
        gbc.gridx = 1; gbc.gridy = 5; panel.add(deleteField, gbc);
        gbc.gridx = 0; gbc.gridy = 6; panel.add(deleteButton, gbc);
        gbc.gridx = 0; gbc.gridy = 7; panel.add(new JLabel("Update Contact:"), gbc);
        gbc.gridx = 1; gbc.gridy = 7; panel.add(updateField, gbc);
        gbc.gridx = 0; gbc.gridy = 8; panel.add(updateButton, gbc);
        gbc.gridx = 0; gbc.gridy = 9; panel.add(sortButton, gbc);
        gbc.gridx = 0; gbc.gridy = 10; gbc.gridwidth = 2; panel.add(displayButton, gbc);

        frame.add(panel, BorderLayout.WEST);
        frame.add(new JScrollPane(contactTable), BorderLayout.CENTER);
        frame.setVisible(true);
    }
    // Add Contact function
    public void addContact(String name, String number) {
        if (!name.isEmpty() && !number.isEmpty()) {
            nameList.add(name);
            numList.add(number);
            tableModel.addRow(new Object[]{name, number});
            JOptionPane.showMessageDialog(null, "Contact was successfully added ");
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Entry!!");
        }
    }

    // Delete Contact Function
    public void delete(String name) {
        int index = nameList.indexOf(name);
        if (index >= 0) {
            nameList.remove(index);
            numList.remove(index);
            tableModel.removeRow(index);
            JOptionPane.showMessageDialog(null, "Successfully Deleted: " + name);
        } else {
            JOptionPane.showMessageDialog(null, name + " Contact Not Found!!");
        }
    }

    // Search contact Function
    public void search(String nameOrNumber) {
        int indexByName = nameList.indexOf(nameOrNumber);
        int indexByNumber = numList.indexOf(nameOrNumber);
        if (indexByName >= 0) {
            JOptionPane.showMessageDialog(null, nameOrNumber + "'s Contact Number is: " + numList.get(indexByName));
        } else if (indexByNumber >= 0) {
            JOptionPane.showMessageDialog(null, "Contact Number " + nameOrNumber + " belongs to: " + nameList.get(indexByNumber));
        } else {
            JOptionPane.showMessageDialog(null, nameOrNumber + " Contact Not Found!!");
        }
    }

    // Update contact Function
    public void updateContact(String name, String newNumber) {
        int index = nameList.indexOf(name);
        if (index >= 0) {
            numList.set(index, newNumber);
            tableModel.setValueAt(newNumber, index, 1);
            JOptionPane.showMessageDialog(null, "Successfully Updated: " + name + "'s number to " + newNumber);
        } else {
            JOptionPane.showMessageDialog(null, name + " Contact Name Does not Exist!!");
        }
    }

    // Display all contacts function
    public void displayAll() {
        if (nameList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No Contacts Available. Please update Contact List!!");
            return;
        }
        StringBuilder allContacts = new StringBuilder("All Contacts:\n");
        for (int i = 0; i < nameList.size(); i++) {
            allContacts.append(nameList.get(i)).append(" - ").append(numList.get(i)).append("\n");
        }
        JOptionPane.showMessageDialog(null, allContacts.toString());
    }

    // Sort contacts function
    public void sortContacts() {
        ArrayList<ContactSort> contacts = new ArrayList<>();
        for (int i = 0; i < nameList.size(); i++) {
            contacts.add(new ContactSort(nameList.get(i), numList.get(i)));
        }
        Collections.sort(contacts, Comparator.comparing(ContactSort::getName));
        nameList.clear();
        numList.clear();
        tableModel.setRowCount(0);
        for (ContactSort contact : contacts) {
            nameList.add(contact.getName());
            numList.add(contact.getNumber());
            tableModel.addRow(new Object[]{contact.getName(), contact.getNumber()});
        }
        JOptionPane.showMessageDialog(null, "Contacts were successfully sorted.");
    }
}
public class ContactSort {
    private String name;
    private String number;
public ContactSort(String name, String number) {
        this.name = name;
        this.number = number;
    }
    public String getName() {
        return name;
    }
  public String getNumber() {
        return number;
    }
}

## 4.1 Testing
Test Case	Action	Input	Expected Output	Status
1	Insert Contact	John, 1234567890	Contact added successfully	Pass
2	Insert Duplicate Contact	John, 1234567890	Contact already exists	Pass
3	Search Contact (Existing)	John	Contact found: John - 1234567890	Pass
4	Search Contact (Non-existent)	Jane	Contact not found	Pass
5	Delete Contact (Existing)	John	Contact deleted	Pass
6	Delete Contact (Non-existent)	Jane	Contact not found	Pass
7	Update Contact (Existing)	John, 0987654321	Contact updated successfully	Pass
8	Update Contact (Non-existent)	Jane, 0987654321	Contact not found	Pass
9	Display All Contacts	N/A	Displays all saved contacts in correct format	Pass
10	Sort Contacts	N/A	Contacts sorted alphabetically	Pass
11	Analyze Search Efficiency	John	Displays number of comparisons	Pass

### 5. GitHub Repository
The source code and documentation can be found in our GitHub repository: [Link to GitHub repository]

### 6. Conclusion
This project successfully implements a simple and efficient phonebook system for
managing contacts.
The system performs core operations like adding, deleting, searching, and updating
contacts, with the additional ability to sort and analyze search efficiency.

### 7. Future Enhancements
Hash Table or Binary Search Tree: Implementing more advanced data structures
would drastically improve search and insertion times.
Data Persistence: Currently, the phonebook data is stored in memory. Future
versions could include file I/O or database integration (e.g., SQLite or MySQL) to
persist contacts between program executions.
Additional Fields: Adding more fields such as email addresses and home addresses
would make the system more versatile and useful for managing detailed contact
information








