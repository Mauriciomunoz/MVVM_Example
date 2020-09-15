package com.mapp.mvvm_project.viewmodel;

import com.mapp.mvvm_project.model.User;

import androidx.databinding.BaseObservable;
import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class FormViewModel extends BaseObservable {

    public final ObservableField<String> errorStr = new ObservableField<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String name;
    public String email;

    private MutableLiveData<User> userMutableLiveData;

    public FormViewModel(){

    }

    public LiveData<User> getUser(){
        if(userMutableLiveData == null){
            userMutableLiveData = new MutableLiveData<>();
        }
        return userMutableLiveData;
    }

    public void onBtnClicked(){
        User user = new User(getName(), getEmail());
        if(user.getEmail() == null || user.getName() == null){
            errorStr.set("Add some text");
        }

        userMutableLiveData.setValue(user);
    }

}
