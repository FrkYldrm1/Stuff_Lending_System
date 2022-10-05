package model;

import java.util.ArrayList;

public class Registry {
  private ArrayList<Member> members;
  

  public Registry() {
    members = new ArrayList<>();

    // hard coded members
    addMember("Bruce", "Lee", "Bruce@gmail.com", "988");
    addMember("Maya", "Hee", "mayahaha@gmail.com", "9843");
  }


  public Member addMember(String firstName, String lastName, String email, String phoneNumber) {
    Member x = new Member(firstName, lastName, email, phoneNumber);
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
