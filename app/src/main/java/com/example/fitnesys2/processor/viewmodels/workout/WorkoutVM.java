package com.example.fitnesys2.processor.viewmodels.workout;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class WorkoutVM extends ViewModel {

    private MutableLiveData<String> mText;

    public WorkoutVM() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}