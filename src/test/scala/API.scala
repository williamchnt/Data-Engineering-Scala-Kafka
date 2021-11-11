import Class.Airport
import Class.Country
import Class.Runway
import Utils.API
import Utils.Utils

class API extends org.scalatest.FunSuite{

  test("testGetAirportsInCountry") {
    //given
    val a1 = new Airport(id=Some(1),
      ident=None,
      theType= None,
      name= None,
      latitudeDeg = None,
      longitudeDeg = None,
      elevationFit = None,
      continent = None,
      isoCountry = Some("FR"),
      isoRegion = None,
      municipality = None,
      scheduled_service = None,
      gpsCode  = None,
      iataCode = None,
      localCode = None,
      homeLink = None,
      wikipediaLink = None,
      keywords  = None)

    val a2 = new Airport(id=Some(2),
      ident=None,
      theType= None,
      name= None,
      latitudeDeg = None,
      longitudeDeg = None,
      elevationFit = None,
      continent = None,
      isoCountry = Some("US"),
      isoRegion = None,
      municipality = None,
      scheduled_service = None,
      gpsCode  = None,
      iataCode = None,
      localCode = None,
      homeLink = None,
      wikipediaLink = None,
      keywords  = None)

    val a3 = new Airport(id=Some(3),
      ident=None,
      theType= None,
      name= None,
      latitudeDeg = None,
      longitudeDeg = None,
      elevationFit = None,
      continent = None,
      isoCountry = Some("FR"),
      isoRegion = None,
      municipality = None,
      scheduled_service = None,
      gpsCode  = None,
      iataCode = None,
      localCode = None,
      homeLink = None,
      wikipediaLink = None,
      keywords  = None)

    val airports = List(a1, a2, a3 )

    //when
    val actual = API.getAirportsInCountry("FR", airports)

    //then
    assert(actual!= null)
    assert(actual.size == 2)
    assert(actual.head.id.get==1)
    assert(actual(1).id.get==3)
  }

  test("testConvertFileToAirports") {
    val file = "src/test/ressource/testAirport.csv"
    val actual = API.convertFileToAirports(file).next()
    assert( actual.id.get == 6523 )
    assert( actual.ident.get.equals("\"00A\""))
    assert( actual.theType.get.equals("\"heliport\"") )
    assert( actual.name.get.equals("\"Total Rf Heliport\"") )
    assert( actual.latitudeDeg.get == 40.07080078125 )
    assert( actual.longitudeDeg.get == -74.93360137939453 )
    assert( actual.elevationFit.get == 11 )
    assert( actual.continent.get.equals("\"NA\"") )
    assert( actual.isoCountry.get.equals("\"US\"") )
    assert( actual.isoRegion.get.equals("\"US-PA\"") )
    assert( actual.municipality.get.equals("\"Bensalem\"") )
    assert( actual.scheduled_service.get.equals("\"no\"") )
    assert( actual.gpsCode.get.equals("\"00A\"") )
    assert( actual.iataCode.isEmpty )
    assert( actual.localCode.get.equals("\"00A\"") )
    assert( actual.homeLink.isEmpty )
    assert( actual.wikipediaLink.isEmpty )
    assert( actual.keywords.isEmpty )
  }

  test("testGetCodeFromName") {
    //given
    val c1 = new Country(id=Some(1),
      code=Some("code_1"),
      name=Some("name_1"),
      continent=None,
      wikipediaLink=None,
      keywords=None )

    val c2 = new Country(id=Some(2),
      code=Some("code_2"),
      name=Some("name_2"),
      continent=None,
      wikipediaLink=None,
      keywords=None )

    val c3 = new Country(id=Some(3),
      code=Some("code_3"),
      name=Some("name_3"),
      continent=None,
      wikipediaLink=None,
      keywords=None )

    val countries = List(c1, c2, c3)

    //when
    val actual = API.getCodeFromName("name_2", countries)

    //then
    assert(actual.get.equals("code_2"))
  }



  test("testConvertFileToCountries") {
    val file = "src/test/ressource/testContries.csv"
    val actual = API.convertFileToCountries(file).next()
    assert( actual.id.get == 302672 )
    assert( actual.code.get.equals("\"AD\""))
    assert( actual.name.get.equals("\"Andorra\"") )
    assert( actual.continent.get.equals("\"EU\"") )
    assert( actual.wikipediaLink.get.equals("\"http://en.wikipedia.org/wiki/Andorra\"") )
    assert( actual.keywords.isEmpty )

  }

  test("testIsStringCountryCode") {
    assert(API.isStringCountryCode("FR"))
    assert(! API.isStringCountryCode("France"))
    assert(! API.isStringCountryCode("fr"))
    assert(! API.isStringCountryCode("FRANCE"))
  }

