package example

object tmp {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(74); 
  println("Welcome to the Scala worksheet");$skip(29); val res$0 = 

  Lists.sum(List(2, 2, 3));System.out.println("""res0: Int = """ + $show(res$0));$skip(20); val res$1 = 
  Lists.sum(List());System.out.println("""res1: Int = """ + $show(res$1));$skip(20); val res$2 = 
  Lists.max(List());System.out.println("""res2: Int = """ + $show(res$2));$skip(27); val res$3 = 
  Lists.sum(List(3, 1, 2));System.out.println("""res3: Int = """ + $show(res$3))}
}
