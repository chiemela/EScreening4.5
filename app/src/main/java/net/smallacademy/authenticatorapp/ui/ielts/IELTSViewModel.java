package net.smallacademy.authenticatorapp.ui.ielts;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class IELTSViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public IELTSViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Upload a pdf format of your IELTS. Filename must start with the phone number used during registration. '\n'e.g 0123456789IELTS");
    }

    public LiveData<String> getText() {
        return mText;
    }
}