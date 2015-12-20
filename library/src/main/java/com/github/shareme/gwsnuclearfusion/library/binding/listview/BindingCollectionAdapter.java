/*
 * Copyright 2015 Evan Tatarka
 * Modifications Copyright(C) 2015 Fred Grott(GrottWorkShop)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.github.shareme.gwsnuclearfusion.library.binding.listview;

import android.databinding.ObservableList;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

/**
 * Base interface for the binding collection adapters for various components.
 *
 * @see BindingListViewAdapter
 * @see BindingViewPagerAdapter
 * Created by fgrott on 12/19/2015.
 */
@SuppressWarnings("unused")
public interface BindingCollectionAdapter<T> {
    /**
     * Returns the {@link ItemViewArg} that the adapter was constructed with.
     */
    ItemViewArg<T> getItemViewArg();

    /**
     * Sets the adapter's items. These items will be displayed based on the {@link ItemView} or
     * {@link ItemViewSelector}. If you pass in an {@link ObservableList} the adapter will also
     * update itself based on that list's changes. <br/> Note that the adapter will keep a direct
     * reference to the given list. Any changes to it <em>must</em> happen on the main thread.
     * Additionally, if you are not using an {@code ObservableList}, you <em>must</em> call {@code
     * notifyDataSetChanged()} or one of the related methods.
     */
    void setItems(@Nullable List<T> items);

    /**
     * Returns the item in the adapter given position. This is useful for accessing items in the
     * adapter.
     */
    T getAdapterItem(int position);

    /**
     * Called to create a binding. An implementation should create a binding inflated with the given
     * {@code layoutId} and {@code viewGroup}. A subclass may override this and cast the result to a
     * specific layout binding to get at the generated view fields.
     */
    ViewDataBinding onCreateBinding(LayoutInflater inflater, @LayoutRes int layoutRes, ViewGroup viewGroup);

    /**
     * Called to bind the given item to the binding. An implementation should simply set the item as
     * a variable on the binding. A subclass may override this and cast the binding to an
     * implementation specific layout binding to get at the generated view fields.
     */
    void onBindBinding(ViewDataBinding binding, int bindingVariable, @LayoutRes int layoutRes, int position, T item);
}
