package object_oriented.bank

import objet_oriented.bank.{ BankAccount, Dollar, Euro }
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should
import org.scalatest.PrivateMethodTester

class BankAccountTest extends AnyFlatSpec with should.Matchers with PrivateMethodTester {

  val readBalanceAttribute: PrivateMethod[Double]       = PrivateMethod[Double](Symbol("balance"))
  val readAccountNumberAttribute: PrivateMethod[String] = PrivateMethod[String](Symbol("accountNumber"))

  "BankAccount balance" should "by default be 0" in {
    BankAccount("John Doe").invokePrivate(readBalanceAttribute()) shouldBe 0
  }

  "BankAccount currency" should "by default be Euro" in {
    BankAccount("John Doe").currency shouldBe Euro
  }

  "BankAccount getBalance" should "be `X €` when currency is Euro and `X $` when currency is Dollar" in {
    BankAccount("John Doe", "Whatever", 0, Euro).getBalance should endWith("€")
    BankAccount("John Doe", "Whatever", 0, Dollar).getBalance should endWith("$")
  }

  "BankAccount accountNumber" should "be automatically calculated and idempotent" in {
    BankAccount("John Doe").invokePrivate(readAccountNumberAttribute()) shouldBe
      BankAccount("John Doe").invokePrivate(readAccountNumberAttribute())
  }
}
