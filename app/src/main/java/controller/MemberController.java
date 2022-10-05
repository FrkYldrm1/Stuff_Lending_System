package controller;

import model.Member;
import model.Registry;
import view.ConsoleUI;

// represents the controller controlling the members
public class MemberController {
  view.ConsoleUI console;
  model.Registry registry;

  public MemberController(ConsoleUI console, Registry registry) {
    this.console = console;
    this.registry = registry;
  }

  public void createNewMember() {
    model.Member newMember = console.createMember();
    registry.addMember(newMember);
  }

  public void showAllMembers() {
    for (Member.Mutable member : registry.getMembers()) {
      console.showMemberDetails(member);
    }
  }
}
