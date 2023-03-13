package com.api.ExportDataToExcel.utils;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.OutputStream;

public class FileFactory {

    public static final String PATH_TEMPLATE = "C:\\Users\\sandrosiqueira\\Downloads\\Template";

    public static File createFile(String fileName, Workbook workbook) throws Exception{
        workbook = new XSSFWorkbook();

        OutputStream out = new FileOutputStream(PATH_TEMPLATE + fileName);

        workbook.write(out);

        return ResourceUtils.getFile(PATH_TEMPLATE + fileName);
    }
}
