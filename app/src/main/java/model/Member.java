package model;

public class Member {
  private String firstName;
  private String lastName;
  private String email;
  private String phoneNumber;
  private MemberId memberId;

  public Member(String firstName, String lastName, String email, String phoneNumber, MemberId memberId) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.memberId = memberId;
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

  public class Mutable extends Member {

    public Mutable(String firstName, String lastName, String email, String phoneNumber, MemberId memberId) {
      super(firstName, lastName, email, phoneNumber, memberId);
      // TODO Auto-generated constructor stub
    }
  }
}
