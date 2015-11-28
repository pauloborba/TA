package steps

import pages.ConceptPages.ConceptSheetUploadPage
import ta.ConceptController
import pages.ConceptPages.ConceptPage
import ta.Sheet

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

// controller Scenario: Importing valid spreadsheet

Sheet sheet
// Given thse spreadsheet "sheet.csv" is on valid file format

Given (~'^the spreadsheet "([^"]*)" or "([^"]*)" is on valid file format$'){ String filename1, filename2 ->
	conceptController = new ConceptController();
	conceptController.builder.createSheet()

	boolean valid;
	conceptController.builder.setSheetFilename(filename1)
	sheet = conceptController.builder.getSheet()
	valid = sheet.validFileFormat();

	conceptController.builder.setSheetFilename(filename2)
	sheet = conceptController.builder.getSheet()
	valid &= sheet.validFileFormat();

	assert valid;
}

// When I import it’s data
When (~'^I import its data$'){ ->
	conceptController.importSheet(sheet)
}
// Then update system data accordingly
Then (~'^update system data accordingly$'){ ->
	assert conceptController.save();
}
// controller Scenario: Importing invalid spreadsheet

// Given the spreadsheet "sheet.csv" is not on valid file format
Given (~'^the spreadsheet "([^"]*)" is not on valid file format$'){ String filename ->
	conceptController = new ConceptController();
	conceptController.builder.createSheet()
	conceptController.builder.setSheetFilename(filename)
	sheet = conceptController.builder.getSheet()

	assert sheet.validFileFormat() == false
}

// When I try to import it’s data
When (~'^I try to import its data$'){ ->
	conceptController.importSheet(sheet)
}
// Then do not update system data
Then (~'^do not update system data$'){ ->
	assert conceptController.reset()
}

// GUI Scenario: Importing valid spreadsheet

//Given that I am at the Concept page
Given (~'^that I am at the Concepts page$') {
	->
	to ConceptSheetUploadPage
	at ConceptSheetUploadPage

}
//When I select the option to import spreadsheet "sheet.csv"
When (~'^I select the option to import spreadsheet "([^"]*)"$') {
	String file ->
		at ConceptSheetUploadPage
		page.click()
		//page.import(file)
}

//And the spreadsheet is on valid format
And (~'^the spreadsheet is on valid format$') { ->
	assert page.validFileFormat
}
//Then the Concept page displays new data accordingly
Then (~'^the Concepts page displays new data accordingly$') { ->
	at ConceptPage
	page.update()
}

// GUI Scenario: Importing invalid spreadsheet

//And the spreadsheet is not on valid format
And (~'^the spreadsheet is not on valid format$') { ->
	assert page.validFileFormat == false
}
//Then displays error message
Then (~'^display error message$') { ->
	at ConceptSheetUploadPage

	assert page.hasDisplayedError()
}