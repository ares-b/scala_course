package basics

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class SimpleFunctionsTest extends AnyFlatSpec with should.Matchers {
  val simpleFunctions = SimpleFunctions

  "A firstFunction" should "return the Int value if the Boolean is true" in {
    simpleFunctions.firstFunction(10, 1.5D, aBoolean = true) shouldBe 10
  }

  "A firstFunction" should "return the Double value casted to Int if the Boolean is false" in {
    simpleFunctions.firstFunction(10, 34.5D, aBoolean = true) shouldBe 34
  }

  "A secondFunction" should "return 18 if Given(13, 'Hello', str.size)" in {
    simpleFunctions.secondFunction(13, "Hello", (str: String) => str.length) shouldBe 18
  }

}
