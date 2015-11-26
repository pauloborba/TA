//package steps
//
//import commom.SheetImporter
//import pages.ConceptPages.ConceptSheetUploadPage
//import ta.ConceptController
//import pages.ConceptPages.ConceptPage
//import ta.EvaluationCriterion
//import ta.Sheet
//import ta.Student
//
//this.metaClass.mixin(cucumber.api.groovy.Hooks)
//this.metaClass.mixin(cucumber.api.groovy.EN)
//
//// Controller Scenario: Importing valid spreadsheet (file format and columns)
//
//// Given the spreadsheet "validSheet.xlsx" is on valid file format
//Given (~'^the spreadsheet "([^"]*)" is on valid file format$'){ String filename->
//	sheetImporter = new SheetImporter(filename)
//	myfilename = filename
//	assert sheetImporter != null
//}
//
//// When I import it’s data
//When (~'^I try to import its data$'){ ->
//	conceptController = new ConceptController()
//	conceptController.uploadSheet(myfilename)
//}
//
////And the spreadsheet contains valid columns
//And (~'the spreadsheet contains valid columns'){ ->
//	assert sheetImporter.hasValidColumns()
//}
//
//// Then update system data accordingly
//Then (~'^update system data accordingly$'){ ->
//	assert conceptController.hasImported
//}
//
//// Controller Scenario: Importing spreadsheet in invalid file format
//// Given the spreadsheet "sheet.csv" is not on valid file format
//Given (~'^the spreadsheet "([^"]*)" is not on valid file format$'){ String filename ->
//	SheetImporter sheetImporter = new SheetImporter(filename)
//	myfilename = filename
//	assert sheetImporter == null
//}
//
//// When I try to import it’s data
//When (~'^I try to import its data$'){ ->
//	conceptController = new ConceptController()
//	conceptController.uploadSheet(myfilename)
//}
//// Then do not update system data
//Then (~'^do not update system data$'){ ->
//	assert !conceptController.hasImported
//}
//
//// Controller Scenario: Importing spreadsheet with invalid column
//// Given the spreadsheet "sheet.csv" is not on valid file format
//Given (~'^the spreadsheet "([^"]*)" is on valid file format$'){ String filename ->
//	SheetImporter sheetImporter = new SheetImporter(filename)
//	myfilename = filename
//	assert sheetImporter != null
//}
//
//// When I try to import it’s data
//When (~'^I try to import its data$'){ ->
//	conceptController = new ConceptController()
//	conceptController.uploadSheet(myfilename)
//}
//
////And the spreadsheet contains invalid columns
//And (~'the spreadsheet contains valid columns'){ ->
//	assert !sheetImporter.hasValidColumns()
//}
//
//// Then do not update system data
//Then (~'^do not update system data$'){ ->
//	assert !conceptController.hasImported
//}
//
//// GUI Scenario: Importing valid spreadsheet (file format and columns)
//
////Given that I am at the Concept page
//Given (~'^that I am at the Concepts page$') {
//	->
//	to ConceptSheetUploadPage
//	at ConceptSheetUploadPage
//
//}
////When I select the option to import spreadsheet "sheet.csv"
//When (~'^I select the option to import spreadsheet "([^"]*)"$') {
//	String file ->
//		at ConceptSheetUploadPage
//		page.click()
//		//page.import(file)
//}
//
////And the spreadsheet is on valid format
//And (~'^the spreadsheet is on valid format (file format and columns)$') { ->
//	assert page.validFileFormat
//}
////Then the Concept page displays new data accordingly
//Then (~'^an upload confirmation message is displayed$') { ->
////	at ConceptPage
////	page.update()
//}
//
//// GUI Scenario: Importing spreadsheet in invalid file format
//
////And the spreadsheet is not on valid format
//And (~'^the spreadsheet is not on valid format$') { ->
//	assert page.validFileFormat == false
//}
////Then displays error message
//Then (~'^display error message$') { ->
//	at ConceptSheetUploadPage
//
//	assert page.hasDisplayedError()
//}
//
////Controller Scenario: Importing spreadsheet with non registered student
////Given the valid spreadsheet "validSheet.xlsx" contains a not registered student named "Alan Turing" with login "at"
//Given (~'^the valid spreadsheet "validSheet.xlsx" contains a not registered student named "Alan Turing" with login "at"$'){ String filename, String name, String login->
//	myfilename = filename
//	studentName = name
//	studentLogin = login
//	studentByLogin = Student.findByLogin(studentLogin)
//	studentByName = Student.findByName(studentName)
//	isRegistered = (studentByLogin == studentByName) && studentByLogin != null
//
//	sheetImporter = new SheetImporter("sampleFiles/" + myfilename)
//	//falta verificar aqui
//	spreadsheetContains = true
//
//	assert !isRegistered && spreadsheetContains
//}
//
////  When I import the spreadsheet
//When (~'^I import the spreadsheet$'){ ->
//	conceptController = new ConceptController()
//	conceptController.uploadSheet(myfilename)
//	assert conceptController.hasImported
//}
//
//
//// Then the student is registered
//Then (~'^the student is registered$'){ ->
//	studentByLogin = Student.findByLogin(studentLogin)
//	studentByName = Student.findByName(studentName)
//	isRegistered = (studentByLogin == studentByName) && studentByLogin != null
//
//	assert isRegistered
//}
//
////Controller Scenario: Importing spreadsheet with non registered criterion
////Given that the valid spreadsheet "validSheet.xlsx" contains a not registered criterion named "grails"
//Given (~'^that the valid spreadsheet "validSheet.xlsx" contains a not registered criterion named "grails"$'){ String filename, String criterion->
//	myfilename = filename
//	criterionName = criterion
//	criterionByName = EvaluationCriterion.findByName(criterionName)
//	isRegistered = criterionByName != null
//
//	sheetImporter = new SheetImporter("sampleFiles/" + myfilename)
//	//falta verificar aqui
//	spreadsheetContains = true
//
//	assert !isRegistered && spreadsheetContains
//}
//
////  When I import the spreadsheet
//When (~'^I import the spreadsheet$'){ ->
//	conceptController = new ConceptController()
//	conceptController.uploadSheet(myfilename)
//	assert conceptController.hasImported
//}
//
//
//// Then the criterion is registered
//Then (~'^the criterion is registered$'){ ->
//	criterionByName = EvaluationCriterion.findByName(criterionName)
//	isRegistered = criterionByName != null
//
//	assert isRegistered
//}