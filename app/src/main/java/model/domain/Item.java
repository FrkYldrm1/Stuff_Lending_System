package model.domain;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import view.CategoryEnum;

/**
 * Item class to create item objects.
 */
public class Item {
  private String name;
  private String shortDescription;
  private int costPerDay;
  private int dayOfCreation;
  private boolean isLended;
  private int contractPeriod;
  private String owner;
  private String lenededTo;
  private CategoryEnum category;

  /**
   * Constructor for the item.
   *
   * @param name             To initialize the name.
   * @param shortDescription To initialize the short description.
   * @param costPerDay       To initialize the cost per day.
   * @param dayOfCreation    To initialize day of creation.
   * @param isLended         To select if it is lended.
   * @param contractPeriod   To initialize the contract period,
   */
  @SuppressFBWarnings(value = "EI_EXPOSE_REP", justification = "It is the constructor so we should have it.")
  public Item(String name, String shortDescription, int costPerDay, int dayOfCreation,
      Boolean isLended, int contractPeriod, String owner, String lendedTo, CategoryEnum category) {
    if (name == null) {
      setNameProt("Unknown name!");
    } else {
      setNameProt(name);
    }
    if (shortDescription == null || shortDescription == "") {
      setShortDescriptionProt("No description!");
    } else {
      setShortDescriptionProt(shortDescription);
    }
    if (costPerDay < 0) {
      setCostPerDayProt(0);
    } else {
      setCostPerDayProt(costPerDay);
    }
    if (isLended == null) {
      setisLendedProt(false);
    } else {
      setisLendedProt(isLended);
    }
    if (contractPeriod < 0) {
      setContractPeriodProt(0);
    }
    if (owner == null || owner.equals("")) {
      this.owner = "No owner!";
    } else {
      this.owner = owner;
    }
    if (lendedTo == null || lendedTo.equals("")) {
      this.lenededTo = "No lender!";
    } else {
      this.lenededTo = lendedTo;
    }
    this.dayOfCreation = 1;
    this.category = category;
  }

  public Item() {

  }



  public String getOwner() {
    return owner;
  }

  /**
   * Setter method for owner.
   *
   * @param owner To initilize owner.
   */
  public void setOwner(String owner) {
    checkNull(owner, "Owner cannot be null!");
    this.owner = owner;
  }

  public boolean isLended() {
    return isLended;
  }

  /**
   * Setter method for the items lender.
   *
   * @param lenededTo To initilize attribute.
   */
  public void setLenededTo(String lenededTo) {
    checkNull(lenededTo, "Lender cannot be null!");
    this.lenededTo = lenededTo;
  }

  /**
   * Getter method for lender.
   *
   * @return String.
   */
  public String getLenededTo() {
    return lenededTo;
  }

  /**
   * Constructor.
   *
   * @param item item object.
   */
  public Item(Item item) {
    this.name = item.name;
    this.shortDescription = item.shortDescription;
    this.costPerDay = item.costPerDay;
    this.isLended = item.isLended;
    this.contractPeriod = item.contractPeriod;
  }

  /**
   * Setter for short description.
   *
   * @param newShortDescription SD set attriute.
   */
  protected void setShortDescriptionProt(String newShortDescription) {
    checkNull(newShortDescription, "Description cannot be null");
    shortDescription = newShortDescription;
  }

  /**
   * Setter method for is owned attribute.
   *
   * @param newisOwned Boolean.
   */
  protected void setisLendedProt(Boolean newisOwned) {
    isLended = newisOwned;
  }

  /**
   * Setter method for the name.
   *
   * @param newName string.
   */
  protected void setNameProt(String newName) {
    checkNull(newName, "First Name Cannot be null");
    name = newName;
  }

  /**
   * Setter method for day of creation.
   *
   * @param newDayOfCreation int.
   */
  protected void setDayOfCreationProt(int newDayOfCreation) {
    checkNull(String.valueOf(dayOfCreation), "Day of creation Cannot be null");
    dayOfCreation = newDayOfCreation;
  }

  /**
   * Setter method for cost perday.
   *
   * @param newCostPerDay integer.
   */
  protected void setCostPerDayProt(int newCostPerDay) {
    checkNull(String.valueOf(newCostPerDay), "Cost cannot be null");
    costPerDay = newCostPerDay;
  }

  /**
   * Setter method for contract period.
   *
   * @param newContractPeriod integer.
   */
  protected void setContractPeriodProt(int newContractPeriod) {
    checkNull(String.valueOf(contractPeriod), "Cost cannot be null");
    contractPeriod = newContractPeriod;
  }

  /**
   * Chek method for checking if attribute is null.
   *
   * @param str     String.
   * @param message String.
   */
  private void checkNull(String str, String message) {
    if (str == null) {
      throw new IllegalArgumentException(message);
    }
  }

  /**
   * Getter method for name.
   *
   * @return String.
   */
  public String getName() {
    return name;
  }

  /**
   * Getter method for short description.
   *
   * @return String.
   */
  public String getShortDescription() {
    return shortDescription;
  }

  /**
   * Getter method for cost perday.
   *
   * @return int.
   */
  public int getCostPerDay() {
    return costPerDay;
  }

  /**
   * Gettter method for day of creation.
   *
   * @return int.
   */
  public int getDayOfCreation() {
    return dayOfCreation;
  }

  /**
   * Getter method for contract period.
   *
   * @return int.
   */
  public int getContractPeriod() {
    return contractPeriod;
  }

  public CategoryEnum getCategory() {
    return category;
  }

  /**
   * Mutable class.
   */
  public static class Mutable extends Item {

    public Mutable(String name, String shortDescription, int costPerDay,
        int dayOfCreation, Boolean isLended, int contractPeriod, String owner, String lendedTo, CategoryEnum category) {
      super(name, shortDescription, costPerDay, dayOfCreation, isLended, contractPeriod, owner, lendedTo, category);
    }

    public Mutable(Item item) {
      super(item);
    }

    public Mutable() {
      super();
    }

    public void setisOwned(Boolean newisLended) {
      setisLendedProt(newisLended);
    }

    public void setName(String newName) {
      setNameProt(newName);
    }

    public void setCostPerDay(int newCostPerDay) {
      setCostPerDayProt(newCostPerDay);
    }

    public void setContractPeriod(int contractPeriod) {
      setContractPeriodProt(contractPeriod);
    }

    public void setShortDescription(String newShortDescription) {
      setShortDescriptionProt(newShortDescription);
    }
  }
}
