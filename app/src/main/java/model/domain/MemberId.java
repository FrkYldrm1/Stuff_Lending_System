package model.domain;

import java.util.Random;

/**
 * Class for member id.
 */
public class MemberId {
  private Random rnd = new Random();
  private String id;
  private String dateCreated;


  public String getDateCreated() {
    return dateCreated;
  }

  // creates random id and puts in creation date
  public MemberId() {
    this.id = createId(6);
    this.dateCreated = creationDate();
  }
  
  private String creationDate() {
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
  private String createId(int length) {
    StringBuilder sb = new StringBuilder();
    Random rand = new Random();
    int asciiStart = 48;
    int asciiEnd = 122;

    for (int i = 0; i < length; i++) {
      int randAscii = rand.nextInt(asciiEnd - asciiStart + 1) + asciiStart;
      if (!(randAscii >= 58 && randAscii <= 64) && !(randAscii >= 91 && randAscii <= 96)) {
        sb.append((char) randAscii);
      } else {
        i--;
      }
    }

    return sb.toString();
  }
}
