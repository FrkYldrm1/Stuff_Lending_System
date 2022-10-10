package controller;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.Scanner;
import model.domain.Registry;
import view.ConsoleUi;

/**
 * Contoroller class for UI.
 */
public class Controller {

  private String input;
  private Scanner scan = new Scanner(System.in, "UTF-8");
  private view.ConsoleUi console = new view.ConsoleUi(new Scanner(System.in, "UTF-8"));
  private Registry registry = new Registry();
  private controller.MemberController memberController = new controller.MemberController(console, registry);

  @SuppressFBWarnings(value = "EI_EXPOSE_REP", justification = "It is the constructor so we should have it.")
  public Controller(ConsoleUi console, Registry registry) {
    this.console = console;
    this.registry = registry;
  }

  /**
   * Method for printing main menu.
   */
  public void mainMenu() {
    console.mainMenu();
    input = scan.next();
    switch (input) {
      case ("1"):
        memMenu();
        break;
      case ("2"):
        itemMenu();
        break;
      case ("3"):
        memberController.changeDay();
        mainMenu();
        break;
      case ("4"):
        console.byeBye();
        break;
      default:
        mainMenu();
    }
  }

  /**
   * Method for printing member menu.
   */
  public void memMenu() {
    console.memberMenu();
    input = scan.next();
    switch (input) {
      case ("1"):
        memberController.createNewMember();
        memMenu();
        break;
      case ("2"):
        registry.listMemberSpecific();
        console.showMemberDetails3(registry.selectMember(console.indexMemberInput()));
        memMenu();
        break;
      case ("3"):
        memberController.showAllMembersSimple();
        memMenu();
        break;
      case ("4"):
        memberController.showAllMembers2();
        memMenu();
        break;
      case ("5"):
        memberController.showAllMembersSimple();
        memberController.editMember();
        memMenu();
        break;
      case ("6"):
        memberController.showAllMembersSimple();
        memberController.deleteMember();
        memMenu();
        break;
      case ("7"):
        memberController.contract();
        memMenu();
        break;
      case ("8"):
        mainMenu();
        break;
      default:
        memMenu();
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
        mainMenu();
        break;
      default:
        itemMenu();
    }
  }

}