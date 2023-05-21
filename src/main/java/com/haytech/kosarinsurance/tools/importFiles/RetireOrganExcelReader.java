package com.haytech.kosarinsurance.tools.importFiles;

import com.haytech.kosarinsurance.model.entity.NonlifeInsurance;
import com.haytech.kosarinsurance.model.entity.RetireOrgan;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class RetireOrganExcelReader {
    public List<RetireOrgan> readExcelFile(MultipartFile file, Integer numberOfSheet) {
        List<RetireOrgan> retireOrgans = new ArrayList<>();

        try (XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream())) {
            if (numberOfSheet == null || numberOfSheet < 0) {
                numberOfSheet = workbook.getNumberOfSheets();
            }
            // Save the Excel file to the D: drive
            LocalDateTime localDateTime=LocalDateTime.now();
            String formatedDateBasic = DateTimeFormatter.BASIC_ISO_DATE.format(localDateTime);
            String fileName = "lifeInsurance" + "-" + formatedDateBasic;
            try (FileOutputStream outputStream = new FileOutputStream("F:/ImportKosarFile"+fileName+".xlsx")) {
                workbook.write(outputStream);
            }
            Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet
            for (int i = 2; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row == null) {
                    continue; // Skip empty rows if any
                }
                RetireOrgan retireOrgan = new RetireOrgan();

                Cell codcCell = row.getCell(0);
                if (codcCell != null && codcCell.getCellType() == CellType.STRING) {
                    retireOrgan.setCodc(codcCell.getStringCellValue());
                }

                Cell shahCell = row.getCell(1);
                if (shahCell != null && shahCell.getCellType() == CellType.STRING) {
                    retireOrgan.setShah(shahCell.getStringCellValue());
                }

                Cell shkhCell = row.getCell(2);
                if (shkhCell != null && shkhCell.getCellType() == CellType.STRING) {
                    retireOrgan.setShkh(shkhCell.getStringCellValue());
                }
                Cell codvCell = row.getCell(3);
                if (codvCell != null && codvCell.getCellType() == CellType.STRING) {
                    retireOrgan.setCodv(codvCell.getStringCellValue());
                }
                Cell namvCell = row.getCell(4);
                if (namvCell != null && namvCell.getCellType() == CellType.STRING) {
                    retireOrgan.setNamv(namvCell.getStringCellValue());
                }
                Cell theCell = row.getCell(5);
                if (theCell != null && theCell.getCellType() == CellType.STRING) {
                    retireOrgan.setThe(theCell.getStringCellValue());
                }
                Cell tarbCell = row.getCell(6);
                if (tarbCell != null && tarbCell.getCellType() == CellType.STRING) {
                    retireOrgan.setTarb(tarbCell.getStringCellValue());
                }
                Cell mgheCell = row.getCell(7);
                if (mgheCell != null && mgheCell.getCellType() == CellType.STRING) {
                    retireOrgan.setMghe(mgheCell.getStringCellValue());
                }
                Cell kasrCell = row.getCell(8);
                if (kasrCell != null && kasrCell.getCellType() == CellType.STRING) {
                    retireOrgan.setKasr(kasrCell.getStringCellValue());
                }
                Cell mabvCell = row.getCell(9);
                if (mabvCell != null && mabvCell.getCellType() == CellType.STRING) {
                    retireOrgan.setMabv(mabvCell.getStringCellValue());
                }
                Cell albvCell = row.getCell(10);
                if (albvCell != null && albvCell.getCellType() == CellType.STRING) {
                    retireOrgan.setAlbv(albvCell.getStringCellValue());
                }
                Cell mahpCell = row.getCell(11);
                if (mahpCell != null && mahpCell.getCellType() == CellType.STRING) {
                    retireOrgan.setMahp(mahpCell.getStringCellValue());
                }
                Cell tksCell = row.getCell(12);
                if (tksCell != null && tksCell.getCellType() == CellType.STRING) {
                    retireOrgan.setTks(tksCell.getStringCellValue());
                }
                Cell ellatCell = row.getCell(13);
                if (ellatCell != null && ellatCell.getCellType() == CellType.STRING) {
                    retireOrgan.setEllat(ellatCell.getStringCellValue());
                }
                Cell codmCell = row.getCell(14);
                if (codmCell != null && codmCell.getCellType() == CellType.STRING) {
                    retireOrgan.setCodm(codmCell.getStringCellValue());
                }
                Cell actCell = row.getCell(15);
                if (actCell != null && actCell.getCellType() == CellType.STRING) {
                    retireOrgan.setAct(actCell.getStringCellValue());
                }
                Cell csabCell = row.getCell(16);
                if (csabCell != null && csabCell.getCellType() == CellType.STRING) {
                    retireOrgan.setCsab(csabCell.getStringCellValue());
                }
                Cell tavgCell = row.getCell(17);
                if (tavgCell != null && tavgCell.getCellType() == CellType.STRING) {
                    retireOrgan.setTavg(tavgCell.getStringCellValue());
                }
                Cell shvamCell = row.getCell(18);
                if (shvamCell != null && shvamCell.getCellType() == CellType.STRING) {
                    retireOrgan.setShvam(shvamCell.getStringCellValue());
                }
                Cell dfotCell = row.getCell(19);
                if (dfotCell != null && dfotCell.getCellType() == CellType.STRING) {
                    retireOrgan.setDfot(dfotCell.getStringCellValue());
                }
                Cell elatCell = row.getCell(20);
                if (elatCell != null && elatCell.getCellType() == CellType.STRING) {
                    retireOrgan.setElat(elatCell.getStringCellValue());
                }


//                // Validate the required fields
//                if (lifeInsurance.getShobehCod() == null || lifeInsurance.getShobehName() == null || lifeInsurance.getBimehNo() == null) {
//                    // Handle missing required fields
//                    continue; // Skip this row
//                }

                // Validate additional fields and perform other business rules as needed

                retireOrgans.add(retireOrgan);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return retireOrgans;
    }
}
