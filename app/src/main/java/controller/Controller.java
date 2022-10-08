package controller;

import java.util.Scanner;
import model.Registry;
import view.ConsoleUi;

public class Controller {

  private String input;
  private Scanner scan = new Scanner(System.in);
  private view.ConsoleUi console = new view.ConsoleUi(new Scanner(System.in, "UTF8"));
  private model.Registry registry = new Registry();;
  private controller.MemberController memberController = new controller.MemberController(console, registry);


  public Controller(ConsoleUi console, Registry registry) {
    this.console = console;
    this.registry = registry;
  }


  public void mainMenu() {
    console.mainMenu();
    input = scan.next();
    switch (input){
    case ("1"):
      memMenu();
      break;
    case ("2"):
      itemMenu();
      break;
    case ("3"):
      console.byeBye();
    default:
      mainMenu();
    }
  }

  public void memMenu() {
    console.memberMenu();
    input = scan.next();
    switch (input) {
      case ("1"):
        memberController.createNewMember();
        memMenu();
        break;
      case ("2"):
        memMenu();
        break;
      case ("3"):
        memberController.showAllMembersSimple();
        memMenu();
        break;
      case ("4"):
        registry.listMemberSpecific();
        memMenu();
        break;
      case ("5"):
        memberController.showAllMembersSimple();
        memberController.editMember();
        memMenu();
        break;
      case ("6"):
        memMenu();
        break;
      case ("7"):
        mainMenu();
    }
  }

  public void itemMenu() {
    console.itemMenu();
    input = scan.next();
    switch (input) {
      case ("1"):
        memberController.showAllMembersSimple();
        memberController.addItem();
        break;
      case ("2"):
        memberController.showAllMembersSimple();
        memberController.showOwnedItems();
        break;
      case ("3"):
        itemMenu();
        break;
      case ("4"):
        itemMenu();
        break;
      case ("5"):
        mainMenu();
      default:
        itemMenu();
    }
  }

}
