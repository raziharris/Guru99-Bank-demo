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

import org.apache.poi.ss.usermodel.*
import org.apache.poi.xssf.usermodel.XSSFWorkbook

// Create a new workbook and a sheet
Workbook workbook = new XSSFWorkbook()
Sheet sheet = workbook.createSheet("TestSheet")

// Create a row and a cell
Row row = sheet.createRow(0)
Cell cell = row.createCell(0)
cell.setCellValue("Hello, ah POI!")

// Write the workbook to a file
FileOutputStream fileOut = new FileOutputStream("C:/Katalon Studio/Guru99 Bank demo/Guru99 Bank demo/Drivers/apache-poi-src-5.3.0-20240625/test-poi123.xlsx")
workbook.write(fileOut)
fileOut.close()
workbook.close()

println('Excel file created successfully using Apache POI.')	
