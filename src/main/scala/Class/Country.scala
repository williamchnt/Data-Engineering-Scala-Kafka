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
    new Country(
      Utils.myToInt(data(0)),
      Utils.myToString(data(1)),
      Utils.myToString(data(2)),
      Utils.myToString(data(3)),
      Utils.myToString(data(4)),
      Utils.myToString(data(5))
    )
  }
}


