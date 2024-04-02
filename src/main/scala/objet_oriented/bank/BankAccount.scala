package objet_oriented.bank

case class BankAccount(
    accountNumber: String, // This information is highly sensitive and cannot be accessed by everyone
    holderName: String, // This information is highly sensitive and cannot be accessed by everyone
    balance: Double,
    currency: Currency
) {
  def deposit(amount: Double): BankAccount  = ???
  def withdraw(amount: Double): BankAccount = ???
  def getBalance: String                    = ???
}
object BankAccount {
  def apply(holderName: String): BankAccount = ???
}
