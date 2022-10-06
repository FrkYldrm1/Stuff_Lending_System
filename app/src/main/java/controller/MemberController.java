package controller;

import model.Member;
import model.Registry;
import view.ConsoleUI;

// represents the controller controlling the members
public class MemberController {
  view.ConsoleUI console;
  model.Registry registry;
  view.ConsoleUI2 ui;
  model.Member member;

  // constructors for controller
  public MemberController(ConsoleUI console, Registry registry) {
    this.console = console;
    this.registry = registry;
  }

  // creates new member
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

    model.Member newMember = new Member(firstName, lastName, email, phoneNumber);
    registry.addMember(newMember);
  }

  public void showAllMembers() {
    for (Member.Mutable member : registry.getMembers()) {
      console.showMemberDetails(member);
    }
  }

  public void deleteMember(model.Member member) {
    registry.removeMember(member);
    ui.MemberDeletedMessage(member);
  }

  public void addItem() {
    member.addPreparedItemOwned(ui.createItem());
  }

  public void deleteItemOwned(model.Item i) {
    member.removeItemOwned(i);
  }

  public void deleteItemLended(model.Item i) {
    member.removeItemLended(i);
  }

  public void showMemberDetails() {
    member.toString();
  }

  public void listAllMembers() {
    registry.ListMembers();
  }

  /**
   * Checks if input is null
   * 
   * @param input any string
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
   * @param phoneNumber input
   * @return true if taken and false if available
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
   * @param email input
   * @return true if taken and false if available
   */
  public boolean isEmailAvailable(String email) {
    for (Member.Mutable member : registry.getMembers()) {
      if (member.getEmail().equals(email)) {
        return false;
      }
    }
    return true;
  }

}
