# A2

Project for Assignment 2

A project template based on gradle and a gitlab pipeline. You should always build and run the application using gradle regularely.

[design.md](design.md) contains the prescribed architectural design of the application.
## Stuff lending system:
As a group we are assigned to do a stuff lending system. The system starts with main menu where user is asked to choose one of four options.

We split our UI to two, the first will send you to a menu that deals with member that. That way it will be easier to navigate the UI and make it more user friendly.
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


In the user menu user will have 8 options. User can create a member or look a specific members information. When user select the second option user will be able to
access a dpesific members information.
In in the third option user can have simple over view of all mebers. If user slects the fourth option user will be able to see detailed information of all members. In member menu user can edit a member, delete a member or create a contract. Once contract is made it will be dependent on time once contract period is done the item will be updated both in owner and lender. We kept items in the lendings list even if the contract period is done so we can kepp track of history but once contract is done item will be updated as no lender and in the item description we will be able to see that contract is done. If user selects option eight user will be back on the main menu. In the main menu user can slect item menu when user select the item menu user will be faced the following menu.


```
|-------------------------------------------------------|
|1) Create item                                         |
|2) View an item                                        |
|3) Edit an item                                        |
|4) Delete an item                                      |
|5) Back to menu                                        |
|-------------------------------------------------------|
```

Here user will be able to create , view, edit or delete an item. When user selects the fifth option user will be able to go back main menu. From main menu user can advance the time. When user advances the time the time will be advanced one day for the all members and items.





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
    0 CheckStyle Issues in C:/Users/ahmed/OneDrive/Skrivbord/oo/a2/app/src/main/java/model/persistence/Imapper.java
    0 CheckStyle Issues in C:/Users/ahmed/OneDrive/Skrivbord/oo/a2/app/src/main/java/model/persistence/Persistence.java
    0 CheckStyle Issues in C:/Users/ahmed/OneDrive/Skrivbord/oo/a2/app/src/main/java/model/persistence/SqlMapper.java
    0 CheckStyle Issues in C:/Users/ahmed/OneDrive/Skrivbord/oo/a2/app/src/main/java/model/TimeAdvancedObserver.java
    0 CheckStyle Issues in C:/Users/ahmed/OneDrive/Skrivbord/oo/a2/app/src/main/java/view/ConsoleUi.java
    2 FindBugs Issues in model/domain/Item.java
    text:lines: 19-251
    new model.domain.Item(String, String, int, int, Boolean, int, String, String, String) uses the same
      code for two branches
    Method uses the same code for two branches
    This method uses the same code to implement two branches of a conditional branch. Check to ensure
      that this isn't a coding mistake.

    text:lines: 19-251
    Call to equals(null) in new model.domain.Item(String, String, int, int, Boolean, int, String,
      String, String)
    Call to equals(null)
    This method calls equals(Object), passing a null value as the argument. According to the contract of
      the equals() method, this call should always return false.

    0 FindBugs Issues in model/domain/MemberId.java
    1 FindBugs Issues in view/ConsoleUi.java
    text:lines: 21-507
    byeBye() invokes System.exit(...), which shuts down the entire virtual machine
    Method invokes System.exit(...)
    Invoking System.exit shuts down the entire Java virtual machine. This should only been done when it
      is appropriate. Such calls make it hard or impossible for your code to be invoked by other code.
      Consider throwing a RuntimeException instead.

    0 FindBugs Issues in controller/Controller.java
    1 FindBugs Issues in controller/MemberController.java
    text:lines: 18-341
    Nullcheck of input at line 208 of value previously dereferenced in check(String)
    Nullcheck of value previously dereferenced
    A value is checked here to see whether it is null, but this value cannot be null because it was
      previously dereferenced and if it were null a null pointer exception would have occurred at the
      earlier dereference. Essentially, this code and the previous dereference disagree as to whether
      this value is allowed to be null. Either the check is redundant or the previous dereference is
      erroneous.

    0 FindBugs Issues in model/domain/Registry.java
    0 FindBugs Issues in controller/App.java
    0 FindBugs Issues in model/domain/Contract.java
    0 FindBugs Issues in model/domain/Member.java
    0 FindBugs Issues in model/domain/Time.java
    0 FindBugs Issues in model/persistence/Imapper.java
    0 FindBugs Issues in model/TimeAdvancedObserver.java
    0 FindBugs Issues in model/persistence/SqlMapper.java
    0 FindBugs Issues in model/persistence/Persistence.java
```

Removing or manipulating the code quality checks results in an immediate assignment **Fail**.

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

## Adding Your Own Code
The `Simple` classes project should likely be removed do not forget to also remove the test case associated to `model.Simple`.

Add your own code to the packages respectively and feel free to add automatic test cases for your own code. A good process is to design a little - code a little - test a little one feature at a time and then iterate.

## Versioning

Adhere to the git versioning instructions according to the assignment.

## System test
Adhere to the instructions according to the assigment.

## Handing In
Adhere to the instructions according to the assigment.