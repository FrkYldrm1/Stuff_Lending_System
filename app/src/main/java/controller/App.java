package controller;

import java.util.Scanner;

import org.checkerframework.checker.guieffect.qual.UI;

import model.Registry;
import view.ConsoleUI2;

public class App {

	public static void main(String[] args) {
		model.Registry registry = new Registry();

		// below is used to test member creation and printing
		view.ConsoleUI console = new view.ConsoleUI(new Scanner(System.in, "UTF8"));
		controller.MemberController mmc = new MemberController(console, registry);
		//mmc.createNewMember();
		mmc.showAllMembers();
		//mmc.addItem();
		mmc.showOwnedItems();

	}
}
