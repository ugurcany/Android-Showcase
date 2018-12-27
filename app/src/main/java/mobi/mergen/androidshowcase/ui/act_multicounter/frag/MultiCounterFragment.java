package mobi.mergen.androidshowcase.ui.act_multicounter.frag;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.evernote.android.state.State;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import mobi.mergen.androidshowcase.R;
import mobi.mergen.androidshowcase.ui.act_multicounter.IMultiCounterNav;
import mobi.mergen.androidshowcase.ui.base.BaseFragment;
import mobi.mergen.androidshowcase.databinding.FragmentMultiCounterBinding;

public class MultiCounterFragment
        extends BaseFragment<FragmentMultiCounterBinding, MultiCounterViewModel> {

    @Inject
    IMultiCounterNav fragNavController;

    @State
    int pageId;
    @State
    int pageInCurrentTabId;
    @State
    int count;

    public static MultiCounterFragment initialize(int pageId, int pageInCurrentTabId) {
        MultiCounterFragment fragment = new MultiCounterFragment();
        fragment.pageId = pageId;
        fragment.pageInCurrentTabId = pageInCurrentTabId;
        fragment.count = 0;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);

        getBinding().setPageName(getString(R.string.multicounter_page_x,
                pageId, pageInCurrentTabId));
        getBinding().setCount(count);

        getBinding().fab.setOnClickListener((v) ->
                getBinding().setCount(++count));
        getBinding().buttonNewPage.setOnClickListener((v) ->
                fragNavController.pushFragment(pageId, pageInCurrentTabId + 1));

        return rootView;
    }

    @Override
    public int layoutRes() {
        return R.layout.fragment_multi_counter;
    }

    @Override
    public Class<MultiCounterViewModel> viewModelClass() {
        return MultiCounterViewModel.class;
    }

}
