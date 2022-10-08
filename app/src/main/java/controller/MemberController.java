package controller;

import java.util.ArrayList;

import org.checkerframework.checker.units.qual.m;

import model.Item;
import model.Member;
import model.MemberId;
import model.Registry;
import model.Time;
import view.ConsoleUi;

/**
 * Class.
 */
public class MemberController {
  view.ConsoleUi console;
  model.Registry registry;
  model.Member member;
  model.Time time = new Time();

  /**
   * constructors for controller.
   */
  public MemberController(ConsoleUi console, Registry registry) {
    this.console = console;
    this.registry = registry;
  }

  /**
   * creates new member.
   */
  public void createNewMember() {
    // model.Member newMember = console.createMember();
    // registry.addMember(newMember);
    // ui.MemberAddedMessage(newMember);

    // for the first name
    String firstName = console.getFirstName();
    while (isNull(firstName)) {
      firstName = console.newFirstName();
    }

    // for the last name
    String lastName = console.getLastName();
    while (isNull(lastName)) {
      lastName = console.newLastName();
    }

    // email
    String email = console.getEmail();
    boolean done = false;
    while (!(done)) {
      if (isNull(email)) {
        email = console.newEmail();
      } else if (!(isEmailAvailable(email))) {
        email = console.uniqueEmail();
      } else {
        done = true;
      }
    }

    // phone number
    String phoneNumber = console.getPhoneNumber();
    done = false;
    while (!(done)) {
      if (isNull(phoneNumber)) {
        phoneNumber = console.newPhoneNumber();
      } else if (!(isPhoneNumberAvailable(phoneNumber))) {
        phoneNumber = console.uniquePhoneNumber();
      } else {
        done = true;
      }
    }

    model.MemberId id = new MemberId();

    while (isIdTaken(id)) {
      id = new MemberId();
    }

    model.Member newMember = new Member(firstName, lastName, email, phoneNumber, id);
    registry.addMember(newMember);
  }

  /**
   * Method for showing the members.
   */
  public void showAllMembersSimple() {
    int index = 0;
    for (Member.Mutable member : registry.getMembers()) {
      index += 1;
      console.showMemberDetailsSimple(member, index);
    }
  }

  /**
   * Method for showing the members.
   */
  public void showAllMembers2() {
    int index = 0;
    for (Member.Mutable member : registry.getMembers()) {
      index += 1;
      console.showMemberDetails2(member, index);
    }
    console.lineBreak();
  }

  /**
   * Gets member based on position in arraylist
   *
   * @param input position in arraylist
   * @return member
   */
  public Member.Mutable getMember(int input) {
    input -= 1;
    ArrayList<Member.Mutable> arraylist = new ArrayList<>();
    for (Member.Mutable member : registry.getMembers()) {
      arraylist.add(member);
    }

    try {
      Member.Mutable member = arraylist.get(input);
      return member;
    } catch (Exception e) {
      input = console.indexMemberInputRetry();
      return getMember(input);
    }
  }

  /**
   * Used to show items owned by user.
   */
  /**
   * Method for showing members owned items.
   */
  public void showOwnedItems() {
    Member.Mutable member = getMember(console.indexMemberInput());
    int index = 0;

    for (Item item : member.getItemsOwned()) {
      index += 1;
      console.showItemDetails(item, index);
    }
  }

  public void selectMember() {
    registry.getMember(console.idInput());
  }

  /**
   * Method for deleting the member.
   */
  public void deleteMember(model.Member member) {
    registry.removeMember(member);
  }

  /**
   * Method for adding items.
   */
  public void addItem() {
    registry.getMember(console.idInput()).addPreparedItemOwned(console.createItem());
  }

  /**
   * Method for deleting owned items.
   */
  public void deleteItemOwned(model.Item i) {
    member.removeItemOwned(i);
  }

  /**
   * Method for deleting lended items.
   */
  public void deleteItemLended(model.Item i) {
    member.removeItemLended(i);
  }

  /**
   * Method for showing member details.
   */
  public void showMemberDetails() {
    member.toString();
  }

  /**
   * Method for listing the members.
   */
  public void listAllMembers() {
    registry.listMembers();
  }

  /**
   * Checks if input is null.
   *
   * @param input any string.
   *
   * @return true if null and false if not.
   */
  public boolean isNull(String input) {
    if (input.equals("") || input.equals(" ") || input == null) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Checks if phone number is already taken.
   *
   * @param phoneNumber input.
   *
   * @return true if taken and false if available.
   */
  public boolean isPhoneNumberAvailable(String phoneNumber) {
    for (Member.Mutable member : registry.getMembers()) {
      if (member.getPhoneNumber().equals(phoneNumber)) {
        return false;
      }
    }
    return true;
  }

  /**
   * Checks if email is already taken.
   *
   * @param email input.
   *
   * @return true if taken and false if available.
   */
  public boolean isEmailAvailable(String email) {
    for (Member.Mutable member : registry.getMembers()) {
      if (member.getEmail().equals(email)) {
        return false;
      }
    }
    return true;
  }

  /**
   * Method for changing the day for every object.
   */
  public void changeDay() {
    time.dayChange(console.dayInput());
    registry.notifyMembersTime(time.getDay());
  }

  /**
   * Method for editing member.
   */
  public void editMember() {
    String mem = console.selectedMember();
    int index = Integer.parseInt(mem);
    System.out.println(index);
    //index -= 1;
    getMember(index).setFirstName(console.getFirstName());
    getMember(index).setLastName(console.getLastName());
    getMember(index).setEmail(console.getEmail());
    getMember(index).setPhoneNumber(console.getPhoneNumber());
    System.out.println("Member " + getMember(index).getFirstName() + " has been edited");
  }
  /**
   * Checks if member Id is taken or available
   *
   * @param id member id
   * @return true if taken and false if available
   */
  public boolean isIdTaken(MemberId id) {
    for (Member.Mutable member : registry.getMembers()) {
      if (id.getId().equals(member.getMemberId().getId())) {
        return true;
      }
    }
    return false;
  }

}
