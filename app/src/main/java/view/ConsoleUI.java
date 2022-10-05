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
