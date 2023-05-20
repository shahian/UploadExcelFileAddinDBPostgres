package com.haytech.kosarinsurance.service;

import com.haytech.kosarinsurance.model.entity.LifeInsurance;
import com.haytech.kosarinsurance.repository.LifeInsuranceRepository;
import com.haytech.kosarinsurance.tools.LifeInsuranceExcelReader;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class LifeInsuranceService {
    private final LifeInsuranceRepository lifeInsuranceRepository;

    public LifeInsuranceService(LifeInsuranceRepository lifeInsuranceRepository) {
        this.lifeInsuranceRepository = lifeInsuranceRepository;
    }

    public List<LifeInsurance> getAllLifeInsurances() {
        return lifeInsuranceRepository.findAll();
    }

    public Optional<LifeInsurance> getLifeInsuranceById(Long id) {
        return lifeInsuranceRepository.findById(id);
    }

    public LifeInsurance createLifeInsurance(LifeInsurance lifeInsurance) {
        return lifeInsuranceRepository.save(lifeInsurance);
    }

    public LifeInsurance updateLifeInsurance(LifeInsurance lifeInsurance) {
        Optional<LifeInsurance> existingLifeInsurance = lifeInsuranceRepository.findByIdAndIsDeletedFalse(lifeInsurance.getId());
        if (existingLifeInsurance.isPresent()) {
            return lifeInsuranceRepository.save(lifeInsurance);
        } else {
            return null;
        }

    }

    public void deleteLifeInsurance(Long id) {

        Optional<LifeInsurance> lifeInsurance = lifeInsuranceRepository.findByIdAndIsDeletedFalse(id);
        if (lifeInsurance.isPresent()) {
            lifeInsurance.get().setIsDeleted(false);
            lifeInsuranceRepository.save(lifeInsurance.get());
        }
    }

    public void upload(MultipartFile file, Integer numberOfSheet) throws IOException {
        LifeInsuranceExcelReader lifeInsuranceExcelReader = new LifeInsuranceExcelReader();
        List<LifeInsurance> lifeInsurances = lifeInsuranceExcelReader.readExcelFile2(file, numberOfSheet);
        lifeInsuranceRepository.saveAll(lifeInsurances);
    }

    public String upload1(MultipartFile file, Integer numberOfSheet) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
        if (numberOfSheet == null || numberOfSheet < 0) {
            numberOfSheet = workbook.getNumberOfSheets();
        }
        for (int i = 0; i < numberOfSheet; i++) {
            // Getting the Sheet at index i
            Sheet sheet = workbook.getSheetAt(i);
            System.out.println("=> " + sheet.getSheetName());
            // Create a DataFormatter to format and get each cell's value as String
            DataFormatter dataFormatter = new DataFormatter();
            // 1. You can obtain a rowIterator and columnIterator and iterate over them
            System.out.println("Iterating over Rows and Columns using Iterator");
            Iterator<Row> rowIterator = sheet.rowIterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                // Now let's iterate over the columns of the current row
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    String cellValue = dataFormatter.formatCellValue(cell);
                    System.out.print(cellValue + "\t");
                }
                System.out.println();
            }
        }
        return "OK";
    }
}
