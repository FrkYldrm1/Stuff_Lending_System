package model;

import java.util.ArrayList;

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

  public Member(String firstName, String lastName, String email, String phoneNumber) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.memberId = new MemberId();
    this.credits = 100;
  }

  public Member(String firstName, String lastName, String email, String phoneNumber, MemberId id) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.memberId = id;
    this.credits = 100;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getEmail() {
    return email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public MemberId getMemberId() {
    return memberId;
  }

  public int getCredits() {
    return credits;
  }

  // To advance time "value" times.
  @Override
  public void TimeAdvanced(int value) {
    time.dayChange(value);
    for (Item item : itemsOwned) {
      item.setDayOfCreationProt(value);
    }
    for (Item item1 : itemsLended) {
      item1.setDayOfCreationProt(value);
    }

  }

  // Total cost of items.
  public int costTotal() {
    for (Item item : itemsLended) {
      costTotal = +item.getCostPerDay() * (item.getCostPerDay() + 1);
    }
    return costTotal;
  }

  // For creation of items.
  public Item addItemOwned(String name, String desc, int costPerDay, int dayOfCreation, Boolean isLended, int contractPeriod) {
    Item s = new Item(name, desc, costPerDay, dayOfCreation, isLended, contractPeriod);
    itemsOwned.add(s);
    credits += 100;
    return s;
  }

  // Adding Items to lendigs list.
  public void addItemLended(Item leding) {
    itemsOwned.add(leding);
  }

  // Getting lending cost for an item.
  public int getLendingCost(Item lendedItem) {
    int cost = lendedItem.getCostPerDay() * (lendedItem.getDayOfCreation() + 1);
    return cost;
  }

  // Removing items from owned items.
  public void removeItemOwned(Item s) {
    itemsOwned.remove(s);
  }

  // Removing lended items.
  public void removeItemLended(Item s) {
    itemsLended.remove(s);
  }

  // Updating items contract date and if date is fullfilled removing the item from lendings.
  @Override
  public void updateItems() {
    // TODO Auto-generated method stub
    for (Item eacItem : itemsLended) {
      if (eacItem.getContractPeriod() != 0) {
        eacItem.setContractPeriodProt(eacItem.getContractPeriod() - 1);
      }
      if (eacItem.getDayOfCreation() == 0) {
        itemsLended.remove(eacItem);
      }
    }
  }

  public static class Mutable extends Member {

    public Mutable(String firstName, String lastName, String email, String phoneNumber) {
      super(firstName, lastName, email, phoneNumber);
    }

    Mutable(String firstName, String lastName, String email, String phoneNumber, MemberId id) {
      super(firstName, lastName, email, phoneNumber, id);
    }

  }

}
