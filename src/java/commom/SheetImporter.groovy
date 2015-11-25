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
    }

    public boolean hasValidColumns(){
        boolean isValid = true;
        def sheet = this.workbook.getSheetAt(0);
        def row = sheet.getRow(0);
        def header;

        header = row.getCell(0).stringCellValue;
        if (!header.equalsIgnoreCase("aluno")) isValid = false;

        header = row.getCell(1).stringCellValue;
        if (!header.equalsIgnoreCase("login")) isValid = false;

        header = row.getCell(2).stringCellValue;
        if (header.length() == 0) isValid = false;



        return isValid;
    }

    public int getNameRow(String name){
        int row = -1
        def sheet = this.workbook.getSheetAt(0)

        for (i in 0..sheet.getLastRowNum()){
            if (sheet.getRow(i).getCell(0).stringCellValue.equalsIgnoreCase(name)){
                row = i
                break
            }
        }
        return row
    }

    public int getLoginRow(String login){
        int row = -1
        def sheet = this.workbook.getSheetAt(0)

        for (i in 0..sheet.getLastRowNum()){
            if (sheet.getRow(i).getCell(1).stringCellValue.equalsIgnoreCase(login)){
                row = i
                break
            }
        }
        return row
    }

}
