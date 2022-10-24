package controller;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.Scanner;

import model.domain.Member;
import model.domain.Registry;
import view.ConsoleUi;
import view.EnumChoices;
import view.InterfaceView;

/**
 * Contoroller class for UI.
 */
public class Controller {

  private String input;
  private Scanner scan = new Scanner(System.in, "UTF-8");
  private view.ConsoleUi console = new view.ConsoleUi(new Scanner(System.in, "UTF-8"));
  private Registry registry = new Registry();
  private InterfaceView inter;
  private controller.MemberController memberController = new controller.MemberController(console, registry);

  @SuppressFBWarnings(value = "EI_EXPOSE_REP", justification = "It is the constructor so we should have it.")
  public Controller(ConsoleUi console, Registry registry, InterfaceView inter) {
    this.console = console;
    this.registry = registry;
    this.inter = inter;
  }

  public void startGame() {
    viewMenu();
  }

  public void viewMenu() {
    view.EnumChoices choice = console.mainMenu();

    switch (choice) {
      case MEMBER_MENU:
        viewMemberMenu();
        break;
      case ITEM_MENU:
        itemMenu();
        break;
      case CHANGE_DAY:
        memberController.changeDay();
        startGame();
        break;
      case EXIT:
        console.byeBye();
      default:
        viewMenu();
    }
  }

  public void viewMemberMenu() {
    view.MemberEnum choice = console.memberMenu();

    switch (choice) {
      case CREATEMEMBER:
        memberController.createNewMember();
        viewMemberMenu();
        break;
      case SPECIFICMEMBER:
        registry.listMemberSpecific();
        Member.Mutable member = registry.selectMember(console.indexMemberInput());
        console.showMemberDetails3(member.getFirstName(), member.getEmail(), member.getMemberId().getId(), member.getItemsOwnedString());
        viewMemberMenu();
        break;
      case SHOWSIMPLE:
        memberController.showAllMembersSimple();
        viewMemberMenu();
        break;
      case SHOWDETAILED:
        memberController.showAllMembers2();
        viewMemberMenu();
        break;
      case EDITMEMBER:
        memberController.showAllMembersSimple();
        memberController.editMember();
        viewMemberMenu();
        break;
      case DELETEMEMBER:
        memberController.showAllMembersSimple();
        memberController.deleteMember();
        viewMemberMenu();
        break;
      case CREATECONTRACT:
        memberController.contract();
        viewMemberMenu();
        break;
      case BACKMENU:
        startGame();
        break;
      default:
        viewMemberMenu();
    }
  }


  /**
   * Method for printing item menu.
   */
  public void itemMenu() {
    console.itemMenu();
    input = scan.next();
    switch (input) {
      case ("1"):
        memberController.showAllMembersSimple();
        memberController.addItem();
        itemMenu();
        break;
      case ("2"):
        memberController.showAllMembersSimple();
        memberController.showOwnedItems();
        itemMenu();
        break;
      case ("3"):
        memberController.showAllMembers2();
        memberController.editItem();
        itemMenu();
        break;
      case ("4"):
        memberController.showAllMembers2();
        memberController.deleteItemOwned();
        itemMenu();
        break;
      case ("5"):
        startGame();
        break;
      default:
        itemMenu();
    }
  }

}