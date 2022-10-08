package model;

/**
 * Interface for advancing time.
 */
public interface TimeAdvancedObserver {
  /**
   * Method for advancing time.
   *
   * @param value Days that will be advanced.
   */
  void advanceTime(int value);

  /**
   * Method for items time.
   */
  void updateItems();

}
