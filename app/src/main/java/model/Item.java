package model;

public class Item {
  private String name;
  private String shortDescription;
  private int costPerDay;
  private int dayOfCreation;
  private boolean IsLended;
  private int contractPeriod;


  public Item(String name, String shortDescription, int costPerDay, int dayOfCreation, Boolean isLended, int contractPeriod) {
    setNameProt(name);
    setShortDescriptionProt(shortDescription);
    setCostPerDayProt(costPerDay);
    setisLendedProt(isLended);
    setContractPeriodProt(contractPeriod);
    this.dayOfCreation = 0;
  }

  public Item(Item item) {
    this.name = item.name;
    this.shortDescription = item.shortDescription;
    this.costPerDay = item.costPerDay;
    this.IsLended = item.IsLended;
    this.contractPeriod = item.contractPeriod;
  }



  protected void setShortDescriptionProt(String newShortDescription) {
    checkNull(newShortDescription, "Description cannot be null");
    shortDescription = newShortDescription;
  }
  protected void setisLendedProt(Boolean newisOwned) {
    IsLended = newisOwned;
  }

  protected void setNameProt(String newName) {
    checkNull(newName, "First Name Cannot be null");
    name = newName;
  }
  protected void setDayOfCreationProt(int newdayOfCreation) {
    checkNull(String.valueOf(dayOfCreation), "Day of creation Cannot be null");
    dayOfCreation = newdayOfCreation;
  }

  protected void setCostPerDayProt(int newCostPerDay) {
    checkNull(String.valueOf(newCostPerDay), "Cost cannot be null");
    costPerDay = newCostPerDay;
  }
  protected void setContractPeriodProt(int newContractPeriod) {
    checkNull(String.valueOf(contractPeriod), "Cost cannot be null");
    contractPeriod = newContractPeriod;
  }

  private void checkNull(String str, String message) {
    if (str == null) {
      throw new IllegalArgumentException(message);
    }
  }

  public String getName() {
    return name;
  }

  public String getShortDescription() {
    return shortDescription;
  }

  public int getCostPerDay() {
    return costPerDay;
  }

  public int getDayOfCreation() {
    return dayOfCreation;
  }
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
