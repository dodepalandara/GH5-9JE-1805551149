package com.example.daftaroperasisistem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    //variabel
    private ArrayList <String> mNames = new ArrayList<>();
    private ArrayList <String> mImageUrls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started.");

        initImageBitmaps();
    }

    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmap: preparing bitmaps.");

        mImageUrls.add("data:image/png;base64,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");
        mNames.add("Android");

        mImageUrls.add("data:image/jpeg;base64,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");
        mNames.add("Apple IOS");

        mImageUrls.add("data:image/png;base64,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");
        mNames.add("Symbian OS");

        mImageUrls.add("data:image/jpeg;base64,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");
        mNames.add("Windows Phone");

        mImageUrls.add("data:image/jpeg;base64,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");
        mNames.add("Linux Ubuntu");

        initRecyclerView();
    }
    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mNames, mImageUrls);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
