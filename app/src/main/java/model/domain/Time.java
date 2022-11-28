package model.domain;

/**
 * Time class for all the objets time.
 */
public class Time {
  private int day;

  public  Time() {
    this.day = 0;
  }

  /**
   * Get current day.
   *
   * @return day.
   *
   */
  public int getDay() {
    return day;
  }

  /**
   * Method for changing the day.
   */
  public void dayChange() {
    day += 1;
  }

}
