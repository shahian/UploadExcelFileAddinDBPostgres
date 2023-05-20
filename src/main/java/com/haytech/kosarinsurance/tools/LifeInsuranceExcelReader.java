package com.haytech.kosarinsurance.tools;

import com.haytech.kosarinsurance.model.entity.LifeInsurance;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LifeInsuranceExcelReader {


    public List<LifeInsurance> readExcelFile2(MultipartFile file, Integer numberOfSheet) {
        List<LifeInsurance> lifeInsurances = new ArrayList<>();

        try (XSSFWorkbook workbook =new XSSFWorkbook(file.getInputStream())) {
            if (numberOfSheet == null || numberOfSheet < 0) {
                numberOfSheet = workbook.getNumberOfSheets();
            }
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
                LifeInsurance lifeInsurance = new LifeInsurance();

                Cell shobehCodCell = row.getCell(0);
                if (shobehCodCell != null && shobehCodCell.getCellType() == CellType.STRING) {
                    lifeInsurance.setShobehCod(shobehCodCell.getStringCellValue());
                }

                Cell shobehNameCell = row.getCell(1);
                if (shobehNameCell != null && shobehNameCell.getCellType() == CellType.STRING) {
                    lifeInsurance.setShobehName(shobehNameCell.getStringCellValue());
                }

                Cell bimehNoCell = row.getCell(2);
                if (bimehNoCell != null && bimehNoCell.getCellType() == CellType.STRING) {
                    lifeInsurance.setBimehNo(bimehNoCell.getStringCellValue());
                }
                Cell shtsCell = row.getCell(3);
                if (shtsCell != null && shtsCell.getCellType() == CellType.STRING) {
                    lifeInsurance.setShts(shtsCell.getStringCellValue());
                }
                Cell shtsCodeCell = row.getCell(4);
                if (shtsCodeCell != null && shtsCodeCell.getCellType() == CellType.STRING) {
                    lifeInsurance.setShtsCode(shtsCodeCell.getStringCellValue());
                }
                Cell dateSodorCell = row.getCell(5);
                if (dateSodorCell != null && dateSodorCell.getCellType() == CellType.STRING) {
                    lifeInsurance.setDateSodor(dateSodorCell.getStringCellValue());
                }
                Cell dateStartCell = row.getCell(6);
                if (dateStartCell != null && dateStartCell.getCellType() == CellType.STRING) {
                    lifeInsurance.setDateStart(dateStartCell.getStringCellValue());
                }
                Cell dateEnsCell = row.getCell(7);
                if (dateEnsCell != null && dateEnsCell.getCellType() == CellType.STRING) {
                    lifeInsurance.setDateEns(dateEnsCell.getStringCellValue());
                }
                Cell nameBimehGozarCell = row.getCell(8);
                if (nameBimehGozarCell != null && nameBimehGozarCell.getCellType() == CellType.STRING) {
                    lifeInsurance.setNameBimehGozar(nameBimehGozarCell.getStringCellValue());
                }
                Cell familyBimehGozarCell = row.getCell(9);
                if (familyBimehGozarCell != null && familyBimehGozarCell.getCellType() == CellType.STRING) {
                    lifeInsurance.setFamilyBimehGozar(familyBimehGozarCell.getStringCellValue());
                }
                Cell firstNameCell = row.getCell(10);
                if (firstNameCell != null && firstNameCell.getCellType() == CellType.STRING) {
                    lifeInsurance.setFirstName(firstNameCell.getStringCellValue());
                }
                Cell lastNameCell = row.getCell(11);
                if (lastNameCell != null && lastNameCell.getCellType() == CellType.STRING) {
                    lifeInsurance.setLastName(lastNameCell.getStringCellValue());
                }
                Cell prsNoCell = row.getCell(12);
                if (prsNoCell != null && prsNoCell.getCellType() == CellType.STRING) {
                    lifeInsurance.setPrsNo(prsNoCell.getStringCellValue());
                }
                Cell codeYeganCell = row.getCell(13);
                if (codeYeganCell != null && codeYeganCell.getCellType() == CellType.STRING) {
                    lifeInsurance.setCodeYegan(codeYeganCell.getStringCellValue());
                }
                Cell codeDaraeiCell = row.getCell(14);
                if (codeDaraeiCell != null && codeDaraeiCell.getCellType() == CellType.STRING) {
                    lifeInsurance.setCodeDaraei(codeDaraeiCell.getStringCellValue());
                }
                Cell codMeliCell = row.getCell(15);
                if (codMeliCell != null && codMeliCell.getCellType() == CellType.STRING) {
                    lifeInsurance.setCodMeli(codMeliCell.getStringCellValue());
                }
                Cell vaziatCell = row.getCell(16);
                if (vaziatCell != null && vaziatCell.getCellType() == CellType.STRING) {
                    lifeInsurance.setVaziat(vaziatCell.getStringCellValue());
                }
                Cell codeKosorCell = row.getCell(17);
                if (codeKosorCell != null && codeKosorCell.getCellType() == CellType.STRING) {
                    lifeInsurance.setCodeKosor(codeKosorCell.getStringCellValue());
                }
                Cell hagBimehCell = row.getCell(18);
                if (hagBimehCell != null && hagBimehCell.getCellType() == CellType.NUMERIC) {
                    lifeInsurance.setHagBimeh(hagBimehCell.getNumericCellValue());
                }
                Cell mandehCell = row.getCell(19);
                if (mandehCell != null && mandehCell.getCellType() == CellType.NUMERIC) {
                    lifeInsurance.setMandeh(mandehCell.getNumericCellValue());
                }
                Cell ghestCell = row.getCell(20);
                if (ghestCell != null && ghestCell.getCellType() == CellType.NUMERIC) {
                    lifeInsurance.setGhest(ghestCell.getNumericCellValue());
                }
                Cell ghestNoCell = row.getCell(21);
                if (ghestNoCell != null && ghestNoCell.getCellType() == CellType.NUMERIC) {
                    lifeInsurance.setGhestNo(ghestNoCell.getNumericCellValue());
                }
                Cell dateGhestCell = row.getCell(22);
                if (dateGhestCell != null && dateGhestCell.getCellType() == CellType.STRING) {
                    lifeInsurance.setDateGhest(dateGhestCell.getStringCellValue());
                }
                Cell telhCell = row.getCell(23);
                if (telhCell != null && telhCell.getCellType() == CellType.STRING) {
                    lifeInsurance.setTelh(telhCell.getStringCellValue());
                }
                Cell billCodCell = row.getCell(24);
                if (billCodCell != null && billCodCell.getCellType() == CellType.STRING) {
                    lifeInsurance.setBillCod(billCodCell.getStringCellValue());
                }
                Cell paymentCodCell = row.getCell(25);
                if (paymentCodCell != null && paymentCodCell.getCellType() == CellType.STRING) {
                    lifeInsurance.setPaymentCod(paymentCodCell.getStringCellValue());
                }
                Cell tgheCell = row.getCell(26);
                if (tgheCell != null && tgheCell.getCellType() == CellType.NUMERIC) {
                    lifeInsurance.setTghe((int) tgheCell.getNumericCellValue());
                }
                Cell tgheTypeCell = row.getCell(27);
                if (tgheTypeCell != null && tgheTypeCell.getCellType() == CellType.STRING) {
                    lifeInsurance.setTgheType(tgheTypeCell.getStringCellValue());
                }
                Cell movafeghtaNamehCell = row.getCell(28);
                if (movafeghtaNamehCell != null && movafeghtaNamehCell.getCellType() == CellType.STRING) {
                    lifeInsurance.setMovafeghtaNameh(movafeghtaNamehCell.getStringCellValue());
                }


//                // Validate the required fields
//                if (lifeInsurance.getShobehCod() == null || lifeInsurance.getShobehName() == null || lifeInsurance.getBimehNo() == null) {
//                    // Handle missing required fields
//                    continue; // Skip this row
//                }

                // Validate additional fields and perform other business rules as needed

                lifeInsurances.add(lifeInsurance);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lifeInsurances;
    }

}
