package net.smallacademy.authenticatorapp.ui.birthcertificate;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BirthCertificateViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public BirthCertificateViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Upload a pdf format of your Birth Certificate. " +
                "Filename must start with the phone number used during registration." +
                "\ne.g 0123456789BirthCertificate");
    }

    public LiveData<String> getText() {
        return mText;
    }
}