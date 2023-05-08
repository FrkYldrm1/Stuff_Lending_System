package controller;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.ArrayList;
import model.domain.Item;
import model.domain.Member;
import model.domain.MemberId;
import model.domain.Registry;
import model.domain.Time;
import view.CategoryEnum;
import view.Language;

/**
 * Class.
 */
public class MemberController {
  private final Language console;

  private final Registry registry = new Registry();
  private final Time time = new Time();

  /**
   * method for creating member.
   */
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

  /**
   * Method for showing the members.
   */
  public void showAllMembersSimple() {
    int index = 0;
    
    ArrayList<Member.Mutable> members = console.sortMembers(registry);

    for (Member.Mutable member : members) {
      index += 1;
      String value = String.valueOf(index);

      console.showMemberDetailsSimple(member.getFirstName(), member.getEmail(), member.getLastName(),
          member.getMemberId().getId(), member.getCredits(), member.sizeOfItemsOwned(), member.getTime().getDay(),
          value);
    }
  }

  /**
   * Method for showing the members.
   */
  public void showAllMembers2() {

    ArrayList<Member.Mutable> members = console.sortMembers(registry);

    for (Member.Mutable member : members) {
      console.showMemberDetails2(member.getFirstName(), member.getLastName(), member.getEmail());

      // need to show items owned and lended
      console.showOwnedItemIntro();
      int index = 0;
      String value;
      if (member.sizeOfItemsOwned() > 0) {
        for (Item item : member.getItemsOwned()) {
          index += 1;
          value = String.valueOf(index);
          console.showItemDetails2(value, item.getName(), item.getLenededTo(), item.getContractPeriod());
        }
      }

      index = 0;
      if (member.getSizeOfItemsLended() > 0) {
        console.showLendedItemIntro();
        for (Item item : member.getItemsLended()) {
          index += 1;
          value = String.valueOf(index);
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
    ArrayList<Member.Mutable> arraylist = console.sortMembers(registry);

    try {
      return arraylist.get(input - 1);
    } catch (Exception e) {

      String in = console.indexMemberInputRetry();
      input = Integer.parseInt(in);
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
    String in = console.indexMemberInput();
    int input = Integer.parseInt(in);
    Member.Mutable member = getMember(input);
    int index = 0;

    for (Item item : member.getItemsOwned()) {
      index += 1;
      String value = String.valueOf(index);
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
    int memIndex = 0;
    String s = console.indexMemberInput();

    Boolean status = true;
    while (status) {
      try {
        memIndex = Integer.parseInt(s);
        status = false;
      } catch (Exception e) {
        s = console.indexMemberInput();
      }
    }


    member = getMember(memIndex);
    String itemName = console.createItemName();
    while (itemName.matches(".*\\d+.*")) {
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

    while (!(s.trim()).matches("\\d+")) {
      s = console.createItemPrice();
    }
    int price = Integer.parseInt(s);

    while ((Integer.parseInt(s) < 1)) {
      price = Integer.parseInt(console.createItemPrice2());
    }
    CategoryEnum input = console.selectCategory();
    CategoryEnum category = null;

    switch (input) {
      case TOOL -> category = CategoryEnum.TOOL;
      case VEHICLE -> category = CategoryEnum.VEHICLE;
      case GAME -> category = CategoryEnum.GAME;
      case TOY -> category = CategoryEnum.TOY;
      case SPORT -> category = CategoryEnum.SPORT;
      case OTHER -> category = CategoryEnum.OTHER;
      default -> addItem();
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
    String index = console.selectedMember();
    int inputMem = Integer.parseInt(index);
    Member member = getMember(inputMem);
    member.setFirstName(console.getFirstName());
    member.setLastName(console.getLastName());
    member.setEmail(console.getEmail());
    member.setPhoneNumber(console.getPhoneNumber());
  }


  /**
   * Method for editing item.
   */
  public void editItem() {
    showAllMembersSimple();

    String inMem = console.indexMemberInput();
    int inputMem = Integer.parseInt(inMem);

    String indItem = console.indexItemInput();
    int inputItem = Integer.parseInt(indItem);

    Item.Mutable item = getItem(inputItem, getMember(inputMem));
    item.setName(console.newItemName());
    item.setShortDescription(console.newItemShortDescription());
    item.setCostPerDay(console.newItemCostPerDay());
  }

  /**
   * Method for deleting the member.
   */
  public void deleteMember() {
    String index = console.selectMemberDelete();
    int inputMem;
    try {
      inputMem = Integer.parseInt(index);
      registry.removeMember(getMember(inputMem));
    } catch (Exception e) {
      deleteMember();
    }
  }

  /**
   * Method for deleting owned items.
   */
  public void deleteItemOwned() {
    showAllMembersSimple();

    String inMem = console.indexMemberInput();
    int inputMem = Integer.parseInt(inMem);

    Member.Mutable member = getMember(inputMem);
    console.lineBreak();

    Iterable<Item.Mutable> items = member.getItemsOwned();
    int index = 0;
    for (Item.Mutable item : items) {
      index += 1;
      String value = String.valueOf(index);
      console.showItemDetails(item.getName(), item.getShortDescription(),
          item.getCostPerDay(), String.valueOf(item.getCategory()),
          item.getDayOfCreation(), value);
    }
    console.lineBreak();

    String indItem = console.indexItemInput();
    int inputItem = Integer.parseInt(indItem);


    member.removeItemOwned(getItem(inputItem, member));

  }

  /**
   * Method for creating a contract.
   */
  public void contract() {
    showAllMembersSimple();

    String inMem = console.selectMember();
    int mem = Integer.parseInt(inMem);

    console.showMemberDetails3(registry.selectMember(mem).getFirstName(), registry.selectMember(mem).getEmail(),
            registry.selectMember(mem).getMemberId().getId());

    console.showOwnedItemIntro();

    int index = 0;
    String value;
    for (Item item : registry.selectMember(mem).getItemsOwned()) {
      index += 1;
      value = String.valueOf(index);
      console.showItemDetails2(value, item.getName(), item.getLenededTo(), item.getContractPeriod());
    }

    String itemIndex = console.selectItem();
    int item = Integer.parseInt(itemIndex);

    String lender = console.selectLender();

    int len = Integer.parseInt(lender);
    int period = console.selectPeriod();

    registry.createContract(getMember(mem), getMember(len), period, item);
    Boolean isContractEligble = registry.getIsEligable();
    if (isContractEligble == null) {
      console.alreadyLended();
    } else if (!(isContractEligble)) {
      console.notEnoughCredit();
    } else {
      console.messageForLending(getMember(mem).getFirstName(), getMember(len).getFirstName(), period);
    }
  }

  /**
   * Prints members with their names then proceed to print details about member.
   */
  public void printMemberSpecific() {
    
    ArrayList<Member.Mutable> members = console.sortMembers(registry);

    int index = 0;
    for (Member.Mutable member : members) {
      index += 1;
      String value = String.valueOf(index);
      console.showMemberSpceific(value, member.getFirstName(), member.getLastName());
    }

    String inMem = console.indexMemberInput();
    int inputMem = Integer.parseInt(inMem);
    

    Member member = getMember(inputMem);

    console.showMemberDetails3(member.getFirstName(), member.getEmail(), member.getMemberId().getId());
    console.showOwnedItemIntro();

    index = 0;
    for (Item item : member.getItemsOwned()) {
      index += 1;
      String value = String.valueOf(inputMem);
      console.showItemDetails2(value, item.getName(), item.getLenededTo(), item.getContractPeriod());
    }
  }

  /**
   * method for converting int to string.
   *
   * @param number int input.
   * @return string.
   *
   */
  public char convertNumToAlph(int number) {
    int asciiStart = 96;
    asciiStart += number;
    return ((char) asciiStart);

  }

  public int converAlphToNum(char character) {
    int asciiStart = 96;
    return (((int) character) - asciiStart);
  }

}