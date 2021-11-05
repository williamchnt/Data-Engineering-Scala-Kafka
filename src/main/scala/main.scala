import scala.annotation.tailrec
import scala.collection.MapView
import scala.io.BufferedSource
import scala.io.StdIn.readLine

object main extends App {
  val airports = model.LoadAirports
  print(airports.take(1).next())
  print("Query or Reports (Q or R): ")
  val option = readLine()
}
