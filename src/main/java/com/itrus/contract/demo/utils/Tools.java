package com.itrus.contract.demo.utils;

import cn.hutool.core.codec.Base64;
import lombok.extern.slf4j.Slf4j;

import java.io.*;

/**
 * @Author: meng
 * @Description:
 * @Date: Create in 16:25 2020/8/18 0018
 */
@Slf4j
public class Tools {

    public static void bytesToFile(String fileName, String fileContent) throws IOException {
        InputStream in = null;
        BufferedOutputStream out = null;
        try {
            File file = new File(fileName);
            //判断父级路径是否存在
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            OutputStream output = new FileOutputStream(file);
            out = new BufferedOutputStream(output);
            in = new ByteArrayInputStream(Base64.decode(fileContent));
            byte[] buff = new byte[1024];
            int len = 0;
            while ((len = in.read(buff)) != -1) {
                out.write(buff, 0, len);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
