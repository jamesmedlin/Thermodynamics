public interface IReadOnlyPart {

  /**
   * retrieves the work value of this part.
   * @return the value of work
   */
  double getWork();

  /**
   * retrieves the value of heat energy transfer.
   * @return the value of energy transferred via heat
   */
  double getHeatTransfer();
}
