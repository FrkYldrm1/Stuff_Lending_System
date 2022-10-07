package model;

public class Item {
  private String name;
  private String shortDescription;
  private int costPerDay;
  private String itemId;
  private int dayOfCreation;
  private boolean IsLended;
  private int contractPeriod;
  private MemberId id = new MemberId();


  public Item(String name, String shortDescription, int costPerDay, int dayOfCreation, Boolean isLended, int contractPeriod) {
    setNameProt(name);
    setShortDescriptionProt(shortDescription);
    setCostPerDayProt(costPerDay);
    setisLendedProt(isLended);
    setContractPeriodProt(contractPeriod);
    this.dayOfCreation = 0;
    this.itemId = id.createId();
  }

  
  /** 
   * @return String
   */
  public String getItemId() {
    return itemId;
  }

  public Item(Item item) {
    this.name = item.name;
    this.shortDescription = item.shortDescription;
    this.costPerDay = item.costPerDay;
    this.IsLended = item.IsLended;
    this.contractPeriod = item.contractPeriod;
  }



  
  /** 
   * @param newShortDescription
   */
  protected void setShortDescriptionProt(String newShortDescription) {
    checkNull(newShortDescription, "Description cannot be null");
    shortDescription = newShortDescription;
  }
  
  /** 
   * @param newisOwned
   */
  protected void setisLendedProt(Boolean newisOwned) {
    IsLended = newisOwned;
  }

  
  /** 
   * @param newName
   */
  protected void setNameProt(String newName) {
    checkNull(newName, "First Name Cannot be null");
    name = newName;
  }
  
  /** 
   * @param newDayOfCreation
   */
  protected void setDayOfCreationProt(int newDayOfCreation) {
    checkNull(String.valueOf(dayOfCreation), "Day of creation Cannot be null");
    dayOfCreation = newDayOfCreation;
  }

  
  /** 
   * @param newCostPerDay
   */
  protected void setCostPerDayProt(int newCostPerDay) {
    checkNull(String.valueOf(newCostPerDay), "Cost cannot be null");
    costPerDay = newCostPerDay;
  }
  
  /** 
   * @param newContractPeriod
   */
  protected void setContractPeriodProt(int newContractPeriod) {
    checkNull(String.valueOf(contractPeriod), "Cost cannot be null");
    contractPeriod = newContractPeriod;
  }

  
  /** 
   * @param str
   * @param message
   */
  private void checkNull(String str, String message) {
    if (str == null) {
      throw new IllegalArgumentException(message);
    }
  }

  
  /** 
   * @return String
   */
  public String getName() {
    return name;
  }

  
  /** 
   * @return String
   */
  public String getShortDescription() {
    return shortDescription;
  }

  
  /** 
   * @return int
   */
  public int getCostPerDay() {
    return costPerDay;
  }

  
  /** 
   * @return int
   */
  public int getDayOfCreation() {
    return dayOfCreation;
  }
  
  /** 
   * @return int
   */
  public int getContractPeriod() {
    return contractPeriod;
  }

  enum category {
    TOOL,
    VEHICLE,
    GAMES,
    TOY,
    SPORT,
    OTHER
  }

  public static class Mutable extends Item {

    public Mutable(String name, String shortDescription, int costPerDay, int dayOfCreation, Boolean isLended, int contractPeriod) {
      super(name, shortDescription, costPerDay, dayOfCreation, isLended, contractPeriod);
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
