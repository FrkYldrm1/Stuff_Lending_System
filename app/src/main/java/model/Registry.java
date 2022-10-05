package model;

import java.util.ArrayList;

public class Registry {
  private ArrayList<Member.Mutable> members;
  

  public Registry() {
    members = new ArrayList<>();

    // hard coded members
    addMember("Bruce", "Lee", "Bruce@gmail.com", "988");
    addMember("Maya", "Hee", "mayahaha@gmail.com", "9843");
  }


  public Member addMember(String firstName, String lastName, String email, String phoneNumber) {
    Member.Mutable x = new Member.Mutable(firstName, lastName, email, phoneNumber);
    members.add(x);
    return x;

  }

  public void removeMember(Member s) {
    members.remove(s);
  }

  private void notifyMembersTime(int time) {
    for (Member s : members) {
      s.TimeAdvanced(time);
    }
  }

}
