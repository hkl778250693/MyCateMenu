package com.example.administrator.catemenu.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import com.example.administrator.catemenu.R;
import com.example.administrator.catemenu.activity.SquarePublishActivity;

/**
 * Created by Administrator on 2016/11/13.
 */
public class SquareFragment extends Fragment {
    SquareDiscussFragment squareDiscussFragment;
    SquareVideoFragment squareVideoFragment;
    private RadioButton videoBtn;
    private RadioButton discussBtn;
    private RadioButton releaseBtn;

    LinearLayout llSquareFragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_square, null);


        llSquareFragment = (LinearLayout) view.findViewById(R.id.ll_square_fragment);
        discussBtn = (RadioButton) view.findViewById(R.id.rb_square_discuss);
        releaseBtn = (RadioButton) view.findViewById(R.id.rb_square_release);
        videoBtn = (RadioButton) view.findViewById(R.id.rb_square_video);

        discussBtn.setOnClickListener(onClickListener);
        releaseBtn.setOnClickListener(onClickListener);
        videoBtn.setOnClickListener(onClickListener);

        discussBtn.setChecked(true);

        if (discussBtn.isChecked()) {
            addHomepageFragment();
        }
        return view;
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            switch (view.getId()) {

                case R.id.rb_square_discuss:
                    if (squareDiscussFragment == null) {
                        squareDiscussFragment = new SquareDiscussFragment();
                    }
                    transaction.replace(R.id.ll_square_fragment, squareDiscussFragment);
                    break;

                case R.id.rb_square_release:
                    Intent intent=new Intent(getActivity(), SquarePublishActivity.class);
                    startActivity(intent);
                    break;

                case R.id.rb_square_video:
                    if (squareVideoFragment == null) {
                        squareVideoFragment = new SquareVideoFragment();
                    }
                   transaction.replace(R.id.ll_square_fragment, squareVideoFragment);
                    break;
            }
            transaction.commit();
        }
    };


    public void addHomepageFragment() {
        squareDiscussFragment = new SquareDiscussFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.ll_square_fragment, squareDiscussFragment);
        fragmentTransaction.commit();
    }
}
