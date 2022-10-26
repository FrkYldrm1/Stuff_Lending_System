package controller;

import java.util.Scanner;
import model.domain.Registry;

/**
 * The app class for running the program.
 */
public class App {

  /**
   * The main method.
   */
  public static void main(String[] args) {
    Registry registry = new Registry();
    view.ConsoleUi console = new view.ConsoleUi(new Scanner(System.in, "UTF-8"));
    controller.Controller hehe = new Controller(console, registry);
    hehe.startApp();
  }
}