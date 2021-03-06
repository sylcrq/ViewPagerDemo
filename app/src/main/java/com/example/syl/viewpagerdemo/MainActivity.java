package com.example.syl.viewpagerdemo;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.annotation.CustomAnnotation;
import com.example.syl.viewpagerdemo.dummy.DummyContent;

//import com.example.annotationprocessor.generated.GeneratedClass;

@CustomAnnotation
public class MainActivity extends AppCompatActivity implements MainFragment.OnFragmentInteractionListener,
        PageFragment.OnListFragmentInteractionListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    @CustomAnnotation
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.activity_main, MainFragment.newInstance());
        transaction.commit();

        showAnnotationMessage();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {
        Toast.makeText(this, "" + item.content, Toast.LENGTH_SHORT).show();
//        Intent intent = new Intent(this, TestActivity.class);
//        startActivityForResult(intent, 1024);

        Intent intent = new Intent(this, MyReactActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG, "xxxx#" + requestCode + "," + resultCode);
        if (requestCode == 1024) {
            Log.d(TAG, "yyy#" + requestCode + "," + resultCode);
        }
    }

    private void showAnnotationMessage() {
//        GeneratedClass generatedClass = new GeneratedClass();
//        String message = generatedClass.getMessage();
        // android.support.v7.app.AlertDialog
//        new AlertDialog.Builder(this)
//                .setPositiveButton("Ok", null)
//                .setTitle("Annotation Processor Messages")
//                .setMessage(message)
//                .show();
    }
}
