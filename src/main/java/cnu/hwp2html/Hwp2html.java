package cnu.hwp2html;

import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.tool.textextractor.TextExtractMethod;
import kr.dogfoot.hwplib.tool.textextractor.TextExtractor;

import java.io.UnsupportedEncodingException;

public class Hwp2html {

    public HTMLFile convert(HWPFile hwpFile) throws UnsupportedEncodingException {
        TextExtractMethod tem = TextExtractMethod.InsertControlTextBetweenParagraphText;
        String hwpText = TextExtractor.extract(hwpFile, tem);

        return new HTMLFile(hwpText);
    }
}
