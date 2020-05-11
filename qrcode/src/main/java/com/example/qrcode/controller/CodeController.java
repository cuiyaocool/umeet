package com.example.qrcode.controller;

import com.example.qrcode.service.ICodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@RestController
public class CodeController {

    @Autowired
    @Qualifier("codeServiceImpl")
    private ICodeService codeService;

    @RequestMapping("/create")
    public void genarate(@RequestParam String message, HttpServletResponse response) throws IOException {
        System.out.println("收到消息： " + message);
        byte[] bytes = codeService.genQRcode(message);
        OutputStream outputStream = null;
        try {
            response.setContentType("image/jpeg");
            outputStream = response.getOutputStream();
            outputStream.write(bytes);
            outputStream.flush();
            System.out.println(bytes.length);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}
