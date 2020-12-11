package com.openclassrooms.myfragmentapp.Activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.openclassrooms.myfragmentapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailFragment extends Fragment {
    private TextView mTextView;
    private int buttonTag;
    private static final String KEY_BUTTONTAG = "com.openclassrooms.myfragmentapp.Fragment.DetailFragment.KEY_BUTTONTAG";

    public DetailFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_detail,container, false);
        this.mTextView=(TextView) view.findViewById(R.id.fragment_detail_text_view);
        return(view);
    }

    public void updateTextView(int tag) {
        this.buttonTag = tag;

        switch (tag) {
            case 10:
                this.mTextView.setText("Youre very good programmer");
                break;
            case 20:
                this.mTextView.setText("I do believe that jon snow is going to die in next season");
                break;
            case 30:
                this.mTextView.setText("Maybe game of throne next season will get back in 2040?");
                break;
            default:
                break;
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (savedInstanceState != null) {
            int buttonTagRestored = savedInstanceState.getInt(KEY_BUTTONTAG, 0);
            this.updateTextView(buttonTagRestored);
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_BUTTONTAG, buttonTag);
    }

}

