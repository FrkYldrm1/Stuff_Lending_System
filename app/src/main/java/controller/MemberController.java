package controller;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.ArrayList;
import model.domain.Item;
import model.domain.Member;
import model.domain.MemberId;
import model.domain.Registry;
import model.domain.Time;
import view.ConsoleUi;

/**
 * Class.
 */
public class MemberController {
  view.ConsoleUi console;
  Registry registry;
  Time time = new Time();

  /**
   * constructors for controller.
   */
  @SuppressFBWarnings(value = "EI_EXPOSE_REP", justification = "It is the constructor so we should have it.")
  public MemberController(ConsoleUi console, Registry registry) {
    this.console = console;
    this.registry = registry;
  }

  /**
   * creates new member.
   */
  public void createNewMember() {
    String firstName = console.getFirstName();
    while (check(firstName)) {
      firstName = console.newFirstName();
    }
    String lastName = console.getLastName();
    while (check(lastName)) {
      lastName = console.newLastName();
    }
    String email = console.getEmail();
    boolean done = false;
    while (!(done)) {
      if (check(email)) {
        email = console.newEmail();
      } else if (!(isEmailAvailable(email))) {
        email = console.uniqueEmail();
      } else {
        done = true;
      }
    }
    String phoneNumber = console.getPhoneNumber();
    done = false;
    while (!(done)) {
      if (check(phoneNumber)) {
        phoneNumber = console.newPhoneNumber();
      } else if (!(isPhoneNumberAvailable(phoneNumber))) {
        phoneNumber = console.uniquePhoneNumber();
      } else {
        done = true;
      }
    }
    MemberId id = new MemberId();
    while (isIdTaken(id)) {
      id = new MemberId();
    }
    Member newMember = new Member(firstName, lastName, email, phoneNumber, id);
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
   * Gets member based on position in arraylist.
   *
   * @param input position in arraylist.
   * @return member.
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
   * get item.
   *
   * @param input index.
   * @param m     member.
   * @return item.
   *
   */
  public Item.Mutable getItem(int input, Member.Mutable m) {
    ArrayList<Item.Mutable> items = new ArrayList<>();
    for (Item.Mutable item : m.getItemsOwned()) {
      items.add(item);
    }
    input -= 1;
    Item.Mutable item;
    try {
      item = items.get(input);
      return item;
    } catch (Exception e) {
      input = console.indexItemInputRetry();
      return getItem(input, m);
    }
  }

  /**
   * Used to show items owned by user.
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

  /**
   * Method for adding items.
   */
  public void addItem() {
    Member member;
    member = registry.getMember(console.idInput());

    String itemName = console.createItemName();
    while (itemName.equals("")) {
      itemName = console.createItemName2();
    }

    String description = console.createItemDescription();
    while (description.equals("")) {
      description = console.createItemDescription2();
    }

    int price = console.createItemPrice();
    while ((price < 1)) {
      price = console.createItemPrice2();
    }

    int itemCategory = console.createItemCategory();
    while ((itemCategory > 6) || (itemCategory < 1)) {
      itemCategory = console.createItemCategory2();
    }

    String category = "";
    if (itemCategory == 1) {
      category = "Tool";
    } else if (itemCategory == 2) {
      category = "Vehicle";
    } else if (itemCategory == 3) {
      category = "Game";
    } else if (itemCategory == 4) {
      category = "Toy";
    } else if (itemCategory == 5) {
      category = "Sport";
    } else if (itemCategory == 6) {
      category = "Other";
    }

    member.addPreparedItemOwned(new Item.Mutable(
        new Item(itemName, description, itemCategory, price, null, itemCategory, itemName, description, category)));
  }

  /**
   * Checks if input is null.
   *
   * @param input any string.
   *
   * @return true if null and false if not.
   */
  public boolean check(String input) {
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
    time.dayChange();
    registry.notifyMembersTime();
    console.advanceDayMessage();
  }

  /**
   * Method for editing member.
   */
  public void editMember() {
    String mem = console.selectedMember();
    int index = Integer.parseInt(mem);
    getMember(index).setFirstName(console.getFirstName());
    getMember(index).setLastName(console.getLastName());
    getMember(index).setEmail(console.getEmail());
    getMember(index).setPhoneNumber(console.getPhoneNumber());
    System.out.println("Member " + getMember(index).getFirstName() + " has been edited");
  }

  /**
   * Method for editing item.
   */
  public void editItem() {
    int memIndex = console.indexMemberInput();
    int index = console.indexItemInput();
    Item.Mutable item = getItem(index, getMember(memIndex));
    item.setName(console.newItemName());
    item.setShortDescription(console.newItemShortDescription());
    item.setCostPerDay(console.newItemCostPerDay());
  }

  /**
   * Method for deleting the member.
   */
  public void deleteMember() {
    String mem = console.selectMemberDelete();
    int index = Integer.parseInt(mem);
    registry.removeMember(getMember(index));
  }

  /**
   * Method for deleting owned items.
   */
  public void deleteItemOwned() {
    showAllMembersSimple();
    int memIndex = console.indexMemberInput();
    Member.Mutable member = getMember(memIndex);
    console.lineBreak();

    Iterable<Item.Mutable> items = member.getItemsOwned();
    int index = 0;
    for (Item.Mutable item : items) {
      index += 1;
      console.showItemDetails(item, index);
    }
    console.lineBreak();

    index = console.indexItemInput();
    member.removeItemOwned(getItem(index, member));

  }

  /**
   * Checks if member id is taken or available.
   *
   * @param id member id.
   * @return true if taken and false if available.
   *
   */
  public boolean isIdTaken(MemberId id) {
    for (Member.Mutable member : registry.getMembers()) {
      if (id.getId().equals(member.getMemberId().getId())) {
        return true;
      }
    }
    return false;
  }


  /**
   * Method for creating a contract.
   */
  public void contract() {
    showAllMembersSimple();
    int mem = console.selectMember();
    int lender = console.selectLender();
    int period = console.selectPeriod();
    console.showMemberDetails3(registry.selectMember(mem));
    int item = console.selectItem();
    registry.createContract(getMember(mem), getMember(lender), period, item);
    console.messageForLending(getMember(mem).getFirstName(), getMember(lender).getFirstName(), period);
  }
}