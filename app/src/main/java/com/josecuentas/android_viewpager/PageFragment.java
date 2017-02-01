package com.josecuentas.android_viewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by jcuentas on 30/01/17.
 */

public class PageFragment extends Fragment {

    private TextView mTviTitle;
    private TextView mTviMessage;
    private CardView mCardView;
    private Page mPage;

    public static PageFragment newInstance(Bundle args) {
        PageFragment pageFragment = new PageFragment();
        pageFragment.setArguments(args);
        return pageFragment;
    }

    @Nullable @Override public View onCreateView(LayoutInflater inflater,
                                                 @Nullable ViewGroup container,
                                                 @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page, container, false);
        injectView(view);
        extras();
        populate();
        return view;
    }

    private void extras() {
        Bundle arguments = getArguments();
        if (arguments == null) return;
        mPage = (Page) arguments.getSerializable(Page.BUNDLE);
    }

    private void populate() {
        if (mPage == null) return;
        String title = mPage.getTitle();
        String message = mPage.getMessage();
        mTviTitle.setText(title);
        mTviMessage.setText(message);

        mCardView.setMaxCardElevation(mCardView.getCardElevation() * PageAdapter.MAX_ELEVATION);
    }

    private void injectView(View view) {
        mTviTitle = (TextView) view.findViewById(R.id.tviTitle);
        mTviMessage = (TextView) view.findViewById(R.id.tviMessage);
        mCardView = (CardView) view.findViewById(R.id.cardView);
    }

    public CardView getCardView() {
        return mCardView;
    }
}
