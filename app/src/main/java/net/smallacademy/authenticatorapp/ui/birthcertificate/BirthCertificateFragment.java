package net.smallacademy.authenticatorapp.ui.birthcertificate;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import net.smallacademy.authenticatorapp.R;
import net.smallacademy.authenticatorapp.putPDF;

import static android.app.Activity.RESULT_OK;


public class BirthCertificateFragment extends Fragment {

    private BirthCertificateViewModel birthCertificateViewModel;
    private static final int PICK_PDF_REQUEST = 12;
    private putPDF putPDF;
    //Buttons
    private Button buttonChoose;
    private Button buttonUpload;
    private TextView textView;

    //ImageView
    private ImageView imageView;

    //a Uri object to store file path
    private Uri filePath;

    //firebase storage reference
    private StorageReference storageReference;

    //firebase database reference
    private DatabaseReference databaseReference;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        birthCertificateViewModel =
                ViewModelProviders.of(this).get(BirthCertificateViewModel.class);
        View root = inflater.inflate(R.layout.fragment_birth_certificate, container, false);
        textView = root.findViewById(R.id.text_home);
        birthCertificateViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });


        //getting views from layout
        buttonChoose = (Button) root.findViewById(R.id.buttonChooseBC);
        buttonUpload = (Button) root.findViewById(R.id.buttonUploadBC);

        imageView = (ImageView) root.findViewById(R.id.imageView);

        //attaching listener
        buttonChoose.setOnClickListener((View.OnClickListener) this);
        buttonUpload.setOnClickListener((View.OnClickListener) this);

        //getting firebase storage reference
        storageReference = FirebaseStorage.getInstance().getReference();
        databaseReference = FirebaseDatabase.getInstance().getReference("MobileStudent");

        buttonChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectPDF();
            }
        });

        return root;
    }

    //method to show file chooser
    private void selectPDF() {
        Intent intent = new Intent();
        intent.setType("application/pdf");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select PDF"), 12);
    }

    //handling the image chooser activity result
    @Override
    public void onActivityResult(int requestCode, int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_PDF_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            textView.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/") + 1));

            buttonUpload.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    uploadPDFFileFirebase(data.getData());
                }
            });

            /*
            try {


            } catch (IOException e) {
                e.printStackTrace();
            }

             */
        }
    }

    private void uploadPDFFileFirebase(Uri data) {
        StorageReference reference = storageReference.child("MobileStudent" + System.currentTimeMillis() + ".pdf");

        reference.putFile(data).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Task<Uri> uriTask = taskSnapshot.getStorage().getDownloadUrl();
                while (!uriTask.isComplete()) ;
                Uri uri = uriTask.getResult();

                putPDF = new putPDF(textView.getText().toString(), uri.toString());
                databaseReference.child(databaseReference.push().getKey()).setValue(putPDF);

            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                double progress = (100.0 * snapshot.getBytesTransferred()) / snapshot.getTotalByteCount();

            }
        });
    }

}