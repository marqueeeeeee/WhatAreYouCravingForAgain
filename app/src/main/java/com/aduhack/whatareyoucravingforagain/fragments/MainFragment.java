package com.aduhack.whatareyoucravingforagain.fragments;

import android.animation.ObjectAnimator;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.BounceInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageButton;

import com.aduhack.whatareyoucravingforagain.R;


public class MainFragment extends Fragment {


    Button circle2, circle3, circle4;
    ImageButton circle1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        circle1 = (ImageButton) view.findViewById(R.id.circle1);
        circle2 = (Button) view.findViewById(R.id.circle2);
        circle3 = (Button) view.findViewById(R.id.circle3);
        circle4 = (Button) view.findViewById(R.id.circle4);



        AnimationSet anims = new AnimationSet(false);
        BounceInterpolator b = new BounceInterpolator();

        anims.setInterpolator(b);

        ScaleAnimation sa = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        sa.setDuration(500);
        sa.setInterpolator(b);
        anims.addAnimation(sa);

        circle4.setAnimation(sa);

        ScaleAnimation sa2 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        sa2.setDuration(500);
        sa2.setStartOffset(200);
        sa2.setInterpolator(b);
        circle3.setAnimation(sa2);

        ScaleAnimation sa3 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        sa3.setDuration(500);
        sa3.setStartOffset(400);
        sa3.setInterpolator(b);

        circle2.setAnimation(sa3);

        ScaleAnimation sa4 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        sa4.setDuration(500);
        sa4.setStartOffset(600);
        sa4.setInterpolator(b);

        circle1.setAnimation(sa4);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
