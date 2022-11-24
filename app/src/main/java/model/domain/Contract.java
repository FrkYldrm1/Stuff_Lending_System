package model.domain;


import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 * The contract class for creating contract objects.
 */
public class Contract {

  private Member owner;
  private Member lentTo;
  private int contractPeriod;
  private Item item;

  /**
   * Constactor for contact class.
   */
  @SuppressFBWarnings(value = "EI_EXPOSE_REP", justification = "It is the constructor so we should have it.")
  public Contract(Member owner, Member lentTo, int contractPeriod, Item item) {
    this.owner = owner;
    this.lentTo = lentTo;
    this.contractPeriod = contractPeriod;
    this.item = item;
  }

  @SuppressFBWarnings(value = "EI_EXPOSE_REP", justification = "In the program some values are accessed by this method."
          + " Making dummy and returning to not expose internal "
          + "representation might cut our access in some parts of the program.")
  public Member getOwner() {
    return owner;
  }

  @SuppressFBWarnings(value = "EI_EXPOSE_REP", justification = "In the program some values are accessed by this method."
          + " Making dummy and returning to not expose internal representation might"
          + " cut our access in some parts of the program.")
  public Member getLentTo() {
    return lentTo;
  }

  /**
   * Getter method for  contract period.
   */
  public int getContractPeriod() {
    return contractPeriod;
  }

  /**
   * Getter method for  item.
   */
  public Item getItem() {
    return item;
  }
}



