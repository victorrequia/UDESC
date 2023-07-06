package org.udesc.otes06;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String permission =
                Manifest.permission.READ_CONTACTS;

        int result = ContextCompat
                .checkSelfPermission(this,permission);
        int granted = PackageManager.PERMISSION_GRANTED;
        Button button = findViewById(R.id.button);
        if (result != granted) {
            button.setEnabled(false);
            ActivityCompat
                    .requestPermissions(
                            this,
                            new String[] { permission },
                            0);
        } else {
            button.setEnabled(true);
        }

        button.setOnClickListener(view ->
                doAction());
    }

    @Override
    protected void onResume(){
        super.onResume();

        Button button = findViewById(R.id.button);
        String permission =
                Manifest.permission.READ_CONTACTS;
        int result = ContextCompat
                .checkSelfPermission(
                        this,permission);
        int granted = PackageManager.PERMISSION_GRANTED;
        button.setEnabled(result == granted);
    }

    private void doAction() {
        ContentResolver contentResolver =
                getContentResolver();
        Uri uri = ContactsContract
                .CommonDataKinds.Phone.CONTENT_URI;
        Cursor cursor = contentResolver
                .query(uri,
                        null,
                        null,
                        null,
                        null);

        if (cursor.getCount() > 0 &&
            cursor.moveToNext()) {
            @SuppressLint("Range")
            String name = cursor.getString(
                cursor.getColumnIndex(
                        ContactsContract
                                .CommonDataKinds
                                .Phone
                                .DISPLAY_NAME));

            Intent intent = new Intent(
                    this,
                    OtherActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("name", name);
            intent.putExtra("bundle", bundle);

            startActivity(intent);
        }
    }
}