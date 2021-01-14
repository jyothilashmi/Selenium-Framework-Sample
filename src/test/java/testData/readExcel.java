/*
 * package testData; import java.io.File; import java.io.FileInputStream; import
 * java.io.IOException; import java.util.ArrayList; import java.util.HashMap;
 * import java.util.LinkedHashMap; import java.util.List; import java.util.Map;
 * 
 * import org.apache.poi.ss.usermodel.Cell; import
 * org.apache.poi.ss.usermodel.DataFormatter; import
 * org.apache.poi.ss.usermodel.Row; import org.apache.poi.ss.usermodel.Sheet;
 * import org.apache.poi.ss.usermodel.Workbook; import
 * org.apache.poi.xssf.usermodel.XSSFCell; import
 * org.apache.poi.xssf.usermodel.XSSFRow; import
 * org.apache.poi.xssf.usermodel.XSSFSheet; import
 * org.apache.poi.xssf.usermodel.XSSFWorkbook;
 * 
 * public class readExcel {
 * 
 * 
 * 
 * 
 * 
 * 
 * static String path =
 * "C:\\Users\\j.lakshmi.s\\eclipse-workspace\\excel\\Resources\\QA\\TestData.xlsx";
 * static String sheetName="PendingOrder"; static String TestCase; static
 * DataFormatter df = new DataFormatter();
 * 
 * public static Map<String, String> setMapData() throws IOException { File
 * file=new File(path); FileInputStream fis = new FileInputStream(new
 * File(path));
 * 
 * XSSFWorkbook workbook = new XSSFWorkbook(fis);
 * //System.out.println(workbook); //String sheetName="PendingOrder";
 * 
 * XSSFSheet sheet = workbook.getSheet("PendingOrder"); String
 * testCaseNme="tc002_HOME"; LinkedHashMap<String, String> columnMapdata = new
 * LinkedHashMap<String, String>(); Map<String, String> excelFileMap = new
 * HashMap<String,String>();
 * 
 * for(int i=0; i<= sheet.getLastRowNum(); i++){
 * 
 * 
 * XSSFRow row = sheet.getRow(i);
 * 
 * int lastCell = row.getLastCellNum(); for(int j=0; j<=0; j++){
 * 
 * Cell cell = row.getCell(j); String value = df.formatCellValue(cell); //
 * System.out.println(value); if(value.equals(testCaseNme)) { Row
 * testcasenumber=cell.getRow(); // // starttest=testcasenumber // // for(int
 * l=0;l<testcasenumber.getLastCellNum();l++) { Cell cell1 =
 * testcasenumber.getCell(l); String value1 = df.formatCellValue(cell1);
 * 
 * 
 * //System.out.println(value1); XSSFCell
 * columnHeader=sheet.getRow(sheet.getFirstRowNum()).getCell(l);
 * 
 * String header= df.formatCellValue(columnHeader);
 * 
 * columnMapdata.put(header, value1);
 * 
 * 
 * 
 * // } // for (Map.Entry mapElement : columnMapdata.entrySet()) { // String key
 * = (String)mapElement.getKey(); // String
 * value3=(String)mapElement.getValue(); // //
 * System.out.println("key"+" "+key); // System.out.println("value"+" "+value3);
 * // } // }
 * 
 * 
 * // for(int k=0;k<=lastCell;k++) // { // Cell cell = row.getCell(k); // String
 * columnHeaderName=df.formatCellValue(cell); //
 * 
 * 
 * 
 * } }
 * 
 * // for(int j=0; j<=0; j++){ // // Cell cell = row.getCell(j); // // String
 * value = df.formatCellValue(cell); // // if(value.equals(testCaseNme)) // { //
 * Row testcasenumber=cell.getRow(); // // // } // } //
 * 
 * //} // for(int k=0;k<=sheet.getFirstRowNum();k++) // { // XSSFRow headerrow =
 * sheet.getRow(k); // DataFormatter df1 = new DataFormatter(); // int
 * lastHeadercell = headerrow.getLastCellNum(); // // for(int
 * m=0;m<headerrow.getLastCellNum();m++) // { // Cell cell2 =
 * headerrow.getCell(m); // String value2 = df.formatCellValue(cell2); //
 * System.out.println("header"+value2); // } // }
 * excelFileMap.putAll(columnMapdata);
 * 
 * } } return excelFileMap;
 * 
 * } public static String getMapData(String key) throws IOException{
 * 
 * String m = setMapData().get(key);
 * 
 * return m; } public static void main(String args[]) throws IOException {
 * String va=readExcel.getMapData("DDD"); //readData.setMapData();
 * System.out.println(va); }
 * 
 * 
 * //----read row wise------------ public static Map<String, Map<String,
 * String>> setMapData() throws IOException {
 * 
 * String path = "data/TestDataSheet.xlsx";
 * 
 * FileInputStream fis = new FileInputStream(path);
 * 
 * Workbook workbook = new XSSFWorkbook(fis);
 * 
 * Sheet sheet = workbook.getSheetAt(0);
 * 
 * int lastRow = sheet.getLastRowNum();
 * 
 * Map<String, Map<String, String>> excelFileMap = new HashMap<String,
 * Map<String,String>>();
 * 
 * Map<String, String> dataMap = new HashMap<String, String>();
 * 
 * //Looping over entire row for(int i=0; i<=lastRow; i++){
 * 
 * Row row = sheet.getRow(i);
 * 
 * //1st Cell as Value Cell valueCell = row.getCell(1);
 * 
 * //0th Cell as Key Cell keyCell = row.getCell(0);
 * 
 * String value = valueCell.getStringCellValue().trim(); String key =
 * keyCell.getStringCellValue().trim();
 * 
 * //Putting key & value in dataMap dataMap.put(key, value);
 * 
 * //Putting dataMap to excelFileMap excelFileMap.put("DataSheet", dataMap); }
 * 
 * //Returning excelFileMap return excelFileMap;
 * 
 * }
 * 
 * //Method to retrieve value public static String getMapData(String key) throws
 * IOException{
 * 
 * Map<String, String> m = setMapData().get("DataSheet"); String value =
 * m.get(key);
 * 
 * return value;
 * 
 * }
 * 
 * }
 * 
 * 
 * public static void main(String[] args) throws IOException { readExcel r = new
 * readExcel();
 * 
 * String val = r.getMapData("search");
 * 
 * System.out.println("Value of the keyword (search) is- "+val);
 * 
 * }
 * 
 * }
 * 
 * 
 * 
 * 
 * 
 */