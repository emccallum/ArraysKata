
import java.io.PrintStream
import org.specs2.mutable._
import org.specs2.mock.Mockito

class ArrayOfStringsTest extends Specification{
  val arrayParser = new ArrayParser()

  "An empty array" should {
    "return the empty string" in {
      arrayParser.findLongestString(Array()) must be("")
    }
  }
  "An array with one string" should {
    "return that string" in {
      arrayParser.findLongestString(Array("hello")) must be("hello")
    }
  }
  "An array with two strings" should {
    "return the longest string" in {
      arrayParser.findLongestString(Array("hello", "you")) must be("hello")
    }
  }
  "An array with two strings" should {
    "return the longest string regardless of order" in {
      arrayParser.findLongestString(Array("you", "hello")) must be("hello")
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

  class MultipleIntegerOperationsArrayTest extends Specification with Mockito{
    isolated
    val mockPrinter = mock[PrintStream]
    val arrayParser = new ArrayParser{
      override val printer = mockPrinter
    }

    "An empty array" should {
      "print nothing" in {
        arrayParser.sumOddsAndMultiplyEvens(Array())
        there was no(mockPrinter).println(anyString)
      }
    }

    "An array with one odd integer" should {
      "print that one odd integer" in {
        arrayParser.sumOddsAndMultiplyEvens(Array(1))
        there was one(mockPrinter).println("Sum of odds: " + 1)
      }
    }

    "An array with two odd integers" should {
      "print the sum of the integers" in {
        arrayParser.sumOddsAndMultiplyEvens(Array(1,3))
        there was one(mockPrinter).println("Sum of odds: " + 4)
      }
    }

    "An array with two odd integers and one even" should {
      "print the sum of the odd integers" in {
        arrayParser.sumOddsAndMultiplyEvens(Array(1,2,3))
        there was one(mockPrinter).println("Sum of odds: " + 4)
      }
    }

    "An array with two odd integers and two evens" should {
      "print the sum of the odd integers and product of evens" in {
        arrayParser.sumOddsAndMultiplyEvens(Array(1,2,3,4))
        there was one(mockPrinter).println("Sum of odds: " + 4)
        there was one(mockPrinter).println("Product of evens: " + 8)
      }
    }

  }


