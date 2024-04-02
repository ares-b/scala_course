package objet_oriented.bank

object BankAccountQueries {

  val john = BankAccount("John Doe")

  println(f"John's balance: ${john.getBalance}.")
  john.deposit(78D)
  john.deposit(569.65)
  john.withdraw(100D)
  println(f"John's balance: ${john.getBalance}.")

}
