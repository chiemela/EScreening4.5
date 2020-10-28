package net.smallacademy.authenticatorapp.ui.birthcertificate;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BirthCertificateViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public BirthCertificateViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}