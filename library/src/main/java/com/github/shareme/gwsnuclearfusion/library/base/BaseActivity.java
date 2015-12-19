/**
 * Eu.inloop Copyright(C) 2014
 * Modifications Copyright(C) 2015 Fred Grott(GrottWorkShop)
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is
 * distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under License.
 */
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
