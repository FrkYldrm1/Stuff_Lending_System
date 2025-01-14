# A2

Project for Assignment 2

A project template based on gradle and a gitlab pipeline. You should always build and run the application using gradle regularly.
Ahmad Zeeb
Faruk Yildirim
Philip Olsson

[design.md](design.md) contains the prescribed architectural design of the application.
## Stuff lending system:
As a group we are assigned to do a stuff lending system. The system starts with main menu where user is asked to choose one of four options.

We split our UI to two, the first will send you to a menu that deals with member that. That way it will be easier to navigate the UI and make it more user-friendly.
***

```
|-------------------------------------------------------|
| Welcome to our amazing lending application!           |
| Kindly follow the instructions below!                 |
| Choose a numbers and then click enter                 |
|-------------------------------------------------------|
|1) To deal with information about member               |
|2) To deal with information about item                 |
|3) Advance time                                        |
|4) Quit                                                |
|-------------------------------------------------------|
```
***
When user choose the first option the member menu will be available.
***

```
|-------------------------------------------------------|
|1) Create a new member                                 |
|2) Look up a specific member`s information             |
|3) Show a simple over view of all members              |
|4) Show a detailed over view of all members            |
|5) Edit a member                                       |
|6) Delete a member                                     |
|7) Create a contract                                   |
|8) Back to menu                                        |
|-------------------------------------------------------|
```


In the user menu user will have 8 options. User can create a member or look a specific member's information. When user select the second option user will be able to
access a specific member's information.
In the third option user can have simple overview of all members. If user selects the fourth option user will be able to see detailed information of all members. In member menu user can edit a member, delete a member or create a contract. Once contract is made it will be dependent on time once contract period is done the item will be updated both in owner and lender. We kept items in the lendings list even if the contract period is done, so we can keep track of history but once contract is done item will be updated as no lender and in the item description we will be able to see that contract is done. If user selects option eight user will be back on the main menu. In the main menu user can select item menu when user select the item menu user will be faced the following menu.


```
|-------------------------------------------------------|
|1) Create item                                         |
|2) View an item                                        |
|3) Edit an item                                        |
|4) Delete an item                                      |
|5) Back to menu                                        |
|-------------------------------------------------------|
```

Here user will be able to create , view, edit or delete an item. When user selects the fifth option user will be able to go back main menu. From main menu user can advance the time. When user advances the time will be advanced one day for the all members and items.





## Building
The build must pass by running console command:  
`./gradlew build`  
Note that you should get a report over the quality like:
```
CodeQualityTests > codeQuality() STANDARD_OUT
    0 CheckStyle Issues in C:/Users/ahmed/OneDrive/Skrivbord/oo/a2/app/src/main/java/controller/App.java
    0 CheckStyle Issues in C:/Users/ahmed/OneDrive/Skrivbord/oo/a2/app/src/main/java/controller/Controller.java
    0 CheckStyle Issues in C:/Users/ahmed/OneDrive/Skrivbord/oo/a2/app/src/main/java/controller/MemberController.java
    0 CheckStyle Issues in C:/Users/ahmed/OneDrive/Skrivbord/oo/a2/app/src/main/java/model/domain/Contract.java
    0 CheckStyle Issues in C:/Users/ahmed/OneDrive/Skrivbord/oo/a2/app/src/main/java/model/domain/Item.java
    0 CheckStyle Issues in C:/Users/ahmed/OneDrive/Skrivbord/oo/a2/app/src/main/java/model/domain/Member.java
    0 CheckStyle Issues in C:/Users/ahmed/OneDrive/Skrivbord/oo/a2/app/src/main/java/model/domain/MemberId.java
    0 CheckStyle Issues in C:/Users/ahmed/OneDrive/Skrivbord/oo/a2/app/src/main/java/model/domain/Registry.java
    0 CheckStyle Issues in C:/Users/ahmed/OneDrive/Skrivbord/oo/a2/app/src/main/java/model/domain/Time.java
    0 CheckStyle Issues in C:/Users/ahmed/OneDrive/Skrivbord/oo/a2/app/src/main/java/model/domain/TimeAdvancedObserver.java
    0 CheckStyle Issues in C:/Users/ahmed/OneDrive/Skrivbord/oo/a2/app/src/main/java/model/persistence/Imapper.java
    0 CheckStyle Issues in C:/Users/ahmed/OneDrive/Skrivbord/oo/a2/app/src/main/java/model/persistence/Persistence.java
    0 CheckStyle Issues in C:/Users/ahmed/OneDrive/Skrivbord/oo/a2/app/src/main/java/model/persistence/SqlMapper.java
    0 CheckStyle Issues in C:/Users/ahmed/OneDrive/Skrivbord/oo/a2/app/src/main/java/view/CategoryEnum.java
    0 CheckStyle Issues in C:/Users/ahmed/OneDrive/Skrivbord/oo/a2/app/src/main/java/view/ConsoleUi.java
    0 CheckStyle Issues in C:/Users/ahmed/OneDrive/Skrivbord/oo/a2/app/src/main/java/view/EnumChoices.java
    0 CheckStyle Issues in C:/Users/ahmed/OneDrive/Skrivbord/oo/a2/app/src/main/java/view/ItemEnum.java
    0 CheckStyle Issues in C:/Users/ahmed/OneDrive/Skrivbord/oo/a2/app/src/main/java/view/Language.java
    0 CheckStyle Issues in C:/Users/ahmed/OneDrive/Skrivbord/oo/a2/app/src/main/java/view/MemberEnum.java
    0 CheckStyle Issues in C:/Users/ahmed/OneDrive/Skrivbord/oo/a2/app/src/main/java/view/SwedishUi.java

