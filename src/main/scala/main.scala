import scala.annotation.tailrec
import scala.collection.MapView
import scala.io.BufferedSource
import scala.io.StdIn.readLine
import Utils.API
import Class.Airport
import Class.Runway
import Class.Country
import main.{airports, countries, runways}

object main extends App {
  println("Sélectionner votre option:" +
    "\n1 - Query" +
    "\n2 - Reports" +
    "\nAnything - Quitter")
  val option = scala.io.StdIn.readLine()
  val airports = API.convertFileToAirports("data/airports.csv").toList
  val countries = API.convertFileToCountries("data/countries.csv").toList
  val runways = API.convertFileToRunways("data/runways.csv").toList

  Start(option,airports,countries,runways)
  def Start(option : String,airports: List[Airport], countries: List[Country], runways: List[Runway]) = option match {
    case "1" => Query(airports,countries,runways)
    case "2" => Reports(airports,countries,runways)
    case _ => println("Fin du programme")
   }

  def Reports(airports: List[Airport], countries: List[Country], runways: List[Runway]) =  {
    println("Reports")
  }

  def Query(airports: List[Airport], countries: List[Country], runways: List[Runway]) =  {
    println("Query")
  }
}
