package view;

import java.util.Scanner;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

public class SwedishUI implements Language {

    Scanner input;
    private String in;

    /**
     * Constructor for consoleUI class.
     *
     * @param input Scanner input.
     */
    @SuppressFBWarnings(value = "EI_EXPOSE_REP", justification = "We need to have scanner")
    public SwedishUI(Scanner input) {
        this.input = input;
    }

    /**
     * Method for main menu ui.
     */
    public EnumChoices mainMenu() {
        System.out.println("|-------------------------------------------------------|");
        System.out.println("| Välkommen till vår fantastiska låneansökan!           |");
        System.out.println("| Vänligen följ instruktionerna nedan!                  |");
        System.out.println("| Välj ett nummer och klicka sedan på enter             |");
        System.out.println("|-------------------------------------------------------|");
        System.out.println("|1) För att hantera information om medlem               |");
        System.out.println("|2) För att hantera information om objekt               |");
        System.out.println("|3) Förskottstid                                        |");
        System.out.println("|4) Sluta                                               |");
        System.out.println("|-------------------------------------------------------|");

        in = input.next();
        switch (in) {
            case ("1"):
                return EnumChoices.MEMBER_MENU;
            case ("2"):
                return EnumChoices.ITEM_MENU;
            case ("3"):
                return EnumChoices.CHANGE_DAY;
            case ("4"):
                return EnumChoices.EXIT;
            default:
                return mainMenu();
        }
    }

    /**
     * Method for the member menu UI.
     */
    public MemberEnum memberMenu() {
        System.out.println("|-------------------------------------------------------|");
        System.out.println("|1) Skapa en ny medlem                                  |");
        System.out.println("|2) Slå upp en specifik medlems information             |");
        System.out.println("|3) Visa en enkel översikt över alla medlemmar          |");
        System.out.println("|4) Visa en detaljerad översikt över alla medlemmar     |");
        System.out.println("|5) Redigera en medlem                                  |");
        System.out.println("|6) Ta bort en medlem                                   |");
        System.out.println("|7) Skapa ett kontrakt                                  |");
        System.out.println("|8) Tillbaka till meny                                  |");
        System.out.println("|-------------------------------------------------------|");

        in = input.next();
        switch (in) {
            case ("1"):
                return MemberEnum.CREATEMEMBER;
            case ("2"):
                return MemberEnum.SPECIFICMEMBER;
            case ("3"):
                return MemberEnum.SHOWSIMPLE;
            case ("4"):
                return MemberEnum.SHOWDETAILED;
            case ("5"):
                return MemberEnum.EDITMEMBER;
            case ("6"):
                return MemberEnum.DELETEMEMBER;
            case ("7"):
                return MemberEnum.CREATECONTRACT;
            case ("8"):
                return MemberEnum.BACKMENU;
            default:
                return memberMenu();
        }
    }

    /**
     * Method for the item menu UI.
     */
    public ItemEnum itemMenu() {
        System.out.println("|-------------------------------------------------------|");
        System.out.println("|1) Skapa objekt                                        |");
        System.out.println("|2) Visa ett objek                                      |");
        System.out.println("|3) Redigera ett objekt                                 |");
        System.out.println("|4) Ta bort ett objekt                                  |");
        System.out.println("|5) Tillbaka till meny                                  |");
        System.out.println("|-------------------------------------------------------|");

        in = input.next();
        switch (in) {
            case ("1"):
                return ItemEnum.CREATEITEM;
            case ("2"):
                return ItemEnum.VIEWITEM;
            case ("3"):
                return ItemEnum.EDITITEM;
            case ("4"):
                return ItemEnum.DELETEITEM;
            case ("5"):
                return ItemEnum.BACK;
            default:
                return itemMenu();
        }
    }

    /**
     * Method for the closing menu UI.
     */
    public void byeBye() {
        System.out.println("|-------------------------------------------------------|");
        System.out.println("|           Det var kul så länge det varade             |");
        System.out.println("|                Hoppas du hade roligt                  |");
        System.out.println("|                      Bye bye                          |");
        System.out.println("|-------------------------------------------------------|");
        System.exit(0);
    }

    /**
     * Asks for first name input to validate.
     *
     * @return first name to be validated.
     */
    public String getFirstName() {
        System.out.print("Ange den nya medlemmens förnamn: ");
        return input.nextLine();
    }

    /**
     * Trigers when user inputs a space or two for first name.
     *
     * @return first name again to be validated.
     */
    public String newFirstName() {
        System.out.print("Namn måste fyllas i. Vänligen ange förnamn: ");
        return input.nextLine();
    }

    /**
     * Asks for last name input to validate.
     *
     * @return last name to be validated.
     */
    public String getLastName() {
        System.out.print("Ange nya medlemmars efternamn: ");
        return input.nextLine();
    }

