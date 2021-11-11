import Utils.API
import Class.Airport
import Class.Runway
import Class.Country

object main extends App {

  println("Selectionner votre option: \n1 - Query \n2 - Reports \nAnything - Quitter")
  val option = scala.io.StdIn.readLine()
  val airports = API.convertFileToAirports("data/Airports.csv").toList
  val countries = API.convertFileToCountries("data/Countries.csv").toList
  val runways = API.convertFileToRunways("data/runways.csv").toList

  Start(option,airports,countries,runways)
  def Start(option : String,airports: List[Airport], countries: List[Country], runways: List[Runway]): Unit = option match {
    case "1" => Query(airports,countries,runways)
    case "2" => Reports(airports,countries,runways)
    case _ => println("Fin du programme")
   }






  def Reports(airports: List[Airport], countries: List[Country], runways: List[Runway]): Unit =  {
    println("Quelles informations souhaitez vous : \n1 - 10 countries with highest number of airports \n2 - 10 countries with lowest number of airports \n3 - Type of runways per country \n4 - The top 10 most common runway latitude \nAnythings - Back to the menu")

    val input = scala.io.StdIn.readLine()
    input match {
      case "1" =>
        val result = API.getTenCountriesHighestNumberOfAirports(airports)
        println(result)

        println("Selectionner votre option: \n1 - Query \n2 - Reports \n Anything - Quitter")
        val option = scala.io.StdIn.readLine()
        Start(option,airports,countries,runways)
      case "2" =>
        val result = API.getTenCountriesLowestNumberOfAirports(airports)
        println(result)

        println("Selectionner votre option: \n1 - Query \n2 - Reports \n Anything - Quitter")
        val option = scala.io.StdIn.readLine()
        Start(option,airports,countries,runways)
      case "3" =>
        val result = API.getTypeOfRunwaysPerCountry(airports, runways)
        println(result.mkString("\n"))

        println("Selectionner votre option: \n1 - Query \n2 - Reports \n Anything - Quitter")
        val option = scala.io.StdIn.readLine()
        Start(option,airports,countries,runways)
      case "4" =>
        val result = API.getTenMostCommonRunwaysLatitude(runways)
        println(result)

        println("Selectionner votre option: \n1 - Query \n2 - Reports \n Anything - Quitter")
        val option = scala.io.StdIn.readLine()
        Start(option,airports,countries,runways)
      case _ =>
        println("Selectionner votre option: \n1 - Query \n2 - Reports \n Anything - Quitter")
        val option = scala.io.StdIn.readLine()
        Start(option,airports,countries,runways)
    }
  }








  def Query(airports: List[Airport], countries: List[Country], runways: List[Runway]): Unit =  {
    println("Query")
    println("Entrez le code ou le nom de la country" )
    val input = scala.io.StdIn.readLine()
    if ( API.isStringCountryCode(input) ){
      val result = API.queryCode("\""+input+"\"", airports, runways)
      println(result.map{case (k,v) => k + " : "+ v }.mkString("\n")  )

      println("Selectionner votre option: \n1 - Query \n2 - Reports \n Anything - Quitter")
      val option = scala.io.StdIn.readLine()
      Start(option,airports,countries,runways)
    }else{
      val result = API.queryName("\""+input+"\"", countries, airports, runways)
      println(result)


      println("Selectionner votre option: \n1 - Query \n2 - Reports \n Anything - Quitter")
      val option = scala.io.StdIn.readLine()
      Start(option,airports,countries,runways)
    }
  }
}
