package forcomp

object test {
  Anagrams.wordOccurrences("asdfccasadf")         //> res0: forcomp.Anagrams.Occurrences = List((a,3), (c,2), (d,2), (f,2), (s,2))
                                                  //| 
  Anagrams.sentenceOccurrences(List("asdfccasadf", "hoonge"))
                                                  //> res1: forcomp.Anagrams.Occurrences = List((a,3), (c,2), (d,2), (f,2), (s,2),
                                                  //|  (e,1), (g,1), (h,1), (n,1), (o,2))

  List(1, 2, 3, 4).drop(2)                        //> res2: List[Int] = List(3, 4)
  List(1, 2, 3, 4).dropWhile(i => i != 2)         //> res3: List[Int] = List(2, 3, 4)

  List(('a', 2), ('b', 2)).zipWithIndex           //> res4: List[((Char, Int), Int)] = List(((a,2),0), ((b,2),1))

  Anagrams.combinations(List(('a', 2))).toSet     //> res5: scala.collection.immutable.Set[forcomp.Anagrams.Occurrences] = Set(Lis
                                                  //| t(), List((a,1)), List((a,2)))
  val a = for {
    i <- 0 to 1
  } yield {
    Anagrams.combinations(List(('a', 1))).map(ox => ('b', i) :: ox)
                                                  //> a  : scala.collection.immutable.IndexedSeq[List[List[(Char, Int)]]] = Vector
                                                  //| (List(List((b,0)), List((b,0), (a,1))), List(List((b,1)), List((b,1), (a,1))
                                                  //| ))
  }
  a.flatten                                       //> res6: scala.collection.immutable.IndexedSeq[List[(Char, Int)]] = Vector(List
                                                  //| ((b,0)), List((b,0), (a,1)), List((b,1)), List((b,1), (a,1)))
  
  Anagrams.combinations(List(('a', 2), ('b', 2))).toSet
                                                  //> res7: scala.collection.immutable.Set[forcomp.Anagrams.Occurrences] = Set(Lis
                                                  //| t((a,1)), List((b,1)), List((b,2)), List((a,1), (b,1)), List(), List((a,2), 
                                                  //| (b,1)), List((a,2)), List((a,1), (b,2)), List((a,2), (b,2)))
                                                  
}