package com.openclassrooms.myfragmentapp.Activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.openclassrooms.myfragmentapp.R;


public class FragmentMainActivity extends Fragment implements View.OnClickListener {

    //2 DECLARE CALLBACK
    private OnButtonClickedListener mCallback;

    //1 DECLARE OUR INTERFACE THAT WILL BE IMPLEMENTED BY ANY CONTAINER ACTIVITY
    public interface OnButtonClickedListener {
        public void onButtonClicked(View view);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

         //INFLATE THE LAYOUT OF MAINFRAGMENT
        View result=inflater.inflate(R.layout.fragment_main_activity, container, false);
        // SET ON CLICK TO BUTTON SHOW ME DETAIL
        result.findViewById(R.id.fragment_main_button_happy).setOnClickListener(this);
        result.findViewById(R.id.fragment_main_button_sad).setOnClickListener(this);
        result.findViewById(R.id.fragment_main_button_horrible).setOnClickListener(this);

        return result;

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        //4 CALL THE METHOD THAT CREATING CALLBACK AFTER BEING ATTACHE TO PARENT ACTIVITY

        this.createCallbackToParentActivity();
    }

    //ACTION....

    @Override
    public void onClick(View v) {
        //HERE IS HANDLED THE BUTTON CLICK
        mCallback.onButtonClicked((v));
    }

    // FRAGMENT SUPPORT

    // 3 CREATE CALLBACK TO PARENT ACTIVITY
    private void createCallbackToParentActivity() {
        try {
            // PARENT ACTIVITY WILL AUTOMATICALLY SUBSCRIBE TO CALLBACK
            mCallback = (OnButtonClickedListener) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(e.toString()+ "must implement OnButtonClickedListener");
        }
    }


}