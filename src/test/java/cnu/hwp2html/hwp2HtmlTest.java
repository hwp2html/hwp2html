package cnu.hwp2html;

import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.reader.HWPReader;
import org.junit.Test;

import java.io.File;

public class hwp2HtmlTest {

    @Test
    public void BasicConvertTest() throws Exception {
        String filePath = "src" + File.separator + "main" + File.separator + "resources" + File.separator + "test-blank.hwp";
        HWPFile hwpFile = HWPReader.fromFile(filePath);

        Hwp2html hwp2html = new Hwp2html();
        HTMLFile htmlFile = hwp2html.convert(hwpFile);
        String fileName = "test";
        htmlFile.writeHTMLFile("", fileName);
    }
}