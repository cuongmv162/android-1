package com.irccloud.android.test;

import android.text.Spanned;

import com.irccloud.android.ColorFormatter;

import junit.framework.TestCase;

public class FormattingTests extends TestCase {

	public void testIrc_to_html() {
		assertEquals("First <font color=\"#FF0000\">1Red</font>",
				ColorFormatter.irc_to_html("First \u000341Red"));

		assertEquals("First <font color=\"#808080\">1Grey</font>",
				ColorFormatter.irc_to_html("First \u0003141Grey"));

		assertEquals("First <_bg800000><font color=\"#FF0000\">1Test</font></_bg800000>",
				ColorFormatter.irc_to_html("First \u00034,51Test"));

		assertEquals("First <_bg808080><font color=\"#800000\">1Test</font></_bg808080>",
				ColorFormatter.irc_to_html("First \u00035,141Test"));

		assertEquals("First <font color=\"#FF0000\">Red </font><font color=\"#008000\">Green</font><b> Bold</b>",
				ColorFormatter.irc_to_html("First \u00034Red \u00033Green\u0003\u0002 Bold\u0002\u000f"));

		assertEquals("First <font color=\"#FF0000\">Color</font><b> Bold</b> unnecessary: <font color=\"#FF0000\">Color</font>  plain <font color=\"#FF0000\">Color</font> <b>Bold</b> <font color=\"#FF0000\">No space color</font><font color=\"#FF0000\"> New color</font>",
				ColorFormatter.irc_to_html("First \u00034Color\u0003\u0002 Bold\u0002 unnecessary:\u0003 \u00034Color\u0003\u0000 plain \u00034Color\u0003\u000f \u0002Bold\u000f \u00034No space color\u0003\u00034 New color\u000f"));
		
		assertEquals("DALnet's recommended mIRC scripting & bot help channel. <font color=\"#FF0000\">Visit us at <u>www.dalnethelpdesk.com</font></u> for scripting info, forums, and searchable logs/stats <font color=\"#0000FF\">Looking for a script/bot/addon?</font> <b><u>mircscripts.org</b></u> <font color=\"#FF0000\">or</font> <b><u>mirc.net</b></u> <font color=\"#0000FF\"> Writing your own?</font><font color=\"#FF0000\"> Ask <b>here.</b> </font> - <font color=\"#0000FF\">m</font><font color=\"#FF0000\">IR</font><font color=\"#FFFF00\">Casdsaa</font>asdasd v7.14 has been released",
				ColorFormatter.irc_to_html("DALnet's recommended mIRC scripting & bot help channel. \u00034Visit us at \u001fwww.dalnethelpdesk.com\u000f for \u0003scripting info, forums, and searchable logs/stats \u000312Looking for a script/bot/addon?\u000f \u0002\u001fmircscripts.org\u000f \u00034or\u000f \u0002\u001fmirc.net\u000f \u000312 Writing your own?\u0003\u00034 Ask \u0002here.\u0002 \u000f - \u000312m\u00034IR\u00038Casdsaa\u0003asdasd\u000f v7.14 has been released"));
		
		assertEquals("<b>irccloud:</b> <font color=\"#FFA500\">master</font> <font color=\"#008000\">James Wheare</font> * <b>87ebfc3</b> (1 files in 1 dirs): hidden_host_set formatting - http://bit.ly/bBsyTM",
				ColorFormatter.irc_to_html("\u0002irccloud:\u0002 \u000307master\u0003 \u000303James Wheare\u0003 * \u000287ebfc3\u0002 (1 files in 1 dirs): hidden_host_set formatting - http://bit.ly/bBsyTM"));
		
		assertEquals("<u>Stuff.Stuff.123.123.-WOOT</u>",
				ColorFormatter.irc_to_html("\u001fStuff.Stuff.123.123.-WOOT\u001f"));
		
		assertEquals("<font color=\"#00FF00\">http://www.google.com/intl/en/about.html</font> asdsa http://www.google.com/intl/en/about.html asdasd",
				ColorFormatter.irc_to_html("\u00039http://www.google.com/intl/en/about.html\u0003 asdsa http://www.google.com/intl/en/about.html asdasd"));
		
		assertEquals("<font color=\"#00FF00\">http://www.google.com/intl/en/about.html</font>  asdsa  http://www.google.com/intl/en/about.html  asdasd",
				ColorFormatter.irc_to_html("\u00039http://www.google.com/intl/en/about.html\u0003  asdsa  http://www.google.com/intl/en/about.html  asdasd"));
		
		assertEquals("<u>http://www.google.com/intl/en/about.html</u>  asda  http://www.google.com/intl/en/about.html  asdasd",
				ColorFormatter.irc_to_html("\u001fhttp://www.google.com/intl/en/about.html\u001f  asda  http://www.google.com/intl/en/about.html  asdasd"));
		
		assertEquals("<b>http://www.google.com/intl/en/about.html</b>",
				ColorFormatter.irc_to_html("\u0002http://www.google.com/intl/en/about.html\u0002"));
		
		assertEquals("<font color=\"#800080\">Stuff.Stuff.123.123.Stuff.Stuff.12345.1234.Stuff-TEST</font>",
				ColorFormatter.irc_to_html("\u00036Stuff.Stuff.123.123.Stuff.Stuff.12345.1234.Stuff-TEST\u0003"));
		
		assertEquals(" <b><_bg000000><font color=\"#FF0000\"> [</font><font color=\"#FFA500\">Test  Title</font><font color=\"#FF0000\">]</font></_bg000000>  blah.hah.hah.and.a.bottle.123.of.123456.0.RUM <_bg000000><font color=\"#FF0000\">[</font><font color=\"#FFA500\">hi/there</font><font color=\"#FF0000\">]</font></_bg000000></b> ",
				ColorFormatter.irc_to_html(" \u0002\u00034,1 [\u000307Test  Title\u00034]\u0003 \u0000blah.hah.hah.and.a.bottle.123.of.123456.0.RUM \u00034,1[\u000307hi/there\u00034]\u000f "));
		
		assertEquals("<_bg000000><font color=\"#FF0000\">h</font></_bg000000><_bg000080><font color=\"#FF0000\">#</font></_bg000080><_bg008000><font color=\"#FF0000\">l</font></_bg008000><_bgFF0000><font color=\"#FF0000\">l</font></_bgFF0000><_bg800000><font color=\"#FF0000\">o</font></_bg800000>",
				ColorFormatter.irc_to_html("\u00034,1h\u000f\u00034,2#\u000f\u00034,3l\u000f\u00034,4l\u000f\u00034,5o\u000f"));
		
		assertEquals("<b><font color=\"#0000FF\">http://www.site.com/</font></b>",
				ColorFormatter.irc_to_html("\u0002\u000312http://www.site.com/\u000f"));
		
		assertEquals("i was last seen \\ \\<font color=\"#000000\">             </font><font color=\"#FFA500\">piss^</font><font color=\"#000000\">      </font><font color=\"#FFA500\">._</font><font color=\"#000000\">   </font><font color=\"#808080\"> '--' </font><font color=\"#0000FF\">'-.\\__/ </font><font color=\"#808080\">_</font><font color=\"#0000FF\">l</font><font color=\"#000000\">       </font><font color=\"#FF0000\">`\\</font><font color=\"#000000\">        </font><font color=\"#FF0000\">\\</font><font color=\"#000000\">      </font><font color=\"#FF00FF\">||</font><font color=\"#000000\">       </font><font color=\"#FFA500\">/</font><font color=\"#000000\">       </font><font color=\"#FF0000\"><b>piss</b></font><font color=\"#000000\">  </font><font color=\"#FFA500\">^`</font><font color=\"#000000\">    </font><font color=\"#00FF00\">)</font><font color=\"#808080\">\\</font><font color=\"#C0C0C0\">((((</font><font color=\"#FFA500\">\\</font><font color=\"#000000\">   </font><font color=\"#FFA500\">.</font><font color=\"#000000\">            </font><font color=\"#FFFF00\"> :;;,,</font><font color=\"#FF0000\">'-._</font><font color=\"#000000\">  </font><font color=\"#FF0000\">\\</font><font color=\"#000000\">                        </font>",
				ColorFormatter.irc_to_html("i was last seen \\ \\\u00031 \u00031 \u00031 \u00031 \u00031 \u00031 \u00031 \u00031 \u00031 \u00031 \u00031 \u00031 \u00031 \u00037piss^\u00031 \u00031 \u00031 \u00031 \u00031 \u00031 \u00037._\u00031 \u00031 \u00031 \u000314 '--' \u000312'-.\\__/ \u000314_\u000312l\u00031 \u00031 \u00031 \u00031 \u00031 \u00031 \u00031 \u00034`\\\u00031 \u00031 \u00031 \u00031 \u00031 \u00031 \u00031 \u00031 \u00034\\\u00031 \u00031 \u00031 \u00031 \u00031 \u00031 \u000313||\u00031 \u00031 \u00031 \u00031 \u00031 \u00031 \u00031 \u00037/\u00031 \u00031 \u00031 \u00031 \u00031 \u00031 \u00031 \u00034\u0002piss\u0002\u00031 \u00031 \u00037^`\u00031 \u00031 \u00031 \u00031 \u00039)\u000314\\\u000315((((\u00037\\\u00031 \u00031 \u00031 \u00037.\u00031 \u00031 \u00031 \u00031 \u00031 \u00031 \u00031 \u00031 \u00031 \u00031 \u00031 \u00031 \u00038 :;;,,\u00034'-._\u00031 \u00031 \u00034\\\u00031 \u00031 \u00031 \u00031 \u00031 \u00031 \u00031 \u00031 \u00031 \u00031 \u00031 \u00031 \u00031 \u00031 \u00031 \u00031 \u00031 \u00031 \u00031 \u00031 \u00031 \u00031 \u00031 \u00031 \u00031"));
		
		assertEquals("<font color=\"#55ee22\">some text in 55ee22 rgb</font>",
				ColorFormatter.irc_to_html("\u00045e2some text in 55ee22 rgb\u0004"));
		
		assertEquals("<font color=\"#55ee22\">some text in 55ee22 rgb</font>",
				ColorFormatter.irc_to_html("\u000455ee22some text in 55ee22 rgb\u0004"));
		
		assertEquals("<font color=\"#55ee22\">some text in 55ee22 rgb</font>",
				ColorFormatter.irc_to_html("\u000455ee22,some text in 55ee22 rgb\u0004"));
		
		assertEquals("<_bgaaaaaa><font color=\"#55ee22\">some text in 55ee22 rgb on aaaaaa bg</font></_bgaaaaaa>",
				ColorFormatter.irc_to_html("\u00045e2,aaasome text in 55ee22 rgb on aaaaaa bg\u0004"));
		
		assertEquals("<_bgaaaaaa><font color=\"#55ee22\">some text in 55ee22 rgb on aaaaaa bg</font></_bgaaaaaa>",
				ColorFormatter.irc_to_html("\u000455ee22,aaaaaasome text in 55ee22 rgb on aaaaaa bg\u0004"));
		
		assertEquals("<_bgaaaaaa><font color=\"#55ee22\">,some text in 55ee22 rgb on aaaaaa bg</font></_bgaaaaaa>",
				ColorFormatter.irc_to_html("\u000455ee22,aaaaaa,some text in 55ee22 rgb on aaaaaa bg\u0004"));
		
		assertEquals("<_bgaaaaaa><font color=\"#55ee22\">,some text in 55ee22 rgb on aaaaaa bg</font></_bgaaaaaa><b> Bold</b>",
				ColorFormatter.irc_to_html("\u000455ee22,aaaaaa,some text in 55ee22 rgb on aaaaaa bg\u0004\u0002 Bold\u0002"));
		
		assertEquals("<_bgaaaaaa><font color=\"#55ee22\">,some text in 55ee22 rgb on aaaaaa bg</font></_bgaaaaaa> ",
				ColorFormatter.irc_to_html("\u000455ee22,aaaaaa,some text in 55ee22 rgb on aaaaaa bg\u0004\u0000"));
		
		assertEquals("<_bgaaaaaa><font color=\"#55ee22\">,some text in 55ee22 rgb on aaaaaa bg</font></_bgaaaaaa><font color=\"#FF0000\"> Red</font>",
				ColorFormatter.irc_to_html("\u000455ee22,aaaaaa,some text in 55ee22 rgb on aaaaaa bg\u0004\u00034 Red\u0003"));

        assertEquals("<b>Bold</b>",
                ColorFormatter.irc_to_html("\u0002Bold\u0002"));

        assertEquals("\u0010Italics\u0010",
                ColorFormatter.irc_to_html("\u0010Italics\u0010"));

        assertEquals("<i>Italics</i>",
                ColorFormatter.irc_to_html("\u0016Italics\u0016"));

        assertEquals("<i>Italics</i>",
                ColorFormatter.irc_to_html("\u001DItalics\u001D"));

        assertEquals("Found: <font color=\"#800080\">biomesoplenty</font>(dev) (Version <font color=\"#800000\">2.1.0.950</font>) - Last updated Fri Aug 01 23:54:18 BST 2014",
                ColorFormatter.irc_to_html("Found: \u000F\u000306biomesoplenty\u0003\u0003\u0003(dev) (Version \u000F\u0003052.1.0.950\u0003) - Last updated Fri Aug 01 23:54:18 BST 2014"));
    }

