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
  private ArrayList<Item> itemsOwned  = new ArrayList<>();
  private ArrayList<Item> itemsLended  = new ArrayList<>();

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

  //Adding Item to member.
  public Item addItem(String name, String desc, int costPerDay, int dayOfCreation) {
    Item s = new Item(name, desc, costPerDay, dayOfCreation);
    items.add(s);
    return s;
  }

  //To advance time "value" times.
  @Override
  public void TimeAdvanced(int value) {
      time.dayChange(value);
      for(Item item : itemsOwned) {
        item.setDayOfCreationProt(value);
      } 
  }
  //Total cost of items.
  public int costTotal(){
    for(Item item: itemsOwned){
       costTotal =+ item.getCostPerDay() * (item.getCostPerDay() + 1);
    }
    return costTotal;
  }
<<<<<<< HEAD
=======
  
  //  For creation of items.
  public Item addItemOwned(String name, String desc, int costPerDay, int dayOfCreation, Boolean isOwned) {
    Item s = new Item(name, desc, costPerDay, dayOfCreation, isOwned);
    itemsOwned.add(s);
    credits += 100;
    return s;
  }
>>>>>>> 265abfc5c2b960aa656a5c43b27cfe2ab26f8599



  public void removeItemOwned(Item s) {
    itemsOwned.remove(s);
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
