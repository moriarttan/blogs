package com.example.blogs.utils;

import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.write.handler.AbstractCellWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteTableHolder;
import org.apache.poi.ss.usermodel.*;

/**
 * 对 excel 单元格样式进行处理
 * Created by ff on 2021/8/20
 *
 * @author ff
 */
public class ExcelEasyHandler extends AbstractCellWriteHandler {

    @Override
    public void afterCellCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Cell cell, Head head, Integer relativeRowIndex, Boolean isHead) {
        if (!isHead) {
            Workbook workbook = writeSheetHolder.getSheet().getWorkbook();

            CellStyle cellStyle = workbook.createCellStyle();

            // 水平居中
            cellStyle.setAlignment(HorizontalAlignment.CENTER);

            // 垂直居中
            cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);

            // 自动换行
            cellStyle.setWrapText(true);

            //设置边框样式
            cellStyle.setBorderLeft(BorderStyle.THIN);
            cellStyle.setBorderTop(BorderStyle.THIN);
            cellStyle.setBorderRight(BorderStyle.THIN);
            cellStyle.setBorderBottom(BorderStyle.THIN);

            cell.setCellStyle(cellStyle);
        }
    }

}
