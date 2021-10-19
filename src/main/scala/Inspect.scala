package compost


trait Inspect[T] extends Selectable:
  //private val dummy = structureOf[T]
  def selectDynamic(name:String):Any = s"$name exists"
