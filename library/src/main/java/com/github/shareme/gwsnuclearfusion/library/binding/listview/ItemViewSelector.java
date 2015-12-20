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

/**
 * Modify an {@link ItemView} based on the given position and item. This allows you to have
 * different layouts in the same collection. You may want to subclass {@link BaseItemViewSelector}
 * instead if you don't need to use {@link #viewTypeCount()}.
 * Created by fgrott on 12/19/2015.
 */
@SuppressWarnings("unused")
public interface ItemViewSelector<T> {

    /**
     * Called on each item in the collection, allowing you to modify the given {@link ItemView}.
     * Note that you should not do complex processing in this method as it's called many times.
     */
    void select(ItemView itemView, int position, T item);

    /**
     * Return the number of <em>different</em> layouts that you will be displaying. Currently this
     * is only used in {@link BindingListViewAdapter}.
     */
    int viewTypeCount();

}
