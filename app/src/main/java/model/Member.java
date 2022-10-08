package model;

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
  private ArrayList<Item> itemsOwned = new ArrayList<>();
  private ArrayList<Item> itemsLended = new ArrayList<>();
  // private ArrayList<Item> items = new ArrayList<>(); // to take away?

  /**
   * Member constructor.
   *
   * @param firstName     to initilize name.
   * @param lastName      to initilize lastname.
   * @param email         to       initilize e-mail.
   * @param phoneNumber   to initilize phone number.
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
   * @param firstName     to initilize name.
   * @param lastName      to initilize lastname.
   * @param email          to       initilize e-mail.
   * @param phoneNumber    to initilize phone number.
   * @param id            initilize id.
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
  public ArrayList<Item> getItemsOwned() {
    ArrayList<Item> copy = new ArrayList<>();
    for (Item item : itemsOwned) {
      copy.add(item);
    }
    return copy;
  }
  
  String itemList = "";

  /**
   * Getter for owned items.
   *
   * @return The list for return.
   */
  public String getItemsOwnedString() {
    int counter = 0;
    for (Item item : itemsOwned) {
      counter += 1;
      itemList += "\n" + " Owned items : " + "\n" + counter + ". " + item.getName() + "-> Lended to: "+ item.getLenededTo() + ", Contract period: " +  item.getContractPeriod() + "\n";
    }
    return itemList;
  }

  
  /**
   * Method for creating items.
   *
   * @param name    To add name.
   * @param shortDescription  To add short description.
   * @param costPerDay To initilize cost per day.
   * @param dayOfCreation To initilize day of creation.
   * @param isLended To decide if it is lended.
   * @param contractPeriod to initilize contract period.
   * @return Item.
   */
  public Item addItem(String name, String shortDescription, int costPerDay, int dayOfCreation, Boolean isLended,
      int contractPeriod,  String owner, String lendedTo) {
    Item s = new Item(name, shortDescription, costPerDay, dayOfCreation, isLended, contractPeriod, owner, lendedTo);
    itemsOwned.add(s);
    return s;
  }

  
  /**
   * Method for advancing time for the items owned and lended.
   *
   * @param value number of days for advancing.
   */
  @Override
  public void advanceTime(int value) {
    time.dayChange(value);
    for (Item item : itemsOwned) {
      item.setDayOfCreationProt(value);
    }
    for (Item item1 : itemsLended) {
      item1.setDayOfCreationProt(value);
    }
  }
  
  /**
   * Getter method for time.
   *
   * @return int.
   */
  public int getTime() {
    return time.getDay();
  }


  /**
   * Total cost of items.
   *
   * @return int.
   */
  public int costTotal() {
    for (Item item : itemsLended) {
      costTotal = +item.getCostPerDay() * (item.getCostPerDay() + 1);
    }
    return costTotal;
  }

  public void deleteItem(int index) {
  itemsOwned.remove(index);
  }

  
  /**
   * Method for creating items.
   *
   * @param name             To add name.
   * @param costPerDay       To initilize cost per day.
   * @param dayOfCreation    To initilize day of creation.
   * @param isLended         To decide if it is lended.
   * @param contractPeriod   to initilize contract period.
   * @return Item.
   */
  public Item addItemOwned(String name, String desc, int costPerDay, int dayOfCreation, Boolean isLended,
      int contractPeriod,  String owner, String lendedTo) {
    Item s = new Item(name, desc, costPerDay, dayOfCreation, isLended, contractPeriod, owner, lendedTo);
    itemsOwned.add(s);
    credits += 100;
    return s;
  }

  
  /**
   * Method for adding lended items to member object.
   *
   * @param leding adding lendings.
   */
  public void addItemLended(Item leding) {
    itemsOwned.add(leding);
  }

  
  /**
   * Adding Items to ownied items list.
   *
   * @param ownedItem adding item.
   *
   */
  public void addPreparedItemOwned(Item ownedItem) {
    itemsOwned.add(ownedItem);
  }

  public void getItemOwned() {

  }

  
  /**
   * Getting lending cost for an item.
   *
   * @param lendedItem adding lended item.
   * @return int.
   */
  public int getLendingCost(Item lendedItem) {
    int cost = lendedItem.getCostPerDay() * (lendedItem.getDayOfCreation() + 1);
    return cost;
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
    // TODO Auto-generated method stub
    for (Item eachItem : itemsLended) {
      if (eachItem.getContractPeriod() != 0) {
        eachItem.setContractPeriodProt(eachItem.getContractPeriod() - 1);
        if (eachItem.getContractPeriod() == 0) {
          itemsLended.remove(eachItem);
        }
      } else if (eachItem.getDayOfCreation() == 0) {
        itemsLended.remove(eachItem);
      }
    }
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setEmail(String email) {
    this.email = email;
  }

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
