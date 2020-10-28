package net.smallacademy.authenticatorapp.ui.passport;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PassportViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PassportViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Upload a pdf format of your passport photograph. Filename must start with the phone number used during registration. '\n'e.g 0123456789Passport");
    }

    public LiveData<String> getText() {
        return mText;
    }
}