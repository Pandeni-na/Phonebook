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
        GridBagConstraints gbc = new GridBagConstraints();
        panel.setBackground(new Color(221, 220, 220));
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
        contactTable.setBackground(new Color(221, 220, 220, 181));
        contactTable.setFont(new Font("Arial", Font.PLAIN, 14));
        contactTable.getTableHeader().setBackground(new Color(104, 163, 214));

        //Creates buttons and sets button color
        JButton addButton = new JButton("Add Contact");
        addButton.setBackground(new Color(93, 213, 83, 224));
        JButton searchButton = new JButton("Search \uD83D\uDD0D");
        searchButton.setBackground(new Color(33, 129, 209, 158));
        JButton deleteButton = new JButton("Delete \uD83D\uDDD1");
        deleteButton.setBackground(new Color(216, 80, 80));
        JButton displayButton = new JButton("Display All");
        displayButton.setBackground(new Color(244, 210, 70, 223));
        JButton updateButton = new JButton("Update Contact ⟳ ");
        updateButton.setBackground(new Color(79, 148, 205, 142));
        JButton sortButton = new JButton("Sort \uD83D\uDDD2");
        sortButton.setBackground(new Color(33, 129, 209, 157));

        addButton.addActionListener(e -> addContact(nameField.getText(), numberField.getText()));
        searchButton.addActionListener(e -> search(searchField.getText()));
        deleteButton.addActionListener(e -> delete(deleteField.getText()));
        displayButton.addActionListener(e -> displayAll());
        updateButton.addActionListener(e -> updateContact(updateField.getText(), numberField.getText()));
        sortButton.addActionListener(e -> sortContacts());

        //Text and Text field layout
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


}

class ContactSort {
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

