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
    view.ConsoleUi console = new view.ConsoleUi(new Scanner(System.in, "UTF8"));
    controller.Controller hehe = new Controller(console, registry);
    hehe.mainMenu();
  }
}
