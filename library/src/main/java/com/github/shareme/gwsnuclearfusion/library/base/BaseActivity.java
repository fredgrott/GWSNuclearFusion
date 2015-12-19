package com.github.shareme.gwsnuclearfusion.library.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.shareme.gwsnuclearfusion.library.viewmodel.IViewModelProvider;
import com.github.shareme.gwsnuclearfusion.library.viewmodel.ViewModelProvider;

/**
 * BaseActivity
 * Created by fgrott on 12/19/2015.
 */
public class BaseActivity extends AppCompatActivity implements IViewModelProvider {

    private ViewModelProvider mViewModelService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //This code must be execute prior to super.onCreate()
        if (getLastCustomNonConfigurationInstance() == null) {
            mViewModelService = new ViewModelProvider();
        } else {
            mViewModelService = (ViewModelProvider) getLastCustomNonConfigurationInstance();
        }
        super.onCreate(savedInstanceState);
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        return mViewModelService;
    }

    @Override
    public ViewModelProvider getViewModelProvider() {
        return mViewModelService;
    }

    @Override
    protected void onStop() {
        if (isFinishing()) {
            mViewModelService.removeAllViewModels();
        }
        super.onStop();
    }

}
