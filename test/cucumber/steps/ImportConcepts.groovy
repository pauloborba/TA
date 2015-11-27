package steps

import commom.SheetImporter
import pages.SheetPages.SheetUploadPage
import ta.EvaluationCriterion
import ta.SheetController
import ta.Student

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

// Controller Scenario: Importing valid spreadsheet (file format and columns)

// Given the spreadsheet "validSheet.xlsx" is on valid file format
Given (~'^the spreadsheet "([^"]*)" is on valid file format$'){ String filename->
	sheetImporter = new SheetImporter("sampleFiles/" + filename)
	myfilename = filename
	assert sheetImporter != null
}

// When I import it’s data
When (~'^I try to import its data$'){ ->
	sheetController = new SheetController()
	sheetController.uploadSheet("sampleFiles/" + myfilename)
}

//And the spreadsheet contains valid columns
And (~'the spreadsheet contains valid columns'){ ->
	assert sheetImporter.hasValidColumns()
}

// Then update system data accordingly
Then (~'^update system data accordingly$'){ ->
	assert sheetController.hasImported
}

// Controller Scenario: Importing spreadsheet in invalid file format
// Given the spreadsheet "sheet.csv" is not on valid file format
Given (~'^the spreadsheet "([^"]*)" is not on valid file format$'){ String filename ->
	valid = true
	myfilename = filename
	try {
		sheetImporter = new SheetImporter("sampleFiles/" + filename)
	} catch (IllegalArgumentException e){
		valid = false
	}
	assert !valid
}

//// When I try to import it’s data

// Then do not update system data
Then (~'^do not update system data$'){ ->
	assert !sheetController.hasImported
}

// Controller Scenario: Importing spreadsheet with invalid column
//  Given the spreadsheet "invalidColumnSheet.xlsx" is on valid file format

// When I try to import it’s data

//And the spreadsheet contains invalid columns
And (~'the spreadsheet contains invalid columns'){ ->
	assert !sheetImporter.hasValidColumns()
}

// Then do not update system data

// GUI Scenario: Importing valid spreadsheet (file format and columns)

//Given that I am at the Sheet Upload page
Given (~'^that I am at the Sheet Upload page$') {
	->
	to SheetUploadPage
	at SheetUploadPage

}
//When I import the spreadsheet "validSheet.xlsx"
When (~'^I import the spreadsheet "([^"]*)"$') {
	String filename ->
		at SheetUploadPage
		myfilename = filename

		page.submit("sampleFiles/" + filename)
		//sheetController = new SheetController()
		//sheetController.uploadSheet("sampleFiles/" + myfilename)
}

//And the spreadsheet is on valid file format
And (~'^the spreadsheet is on valid file format$') { ->
	at SheetUploadPage
	sheetImporter = new SheetImporter("sampleFiles/" + myfilename)

	assert page.verifyFileFormat("sampleFiles/" + myfilename)
}

//And the spreadsheet contains valid columns

//Then an upload confirmation message is displayed
Then (~'^an upload confirmation message is displayed$') { ->
	at SheetUploadPage
	assert page.hasMessage()
}

// GUI Scenario: Importing spreadsheet in invalid file format

//Given that I am at the Concepts page
//When I import the spreadsheet "sheet.csv"

//And the spreadsheet is not on valid file format
And (~'^the spreadsheet is not on valid file format$') { ->
	at SheetUploadPage
	assert page.validFileFormat == false
}
//Then display error message
Then (~'^display error message$') { ->
	at SheetUploadPage
	assert page.hasErrors()
}

// GUI Scenario: Importing spreadsheet with invalid column

//Given that I am at the Upload Sheet page
//When I import the spreadsheet "invalidColumnSheet.xlsx"
//And the spreadsheet is on valid file format

// And the spreadsheet has invalid columns
And (~'^the spreadsheet has invalid columns$') { ->
	assert !sheetImporter.hasValidColumns()
}
//Then display error message

//Controller Scenario: Importing spreadsheet with non registered student
//Given the valid spreadsheet "validSheet.xlsx" contains a not registered student named "Alan Turing" with login "at"
Given (~'^the valid spreadsheet "([^"]*)" contains a not registered student named "([^"]*)" with login "([^"]*)"$'){ String filename, String name, String login->
	myfilename = filename
	studentName = name
	studentLogin = login

	studentByLogin = Student.findByLogin(studentLogin)
	if (studentByLogin != null){
		studentByLogin.delete(flush:true)
		studentByLogin = Student.findByLogin(studentLogin)
	}

	studentByName = Student.findByName(studentName)
	if (studentByName != null){
		studentByName.delete(flush:true)
		studentByName = Student.findByName(studentName)
	}

	isRegistered = (studentByLogin == studentByName) && studentByLogin != null

	sheetImporter = new SheetImporter("sampleFiles/" + myfilename)
	nameRow = sheetImporter.getNameRow(name)
	loginRow = sheetImporter.getLoginRow(login)
	spreadsheetContains = (nameRow == loginRow) && nameRow != -1

	assert !isRegistered && spreadsheetContains
}

//  When I import the spreadsheet
When (~'^I import the spreadsheet$'){ ->
	sheetController = new SheetController()
	sheetController.uploadSheet("sampleFiles/" + myfilename)
	assert sheetController.hasImported
}


// Then the student is registered
Then (~'^the student is registered$'){ ->
	studentByLogin = Student.findByLogin(studentLogin)
	studentByName = Student.findByName(studentName)
	isRegistered = (studentByLogin == studentByName) && studentByLogin != null

	assert isRegistered
}

//Controller Scenario: Importing spreadsheet with non registered criterion
//Given that the valid spreadsheet "validSheet.xlsx" contains a not registered criterion named "grails"
Given (~'^that the valid spreadsheet "([^"]*)" contains a not registered criterion named "([^"]*)"$'){ String filename, String criterion->
	myfilename = filename
	criterionName = criterion
	criterionByName = EvaluationCriterion.findByName(criterionName)
	if (criterionByName != null){
		criterionByName.delete(flush:true)
		criterionByName = EvaluationCriterion.findByName(criterionName)
	}

	isRegistered = criterionByName != null

	sheetImporter = new SheetImporter("sampleFiles/" + myfilename)

	sheetCriterion = sheetImporter.getCriterion()
	spreadsheetContains = criterionName.equalsIgnoreCase(sheetCriterion)

	assert !isRegistered && spreadsheetContains
}

//  When I import the spreadsheet

// Then the criterion is registered
Then (~'^the criterion is registered$'){ ->
	criterionByName = EvaluationCriterion.findByName(criterionName)
	isRegistered = criterionByName != null

	assert isRegistered
}
