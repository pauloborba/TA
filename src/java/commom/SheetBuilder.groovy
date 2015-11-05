package commom

import ta.Evaluation
import ta.Sheet

class SheetBuilder implements ISheetBuilder {

	private Sheet _Sheet

	public void createSheet() {
		_Sheet = new Sheet()
	}

	public void setSheetFilename(String name) {
		_Sheet.filename = name
	}

	public Sheet getSheet(){
		return this._Sheet;
	}

}