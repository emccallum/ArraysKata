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
    if (arrayOfIntegers.length > 0) {
      val sumOfOdds: Int = sumOdds(arrayOfIntegers)
      val productOfEvens: Int = multiplyEvens(arrayOfIntegers)
      printer.println("Sum of odds: " + sumOfOdds)
      printer.println("Product of evens: " + productOfEvens)
    }
  }


  def multiplyEvens(arrayOfIntegers: Array[Int]): Int = {
    val productOfEvens = arrayOfIntegers.foldLeft(1) {
      (prod, thisInt) => {
        if ((thisInt % 2) == 0) prod * thisInt else prod
      }
    }
    productOfEvens
  }

  def sumOdds(arrayOfIntegers: Array[Int]): Int = {
    val sumOfOdds = arrayOfIntegers.foldLeft(0) {
      (sum, thisInt) => {
        if ((thisInt % 2) != 0) sum + thisInt else sum
      }
    }
    sumOfOdds
  }
}
