How to find metadata of links of a web page --- Response Status, Location header
====

## Overview

This is a small Katalon Studio project for demonstration purpose.
You can download the source and run it with your local Katalon Studio.

This project was developed using Katalon Studio version 7.7.0, but
I expect it will run on the previous versions.

This project was developed to propose a solution to a question raised
in a post ['How to find the inaccessible links on a webpage'](https://forum.katalon.com/t/how-to-find-the-inaccessible-links-on-a-webpage/48716) in the
[Katalon Forum](https://forum.katalon.com/).

## How to run the demo

Just open and run the Test Case [TC1](./Scripts/TC1/Script1604018300822.groovy) test case script.

## What the demo does

The script goes as follows:

1. open the Goole Search top page
2. type keyword `katalon` and click the Search button, wait for the Result page
3. scan the Result page for `<a>` elements with `href` attribute filtering out the links to `google` internal pages
4. iterate over the external links
  1. make a WebService request to each link
  2. look up Http StatusCode out of the WebService response
  3. if the StatusCode is 302, look up the Location Header value


## Output of the demo

You will see log like this in the Console:

```
2020-10-30 18:15:58.715 INFO  c.k.k.core.webui.driver.DriverFactory    - sessionId = 347bda2c2c5e693968d0f01f8ca0689e
2020-10-30 18:15:58.749 INFO  c.k.k.core.webui.driver.DriverFactory    - browser = Chrome 86.0.4240.111
2020-10-30 18:15:58.752 INFO  c.k.k.core.webui.driver.DriverFactory    - platform = Mac OS X
2020-10-30 18:15:58.753 INFO  c.k.k.core.webui.driver.DriverFactory    - seleniumVersion = 3.141.59
2020-10-30 18:15:58.754 INFO  c.k.k.core.webui.driver.DriverFactory    - proxyInformation = ProxyInformation { proxyOption=NO_PROXY, proxyServerType=HTTP, username=, password=********, proxyServerAddress=, proxyServerPort=0, executionList="", isApplyToDesiredCapabilities=true }
2020-10-30 18:15:58.771 DEBUG testcase.TC1                             - 7: navigateToUrl(url)
2020-10-30 18:16:19.858 DEBUG testcase.TC1                             - 8: verifyElementPresent(tObjInputQ, 10)
2020-10-30 18:16:20.232 DEBUG testcase.TC1                             - 9: setText(tObjInputQ, "katalon")
2020-10-30 18:16:20.943 DEBUG testcase.TC1                             - 10: click(tObjInputBtnK)
2020-10-30 18:16:37.088 DEBUG testcase.TC1                             - 11: waitForElementPresent(tObjAnchorKatalon, 10)
2020-10-30 18:16:37.503 DEBUG testcase.TC1                             - 12: anchors = findWebElements(tObjAnchors, 10)
2020-10-30 18:16:37.779 DEBUG testcase.TC1                             - 13: comment(anchors.size(): $anchors.size() --- this contains miscellaneous google pages)
2020-10-30 18:16:37.819 INFO  c.k.k.c.keyword.builtin.CommentKeyword   - anchors.size(): 119 --- this contains miscellaneous google pages
2020-10-30 18:16:37.820 DEBUG testcase.TC1                             - 14: links = new java.util.HashSet()
2020-10-30 18:16:37.855 DEBUG testcase.TC1                             - 15: anchors.each({ -> ... })
2020-10-30 18:16:38.462 INFO  c.k.k.c.keyword.builtin.CommentKeyword   - https://www.katalon.com/
2020-10-30 18:16:38.526 INFO  c.k.k.c.keyword.builtin.CommentKeyword   - https://www.katalon.com/pricing/
2020-10-30 18:16:38.553 INFO  c.k.k.c.keyword.builtin.CommentKeyword   - https://www.katalon.com/sign-up/
2020-10-30 18:16:38.568 INFO  c.k.k.c.keyword.builtin.CommentKeyword   - https://www.katalon.com/katalon-studio/
2020-10-30 18:16:38.586 INFO  c.k.k.c.keyword.builtin.CommentKeyword   - https://docs.katalon.com/katalon-studio/docs/index.html
2020-10-30 18:16:38.618 INFO  c.k.k.c.keyword.builtin.CommentKeyword   - https://qiita.com/kazurayam/items/aece5d314f84893a0a14
2020-10-30 18:16:38.673 INFO  c.k.k.c.keyword.builtin.CommentKeyword   - https://qiita.com/RyomaMaeda/items/0d02c1687e8bc4e57944
2020-10-30 18:16:38.738 INFO  c.k.k.c.keyword.builtin.CommentKeyword   - https://blog.engineer.adways.net/entry/advent_calendar_2018/07
2020-10-30 18:16:38.790 INFO  c.k.k.c.keyword.builtin.CommentKeyword   - https://www.itreview.jp/products/katalon-studio/reviews
2020-10-30 18:16:38.845 INFO  c.k.k.c.keyword.builtin.CommentKeyword   - http://take-web.com/cad/2019/03/katalon02/
2020-10-30 18:16:38.941 INFO  c.k.k.c.keyword.builtin.CommentKeyword   - https://devtab.jp/entry/internal/103
2020-10-30 18:16:38.987 INFO  c.k.k.c.keyword.builtin.CommentKeyword   - https://www.sprasia.co.jp/blog/about-katalon-studio
2020-10-30 18:16:39.036 INFO  c.k.k.c.keyword.builtin.CommentKeyword   - https://addons.mozilla.org/ja/firefox/addon/katalon-automation-record/
2020-10-30 18:16:39.605 INFO  c.k.k.c.keyword.builtin.CommentKeyword   - https://en.wikipedia.org/wiki/Katalon_Studio
2020-10-30 18:16:39.631 INFO  c.k.k.c.keyword.builtin.CommentKeyword   - https://en.wikipedia.org/wiki/Katalon_Studio
2020-10-30 18:16:39.875 DEBUG testcase.TC1                             - 16: comment(links.size(): $links.size())
2020-10-30 18:16:39.881 INFO  c.k.k.c.keyword.builtin.CommentKeyword   - links.size(): 14
2020-10-30 18:16:39.882 DEBUG testcase.TC1                             - 17: builder = new com.kms.katalon.core.testobject.RestRequestObjectBuilder()
2020-10-30 18:16:39.901 DEBUG testcase.TC1                             - 18: links.each({ java.lang.Object link -> ... })
2020-10-30 18:16:44.479 INFO  c.k.k.core.webservice.common.HarLogger   - HAR: /var/folders/7m/lm7d6nx51kj0kbtnsskz6r3m0000gn/T/Katalon/Test Cases/TC1/20201030_181536/requests/main/0.har
2020-10-30 18:16:44.859 INFO  c.k.k.c.keyword.builtin.CommentKeyword   - Request to https://docs.katalon.com/katalon-studio/docs/index.html was responded with StatusCode 200
2020-10-30 18:16:48.303 INFO  c.k.k.core.webservice.common.HarLogger   - HAR: /var/folders/7m/lm7d6nx51kj0kbtnsskz6r3m0000gn/T/Katalon/Test Cases/TC1/20201030_181536/requests/main/1.har
2020-10-30 18:16:48.313 INFO  c.k.k.c.keyword.builtin.CommentKeyword   - Request to https://www.sprasia.co.jp/blog/about-katalon-studio was responded with StatusCode 200
2020-10-30 18:16:56.943 INFO  c.k.k.core.webservice.common.HarLogger   - HAR: /var/folders/7m/lm7d6nx51kj0kbtnsskz6r3m0000gn/T/Katalon/Test Cases/TC1/20201030_181536/requests/main/2.har
2020-10-30 18:16:56.959 INFO  c.k.k.c.keyword.builtin.CommentKeyword   - Request to https://www.katalon.com/sign-up/ was responded with StatusCode 200
2020-10-30 18:16:58.152 INFO  c.k.k.core.webservice.common.HarLogger   - HAR: /var/folders/7m/lm7d6nx51kj0kbtnsskz6r3m0000gn/T/Katalon/Test Cases/TC1/20201030_181536/requests/main/3.har
2020-10-30 18:16:58.162 INFO  c.k.k.c.keyword.builtin.CommentKeyword   - Request to https://qiita.com/kazurayam/items/aece5d314f84893a0a14 was responded with StatusCode 200
2020-10-30 18:17:02.988 INFO  c.k.k.core.webservice.common.HarLogger   - HAR: /var/folders/7m/lm7d6nx51kj0kbtnsskz6r3m0000gn/T/Katalon/Test Cases/TC1/20201030_181536/requests/main/4.har
2020-10-30 18:17:03.003 INFO  c.k.k.c.keyword.builtin.CommentKeyword   - Request to https://addons.mozilla.org/ja/firefox/addon/katalon-automation-record/ was responded with StatusCode 200
2020-10-30 18:17:04.781 INFO  c.k.k.core.webservice.common.HarLogger   - HAR: /var/folders/7m/lm7d6nx51kj0kbtnsskz6r3m0000gn/T/Katalon/Test Cases/TC1/20201030_181536/requests/main/5.har
2020-10-30 18:17:04.796 INFO  c.k.k.c.keyword.builtin.CommentKeyword   - Request to http://take-web.com/cad/2019/03/katalon02/ was responded with StatusCode 200
2020-10-30 18:17:06.998 INFO  c.k.k.core.webservice.common.HarLogger   - HAR: /var/folders/7m/lm7d6nx51kj0kbtnsskz6r3m0000gn/T/Katalon/Test Cases/TC1/20201030_181536/requests/main/6.har
2020-10-30 18:17:07.007 INFO  c.k.k.c.keyword.builtin.CommentKeyword   - Request to https://en.wikipedia.org/wiki/Katalon_Studio was responded with StatusCode 200
2020-10-30 18:17:10.107 INFO  c.k.k.core.webservice.common.HarLogger   - HAR: /var/folders/7m/lm7d6nx51kj0kbtnsskz6r3m0000gn/T/Katalon/Test Cases/TC1/20201030_181536/requests/main/7.har
2020-10-30 18:17:10.119 INFO  c.k.k.c.keyword.builtin.CommentKeyword   - Request to https://www.katalon.com/ was responded with StatusCode 200
2020-10-30 18:17:12.632 INFO  c.k.k.core.webservice.common.HarLogger   - HAR: /var/folders/7m/lm7d6nx51kj0kbtnsskz6r3m0000gn/T/Katalon/Test Cases/TC1/20201030_181536/requests/main/8.har
2020-10-30 18:17:12.639 INFO  c.k.k.c.keyword.builtin.CommentKeyword   - Request to https://qiita.com/RyomaMaeda/items/0d02c1687e8bc4e57944 was responded with StatusCode 200
2020-10-30 18:17:14.645 INFO  c.k.k.core.webservice.common.HarLogger   - HAR: /var/folders/7m/lm7d6nx51kj0kbtnsskz6r3m0000gn/T/Katalon/Test Cases/TC1/20201030_181536/requests/main/9.har
2020-10-30 18:17:14.655 INFO  c.k.k.c.keyword.builtin.CommentKeyword   - Request to https://blog.engineer.adways.net/entry/advent_calendar_2018/07 was responded with StatusCode 200
2020-10-30 18:17:19.333 INFO  c.k.k.core.webservice.common.HarLogger   - HAR: /var/folders/7m/lm7d6nx51kj0kbtnsskz6r3m0000gn/T/Katalon/Test Cases/TC1/20201030_181536/requests/main/10.har
2020-10-30 18:17:19.346 INFO  c.k.k.c.keyword.builtin.CommentKeyword   - Request to https://www.itreview.jp/products/katalon-studio/reviews was responded with StatusCode 200
2020-10-30 18:17:23.430 INFO  c.k.k.core.webservice.common.HarLogger   - HAR: /var/folders/7m/lm7d6nx51kj0kbtnsskz6r3m0000gn/T/Katalon/Test Cases/TC1/20201030_181536/requests/main/11.har
2020-10-30 18:17:23.442 INFO  c.k.k.c.keyword.builtin.CommentKeyword   - Request to https://www.katalon.com/katalon-studio/ was responded with StatusCode 200
2020-10-30 18:17:26.428 INFO  c.k.k.core.webservice.common.HarLogger   - HAR: /var/folders/7m/lm7d6nx51kj0kbtnsskz6r3m0000gn/T/Katalon/Test Cases/TC1/20201030_181536/requests/main/12.har
2020-10-30 18:17:26.436 INFO  c.k.k.c.keyword.builtin.CommentKeyword   - Request to https://www.katalon.com/pricing/ was responded with StatusCode 200
2020-10-30 18:17:29.607 INFO  c.k.k.core.webservice.common.HarLogger   - HAR: /var/folders/7m/lm7d6nx51kj0kbtnsskz6r3m0000gn/T/Katalon/Test Cases/TC1/20201030_181536/requests/main/13.har
2020-10-30 18:17:29.616 INFO  c.k.k.c.keyword.builtin.CommentKeyword   - Request to https://devtab.jp/entry/internal/103 was responded with StatusCode 200
2020-10-30 18:17:29.616 DEBUG testcase.TC1                             - 19: closeBrowser()
2020-10-30 18:17:29.866 INFO  c.k.katalon.core.main.TestCaseExecutor   - END Test Cases/TC1

```

## Points to note

The TC1 script code shows that:

1. You can use Katalon's WebUI keywords and WebService keywords mixed in a test case.
2. [`com.kms.katalon.core.testobject.ResponseObject`](https://docs.katalon.com/javadoc/com/kms/katalon/core/testobject/ResponseObject.html) implements a lot of getter methods to read the HTTP Response object. E.g, `getStatusCode()` and `getHeaderField()`. Those methods enable you to inspect the Response in detail.
