
import java.io.PrintStream
import org.specs2.mutable._
import org.specs2.mock.Mockito

class ArrayOfStringsTest extends Specification{
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

class ArrayOfIntegersTest extends Specification with Mockito {
  isolated
  val mockPrinter = mock[PrintStream]
  val arrayParser = new ArrayParser{
    override val printer = mockPrinter
  }
  "An empty array" should {
    "not print anything" in {
      arrayParser.printOddIntegers(Array())
      there was no(mockPrinter).println(anyInt)
    }
  }
  "An array with one odd integer" should {
    "print that integer" in {
      arrayParser.printOddIntegers(Array(1))
      there was one(mockPrinter).println(1)
    }
  }
  "An array with one even integer" should {
    "not print that integer" in {
      arrayParser.printOddIntegers(Array(2))
      there was no(mockPrinter).println(anyInt)
    }
  }
  "An array with one even, one odd integer" should {
    "print only the odd integer" in {
      arrayParser.printOddIntegers(Array(2, 1))
      there was no(mockPrinter).println(2)
      there was one(mockPrinter).println(1)
    }
  }

  "An array with multiple odd integers" should {
    "print only the odd integers" in {
      arrayParser.printOddIntegers(Array(2, 1, 3, 4))
      there was no(mockPrinter).println(2)
      there was no(mockPrinter).println(4)
      there was one(mockPrinter).println(1)
      there was one(mockPrinter).println(3)
    }
  }

}
