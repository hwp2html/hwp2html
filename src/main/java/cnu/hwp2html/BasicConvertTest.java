package cnu.hwp2html;

import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.reader.HWPReader;
import kr.dogfoot.hwplib.tool.textextractor.TextExtractMethod;
import kr.dogfoot.hwplib.tool.textextractor.TextExtractor;

import java.io.File;
import java.io.FileOutputStream;


public class BasicConvertTest {
    public static void main(String[] args) throws Exception{
        FileOutputStream fos = new FileOutputStream(new File("test.html"));

        TextExtractMethod tem = TextExtractMethod.InsertControlTextBetweenParagraphText;
        String data = test("src" + File.separator + "main" + File.separator + "resources" + File.separator + "test-blank.hwp", tem);
        data = "<p>"+data+"<p>";
        fos.write(data.getBytes());
    }
    private static String test(String filename, TextExtractMethod tem) throws Exception{
        HWPFile hwpFile = HWPReader.fromFile(filename);
        String hwpText = TextExtractor.extract(hwpFile,tem);
        System.out.println("text extractor : "+hwpText);

        return hwpText;
//        System.out.println(hwpFile.getBodyText().getSectionList());

    }
}
