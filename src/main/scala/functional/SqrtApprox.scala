package functional

object SqrtApprox {
  val EPSILON = 0.001

  // Computes whether the current value is close to the actual value of sqrt(x)
  def isGoodEnough(current: Double, x: Double): Boolean = ???

  // Computes a better approximation by calculating the mean value between the current approximation and the value “x”
  // Mean of guess and x
  def improve(guess: Double, x: Double): Double = ???

  // Recursive function that calculates the sqrt value of x and starts with an approximation of “1”
  def sqrtIter(guess: Double, x: Double): Double = ???
}
