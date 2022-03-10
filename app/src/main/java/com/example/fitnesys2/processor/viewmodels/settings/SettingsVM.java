package com.example.fitnesys2.processor.viewmodels.settings;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SettingsVM extends ViewModel {

    private MutableLiveData<String> mText;

    public SettingsVM() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notifications fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}