package edu.gsu.httpscs.finalproject.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.gsu.httpscs.finalproject.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PasswordManagerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PasswordManagerFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    @OnClick(R.id.fragment_password_manager_tv)
    public void click1(View view){
        Intent intent = new Intent("edu.gsu.httpscs.finalproject.PasswordManagerLoginActivity");//check list
        startActivity(intent);
    }


    public PasswordManagerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CheckListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PasswordManagerFragment newInstance(String param1, String param2) {
        PasswordManagerFragment fragment = new PasswordManagerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_password_manager, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

}
