import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.ConditionType
import org.openqa.selenium.WebElement

/* We start here */
def url = 'https://www.google.com/'

/* input field for search keyword*/
def tObjInputQ = new TestObject('q').addProperty('xpath', 
	ConditionType.EQUALS, "//input[@name='q']")

/* Google Search button */
def tObjInputBtnK = new TestObject('btnK').addProperty('xpath', 
	ConditionType.EQUALS, "//input[@name='btnK']")

/* link to the Katalon Offical site */
def tObjAnchorKatalon = new TestObject('katalonOfficial').addProperty('xpath', 
	ConditionType.EQUALS, "//a[@href='https://www.katalon.com/']")

/* set of all links in a web page */
def tObjAnchors = new TestObject('allLinks').addProperty('xpath',
	ConditionType.EQUALS, "//a")

WebUI.openBrowser('')
WebUI.navigateToUrl(url)
WebUI.verifyElementPresent(tObjInputQ, 10)
WebUI.setText(tObjInputQ, 'katalon')
WebUI.click(tObjInputBtnK)
WebUI.waitForElementPresent(tObjAnchorKatalon, 10)
List<WebElement> anchors = WebUI.findWebElements(tObjAnchors, 10)
WebUI.comment("anchors.size(): ${anchors.size()}")
WebUI.closeBrowser()