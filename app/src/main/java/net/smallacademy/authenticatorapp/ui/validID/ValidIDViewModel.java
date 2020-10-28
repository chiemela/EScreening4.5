package net.smallacademy.authenticatorapp.ui.validID;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ValidIDViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ValidIDViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}