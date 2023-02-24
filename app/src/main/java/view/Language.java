package view;

import java.util.Scanner;

public interface Language {
  public EnumChoices mainMenu();

    public MemberEnum memberMenu();

    public ItemEnum itemMenu();

    public void byeBye();

    public String getFirstName();

    public boolean check(String input);

    public String newFirstName();

    public String getLastName();

    public String newLastName();

    public String getPhoneNumber();

    public String newPhoneNumber();

    public String uniquePhoneNumber();

    public String selectedMember();

    public String selectMemberDelete();

    public String getEmail();

    public String newEmail();

    public String uniqueEmail();

    public void showMemberDetailsSimple(String firstName, String email, String lastName, String memberId,
      int currentCredit, int ownedItem, int time, String index);

    public void showItemDetails(String itemName, String itemDesc, int itemCost, String category, int dayOfCreation,
      String index);

    public String idInput();

    public String indexMemberInput();

    public String indexItemInput();

    public String indexMemberInputRetry();

    public int indexItemInputRetry();

    public String newItemName();

    public String newItemShortDescription();

    public int newItemCostPerDay();

    public void showMemberDetails2(String firstName, String lastName, String email);

    public void showOwnedItemIntro();

    public void showLendedItemIntro();

    public void showItemDetails2(String index, String itemName, String lendedTo, int contractPeriod);

    public void showItemDetails3(String index, String itemName, String owner, int contractPeriod);

    public void showMemberDetails3(String firstName, String email, String id);

    public void lineBreak();

    public void setInput(Scanner input);


    public void notEnoughCredit();

  public void alreadyLended();

  public String selectMember();

  public int selectLender();

  public int selectPeriod();

  public int selectItem();

  public void messageForLending(String mem, String lend, int period);

  /**
   * Message for advancig the day.
   */
  public void advanceDayMessage();

  /**
   * Asks user for item name.
   *
   * @return item name as a string.
   */
  public String createItemName();

  /**
   * Asks user to reenter item name.
   *
   * @return item name as a string.
   */
  public String createItemName2();

  /**
   * Asks user to enter item description.
   *
   * @return description string.
   */
  public String createItemDescription();

  /**
   * Asks user to enter description again.
   *
   * @return description string.
   */
  public String createItemDescription2();

  /**
   * Asks user to enter price.
   *
   * @return price int.
   */
  public String createItemPrice();

  /**
   * Asks user to reenter price.
   *
   * @return price int.
   */
  public String createItemPrice2();

  public void showMemberSpceific(String index, String firstName, String lastName);


  CategoryEnum selectCategory();
}

