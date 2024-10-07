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


