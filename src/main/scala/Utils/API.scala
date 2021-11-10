<<<<<<< HEAD
package Utils
import Class.Airport
import Class.Runway
import Class.Country

import scala.annotation.tailrec
import scala.collection.immutable.ListMap

object API {
  def convertFileToAirports(file : String): Iterator[Airport] = {
    scala.io.Source.fromFile(file, "utf-8").getLines().drop(1) map( l => Airport(l))
  }

  def getAirportsInCountry(countryCode: String, airports: List[Airport]) : List[Airport] = {
    //println(airports.toList )
    airports.filter( a => a.isoCountry match{
      case None => false
      case Some(value) => value.equals(countryCode)
    } )
  }

  def convertFileToCountries(filePath : String): Iterator[Country] = {
    scala.io.Source.fromFile(filePath, "utf-8").getLines().drop(1) map(l => Country(l))
  }

  def isStringCountryCode(s: String): Boolean = {
    s.equals(s.toUpperCase()) && s.length==2
  }

  def getCodeFromName(countryName : String, countries: List[Country]): Option[String] = {
    val countryResult = countries.find( c => c.name match{
      case None => false
      case Some(value) => value.equals(countryName)
    }  )

    countryResult match {
      case None => None
      case Some(x) => x.code
    }
  }
  def getTenCountriesHighestNumberOfAirports(airports : List[Airport]): Map[String, Int] = {
    val mapOfNumber = createMapOfNumberAirports(airports)

    ListMap(mapOfNumber.toSeq.sortWith(_._2 > _._2):_*)
      .take(10)
  }

  def getTenCountriesLowestNumberOfAirports(airports : List[Airport]): Map[String, Int] = {
    val mapOfNumber = createMapOfNumberAirports(airports)

    ListMap(mapOfNumber.toSeq.sortWith(_._2 < _._2):_*)
      .take(10)
  }


  private def createMapOfNumberAirports(airports : List[Airport]): Map[String, Int] = {
    @tailrec
    def aux(airports : List[Airport], acc: Map[String, Int] ): Map[String, Int] = airports match {
      case Nil => acc
      case x :: xs =>
        val key = x.isoCountry.get
        if(acc.contains(key)){
          val nb = acc(key)
          val acc2 = acc.-(key)
          aux( xs, acc2 + (key -> (nb+1)) )
        }else{
          aux( xs, acc + (key -> 1) )
        }
    }

    aux(airports, Map[String,Int]())

  }


  def getTypeOfRunwaysPerCountry(airports : List[Airport], runways: List[Runway]): Map[ String,Set[String] ] = {
    @tailrec
    def aux(airports : List[Airport], runways: List[Runway], acc: Map[ String,Set[String] ] ): Map[ String,Set[String] ] = runways match {
      case Nil => acc
      case x :: xs =>
        x.surface match{
          case None => aux(airports, xs, acc)
          case Some(_) =>
            val airportOfRunway = airports.find(a => a.ident.equals(x.airportIdent))
            airportOfRunway match {
              case None => aux(airports, xs, acc)
              case Some(value) =>
                val key = value.isoCountry.get
                if (acc.contains(key)) {
                  val setOfCountry = acc(key)
                  val acc2 = acc.-(key)
                  aux(airports, xs, acc2 + (key -> (setOfCountry + x.surface.get )))
                } else {
                  aux(airports, xs, acc + (key -> (Set() + x.surface.get )))
                }
            }
        }
    }


    aux(airports, runways, Map[String,Set[String]]())
  }

  def getTenMostCommonRunwaysLatitude(runways: List[Runway]): Set[String] = {
    @tailrec
    def aux(runways: List[Runway], acc: Map[String, Int]) : Map[String,Int] = runways match {
      case Nil => acc
      case x :: xs =>
        val key = x.leIdent
        key match {
          case None => aux(xs, acc)
          case Some(keyValue) =>
            if(acc.contains(keyValue)){
              val nb = acc(keyValue)
              val acc2 = acc.-(keyValue)
              aux(xs, acc2 + (keyValue -> (nb+1)) )
            }else{
              aux( xs, acc + (keyValue -> 1) )
            }
        }
    }


    val frequencyMap = aux(runways, Map[String,Int]())
    ListMap(frequencyMap.toSeq.sortWith(_._2 > _._2): _*)
      .take(10).keys
      .toSet
  }

