package view;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import model.domain.Member;
import model.domain.Registry;

/**
 * Class for printing console UI elements.
 */
public class ConsoleUi implements Language {
  Scanner input;
  private String in;

  /**
   * Constructor for consoleUI class.
   *
   * @param input Scanner input.
   */
  @SuppressFBWarnings(value = "EI_EXPOSE_REP", justification = "We need to have scanner")
  public ConsoleUi(Scanner input) {
    this.input = input;
  }

  /**
   * Method for main menu ui.
   */
  public EnumChoices mainMenu() {
    System.out.println("|-------------------------------------------------------|");
    System.out.println("| Welcome to our amazing lending application!           |");
    System.out.println("| Kindly follow the instructions below!                 |");
    System.out.println("| Choose a numbers and then click enter                 |");
    System.out.println("|-------------------------------------------------------|");
    System.out.println("|1) To deal with information about member               |");
    System.out.println("|2) To deal with information about item                 |");
    System.out.println("|3) Advance time                                        |");
    System.out.println("|4) Quit                                                |");
    System.out.println("|-------------------------------------------------------|");

    in = input.next();
    switch (in) {
      case ("1"):
        return EnumChoices.MEMBER_MENU;
      case ("2"):
        return EnumChoices.ITEM_MENU;
      case ("3"):
        return EnumChoices.CHANGE_DAY;
      case ("4"):
        return EnumChoices.EXIT;
      default:
        return mainMenu();
    }
  }

  /**
   * Method for the member menu UI.
   */
  public MemberEnum memberMenu() {
    System.out.println("|-------------------------------------------------------|");
    System.out.println("|1) Create a new member                                 |");
    System.out.println("|2) Look up a specific member`s information             |");
    System.out.println("|3) Show a simple over view of all members              |");
    System.out.println("|4) Show a detailed over view of all members            |");
    System.out.println("|5) Edit a member                                       |");
    System.out.println("|6) Delete a member                                     |");
    System.out.println("|7) Create a contract                                   |");
    System.out.println("|8) Back to menu                                        |");
    System.out.println("|-------------------------------------------------------|");

    in = input.next();
    switch (in) {
      case ("1"):
        return MemberEnum.CREATEMEMBER;
      case ("2"):
        return MemberEnum.SPECIFICMEMBER;
      case ("3"):
        return MemberEnum.SHOWSIMPLE;
      case ("4"):
        return MemberEnum.SHOWDETAILED;
      case ("5"):
        return MemberEnum.EDITMEMBER;
      case ("6"):
        return MemberEnum.DELETEMEMBER;
      case ("7"):
        return MemberEnum.CREATECONTRACT;
      case ("8"):
        return MemberEnum.BACKMENU;
      default:
        return memberMenu();
    }
  }

  /**
   * Method for the item menu UI.
   */
  public ItemEnum itemMenu() {
    System.out.println("|-------------------------------------------------------|");
    System.out.println("|1) Create item                                         |");
    System.out.println("|2) View an item                                        |");
    System.out.println("|3) Edit an item                                        |");
    System.out.println("|4) Delete an item                                      |");
    System.out.println("|5) Back to menu                                        |");
    System.out.println("|-------------------------------------------------------|");

    in = input.next();
    switch (in) {
      case ("1"):
        return ItemEnum.CREATEITEM;
      case ("2"):
        return ItemEnum.VIEWITEM;
      case ("3"):
        return ItemEnum.EDITITEM;
      case ("4"):
        return ItemEnum.DELETEITEM;
      case ("5"):
        return ItemEnum.BACK;
      default:
        return itemMenu();
    }
  }

  /**
   * Method for the closing menu UI.
   */
  @SuppressFBWarnings(value = "EI_EXPOSE_REP", justification = "We need system.exit for stopping the programm.")
  public void byeBye() {
    System.out.println("|-------------------------------------------------------|");
    System.out.println("|           It was fun while it lasted                  |");
    System.out.println("|                Hope you had fun                       |");
    System.out.println("|                      Bye bye                          |");
    System.out.println("|-------------------------------------------------------|");
    System.exit(0);
  }

  /**
   * Asks for first name input to validate.
   *
   * @return first name to be validated.
   */
  public String getFirstName() {
    System.out.print("Enter new member's first name: ");
    return input.next();
  }

  /**
   * Trigers when user inputs a space or two for first name.
   *
   * @return first name again to be validated.
   */
  public String newFirstName() {
    System.out.print("Name has to be filled. Please enter first name: ");
    return input.nextLine();
  }

  /**
   * Asks for last name input to validate.
   *
   * @return last name to be validated.
   */
  public String getLastName() {
    System.out.print("Enter new member's last name: ");
    return input.next();
  }

