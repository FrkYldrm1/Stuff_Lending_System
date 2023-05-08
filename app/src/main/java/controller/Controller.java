package controller;

import java.util.Scanner;
import view.Language;
import view.SwedishUi;

/**
 * Controller class for UI.
 */
public class Controller {

  int languageBinary = 0; // 1 for english, 0 for swedish;
  private Language console;
  private controller.MemberController memberController;

  /**
   * method for starting the program.
   */
  public void startApp() {
    init();
    viewMenu();
  }

  /**
   * method for initialising with language.
   */
  public void init() {
    if (languageBinary == 1) {
      console = new view.ConsoleUi(new Scanner(System.in, "UTF-8"));
    } else if (languageBinary == 0) {
      console = new SwedishUi(new Scanner(System.in, "UTF-8"));
    }
    memberController = new controller.MemberController(console);
  }

  /**
   * method for showing main menu.2
   */
  public void viewMenu() {
    view.EnumChoices choice = console.mainMenu();

    switch (choice) {
      case MEMBER_MENU:
        viewMemberMenu();
        break;
      case ITEM_MENU:
        viewItem();
        break;
      case CHANGE_DAY:
        memberController.changeDay();
        startApp();
        break;
      case EXIT:
        console.byeBye();
        break;
      default:
        viewMenu();
    }
  }

  /**
   * Method for showing member menu.
   */
  public void viewMemberMenu() {
    view.MemberEnum choice = console.memberMenu();

    switch (choice) {
      case CREATEMEMBER:
        memberController.createMember();
        viewMemberMenu();
        break;
      case SPECIFICMEMBER:
        memberController.printMemberSpecific();
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
        startApp();
        break;
      default:
        viewMemberMenu();
    }
  }

  /**
   * Method for printing item menu.
   **/
  public void viewItem() {
    view.ItemEnum choice = console.itemMenu();

    switch (choice) {
      case CREATEITEM:
        memberController.showAllMembersSimple();
        memberController.addItem();
        viewItem();
        break;
      case VIEWITEM:
        memberController.showAllMembersSimple();
        memberController.showOwnedItems();
        viewItem();
        break;
      case EDITITEM:
        memberController.showAllMembers2();
        memberController.editItem();
        viewItem();
        break;
      case DELETEITEM:
        memberController.showAllMembers2();
        memberController.deleteItemOwned();
        viewItem();
        break;
      case BACK:
        startApp();
        break;
      default:
        viewItem();
    }
  }
}