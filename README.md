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

Just open and run the [TC1](./Scripts/TC1/Script1604018300822.groovy) test case script.

## What the demo does

The TC1 script shows that you can use Katalon WebUI keywords and WebService keywords mixed together in a test case. By WebUI keywords you can navigate to web pages and look up URLs in web pages. By WS keywords you can explicity process the URLs looked up; you make HTTP Request and check HTTP Response in detail with your code.

The script goes as follows:

1. open the Goole Search top page
2. type keyword `katalon` and click the Search button, wait for the Result page
3. scan the Result page for `<a>` elements with `href` attribute filtering out the links to `google` internal pages
4. iterate over the external links
  1. make a WebService request to each link
  2. look up Http StatusCode of the response
  3. if the StatusCode is 302, look up the Location Header value
