package controller;

import model.Member;
import model.Registry;
import view.ConsoleUI;

// represents the controller controlling the members
public class MemberController {
  view.ConsoleUI console;
  model.Registry registry;
  view.ConsoleUI2 ui;
  model.Member member;


  public MemberController(ConsoleUI console, Registry registry) {
    this.console = console;
    this.registry = registry;
  }

  public void createNewMember() {
    model.Member newMember = console.createMember();
    registry.addMember(newMember);
    ui.MemberAddedMessage(newMember);

  }

  public void showAllMembers() {
    for (Member.Mutable member : registry.getMembers()) {
      console.showMemberDetails(member);
    }
  }

  public void deleteMember(model.Member member) {
    registry.removeMember(member);
    ui.MemberDeletedMessage(member);
  }
  public void addItem() {
    member.addPreparedItemOwned(ui.createItem());
  }

  public void deleteItemOwned(model.Item i) {
    member.removeItemOwned(i);
  }

  public void deleteItemLended(model.Item i) {
    member.removeItemLended(i);
  }

}
