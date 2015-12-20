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
 * You may extend this instead of {@link ItemViewSelector} if you do not need to implement {@link
 * #viewTypeCount()}, which is currently only used for {@link BindingListViewAdapter}.
 * Created by fgrott on 12/19/2015.
 */
public abstract class BaseItemViewSelector<T> implements ItemViewSelector<T> {
    private static final ItemViewSelector EMPTY = new BaseItemViewSelector() {


        @Override
        public void select(ItemView itemView, int position, Object item) {

        }
    };

    /**
     * Returns an empty {@link ItemViewSelector}, i.e. one that does nothing on {@link
     * #select(ItemView, int, Object)}.
     */
    @SuppressWarnings("unchecked")
    public static <T> ItemViewSelector<T> empty() {
        return EMPTY;
    }

    @Override
    public int viewTypeCount() {
        return 1;
    }
}
