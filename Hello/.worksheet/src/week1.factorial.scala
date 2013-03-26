package week1

import scala.annotation.tailrec

object factorial {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(256); 
  def factorial(n: Integer): Integer = {
		@tailrec
    def factIter(n: Integer, sum: Integer): Integer =
      if (n == 1) sum else factIter(n - 1, sum * n)
     
    factIter(n, 1)
  };System.out.println("""factorial: (n: Integer)Integer""");$skip(16); val res$0 = 

	factorial(5);System.out.println("""res0: Integer = """ + $show(res$0))}
}
