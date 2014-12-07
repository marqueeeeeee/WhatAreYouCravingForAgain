package com.aduhack.whatareyoucravingforagain.fragments;

import android.animation.ObjectAnimator;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.media.Image;
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
import com.aduhack.whatareyoucravingforagain.activity.MenuShopActivity;


public class MainFragment extends Fragment {


    Button circle2, circle3, circle4;
    ImageButton circle1, m1, m2, m3, m4, m5, m6, m7, m8;

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

        m1 = (ImageButton) view.findViewById(R.id.mini1);
        m2 = (ImageButton) view.findViewById(R.id.mini2);
        m3 = (ImageButton) view.findViewById(R.id.mini3);
        m4 = (ImageButton) view.findViewById(R.id.mini4);
        m5 = (ImageButton) view.findViewById(R.id.mini5);
        m6 = (ImageButton) view.findViewById(R.id.mini6);

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


        ScaleAnimation sa5 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        sa5.setDuration(200);
        sa5.setStartOffset(900);
        sa5.setInterpolator(b);

        m6.setAnimation(sa5);

        ScaleAnimation sa6 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        sa6.setDuration(200);
        sa6.setStartOffset(1000);
        sa6.setInterpolator(b);

        m1.setAnimation(sa6);

        ScaleAnimation sa7 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        sa7.setDuration(200);
        sa7.setStartOffset(1100);
        sa7.setInterpolator(b);

        m5.setAnimation(sa7);

        ScaleAnimation sa8 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        sa8.setDuration(200);
        sa8.setStartOffset(1200);
        sa8.setInterpolator(b);

        m3.setAnimation(sa8);

        ScaleAnimation sa9 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        sa9.setDuration(200);
        sa9.setStartOffset(1300);
        sa9.setInterpolator(b);

        m4.setAnimation(sa9);

        ScaleAnimation sa10 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        sa10.setDuration(200);
        sa10.setStartOffset(1400);
        sa10.setInterpolator(b);

        m2.setAnimation(sa10);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }


}