    /**
     * Trigers when user inputs a space or two for last name.
     *
     * @return last name again to be validated.
     */
    public String newLastName() {
        System.out.print("Namn måste fyllas i. Vänligen ange efternamn: ");
        return input.nextLine();
    }

    /**
     * Asks for phone number.
     *
     * @return phonenumber to be validated.
     */
    public String getPhoneNumber() {
        System.out.print("Enter new member's phone number: ");
        return input.nextLine();
    }

    /**
     * Triggers if empty string is input to phone number.
     *
     * @return phone number string.
     */
    public String newPhoneNumber() {
        System.out.print("Telefonnummer måste fyllas i. Vänligen ange telefonnummer: ");
        return input.nextLine();
    }

    /**
     * Triggers if phone number has a duplicate. Asks the user for another phone
     * number.
     *
     * @return phone number as a strign.
     */
    public String uniquePhoneNumber() {
        System.out.print("Telefonnummer tas. Vänligen ange ett nytt telefonnummer: ");
        return input.nextLine();
    }

    /**
     * Method for getting index.
     *
     * @return String.
     */
    public String selectedMember() {
        System.out.print("Välj medlem att redigera (Inmatningsnummer): ");
        return input.nextLine();
    }

    /**
     * Method for getting input.
     *
     * @return returns input.
     */
    public String selectMemberDelete() {
        System.out.print("Välj medlem att radera (Inmatningsnummer): ");
        return input.nextLine();
    }

    /**
     * Asks for email.
     *
     * @return email to be validated.
     */
    public String getEmail() {
        System.out.print("Ange nya medlemmars e-postadress: ");
        return input.nextLine();
    }

    /**
     * Triggers if empty string is input to email.
     *
     * @return email string.
     */
    public String newEmail() {
        System.out.print("E-post måste fyllas i. Vänligen ange e-post: ");
        return input.nextLine();
    }

    /**
     * Triggers if email has a duplicate. Asks the user for another email.
     *
     * @return email as a strign.
     */
    public String uniqueEmail() {
        System.out.print("E-post tas. Vänligen ange en ny e-postadress: ");
        return input.nextLine();
    }

    /**
     * Prints details of member.
     *
     * @param index To add index.
     */
    public void showMemberDetailsSimple(String firstName, String email, String lastName, String memberId,
            int currentCredit, int ownedItem, int time, int index) {
        String toPrint = String.format(
                "%s    %s  Nuvarande dag: %s    %s, %s\t%s\tAktuella krediter: %s\tAntal ägda föremål: %s", index,
                memberId, time + 1, firstName, lastName, email, currentCredit, ownedItem);
        System.out.println(toPrint);
    }

    /**
     * Here we show items details.
     */
    public void showItemDetails(String itemName, String itemDesc, int itemCost, String category, int dayOfCreation,
            int index) {
        String toPrint = String.format("%s    %s    %s    %s    %s     Dag för föremål: %s",
                index, itemName, itemCost, itemDesc, category, dayOfCreation);
        System.out.println(toPrint);
    }

    /**
     * Method for getting id input.
     *
     * @return String.
     */
    public String idInput() {
        System.out.print("Välj en medlem med position i listan (Ange ett nummer): ");
        return input.nextLine();
    }

    /**
     * Asks the user for a member's position in arraylist.
     *
     * @return int.
     */
    public String indexMemberInput() {
        System.out.print("Välj en medlem (Ange ett nummer): ");
        return input.nextLine();
    }

    public int indexItemInput() {
        System.out.print("Välj ett objekt med hjälp av position i listan: ");
        return input.nextInt();
    }

    /**
     * Validates index input.
     *
     * @return int
     */
    public int indexMemberInputRetry() {
        System.out.print("Inte en giltig position. Var god försök igen: ");
        return input.nextInt();
    }

    public int indexItemInputRetry() {
        System.out.print("Inte en giltig position. Var god försök igen: ");
        return input.nextInt();
    }

    public String newItemName() {
        System.out.print("Ange objektets namn:");
        return input.next();
    }

    public String newItemShortDescription() {
        System.out.print("Ange artikelbeskrivning: ");
        return input.next();
    }

    public int newItemCostPerDay() {
        System.out.print("Ange artikelkostnad:");
        return input.nextInt();
    }

    /**
     * Prints details of member.
     */
    public void showMemberDetails2(String firstName, String lastName, String email) {
        String toPrint = "\n" + "Medlemmarnas namn: " + firstName + " " + lastName + " E-post: " + email;
        System.out.println(toPrint);
    }

    /**
     * Prints details of member.
     */
    public void showMemberDetails3(String firstName, String email, String id) {
        String toPrint = "\n" + "Medlemmarnas namn: " + firstName + " E-post: " + email
                + " Medlems-id: " + id;
        System.out.println(toPrint);

    }

