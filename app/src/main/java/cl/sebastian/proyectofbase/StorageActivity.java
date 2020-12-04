package cl.sebastian.proyectofbase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class StorageActivity extends AppCompatActivity {



    private static final int PICK_IMAGE_REQUEST = 1;
    private Button botonSeleccionar;
    private Button botonSubir;
    private ImageView imageView;
    private Uri filePath;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);
        botonSeleccionar = findViewById(R.id.buttonChoose);
        botonSubir = findViewById(R.id.buttonUpload);
        imageView = findViewById(R.id.imageView);

//agregamos nuestro método al onClick del botón
        botonSeleccionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFileChooser();
            }
        });



    }

    private void showFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }


}