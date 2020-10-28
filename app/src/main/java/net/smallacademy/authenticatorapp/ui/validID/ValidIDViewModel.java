package net.smallacademy.authenticatorapp.ui.validID;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ValidIDViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ValidIDViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Upload a pdf format of your valid ID e.g International Passport. Filename must start with the phone number used during registration. '\n'e.g 0123456789ValidID");
    }

    public LiveData<String> getText() {
        return mText;
    }
}