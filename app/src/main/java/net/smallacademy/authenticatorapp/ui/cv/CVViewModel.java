package net.smallacademy.authenticatorapp.ui.cv;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


public class CVViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CVViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}