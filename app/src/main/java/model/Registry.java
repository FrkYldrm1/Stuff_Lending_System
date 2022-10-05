package model;

import java.util.ArrayList;

import view.ConsoleUI2;

public class Registry {
  private ArrayList<Member> members;
  private ConsoleUI2 ui = new ConsoleUI2();
  

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


  public Member addMember(String firstName, String lastName, String email, String phoneNumber) {
    Member x = new Member(firstName, lastName, email, phoneNumber);
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

}
