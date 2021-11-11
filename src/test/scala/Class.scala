import Class.Airport
import Class.Country
import Class.Runway

class Class extends org.scalatest.FunSuite{
  test("testAirport"){
    val line = "6523,\"00A\",\"heliport\",\"Total Rf Heliport\",40.07080078125,-74.93360137939453,11,\"NA\"," +
      "\"US\",\"US-PA\",\"Bensalem\",\"no\",\"00A\",,\"00A\",,,"
    val airport = Airport(line)

    assert(airport!=null)
    assert(airport.id.get == 6523)
    assert(airport.ident.get.equals("\"00A\"") )
    assert(airport.theType.get.equals("\"heliport\""))
    assert(airport.name.get.equals("\"Total Rf Heliport\""))
    assert(airport.latitudeDeg.get == 40.07080078125)
    assert(airport.longitudeDeg.get == -74.93360137939453)
    assert(airport.elevationFit.get == 11)
    assert(airport.continent.get.equals("\"NA\""))
    assert(airport.isoCountry.get.equals("\"US\""))
    assert(airport.isoRegion.get.equals("\"US-PA\""))
    assert(airport.municipality.get.equals("\"Bensalem\""))
    assert(airport.scheduled_service.get.equals("\"no\""))
    assert(airport.gpsCode.get.equals("\"00A\""))
    assert(airport.iataCode.equals(None))
    assert(airport.localCode.get.equals("\"00A\""))
    assert(airport.homeLink.equals(None))
    assert(airport.wikipediaLink.equals(None))
    assert(airport.keywords.equals(None))
  }

  test("testCounty") {

    val line = "302672,\"AD\",\"Andorra\",\"EU\",\"http://en.wikipedia.org/wiki/Andorra\","
    val country = Country(line)

    assert(country!=null)
    assert(country.id.get == 302672)
    assert(country.code.get.equals("\"AD\""))
    assert(country.name.get.equals("\"Andorra\""))
    assert(country.continent.get.equals("\"EU\""))
    assert(country.wikipediaLink.get.equals("\"http://en.wikipedia.org/wiki/Andorra\""))
    assert(country.keywords.equals(None))

  }

  test("testRunway") {

    val line = "269408,6523,\"00A\",80,80,\"ASPH-G\",1,0,\"H1\",,,,,,,,,,,"
    val runway = Runway(line)

    assert(runway!=null)
    assert(runway.id.get == 269408)
    assert(runway.airportRef.get == 6523)
    assert(runway.airportIdent.get.equals("\"00A\""))
    assert(runway.lengthFt.get.equals("80"))
    assert(runway.widthFt.get == 80)
    assert(runway.surface.get.equals("\"ASPH-G\""))
    assert(runway.lighted.get == true)
    assert(runway.closed.get == false)
    assert(runway.leIdent.get.equals("\"H1\""))
    assert(runway.leLatitudeDeg.equals(None))
    assert(runway.leLongitudeDeg.equals(None))
    assert(runway.leElevationFt.equals(None))
    assert(runway.leHeadingDegT.equals(None))
    assert(runway.leDisplacedThresholdFt.equals(None))
    assert(runway.heIdent.equals(None))
    assert(runway.heLatitudeDeg.equals(None))
    assert(runway.heLongitudeDeg.equals(None))
    assert(runway.heElevationFt.equals(None))
    assert(runway.heHeadingDegT.equals(None))
    assert(runway.heDisplacedThresholdFt.equals(None))

  }
}
