import scala.annotation.tailrec
import scala.collection.MapView
import scala.io.BufferedSource
import scala.io.StdIn.readLine

object main extends App {
  val bufferedSource = io.Source.fromFile("data/airports.csv")
  print("Query or Reports: ")
  val option = readLine()

  print(option)

}