    /**
     * Prints empty string. Used to make interface look nicer with some line breaks.
     */
    public void lineBreak() {
        System.out.println("");
    }

    /**
     * Setter method for input.
     *
     * @param input input.
     */
    @SuppressFBWarnings(value = "EI_EXPOSE_REP", justification = "We need set inout method for scanner")
    public void setInput(Scanner input) {
        this.input = input;
    }

    public void notEnoughCredit() {
        String toPrint = "Inte tillräckligt med krediter";
        System.out.println(toPrint);
    }

    public void alreadyLended() {
        System.out.println("Varan är redan utlånad!");
    }

    public int selectMember() {
        System.out.print("Välj ägare (Ange ett nummer): ");
        return input.nextInt();
    }

    public int selectLender() {
        System.out.print("Välj medlem att låna ut till (Ange ett nummer): ");
        return input.nextInt();
    }

    public int selectPeriod() {
        System.out.print("Hur länge vill du låna ut objektet (Ange ett nummer): ");
        return input.nextInt();
    }

    public int selectItem() {
        System.out.print("Välj objekt du vill låna ut (Ange ett nummer): ");
        return input.nextInt();
    }

    public void messageForLending(String mem, String lend, int period) {
        System.out.println("Kontrakt har skapats " + mem + " har lånat ut till " + lend + " för " + period + " dags");
    }

    /**
     * Message for advancig the day.
     */
    public void advanceDayMessage() {
        System.out.println("Tiden har flyttats fram med en dag;)");
    }

    /**
     * Ui for selecting the category.
     *
     * @return input.
     */
    public CategoryEnum selectCategory() {
        lineBreak();
        System.out.println("Vänligen ange lämplig kategori för objektet med hjälp av listan nedan");
        System.out.println("1. Verktyg\n2. Fordon\n3. Spel\n4. Leksak\n5. Sport\n6. Övrig");
        System.out.print("Ange den kategori som passar varan bäst: ");
        in = input.next();
        switch (in) {
            case ("1"):
                return CategoryEnum.TOOL;
            case ("2"):
                return CategoryEnum.VEHICLE;
            case ("3"):
                return CategoryEnum.GAME;
            case ("4"):
                return CategoryEnum.TOY;
            case ("5"):
                return CategoryEnum.SPORT;
            case ("6"):
                return CategoryEnum.OTHER;
            default:
                return selectCategory();
        }
    }

    /**
     * Asks user for item name.
     *
     * @return item name as a string.
     */
    public String createItemName() {
        System.out.print("Ange objektets namn som en String: ");
        return input.nextLine();
    }

    /**
     * Asks user to reenter item name.
     *
     * @return item name as a string.
     */
    public String createItemName2() {
        System.out.print("Ogiltigt namn, ange igen:");
        return input.nextLine();
    }

    /**
     * Asks user to enter item description.
     *
     * @return description string.
     */
    public String createItemDescription() {
        System.out.print("Ange beskrivning för artikeln: ");
        return input.nextLine();
    }

    /**
     * Asks user to enter description again.
     *
     * @return description string.
     */
    public String createItemDescription2() {
        System.out.print("Ogiltig beskrivning, ange igen: ");
        return input.nextLine();
    }

    /**
     * Asks user to enter price.
     *
     * @return price int.
     */
    public String createItemPrice() {
        System.out.print("Ange artikelpris per dag:");
        return input.nextLine();
    }

    /**
     * Asks user to reenter price.
     *
     * @return price int.
     */
    public String createItemPrice2() {
        System.out.print("Ogiltigt pris, ange igen:");
        return input.nextLine();
    }

    /**
     * Prints member in a simple way to then look at their details.
     *
     * @param index     index.
     * @param firstName member's first name.
     * @param lastName  member's last name.
     */
    public void showMemberSpceific(int index, String firstName, String lastName) {
        System.out.println(index + "\t" + firstName + " " + lastName);
    }

    /**
     * Checks if input is null.
     *
     * @param input any string.
     *
     * @return true if null and false if not.
     */
    public boolean check(String input) {
        if (input.equals("") || input.equals(" ") || input == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void showOwnedItemIntro() {
        System.out.println("Mga ari-arian: ");
    }

    @Override
    public void showLendedItemIntro() {
        System.out.println("Mga hiniram na bagay: ");
    }

    @Override
    public void showItemDetails2(int index, String itemName, String lendedTo, int contractPeriod) {
        System.out.println(index + ". " + itemName + " -> Lånat av: " + lendedTo + ", Avtalsperiod: " + contractPeriod);
    }

    @Override
    public void showItemDetails3(int index, String itemName, String owner, int contractPeriod) {
        System.out.println(index + ". " + itemName + " -> Ägare: " + owner + ", Avtalsperiod: " + contractPeriod);
    }

}