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


}
