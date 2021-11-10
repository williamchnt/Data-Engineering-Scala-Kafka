package Class

import Utils.Utils

case class Airport(id: Option[Int],
                   ident: Option[String],
                   theType: Option[String],
                   name: Option[String],
                   latitudeDeg: Option[Float],
                   longitudeDeg: Option[Float],
                   elevationFit: Option[Int],
                   continent: Option[String],
                   isoCountry: Option[String],
                   isoRegion: Option[String],
                   municipality: Option[String],
                   scheduled_service: Option[String],
                   gpsCode : Option[String],
                   iataCode: Option[String],
                   localCode: Option[String],
                   homeLink: Option[String],
                   wikipediaLink: Option[String],
                   keywords : Option[String]
                  )

object Airport{
  def apply(line : String): Airport = {
    val data = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1)
    val utils = new Utils
    //println("\t\tla name data : " + data(4))
    new Airport(
      utils.myToInt(data(0)),
      utils.myToString(data(1)),
      utils.myToString(data(2)),
      utils.myToString(data(3)),
      utils.myToFloat(data(4)),
      utils.myToFloat(data(5)),
      utils.myToInt(data(6)),
      utils.myToString(data(7)),
      utils.myToString(data(8)),
      utils.myToString(data(9)),
      utils.myToString(data(10)),
      utils.myToString(data(11)),
      utils.myToString(data(12)),
      utils.myToString(data(13)),
      utils.myToString(data(14)),
      utils.myToString(data(15)),
      utils.myToString(data(16)),
      utils.myToString(data(17)),
    )
  }
}

