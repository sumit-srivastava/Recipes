package com.java.se7.string.recipes;

import javax.activation.MimetypesFileTypeMap;

public class DocumentUtils {
    public static String getFileNameForDocument(String docName, String contentType)
    {
        int index = contentType.lastIndexOf("/");
        
        String extention = contentType.substring(index + 1, index + 6);
        
        return (docName + "." + extention);
    }
    
//    public static String detectContentCharSet(byte[] buffer)
//    {
//        UniversalDetector detector = new UniversalDetector(null);
//        detector.handleData(buffer, 0, buffer.length);
//        detector.dataEnd();
//        return detector.getDetectedCharset();
//    }
    
    public static String getImageFileNameForDocument(String docName, int pageIndex)
    {
        return (docName + "-" + String.valueOf(pageIndex) + ".png");
    }

    public static String getMimeType(String url) {
        return MimetypesFileTypeMap
                .getDefaultFileTypeMap()
                .getContentType(url);
    }

    public static void main(String[] args) {
        System.out.println(getFileNameForDocument("abc", "application/pdf"));

        System.out.println(getMimeType("abc.pdf"));
    }
}