CodeQualityTests > codeQuality() STANDARD_ERROR
    Findbugs xml file not found: .\build\reports\spotbugs\spotbugs.xml
    Consider making code change to initiate regeneration of the xml (will try backup)
    Restored xml from backup: .\build\reports\spotbugs\spotbugs_bak.xml

CodeQualityTests > codeQuality() STANDARD_OUT
    0 FindBugs Issues in model/domain/Item.java
    0 FindBugs Issues in model/domain/MemberId.java
    0 FindBugs Issues in view/EnumChoices.java
    1 FindBugs Issues in view/ConsoleUi.java
    text:lines: 24-616
    byeBye() invokes System.exit(...), which shuts down the entire virtual machine
    Method invokes System.exit(...)
    Invoking System.exit shuts down the entire Java virtual machine. This should only been done when it
      is appropriate. Such calls make it hard or impossible for your code to be invoked by other code.
      Consider throwing a RuntimeException instead.

    0 FindBugs Issues in view/CategoryEnum.java
    0 FindBugs Issues in controller/Controller.java
    0 FindBugs Issues in model/domain/TimeAdvancedObserver.java
    0 FindBugs Issues in view/Language.java
    0 FindBugs Issues in view/MemberEnum.java
    1 FindBugs Issues in view/SwedishUi.java
    text:lines: 25-617
    byeBye() invokes System.exit(...), which shuts down the entire virtual machine
    Method invokes System.exit(...)
    Invoking System.exit shuts down the entire Java virtual machine. This should only been done when it
      is appropriate. Such calls make it hard or impossible for your code to be invoked by other code.
      Consider throwing a RuntimeException instead.

    0 FindBugs Issues in controller/MemberController.java
    1 FindBugs Issues in model/domain/Registry.java
    text:lines: 19-260
    setMembers(ArrayList) may expose internal representation by storing an externally mutable object
      into Registry.members
    May expose internal representation by incorporating reference to mutable object
    This code stores a reference to an externally mutable object into the internal representation of the
      object. If instances are accessed by untrusted code, and unchecked changes to the mutable object
      would compromise security or other important properties, you will need to do something different.
      Storing a copy of the object is better approach in many situations.

    0 FindBugs Issues in controller/App.java
    0 FindBugs Issues in model/domain/Contract.java
    0 FindBugs Issues in model/domain/Member.java
    0 FindBugs Issues in model/domain/Time.java
    0 FindBugs Issues in model/persistence/Imapper.java
    0 FindBugs Issues in model/persistence/SqlMapper.java
    0 FindBugs Issues in view/ItemEnum.java
    0 FindBugs Issues in model/persistence/Persistence.java

```

## Running
The application should start by running console command:  
`./gradlew run -q --console=plain`
```
|-------------------------------------------------------|
| Welcome to our amazing lending application!           |
| Kindly follow the instructions below!                 |
| Choose a numbers and then click enter                 |
|-------------------------------------------------------|
|1) To deal with information about member               |
|2) To deal with information about item                 |
|3) Advance time                                        |
|4) Quit                                                |
|-------------------------------------------------------|
```
# Updates and fixes

## Added a new language
As asked we added a new language (Swedish) now the program can be run with both languages. In controller you will find int languageBinary = 1; just change to 0 if you want to use 
Swedish. The swedish Ui has a different order and uses strings for index instead of int.

## Model responsibility in view/controller

Doing this assignment for the first time was time-consuming and stressful which led us to miss few things in our code
one of these things was responsibilities that we did not approach accurately. For this part of the fix we looked at the 
responsibilities that should be in model instead of view or controller, and we found out some things that we could change
for example email and phone validation should be in model instead of controller.

## Hidden dependencies

This part of the fix was the most time-consuming as it changed a lot in our code. First we found out that there was some 
objects getting created in the wrong place we fixed that by moving the objects to the controller where we think it belongs,
the second problem was that we used strings instead of enumeration and this fix took the most time. enumeration was not easy
to apply especially after coding everything, we changed all the inputs from strings to enumeration so when we want to navigate
between the menus we do so by using enumeration. 

## Diagrams 

We knew that our diagrams were not that good as we did not have much time to focus on them, but we changed the class, sequence and objects
diagrams. We updated and improved the dependencies and the notations, and we made to sure that the diagrams correspond to the implementation
of course with our understanding of uml.  
 

