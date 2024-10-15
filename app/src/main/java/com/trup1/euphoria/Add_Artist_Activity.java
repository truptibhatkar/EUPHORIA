package com.trup1.euphoria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Add_Artist_Activity extends AppCompatActivity {
    TextView textView2;
    private static final int REQUEST_CODE_IMAGE_PICKER = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_winner);

        textView2 = findViewById(R.id.artistimg);
        EditText input1 = findViewById(R.id.artistname);
        Button submit = findViewById(R.id.subartist);



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String artistName = input1.getText().toString();

                // Store the artist name in a data store
                storeArtistName(artistName);

                // Navigate to the HomeActivity
                Intent intent = new Intent(Add_Artist_Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch an intent to select an image from the gallery or take a photo using the camera
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 1);
            }
        });


    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            // Get the selected image
            Uri imageUri = data.getData();
            ImageView selectedImageView = findViewById(R.id.showartistimg);
            selectedImageView.setImageURI(imageUri);

            // Show a message indicating that the image has been successfully selected
            Toast.makeText(this, "Image selected successfully!", Toast.LENGTH_SHORT).show();



        }
    }
    private void storeArtistName(String artistName) {
        // Store the artist name in a data store
        // For example, you can store it in a shared preference:
        SharedPreferences preferences = getSharedPreferences("my_preferences", MODE_PRIVATE);
        String artistNamesString = preferences.getString("artist_names", "");
        artistNamesString += artistName + ",";
        preferences.edit().putString("artist_names", artistNamesString).apply();
    }
}
