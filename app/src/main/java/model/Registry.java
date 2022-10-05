package model;

import java.util.ArrayList;

import view.ConsoleUI2;

public class Registry {
  private ArrayList<Member> members;
  private ConsoleUI2 ui = new ConsoleUI2();

  private ArrayList<Member.Mutable> member;

  public Registry() {
    members = new ArrayList<>();

    // hard coded members
    addMember("Bruce", "Lee", "Bruce@gmail.com", "988");
    addMember("Maya", "Hee", "mayahaha@gmail.com", "9843");
    for (Member member : members) {
      String name = member.getFirstName();
      System.out.println(name);
    }
  }

  // returns iterable members
  public Iterable<Member.Mutable> getMembers() {
    return member;
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
    ui.MemberAddedMessage(x);
    return x;
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
      System.out.println(member.getMemberId() + " " + member.getFirstName() +" " + member.getLastName()
      + " " + member.getEmail() + " " + member.getPhoneNumber() );
    }
  }



}
