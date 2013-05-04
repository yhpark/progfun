package forcomp

object test {
  Anagrams.wordOccurrences("asdfccasadf")         //> res0: forcomp.Anagrams.Occurrences = List((a,3), (c,2), (d,2), (f,2), (s,2))
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

  Anagrams.combinations(List(('a', 2), ('b', 2))).toSet.toList
                                                  //> res7: List[forcomp.Anagrams.Occurrences] = List(List((a,1)), List((b,1)), Li
                                                  //| st((b,2)), List((a,1), (b,1)), List(), List((a,2), (b,1)), List((a,2)), List
                                                  //| ((a,1), (b,2)), List((a,2), (b,2)))

  Anagrams.combinations(Anagrams.wordOccurrences("dat")).toSet
                                                  //> res8: scala.collection.immutable.Set[forcomp.Anagrams.Occurrences] = Set(Lis
                                                  //| t((d,1), (t,1)), List((a,1), (t,1)), List((a,1)), List((t,1)), List(), List(
                                                  //| (a,1), (d,1), (t,1)), List((d,1)), List((a,1), (d,1)))

  Anagrams.subtract(List(('a', 1), ('e', 1), ('i', 1), ('t', 2)), List(('i', 1), ('t', 1)))
                                                  //> res9: forcomp.Anagrams.Occurrences = List((a,1), (e,1), (t,1))

  Anagrams.sentenceAnagrams(List("Linux", "rulez")).toSet
                                                  //> res10: scala.collection.immutable.Set[forcomp.Anagrams.Sentence] = Set(List(
                                                  //| rulez, Linux), List(Linux, rulez))
  
  Anagrams.occurAnagrams(Anagrams.sentenceOccurrences(List("Rex", "lin", "zulu")))
                                                  //> res11: List[forcomp.Anagrams.Sentence] = List(List(Lin, Zulu, Rex), List(Lin
                                                  //| , Rex, Zulu), List(nil, Zulu, Rex), List(nil, Rex, Zulu), List(Rex, Lin, Zul
                                                  //| u), List(Rex, nil, Zulu))
                                                  
  //Anagrams.occurAnagrams(Anagrams.sentenceOccurrences(List("Linux", "rulez")))
                                                  
  val anas = List(
      List("Rex", "Lin", "Zulu"),
      List("nil", "Zulu", "Rex"),
      List("Rex", "nil", "Zulu"),
      List("Zulu", "Rex", "Lin"),
      List("null", "Uzi", "Rex"),
      List("Rex", "Zulu", "Lin"),
      List("Uzi", "null", "Rex"),
      List("Rex", "null", "Uzi"),
      List("null", "Rex", "Uzi"),
      List("Lin", "Rex", "Zulu"),
      List("nil", "Rex", "Zulu"),
      List("Rex", "Uzi", "null"),
      List("Rex", "Zulu", "nil"),
      List("Zulu", "Rex", "nil"),
      List("Zulu", "Lin", "Rex"),
      List("Lin", "Zulu", "Rex"),
      List("Uzi", "Rex", "null"),
      List("Zulu", "nil", "Rex"),
      List("rulez", "Linux"),
      List("Linux", "rulez")
    )                                             //> anas  : List[List[String]] = List(List(Rex, Lin, Zulu), List(nil, Zulu, Rex
                                                  //| ), List(Rex, nil, Zulu), List(Zulu, Rex, Lin), List(null, Uzi, Rex), List(R
                                                  //| ex, Zulu, Lin), List(Uzi, null, Rex), List(Rex, null, Uzi), List(null, Rex,
                                                  //|  Uzi), List(Lin, Rex, Zulu), List(nil, Rex, Zulu), List(Rex, Uzi, null), Li
                                                  //| st(Rex, Zulu, nil), List(Zulu, Rex, nil), List(Zulu, Lin, Rex), List(Lin, Z
                                                  //| ulu, Rex), List(Uzi, Rex, null), List(Zulu, nil, Rex), List(rulez, Linux), 
                                                  //| List(Linux, rulez))

  //Anagrams.occurAnagrams(Anagrams.wordOccurrences("eatit"))

}