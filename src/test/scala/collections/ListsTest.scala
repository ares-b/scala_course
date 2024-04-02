package collections

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class ListsTest extends AnyFlatSpec with should.Matchers {
  val firstList  = Seq(1, 2, 3, 4)
  val secondList = Seq(9, 10, 15, 1, 17)

  "alternateSorting" should "sort the list as high -> low -> high -> low " in {
    Lists.alternativeSorting(firstList).sliding(3).foldLeft(true) { (accumulator, xs) =>
      xs match {
        case Seq(first, second, third) => accumulator && first >= second && second <= third
      }
    } shouldBe true
  }

  "twoSeqReverseSum on (1, 2, 3, 4) and (9, 10, 15, 1, 17)" should "be 17119430" in {
    Lists.twoSeqReverseSum(firstList, secondList) shouldBe 17119430
  }
}
