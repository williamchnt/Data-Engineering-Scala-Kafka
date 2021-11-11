package Utils

object Utils {

  def myToInt(s: String): Option[Int] = {
    if (s.isBlank){
      None
    }else{
      Some(s.toInt)
    }
  }

  def myToFloat(s: String): Option[Float] = {
    if (s.isBlank){
      None
    }else{
      Some(s.toFloat)
    }
  }

  def myToString(s: String): Option[String] = {
    if (s.isBlank){
      None
    }else{
      Some(s)
    }
  }

  //todo voir si au lieu de faire une option on ne
  // retournerait pas un false au lieu d'un None
  // donc pas d'Option

  def myToBoolean(s: String): Option[Boolean] = {
    if (s.isBlank){
      None
    }else{
      s match {
        case "1" => Some(true)
        case "0" => Some(false)
      }
    }
  }


}
