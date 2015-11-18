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

    List<Map> getConcepts(){
        Map CONFIG_COLUMN_MAP = [
                sheet: this.workbook.getSheetAt(0).getSheetName(),
                startRow: 1,
                columnMap: [
                        'A':'login',
                        'B':'conceito'
                ]
        ]
        List conceptList = excelImportService.columns(workbook, CONFIG_COLUMN_MAP)
    }


}
