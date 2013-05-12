package org.ebookdroid.droids.mupdf.codec;

import org.ebookdroid.core.codec.CodecDocument;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


public class PdfContext extends MuPdfContext {

    /* (non-Javadoc)
     * Open a PDF document using a filename.
     * @see org.ebookdroid.core.codec.CodecContext#openDocument(java.lang.String, java.lang.String)
     */
    @Override
    public CodecDocument openDocument(final String fileName, final String password) {
        setExternalFonts(); 
        return new MuPdfDocument(this, MuPdfDocument.FORMAT_PDF, fileName, password); 
    }
    
    /* (non-Javadoc)
     * Open a PDF document based on file data.
     * @see org.ebookdroid.core.codec.CodecContext#openDocument(byte[], java.lang.String)
     */
    @Override
    public CodecDocument openDocument(byte[] fileData, final String password) {
        setExternalFonts(); 
        return new MuPdfDocument(this, MuPdfDocument.FORMAT_PDF, fileData, password);
    }
}
