package controller;

import java.util.Scanner;
import model.domain.Registry;
import view.ConsoleUi;
import view.InterfaceView;

/**
 * The app class for running the program.
 */
public class App {

  /**
   * The main method.
   */
  public static void main(String[] args) {
    Registry registry = new Registry();
    InterfaceView inter = new ConsoleUi(new Scanner(System.in, "UTF-8"));
    view.ConsoleUi console = new view.ConsoleUi(new Scanner(System.in, "UTF-8"));
    controller.Controller hehe = new Controller(console, registry, inter);
    hehe.startGame();

  }
}