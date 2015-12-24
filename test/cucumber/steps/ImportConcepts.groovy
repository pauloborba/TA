package steps

import commom.SheetImporter
import pages.SheetPages.SheetUploadPage
import ta.EvaluationCriterion
import ta.SheetController
import ta.Student

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

// GUI Scenario: Importing valid spreadsheet (file format and columns) 1

//Given that I am at the Sheet Upload page
Given (~'^that I am at the Sheet Upload page$') {
	->
	to SheetUploadPage
	at SheetUploadPage

}
//And the spreadsheet "validSheet.xlsx" is on valid file format
And (~'^the spreadsheet "([^"]*)" is on valid file format$') { String filename->
	sheetImporter = new SheetImporter("sampleFiles/" + filename)
	assert sheetImporter != null
}

//And the spreadsheet "validSheet.xlsx" contains valid columns
And (~'the spreadsheet "([^"]*)" contains valid columns'){ String filename->
	sheetImporter = new SheetImporter("sampleFiles/" + filename)
	assert sheetImporter.hasValidColumns()
}

//When I select to import the spreadsheet "validSheet.xlsx"
When (~'^I select to import the spreadsheet "([^"]*)"$') {
	String filename ->
		at SheetUploadPage
		myfilename = filename

		page.submit("sampleFiles/" + filename)

}

//Then an upload confirmation message is displayed
Then (~'^an upload confirmation message is displayed$') { ->
	at SheetUploadPage
	assert page.hasMessage()
}

// GUI Scenario: Importing spreadsheet in invalid file format 2

//Given that I am at the Sheet Upload page

//And the spreadsheet "sheet.csv" is not on valid file format
And (~'^the spreadsheet "([^"]*)" is not on valid file format$') { String filename->
	valid = true
	myfilename = filename
	try {
		sheetImporter = new SheetImporter("sampleFiles/" + filename)
	} catch (IllegalArgumentException e){
		valid = false
	}
	assert !valid
}

//When I select to import the spreadsheet "sheet.csv"


//Then display error message
Then (~'^display error message$') { ->
	at SheetUploadPage
	assert page.hasErrors()
}

// GUI Scenario: Importing spreadsheet with invalid column 3

//Given that I am at the Upload Sheet page

//And the spreadsheet "invalidColumnSheet.xlsx" is on valid file format

//And the spreadsheet "invalidColumnSheet.xlsx" contains invalid columns
And (~'^the spreadsheet "([^"]*)" contains invalid columns$') { String filename->
	sheetImporter = new SheetImporter("sampleFiles/" + filename)
	assert !sheetImporter.hasValidColumns()
}

//When I select to import the spreadsheet "invalidColumnSheet.xlsx"
//Then display error message

// Controller Scenario: Importing valid spreadsheet (file format and columns) 4

// Given the spreadsheet "validSheet.xlsx" is on valid file format

//And the spreadsheet "validSheet.xlsx" contains valid columns

// When I import the spreadsheet "validSheet.xlsx"
When (~'^I import the spreadsheet "([^"]*)"$'){ String filename ->
	sheetController = new SheetController()
	sheetController.uploadSheet("sampleFiles/" + filename)
}

// Then update system data accordingly
Then (~'^update system data accordingly$'){ ->
	assert sheetController.hasImported
}

// Controller Scenario: Importing spreadsheet in invalid file format 5
// Given the spreadsheet "sheet.csv" is not on valid file format

// When I import the spreadsheet "sheet.csv"

// Then do not update system data
Then (~'^do not update system data$'){ ->
	assert !sheetController.hasImported
}

// Controller Scenario: Importing spreadsheet with invalid column 6
//  Given the spreadsheet "invalidColumnSheet.xlsx" is on valid file format

// And the spreadsheet "invalidColumnSheet.xlsx" contains invalid columns

// When I import the spreadsheet "sheet.csv"

// Then do not update system data

//Controller Scenario: Importing spreadsheet with non registered student 7
//Given the valid spreadsheet "validSheet.xlsx" contains a not registered student named "Alan Turing" with login "at"
Given (~'^the valid spreadsheet "([^"]*)" contains a not registered student named "([^"]*)" with login "([^"]*)"$'){ String filename, String name, String login->
	studentByLogin = Student.findByLogin(login)
	if (studentByLogin != null){
		studentByLogin.delete(flush:true)
		studentByLogin = Student.findByLogin(login)
	}

	studentByName = Student.findByName(name)
	if (studentByName != null){
		studentByName.delete(flush:true)
		studentByName = Student.findByName(name)
	}

	isRegistered = (studentByLogin == studentByName) && studentByLogin != null

	sheetImporter = new SheetImporter("sampleFiles/" + filename)
	nameRow = sheetImporter.getNameRow(name)
	loginRow = sheetImporter.getLoginRow(login)
	spreadsheetContains = (nameRow == loginRow) && nameRow != -1

	assert !isRegistered && spreadsheetContains
}

//  When  I import the spreadsheet "validSheet.xlsx"

// Then the student named "Alan Turing" with login "at" is registered
Then (~'^the student named "([^"]*)" with login "([^"]*)" is registered$'){ String name, String login ->
	studentByName = Student.findByName(name)
	studentByLogin = Student.findByLogin(login)
	isRegistered = (studentByLogin == studentByName) && studentByLogin != null

	assert isRegistered
}

//Controller Scenario: Importing spreadsheet with non registered criterion 8
//Given that the valid spreadsheet "validSheet.xlsx" contains a not registered criterion named "grails"
Given (~'^that the valid spreadsheet "([^"]*)" contains a not registered criterion named "([^"]*)"$'){ String filename, String criterion->
	criterionByName = EvaluationCriterion.findByName(criterion)
	if (criterionByName != null){
		criterionByName.delete(flush:true)
		criterionByName = EvaluationCriterion.findByName(criterion)
	}

	isRegistered = criterionByName != null

	sheetImporter = new SheetImporter("sampleFiles/" + filename)

	sheetCriterion = sheetImporter.getCriterion()
	spreadsheetContains = criterion.equalsIgnoreCase(sheetCriterion)

	assert !isRegistered && spreadsheetContains
}

//  When I import the spreadsheet

// Then the criterion "grails" is registered
Then (~'^the criterion "([^"]*)" is registered$'){ String criterion ->
	criterionByName = EvaluationCriterion.findByName(criterion)
	isRegistered = criterionByName != null

	assert isRegistered
}