  def convertFileToRunways(file : String): Iterator[Runway] = {
    scala.io.Source.fromFile(file, "utf-8").getLines().drop(1) map( l => Runway(l))
  }


  def getRunwaysInAirportList(airports: List[ (Option[String],Option[String])], runways: List[Runway]): Map[Option[String], List[String]] = {
    @tailrec
    def aux(airports: List[ (Option[String],Option[String]) ], runways: List[Runway], acc: Map[Option[String], List[String]] ): Map[Option[String], List[String]] = airports match{
      case Nil => acc
      case ( ident, name ) :: xs =>
        aux(xs, runways, acc + ( name -> getRunwaysInAirport(ident, runways) ) )
    }
    aux(airports, runways, Map[Option[String], List[String]]())
  }

  private def getRunwaysInAirport(airportIdent: Option[String], runways: List[Runway] ) : List[String] = {
    runways.filter( r => r.airportIdent match {
      case None => false
      case Some(value) => value.equals(airportIdent.get)
    }).map(r => "id = " + r.id.get)
  }

  //todo transform the Map into a QueryResponse

  def queryCode(countryCode : String, airports: List[Airport], runways: List[Runway]) : Map[Option[String], List[String]] = {
    val airportsInCountry =  API.getAirportsInCountry(countryCode, airports)
    //println("airports : " +airportsInCountry)
    API.getRunwaysInAirportList( airportsInCountry.map(a => (a.ident, a.name) ), runways)
  }


  def queryName(countryName : String, countries: List[Country], airports: List[Airport], runways: List[Runway]) : Map[Option[String], List[String]] = {
    val code = API.getCodeFromName(countryName, countries)
    code match {
      case None => Map[Option[String], List[String]]()
      case Some(codeValue) => queryCode(codeValue, airports, runways)
    }
  }
}
=======
package Utils
import Class.Airport
import Class.Runway
import Class.Country

import scala.annotation.tailrec
import scala.collection.immutable.ListMap

object API {
  def convertFileToAirports(file : String): Iterator[Airport] = {
    scala.io.Source.fromFile(file, "utf-8").getLines().drop(1) map( l => Airport(l))
  }

  def getAirportsInCountry(countryCode: String, airports: List[Airport]) : List[Airport] = {
    //println(airports.toList )
    airports.filter( a => a.isoCountry match{
      case None => false
      case Some(value) => value.equals(countryCode)
    } )
  }

  def convertFileToCountries(filePath : String): Iterator[Country] = {
    scala.io.Source.fromFile(filePath, "utf-8").getLines().drop(1) map(l => Country(l))
  }

  def isStringCountryCode(s: String): Boolean = {
    s.equals(s.toUpperCase()) && s.length==2
  }

  def getCodeFromName(countryName : String, countries: List[Country]): Option[String] = {
    val countryResult = countries.find( c => c.name match{
      case None => false
      case Some(value) => value.equals(countryName)
    }  )

    countryResult match {
      case None => None
      case Some(x) => x.code
    }
  }
  def getTenCountriesHighestNumberOfAirports(airports : List[Airport]): Map[String, Int] = {
    val mapOfNumber = createMapOfNumberAirports(airports)

    ListMap(mapOfNumber.toSeq.sortWith(_._2 > _._2):_*)
      .take(10)
  }

  def getTenCountriesLowestNumberOfAirports(airports : List[Airport]): Map[String, Int] = {
    val mapOfNumber = createMapOfNumberAirports(airports)

    ListMap(mapOfNumber.toSeq.sortWith(_._2 < _._2):_*)
      .take(10)
  }