    private void checkURL(String input, String expected) {
        Spanned s = ColorFormatter.html_to_spanned(ColorFormatter.irc_to_html(input), true, null);
        ColorFormatter.URLSpanNoUnderline[] spans = s.getSpans(0, s.length(), ColorFormatter.URLSpanNoUnderline.class);
        assertTrue(spans.length > 0);
        assertEquals(expected, spans[0].getURL());
    }

    public void testUrls() {
        checkURL("blah www.isktheguide.com/test/tis.html blah", "http://www.isktheguide.com/test/tis.html");
        checkURL("blah (www.isktheguide.com/test/tis.html) blah", "http://www.isktheguide.com/test/tis.html");
        checkURL("http://foo.com/blah_blah", "http://foo.com/blah_blah");
        checkURL("http://foo.com/blah_blah/", "http://foo.com/blah_blah/");
        checkURL("(Something like http://foo.com/blah_blah)", "http://foo.com/blah_blah");
        checkURL("http://foo.com/blah_blah_(wikipedia)", "http://foo.com/blah_blah_(wikipedia)");
        checkURL("(Something like http://foo.com/blah_blah_(wikipedia))", "http://foo.com/blah_blah_(wikipedia)");
        checkURL("(Something like http://foo.com/blah_blah_)wikipedia()", "http://foo.com/blah_blah_)wikipedia(");
        checkURL("(Something like http://foo.com/blah_blah_{wikipedia})", "http://foo.com/blah_blah_{wikipedia}");
        checkURL("(Something like http://foo.com/blah_blah_[wikipedia])", "http://foo.com/blah_blah_[wikipedia]");
        checkURL("http://foo.com/blah_blah.", "http://foo.com/blah_blah");
        checkURL("http://foo.com/blah_blah!", "http://foo.com/blah_blah");
        checkURL("http://foo.com/!", "http://foo.com/");
        checkURL("http://lifehacker.com/#!5794512", "http://lifehacker.com/#!5794512");
        checkURL("http://foo.com!", "http://foo.com");
        checkURL("http://foo.com/blah_blah/.", "http://foo.com/blah_blah/");
        checkURL("http://foo.com/blah_blah,", "http://foo.com/blah_blah");
        checkURL("http://www.example.com/wpstyle/?p=364.", "http://www.example.com/wpstyle/?p=364");
        checkURL("http://✪df.ws/123", "http://✪df.ws/123");
        checkURL("http://userid:password@example.com:8080", "http://userid:password@example.com:8080");
        checkURL("http://www.marinetraffic.com/ais/details/ships/shipid:152182/mmsi:218284000/imo:9343730/vessel:KUALA_LUMPUR_EXPRESS", "http://www.marinetraffic.com/ais/details/ships/shipid:152182/mmsi:218284000/imo:9343730/vessel:KUALA_LUMPUR_EXPRESS");
        checkURL("http://www.marinetraffic.com:80/ais/details/ships/shipid:152182/mmsi:218284000/imo:9343730/vessel:KUALA_LUMPUR_EXPRESS", "http://www.marinetraffic.com:80/ais/details/ships/shipid:152182/mmsi:218284000/imo:9343730/vessel:KUALA_LUMPUR_EXPRESS");
        checkURL("http://www.marinetraffic.com:http/ais/details/ships/shipid:152182/mmsi:218284000/imo:9343730/vessel:KUALA_LUMPUR_EXPRESS", "http://www.marinetraffic.com");
        checkURL("http://www.marinetraffic.com/:http/ais/details/ships/shipid:152182/mmsi:218284000/imo:9343730/vessel:KUALA_LUMPUR_EXPRESS", "http://www.marinetraffic.com/:http/ais/details/ships/shipid:152182/mmsi:218284000/imo:9343730/vessel:KUALA_LUMPUR_EXPRESS");
        checkURL("http://google.com:80", "http://google.com:80");
        checkURL("http://google.com/:80", "http://google.com/:80");
        checkURL("http://google.com:http", "http://google.com");
        checkURL("http://google.com:80:http", "http://google.com:80");
        checkURL("http://google.com/:http", "http://google.com/:http");
        checkURL("http://google.com:http@google.com", "http://google.com:http@google.com");
        checkURL("http://google.com:http@google.com:80", "http://google.com:http@google.com:80");
        checkURL("http://google.com:http@google.com/:80", "http://google.com:http@google.com/:80");
        checkURL("http://google.com:http@google.com:http", "http://google.com:http@google.com");
        checkURL("http://google.com:http@google.com:80:http", "http://google.com:http@google.com:80");
        checkURL("http://google.com:http@google.com/:http", "http://google.com:http@google.com/:http");
        checkURL("http://userid@example.com", "http://userid@example.com");
        checkURL("http://userid@example.com:8080", "http://userid@example.com:8080");
        checkURL("http://userid:password@example.com", "http://userid:password@example.com");
        checkURL("<tag>http://example.com</tag>", "http://example.com");
        checkURL("Just a www.example.com link.", "http://www.example.com");
        checkURL("http://foo.com/more_(than)_one_(parens)", "http://foo.com/more_(than)_one_(parens)");
        checkURL("http://foo.com/more_[than]_one_[parens]", "http://foo.com/more_[than]_one_[parens]");
        checkURL("http://foo.com/more_{than}_one_{parens}", "http://foo.com/more_{than}_one_{parens}");
        checkURL("http://foo.com/more_(than)_one_[parens]_{test}", "http://foo.com/more_(than)_one_[parens]_{test}");
        checkURL("http://foo.com/blah_(wikipedia)#cite-1", "http://foo.com/blah_(wikipedia)#cite-1");
        checkURL("http://foo.com/blah_(wikipedia)_blah#cite-1", "http://foo.com/blah_(wikipedia)_blah#cite-1");
        checkURL("http://foo.com/unicode_(✪)_in_parens", "http://foo.com/unicode_(✪)_in_parens");
        checkURL("http://foo.com/(something)?after=parens", "http://foo.com/(something)?after=parens");
        checkURL("https://github.com/RJ/irccloud/compare/e9f748e760^...a8e784b39", "https://github.com/RJ/irccloud/compare/e9f748e760^...a8e784b39");
        checkURL("example.com!", "http://example.com");
        checkURL("example.com?", "http://example.com");
        checkURL("example.com/?", "http://example.com/");
        checkURL("example.com/?ref=123", "http://example.com/?ref=123");
        checkURL("example.com/#ref=123", "http://example.com/#ref=123");
        checkURL("example.com?ref=123", "http://example.com?ref=123");
        checkURL("www.youtube.com/watch?v=kK42LZqO0wA", "http://www.youtube.com/watch?v=kK42LZqO0wA");
        checkURL("www.youtube.com?v=kK42LZqO0wA", "http://www.youtube.com?v=kK42LZqO0wA");
        checkURL("youtube.com/watch?v=kK42LZqO0wA", "http://youtube.com/watch?v=kK42LZqO0wA");
        checkURL("youtube.com?v=kK42LZqO0wA", "http://youtube.com?v=kK42LZqO0wA");
        checkURL("youtube.com/?v=kK42LZqO0wA", "http://youtube.com/?v=kK42LZqO0wA");
        checkURL("www.youtube.com/?v=kK42LZqO0wA", "http://www.youtube.com/?v=kK42LZqO0wA");
        checkURL("example.com#ref=123", "http://example.com#ref=123");
        checkURL("http://example.com?", "http://example.com");
        checkURL("http://example.com/?", "http://example.com/");
        checkURL("http://example.com?ref=123", "http://example.com?ref=123");
        checkURL("http://example.com#ref=123", "http://example.com#ref=123");
        checkURL("http://example.com/?ref=123", "http://example.com/?ref=123");
        checkURL("http://example.com/#ref=123", "http://example.com/#ref=123");
        checkURL("google.com", "http://google.com");
        checkURL("'google.com'", "http://google.com");
        checkURL("\"google.com\"", "http://google.com");
        checkURL("(google.com)", "http://google.com");
        checkURL("[google.com]", "http://google.com");
        checkURL("google.com/test", "http://google.com/test");
        checkURL("'google.com/test'", "http://google.com/test");
        checkURL("\"google.com/test\"", "http://google.com/test");
        checkURL("(google.com/test)", "http://google.com/test");
        checkURL("[google.com/test]", "http://google.com/test");
        checkURL("http://google.com", "http://google.com");
        checkURL("'http://google.com'", "http://google.com");
        checkURL("\"http://google.com\"", "http://google.com");
        checkURL("(http://google.com)", "http://google.com");
        checkURL("[http://google.com]", "http://google.com");
        checkURL("http://google.com/test", "http://google.com/test");
        checkURL("'http://google.com/test'", "http://google.com/test");
        checkURL("\"http://google.com/test\"", "http://google.com/test");
        checkURL("(http://google.com/test)", "http://google.com/test");
        checkURL("[http://google.com/test]", "http://google.com/test");
        checkURL("example.com?hello=mum", "http://example.com?hello=mum");
        checkURL("example.com#hashbang", "http://example.com#hashbang");
        checkURL("lifehacker.com/#!5794512", "http://lifehacker.com/#!5794512");
        checkURL("example.com:8080", "http://example.com:8080");
        checkURL("james.dev.last.fm", "http://james.dev.last.fm");
        checkURL("foo.com/bar.txt", "http://foo.com/bar.txt");
        checkURL("\u0002\u000312http://something.com\u0003\u0002", "http://something.com");
        checkURL("irc.irccloud.com", "irc://irc.irccloud.com");
    }

