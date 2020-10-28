package net.smallacademy.authenticatorapp.ui.testimonial;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TestimonialViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TestimonialViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}