package week4

object lists {
  def isort(xs: List[Int]): List[Int] = xs match {
    case List() => List()
    case y :: ys => insert(y, isort(ys))
  }                                               //> isort: (xs: List[Int])List[Int]

  def insert(x: Int, xs: List[Int]): List[Int] = xs match {
    case List() => List(x)
    case y :: ys => if (x < y) x :: xs else y :: insert(x, ys)
  }                                               //> insert: (x: Int, xs: List[Int])List[Int]

  isort(List(2, 4, 3, 5, 1, 5, 2, 4))             //> res0: List[Int] = List(1, 2, 2, 3, 4, 4, 5, 5)
}