import scala.annotation.tailrec
import scala.collection.MapView
import scala.io.BufferedSource
import scala.io.StdIn.readLine

object main extends App {
  val airports = io.Source.fromFile("data/airports.csv","utf-8").getLines
  print(airports)
  print("Query or Reports (Q or R): ")
  val option = readLine()

  print(option)

}
