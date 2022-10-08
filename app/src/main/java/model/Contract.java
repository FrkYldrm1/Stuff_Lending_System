package model;

/**
 * The contract class for creating contract objects.
 */
public class Contract {
  private int startDate;
  private int endDate;

  /**
   * Constructor for contract class.
   *
   * @param startDate start date of contract.
   * @param endDate End date of contract.
   */
  public Contract(int startDate, int endDate) {
    this.startDate = startDate;
    this.endDate = endDate;
  }

  /**
   * Getter for start date.
   *
   * @return int.
   */
  public int getStartDate() {
    return startDate;
  }

  /**
   * Setter for start date.
   *
   * @param startDate Start date paramater.
   */
  public void setStartDate(int startDate) {
    this.startDate = startDate;
  }

  /**
   * Getter for end date.
   *
   * @return  enddate.
   */
  public int getEndDate() {
    return endDate;
  }

  /**
   * Setter for end date.
   *
   * @param endDate parameter for the method.
   */
  public void setEndDate(int endDate) {
    this.endDate = endDate;
  }

  /**
   * Item contract method.
   *
   * @param x The contract member 1.
   * @param y Contract member 2.
   * @param contractPeriod The contract period.
   */
  public void itemContract(Member x, Member y, int contractPeriod) {

  }

}
