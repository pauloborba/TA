package commom

import org.grails.plugins.excelimport.AbstractExcelImporter
import org.grails.plugins.excelimport.ExcelImportService

/**
 * Created by gaabs on 16/11/15.
 */
class SheetImporter extends AbstractExcelImporter{

//    static Map CONFIG_COLUMN_MAP = [
//            sheet: this.sheet.getSheetName(),
//            startRow: 1,
//            columnMap: [
//                    'A':'login',
//                    'B':'conceito'
//            ]
//    ]

    def getExcelImportService(){
        ExcelImportService.getService()
    }

    public SheetImporter(fileName){
        super(fileName)

    }

    public String getCriterion(){
        String criterion = this.workbook.getSheetAt(0).getRow(0).getCell(1).stringCellValue;
        return criterion;
    }

    List<Map> getConcepts(){
        String criterion = getCriterion();
        Map CONFIG_COLUMN_MAP = [
                sheet: this.workbook.getSheetAt(0).getSheetName(),
                startRow: 1,
                columnMap: [
                        'A':'login',
                        'B': criterion
                ]
        ]
        List conceptList = excelImportService.columns(workbook, CONFIG_COLUMN_MAP)
    }


}
