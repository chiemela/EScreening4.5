package net.smallacademy.authenticatorapp.ui.results;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ResultsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ResultsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Upload a pdf format of your O'Level Result. Filename must start with the phone number used during registration. '\n'e.g 0123456789Result");
    }

    public LiveData<String> getText() {
        return mText;
    }
}