package monad

object LazyMonad {
  class Lazy[+A](value: => A) {
    private lazy val internal: A                  = value
    def flatMap[B](f: (=> A) => Lazy[B]): Lazy[B] = f(internal)
    def map[B](f: A => B): Lazy[B]                = flatMap(x => Lazy(f(x)))

    def get: A = internal
  }
  object Lazy {
    def apply[A](value: => A): Lazy[A] = new Lazy(value)
  }

  val result: Lazy[Int] = for {
    first  <- Lazy(1)
    second <- Lazy(2)
    third  <- Lazy(3)
  } yield first + second + third

  result.get
}
