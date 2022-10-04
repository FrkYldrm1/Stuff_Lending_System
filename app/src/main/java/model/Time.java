package model;

public class Time {
  private String dayOfCreation;
  private int day;

  public  Time(String dayOfCreation, int day) {
    this.dayOfCreation = dayOfCreation;
    this.day = day;
  }

  private void dateStart() {
    day = 0;
  }

  public void dayChange() {
    day += 1;
  }

  public String getDayOfCreation() {
    return dayOfCreation;
  }

  public void setDayOfCreation(String dayOfCreation) {
    this.dayOfCreation = dayOfCreation;
  }

  public int getDay() {
    return day;
  }

  public void setDay(int day) {
    this.day = day;
  }
}
