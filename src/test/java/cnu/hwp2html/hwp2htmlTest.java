package cnu.hwp2html;

import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.reader.HWPReader;
import kr.dogfoot.hwplib.tool.textextractor.TextExtractMethod;
import kr.dogfoot.hwplib.tool.textextractor.TextExtractor;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import static org.junit.Assert.*;

public class hwp2htmlTest {

    @Test
    public void BasicConvertTest() throws Exception {
        FileOutputStream fos = new FileOutputStream(new File("test.html"));

        TextExtractMethod tem = TextExtractMethod.InsertControlTextBetweenParagraphText;
        HWPFile hwpFile = HWPReader.fromFile("src" + File.separator + "main" + File.separator + "resources" + File.separator + "test-blank.hwp");
        String hwpText = TextExtractor.extract(hwpFile,tem);
        System.out.println("text extractor : "+hwpText);

        String data = hwpText;
        data = "<p>"+data+"<p>";
        fos.write(data.getBytes());
    }
}