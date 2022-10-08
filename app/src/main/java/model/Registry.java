package model;

import java.util.ArrayList;

/**
 * Registry class for saving data.
 */
public class Registry {

  controller.MemberController controller;
  view.ConsoleUi console;
  private ArrayList<Member.Mutable> members;


  /**
   * Constructor.
   */
  public Registry() {
    members = new ArrayList<>();

    // hard coded members
    addMember("Bruce", "Lee", "Bruce@gmail.com", "988");
    addMember("Maya", "Hee", "mayahaha@gmail.com", "9843");
    //members.get(0).addItem("phone", "black", 45, 3, false, 3);
  }


  
  /**
   * Getter method for members.
   *
   * @return Iterable Mutable.
   */
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
      if (member.getMemberId().getId() == memberId) {
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
   *
   * @param time day that will be changed.
   */
  public void notifyMembersTime(int time) {
    for (Member s : members) {
      s.advanceTime(time);
      s.updateItems();
    }

  }

  /**
   * Listing the members.
   */
  public void listMembers() {
    for (Member member : members) {
      System.out.println(member.getMemberId() + " " + member.getFirstName() + " " + member.getLastName()
          + " " + member.getEmail() + " " + member.getPhoneNumber());
    }
  }

  /**
   * Method for listing a short overview of members.
   */
 public void listMemberSpecific() {
    for (Member member : members) {
      System.out.println(member.getMemberId() + " " + member.getFirstName() + " " + member.getLastName());
    }
 }
}
