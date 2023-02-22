package view;

import java.util.Scanner;
import java.util.zip.ZipEntry;

public interface Language {

    public MemberEnum memberMenu();

    public ItemEnum itemMenu();

    public void byeBye();

    public String getFirstName();

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
      int currentCredit, int ownedItem, int time, int index);

    public void showItemDetails(String itemName, String itemDesc, int itemCost, String category, int dayOfCreation,
      int index);

    public String idInput();

    public int indexMemberInput();

    public int indexItemInput();

    public int indexMemberInputRetry();

    public int indexItemInputRetry();

    public String newItemName();

    public String newItemShortDescription();

    public int newItemCostPerDay();

    public void showMemberDetails2(String firstName, String lastName, String email, String ownedItem,
      String lendedItemString);

    public void showMemberDetails3(String firstName, String email, String id, String ownedItems);

    public void lineBreak();

    public void setInput(Scanner input);


    public void notEnoughCredit();

  public void alreadyLended();

  public int selectMember();

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
  public int createItemPrice();

  /**
   * Asks user to reenter price.
   *
   * @return price int.
   */
  public int createItemPrice2();

  public void showMemberSpceific(int index, String firstName, String lastName);


  CategoryEnum selectCategory();
}
