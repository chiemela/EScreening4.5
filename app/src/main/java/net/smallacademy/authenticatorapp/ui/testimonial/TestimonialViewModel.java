package net.smallacademy.authenticatorapp.ui.testimonial;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TestimonialViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TestimonialViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Upload a pdf format of your O'Level Testimonial. Filename must start with the phone number used during registration. '\n'e.g 0123456789Testimonial");
    }

    public LiveData<String> getText() {
        return mText;
    }
}