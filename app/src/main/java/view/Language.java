package view;

import java.util.zip.ZipEntry;

public interface Language {
    public EnumChoices mainMenu();

    public MemberEnum memberMenu();

    public ItemEnum itemMenu();

    public void byeBye();

    public String getFirstName();

    public String newFirstName();

    public String getLastName();

    public String newLastName();

    public String getPhoneNumber();

    public String newPhoneNumber();

    public String uniquePhoneNumber();

    public String selectedMember();
    
    public String selectMemberDelete();

    public String getEmail();

    public String newEmail();

    public String uniqueEmail();

    public void showMemberDetailsSimple(String firstName, String email, String lastName, String memberId,
      int currentCredit, int ownedItem, int time, int index);

    public void showItemDetails(String itemName, String itemDesc, int itemCost, String category, int dayOfCreation,
      int index);   

    public String idInput();
    
    public int indexMemberInput();

    public int indexItemInput();
    
    public int indexMemberInputRetry();

    public int indexItemInputRetry();

    public String newItemName();

    public String newItemShortDescription();

    public int newItemCostPerDay();

    public void showMemberDetails2(String firstName, String lastName, String email, String ownedItem,
      String lendedItemString);

    public void showMemberDetails3(String firstName, String email, String id, String ownedItems);

    public void lineBreak();






    
}
