package collections

object Lists {
  //Soit une liste d'entier. Par exemple (1,2,7,9,11). Retourner l'indice des deux premiers éléments de la liste tels que leurs somme est égale à 11.
  //Par exemple 2+9=11 donc on doit retourner (1,3).

  /**
    * Sorts the list as high -> low -> high -> low ...
    * Should be O(n log n)
    * @param lst: a sequence of Integer
    * @return Seq[Int]: the input list sorted as high -> low -> high -> low ...
    */
  def alternativeSorting(lst: Seq[Int]): Seq[Int] = ???

  /**
    * Given two Seq[Int], reverse each list, concatenate each element and sum the results
    * e.g Intput: (9, 8) and  (5, 4, 2) -> Result: 89+245=334
    * @param first: first list
    * @param second: second list
    * @return Int: Sum of each list, reversed and concatenated
    */
  def twoSeqReverseSum(first: Seq[Int], second: Seq[Int]): Int = ???
}
