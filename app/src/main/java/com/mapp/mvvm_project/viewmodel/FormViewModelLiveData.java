package com.mapp.mvvm_project.viewmodel;

import com.mapp.mvvm_project.model.User;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FormViewModelLiveData extends ViewModel {

    public MutableLiveData<String> errorStr = new MutableLiveData<>();
    public MutableLiveData<String> name = new MutableLiveData<>();
    public MutableLiveData<String> email = new MutableLiveData<>();

    public FormViewModelLiveData(){}

    private MutableLiveData<User> userMutableLiveData;

    public LiveData<User> getUser(){
        if(userMutableLiveData == null){
            userMutableLiveData = new MutableLiveData<>();
        }
        return userMutableLiveData;
    }

    public void onBtnClicked(){
        User user = new User(name.getValue(), email.getValue());
        if(user.getEmail() == null || user.getName() == null){
            errorStr.setValue("Add some text");
        }

        userMutableLiveData.setValue(user);
    }

}
