package model;

public class Time {
  private int day;

  public  Time() {
    this.day = 0;
  }

  public void dayChange(int value) {
    day += value;
  }

  public int getDay() {
    return day;
  }

  public void setDay(int day) {
    this.day = day;
  }
}
