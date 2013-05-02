package week5

object lists {
  def init[T](xs: List[T]): List[T] = xs match {
    case List() => throw new Error("init of empty list")
    case List(x) => List()
    case y :: ys => y :: init(ys)
  }                                               //> init: [T](xs: List[T])List[T]

  def concat[T](xs: List[T], ys: List[T]): List[T] = xs match {
    case List() => ys
    case z :: zs => z :: concat(zs, ys)
  }                                               //> concat: [T](xs: List[T], ys: List[T])List[T]

  def reverse[T](xs: List[T]): List[T] = xs match {
    case List() => List()
    case y :: ys => reverse(ys) ++ List(y)
  }                                               //> reverse: [T](xs: List[T])List[T]

  def removeAt[T](n: Int, xs: List[T]): List[T] = (xs take n) ++ (xs drop n + 1)
                                                  //> removeAt: [T](n: Int, xs: List[T])List[T]
  removeAt(2, List('a', 'b', 'c', 'd'))           //> res0: List[Char] = List(a, b, d)

  def flatten(xs: List[Any]): List[Any] = xs match {
    case List() => List()
    case (y :: ys) :: zs => y :: flatten(ys :: zs)
    case y :: ys => y :: flatten(ys)
  }                                               //> flatten: (xs: List[Any])List[Any]

  def pack[T](xs: List[T]): List[List[T]] = xs match {
    case Nil => Nil
    case x :: xs1 => {
      val (first, rest) = xs.span(i => i == x)
      first :: pack(rest)
    }
  }                                               //> pack: [T](xs: List[T])List[List[T]]

  pack(List(1, 1, 1, 2, 3, 2, 2))                 //> res1: List[List[Int]] = List(List(1, 1, 1), List(2), List(3), List(2, 2))

  def encode[T](xs: List[T]): List[(T, Int)] =
    pack(xs) map (ys => (ys.head, ys.length))     //> encode: [T](xs: List[T])List[(T, Int)]

  encode(List(1, 1, 1, 2, 3, 2, 2))               //> res2: List[(Int, Int)] = List((1,3), (2,1), (3,1), (2,2))

  def mapFun[T, U](xs: List[T], f: T => U): List[U] =
    (xs foldRight List[U]())(f(_) :: _)           //> mapFun: [T, U](xs: List[T], f: T => U)List[U]

  def lengthFun[T](xs: List[T]): Int =
    (xs foldRight 0)((x, n) => n + 1)             //> lengthFun: [T](xs: List[T])Int

  mapFun(List(1, 1, 1, 2, 3, 2, 2), (x: Int) => x.toString + "A")
                                                  //> res3: List[String] = List(1A, 1A, 1A, 2A, 3A, 2A, 2A)

  lengthFun(List(1, 1, 1, 2, 3, 2, 2))            //> res4: Int = 7
}