    public void testImages() {
        checkURL("https://www.google.co.uk/images/srpr/logo11w.png", "irccloud-images://www.google.co.uk/images/srpr/logo11w.png");
        checkURL("https://www.google.co.uk/images/srpr/logo11w.jpg", "irccloud-images://www.google.co.uk/images/srpr/logo11w.jpg");
        checkURL("https://www.google.co.uk/images/srpr/logo11w.jpeg", "irccloud-images://www.google.co.uk/images/srpr/logo11w.jpeg");
        checkURL("https://www.google.co.uk/images/srpr/logo11w.gif", "irccloud-images://www.google.co.uk/images/srpr/logo11w.gif");
        checkURL("https://www.google.co.uk/images/srpr/logo11w.bmp", "irccloud-images://www.google.co.uk/images/srpr/logo11w.bmp");
        checkURL("http://f.cl.ly/items/3F0Q2L0f0V2F2z342c16/Screen%20Shot%202013-11-19%20at%2020.59.40.png", "irccloud-image://f.cl.ly/items/3F0Q2L0f0V2F2z342c16/Screen%20Shot%202013-11-19%20at%2020.59.40.png");
        checkURL("http://d.pr/i/JONs", "irccloud-image://d.pr/i/JONs");
        checkURL("http://droplr.com/i/JONs", "irccloud-image://droplr.com/i/JONs");
        checkURL("http://cloud-4.steampowered.com/ugc/633039016643356912/4928C2DE66D7946F5B2814A1B5483928650A4170/", "irccloud-image://cloud-4.steampowered.com/ugc/633039016643356912/4928C2DE66D7946F5B2814A1B5483928650A4170/");
        checkURL("http://www.flickr.com/photos/jwheare/12015278916/", "irccloud-image://www.flickr.com/photos/jwheare/12015278916/");
        checkURL("http://instagram.com/p/hZiTV3Tbl4/", "irccloud-image://instagram.com/p/hZiTV3Tbl4/");
        checkURL("http://instagr.am/p/hZiTV3Tbl4/", "irccloud-image://instagr.am/p/hZiTV3Tbl4/");
        checkURL("http://imgur.com/gJUafck", "irccloud-image://imgur.com/gJUafck");
    }
}
