package week1

object sqrt {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(37); val res$0 = 
  1 + 3;System.out.println("""res0: Int(4) = """ + $show(res$0));$skip(53); 
  def abs(x: Double): Double = if (x >= 0) x else -x;System.out.println("""abs: (x: Double)Double""");$skip(334); 
  def sqrt(x: Double): Double = {
    def sqrtIter(guess: Double): Double =
      if (isGoodEnough(guess)) guess
      else sqrtIter(improve(guess))

    def isGoodEnough(guess: Double): Boolean =
      abs(guess * guess - x) / x < 0.001

    def improve(guess: Double): Double =
      (guess + x / guess) / 2

    sqrtIter(1)
  };System.out.println("""sqrt: (x: Double)Double""");$skip(14); val res$1 = 
  
  sqrt(2);System.out.println("""res1: Double = """ + $show(res$1))}
}
