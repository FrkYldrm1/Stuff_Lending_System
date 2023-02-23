package model.domain;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import view.CategoryEnum;

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
  private Time time = new Time();
  private ArrayList<Item.Mutable> itemsOwned = new ArrayList<>();
  private ArrayList<Item> itemsLended = new ArrayList<>();


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
  @SuppressFBWarnings(value = "EI_EXPOSE_REP", justification = "In the program some values are accessed by this method."
      + " Making dummy and returning to not expose internal representation"
      + " might cut our access in some parts of the program.")
  public Iterable<Item.Mutable> getItemsOwned() {
    return itemsOwned;
  }

  /**
   * Getter for lended items.
   *
   * @return The list for return.
   */
  @SuppressFBWarnings(value = "EI_EXPOSE_REP", justification = "In the program some values are accessed by this method."
      + " Making dummy and returning to not expose internal representation"
      + " might cut our access in some parts of the program.")
  public Iterable<Item> getItemsLended() {
    return itemsLended;
  }

  /**
   * Returns size of items lended.
   * 
   * @return size of items lended.
   */
  public int getSizeOfItemsLended() {
    return itemsLended.size();
  }

  /**
   * Method for creating items.
   *
   * @param name             To add name.
   * @param shortDescription To add short description.
   * @param costPerDay       To initialize cost per day.
   * @param dayOfCreation    To initialize day of creation.
   * @param isLended         To decide if it is lended.
   * @param contractPeriod   to initialize contract period.
   * @return Item.
   */
  public Item addItem(String name, String shortDescription, int costPerDay, int dayOfCreation,
      Boolean isLended, int contractPeriod, String owner, String lendedTo, CategoryEnum category) {
    Item.Mutable s = new Item.Mutable(name, shortDescription, costPerDay, dayOfCreation,
        isLended, contractPeriod, owner, lendedTo, category);
    setCredits(getCredits() + 100);
    itemsOwned.add(s);
    return s;
  }

  public boolean isUniqueItem(String itemName) {
    for (Item.Mutable item : itemsOwned) {
      if (item.getName().trim().toLowerCase().equals(itemName.trim().toLowerCase())) {
        return true;
      }
    }
    return false;
  }

  public Time getTime() {
    return time;
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
    if (!itemsLended.isEmpty()) {
      for (Item eachItem : itemsLended) {
        if (eachItem.getContractPeriod() > 0) {
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
     * @param firstName   to initialize objects name.
     * @param lastName    to initialize last name.
     * @param email       to initialize email.
     * @param phoneNumber to initialize phone number.
     */
    public Mutable(String firstName, String lastName, String email, String phoneNumber) {
      super(firstName, lastName, email, phoneNumber);
    }

    Mutable(String firstName, String lastName, String email, String phoneNumber, MemberId id) {
      super(firstName, lastName, email, phoneNumber, id);
    }
  }

}
