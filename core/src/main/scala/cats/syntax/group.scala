package cats
package syntax

import cats.macros.Ops

trait GroupSyntax {
  // TODO: use simulacrum instances eventually
  implicit def groupSyntax[A: Group](a: A): GroupOps[A] =
    new GroupOps[A](a)
}

class GroupOps[A: Group](lhs: A) {
  def |-|(rhs: A): A = macro Ops.binop[A, A]
  def remove(rhs: A): A = macro Ops.binop[A, A]
}
