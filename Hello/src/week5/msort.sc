package week5

object msort {
  def msort[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
        case (Nil, ys) => ys
        case (xs, Nil) => xs
        case (x :: xs1, y :: ys1) =>
          if (ord.lt(x, y)) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
      }

      val (fst, snd) = xs splitAt n
      merge(msort(fst)(ord), msort(snd)(ord))
    }
  }                                               //> msort: [T](xs: List[T])(implicit ord: Ordering[T])List[T]

  msort(List(1, 4, 2, 5, 9, 3, 6, 7))             //> res0: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 9)
  msort(List("banan", "a", "asdf"))               //> res1: List[String] = List(a, asdf, banan)
}