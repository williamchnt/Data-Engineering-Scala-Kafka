package Class

import Utils.Utils

case class Country(id : Option[Int],
                   code : Option[String],
                   name : Option[String],
                   continent : Option[String],
                   wikipediaLink : Option[String],
                   keywords : Option[String] )

object Country{
  def apply(line : String): Country = {
    val data = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1)
    val utils = new Utils
    new Country(
      utils.myToInt(data(0)),
      utils.myToString(data(1)),
      utils.myToString(data(2)),
      utils.myToString(data(3)),
      utils.myToString(data(4)),
      utils.myToString(data(5))
    )
  }
}


