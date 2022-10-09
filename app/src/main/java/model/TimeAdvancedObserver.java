package model;

/**
 * Interface for advancing time.
 */
public interface TimeAdvancedObserver {
  /**
   *
   * Method for advancing time.
   *
   */
  void advanceTime();

  /**
   * Method for items time.
   */
  void updateItems();

}
