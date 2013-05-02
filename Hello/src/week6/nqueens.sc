package week6

object nqueens {
	def queens(n: Int) : Set[List[Int]] = {
		def isSafe(col: Int, queens: List[Int]) : Boolean =
			((queens.length - 1 to 0 by -1) zip queens) forall {
				case (i, c) => col != c && math.abs(col - c) != queens.length - i
			}
		
		def placeQueens(k: Int): Set[List[Int]] =
			if (k == 0) Set(List())
			else
				for {
					queens <- placeQueens(k - 1)
					col <- 0 until n
					if isSafe(col, queens)
				} yield col :: queens
		
		placeQueens(n)
	}                                         //> queens: (n: Int)Set[List[Int]]
	
	queens(4)                                 //> res0: Set[List[Int]] = Set(List(1, 3, 0, 2), List(2, 0, 3, 1))
}