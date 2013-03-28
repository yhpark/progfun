package week1

import scala.annotation.tailrec

object factorial {
  def factorial(n: Integer): Integer = {
		@tailrec
    def factIter(n: Integer, sum: Integer): Integer =
      if (n == 1) sum else factIter(n - 1, sum * n)
     
    factIter(n, 1)
  }                                               //> factorial: (n: Integer)Integer

	factorial(5)                              //> res0: Integer = 120
}