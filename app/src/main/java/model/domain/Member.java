package model.domain;

import model.TimeAdvancedObserver;

import java.util.ArrayList;

/**
 * Member class.
 */
public class Member implements TimeAdvancedObserver {
  private String firstName;
  private String lastName;
  private String email;
  private String phoneNumber;
  private MemberId memberId;
  private int credits;
  private int costTotal;
  private Time time = new Time();
  private ArrayList<Item.Mutable> itemsOwned = new ArrayList<>();
  private ArrayList<Item> itemsLended = new ArrayList<>();
  // private ArrayList<Item> items = new ArrayList<>(); // to take away?

  /**
   * Member constructor.
   *
   * @param firstName   to initilize name.
   * @param lastName    to initilize lastname.
   * @param email       to initilize e-mail.
   * @param phoneNumber to initilize phone number.
   */
  public Member(String firstName, String lastName, String email, String phoneNumber) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.memberId = new MemberId();
    this.credits = 100;
  }

  /**
   * Member constructor.
   *
   * @param firstName   to initilize name.
   * @param lastName    to initilize lastname.
   * @param email       to initilize e-mail.
   * @param phoneNumber to initilize phone number.
   * @param id          initilize id.
   */
  public Member(String firstName, String lastName, String email, String phoneNumber, MemberId id) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.memberId = id;
    this.credits = 100;
  }

  /**
   * Getter for the first name.
   *
   * @return String.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Getter for the last name.
   *
   * @return String.
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Getter for the email.
   *
   * @return String.
   */
  public String getEmail() {
    return email;
  }

  /**
   * Getter for the phone number.
   *
   * @return String.
   */
  public String getPhoneNumber() {
    return phoneNumber;
  }

  /**
   * Getter for the member id.
   *
   * @return MemberId.
   */
  public MemberId getMemberId() {
    return memberId;
  }

  /**
   * Getter for the credits.
   *
   * @return int.
   */
  public int getCredits() {
    return credits;
  }

  /**
   * Getter for owned items.
   *
   * @return The list for return.
   */
  public Iterable<Item.Mutable> getItemsOwned() {
    return itemsOwned;
  }

  /**
   * Getter for owned items.
   *
   * @return The list for return.
   */
  public String getItemsOwnedString() {
    String itemList = "";
    int counter = 0;
    for (Item item : itemsOwned) {
      counter += 1;
      itemList += "\n" + " Owned items : " + "\n" + counter + ". " + item.getName() + "-> Lended to: "
          + item.getLenededTo() + ", Contract period: " + item.getContractPeriod() + "\n";
    }
    return itemList;
  }

  /**
   * Create a string of lended item array.
   *
   * @return lended item string.
   *
   */
  public String getItemsLended() {
    String itemListLended = "";
    int counter = 0;
    for (Item item : itemsLended) {
      counter++;
      itemListLended += "\n" + " Lended items  : " + "\n" + counter + ". " + item.getName() + "-> Lended to: "
          + item.getLenededTo() + ", Contract period: " +
              item.getContractPeriod() + " Short description: " + item.getShortDescription() +"\n";
    }
    return itemListLended;
  }

  /**
   * Method for creating items.
   *
   * @param name             To add name.
   * @param shortDescription To add short description.
   * @param costPerDay       To initilize cost per day.
   * @param dayOfCreation    To initilize day of creation.
   * @param isLended         To decide if it is lended.
   * @param contractPeriod   to initilize contract period.
   * @return Item.
   */
  public Item addItem(String name, String shortDescription, int costPerDay, int dayOfCreation,
      Boolean isLended, int contractPeriod, String owner, String lendedTo, String category) {
    Item.Mutable s = new Item.Mutable(name, shortDescription, costPerDay, dayOfCreation,
        isLended, contractPeriod, owner, lendedTo, category);
    setCredits(getCredits() + 100);
    itemsOwned.add(s);
    return s;
  }

  /**
   * Method for advancing time for the items owned and lended.
   *
   */
  @Override
  public void advanceTime() {
    time.dayChange();
    for (Item item : itemsOwned) {
      item.setDayOfCreationProt(item.getDayOfCreation() + 1);
    }
    for (Item item1 : itemsLended) {
      item1.setDayOfCreationProt(item1.getDayOfCreation() + 1);
    }
  }

  public int sizeOfItemsOwned() {
    return itemsOwned.size();
  }

  /**
   * Method for adding lended items to member object.
   *
   * @param leding adding lendings.
   */
  public void addItemLended(Item leding) {
    itemsLended.add(leding);
  }

  /**
   * Adding Items to ownied items list.
   *
   * @param ownedItem adding item.
   *
   */
  public void addPreparedItemOwned(Item.Mutable ownedItem) {
    itemsOwned.add(ownedItem);
  }

  public void setCredits(int credits) {
    this.credits = credits;
  }

  public Item.Mutable getItemOwned(int index) {
    index -= 1;
    return itemsOwned.get(index);
  }

  /**
   * Removing items from owned items.
   *
   * @param s Item that will be removed.
   */
  public void removeItemOwned(Item s) {
    itemsOwned.remove(s);
  }

  /**
   * Removing lended items.
   *
   * @param s item that will be removed.
   */
  public void removeItemLended(Item s) {
    itemsLended.remove(s);
  }

  // Updating items contract date and if date is fullfilled removing the item from
  // lendings.
  @Override
  public void updateItems() {
    ArrayList<Item> item = new ArrayList<>();
    item = itemsLended;
    int index = 0;
    if (!itemsLended.isEmpty()){
      for (Item eachItem : itemsLended) {
        index++;
        if (eachItem.getContractPeriod() > 0 ) {
          eachItem.setContractPeriodProt(eachItem.getContractPeriod() - 1);
        } else if (eachItem.getContractPeriod() == 0) {
          eachItem.setShortDescriptionProt(" Item contract has expired!");
          eachItem.setisLendedProt(false);
          eachItem.setLenededTo("No one ");
        }
      }
      for (Item item1 : itemsOwned) {
        if (item1.getContractPeriod() == 0) {
          item1.setLenededTo("No one");
          item1.setisLendedProt(false);
        }
      }

    }
  }

  /**
   * Setter method for firstname.
   *
   * @param firstName first to initilize first name.
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * Setter method for lastname.
   *
   * @param lastName To initilize the lastname.
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * Setter method for email.
   *
   * @param email To initilize email.
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Setter method for phone number.
   *
   * @param phoneNumber To initilize the phone number.
   */
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  /**
   * Mutable class.
   */
  public static class Mutable extends Member {

    /**
     * Contructor for mutable members.
     *
     * @param firstName   to initilize objects name.
     * @param lastName    to initilize last name.
     * @param email       to initilize email.
     * @param phoneNumber to initilize phone number.
     */
    public Mutable(String firstName, String lastName, String email, String phoneNumber) {
      super(firstName, lastName, email, phoneNumber);
    }

    Mutable(String firstName, String lastName, String email, String phoneNumber, MemberId id) {
      super(firstName, lastName, email, phoneNumber, id);
    }

  }
}
