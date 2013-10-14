import collection.mutable.Stack
import org.specs2.mutable._

class ArrayParserTest extends Specification {
  val ap = new ArrayParser()

  "An empty array" should {
    "return the empty string" in {
      ap.findLongestString(Array()) must be("")
    }
  }
  "An array with one string" should {
    "return that string" in {
      ap.findLongestString(Array("hello")) must be("hello")
    }
  }
  "An array with two strings" should {
    "return the longest string" in {
      ap.findLongestString(Array("hello", "you")) must be("hello")
    }
  }
  "An array with two strings" should {
    "return the longest string regardless of order" in {
      ap.findLongestString(Array("you", "hello")) must be("hello")
    }
  }
}
