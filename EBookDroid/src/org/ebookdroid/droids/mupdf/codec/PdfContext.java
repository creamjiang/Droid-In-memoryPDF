package org.ebookdroid.droids.mupdf.codec;

import org.ebookdroid.core.codec.CodecDocument;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


public class PdfContext extends MuPdfContext {

    @Override
    public CodecDocument openDocument(final String fileName, final String password) {
        setExternalFonts(); 
        byte[] srcData = getBytesFromFile(new File (fileName));
        return new MuPdfDocument(this, MuPdfDocument.FORMAT_PDF, srcData, password);
        //return new MuPdfDocument(this, MuPdfDocument.FORMAT_PDF, fileName, password); 
    }
    
    public static byte[] getBytesFromFile(File file) {
        InputStream is=null;
        byte[]bytes = null;
        try {
            is = new FileInputStream(file);
            System.out.println("\nDEBUG: FileInputStream is " + file);
            
            // Get the size of the file
            long length = file.length();
            System.out.println("DEBUG: Length of " + file + " is " + length + "\n");
            
            /*
             * You cannot create an array using a long type. It needs to be an int
             * type. Before converting to an int type, check to ensure that file is
             * not larger than Integer.MAX_VALUE;
             */
            if (length > Integer.MAX_VALUE) {
                System.out.println("File is too large to process");
                return null;
            }
            
            // Create the byte array to hold the data
            bytes = new byte[(int)length];
            
            // Read in the bytes
            int offset = 0;
            int numRead = 0;
            while ((offset < bytes.length) && ((numRead=is.read(bytes, offset, bytes.length-offset)) >= 0)) {
                offset += numRead;
            }
            
            // Ensure all the bytes have been read in
            if (offset < bytes.length) {
                // TODO: Handle error condition.
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return bytes;
    }
}
