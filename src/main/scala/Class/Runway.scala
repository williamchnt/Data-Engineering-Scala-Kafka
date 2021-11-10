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
    val utils = new Utils
    //println("\t\tairportRef : " + data(1))
    new Runway(
      utils.myToInt(data(0)),
      utils.myToInt(data(1)),
      utils.myToString(data(2)),
      utils.myToString(data(3)),
      utils.myToInt(data(4)),
      utils.myToString(data(5)),
      utils.myToBoolean(data(6)),
      utils.myToBoolean(data(7)),
      utils.myToString(data(8)),
      utils.myToFloat(data(9)),
      utils.myToFloat(data(10)),
      utils.myToInt(data(11)),
      utils.myToFloat(data(12)),
      utils.myToInt(data(13)),
      utils.myToString(data(14)),
      utils.myToFloat(data(15)),
      utils.myToFloat(data(16)),
      utils.myToInt(data(17)),
      utils.myToFloat(data(18)),
      utils.myToInt(data(19)),
    )
  }
}
