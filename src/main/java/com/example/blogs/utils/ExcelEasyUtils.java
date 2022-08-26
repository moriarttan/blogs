package com.example.blogs.utils;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.metadata.WriteSheet;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * EasyExcel 工具类
 * Created by ff on 2021/8/19
 *
 * @author ff
 */
@Slf4j
public final class ExcelEasyUtils {
    /**
     * 导出excel。
     *
     * @param response  响应
     * @param fileName  文件名
     * @param sheetName sheet标签名称
     * @param clazz     类
     * @param data      数据
     */
    public static void exportExcel(HttpServletResponse response, String fileName, String sheetName, Class<?> clazz, List<?> data) {
        try (BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream())) {
            ExcelWriterBuilder excelWriterBuilder = new ExcelWriterBuilder();
            excelWriterBuilder.file(bos);
            excelWriterBuilder.excelType(ExcelTypeEnum.XLSX);
            excelWriterBuilder.registerWriteHandler(new ExcelEasyHandler());

            // 写第一个sheet, sheet1  数据全是List<String> 无模型映射关系
            WriteSheet writeSheet = new WriteSheet();

            writeSheet.setSheetNo(1);
            writeSheet.setSheetName(sheetName);
            writeSheet.setClazz(clazz);

            ExcelWriter writer = excelWriterBuilder.build();
            writer.write(data, writeSheet);
            fileName = URLEncoder.encode(fileName, "UTF8");

            response.setHeader("Content-disposition", "attachment;filename="
                + new String(fileName.getBytes(StandardCharsets.UTF_8), "ISO8859-1") + ".xlsx");
            writer.finish();
            response.setContentType("multipart/form-data");
            response.setCharacterEncoding("utf-8");
        } catch (IOException e) {
            log.error(e.getMessage());
            
        }
    }

    public static void excelExportWorkbook(HttpServletResponse response, String fileName, XSSFWorkbook workbook) {
        ServletOutputStream outputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            fileName = URLEncoder.encode(fileName, "UTF8");

            response.setHeader("Access-Control-Expose-Headers", "Content-disposition");
            response.setHeader("Content-disposition", "attachment;filename=" + new String(fileName.getBytes(StandardCharsets.UTF_8), "ISO8859-1") + ".xlsx");

            outputStream = response.getOutputStream();
            bufferedOutputStream = new BufferedOutputStream(outputStream);
            workbook.write(bufferedOutputStream);
            bufferedOutputStream.flush();

            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("utf-8");
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            try {
                outputStream.close();
                bufferedOutputStream.close();
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
    }

}
