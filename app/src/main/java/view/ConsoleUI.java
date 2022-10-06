package view;

import java.lang.reflect.Member;
import java.util.Scanner;

public class ConsoleUI {
  Scanner input;

  public ConsoleUI(Scanner input) {
    this.input = input;
  }

  // Method for creating members
  public model.Member createMember() {
    System.out.println("Enter new member's first name: ");
    String firstName = input.nextLine();
    System.out.println("Enter new member's last name: ");
    String lastName = input.nextLine();
    System.out.println("Enter new member's phone number: ");
    String phoneNumber = input.nextLine();
    System.out.println("Enter new member's email: ");
    String email = input.nextLine();
    return new model.Member(firstName, lastName, email, phoneNumber);
  }

  /**
   * Asks for first name input to validate.
   * 
   * @return first name to be validated
   */
  public String getFirstName() {
    System.out.println("Enter new member's first name: ");
    return input.nextLine();
  }

  /**
   * Trigers when user inputs a space or two for first name.
   * 
   * @return first name again to be validated
   */
  public String newFirstName() {
    System.out.println("Name has to be filled. Please enter first name: ");
    return input.nextLine();
  }

  /**
   * Asks for last name input to validate.
   * 
   * @return last name to be validated
   */
  public String getLastName() {
    System.out.println("Enter new member's last name: ");
    return input.nextLine();
  }

  /**
   * Trigers when user inputs a space or two for last name.
   * 
   * @return last name again to be validated
   */
  public String newLastName() {
    System.out.println("Name has to be filled. Please enter last name: ");
    return input.nextLine();
  }

  /**
   * Asks for phone number.
   * 
   * @return phonenumber to be validated
   */
  public String getPhoneNumber() {
    System.out.println("Enter new member's phone number: ");
    return input.nextLine();
  }

  /**
   * Triggers if empty string is input to phone number
   * 
   * @return phone number string
   */
  public String newPhoneNumber() {
    System.out.println("Phone number has to be filled. Please enter phone number: ");
    return input.nextLine();
  }

  /**
   * Triggers if phone number has a duplicate. Asks the user for another phone
   * number.
   * 
   * @return phone number as a strign
   */
  public String uniquePhoneNumber() {
    System.out.println("Phone number is taken. Please enter a new phone number: ");
    return input.nextLine();
  }

  /**
   * Asks for email.
   * 
   * @return email to be validated
   */
  public String getEmail() {
    System.out.println("Enter new member's email: ");
    return input.nextLine();
  }

  /**
   * Triggers if empty string is input to email
   * 
   * @return email string
   */
  public String newEmail() {
    System.out.println("Email has to be filled. Please enter email: ");
    return input.nextLine();
  }

  /**
   * Triggers if email has a duplicate. Asks the user for another email.
   * 
   * @return email as a strign
   */
  public String uniqueEmail() {
    System.out.println("Email is taken. Please enter a new email: ");
    return input.nextLine();
  }

  // prints details of member
  public void showMemberDetails(model.Member m) {

    // gets infromation
    String firstName = m.getFirstName();
    String lastName = m.getLastName();
    String memberId = m.getMemberId().getId();

    // printed string
    String toPrint = firstName + " " + lastName + " (" + memberId + ")";

    // prints information
    System.out.println(toPrint);
  }

}
