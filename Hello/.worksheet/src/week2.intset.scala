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
  };import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(906); 
  
  val t1 = new NonEmpty(3, Empty, Empty);System.out.println("""t1  : week2.intset.NonEmpty = """ + $show(t1 ));$skip(21); 
  val t2 = t1 incl 4;System.out.println("""t2  : week2.intset.NonEmpty = """ + $show(t2 ));$skip(21); val res$0 = 
  
  Empty.union(t1);System.out.println("""res0: week2.intset.IntSet = """ + $show(res$0));$skip(14); val res$1 = 
  t2 union t1;System.out.println("""res1: week2.intset.IntSet = """ + $show(res$1))}
}
