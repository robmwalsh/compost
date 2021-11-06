package compost

import ShouldProbablyBeAMacroLibrary.selectDynamicImpl

trait Inspect[T] extends Selectable:
  //private val dummy = structureOf[T]
  inline def selectDynamic(name:String):Any = ${selectDynamicImpl('{name})}
