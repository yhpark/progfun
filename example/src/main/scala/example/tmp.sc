package example

object tmp {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  Lists.sum(List(2, 2, 3))                        //> res0: Int = 7
  Lists.sum(List())                               //> res1: Int = 0
  Lists.max(List())                               //> java.util.NoSuchElementException
                                                  //| 	at example.Lists$.max(Lists.scala:47)
                                                  //| 	at example.tmp$$anonfun$main$1.apply$mcV$sp(example.tmp.scala:8)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at example.tmp$.main(example.tmp.scala:3)
                                                  //| 	at example.tmp.main(example.tmp.scala)
  Lists.sum(List(3, 1, 2))
}