  /**
   * Trigers when user inputs a space or two for last name.
   *
   * @return last name again to be validated.
   */
  public String newLastName() {
    System.out.print("Name has to be filled. Please enter last name: ");
    return input.nextLine();
  }

  /**
   * Asks for phone number.
   *
   * @return phonenumber to be validated.
   */
  public String getPhoneNumber() {
    System.out.print("Enter new member's phone number: ");
    return input.next();
  }

  /**
   * Triggers if empty string is input to phone number.
   *
   * @return phone number string.
   */
  public String newPhoneNumber() {
    System.out.print("Phone number has to be filled. Please enter phone number: ");
    return input.nextLine();
  }

  /**
   * Triggers if phone number has a duplicate. Asks the user for another phone
   * number.
   *
   * @return phone number as a strign.
   */
  public String uniquePhoneNumber() {
    System.out.print("Phone number is taken. Please enter a new phone number: ");
    return input.nextLine();
  }

  /**
   * Method for getting index.
   *
   * @return String.
   */
  public String selectedMember() {
    System.out.print("Select member to edit (Input number): ");
    String in = input.next();
    if (in.isBlank()) {
      return selectedMember();
    }
    return in;
  }

  /**
   * Method for getting input.
   *
   * @return returns input.
   */
  public String selectMemberDelete() {
    System.out.print("Select member to delete (Input number): ");
    String in = input.next();
    if (in.isBlank()) {
      return selectMemberDelete();
    }
    return in;
  }

  /**
   * Asks for email.
   *
   * @return email to be validated.
   */
  public String getEmail() {
    System.out.print("Enter new member's email: ");
    return input.next();
  }

  /**
   * Triggers if empty string is input to email.
   *
   * @return email string.
   */
  public String newEmail() {
    System.out.print("Email has to be filled. Please enter email: ");
    return input.nextLine();
  }

  /**
   * Triggers if email has a duplicate. Asks the user for another email.
   *
   * @return email as a strign.
   */
  public String uniqueEmail() {
    System.out.print("Email is taken. Please enter a new email: ");
    return input.nextLine();
  }

  /**
   * Prints details of member.
   *
   * @param index To add index.
   */
  public void showMemberDetailsSimple(String firstName, String email, String lastName, String memberId,
      int currentCredit, int ownedItem, int time, String index) {
    String toPrint = String.format(
        "%s    %s   Current day: %s    %s, %s\t%s\tCurrent credits: %s\tNumber of owned items: %s", index,
        memberId, time + 1, firstName, lastName, email, currentCredit, ownedItem);
    System.out.println(toPrint);
  }

  /**
   * Here we show items details.
   */
  public void showItemDetails(String itemName, String itemDesc, int itemCost, String category, int dayOfCreation,
      String index) {
    String toPrint = String.format("%s    %s    %s    %s    %s     Day for item: %s",
        index, itemName, itemCost, itemDesc, category, dayOfCreation);
    System.out.println(toPrint);
  }

  /**
   * Method for getting id input.
   *
   * @return String.
   */
  public String idInput() {
    System.out.print("Select a member using position in list (Input a number): ");
    return input.nextLine();
  }

  /**
   * Asks the user for a member's position in arraylist.
   *
   * @return int.
   */
  public String indexMemberInput() {
    System.out.print("Select a member (Input a number): ");
    String in = input.next();
    if (in.isBlank()) {
      return indexItemInput();
    }
    return in;
  }

  /**
   * input for item index.
   *
   * @return index.
   *
   */
  public String indexItemInput() {
    System.out.print("Select an item using position in list: ");
    String in = input.next();
    if (in.isBlank()) {
      return indexItemInput();
    }
    return in;
  }

  /**
   * Validates index input.
   *
   * @return int
   */
  public String indexMemberInputRetry() {
    System.out.print("Not a valid position. Please try again: ");
    return input.nextLine();
  }

