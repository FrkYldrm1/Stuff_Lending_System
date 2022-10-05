package view;

import java.lang.reflect.Member;

import model.Item;
import java.util.Scanner;

public class ConsoleUI2 {

    Scanner input;

    public void ShowDeletedItemMessage(Item i) {
        System.out.println("Item " + i.getName() + "deleted.");
    }

    public void ShowItemUpdateMessage(Item i) {
        System.out.println("Item updated remaining contract day " + i.getContractPeriod());
    }

    public void MemberAddedMessage(model.Member x) {
        System.out.println("Member " + x.getFirstName() + " is created!");
    }

    public void MemberDeletedMessage(model.Member x) {
        System.out.println("Member " + x.getFirstName() + " is deleted!");
    }

    public model.Item createItem() {
        System.out.println("Enter item name: ");
        String itemName = input.nextLine();
        System.out.println("Enter item's short description: ");
        String descrioption = input.nextLine();
        System.out.println("Enter item's cost per day : ");
        int costPerDay = input.nextInt();
        System.out.println("Enter day of creation");
        int dayOfCreation = input.nextInt();

        return new model.Item(itemName, descrioption, costPerDay, dayOfCreation, false, 0);
    }

}
