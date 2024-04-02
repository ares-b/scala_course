package object_oriented.tweet

import objet_oriented.tweet.{ Tweet, TweetQueries }
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class TweetQueriesTest extends AnyFlatSpec with should.Matchers {

  "getAndroidTweets" should "return android tweets only" in {
    TweetQueries.getAndroidTweets(
      List(
        Tweet("John Doe", "Who's still using Android in 2024 LMAO", 0),
        Tweet("Jane Doe", "Galaxy S12 all the way!", 23),
        Tweet("Willy Doe", "Has anyone tried Google Nexus yet ?", 1),
        Tweet("John Doe", "iOS.", 1)
      )
    ) should contain theSameElementsAs List(
      Tweet("John Doe", "Who's still using Android in 2024 LMAO", 0),
      Tweet("Jane Doe", "Galaxy S12 all the way!", 23),
      Tweet("Willy Doe", "Has anyone tried Google Nexus yet ?", 1)
    )
  }

  "getAppleTweets" should "return ios tweets only" in {
    TweetQueries.getAppleTweets(
      List(
        Tweet("John Doe", "iPhone, iPad, Macbook. I'm all set up!", 0),
        Tweet("Jane Doe", "Everyone talking shit about apple is too broke to afford one. PERIODT", 23),
        Tweet("John Doe", "I really don't understand why android is so popular..gosh it's horrible", 1)
      )
    ) should contain theSameElementsAs List(
      Tweet("John Doe", "iPhone, iPad, Macbook. I'm all set up!", 0)
    )
  }

  "getTrendingTweets" should "return android and ios tweet sorted by number of retweets" in {
    TweetQueries.getAndroidTweets(
      List(
        Tweet("John Doe", "Who's still using Android in 2024 LMAO", 17),
        Tweet("Jane Doe", "Galaxy S12 all the way!", 13),
        Tweet("Willy Doe", "Has anyone tried Google Nexus yet ?", 5),
        Tweet("John Doe", "iOS.", 2),
        Tweet("Jane Doe", "Everyone talking shit about apple is too broke to afford one. PERIODT", 23),
        Tweet("Jane Doe", "Everyone talking shit about apple is too broke to afford one. PERIODT", 23),
        Tweet("John Doe", "I really don't understand why android is so popular..gosh it's horrible", 9)
      )
    ) should contain theSameElementsInOrderAs List(
      Tweet("John Doe", "iOS.", 2),
      Tweet("Willy Doe", "Has anyone tried Google Nexus yet ?", 5),
      Tweet("John Doe", "I really don't understand why android is so popular..gosh it's horrible", 9),
      Tweet("Jane Doe", "Galaxy S12 all the way!", 13),
      Tweet("John Doe", "Who's still using Android in 2024 LMAO", 17),
      Tweet("Jane Doe", "Everyone talking shit about apple is too broke to afford one. PERIODT", 23)
    )
  }
}
