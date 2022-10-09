package model;

/**
 * Time class for all the objets time.
 */
public class Time {
  private int day;

  public  Time() {
    this.day = 0;
  }

  
  /**
   *
   * Method for changing the day.
   *
   */
  public void dayChange() {
    day += 1;
  }

}
