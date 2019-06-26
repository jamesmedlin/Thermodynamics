
public interface IPart extends IReadOnlyPart {

  /**
   * sets the given state to this part's inlet.
   * @param state the state as it enters this part
   */
  void setInlet(IState state);

  /**
   * sets the given state to this part's exit.
   * @param state the state as it exits this part
   */
  void setExit(IState state);

  /**
   * retrieves the inlet state of the part.
   * @return a mutable State
   */
  IState getInlet();

  /**
   * retrieves the exit state of the part.
   * @return a mutable state
   */
  IState getExit();

  /**
   * sets the exit state of this part.
   * @param state the state of the exit
   */
  void addExit(IState state);

  /**
   * sets the inlet state of this part.
   * @param state the state of the inlet
   */
  void addInlet(IState state);

  /**
   * sets the work to the given value.
   * @param value the work value
   */
  void setWork(boolean value);

  /**
   * sets the heat energy transferred to the given value.
   * @param value the heat energy value
   */
  void setHeatTransfer(boolean value);

}