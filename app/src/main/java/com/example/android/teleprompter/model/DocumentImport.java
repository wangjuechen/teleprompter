package com.example.android.teleprompter.model;


import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.OpenableColumns;
import android.support.v7.app.AppCompatActivity;

public class DocumentImport extends AppCompatActivity {

    private static final int READ_REQUEST_CODE = 39;

    public void performFileSearch() {

        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);

        intent.addCategory(Intent.CATEGORY_OPENABLE);

        String[] mimeTypes = {"application/pdf",
                "text/plain",
                "application/vnd.openxmlformats-officedocument.wordprocessingml.document",
                "application/msword",
                "application/vnd.ms-powerpoint",
                "application/vnd.ms-powerpoint",
                "application/vnd.openxmlformats-officedocument.presentationml.presentation",
                "application/rtf",
                "application/x-rtf",
                "text/richtext",
                "text/rtf"};

        intent.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes);

        startActivityForResult(intent, READ_REQUEST_CODE);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == READ_REQUEST_CODE && resultCode == RESULT_OK) {
            Uri fileImportedUri = data.getData();

            Cursor returnCursor = getContentResolver().query(fileImportedUri, null, null, null, null);

            if (returnCursor != null && returnCursor.moveToFirst()) {
                int fileNameIndex = returnCursor.getColumnIndex(OpenableColumns.DISPLAY_NAME);
                String fileName = returnCursor.getColumnName(fileNameIndex);


            }
        }

    }
}

