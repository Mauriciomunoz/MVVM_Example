package com.mapp.mvvm_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.mapp.mvvm_project.databinding.ActivityMainBinding;
import com.mapp.mvvm_project.model.User;
import com.mapp.mvvm_project.viewmodel.FormViewModel;
import com.mapp.mvvm_project.viewmodel.FormViewModelLiveData;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        FormViewModelLiveData fViewModelLD = ViewModelProviders.of(this).get(FormViewModelLiveData.class);
        binding.setFormViewModelObservable(fViewModelLD);
        binding.setLifecycleOwner(this);

        fViewModelLD.getUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                if(user.getName() != null && user.getEmail() != null){
                    binding.txtOutput.setText(user.getName() + " :: " + user.getEmail());
                }
            }
        });

        //This is using BaseObservable for our ViewModel.
        //This is not Lifecycle aware
        /*
        FormViewModel fViewModel = new FormViewModel();
        binding.setFormViewModelObservable(fViewModel);

        fViewModel.getUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                if(user.getName() != null && user.getName() != null)
                    binding.txtOutput.setText(user.getName() + " :: " + user.getEmail());
            }
        });
        */

    }
}