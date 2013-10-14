/**
 * Created with IntelliJ IDEA.
 * User: Thoughtworks
 * Date: 10/14/13
 * Time: 12:39 PM
 * To change this template use File | Settings | File Templates.
 */
class ArrayParser {

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

}
