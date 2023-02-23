package controller;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import javax.swing.text.View;

import model.domain.Item;
import model.domain.Member;
import model.domain.MemberId;
import model.domain.Registry;
import model.domain.Time;
import view.CategoryEnum;
import view.ConsoleUi;
import view.Language;
import view.SwedishUI;

/**
 * Class.
 */
public class MemberController {
  private Language console;

  private Registry registry = new Registry();
  private Time time = new Time();

  public void createMember() {
    String firstName = console.getFirstName();
    while (console.check(firstName)) {
      firstName = console.newFirstName();
    }
    String lastName = console.getLastName();
    while (console.check(lastName)) {
      lastName = console.newLastName();
    }
    String email = console.getEmail();
    boolean done = false;
    while (!(done)) {
      if (console.check(email)) {
        email = console.newEmail();
      } else if (!(registry.isEmailAvailable(email))) {
        email = console.uniqueEmail();
      } else {
        done = true;
      }
    }
    String phoneNumber = console.getPhoneNumber();
    done = false;
    while (!(done)) {
      if (console.check(phoneNumber)) {
        phoneNumber = console.newPhoneNumber();
      } else if (!(registry.isPhoneNumberAvailable(phoneNumber))) {
        phoneNumber = console.uniquePhoneNumber();
      } else {
        done = true;
      }
    }
    MemberId id = new MemberId();
    while (registry.isIdTaken(id)) {
      id = new MemberId();
    }
    registry.createNewMember(firstName, lastName, email, phoneNumber, id);
  }

  /**
   * constructors for controller.
   */
  @SuppressFBWarnings(value = "EI_EXPOSE_REP", justification = "It is the constructor so we should have it.")
  public MemberController(Language console) {
    this.console = console;

  }

  public void languageCheck() {
    if (console instanceof SwedishUI) {
      registry.sortById();
    } else {
      registry.sortByName();
    }
  }

  /**
   * Method for showing the members.
   */
  public void showAllMembersSimple() {
    int index = 0;
    languageCheck();
    for (Member.Mutable member : registry.getMembers()) {
      index += 1;
      String value;
      if (console instanceof ConsoleUi) {
        value = String.valueOf(index);
      } else {
        value = String.valueOf(switchInputFromNumToAlph(index));
      }
      console.showMemberDetailsSimple(member.getFirstName(), member.getEmail(), member.getLastName(),
          member.getMemberId().getId(), member.getCredits(), member.sizeOfItemsOwned(), member.getTime().getDay(),
          value);
    }
  }

