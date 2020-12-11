package com.openclassrooms.myfragmentapp.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.openclassrooms.myfragmentapp.R;

public class DetailActivity extends AppCompatActivity {
    private DetailFragment mDetailFragment;
    public static final String EXTRA_BUTTON_TAG = "com.openclassrooms.myfragmentapp.Activities.DetailActivity.EXTRA_BUTTON_TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        this.configureAndShowDetailFragment();
    }

    @Override
    public void onResume() {
        super.onResume();

        this.updateDetailFragmentTextViewWithIntentTag();
    }

    private void configureAndShowDetailFragment() {

        // A - Get FragmentManager (Support) and Try to find existing instance of fragment in FrameLayout container
        mDetailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.frame_layout_detail);

        if (mDetailFragment == null) {
            // B - Create new main fragment
            mDetailFragment = new DetailFragment();
            // C - Add it to FrameLayout container
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frame_layout_detail, mDetailFragment)
                    .commit();
        }
    }

    private void updateDetailFragmentTextViewWithIntentTag() {

        int buttonTag = getIntent().getIntExtra(EXTRA_BUTTON_TAG, 0);
        mDetailFragment.updateTextView(buttonTag);

    }
}