package week4

trait Expr {
  def eval: Int = this match {
    case Number(n) => n
    case Sum(e1, e2) => e1.eval + e2.eval
    case Prod(e1, e2) => e1.eval * e2.eval
    case Var(name) => throw new Error
  }

  def show: String = this match {
    case Number(n) => n.toString
    case Sum(e1, e2) => e1.show + " + " + e2.show
    case Prod(e1, e2) => {
      def wrapIfSum(e: Expr): String = e match {
        case Sum(_, _) => "(" + e.show + ")"
        case _ => e.show
      }
      wrapIfSum(e1) + " * " + wrapIfSum(e2)
    }
    case Var(name) => name
  }
}
case class Number(n: Int) extends Expr
case class Sum(e1: Expr, e2: Expr) extends Expr
case class Prod(e1: Expr, e2: Expr) extends Expr
case class Var(name: String) extends Expr