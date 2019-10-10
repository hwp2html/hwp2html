package cnu.hwp2html;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class HTMLFile {
    private String hwpText;

    public HTMLFile(String hwpText) {
        this.hwpText = hwpText;
    }

    public void writeHTMLFile(String path, String fileName) throws IOException {
        FileOutputStream fos = new FileOutputStream(new File(path + fileName + ".html"));
        fos.write(hwpText.getBytes());
    }
}
