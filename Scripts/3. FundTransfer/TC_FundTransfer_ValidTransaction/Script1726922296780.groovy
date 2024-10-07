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
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('https://demo.guru99.com/V4/')

WebUI.sendKeys(findTestObject('LoginPage/txt_UserID'), GlobalVariable.UserID)

WebUI.sendKeys(findTestObject('LoginPage/txt_Password'), GlobalVariable.Password)

WebUI.click(findTestObject('LoginPage/btn_Login'))

WebUI.click(findTestObject('Fund Transfer/btn_FundTransfer'))

WebUI.sendKeys(findTestObject('Fund Transfer/txt_PayersAccountNo'), findTestData('Payers_Payee Data').getValue(1, 1))

WebUI.sendKeys(findTestObject('Fund Transfer/txt_PayeesAccountNo'), findTestData('Payers_Payee Data').getValue(2, 1))

WebUI.sendKeys(findTestObject('Fund Transfer/txt_Amount'), '11')

WebUI.sendKeys(findTestObject('Fund Transfer/txt_Description'), 'fund transfer')

WebUI.click(findTestObject('Fund Transfer/btn_Submit'))

WebUI.verifyElementPresent(findTestObject('Fund Transfer/vrfy_fundTransfer'), 1 )

String fundTransfer = WebUI.getText(findTestObject('Fund Transfer/vrfy_fundTransfer'))

println("Successfully = " + fundTransfer)

WebUI.closeBrowser()



