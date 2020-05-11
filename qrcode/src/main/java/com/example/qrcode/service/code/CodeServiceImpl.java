package com.example.qrcode.service.code;

import com.example.qrcode.common.Constants;
import com.example.qrcode.service.ICodeService;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;

@Service
@Qualifier("codeServiceImpl")
public class CodeServiceImpl implements ICodeService<String> {

    @Override
    public byte[] genQRcode(String message) {
        if (!StringUtils.isEmpty(message)) {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            try {
                BitMatrix bitMatrix = qrCodeWriter.encode(message, BarcodeFormat.QR_CODE, Constants.QRCODE_WIDTH, Constants.QRCODE_HEIGHT);
                // 1、读取文件转换为字节数组
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                BufferedImage image = toBufferedImage(bitMatrix);
                //转换成png格式的IO流
                ImageIO.write(image, "jpg", out);
                byte[] bytes = out.toByteArray();
                //保存二维码到本地选项
                if (Constants.SAVE_QRCODE) {
                    InputStream in = new ByteArrayInputStream(bytes);
                    BufferedImage im = null;
                    try {
                        im = ImageIO.read(in);
                        ImageIO.write(im, "jpg", new File("D://"+"code"+".jpg"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return bytes;
            } catch (Exception e) {
            }
        }
        return null;
    }

    /**
     * image流数据处理
     * @param matrix
     * @return
     */
    public BufferedImage toBufferedImage(BitMatrix matrix) {
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, matrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
            }
        }
        return image;
    }
}
