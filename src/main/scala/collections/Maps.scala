package collections

object Maps {

  /**
    * Calculate the sum of the length of the String with the Int
    * @param aMap: a Map with String as Key and Int as Values
    * @return Int: the sum of the length of the String with the Int
    */
  def sumKeysLengthWithValues(aMap: Map[String, Int]): Int = ???

  /**
    * Applies a function to each String key in order to transform it into a Integer and sums the results with the keys
    * @param aMap: a Map with String as Key and Int as Values
    * @param strToInt: a functions that maps String to Int
    * @return Int: Sum of values with String after applying the strToInt function
    */
  def sumKeysWithValues(aMap: Map[String, Int], strToInt: String => Int): Int = ???

}
