package com.example.sanchitra.view;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.sanchitra.R;
import com.example.sanchitra.databinding.ActivityDetailViewBinding;

public class DetailViewActivity extends FragmentActivity {

    private ActivityDetailViewBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_detail_view);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_view);

        Glide.with(this)
             .load(getIntent().getStringExtra("image"))
              .into(binding.headBanner);
        binding.headTitle.setText(getIntent().getStringExtra("title"));
        binding.subtitle.setText(getIntent().getStringExtra("release"));
        binding.description.setText(getIntent().getStringExtra("summary"));
        changeFragment(new EpisodeListView());
    }

    private void changeFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.episode_fragment, fragment);
        transaction.commit();
    }
}