  /**
   * Method for showing the members.
   */
  public void showAllMembers2() {
    languageCheck();
    for (Member.Mutable member : registry.getMembers()) {
      console.showMemberDetails2(member.getFirstName(), member.getLastName(), member.getEmail());

      // need to show items owned and lended
      console.showOwnedItemIntro();
      int index = 0;
      String value;
      if (member.sizeOfItemsOwned() > 0) {
        for (Item item : member.getItemsOwned()) {
          index += 1;
          if (console instanceof ConsoleUi) {
            value = String.valueOf(index);
          } else {
            value = String.valueOf(switchInputFromNumToAlph(index));
          }
          console.showItemDetails2(value, item.getName(), item.getLenededTo(), item.getContractPeriod());
        }
      }

      index = 0;
      if (member.getSizeOfItemsLended() > 0) {
        console.showLendedItemIntro();
              for (Item item : member.getItemsLended()) {
                index += 1;
                if (console instanceof ConsoleUi) {
                  value = String.valueOf(index);
                } else {
                  value = String.valueOf(switchInputFromNumToAlph(index));
                }
                console.showItemDetails3(value, item.getName(), item.getOwner(), item.getContractPeriod());
              
              }
      }
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
    Member.Mutable member = getMember(Integer.parseInt(console.indexMemberInput()));
    int index = 0;

    for (Item item : member.getItemsOwned()) {
      index += 1;
      String value;
      if (console instanceof ConsoleUi) {
        value = String.valueOf(index);
      } else {
        value = String.valueOf(switchInputFromNumToAlph(index));
      }
      console.showItemDetails(item.getName(), item.getShortDescription(),
          item.getCostPerDay(), String.valueOf(item.getCategory()),
          item.getDayOfCreation(), value);
    }
  }

  /**
   * Method for adding items.
   */
  public void addItem() {
    Member member;
    int memIndex;
    String s = console.indexMemberInput();
    while (!(s = console.indexMemberInput().trim()).matches("\\d+")) {
      s = console.indexMemberInput();
    }
    memIndex = Integer.parseInt(s);
    member = getMember(memIndex);
    String itemName = console.createItemName();
    while(itemName.matches(".*\\d+.*")) {
      itemName = console.createItemName();
    }

    while (itemName.equals("")) {
      itemName = console.createItemName2();
    }
    while (member.isUniqueItem(itemName) || itemName.equals("")) {
      itemName = console.createItemName2();
    }
    String description = console.createItemDescription();
    while (description.equals("")) {
      description = console.createItemDescription2();
    }

    s = null;
    while (!(s = console.createItemPrice().trim()).matches("\\d+")) {
      s = console.createItemPrice();
    }
    int price = Integer.parseInt(s);

    while ((Integer.parseInt(s) < 1)) {
      price = Integer.parseInt(console.createItemPrice2());
    }
    CategoryEnum input = console.selectCategory();
    CategoryEnum category = CategoryEnum.TOOL;

    switch (input) {
      case TOOL:
        category = CategoryEnum.TOOL;
        break;
      case VEHICLE:
        category = CategoryEnum.VEHICLE;
        break;
      case GAME:
        category = CategoryEnum.GAME;
        break;
      case TOY:
        category = CategoryEnum.TOY;
        break;
      case SPORT:
        category = CategoryEnum.SPORT;
        break;
      case OTHER:
        category = CategoryEnum.OTHER;
        break;
      default:
        addItem();
    }

    member.addItem(itemName, description, price, 1, false, 0,
        member.getFirstName() + member.getLastName(), "", category);

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
    System.out.println("Member " + getMember(index).getFirstName() + " has been edited"); // fix
                                                                                          // this////////////////////////
  }

  /**
   * Method for editing item.
   */
  public void editItem() {
    int memIndex = Integer.parseInt(console.indexMemberInput());
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
    int memIndex = Integer.parseInt(console.indexMemberInput());
    Member.Mutable member = getMember(memIndex);
    console.lineBreak();

    Iterable<Item.Mutable> items = member.getItemsOwned();
    int index = 0;
    for (Item.Mutable item : items) {
      index += 1;
      String value;
      if (console instanceof ConsoleUi) {
        value = String.valueOf(index);
      } else {
        value = String.valueOf(switchInputFromNumToAlph(index));
      }
      console.showItemDetails(item.getName(), item.getShortDescription(),
          item.getCostPerDay(), String.valueOf(item.getCategory()),
          item.getDayOfCreation(), value);
    }
    console.lineBreak();

    index = console.indexItemInput();
    member.removeItemOwned(getItem(index, member));

  }

  /**
   * Method for creating a contract.
   */
  public void contract() {
    showAllMembersSimple();
    String in = console.selectMember();
    int mem = Integer.parseInt(in);
    int lender = console.selectLender();
    int period = console.selectPeriod();

    console.showMemberDetails3(registry.selectMember(mem).getFirstName(), registry.selectMember(mem).getEmail(),
        registry.selectMember(mem).getMemberId().getId());
    console.showOwnedItemIntro();
    int index = 0;
    String value;
    for (Item item : registry.selectMember(mem).getItemsOwned()) {
      index += 1;
      if (console instanceof ConsoleUi) {
        value = String.valueOf(index);
      } else {
        value = String.valueOf(switchInputFromNumToAlph(index));
      }
      console.showItemDetails2(value, item.getName(), item.getLenededTo(), item.getContractPeriod());
    }

    int itemIndex = console.selectItem();
    registry.createContract(getMember(mem), getMember(lender), period, itemIndex);
    Boolean isContractEligble = registry.getIsEligable();
    if (isContractEligble == null)
      console.alreadyLended();
    else if (!(isContractEligble)) {
      console.notEnoughCredit();
    } else {
      console.messageForLending(getMember(mem).getFirstName(), getMember(lender).getFirstName(), period);
    }
  }

  /**
   * Prints members with their names then proceed to print details about member.
   */
  public void printMemberSpecific() {
    languageCheck();
    int index = 0;
    for (Member.Mutable member : registry.getMembers()) {
      index += 1;
      String value;
      if (console instanceof ConsoleUi) {
        value = String.valueOf(index);
      } else {
        value = String.valueOf(switchInputFromNumToAlph(index));
      }
      console.showMemberSpceific(value, member.getFirstName(), member.getLastName());
    }

    Member.Mutable member = getMember(Integer.parseInt(console.indexMemberInput()));
    console.showMemberDetails3(member.getFirstName(), member.getEmail(), member.getMemberId().getId());
    console.showOwnedItemIntro();

    index = 0;
    for (Item item : member.getItemsOwned()) {
      index += 1;
      String value;
      if (console instanceof ConsoleUi) {
        value = String.valueOf(index);
      } else {
        value = String.valueOf(switchInputFromNumToAlph(index));
      }
      console.showItemDetails2(value, item.getName(), item.getLenededTo(), item.getContractPeriod());
    }
  }

  public char switchInputFromNumToAlph(int number) {
    String alphabetPool = "abcdefghijklmnopqrstuvwxyz";
    return alphabetPool.charAt(number - 1);
  }
}