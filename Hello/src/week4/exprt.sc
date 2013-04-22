package week4

object exprt {
  Sum(Number(1), Number(2)).eval                  //> res0: Int = 3
  Sum(Number(1), Number(2)).show                  //> res1: String = 1 + 2
  Sum(Prod(Number(1), Number(2)), Number(3)).show //> res2: String = 1 * 2 + 3
  Prod(Sum(Number(1), Number(2)), Number(3)).show //> res3: String = (1 + 2) * 3
}