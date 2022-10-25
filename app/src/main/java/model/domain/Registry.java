package model.domain;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Registry class for saving data.
 */
public class Registry {
  view.ConsoleUi console = new view.ConsoleUi(new Scanner(System.in, "UTF8"));
  Item item = new Item();
  private ArrayList<Member.Mutable> members;

  /**
   * Constructor.
   */
  public Registry() {
    members = new ArrayList<>();

    addMember("Bruce", "Lee", "Bruce@gmail.com", "988");
    addMember("Maya", "Hee", "mayahaha@gmail.com", "9843");
    addMember("Ahmad", "Deeb", "ahmad@gmail.com", "123456");
    addMember("Philip", "Olsson", "philip@gmail.com", "234567");
    addMember("Faruk", "Yildirim", "faruk@gmail.com", "345678");
    addMember("Lea", "Le Galo", "lea@gmail.com", "456789");
    addMember("Gummi", "Andri", "gummi@gmail.com", "567890");
    addMember("Grace", "Yasine", "grace@gmail.com", "67687587");
    members.get(0).addItem("phone", "black", 45, 3, false, 0, members.get(0).getFirstName(), " No one ", Item.CategoryEnum.TOOL);
    members.get(0).addItem("phone", "black", 45, 3, false, 0, members.get(0).getFirstName(), " No one ", Item.CategoryEnum.TOOL);
    members.get(1).addItem("Phone", "Brown", 15, 1, false, 0, members.get(1).getFirstName(), " No one ", Item.CategoryEnum.TOOL);
    members.get(2).addItem("scooter", "White", 25, 1, false, 2, members.get(2).getFirstName(), " No one ", Item.CategoryEnum.VEHICLE);
    members.get(6).addItem("VacuumCleaner", "Red", 10, 2, false, 5, members.get(6).getFirstName(), " No one ", Item.CategoryEnum.TOOL);
    members.get(4).addItem("E-vape", "black", 5, 3, false, 7, members.get(4).getFirstName(), " No one ", Item.CategoryEnum.OTHER);
    members.get(3).addItem("Burgiiiir", "Green", 5, 1, false, 1, members.get(3).getFirstName(), " No one ", Item.CategoryEnum.OTHER);
    members.get(5).addItem("Bike", "Yellow", 20, 8, false, 9, members.get(5).getFirstName(), " No one ", Item.CategoryEnum.VEHICLE);
    members.get(2).addItem("Ipad", "Gray", 50, 2, false, 4, members.get(2).getFirstName(), " No one ", Item.CategoryEnum.TOOL);
  }

  /**
   * Getter method for members.
   *
   * @return Iterable Mutable.
   */
  @SuppressFBWarnings(value = "EI_EXPOSE_REP", justification = "In the program some values are accessed by this method."
      + " Making dummy and returning to not expose internal representation"
      + " might cut our access in some parts of the program.")
  public Iterable<Member.Mutable> getMembers() {
    return members;
  }

  /**
   * Method for adding members adds members without an id.
   *
   * @param firstName   To initilize First name.
   * @param lastName    To initilize Last name.
   * @param email       To initilize email.
   * @param phoneNumber To initilize phone number.
   * @return Member.
   */
  public Member addMember(String firstName, String lastName, String email, String phoneNumber) {
    Member.Mutable x = new Member.Mutable(firstName, lastName, email, phoneNumber);
    members.add(x);
    return x;
  }

  /**
   * Adds members with id already.
   *
   * @param mem member object to add in the list.
   * @return Member.
   */
  public Member addMember(Member mem) {
    Member.Mutable x = new Member.Mutable(mem.getFirstName(), mem.getLastName(), mem.getEmail(), mem.getPhoneNumber(),
        mem.getMemberId());
    members.add(x);
    return x;
  }

  /**
   * For getting spesific member.
   *
   * @param memberId Gets the member with member id.
   * @return Member.
   */
  public Member getMember(String memberId) {
    for (Member member : members) {
      if (member.getMemberId().getId().equals(memberId)) {
        return member;
      }
    }
    return members.get(0);
  }

  /**
   * To remove a member from a list.
   *
   * @param s member that will be removed.
   */
  public void removeMember(Member s) {
    members.remove(s);
  }

  /**
   * Method for changing the time.
   */
  public void notifyMembersTime() {
    for (Member s : members) {
      s.advanceTime();
      s.updateItems();
    }
  }

  /**
   * Method for listing a short overview of members.
   */
  public void listMemberSpecific() {
    int index = 0;
    for (Member.Mutable member : members) {
      index += 1;
      System.out.println(index + " " + member.getFirstName() + " " + member.getLastName());
    }
  }

  /**
   * Selecting the members.
   *
   * @param index To get the member by index.
   * @return Member.
   */
  public Member.Mutable selectMember(int index) {
    index -= 1;
    return members.get(index);
  }

  /**
   * Method for creating a contract and update objects with contract.
   *
   * @param owner          For initilizing owner object.
   * @param lender         For initilizing lender object.
   * @param contractPeriod For initilizing contract period.
   * @param item           For initilizing item object.
   */
  public void createContract(Member owner, Member lender, int contractPeriod, int item) {
    Contract contract = new Contract(owner, lender, contractPeriod, item);
    this.item = contract.getOwner().getItemOwned(item);
    if (!contract.getOwner().getItemOwned(item).isLended()) {
      if (isEligable(this.item.getCostPerDay(), contractPeriod, lender)) {
        this.item.setContractPeriodProt(contractPeriod);
        this.item.setLenededTo(lender.getFirstName());
        this.item.setisLendedProt(true);
        contract.getOwner().getItemOwned(item).setContractPeriod(contractPeriod);
        contract.getOwner().getItemOwned(item).setLenededTo(lender.getFirstName());
        contract.getOwner().getItemOwned(item).setisLendedProt(true);
        contract.getLentTo().addItemLended(this.item);
        int cost = this.item.getCostPerDay() * contractPeriod;
        contract.getLentTo().setCredits(contract.getLentTo().getCredits() - cost);
        contract.getOwner().setCredits(contract.getOwner().getCredits() + (contractPeriod * this.item.getCostPerDay()));
      } else {
        console.notEnoughcredit();
      }
    } else {
      console.alreadyLended();
    }
  }

  /**
   * Method for checking eligibilty of member to lend an item.
   *
   * @param cost           Parameters for eligibility.
   * @param contractPeriod Parameters for eligibility.
   * @param member         Parameters for eligibility.
   * @return Returns if member is eligible.
   */
  public boolean isEligable(int cost, int contractPeriod, Member member) {
    int total = cost * contractPeriod;
    if (total > member.getCredits()) {
      return false;
    }
    return true;
  }

  /**
   * Checks if the email is alreaady taken or not
   * 
   * @param email as input
   * @return true if email is still available and false if not
   */
  public boolean isEmailAvailable(String email) {
    for (Member.Mutable member : members) {
      if (member.getEmail().equals(email)) {
        return false;
      }
    }
    return true;
  }

  /**
   * Checks if the phonenumber is already taken or not
   * 
   * @param phoneNumber as input
   * @return true if phone number is available and false if not
   */
  public boolean isPhoneNumberAvailable(String phoneNumber) {
    for (Member.Mutable member : members) {
      if (member.getPhoneNumber().equals(phoneNumber)) {
        return false;
      }
    }
    return true;
  }
}
