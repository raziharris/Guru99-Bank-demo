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
import java.util.Random as Random


WebUI.openBrowser('https://demo.guru99.com/V4/')

WebUI.sendKeys(findTestObject('LoginPage/txt_UserID'), GlobalVariable.UserID)

WebUI.sendKeys(findTestObject('LoginPage/txt_Password'), GlobalVariable.Password)

WebUI.click(findTestObject('LoginPage/btn_Login'))

WebUI.click(findTestObject('AccountPage/CreateNewCustomer/btn_NewCustomer'))

WebUI.sendKeys(findTestObject('AccountPage/CreateNewCustomer/txt_CustomerName'), 'RaziHarris')

WebUI.click(findTestObject('AccountPage/CreateNewCustomer/radiobtn_Gender'), FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('AccountPage/CreateNewCustomer/txt_DOB'), '09091999')

WebUI.sendKeys(findTestObject('AccountPage/CreateNewCustomer/txt_Address'), 'Jalan Bayu Rahmah')

WebUI.sendKeys(findTestObject('AccountPage/CreateNewCustomer/txt_City'), 'Kuala Lumpur')

WebUI.sendKeys(findTestObject('AccountPage/CreateNewCustomer/txt_State'), 'Wilayah Persekutuan')

WebUI.sendKeys(findTestObject('AccountPage/CreateNewCustomer/txt_PIN'), '500000')

WebUI.sendKeys(findTestObject('AccountPage/CreateNewCustomer/txt_MobileNumber'), '012345678')

// Create an instance of Random
Random random = new Random()

// Generate a random integer between 0 and 100
int randomInt = random.nextInt(100)

println('Random Integer: ' + randomInt)

WebUI.sendKeys(findTestObject('AccountPage/CreateNewCustomer/txt_Email'), randomInt + '@gmail.com')

WebUI.sendKeys(findTestObject('AccountPage/CreateNewCustomer/txt_Password'), 'test123')

WebUI.click(findTestObject('AccountPage/CreateNewCustomer/btn_Submit'))

WebUI.waitForElementVisible(findTestObject('AccountPage/CreateNewCustomer/txt_CustomerID'), 2)

String CustomerId = WebUI.getText(findTestObject('AccountPage/CreateNewCustomer/txt_CustomerID'))

println('Captured Customer ID: ' + CustomerId)

assert (CustomerId != null) && !(CustomerId.isEmpty()) : 'Customer ID should not be empty'

GlobalVariable.CustomerId = CustomerId

println('Stored Customer ID in Global Variable: ' + CustomerId)


import org.apache.poi.ss.usermodel.*
import org.apache.poi.xssf.usermodel.XSSFWorkbook

// Create a new workbook and a sheet
Workbook workbook = new XSSFWorkbook()
Sheet sheet = workbook.createSheet("TestSheet")

// Create a row and a cell
Row row = sheet.createRow(0)
Cell cell = row.createCell(0)
cell.setCellValue(CustomerId)

// Write the workbook to a file
FileOutputStream fileOut = new FileOutputStream("C:/Katalon Studio/Guru99 Bank demo/Guru99 Bank demo/Drivers/apache-poi-src-5.3.0-20240625/New-CustomerID.xlsx")
workbook.write(fileOut)
fileOut.close()
workbook.close()

println('Excel file created successfully using Apache POI.')







