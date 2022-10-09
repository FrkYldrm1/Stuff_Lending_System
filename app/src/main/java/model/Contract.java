package model;

import java.util.List;

/**
 * The contract class for creating contract objects.
 */
public class Contract {

  private Member owner;
  private Member lentTo;
  private int contractPeriod;
  private int item;


  public Contract(Member owner, Member lentTo, int contractPeriod, int item) {
    this.owner = owner;
    this.lentTo = lentTo;
    this.contractPeriod = contractPeriod;
    this.item = item;
  }
  public Member getOwner() {
    return owner;
  }
  public void setOwner(Member owner) {
    this.owner = owner;
  }
  public Member getLentTo() {
    return lentTo;
  }
  public void setLentTo(Member lentTo) {
    this.lentTo = lentTo;
  }
  public int getContractPeriod() {
    return contractPeriod;
  }
 
  public void setContractPeriod(int contractPeriod) {
    this.contractPeriod = contractPeriod;
  }

  public int getItem() {
    return item;
  }
}


