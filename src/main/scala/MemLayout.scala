package compost

import jdk.incubator.foreign.MemoryLayout

import java.lang.constant.{Constable, DynamicConstantDesc}
import java.nio.ByteOrder
import java.util.{Optional, stream}

enum MemLayout[A] {
  case Struct()
  case Union()
  case Sequence()
  case Value()
  case Padding()
}

object MemLayouts {
  opaque type MemLayout[A] = MemoryLayout

  object MemLayout{
    import scala.deriving.Mirror

    def derived[T](using Mirror.Of[T]): MemLayout[T] = ???

  }

}
