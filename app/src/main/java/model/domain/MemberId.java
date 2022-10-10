package model.domain;

import java.util.Random;

/**
 * Class for member id.
 */
public class MemberId {
  private Random rnd = new Random();
  private String id;
  private String dateCreated;

  // creates random id and puts in creation date
  public MemberId() {
    this.id = createId();
    this.dateCreated = creationDate();
  }
  public String creationDate() {
    return (java.time.LocalDate.now().toString());
  }

  public String getId() {
    return id;
  }

  /**
   * Creates random ID.
   *
   * @return ID.
   */
  public String createId() {
    // works by generating a random number and taking the character at that position
    // adding it to the string that will be returned.
    String returnee = ""; // string to be returned
    String characters = "0123456789AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";

    for (int i = 0; i < 6; i++) {
      int num = rnd.nextInt(characters.length());
      returnee += String.valueOf(characters.charAt(num));
    }
    return returnee;
  }

}