  test("testQueryName") {
    //given
    val a1 = new Airport(id=Some(1),
      ident=Some("ident_1"),
      theType= None,
      name= Some("airport_1"),
      latitudeDeg = None,
      longitudeDeg = None,
      elevationFit = None,
      continent = None,
      isoCountry = Some("FR"),
      isoRegion = None,
      municipality = None,
      scheduled_service = None,
      gpsCode  = None,
      iataCode = None,
      localCode = None,
      homeLink = None,
      wikipediaLink = None,
      keywords  = None)

    val a2 = new Airport(id=Some(2),
      ident=Some("ident_2"),
      theType= None,
      name= Some("airport_2"),
      latitudeDeg = None,
      longitudeDeg = None,
      elevationFit = None,
      continent = None,
      isoCountry = Some("US"),
      isoRegion = None,
      municipality = None,
      scheduled_service = None,
      gpsCode  = None,
      iataCode = None,
      localCode = None,
      homeLink = None,
      wikipediaLink = None,
      keywords  = None)

    val a3 = new Airport(id=Some(3),
      ident=Some("ident_3"),
      theType= None,
      name= Some("airport_3"),
      latitudeDeg = None,
      longitudeDeg = None,
      elevationFit = None,
      continent = None,
      isoCountry = Some("FR"),
      isoRegion = None,
      municipality = None,
      scheduled_service = None,
      gpsCode  = None,
      iataCode = None,
      localCode = None,
      homeLink = None,
      wikipediaLink = None,
      keywords  = None)

    val airports = List(a1, a2, a3)


    val c1 = new Country(id=Some(1),
      code=Some("FR"),
      name=Some("name_1"),
      continent=None,
      wikipediaLink=None,
      keywords=None )

    val countries = List(c1)

    val r1 = new Runway(id = Some(1),
      airportRef = None,
      airportIdent= Some("ident_3"),
      lengthFt = None,
      widthFt = None,
      surface = None,
      lighted = None,
      closed = None,
      leIdent = None,
      leLatitudeDeg = None,
      leLongitudeDeg = None,
      leElevationFt = None,
      leHeadingDegT = None,
      leDisplacedThresholdFt = None,
      heIdent = None,
      heLatitudeDeg = None,
      heLongitudeDeg = None,
      heElevationFt = None,
      heHeadingDegT = None,
      heDisplacedThresholdFt = None
    )

    val runways = List(r1)

    //when
    val actual = API.queryName("name_1", countries, airports, runways)

    //then
    assert(actual!=null)
    assert(actual.contains(Some("airport_1")) )
    assert(actual( Some("airport_1") ).equals(List()))
    assert(actual.contains(Some("airport_3")) )
    assert(actual( Some("airport_3") ).equals(List("id = 1")))

  }

  test("testQueryCode") {
    //given
    val a1 = new Airport(id=Some(1),
      ident=Some("ident_1"),
      theType= None,
      name= Some("airport_1"),
      latitudeDeg = None,
      longitudeDeg = None,
      elevationFit = None,
      continent = None,
      isoCountry = Some("FR"),
      isoRegion = None,
      municipality = None,
      scheduled_service = None,
      gpsCode  = None,
      iataCode = None,
      localCode = None,
      homeLink = None,
      wikipediaLink = None,
      keywords  = None)

    val a2 = new Airport(id=Some(2),
      ident=Some("ident_2"),
      theType= None,
      name= Some("airport_2"),
      latitudeDeg = None,
      longitudeDeg = None,
      elevationFit = None,
      continent = None,
      isoCountry = Some("US"),
      isoRegion = None,
      municipality = None,
      scheduled_service = None,
      gpsCode  = None,
      iataCode = None,
      localCode = None,
      homeLink = None,
      wikipediaLink = None,
      keywords  = None)

    val a3 = new Airport(id=Some(3),
      ident=Some("ident_3"),
      theType= None,
      name= Some("airport_3"),
      latitudeDeg = None,
      longitudeDeg = None,
      elevationFit = None,
      continent = None,
      isoCountry = Some("FR"),
      isoRegion = None,
      municipality = None,
      scheduled_service = None,
      gpsCode  = None,
      iataCode = None,
      localCode = None,
      homeLink = None,
      wikipediaLink = None,
      keywords  = None)

    val airports = List(a1, a2, a3)


    val r1 = new Runway(id = Some(1),
      airportRef = None,
      airportIdent= Some("ident_3"),
      lengthFt = None,
      widthFt = None,
      surface = None,
      lighted = None,
      closed = None,
      leIdent = None,
      leLatitudeDeg = None,
      leLongitudeDeg = None,
      leElevationFt = None,
      leHeadingDegT = None,
      leDisplacedThresholdFt = None,
      heIdent = None,
      heLatitudeDeg = None,
      heLongitudeDeg = None,
      heElevationFt = None,
      heHeadingDegT = None,
      heDisplacedThresholdFt = None
    )

    val runways = List(r1)

    //when
    val actual = API.queryCode("FR", airports, runways)

    //then
    assert(actual!=null)
    println("\n\n\n uuuuuuuuu "+actual)
    assert(actual.contains(Some("airport_1")) )
    assert(actual( Some("airport_1") ).equals(List()))
    assert(actual.contains(Some("airport_3")) )
    assert(actual( Some("airport_3") ).equals(List("id = 1")))
  }

  test("testMyToBoolean") {
    val s = "1"
    assert(Utils.myToBoolean(s).equals(Some(true)))
  }

  test("testMyToString") {
    val s = "hello"
    assert(utils.myToString(s).equals(Some("hello")))
  }

  test("testMyToFloat") {
    val s = "1.0"
    assert(utils.myToFloat(s).equals(Some(1.0)))
  }

  test("testMyToInt") {
    val s = "711"
    assert(utils.myToInt(s).equals(Some(711)))
  }
}
