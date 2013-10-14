import java.io.PrintStream

/**
 * Created with IntelliJ IDEA.
 * User: Thoughtworks
 * Date: 10/14/13
 * Time: 12:39 PM
 * To change this template use File | Settings | File Templates.
 */
class ArrayParser {
  val printer = new PrintStream(System.out)

  def findLongestString(arr: Array[String]): String = {
    if (arr.length == 0) ""
    else {
      var currentLongestString = arr(0)
      for (str <- arr)
        if (str.length > currentLongestString.length)
          currentLongestString = str
      currentLongestString
    }
  }

  def printOddIntegers(arr: Array[Int]) {
    if (arr.length > 0)
      for (num <- arr)
        if (num % 2 != 0)
          printer.println(num)
  }

}
