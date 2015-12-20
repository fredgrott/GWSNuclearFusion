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
package com.github.shareme.gwsnuclearfusion.library.binding.rv;

import android.databinding.BindingAdapter;
import android.databinding.BindingConversion;
import android.support.v7.widget.RecyclerView;

import com.github.shareme.gwsnuclearfusion.library.binding.listview.BindingCollectionAdapters;
import com.github.shareme.gwsnuclearfusion.library.binding.listview.ItemViewArg;
import com.github.shareme.gwsnuclearfusion.library.binding.listview.Utils;

import java.util.List;

/**
 * @see {@link BindingCollectionAdapters}
 * Created by fgrott on 12/20/2015.
 */
@SuppressWarnings("unused")
public class BindingRecyclerViewAdapters {
    // RecyclerView
    @SuppressWarnings("unchecked")
    @BindingAdapter(value = {"itemView", "items", "adapter", "itemIds"}, requireAll = false)
    public static <T> void setAdapter(RecyclerView recyclerView, ItemViewArg<T> arg, List<T> items, BindingRecyclerViewAdapterFactory factory, BindingRecyclerViewAdapter.ItemIds<T> itemIds) {
        if (arg == null) {
            throw new IllegalArgumentException("itemView must not be null");
        }
        if (factory == null) {
            factory = BindingRecyclerViewAdapterFactory.DEFAULT;
        }
        BindingRecyclerViewAdapter<T> adapter = (BindingRecyclerViewAdapter<T>) recyclerView.getAdapter();
        if (adapter == null || !adapter.getItemViewArg().equals(arg)) {
            adapter = factory.create(recyclerView, arg);
            adapter.setItemIds(itemIds);
            recyclerView.setAdapter(adapter);
        }
        adapter.setItems(items);
    }

    @BindingAdapter("layoutManager")
    public static void setLayoutManager(RecyclerView recyclerView, LayoutManagers.LayoutManagerFactory layoutManagerFactory) {
        recyclerView.setLayoutManager(layoutManagerFactory.create(recyclerView));
    }

    @BindingConversion
    public static BindingRecyclerViewAdapterFactory toRecyclerViewAdapterFactory(final String className) {
        return new BindingRecyclerViewAdapterFactory() {
            @Override
            public <T> BindingRecyclerViewAdapter<T> create(RecyclerView recyclerView, ItemViewArg<T> arg) {
                return Utils.createClass(className, arg);
            }
        };
    }
}
