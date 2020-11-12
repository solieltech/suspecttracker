package com.example.suspectservice;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

import com.example.suspectservice.vo.VideoCommentsVO;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ExcelHelper {




    /*protected void write2Cell(XSSFSheet spreadsheet,VideoCommentsVO videoCommentsVO,int rowid){
        XSSFRow row = spreadsheet.createRow(rowid++);
        row.createCell(0).setCellValue(Objects.toString(videoCommentsVO.getName(),""));
        row.createCell(1).setCellValue(Objects.toString(videoCommentsVO.getComment(),""));
        row.createCell(2).setCellValue(Objects.toString(videoCommentsVO.getLikeCount(),""));
        row.createCell(3).setCellValue(Objects.toString(videoCommentsVO.getTotalReplyCount(),""));
        row.createCell(4).setCellValue(Objects.toString(videoCommentsVO.getPublishedAt(),""));

        if(videoCommentsVO.getVideoCommentsVOList()!=null && videoCommentsVO.getVideoCommentsVOList().size()>0){
          List<VideoCommentsVO> videoCommentsVOList=  videoCommentsVO.getVideoCommentsVOList();
            for (VideoCommentsVO childComment : videoCommentsVOList) {
                write2Cell(childComment,rowid);
            }
        }

    }*/

    public ResponseEntity<InputStreamResource> writeToExcel(List<VideoCommentsVO> videoCommentsVOList) throws Exception {
        //Create blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();

        //Create a blank sheet
        XSSFSheet spreadsheet = workbook.createSheet(" Comments ");
        int rowid = 0;
        XSSFRow row = spreadsheet.createRow(rowid++);
        row.createCell(0).setCellValue("Name");
        row.createCell(1).setCellValue("Comment");
        row.createCell(2).setCellValue("Like count");
        row.createCell(3).setCellValue("Reply Count");
        row.createCell(4).setCellValue("Pubblished At");

        for (VideoCommentsVO videoCommentsVO : videoCommentsVOList) {
            //write2Cell(spreadsheet,videoCommentsVO,rowid);
             row = spreadsheet.createRow(rowid++);
            row.createCell(0).setCellValue(Objects.toString(videoCommentsVO.getName(), ""));
            row.createCell(1).setCellValue(Objects.toString(videoCommentsVO.getComment(), ""));
            row.createCell(2).setCellValue(Objects.toString(videoCommentsVO.getLikeCount(), ""));
            row.createCell(3).setCellValue(Objects.toString(videoCommentsVO.getTotalReplyCount(), ""));
            row.createCell(4).setCellValue(Objects.toString(videoCommentsVO.getPublishedAt(), ""));

            if (videoCommentsVO.getVideoCommentsVOList() != null && videoCommentsVO.getVideoCommentsVOList().size() > 0) {
                List<VideoCommentsVO> childvideoCommentsVOList = videoCommentsVO.getVideoCommentsVOList();
                for (VideoCommentsVO childComment : childvideoCommentsVOList) {
                     row = spreadsheet.createRow(rowid++);
                    row.createCell(0).setCellValue(Objects.toString(childComment.getName(), ""));
                    row.createCell(1).setCellValue(Objects.toString(childComment.getComment(), ""));
                    row.createCell(2).setCellValue(Objects.toString(childComment.getLikeCount(), ""));
                    row.createCell(3).setCellValue(Objects.toString(childComment.getTotalReplyCount(), ""));
                    row.createCell(4).setCellValue(Objects.toString(childComment.getPublishedAt(), ""));

                }
            }
        }
        //Write the workbook in file system
        File f = new File("comments.xlsx");
        f.createNewFile();
        FileOutputStream out = new FileOutputStream(f,true);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        workbook.write(stream);
        out.close();
        System.out.println("Row id ::" + rowid);
        System.out.println("Writesheet.xlsx written successfully");

       /* HttpHeaders header = new HttpHeaders();
        header.setContentType(new MediaType("application", "force-download"));
        header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=ProductTemplate.xlsx");*/
        HttpHeaders httpHeaders =new HttpHeaders();
        httpHeaders.set("Content-Disposition",
                "attachment; filename=new-excel-file.xlsx");
       // httpHeaders.setContentType(new MediaType("application", "force-download"));
        workbook.write(stream);
        //workbook.close();
       /* return new ResponseEntity<>(stream.toByteArray(),
                httpHeaders, HttpStatus.CREATED);*/
        return ResponseEntity
                .ok()
                .headers(httpHeaders)
                .body(new InputStreamResource(new ByteArrayInputStream(stream.toByteArray())));
    }

}
