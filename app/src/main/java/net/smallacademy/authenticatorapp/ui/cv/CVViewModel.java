package net.smallacademy.authenticatorapp.ui.cv;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


public class CVViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CVViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Upload a pdf format of your C.V. " +
                "Filename must start with the phone number used during registration." +
                "\ne.g 0123456789CV");
    }

    public LiveData<String> getText() {
        return mText;
    }
}