package net.smallacademy.authenticatorapp.ui.personalstatement;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PersonalStatementViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PersonalStatementViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Upload a pdf format of your Personal Statement. Filename must start with the phone number used during registration. '\n'e.g 0123456789PersonalStatement");
    }

    public LiveData<String> getText() {
        return mText;
    }
}