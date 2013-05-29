package org.ebookdroid;

import org.ebookdroid.ui.viewer.ViewerActivity;
import org.ebookdroid.ui.viewer.ViewerSharedData;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class InvokeViewerActivity extends Activity { 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        final Intent myIntent = new Intent(this.getApplicationContext(), ViewerActivity.class);
        try {
            // ViewerSharedData.setPdfDataStream(new FileInputStream ("/mnt/shell/emulated/0/2142.pdf"));
            //ViewerSharedData.setPdfDataStream(new FileInputStream ("/mnt/sdcard/S2.pdf"));
            ViewerSharedData.setPdfDataStream(new FileInputStream ("/mnt/sdcard/bpl13210.pdf"));
            startActivity(myIntent);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
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
