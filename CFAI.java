/*
 * hw4
 * Name: Zhengyang Qi
 * SID: 204296544
 */

/*
 * Interface for AIs
 */
public interface CFAI {
  int nextMove(CFGame g);
  //return value of getName cannot be "draw"
  String getName();
}