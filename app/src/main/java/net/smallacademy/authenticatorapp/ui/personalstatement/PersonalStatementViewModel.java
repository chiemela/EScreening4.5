package net.smallacademy.authenticatorapp.ui.personalstatement;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PersonalStatementViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PersonalStatementViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}