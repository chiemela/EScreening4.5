package net.smallacademy.authenticatorapp.ui.transcripts;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TranscriptsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TranscriptsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Upload a pdf format of your educational transcripts. Filename must start with the phone number used during registration. \ne.g 0123456789Transcripts");
    }

    public LiveData<String> getText() {
        return mText;
    }
}