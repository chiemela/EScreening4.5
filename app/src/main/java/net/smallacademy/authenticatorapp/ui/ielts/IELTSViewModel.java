package net.smallacademy.authenticatorapp.ui.ielts;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class IELTSViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public IELTSViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}