  private def createMapOfNumberAirports(airports : List[Airport]): Map[String, Int] = {
    @tailrec
    def aux(airports : List[Airport], acc: Map[String, Int] ): Map[String, Int] = airports match {
      case Nil => acc
      case x :: xs =>
        val key = x.isoCountry.get
        if(acc.contains(key)){
          val nb = acc(key)
          val acc2 = acc.-(key)
          aux( xs, acc2 + (key -> (nb+1)) )
        }else{
          aux( xs, acc + (key -> 1) )
        }
    }

    aux(airports, Map[String,Int]())

  }


  def getTypeOfRunwaysPerCountry(airports : List[Airport], runways: List[Runway]): Map[ String,Set[String] ] = {
    @tailrec
    def aux(airports : List[Airport], runways: List[Runway], acc: Map[ String,Set[String] ] ): Map[ String,Set[String] ] = runways match {
      case Nil => acc
      case x :: xs =>
        x.surface match{
          case None => aux(airports, xs, acc)
          case Some(_) =>
            val airportOfRunway = airports.find(a => a.ident.equals(x.airportIdent))
            airportOfRunway match {
              case None => aux(airports, xs, acc)
              case Some(value) =>
                val key = value.isoCountry.get
                if (acc.contains(key)) {
                  val setOfCountry = acc(key)
                  val acc2 = acc.-(key)
                  aux(airports, xs, acc2 + (key -> (setOfCountry + x.surface.get )))
                } else {
                  aux(airports, xs, acc + (key -> (Set() + x.surface.get )))
                }
            }
        }
    }


    aux(airports, runways, Map[String,Set[String]]())
  }

  def getTenMostCommonRunwaysLatitude(runways: List[Runway]): Set[String] = {
    @tailrec
    def aux(runways: List[Runway], acc: Map[String, Int]) : Map[String,Int] = runways match {
      case Nil => acc
      case x :: xs =>
        val key = x.leIdent
        key match {
          case None => aux(xs, acc)
          case Some(keyValue) =>
            if(acc.contains(keyValue)){
              val nb = acc(keyValue)
              val acc2 = acc.-(keyValue)
              aux(xs, acc2 + (keyValue -> (nb+1)) )
            }else{
              aux( xs, acc + (keyValue -> 1) )
            }
        }
    }


    val frequencyMap = aux(runways, Map[String,Int]())
    ListMap(frequencyMap.toSeq.sortWith(_._2 > _._2): _*)
      .take(10).keys
      .toSet
  }

  def convertFileToRunways(file : String): Iterator[Runway] = {
    scala.io.Source.fromFile(file, "utf-8").getLines().drop(1) map( l => Runway(l))
  }


  def getRunwaysInAirportList(airports: List[ (Option[String],Option[String])], runways: List[Runway]): Map[Option[String], List[String]] = {
    @tailrec
    def aux(airports: List[ (Option[String],Option[String]) ], runways: List[Runway], acc: Map[Option[String], List[String]] ): Map[Option[String], List[String]] = airports match{
      case Nil => acc
      case ( ident, name ) :: xs =>
        aux(xs, runways, acc + ( name -> getRunwaysInAirport(ident, runways) ) )
    }
    aux(airports, runways, Map[Option[String], List[String]]())
  }

  private def getRunwaysInAirport(airportIdent: Option[String], runways: List[Runway] ) : List[String] = {
    runways.filter( r => r.airportIdent match {
      case None => false
      case Some(value) => value.equals(airportIdent.get)
    }).map(r => "id = " + r.id.get)
  }

  //todo transform the Map into a QueryResponse

  def queryCode(countryCode : String, airports: List[Airport], runways: List[Runway]) : Map[Option[String], List[String]] = {
    val airportsInCountry =  API.getAirportsInCountry(countryCode, airports)
    //println("airports : " +airportsInCountry)
    API.getRunwaysInAirportList( airportsInCountry.map(a => (a.ident, a.name) ), runways)
  }


  def queryName(countryName : String, countries: List[Country], airports: List[Airport], runways: List[Runway]) : Map[Option[String], List[String]] = {
    val code = API.getCodeFromName(countryName, countries)
    code match {
      case None => Map[Option[String], List[String]]()
      case Some(codeValue) => queryCode(codeValue, airports, runways)
    }
  }
}
>>>>>>> 157a7a42ff56b87554283f9c9374d6d7ff562807
