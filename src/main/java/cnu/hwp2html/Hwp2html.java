package cnu.hwp2html;

import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.object.bodytext.Section;
import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;

import java.io.UnsupportedEncodingException;

public class Hwp2html {

    public HTMLFile convert(HWPFile hwpFile) {
        Section paragraphs = hwpFile.getBodyText().getSectionList().get(0);
        StringBuilder hwpText = new StringBuilder();
        paragraphs.forEach(paragraph -> {
            hwpText.append("<p>");
            hwpText.append(extractFromParagraph(paragraph));
            hwpText.append("</p>");
            hwpText.append(System.lineSeparator());
        });

        return new HTMLFile(hwpText.toString());
    }

    private String extractFromParagraph(Paragraph paragraph){
        if (paragraph.getText() == null) return "";
        String normalString = null;
        try {
            normalString = paragraph.getText().getNormalString(0, paragraph.getText().getCharList().size()-1);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return normalString;
    }
}
