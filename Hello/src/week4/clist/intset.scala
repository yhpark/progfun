package week4.clist

abstract class IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(other: IntSet): IntSet
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  def incl(x: Int) =
    if (x < elem) new NonEmpty(elem, left incl x, right)
    else if (x > elem) new NonEmpty(elem, left, right incl x)
    else this

  def contains(x: Int) =
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true

  def union(other: IntSet) = (left union right) union other incl elem

  override def toString = "{" + left + elem + right + "}"
}

class Empty extends IntSet {
  def contains(x: Int) = false
  def incl(x: Int) = new NonEmpty(x, new Empty, new Empty)
  def union(other: IntSet) = other

  override def toString = "."
}
