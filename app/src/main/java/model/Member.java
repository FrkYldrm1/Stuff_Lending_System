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
  private ArrayList<Item> items = new ArrayList<>();

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
    for (Item item : items) {
      item.setDayOfCreationProt(value);
    }
  }

  // Total cost of items.
  public int costTotal() {
    for (Item item : items) {
      costTotal = +item.getCostPerDay() * (item.getCostPerDay() + 1);
    }
    return costTotal;
  }

  // Adding Item to member.
  public Item addItem(String name, String desc, int costPerDay, int dayOfCreation) {
    Item s = new Item(name, desc, costPerDay, dayOfCreation);
    items.add(s);
    return s;
  }

  public void removeItem(Item s) {
    items.remove(s);
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
