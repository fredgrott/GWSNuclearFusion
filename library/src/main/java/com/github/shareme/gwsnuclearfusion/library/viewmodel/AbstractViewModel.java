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
package com.github.shareme.gwsnuclearfusion.library.viewmodel;

import android.databinding.BaseObservable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.github.shareme.gwsnuclearfusion.library.view.IView;

/**
 * AbstractViewModel,
 *
 * Its okay to have Android framework refs here as we are not concerned with keeping this
 * as a pure POJO. The BaseObservable is for the Google DataBinding integration.
 *
 * Saving sate is wired into Activity and Fragment by ViewModelProvider and ViewModelHelper
 * respectively. Due to different coupling one could use this a MVC, MVP, MVVM, and even a Flux
 * OOP compound pattern.
 *
 * @param <T> view
 * Created by fgrott on 12/19/2015.
 */
@SuppressWarnings("unused")
public abstract class AbstractViewModel<T extends IView> extends BaseObservable {

    @Nullable
    private T mView;

    /**
     *
     * @param view the view ot initialize with
     */
    public void initWithView(@NonNull T view) {
        mView = view;
    }

    /**
     *
     * @return the view
     */
    public T getView() {
        return mView;
    }

    public void clearView() {
        mView = null;
    }

    /**
     *
     * @param bundle the bundle
     */
    public void saveState(Bundle bundle) {

    }

    /**
     * Will be called only in case the system is killed due to low memory and restored
     * @param bundle the bundle
     */
    public void restoreState(Bundle bundle) {

    }

    public void onStop() {

    }

    public void onStart() {

    }

    /**
     * Called when there parent fragment or view is already gone and destroyed.
     * This is a good place to empty any planned tasks that are useless without a UI.
     */
    public void onModelRemoved() {

    }
}
