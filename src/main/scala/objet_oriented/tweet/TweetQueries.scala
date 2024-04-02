package objet_oriented.tweet

object TweetQueries {

  /**
    * A list of all tweets mentioning the keywords: android, galaxy or nexus (case insensitive)
    */
  def getAndroidTweets(allTweets: List[Tweet]): List[Tweet] = ???

  /**
    * A list of all tweets mentioning the keywords: ios, iphone or ipad (case insensitive)
    */
  def getAppleTweets(allTweets: List[Tweet]): List[Tweet] = ???

  /**
    * A list of all tweets mentioning a keyword from either android or google (case insensitive)
    * sorted by the number of retweets.
    */
  def getTrendingTweets(allTweets: List[Tweet]): List[Tweet] = ???
}
