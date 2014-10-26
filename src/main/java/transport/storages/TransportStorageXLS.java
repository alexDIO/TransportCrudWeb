package transport.storages;

import transport.*;
import transport.classes.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by olomakovskyi on 9/12/2014.
 */
public class TransportStorageXLS implements TransportStorage {
    private final TransportPropertiesHolder propertiesHolder;
    private final TransportConverter converter;

    public TransportStorageXLS(TransportPropertiesHolder propertiesHolder, TransportConverter converter) {
        this.propertiesHolder = propertiesHolder;
        this.converter = converter;
    }

    @Override
    public void addTransport(TransportPojo inPojo) throws IOException {
        Transport newTransport = converter.convertPojoToTransport(inPojo);
        TransportPojo newPojo = converter.convertTransportToPojo(newTransport);

        File transportFile = new File(propertiesHolder.getXlsFilename());
        HSSFWorkbook workbook;
        Sheet sheet;

        if (!transportFile.exists()) {
            workbook = new HSSFWorkbook();
            sheet = workbook.createSheet(propertiesHolder.getXlsSheetName());
            org.apache.poi.ss.usermodel.Row row = sheet.createRow(0);
            for (int i = 0; i < 9; i++) {
                row.createCell(i);
            }
            writePojoToExcel(row, newPojo);
        } else {
            FileInputStream inFile = new FileInputStream(transportFile);
            workbook = new HSSFWorkbook(inFile);
            sheet = workbook.getSheet(propertiesHolder.getXlsSheetName());
            Row row = sheet.createRow(sheet.getLastRowNum() + 1);
            for (int i = 0; i < 9; i++) {
                row.createCell(i);
            }
            writePojoToExcel(row, newPojo);
            inFile.close();
        }

        FileOutputStream outFile = new FileOutputStream(new File(propertiesHolder.getXlsFilename()));
        workbook.write(outFile);
        outFile.close();
    }

    @Override
    public void deleteTransport(int id) throws IOException {

        FileInputStream inFile = new FileInputStream(new File(propertiesHolder.getXlsFilename()));
        HSSFWorkbook workbook = new HSSFWorkbook(inFile);
        Sheet sheet = workbook.getSheet(propertiesHolder.getXlsSheetName());
        int lastRowIndex = sheet.getLastRowNum();

        for (int i = 0; i < lastRowIndex; i++) {
            sheet.getRow(i).getCell(0).setCellType(Cell.CELL_TYPE_STRING);
            if (Integer.valueOf(sheet.getRow(i).getCell(0).getStringCellValue()) == id) {
                sheet.shiftRows(i + 1, lastRowIndex, -1);
                sheet.removeRow(sheet.getRow(lastRowIndex));
                lastRowIndex--;
            }
        }

        sheet.getRow(lastRowIndex).getCell(0).setCellType(Cell.CELL_TYPE_STRING);
        if (Integer.valueOf(sheet.getRow(lastRowIndex).getCell(0).getStringCellValue()) == id) {
            sheet.removeRow(sheet.getRow(lastRowIndex));
        }

        inFile.close();

        FileOutputStream outFile = new FileOutputStream(new File(propertiesHolder.getXlsFilename()));
        workbook.write(outFile);
        outFile.close();
    }

    @Override
    public Map<Integer, Transport> getAllTransport() throws IOException {
        Map<Integer, Transport> resultMap = new HashMap<>();
        File transportFile = new File(propertiesHolder.getXlsFilename());

        if (transportFile.exists()) {
            FileInputStream inFile = new FileInputStream(transportFile);
            HSSFWorkbook workbook = new HSSFWorkbook(inFile);
            Sheet sheet = workbook.getSheetAt(0);
            Map<Integer, TransportPojo> pojoMap = getAllPojoFromExcel(sheet);
            inFile.close();

            for (Map.Entry<Integer, TransportPojo> entry : pojoMap.entrySet()) {
                resultMap.put(entry.getKey(), converter.convertPojoToTransport(entry.getValue()));
            }
        }

        return resultMap;
    }

    private void writePojoToExcel(Row targetRow, TransportPojo inPojo) throws FileNotFoundException {
        targetRow.getCell(0).setCellValue(inPojo.getId());
        targetRow.getCell(1).setCellValue(inPojo.getTransportType());
        targetRow.getCell(2).setCellValue(inPojo.getMark());
        targetRow.getCell(3).setCellValue(inPojo.getColor());
        targetRow.getCell(4).setCellValue(inPojo.getManufactureYear());
        targetRow.getCell(5).setCellValue(inPojo.getPassengersCount());
        targetRow.getCell(6).setCellValue(inPojo.getEnergySource());
        targetRow.getCell(7).setCellValue(inPojo.getTransmission());
        targetRow.getCell(8).setCellValue(inPojo.getLoad());
    }

    private Map<Integer, TransportPojo> getAllPojoFromExcel(Sheet targetSheet) {
        Map<Integer, TransportPojo> resultMap = new HashMap<>();
        Row targetRow;
        TransportPojo newPojo;
        int lastRow = targetSheet.getLastRowNum();
        for (int i = 0; i <= lastRow; i++) {
            targetRow = targetSheet.getRow(i);
            //setting Cell format to string to all values that should be integer
            targetRow.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
            targetRow.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
            targetRow.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
            targetRow.getCell(8).setCellType(Cell.CELL_TYPE_STRING);
            newPojo = new TransportPojo();
            int id = Integer.valueOf(targetRow.getCell(0).getStringCellValue());
            newPojo.setId(id);
            newPojo.setTransportType(targetRow.getCell(1).getStringCellValue());
            newPojo.setMark(targetRow.getCell(2).getStringCellValue());
            newPojo.setColor(targetRow.getCell(3).getStringCellValue());
            newPojo.setManufactureYear(Integer.valueOf(targetRow.getCell(4).getStringCellValue()));
            newPojo.setPassengersCount(Integer.valueOf(targetRow.getCell(5).getStringCellValue()));
            newPojo.setEnergySource(targetRow.getCell(6).getStringCellValue());
            newPojo.setTransmission(targetRow.getCell(7).getStringCellValue());
            newPojo.setLoad(Integer.valueOf(targetRow.getCell(8).getStringCellValue()));

            resultMap.put(id, newPojo);
        }

        return resultMap;
    }

}