  public int indexItemInputRetry() {
    System.out.print("Not a valid position. Please try again: ");
    return input.nextInt();
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

  /**
   * Prints details of member.
   */
  public void showMemberDetails2(String firstName, String lastName, String email) {
    String toPrint = "\n" + "Members name: " + firstName + " " + lastName + " E-mail: " + email;
    System.out.println(toPrint);
  }

  /**
   * Prints details of member.
   */
  public void showMemberDetails3(String firstName, String email, String id) {
    String toPrint = "\n" + "Members name: " + firstName + " E-mail: " + email
        + " Member id: " + id;
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
  @SuppressFBWarnings(value = "EI_EXPOSE_REP", justification = "We need set inout method for scanner")
  public void setInput(Scanner input) {
    this.input = input;
  }

  /**
   * error print.
   */
  public void notEnoughCredit() {
    String toPrint = "Not enough credits";
    System.out.println(toPrint);
  }

  public void alreadyLended() {
    System.out.println("Item is already lended!");
  }

  /**
   * input for index.
   *
   * @return index.
   *
   */
  public String selectMember() {
    System.out.print("Select the owner (Input a number): ");
    String in = input.next();
    if (check(in)) {
      return selectMember();
    }
    return in;
  }

  /**
   * input for index.
   *
   * @return index.
   *
   */
  public String selectLender() {
    System.out.print("Select member to lend to (Input a number): ");
    String in = input.next();
    if (in.isBlank()) {
      return selectLender();
    }
    return in;
  }

  public int selectPeriod() {
    System.out.print("How long would like to lend the item (Input a number): ");
    return input.nextInt();
  }

  /**
   * input for index.
   *
   * @return index.
   *
   */
  public String selectItem() {
    System.out.print("Select item you wish to lend (Input a number): ");
    String in = input.next();
    if (in.isBlank()) {
      return selectItem();
    }
    return in;
  }

  public void messageForLending(String mem, String lend, int period) {
    System.out.println("Contract has been created " + mem + " has lended to " + lend + " for " + period + " days");
  }

  /**
   * Message for advancig the day.
   */
  public void advanceDayMessage() {
    System.out.println("Time has been advanced by one day ;)");
  }

  /**
   * Ui for selecting the category.
   *
   * @return input.
   */
  public CategoryEnum selectCategory() {
    lineBreak();
    System.out.println("Please enter the appropriate category for item using the list below");
    System.out.println("1. Tool\n2. Vehicle\n3. Game\n4. Toy\n5. Sport\n6. Other");
    System.out.print("Enter category which fits the item the most: ");

    in = input.next();
    switch (in) {
      case ("1"):
        return CategoryEnum.TOOL;
      case ("2"):
        return CategoryEnum.VEHICLE;
      case ("3"):
        return CategoryEnum.GAME;
      case ("4"):
        return CategoryEnum.TOY;
      case ("5"):
        return CategoryEnum.SPORT;
      case ("6"):
        return CategoryEnum.OTHER;
      default:
        return selectCategory();
    }
  }

  /**
   * Asks user for item name.
   *
   * @return item name as a string.
   */
  public String createItemName() {
    System.out.print("Enter item name as an String: ");
    return input.next();
  }

  /**
   * Asks user to reenter item name.
   *
   * @return item name as a string.
   */
  public String createItemName2() {
    System.out.print("Invalid name or item already exist, enter again: ");
    return input.nextLine();
  }

  /**
   * Asks user to enter item description.
   *
   * @return description string.
   */
  public String createItemDescription() {
    System.out.print("Enter description for item: ");
    return input.next();
  }

  /**
   * Asks user to enter description again.
   *
   * @return description string.
   */
  public String createItemDescription2() {
    System.out.print("Invalid description, enter again: ");
    return input.nextLine();
  }

  /**
   * Asks user to enter price.
   *
   * @return price int.
   */
  public String createItemPrice() {
    System.out.print("Enter item price per day: ");
    return input.next();
  }

  /**
   * Asks user to reenter price.
   *
   * @return price int.
   */
  public String createItemPrice2() {
    System.out.print("Invalid price, enter again: ");
    return input.nextLine();
  }

  /**
   * Prints member in a simple way to then look at their details.
   *
   * @param index     index.
   * @param firstName member's first name.
   * @param lastName  member's last name.
   */
  public void showMemberSpceific(String index, String firstName, String lastName) {
    System.out.println(index + "\t" + firstName + " " + lastName);
  }

  @Override
  public void showOwnedItemIntro() {
    System.out.println("Items owned:");
  }

  @Override
  public void showLendedItemIntro() {
    System.out.println("Items lended:");
  }

  @Override
  public void showItemDetails2(String index, String itemName, String lendedTo, int contractPeriod) {
    System.out.println(index + ". " + itemName + " -> Lended to: " + lendedTo + ", Contract Period: " + contractPeriod);
  }

  @Override
  public void showItemDetails3(String index, String itemName, String owner, int contractPeriod) {
    System.out.println(index + ". " + itemName + " -> Owner: " + owner + ", Contract Period: " + contractPeriod);
  }

  /**
   * Checks if input is null.
   *
   * @param input any string.
   *
   * @return true if null and false if not.
   */
  public boolean check(String input) {
    if (input.equals("") || input.equals(" ")) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Sort members.
   */
  public ArrayList<Member.Mutable> sortMembers(Registry registry) {
    ArrayList<Member.Mutable> members = registry.getMembers();
    Comparator<Member.Mutable> comparator = new Comparator<Member.Mutable>() {
      public int compare(Member.Mutable person1, Member.Mutable person2) {
        String comparee1 = person1.getFirstName().toLowerCase();
        String comparee2 = person2.getFirstName().toLowerCase();
        return comparee1.compareTo(comparee2);
      }
    };
    Collections.sort(members, comparator);
    return members;
  }

}