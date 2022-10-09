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

  
  /**
   * Getter for the day.
   *
   * @return int.
   */
  public int getDay() {
    return day;
  }

  
  /**
   * Setter for the day.
   *
   * @param day Parameter for setting day.
   */
  public void setDay(int day) {
    this.day = day;
  }
}
