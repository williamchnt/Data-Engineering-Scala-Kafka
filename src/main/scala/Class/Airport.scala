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
    //println("\t\tla name data : " + data(4))
    new Airport(
      Utils.myToInt(data(0)),
      Utils.myToString(data(1)),
      Utils.myToString(data(2)),
      Utils.myToString(data(3)),
      Utils.myToFloat(data(4)),
      Utils.myToFloat(data(5)),
      Utils.myToInt(data(6)),
      Utils.myToString(data(7)),
      Utils.myToString(data(8)),
      Utils.myToString(data(9)),
      Utils.myToString(data(10)),
      Utils.myToString(data(11)),
      Utils.myToString(data(12)),
      Utils.myToString(data(13)),
      Utils.myToString(data(14)),
      Utils.myToString(data(15)),
      Utils.myToString(data(16)),
      Utils.myToString(data(17)),
    )
  }
}

