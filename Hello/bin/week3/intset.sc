package week2

object intset {
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

  object Empty extends IntSet {
    def contains(x: Int) = false
    def incl(x: Int) = new NonEmpty(x, Empty, Empty)
    def union(other: IntSet) = other

    override def toString = "."
  }
  
  val t1 = new NonEmpty(3, Empty, Empty)          //> t1  : week2.intset.NonEmpty = {.3.}
  val t2 = t1 incl 4                              //> t2  : week2.intset.NonEmpty = {.3{.4.}}
  
  Empty.union(t1)                                 //> res0: week2.intset.IntSet = {.3.}
  t2 union t1                                     //> res1: week2.intset.IntSet = {.3{.4.}}
}