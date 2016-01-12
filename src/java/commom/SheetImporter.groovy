package commom

import org.grails.plugins.excelimport.AbstractExcelImporter
import org.grails.plugins.excelimport.ExcelImportService

/**
 * Created by gaabs on 16/11/15.
 */
class SheetImporter extends AbstractExcelImporter{

    def getExcelImportService(){
        ExcelImportService.getService()
    }

    public SheetImporter(fileName){
        super(fileName)

    }

    public String getCriterion(){
        String criterion = this.workbook.getSheetAt(0).getRow(0).getCell(2).stringCellValue;
        return criterion;
    }

    public List<Map> getConcepts(){
        String criterion = getCriterion();
        Map CONFIG_COLUMN_MAP = [
                sheet: this.workbook.getSheetAt(0).getSheetName(),
                startRow: 1,
                columnMap: [
                        'A':'aluno',
                        'B':'login',
                        'C': criterion,
                ]
        ]
        List conceptList = excelImportService.columns(workbook, CONFIG_COLUMN_MAP)
        return conceptList
    }

    public boolean hasValidColumns(){
        boolean isValid = true;
        def sheet = this.workbook.getSheetAt(0);
        def row = sheet.getRow(0);

        isValid &= hasHeader(row,0,"aluno")
        isValid &= hasHeader(row,1,"login")

        def criterion = row.getCell(2).stringCellValue;
        if (criterion.length() == 0) isValid = false;

        return isValid;
    }

    private boolean hasHeader(row, cell, name) {
        def header = row.getCell(cell).stringCellValue;

        return header.equalsIgnoreCase(name)
    }

    public int getNameRow(String name){
        return getRowNum(0,name)
    }

    public int getLoginRow(String login){
        return getRowNum(1,login)
    }

    private int getRowNum(int cell, String login) {
        int row = -1
        def sheet = this.workbook.getSheetAt(0)

        for (i in 0..sheet.getLastRowNum()) {
            if (sheet.getRow(i).getCell(cell).stringCellValue.equalsIgnoreCase(login)) {
                row = i
                break
            }
        }
        return row
    }


}
