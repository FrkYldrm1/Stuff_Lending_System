package model;

public class Item {
  private String name;
  private String shortDescription;
  private int costPerDay;
  private int itemId;
  private int dayOfCreation;


  public Item(String name, String shortDescription, int costPerDay, int dayOfCreation) {
    setNameProt(name);
    setShortDescriptionProt(shortDescription);
    setCostPerDayProt(costPerDay);
  }

  public Item(Item item) {
    this.name = item.name;
    this.shortDescription = item.shortDescription;
    this.itemId = 0;
    this.costPerDay = item.costPerDay;
  }



  protected void setShortDescriptionProt(String newShortDescription) {
    checkNull(newShortDescription, "Description cannot be null");
    shortDescription = newShortDescription;
  }

  protected void setNameProt(String newName) {
    checkNull(newName, "First Name Cannot be null");
    name = newName;
  }
  protected void setDayOfCreationProt(int newDayOfCreation) {
    checkNull(String.valueOf(dayOfCreation), "Day of creation Cannot be null");
    dayOfCreation = newDayOfCreation;
  }

  protected void setCostPerDayProt(int newCostPerDay) {
    checkNull(String.valueOf(newCostPerDay), "Cost cannot be null");
    costPerDay = newCostPerDay;
  }

  private void checkNull(String str, String message) {
    if (str == null) {
      throw new IllegalArgumentException(message);
    }
  }

  public String getName() {
    return name;
  }

  public int getItemId() {
    return itemId;
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

  public void setItemId(int itemId) {
    this.itemId = itemId;
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

    public Mutable(String name, String shortDescription, int costPerDay, int dayOfCreation) {
      super(name, shortDescription, costPerDay, dayOfCreation);
    }

    public Mutable(Item item) {
      super(item);
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
