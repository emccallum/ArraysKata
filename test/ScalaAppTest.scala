import collection.mutable.Stack
import org.specs2.mutable._



/**
 * Created with IntelliJ IDEA.
 * User: Thoughtworks
 * Date: 10/14/13
 * Time: 11:04 AM
 * To change this template use File | Settings | File Templates.
 */

class Specs2ExamplesSpec extends Specification {
  "The 'Hello world' string" should {
    "contain 11 characters" in {
      "Hello world" must have size(11)
    }
    "start with 'Hello'" in {
      "Hello world" must startWith("Hello")
    }
    "end with 'world'" in {
      "Hello world" must endWith("world")
    }
  }
}

class Specs2ExamplesSpec2 extends Specification {
  val ap = new ArrayParser()
  "The main method" should {
    "print hello world" in {
      ap.returnHelloWorld() must be("Hello, world!")
    }
  }
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
