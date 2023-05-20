package com.haytech.kosarinsurance.tools;

import com.haytech.kosarinsurance.model.entity.NonlifeInsurance;
import com.haytech.kosarinsurance.service.NonLifeInsuranceService;
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

public class NonLifeInsuranceExcelReader {
    public List<NonlifeInsurance> readExcelFile(MultipartFile file, Integer numberOfSheet) {
        List<NonlifeInsurance> nonLifeInsurances = new ArrayList<>();

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
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row == null) {
                    continue; // Skip empty rows if any
                }
                NonlifeInsurance nonLifeInsurance = new NonlifeInsurance();

                Cell contractNumberCell = row.getCell(0);
                if (contractNumberCell != null && contractNumberCell.getCellType() == CellType.STRING) {
                    nonLifeInsurance.setContractNumber(contractNumberCell.getStringCellValue());
                }

                Cell debtIndexCell = row.getCell(1);
                if (debtIndexCell != null && debtIndexCell.getCellType() == CellType.STRING) {
                    nonLifeInsurance.setDebtIndex(debtIndexCell.getStringCellValue());
                }

                Cell debtGroupCell = row.getCell(2);
                if (debtGroupCell != null && debtGroupCell.getCellType() == CellType.STRING) {
                    nonLifeInsurance.setDebtGroup(debtGroupCell.getStringCellValue());
                }
                Cell unitCodeCell = row.getCell(3);
                if (unitCodeCell != null && unitCodeCell.getCellType() == CellType.STRING) {
                    nonLifeInsurance.setUnitCode(unitCodeCell.getStringCellValue());
                }
                Cell assetCodeCell = row.getCell(4);
                if (assetCodeCell != null && assetCodeCell.getCellType() == CellType.STRING) {
                    nonLifeInsurance.setAssetCode(assetCodeCell.getStringCellValue());
                }
                Cell issuanceUnitCodeCell = row.getCell(5);
                if (issuanceUnitCodeCell != null && issuanceUnitCodeCell.getCellType() == CellType.STRING) {
                    nonLifeInsurance.setInsuranceUnitCode(issuanceUnitCodeCell.getStringCellValue());
                }
                Cell issuanceUnitNameCell = row.getCell(6);
                if (issuanceUnitNameCell != null && issuanceUnitNameCell.getCellType() == CellType.STRING) {
                    nonLifeInsurance.setInsuranceUnitName(issuanceUnitNameCell.getStringCellValue());
                }
                Cell insurancePolicyNumberCell = row.getCell(7);
                if (insurancePolicyNumberCell != null && insurancePolicyNumberCell.getCellType() == CellType.STRING) {
                    nonLifeInsurance.setInsurancePolicyNumber(insurancePolicyNumberCell.getStringCellValue());
                }
                Cell fieldTitleCell = row.getCell(8);
                if (fieldTitleCell != null && fieldTitleCell.getCellType() == CellType.STRING) {
                    nonLifeInsurance.setFieldTitle(fieldTitleCell.getStringCellValue());
                }
                Cell fieldCodeCell = row.getCell(9);
                if (fieldCodeCell != null && fieldCodeCell.getCellType() == CellType.STRING) {
                    nonLifeInsurance.setFieldCode(fieldCodeCell.getStringCellValue());
                }
                Cell insuranceDateCell = row.getCell(10);
                if (insuranceDateCell != null && insuranceDateCell.getCellType() == CellType.STRING) {
                    nonLifeInsurance.setInsuranceDate(insuranceDateCell.getStringCellValue());
                }
                Cell startDateCell = row.getCell(11);
                if (startDateCell != null && startDateCell.getCellType() == CellType.STRING) {
                    nonLifeInsurance.setStartDate(startDateCell.getStringCellValue());
                }
                Cell endDateCell = row.getCell(12);
                if (endDateCell != null && endDateCell.getCellType() == CellType.STRING) {
                    nonLifeInsurance.setEndDate(endDateCell.getStringCellValue());
                }
                Cell insurerNameCell = row.getCell(13);
                if (insurerNameCell != null && insurerNameCell.getCellType() == CellType.STRING) {
                    nonLifeInsurance.setInsurerName(insurerNameCell.getStringCellValue());
                }
                Cell insurerLastNameCell = row.getCell(14);
                if (insurerLastNameCell != null && insurerLastNameCell.getCellType() == CellType.STRING) {
                    nonLifeInsurance.setInsurerLastName(insurerLastNameCell.getStringCellValue());
                }
                Cell insurerNationalCodeCell = row.getCell(15);
                if (insurerNationalCodeCell != null && insurerNationalCodeCell.getCellType() == CellType.STRING) {
                    nonLifeInsurance.setInsurerNationalCode(insurerNationalCodeCell.getStringCellValue());
                }
                Cell payerNameCell = row.getCell(16);
                if (payerNameCell != null && payerNameCell.getCellType() == CellType.STRING) {
                    nonLifeInsurance.setPayerName(payerNameCell.getStringCellValue());
                }
                Cell payerLastNameCell = row.getCell(17);
                if (payerLastNameCell != null && payerLastNameCell.getCellType() == CellType.STRING) {
                    nonLifeInsurance.setPayerLastName(payerLastNameCell.getStringCellValue());
                }
                Cell payerPersonnelCodeCell = row.getCell(18);
                if (payerPersonnelCodeCell != null && payerPersonnelCodeCell.getCellType() == CellType.STRING) {
                    nonLifeInsurance.setPayerPersonnelCode(payerPersonnelCodeCell.getStringCellValue());
                }
                Cell payerNationalCodeCell = row.getCell(19);
                if (payerNationalCodeCell != null && payerNationalCodeCell.getCellType() == CellType.STRING) {
                    nonLifeInsurance.setPayerNationalCode(payerNationalCodeCell.getStringCellValue());
                }
                Cell employmentStatusCell = row.getCell(20);
                if (employmentStatusCell != null && employmentStatusCell.getCellType() == CellType.STRING) {
                    nonLifeInsurance.setEmploymentStatus(employmentStatusCell.getStringCellValue());
                }
                Cell insuranceAmountCell = row.getCell(21);
                if (insuranceAmountCell != null && insuranceAmountCell.getCellType() == CellType.NUMERIC) {
                    nonLifeInsurance.setInsuranceAmount(insuranceAmountCell.getNumericCellValue());
                }
                Cell insuranceBalanceCell = row.getCell(22);
                if (insuranceBalanceCell != null && insuranceBalanceCell.getCellType() == CellType.NUMERIC) {
                    nonLifeInsurance.setInsuranceBalance(insuranceBalanceCell.getNumericCellValue());
                }
                Cell installmentAmountCell = row.getCell(23);
                if (installmentAmountCell != null && installmentAmountCell.getCellType() == CellType.NUMERIC) {
                    nonLifeInsurance.setInstallmentAmount(installmentAmountCell.getNumericCellValue());
                }
                Cell installmentCountCell = row.getCell(24);
                if (installmentCountCell != null && installmentCountCell.getCellType() == CellType.NUMERIC) {
                    nonLifeInsurance.setInstallmentCount((int) installmentCountCell.getNumericCellValue());
                }
                Cell insurerMobileNumberCell = row.getCell(25);
                if (insurerMobileNumberCell != null && insurerMobileNumberCell.getCellType() == CellType.STRING) {
                    nonLifeInsurance.setInsurerMobileNumber(insurerMobileNumberCell.getStringCellValue());
                }



//                // Validate the required fields
//                if (lifeInsurance.getShobehCod() == null || lifeInsurance.getShobehName() == null || lifeInsurance.getBimehNo() == null) {
//                    // Handle missing required fields
//                    continue; // Skip this row
//                }

                // Validate additional fields and perform other business rules as needed

                nonLifeInsurances.add(nonLifeInsurance);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return nonLifeInsurances;
    }
}
