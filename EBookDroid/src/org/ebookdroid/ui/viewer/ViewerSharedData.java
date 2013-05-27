package org.ebookdroid.ui.viewer;

import java.io.InputStream;

/**
 * Provide a mechanism to pass non serializable data into the
 * ViewActivity.
 * 
 * @author rajesh
 *
 */
public class ViewerSharedData {
    
    // InputStream used by the ViewerActivity if it is not null.
    static private InputStream pdfDataStream = null;
    
    /**
     * Retrieve the PDF input stream.
     * @return
     */
    public static InputStream getPdfDataStream() {
        return pdfDataStream;
    }

    
    /**
     * Set the PDF input stream.
     * @param pdfDataStream
     */
    public static void setPdfDataStream(InputStream pdfDataStream) {
        ViewerSharedData.pdfDataStream = pdfDataStream;
    }

}
