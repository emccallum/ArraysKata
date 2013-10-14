import java.io.PrintStream

class ArrayParser {
  val printer = new PrintStream(System.out)

  def findLongestString(arrayOfStrings: Array[String]): String = {
    if (arrayOfStrings.length == 0) ""
    else {
      var currentLongestString = arrayOfStrings(0)
      for (str <- arrayOfStrings)
        if (str.length > currentLongestString.length)
          currentLongestString = str
      currentLongestString
    }
  }

  def printOddIntegers(arrayOfIntegers: Array[Int]) {
    if (arrayOfIntegers.length > 0)
      for (num <- arrayOfIntegers)
        if (num % 2 != 0)
          printer.println(num)
  }

  def sumOddsAndMultiplyEvens(arrayOfIntegers: Array[Int]) {
    if (arrayOfIntegers.length > 0)
      printer.println(arrayOfIntegers.sum)
  }

}
