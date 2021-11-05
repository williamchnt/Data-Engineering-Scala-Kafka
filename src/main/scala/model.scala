object model {
  def LoadAirports():Iterator[Array[String]] = {
    val airports: List[String] = List()
    val Buffured = io.Source.fromFile("data/airports.csv", "utf-8").getLines().drop(1).map(_.split(","))
    Buffured
  }

  def LoadCountries():Iterator[Array[String]] = {
    val airports: List[String] = List()
    val Buffured = io.Source.fromFile("data/countries.csv", "utf-8").getLines().drop(1).map(_.split(","))
    Buffured
  }

  def LoadRunways():Iterator[Array[String]] = {
    val airports: List[String] = List()
    val Buffured = io.Source.fromFile("data/runways.csv", "utf-8").getLines().drop(1).map(_.split(","))
    Buffured
  }
}
