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
   * Method for main menu ui.
   */
  public void mainMenu() {
    System.out.println("|-------------------------------------------------------|");
    System.out.println("| Welcome to our amazing lending application!           |");
    System.out.println("| Kindly follow the instructions below!                 |");
    System.out.println("| Choose a numbers and then click enter                 |");
    System.out.println("|-------------------------------------------------------|");
    System.out.println("|1) To deal with information about member               |");
    System.out.println("|2) To deal with information about item                 |");
    System.out.println("|3) Quit                                                |");
    System.out.println("|-------------------------------------------------------|");
  }

  /**
   * Method for the membure menu UI.
   */
  public void memberMenu() {
    System.out.println("|-------------------------------------------------------|");
    System.out.println("|1) Create a new member                                 |");
    System.out.println("|2) Look up a specific member`s information             |");
    System.out.println("|3) Show a simple over view of all members              |");
    System.out.println("|4) Show a detailed over view of all members            |");
    System.out.println("|5) Edit a member                                       |");
    System.out.println("|6) Delete a member                                     |");
    System.out.println("|7) Back to menu                                        |");
    System.out.println("|-------------------------------------------------------|");
  }

  /**
   * Method for the item menu UI.
   */
  public void itemMenu() {
    System.out.println("|-------------------------------------------------------|");
    System.out.println("|1) Create item                                         |");
    System.out.println("|2) View an item                                        |");
    System.out.println("|3) Edit an item                                        |");
    System.out.println("|4) Delete an item                                      |");
    System.out.println("|5) Back to menu                                        |");
    System.out.println("|-------------------------------------------------------|");
  }

  /**
   * Method for the closing menu UI.
   */
  public void byeBye() {
    System.out.println("|-------------------------------------------------------|");
    System.out.println("|           It was fun while it lasted                  |");
    System.out.println("|                Hope you had fun                       |");
    System.out.println("|                      Bye bye                          |");
    System.out.println("|-------------------------------------------------------|");
    System.exit(0);
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
   * Method for getting index.
   *
   * @return String.
   */
  public String selectedMember() {
    System.out.print("Select member to edit (Input number): ");
    return input.nextLine();
  }

  public String SelectMemberDelete() {
    System.out.println("Select member to delete (Input number): ");
    return input.nextLine();
  }

  public String SelectItemDelete() {
    System.out.println("Select item to delete (Input number): ");
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
  public void showMemberDetailsSimple(model.Member.Mutable m, int index) {

    String firstName = m.getFirstName();
    String email = m.getEmail();
    String lastName = m.getLastName();
    String memberId = m.getMemberId().getId();
    int currentCredit = m.getCredits();
    int ownedItem = m.sizeOfItemsOwned();

    // printed string
    String toPrint = String.format("%s    %s    %s, %s\t%s\tCurrent credits: %s\tNumber of owned items: %s", index,
        memberId, firstName, lastName, email, currentCredit, ownedItem);

    // prints information
    System.out.println(toPrint);

  }

  /**
   * Here we show items details.
   *
   * @param i Item object.
   */
  public void showItemDetails(model.Item i, int index) {
    String itemName = i.getName();
    // String itemId = i.getItemId();
    String itemDesc = i.getShortDescription();
    int itemCost = i.getCostPerDay();

    // String toxPrint = itemName + " ID: " + itemId + " Item desc : " + itemDesc +
    // " Item cost : " + itemCost;
    String toPrint = String.format("%s    %s    %s    %s    Day for items: %s", index, itemName, itemCost, itemDesc,
        i.getDayOfCreation());
    System.out.println(toPrint);
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
   * Asks the user for a member's position in arraylist.
   *
   * @return int.
   */
  public int indexMemberInput() {
    System.out.print("Select a member (Input a number): ");
    return input.nextInt();
  }

  public int indexItemInput() {
    System.out.println("Select an item using position in list: ");
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

  public int indexItemInputRetry() {
    System.out.println("Not a valid position. Please try again: ");
    return input.nextInt();
  }

  /**
   * Is used for creating items.
   *
   * @return Item.
   */
  public model.Item.Mutable createItem() {
    System.out.println("Enter item name: ");
    String itemName = input.nextLine();
    System.out.println("Enter item's short description: ");
    String descrioption = input.nextLine();
    System.out.println("Enter item's cost per day : ");
    int costPerDay = input.nextInt();
    System.out.println("Enter owners name: "); // Should get owner by itself
    String owner = input.nextLine();

    return new model.Item.Mutable(itemName, descrioption, costPerDay, 0, false, 0, owner, "");
  }

  public String newItemName() {
    System.out.print("Enter item name: ");
    return input.next();
  }

  public String newItemShortDescription() {
    System.out.print("Enter item description: ");
    return input.next();
  }

  public int newItemCostPerDay() {
    System.out.print("Enter item cost: ");
    return input.nextInt();
  }

  public String newItemOwnerName() {
    System.out.println("Enter item owner name: ");
    return input.nextLine();
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

  /**
   * Prints details of member.
   *
   * @param m     Member object.
   * @param index To add index.
   */
  public void showMemberDetails2(model.Member.Mutable m, int index) {

    // gets infromation
    String fullName = m.getFirstName() + " " + m.getLastName();
    String email = m.getEmail();
    String ownedItemsString = m.getItemsOwnedString();

    // printed string
    String toPrint = "\n" + "Members name: " + fullName + " E-mail: " + email
        + ownedItemsString;
    // prints information
    System.out.println(toPrint);

  }

  /**
   * Prints details of member.
   *
   * @param m Member object.
   */
  public void showMemberDetails3(model.Member m) {

    String firstName = m.getFirstName();
    String email = m.getEmail();
    String id = m.getMemberId().getId();
    String ownedItemsString = m.getItemsOwnedString();
    String toPrint = "\n" + "Members name: " + firstName + " E-mail: " + email +
        " Member id: " + id + ownedItemsString;
    System.out.println(toPrint);

  }

  /**
   * Prints empty string. Used to make interface look nicer with some line breaks.
   */
  public void lineBreak() {
    System.out.println("");
  }

  /**
   * Setter method for input.
   *
   * @param input input.
   */
  public void setInput(Scanner input) {
    this.input = input;
  }

}