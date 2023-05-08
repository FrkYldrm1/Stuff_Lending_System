package view;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import model.domain.Member;
import model.domain.Registry;

/**
 * Swedish Ui.
 */
public class SwedishUi implements Language {

  Scanner input;
  private String in;

  /**
   * Constructor for consoleUI class.
   *
   * @param input Scanner input.
   */
  @SuppressFBWarnings(value = "EI_EXPOSE_REP", justification = "We need to have scanner")
  public SwedishUi(Scanner input) {
    this.input = input;
  }

  /**
   * Method for main menu ui.
   */
  public EnumChoices mainMenu() {
    System.out.println("|-------------------------------------------------------|");
    System.out.println("| Välkommen till vår fantastiska låneansökan!           |");
    System.out.println("| Vänligen följ instruktionerna nedan!                  |");
    System.out.println("| Välj ett nummer och klicka sedan på enter             |");
    System.out.println("|-------------------------------------------------------|");
    System.out.println("|A) Sluta                                              |");
    System.out.println("|B) Förskottstid                                        |");
    System.out.println("|C) För att hantera information om objekt               |");
    System.out.println("|D) För att hantera information om medlem               |");
    System.out.println("|-------------------------------------------------------|");

    in = input.next();
    switch (in.trim().toLowerCase()) {
      case ("d"):
        return EnumChoices.MEMBER_MENU;
      case ("c"):
        return EnumChoices.ITEM_MENU;
      case ("b"):
        return EnumChoices.CHANGE_DAY;
      case ("a"):
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
    System.out.println("|A) Tillbaka till meny                                  |");
    System.out.println("|B) Skapa ett kontrakt                                  |");
    System.out.println("|C) Ta bort en medlem                                   |");
    System.out.println("|D) Redigera en medlem                                  |");
    System.out.println("|E) Visa en detaljerad översikt över alla medlemmar     |");
    System.out.println("|F) Visa en enkel översikt över alla medlemmar          |");
    System.out.println("|G) Slå upp en specifik medlems information             |");
    System.out.println("|H) Skapa en ny medlem                                  |");
    System.out.println("|-------------------------------------------------------|");

    in = input.next();
    switch (in.trim().toLowerCase()) {
      case ("h"):
        return MemberEnum.CREATEMEMBER;
      case ("g"):
        return MemberEnum.SPECIFICMEMBER;
      case ("f"):
        return MemberEnum.SHOWSIMPLE;
      case ("e"):
        return MemberEnum.SHOWDETAILED;
      case ("d"):
        return MemberEnum.EDITMEMBER;
      case ("c"):
        return MemberEnum.DELETEMEMBER;
      case ("b"):
        return MemberEnum.CREATECONTRACT;
      case ("a"):
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
    System.out.println("|A) Tillbaka till meny                                  |");
    System.out.println("|B) Ta bort ett objekt                                  |");
    System.out.println("|C) Redigera ett objekt                                 |");
    System.out.println("|D) Visa ett objek                                      |");
    System.out.println("|E) Skapa objekt                                        |");
    System.out.println("|-------------------------------------------------------|");

    in = input.next();
    switch (in.trim().toLowerCase()) {
      case ("e"):
        return ItemEnum.CREATEITEM;
      case ("d"):
        return ItemEnum.VIEWITEM;
      case ("c"):
        return ItemEnum.EDITITEM;
      case ("b"):
        return ItemEnum.DELETEITEM;
      case ("a"):
        return ItemEnum.BACK;
      default:
        return itemMenu();
    }
  }

  /**
   * Method for the closing menu UI.
   */
  public void byeBye() {
    System.out.println("|-------------------------------------------------------|");
    System.out.println("|           Det var kul så länge det varade             |");
    System.out.println("|                Hoppas du hade roligt                  |");
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
    System.out.print("Ange den nya medlemmens förnamn: ");
    return input.next();
  }

  /**
   * Trigers when user inputs a space or two for first name.
   *
   * @return first name again to be validated.
   */
  public String newFirstName() {
    System.out.print("Namn måste fyllas i. Vänligen ange förnamn: ");
    return input.nextLine();
  }

  /**
   * Asks for last name input to validate.
   *
   * @return last name to be validated.
   */
  public String getLastName() {
    System.out.print("Ange nya medlemmars efternamn: ");
    return input.next();
  }

  /**
   * Trigers when user inputs a space or two for last name.
   *
   * @return last name again to be validated.
   */
  public String newLastName() {
    System.out.print("Namn måste fyllas i. Vänligen ange efternamn: ");
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
    System.out.print("Telefonnummer måste fyllas i. Vänligen ange telefonnummer: ");
    return input.nextLine();
  }

  /**
   * Triggers if phone number has a duplicate. Asks the user for another phone
   * number.
   *
   * @return phone number as a strign.
   */
  public String uniquePhoneNumber() {
    System.out.print("Telefonnummer tas. Vänligen ange ett nytt telefonnummer: ");
    return input.nextLine();
  }

  /**
   * Method for getting index.
   *
   * @return String.
   */
  public String selectedMember() {
    System.out.print("Välj medlem att redigera (Inmatningsnummer): ");
    String in = input.next();
    if (check(in)) {
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
    System.out.print("Välj medlem att radera (Inmatningsnummer): ");
    String in = input.next();
    if (check(in)) {
      System.out.println("Välj medlem att radera (Inmatningsnummer): ");
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
    System.out.print("Ange nya medlemmars e-postadress: ");
    return input.next();
  }

  /**
   * Triggers if empty string is input to email.
   *
   * @return email string.
   */
  public String newEmail() {
    System.out.print("E-post måste fyllas i. Vänligen ange e-post: ");
    return input.nextLine();
  }

  /**
   * Triggers if email has a duplicate. Asks the user for another email.
   *
   * @return email as a strign.
   */
  public String uniqueEmail() {
    System.out.print("E-post tas. Vänligen ange en ny e-postadress: ");
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
        "%s    %s  Nuvarande dag: %s    %s, %s\t%s\tAktuella krediter: %s\tAntal ägda föremål: %s", index,
        memberId, time + 1, firstName, lastName, email, currentCredit, ownedItem);
    System.out.println(toPrint);
  }

  /**
   * Here we show items details.
   */
  public void showItemDetails(String itemName, String itemDesc, int itemCost, String category, int dayOfCreation,
      String index) {
    String toPrint = String.format("%s    %s    %s    %s    %s     Dag för föremål: %s",
        index, itemName, itemCost, itemDesc, category, dayOfCreation);
    System.out.println(toPrint);
  }

  /**
   * Method for getting id input.
   *
   * @return String.
   */
  public String idInput() {
    System.out.print("Välj en medlem med position i listan (Ange ett nummer): ");
    return input.nextLine();
  }

  /**
   * Asks the user for a member's position in arraylist.
   *
   * @return int.
   */
  public String indexMemberInput() {
    System.out.print("Välj en medlem (Ange ett bokstav): ");
    String in = input.next();
    if (in.isBlank()) {
      return indexMemberInput();
    }
    return in;
  }

  /**
   * method for returning index.
   *
   * @return index of the item.
   *
   */
  public String indexItemInput() {
    System.out.print("Välj ett objekt med hjälp av position i listan: ");
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
    System.out.print("Inte en giltig position. Var god försök igen: ");
    return input.nextLine();
  }

  public int indexItemInputRetry() {
    System.out.print("Inte en giltig position. Var god försök igen: ");
    return input.nextInt();
  }

  public String newItemName() {
    System.out.print("Ange objektets namn:");
    return input.next();
  }

  public String newItemShortDescription() {
    System.out.print("Ange artikelbeskrivning: ");
    return input.next();
  }

  public int newItemCostPerDay() {
    System.out.print("Ange artikelkostnad:");
    return input.nextInt();
  }

  /**
   * Prints details of member.
   */
  public void showMemberDetails2(String firstName, String lastName, String email) {
    String toPrint = "\n" + "Medlemmarnas namn: " + firstName + " " + lastName + " E-post: " + email;
    System.out.println(toPrint);
  }

  /**
   * Prints details of member.
   */
  public void showMemberDetails3(String firstName, String email, String id) {
    String toPrint = "\n" + "Medlemmarnas namn: " + firstName + " E-post: " + email
        + " Medlems-id: " + id;
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
   * print for no credit.
   */
  public void notEnoughCredit() {
    String toPrint = "Inte tillräckligt med krediter";
    System.out.println(toPrint);
  }

  /**
   * print.
   */
  public void alreadyLended() {
    System.out.println("Varan är redan utlånad!");
  }

  /**
   * input for member.
   *
   * @return member index.
   *
   */
  public String selectMember() {
    System.out.print("Välj ägare (Ange ett nummer): ");
    String in = input.next();
    if (in.isBlank()) {
      return selectMember();
    }
    return in;
  }

  /**
   * input for lender.
   *
   * @return selected lender.
   *
   */
  public String selectLender() {
    System.out.print("Välj medlem att låna ut till (Ange ett bokstav): ");
    String in = input.next();
    if (in.isBlank()) {
      return selectLender();
    }
    return in;
  }

  public int selectPeriod() {
    System.out.print("Hur länge vill du låna ut objektet (Ange ett nummer): ");
    return input.nextInt();
  }

  /**
   * input for selecting item.
   *
   * @return selected item.
   *
   */
  public String selectItem() {
    System.out.print("Välj objekt du vill låna ut (Ange ett bokstav): ");
    String in = input.next();
    if (in.isBlank()) {
      return selectItem();
    }
    return in;
  }

  public void messageForLending(String mem, String lend, int period) {
    System.out.println("Kontrakt har skapats " + mem + " har lånat ut till " + lend + " för " + period + " dags");
  }

  /**
   * Message for advancig the day.
   */
  public void advanceDayMessage() {
    System.out.println("Tiden har flyttats fram med en dag;)");
  }

  /**
   * Ui for selecting the category.
   *
   * @return input.
   */
  public CategoryEnum selectCategory() {
    lineBreak();
    System.out.println("Vänligen ange lämplig kategori för objektet med hjälp av listan nedan");
    System.out.println("1. Verktyg\n2. Fordon\n3. Spel\n4. Leksak\n5. Sport\n6. Övrig");
    System.out.print("Ange den kategori som passar varan bäst: ");
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
    System.out.print("Ange objektets namn som en String: ");
    return input.next();
  }

  /**
   * Asks user to reenter item name.
   *
   * @return item name as a string.
   */
  public String createItemName2() {
    System.out.print("Ogiltigt namn, ange igen:");
    return input.nextLine();
  }

  /**
   * Asks user to enter item description.
   *
   * @return description string.
   */
  public String createItemDescription() {
    System.out.print("Ange beskrivning för artikeln: ");
    return input.next();
  }

  /**
   * Asks user to enter description again.
   *
   * @return description string.
   */
  public String createItemDescription2() {
    System.out.print("Ogiltig beskrivning, ange igen: ");
    return input.nextLine();
  }

  /**
   * Asks user to enter price.
   *
   * @return price int.
   */
  public String createItemPrice() {
    System.out.print("Ange artikelpris per dag:");
    return input.next();
  }

  /**
   * Asks user to reenter price.
   *
   * @return price int.
   */
  public String createItemPrice2() {
    System.out.print("Ogiltigt pris, ange igen:");
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

  /**
   * Checks if input is null.
   *
   * @param input any string.
   * @return true if null and false if not.
   *
   */
  public boolean check(String input) {
    if (input.equals("") || input.equals(" ")) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public void showOwnedItemIntro() {
    System.out.println("Mga ari-arian: ");
  }

  @Override
  public void showLendedItemIntro() {
    System.out.println("Mga hiniram na bagay: ");
  }

  @Override
  public void showItemDetails2(String character, String itemName, String lendedTo, int contractPeriod) {
    System.out.println(character + ". " + itemName + " -> Lånat av: " + lendedTo + ", Avtalsperiod: " + contractPeriod);
  }

  @Override
  public void showItemDetails3(String character, String itemName, String owner, int contractPeriod) {
    System.out.println(character + ". " + itemName + " -> Ägare: " + owner + ", Avtalsperiod: " + contractPeriod);
  }

  /**
   * Sort members.
   */
  public ArrayList<Member.Mutable> sortMembers(Registry registry) {
    ArrayList<Member.Mutable> members = registry.getMembers();
    Comparator<Member.Mutable> compare = new Comparator<Member.Mutable>() {
      public int compare(Member.Mutable person1, Member.Mutable person2) {
        return person1.getMemberId().getId().compareTo(person2.getMemberId().getId());
      }
    };
    Collections.sort(members, compare);
    return members;

  }
}
