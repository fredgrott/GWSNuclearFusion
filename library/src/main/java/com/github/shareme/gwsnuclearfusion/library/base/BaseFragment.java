package com.github.shareme.gwsnuclearfusion.library.base;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.github.shareme.gwsnuclearfusion.library.viewmodel.AbstractViewModel;
import com.github.shareme.gwsnuclearfusion.library.viewmodel.IView;
import com.github.shareme.gwsnuclearfusion.library.viewmodel.ViewModelHelper;

/**
 * BaseFragment
 * Created by fgrott on 12/19/2015.
 */
@SuppressWarnings("unused")
public abstract class BaseFragment<T extends IView, R extends AbstractViewModel<T>> extends Fragment {

    private ViewModelHelper<T, R> mViewModeHelper = new ViewModelHelper<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModeHelper.onCreate(getActivity(), savedInstanceState, getViewModelClass());
    }

    public abstract Class<R> getViewModelClass();

    @Override
    @SuppressWarnings("unchecked")
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModeHelper.initWithView((T) this);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mViewModeHelper.onSaveInstanceState(outState);
    }

    @Override
    public void onStart() {
        super.onStart();
        mViewModeHelper.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mViewModeHelper.onStop();
    }

    @Override
    public void onDestroyView() {
        mViewModeHelper.onDestroyView(this);
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        mViewModeHelper.onDestroy(this);
        super.onDestroy();
    }

    public R getViewModel() {
        return mViewModeHelper.getViewModel();
    }

}
