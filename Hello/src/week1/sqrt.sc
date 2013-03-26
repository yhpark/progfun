package week1

object sqrt {
  1 + 3                                           //> res0: Int(4) = 4
  def abs(x: Double): Double = if (x >= 0) x else -x
                                                  //> abs: (x: Double)Double
  def sqrt(x: Double): Double = {
    def sqrtIter(guess: Double): Double =
      if (isGoodEnough(guess)) guess
      else sqrtIter(improve(guess))

    def isGoodEnough(guess: Double): Boolean =
      abs(guess * guess - x) / x < 0.001

    def improve(guess: Double): Double =
      (guess + x / guess) / 2

    sqrtIter(1)
  }                                               //> sqrt: (x: Double)Double
  
  sqrt(2)                                         //> res1: Double = 1.4142156862745097
}