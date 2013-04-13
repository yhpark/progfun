package week2

object tailreq {
  def sigma(f: Int => Int, g: (Int, Int) => Int, zero: Int)(a: Int, b: Int) = {
    def loop(a: Int, acc: Int): Int =
      if (a > b) acc else loop(a + 1, g(acc, f(a)))
    loop(a, zero)
  }                                               //> sigma: (f: Int => Int, g: (Int, Int) => Int, zero: Int)(a: Int, b: Int)Int

  def sum(f: Int => Int)(a: Int, b: Int): Int = {
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a + 1, acc + f(a))
    }
    loop(a, 0)
  }                                               //> sum: (f: Int => Int)(a: Int, b: Int)Int

  sum((x: Int) => x)(8, 10)                       //> res0: Int = 27

  def product(f: Int => Int)(a: Int, b: Int): Int = {
    def loop(a: Int, acc: Int): Int =
      if (a > b) acc
      else loop(a + 1, acc * f(a))
    loop(a, 1)
  }                                               //> product: (f: Int => Int)(a: Int, b: Int)Int

  product(x => x * x)(1, 3)                       //> res1: Int = 36

  def fact(a: Int): Int = product(x => x)(1, a)   //> fact: (a: Int)Int

  fact(5)                                         //> res2: Int = 120

  sigma(x => x * x, (a, b) => a + b, 0)(8, 10)    //> res3: Int = 245
}