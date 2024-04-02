import scala.io.StdIn.readLine

def greet: Unit = {
  println("What is your name?")
  val name = readLine
  println(f"Hello, $name!")
}

case class IO[A](unsafeRun: () => A){ self =>
  def flatMap[B](f: A => IO[B]): IO[B] = IO(
    () => f(self.unsafeRun()).unsafeRun()
  )
  def map[B](f: A => B): IO[B] = IO(() => f(self.unsafeRun()))
}

def printString(line: String): IO[Unit] = IO(() => println(line))
def readStdIn: IO[String] = IO(() => readLine)

def betterGreet: IO[Unit] = for {
  _ <- printString("What is your name?")
  name <- readStdIn
  _ <- printString(f"Hello, $name!")
} yield ()