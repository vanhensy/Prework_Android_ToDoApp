package com.vanhensy.tododemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class EditItemsView extends AppCompatActivity {
    ArrayList<String> items;
    ArrayAdapter<String> itemsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_items_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Start implement to text field
        String content = getIntent().getStringExtra("itemContent"); // Get current item's content
        EditText editItemField = (EditText)findViewById(R.id.editItemField);
        editItemField.setText(content); // Set textFiled placeholder using item's content
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        int textLength = editItemField.getText().length();
        editItemField.setSelection(textLength, textLength); // Set cursor to end of textField
        editItemField.requestFocus();

    }

    public void onSaveBtnClicked(View v) {
        EditText editItemField = (EditText)findViewById(R.id.editItemField);
        String content = editItemField.getText().toString();
        Intent data = new Intent();
        int position = getIntent().getIntExtra("position", 0);
        data.putExtra("content", content);
        data.putExtra("position", position);
        setResult(RESULT_OK, data);
        this.finish();
    }

}
