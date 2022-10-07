package model;

import java.util.ArrayList;

import controller.MemberController;
import view.ConsoleUI2;

public class Registry {

  controller.MemberController controller;

  // Sprivate ArrayList<Member> members;
  private ConsoleUI2 ui = new ConsoleUI2();

  private ArrayList<Member.Mutable> members;

  public Registry() {
    members = new ArrayList<>();

    // hard coded members
    addMember("Bruce", "Lee", "Bruce@gmail.com", "988");
    addMember("Maya", "Hee", "mayahaha@gmail.com", "9843");
    members.get(0).addItem("phone", "black", 45, 3, false, 3);

  }

  // returns iterable members
  public Iterable<Member.Mutable> getMembers() {
    return members;
  }



  // adds members without an id
  public Member addMember(String firstName, String lastName, String email, String phoneNumber) {
    Member.Mutable x = new Member.Mutable(firstName, lastName, email, phoneNumber);
    members.add(x);
    return x;
  }

  // adds members with id already
  public Member addMember(Member mem) {
    Member.Mutable x = new Member.Mutable(mem.getFirstName(), mem.getLastName(), mem.getEmail(), mem.getPhoneNumber(),
        mem.getMemberId());
    members.add(x);
    return x;
  }

  // Used for getting a spesific member. But it is not working functionally. But for testing we used a members as a return.
  public Member getMember (String memberId) {
    for (Member member : members) {
      if(member.getMemberId().getId() == memberId) {
        return member;
      }
    }
    return members.get(0);
  }

  public void removeMember(Member s) {
    members.remove(s);
  }

  private void notifyMembersTime(int time) {
    for (Member s : members) {
      s.TimeAdvanced(time);
      s.updateItems();
    }

  }

  public void ListMembers() {
    for (Member member : members) {
      System.out.println(member.getMemberId() + " " + member.getFirstName() + " " + member.getLastName()
          + " " + member.getEmail() + " " + member.getPhoneNumber());
    }
  }
}
