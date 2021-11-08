import scala.annotation.tailrec
import scala.collection.MapView
import scala.io.BufferedSource
import scala.io.StdIn.readLine
import Utils.API

object main extends App {
  println("Sélectionner votre option:" +
    "\n1 - Query" +
    "\n2 - Reports" +
    "\nAnything - Quitter")
  val option = scala.io.StdIn.readLine()

  Start(option)
  def Start(option : String) = option match {
    case "1" => Query()
    case "2" => Reports()
    case _ => println("Fin du programme")
   }

  val airports = API.convertFileToAirports("resources/airports.csv")

  def Reports() =  {
    println("Reports")
  }

  def Query() =  {
    println("Query")
  }
}
