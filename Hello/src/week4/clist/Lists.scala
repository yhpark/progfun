package week4.clist

trait List[+T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
  def prepend[U >: T](elem: U): List[U] = new Cons(elem, this)
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false
}

object Nil extends List[Nothing] {
  def isEmpty: Boolean = true
  def head: Nothing = throw new NoSuchElementException
  def tail: Nothing = throw new NoSuchElementException
}

object test {
  val x: List[String] = Nil
  def f(xs: List[NonEmpty], x: Empty) = xs prepend (x)
}