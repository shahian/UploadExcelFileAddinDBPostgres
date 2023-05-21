package com.haytech.kosarinsurance.tools.exportFiles;

import com.haytech.kosarinsurance.model.entity.RetireOrgan;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class RetireOrganExportToExcel {
    public static void exportToExcel(List<RetireOrgan> retireOrgans) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("RetireOrgan Data");
        //create header
        Row headerRow = sheet.createRow(0);

        headerRow.createCell(0).setCellValue("CODC");
        headerRow.createCell(1).setCellValue("SHAH");
        headerRow.createCell(2).setCellValue("SHKH");
        headerRow.createCell(3).setCellValue("CODV");
        headerRow.createCell(4).setCellValue("NAMV");
        headerRow.createCell(5).setCellValue("THE");
        headerRow.createCell(6).setCellValue("TARB");
        headerRow.createCell(7).setCellValue("MGHE");
        headerRow.createCell(8).setCellValue("KASR");
        headerRow.createCell(9).setCellValue("MABV");
        headerRow.createCell(10).setCellValue("ALBV");
        headerRow.createCell(11).setCellValue("MAHP");
        headerRow.createCell(12).setCellValue("TKS");
        headerRow.createCell(13).setCellValue("ELLAT");
        headerRow.createCell(14).setCellValue("CODM");
        headerRow.createCell(15).setCellValue("ACT");
        headerRow.createCell(16).setCellValue("CSAB");
        headerRow.createCell(17).setCellValue("TAVG");
        headerRow.createCell(18).setCellValue("SHVAM");
        headerRow.createCell(19).setCellValue("DFOT");
        headerRow.createCell(20).setCellValue("ELAT");
        int rowNumber = 1;
        for (RetireOrgan retireOrgan : retireOrgans) {
            headerRow.createCell(0).setCellValue(retireOrgan.getCodc());
            headerRow.createCell(1).setCellValue(retireOrgan.getShah());
            headerRow.createCell(2).setCellValue(retireOrgan.getShkh());
            headerRow.createCell(3).setCellValue(retireOrgan.getCodv());
            headerRow.createCell(4).setCellValue(retireOrgan.getNamv());
            headerRow.createCell(5).setCellValue(retireOrgan.getThe());
            headerRow.createCell(6).setCellValue(retireOrgan.getTarb());
            headerRow.createCell(7).setCellValue(retireOrgan.getMghe());
            headerRow.createCell(8).setCellValue(retireOrgan.getKasr());
            headerRow.createCell(9).setCellValue(retireOrgan.getMabv());
            headerRow.createCell(10).setCellValue(retireOrgan.getAlbv());
            headerRow.createCell(11).setCellValue(retireOrgan.getMahp());
            headerRow.createCell(12).setCellValue(retireOrgan.getTks());
            headerRow.createCell(13).setCellValue(retireOrgan.getEllat());
            headerRow.createCell(14).setCellValue(retireOrgan.getCodm());
            headerRow.createCell(15).setCellValue(retireOrgan.getAct());
            headerRow.createCell(16).setCellValue(retireOrgan.getCsab());
            headerRow.createCell(17).setCellValue(retireOrgan.getTavg());
            headerRow.createCell(18).setCellValue(retireOrgan.getShvam());
            headerRow.createCell(19).setCellValue(retireOrgan.getDfot());
            headerRow.createCell(20).setCellValue(retireOrgan.getElat());
        }
        // Auto-size columns
        for (int i = 0; i < 21; i++) {
            sheet.autoSizeColumn(i);
        }

        //write the workbook at the file
        LocalDateTime localDateTime = LocalDateTime.now();
        String formatedDateBasic = DateTimeFormatter.BASIC_ISO_DATE.format(localDateTime);
        String fileName = "RetireOrgan" + "-" + formatedDateBasic;
        String filePath = "F:/exportFile/" + fileName + ".xlsx";
        FileOutputStream outputStream = new FileOutputStream(filePath);
        workbook.write(outputStream);
        workbook.close();
        System.out.println("Excel Export Complete");
    }
}
