package org.ebookdroid;

import org.ebookdroid.ui.viewer.ViewerActivity;
import org.ebookdroid.ui.viewer.ViewerSharedData;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class InvokeViewerActivity extends Activity { 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Create the intent.
        final Intent myIntent = new Intent(this.getApplicationContext(), ViewerActivity.class);
        try {
            // Populate the shared static alss ViewerSharedData with
            // the InputStream
            ViewerSharedData.setPdfDataStream(new FileInputStream (Environment.getExternalStorageDirectory().getPath() + "/bpl13210.pdf"));
            
            // Start the viewer.
            startActivity(myIntent);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.invoke_viewer, menu);
        return true;
    }

}
