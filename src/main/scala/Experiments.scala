package compost

import ShouldProbablyBeAMacroLibrary.*

import compost.MemLayouts.MemLayout

import scala.compiletime.*
import scala.deriving.*
import scala.quoted.{Expr, Quotes, Type}

object Experiments extends App:
  /*import jdk.incubator.foreign.*

  import java.nio.ByteOrder
  val taggedValues = MemoryLayout
    .sequenceLayout(
      5,
      MemoryLayout.structLayout(
        MemoryLayout.valueLayout(8, ByteOrder.nativeOrder()).withName("kind"),
        MemoryLayout.paddingLayout(24),
        MemoryLayout.valueLayout(32, ByteOrder.nativeOrder()).withName("value")
      )
    )
    .withName("TaggedValues");*/

  case class Person(name: String, age : Int)

  //case class Rectangle(x : Int, y : Int) derives MemLayout

  val x = refineWithFields[Person]
  println(x.age)





