package model;

public class Member implements TimeAdvancedObserver {
  private String firstName;
  private String lastName;
  private String email;
  private String phoneNumber;
  private MemberId memberId;
  private int credits;
  private Time time = new Time();

  public Member(String firstName, String lastName, String email, String phoneNumber) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.memberId = new MemberId();
    this.credits = 100;
  }

  public Member(String firstName, String lastName, String email, String phoneNumber, MemberId id) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.memberId = id;
    this.credits = 100;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getEmail() {
    return email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public MemberId getMemberId() {
    return memberId;
  }

  public int getCredits() {
    return credits;
  }
  @Override
  public void TimeAdvanced(int value) {
      time.dayChange(value);
  }

  public static class Mutable extends Member {

    public Mutable(String firstName, String lastName, String email, String phoneNumber) {
      super(firstName, lastName, email, phoneNumber);
    }

    Mutable(String firstName, String lastName, String email, String phoneNumber, MemberId id) {
      super(firstName, lastName, email, phoneNumber, id);
    }

  }
}
