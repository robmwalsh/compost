package compost
import compost.Inspect



import scala.compiletime.*
import scala.quoted.*
import scala.deriving.*

object ShouldProbablyBeAMacroLibrary:

  transparent inline def refineWithFields[T <: Product] : Any =
    ${refineWithFieldsImpl[T]}

  private def refineWithFieldsImpl[T <: Product: Type](using Quotes):Expr[Any] =
    import quotes.reflect._

    def loop[L: Type, T: Type](typeRepr: TypeRepr):TypeRepr =
      Type.of[L] match
        case '[lHead *: lTail] =>
          Type.of[T] match
            case '[tHead *: tTail] =>  loop[lTail, tTail](Refinement(typeRepr, Type.valueOfConstant[lHead].get.toString, TypeRepr.of[tHead]))
            case _ => throw new IllegalStateException("labels and types must be the same length")
        case _ => typeRepr

    Expr.summon[Mirror.ProductOf[T]].get match
      case '{ $m: Mirror.ProductOf[T] {type MirroredElemLabels = labels; type MirroredElemTypes = types } } =>
        loop[labels, types](TypeRepr.of[Inspect[T]]).asType match {
          case '[r] =>
            val res = '{new Inspect[r]{}}
            println(res.show)
            res
        }



