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
 * Unify {@link ItemView} and {@link ItemViewSelector} to simplify BindingAdapters.
 * Created by fgrott on 12/19/2015.
 */
@SuppressWarnings("unused")
public class ItemViewArg<T> {
    public static <T> ItemViewArg<T> of(ItemView itemView) {
        return new ItemViewArg<>(itemView);
    }

    public static <T> ItemViewArg<T> of(ItemViewSelector<T> selector) {
        return new ItemViewArg<>(selector);
    }

    private final ItemView itemView;
    private final ItemViewSelector<T> selector;

    private ItemViewArg(ItemView itemView) {
        this.itemView = itemView;
        this.selector = BaseItemViewSelector.empty();
    }

    private ItemViewArg(ItemViewSelector<T> selector) {
        this.itemView = new ItemView();
        this.selector = selector;
    }

    public void select(int position, T item) {
        selector.select(itemView, position, item);
    }

    public int bindingVariable() {
        return itemView.bindingVariable();
    }

    public int layoutRes() {
        return itemView.layoutRes();
    }

    public int viewTypeCount() {
        return selector.viewTypeCount();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemViewArg<?> that = (ItemViewArg<?>) o;

        return itemView.equals(that.itemView) && selector == that.selector;
    }

    @Override
    public int hashCode() {
        int result = itemView.hashCode();
        result = 31 * result + selector.hashCode();
        return result;
    }
}
