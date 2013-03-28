package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || r == 0 || c == r) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def balanceIter(chars: List[Char], balance: Int): Boolean = {
      if (balance < 0) false
      else if (chars.isEmpty) balance == 0
      else balanceIter(chars.tail,
        chars.head match {
          case '(' => balance + 1
          case ')' => balance - 1
          case _ => balance
        })
    }

    balanceIter(chars, 0)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    def countIter(counted: Int, coins: List[Int]): Int = {
      if (counted == money) 1
      else if (counted > money) 0
      else if (coins.isEmpty) 0
      else countIter(counted + coins.head, coins) + countIter(counted, coins.tail)
    }

    if (money > 0) countIter(0, coins) else 0
  }
}
