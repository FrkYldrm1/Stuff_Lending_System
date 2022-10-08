package view;

import java.util.Scanner;

/**
 * Class for printing console UI elements.
 */
public class ConsoleUi {
  Scanner input;

  /**
   * Constructor for consoleUI class.
   *
   * @param input Scanner input.
   */
  public ConsoleUi(Scanner input) {
    this.input = input;
  }

  /**
   * Method for creating member.
   *
   * @return Member.
   */
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
   * @return first name to be validated.
   */
  public String getFirstName() {
    System.out.println("Enter new member's first name: ");
    return input.nextLine();
  }

  /**
   * Trigers when user inputs a space or two for first name.
   *
   * @return first name again to be validated.
   */
  public String newFirstName() {
    System.out.println("Name has to be filled. Please enter first name: ");
    return input.nextLine();
  }

  /**
   * Asks for last name input to validate.
   *
   * @return last name to be validated.
   */
  public String getLastName() {
    System.out.println("Enter new member's last name: ");
    return input.nextLine();
  }

  /**
   * Trigers when user inputs a space or two for last name.
   *
   * @return last name again to be validated.
   */
  public String newLastName() {
    System.out.println("Name has to be filled. Please enter last name: ");
    return input.nextLine();
  }

  /**
   * Asks for phone number.
   *
   * @return phonenumber to be validated.
   */
  public String getPhoneNumber() {
    System.out.println("Enter new member's phone number: ");
    return input.nextLine();
  }

  /**
   * Triggers if empty string is input to phone number.
   *
   * @return phone number string.
   */
  public String newPhoneNumber() {
    System.out.println("Phone number has to be filled. Please enter phone number: ");
    return input.nextLine();
  }

  /**
   * Triggers if phone number has a duplicate. Asks the user for another phone
   * number.
   *
   * @return phone number as a strign.
   */
  public String uniquePhoneNumber() {
    System.out.println("Phone number is taken. Please enter a new phone number: ");
    return input.nextLine();
  }

  /**
   * Asks for email.
   *
   * @return email to be validated.
   */
  public String getEmail() {
    System.out.println("Enter new member's email: ");
    return input.nextLine();
  }

  /**
   * Triggers if empty string is input to email.
   *
   * @return email string.
   */
  public String newEmail() {
    System.out.println("Email has to be filled. Please enter email: ");
    return input.nextLine();
  }

  /**
   * Triggers if email has a duplicate. Asks the user for another email.
   *
   * @return email as a strign.
   */
  public String uniqueEmail() {
    System.out.println("Email is taken. Please enter a new email: ");
    return input.nextLine();
  }

  /**
   * Prints details of member.
   *
   * @param m     Member object.
   * @param index To add index.
   */
  public void showMemberDetails(model.Member.Mutable m, int index) {

    // gets infromation
    String firstName = m.getFirstName();
    String email = m.getEmail();
    String lastName = m.getLastName();
    String memberId = m.getMemberId().getId();
    int currentCredit = m.getCredits();
    int ownedItem = m.getItemsOwned().size();

    // printed string
    String toPrint = String.format("%s    %s    %s, %s\t%s\tCurrent credits: %s\tNumber of owned items: %s", index,
        memberId, firstName, lastName, email, currentCredit, ownedItem);
    System.out.println("The day is : " + m.getTime());

    // prints information
    System.out.println(toPrint);

  }

  /**
   * Here we show items details.
   *
   * @param i Item object.
   */
  public void showItemDetails(model.Item i) {
    String itemName = i.getName();
    String itemId = i.getItemId();
    String itemDesc = i.getShortDescription();
    int itemCost = i.getCostPerDay();

    String toPrint = itemName + " ID: " + itemId + " Item desc : " + itemDesc + " Item cost : " + itemCost;
    System.out.println(toPrint);
    System.out.println("The day for items : " + i.getDayOfCreation());
  }

  /**
   * Method for getting id input.
   *
   * @return String.
   */
  public String idInput() {
    System.out.println("Please enter member ID : ");
    return input.nextLine();
  }

  /**
   * Asks the user for a member's position in arraylist
   * 
   * @return int
   */
  public int indexMemberInput() {
    System.out.println("Please choose a member with their position in the list: ");
    return input.nextInt();
  }

  /**
   * Validates index input.
   * 
   * @return int
   */
  public int indexMemberInputRetry() {
    System.out.println("Not a valid position. Please try again: ");
    return input.nextInt();
  }

  /**
   * Is used for creating items.
   *
   * @return Item.
   */
  public model.Item createItem() {
    System.out.println("Enter item name: ");
    String itemName = input.nextLine();
    System.out.println("Enter item's short description: ");
    String descrioption = input.nextLine();
    System.out.println("Enter item's cost per day : ");
    int costPerDay = input.nextInt();

    return new model.Item(itemName, descrioption, costPerDay, 0, false, 0);
  }

  /**
   * To get day input.
   *
   * @return int.
   */
  public int dayInput() {
    System.out.println("Please enter the day that you want to change :");
    return input.nextInt();
  }

}
