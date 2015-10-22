package commom

import ta.Evaluation
import ta.Sheet

public interface ISheetBuilder {

	public void createSheet();
	public void setSheetFilename(String name);
	public Sheet getSheet();

}