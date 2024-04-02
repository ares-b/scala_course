package collections

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class MapsTest extends AnyFlatSpec with should.Matchers {

  val testMap = Map(
    "Hello" -> 59,
    "World" -> 23
  )

  "twoSeqReverseSum on Map(Hello -> 59, World -> 23)" should "return 92" in {
    Maps.sumKeysLengthWithValues(testMap) shouldBe 92
  }

  "twoSeqReverseSum on Map('' -> 59)" should "return 59" in {
    Maps.sumKeysLengthWithValues(Map("" -> 59)) shouldBe 92
  }

  "sumKeysWithValues ib Map(Hello -> 59, World -> 23) with str function `length`" should "return 92" in {
    Maps.sumKeysWithValues(testMap, (str: String) => str.length) shouldBe 92
  }

  "twoSeqReverseSum on Map('' -> 59) with str function `length`" should "return 59" in {
    Maps.sumKeysLengthWithValues(Map("" -> 59)) shouldBe 59
  }

}
