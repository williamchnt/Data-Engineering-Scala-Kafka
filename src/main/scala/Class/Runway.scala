package Class

import Utils.Utils

case class Runway(id : Option[Int],
                  airportRef : Option[Int],
                  airportIdent: Option[String],
                  lengthFt : Option[String],
                  widthFt : Option[Int],
                  surface : Option[String],
                  lighted : Option[Boolean],
                  closed : Option[Boolean],
                  leIdent : Option[String],
                  leLatitudeDeg : Option[Float],
                  leLongitudeDeg : Option[Float],
                  leElevationFt : Option[Int],
                  leHeadingDegT : Option[Float],
                  leDisplacedThresholdFt : Option[Int],
                  heIdent : Option[String],
                  heLatitudeDeg : Option[Float],
                  heLongitudeDeg : Option[Float],
                  heElevationFt : Option[Int],
                  heHeadingDegT : Option[Float],
                  heDisplacedThresholdFt :Option[Int]
                 )

object Runway {
  def apply(line : String): Runway = {
    val data = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1)
    //println("\t\tairportRef : " + data(1))
    new Runway(
      Utils.myToInt(data(0)),
      Utils.myToInt(data(1)),
      Utils.myToString(data(2)),
      Utils.myToString(data(3)),
      Utils.myToInt(data(4)),
      Utils.myToString(data(5)),
      Utils.myToBoolean(data(6)),
      Utils.myToBoolean(data(7)),
      Utils.myToString(data(8)),
      Utils.myToFloat(data(9)),
      Utils.myToFloat(data(10)),
      Utils.myToInt(data(11)),
      Utils.myToFloat(data(12)),
      Utils.myToInt(data(13)),
      Utils.myToString(data(14)),
      Utils.myToFloat(data(15)),
      Utils.myToFloat(data(16)),
      Utils.myToInt(data(17)),
      Utils.myToFloat(data(18)),
      Utils.myToInt(data(19)),
    )
  }
}
