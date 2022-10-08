package model;

/**
 * Item class to create item objects.
 */
public class Item {
  private String name;
  private String shortDescription;
  private int costPerDay;
  private String itemId;
  private int dayOfCreation;
  private boolean isLended;
  private int contractPeriod;
  private String owner;
  private String lenededTo;
  private MemberId id = new MemberId();



  /**
   * Constructor for the item.
   *
   * @param name             To initilize the name.
   * @param shortDescription To initilize the short description.
   * @param costPerDay       To initilize the cost per day.
   * @param dayOfCreation    To initilize day of creation.
   * @param isLended         To select if it is lended.
   * @param contractPeriod   To initilize the contract period,
   */
  public Item(String name, String shortDescription, int costPerDay, int dayOfCreation,
      Boolean isLended, int contractPeriod, String owner, String lendedTo) {
    setNameProt(name);
    setShortDescriptionProt(shortDescription);
    setCostPerDayProt(costPerDay);
    setisLendedProt(isLended);
    setContractPeriodProt(contractPeriod);
    this.dayOfCreation = 0;
    this.itemId = id.createId();
    this.owner = owner;
    this.lenededTo = lendedTo;
  }

  
  public void setOwner(String owner) {
    this.owner = owner;
  }


  public void setLenededTo(String lenededTo) {
    this.lenededTo = lenededTo;
  }


  public String getOwner() {
    return owner;
  }


  public String getLenededTo() {
    return lenededTo;
  }


  /** 
   * Getter method for item id.
   *
   * @return String.
   */
  public String getItemId() {
    return itemId;
  }

  /**
   *  Constructor.
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
   * @param str String.
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

  enum Category {
    TOOL,
    VEHICLE,
    GAMES,
    TOY,
    SPORT,
    OTHER
  }

  /**
   * Mutable class.
   */
  public static class Mutable extends Item {

    public Mutable(String name, String shortDescription, int costPerDay,
        int dayOfCreation, Boolean isLended, int contractPeriod, String owner, String lendedTo) {
      super(name, shortDescription, costPerDay, dayOfCreation, isLended, contractPeriod, owner, lendedTo);
    }

    public Mutable(Item item) {
      super(item);
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

    public void setShortDescription(String newShortDescription) {
      setShortDescriptionProt(newShortDescription);
    }
  }
}
