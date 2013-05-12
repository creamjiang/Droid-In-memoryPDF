package org.ebookdroid.droids.mupdf.codec;

import org.ebookdroid.core.codec.CodecDocument;


public class XpsContext extends MuPdfContext {

    /* (non-Javadoc)
     * Stub to satisfy compiler.
     * @see org.ebookdroid.core.codec.CodecContext#openDocument(java.lang.String, java.lang.String)
     */
    @Override
    public CodecDocument openDocument(final String fileName, final String password) {
        setExternalFonts();
        return new MuPdfDocument(this, MuPdfDocument.FORMAT_XPS, fileName, password);
    }

    /* (non-Javadoc)
     * Stub to satisfy compiler.
     * @see org.ebookdroid.core.codec.CodecContext#openDocument(byte[], java.lang.String)
     */
    @Override
    public CodecDocument openDocument(byte[] fileData, String password) {
        return null;
    }
}
