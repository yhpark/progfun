package objsets

object test {
  val set1 = new Empty                            //> set1  : objsets.Empty = .
  val set2 = set1.incl(new Tweet("a", "a body", 20))
                                                  //> set2  : objsets.TweetSet = {.[a:a body(20)].}
  val set3 = set2.incl(new Tweet("b", "b body", 20))
                                                  //> set3  : objsets.TweetSet = {.[a:a body(20)]{.[b:b body(20)].}}
  val c = new Tweet("c", "c body", 7)             //> c  : objsets.Tweet = [c:c body(7)]
  val d = new Tweet("d", "d body", 9)             //> d  : objsets.Tweet = [d:d body(9)]
  val set4c = set3.incl(c)                        //> set4c  : objsets.TweetSet = {.[a:a body(20)]{.[b:b body(20)]{.[c:c body(7)].
                                                  //| }}}
  val set4d = set3.incl(d)                        //> set4d  : objsets.TweetSet = {.[a:a body(20)]{.[b:b body(20)]{.[d:d body(9)].
                                                  //| }}}
  val set5 = set4c.incl(d)                        //> set5  : objsets.TweetSet = {.[a:a body(20)]{.[b:b body(20)]{.[c:c body(7)]{.
                                                  //| [d:d body(9)].}}}}
 
  set5.filter(t => t.retweets > 10)               //> res0: objsets.TweetSet = {.[a:a body(20)]{.[b:b body(20)].}}
  
  TweetReader.allTweets                           //> res1: objsets.TweetSet = {{{{{{{{{{{{{.[engadget:"It's now a surprise to hea
                                                  //| r of a company listening to its users, issuing an apology and vowing to make
                                                  //|  it better." (http://t.co/R5bu5Wp1)(49)].}[gadgetlab:"We've updated every as
                                                  //| pect of iPhone 5,? @PSchiller says. #Apple #iPhone5 LIVEBLOG http://t.co/Dwt
                                                  //| KQkSu(16)].}[gadgetlab:#Apple #iPhone5 battery: 8hrs of 3G talk time, 8hrs o
                                                  //| f LTE or 3G browsing, 10hrs of WiFi browsing, 225hrs of standby http://t.co/
                                                  //| DwtKQkSu(121)].}[gadgetlab:#Apple #iPhone5 camera is 8megapixels...same as i
                                                  //| Phone 4S. But it's not the same camera http://t.co/DwtKQkSu #LIVEBLOG(30)].}
                                                  //| [gadgetlab:#Apple #iPhone5 comes in either Slate (aka black) or White http:/
                                                  //| /t.co/DwtKQkSu LIVEBLOG(17)]{.[gadgetlab:#Apple #iPhone5 has 40% faster phot
                                                  //| o capture thanks iPhone 4S http://t.co/DwtKQkSu LIVEBLOG(17)]{.[gadgetlab:#A
                                                  //| pple #iPhone5 photos up on our liveblog ---&gt; http://t.co/DwtKQkSu(35)]{{.
                                                  //| [gadgetlab:#Apple CEO Ti
                                                  //| Output exceeds cutoff limit.
  GoogleVsApple.googleTweets                      //> res2: objsets.TweetSet = {.[mashable:5 Mobile Photographers Capturing the Wo
                                                  //| rld With #Android http://t.co/786NneBt(78)]{.[mashable:7 Free #Android Apps 
                                                  //| for Killing Time in Lines http://t.co/eKu5hhsh(42)]{.[CNET:A mathematician a
                                                  //| ccurately predicted when Android's app store would hit 25 billion downloads 
                                                  //| http://t.co/VFLBJ0z3(36)]{.[engadget:AT&amp;T 4G LTE adds Galaxy Note 2, Gal
                                                  //| ay Tab 2 10.1, Galaxy Express and Galaxy Rugby Pro to lineup -  http://t.co/
                                                  //| uvBFFMQO(12)]{.[gadgetlab:BlueStacks and AMD Bring 500,000 Android Apps to W
                                                  //| indows 8: http://t.co/GskuXhRo by @alexandra_chang(22)]{.[CNET:Camera contes
                                                  //| t:  Apple iPhone 5 vs. Samsung Galaxy S3 vs. HTC One X http://t.co/PmbhNgrd(
                                                  //| 49)]{.[engadget:Court of Appeals for the Federal Circuit tells Judge Koh to 
                                                  //| revisit Galaxy Tab 10.1 injunction -  http://t.co/iIOCcwDW(13)]{.[engadget:C
                                                  //| ubify lets you skin, 3D print your own personal Android -  http://t.co/S6nim
                                                  //| h5R(23)]{.[engadget:FAVI
                                                  //| Output exceeds cutoff limit.
}