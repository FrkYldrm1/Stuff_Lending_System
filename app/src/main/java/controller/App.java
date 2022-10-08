package controller;

import java.util.Scanner;
import model.Registry;

/**
 * The app class for running the program.
 */
public class App {

  /**
   * The main method.
   */
  public static void main(String[] args) {
    model.Registry registry = new Registry();

    // below is used to test member creation and printing
    view.ConsoleUi console = new view.ConsoleUi(new Scanner(System.in, "UTF8"));
    controller.MemberController mmc = new MemberController(console, registry);

    // mmc.createNewMember();
    mmc.showAllMembers();
    mmc.changeDay();
    mmc.showAllMembers();
    // mmc.addItem();
    mmc.showOwnedItems();

  }
}
