package steps

import commom.SheetImporter
import pages.ConceptPages.ConceptSheetUploadPage
import ta.ConceptController
import pages.ConceptPages.ConceptPage
import ta.EvaluationCriterion
import ta.Sheet
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
	conceptController = new ConceptController()
	conceptController.uploadSheet("sampleFiles/" + myfilename)
}

//And the spreadsheet contains valid columns
And (~'the spreadsheet contains valid columns'){ ->
	assert sheetImporter.hasValidColumns()
}

// Then update system data accordingly
Then (~'^update system data accordingly$'){ ->
	assert conceptController.hasImported
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
	assert !conceptController.hasImported
}

// Controller Scenario: Importing spreadsheet with invalid column
// Given the spreadsheet "sheet.csv" is not on valid file format

// When I try to import it’s data

//And the spreadsheet contains invalid columns
And (~'the spreadsheet contains invalid columns'){ ->
	assert !sheetImporter.hasValidColumns()
}

// Then do not update system data

// GUI Scenario: Importing valid spreadsheet (file format and columns)

//Given that I am at the Concept page
Given (~'^that I am at the Concepts page$') {
	->
	to ConceptSheetUploadPage
	at ConceptSheetUploadPage

}
//When I select the option to import spreadsheet "validSheet.xlsx"
When (~'^I select the option to import spreadsheet "([^"]*)"$') {
	String file ->
		at ConceptSheetUploadPage
		page.click()
		//page.import(file)
}

//And the spreadsheet is on valid file format
And (~'^the spreadsheet is on valid file format$') { ->
	assert page.validFileFormat
}

//And the spreadsheet contains valid columns

//Then an upload confirmation message is displayed
Then (~'^an upload confirmation message is displayed$') { ->
//	at ConceptPage
//	page.update()
}

// GUI Scenario: Importing spreadsheet in invalid file format

//Given that I am at the Concepts page
//When I select the option to import spreadsheet "sheet.csv"

//And the spreadsheet is not on valid file format
And (~'^the spreadsheet is not on valid file format$') { ->
	assert page.validFileFormat == false
}
//Then displays error message
Then (~'^display error message$') { ->
	at ConceptSheetUploadPage

	assert page.hasDisplayedError()
}

// GUI Scenario: Importing spreadsheet with invalid column

//Given that I am at the Concepts page
//When I select the option to import spreadsheet "invalidColumnSheet.xlsx"
//And the spreadsheet is on valid file format

// And the spreadsheet has invalid columns
And (~'^the spreadsheet has invalid columns$') { ->

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
	conceptController = new ConceptController()
	conceptController.uploadSheet("sampleFiles/" + myfilename)
	assert conceptController.hasImported
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
