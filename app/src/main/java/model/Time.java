package model;

public class Time {
  private int dayOfCreation;
  private int day;

  public  Time() {
    this.dayOfCreation = 0;
    this.day = 0;
  }

  public void dayChange(int value) {
    day += value;
  }

  public int getDayOfCreation() {
    return dayOfCreation;
  }

  public void setDayOfCreation(int dayOfCreation) {
    this.dayOfCreation = dayOfCreation;
  }

  public int getDay() {
    return day;
  }

  public void setDay(int day) {
    this.day = day;
  }
}
