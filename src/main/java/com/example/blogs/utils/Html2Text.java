package com.example.blogs.utils;

import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.ParserDelegator;
import java.io.*;

/**
 * @Author: FF
 * @Description: 富文本转化
 * @Date: 2022/4/8 11:00
 * @Version: 1.0
 */
public class Html2Text extends HTMLEditorKit.ParserCallback{
    private static final Html2Text html2Text = new Html2Text();

    StringBuffer s;

    public Html2Text() {
    }

    public void parse(String str) throws IOException {

        InputStream iin = new ByteArrayInputStream(str.getBytes());
        Reader in = new InputStreamReader(iin);
        s = new StringBuffer();
        ParserDelegator delegator = new ParserDelegator();
        delegator.parse(in, this, Boolean.TRUE);
        iin.close();
        in.close();
    }

    @Override
    public void handleText(char[] text, int pos) {
        s.append(text);
    }

    public String getText() {
        return s.toString();
    }

    public static String getContent(String str) {
        try {
            html2Text.parse(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return html2Text.getText();
    }
}
