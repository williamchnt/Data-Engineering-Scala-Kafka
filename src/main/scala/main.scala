import scala.annotation.tailrec
import scala.collection.MapView
import scala.io.BufferedSource
import scala.io.StdIn.readLine

object main extends App {
  //val airports = model.LoadAirports
  //println(airports.take(1).next())
  println("Query or Reports (Q or R): ")
  val option = readLine()
  
  Start(option)
  def Start(option : String) = option match {
    case "Q" => Query()
    case "R" => Reports()
    case _ => println("Commande inconnue")
   }

  def Reports() =  {
    println("Reports")
  }

  def Query() =  {
    println("Query")
  }
}
