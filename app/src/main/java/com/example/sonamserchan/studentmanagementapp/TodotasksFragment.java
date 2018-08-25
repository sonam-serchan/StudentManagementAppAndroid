package com.example.sonamserchan.studentmanagementapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.sonamserchan.studentmanagementapp.adapter.ListAdapterTodoTasks;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TodotasksFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TodotasksFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TodotasksFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    /**Creating arrays of data of pizzas**/

    ListView listView;

    String[] nameArray = {"Ham and Pineapple", "Supreme", "Seafood", "Margherita", "Pepperoni", "Mexican",
            "Italian", "Meat Lover", "Vegeterian"};

    String[] infoArray = {"A famous Hawaiian pizza", "Lots of items", "Prawns, squids and kalamari",
            "Traditonal pizza", "Lots of pepperoni", "Spicy chorizo with jalopeno",
            "Something new to try", "Beef, pepperoni, chorizo, chicken, ham", "An exotic veg pizza"};

    String[] priceArray = {"$15", "$20", "$25", "$15", "$20", "$20", "$20", "$25", "$20"};

    Integer[] imageArray = {R.drawable.ic_assignment_black_24dp, R.drawable.ic_dashboard_black_24dp, R.drawable.ic_home_black_24dp,
            R.drawable.ic_image_black_24dp, R.drawable.ic_person_black_24dp, R.drawable.ic_speaker_notes_black_24dp, R.drawable.ic_notifications_black_24dp,
            R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_background};

    ListAdapterTodoTasks listAdapter;

    public TodotasksFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TodotasksFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TodotasksFragment newInstance(String param1, String param2) {
        TodotasksFragment fragment = new TodotasksFragment();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_todotasks, container, false);

        listAdapter = new ListAdapterTodoTasks(getActivity(), nameArray, infoArray, imageArray, priceArray);

        listView = view.findViewById(R.id.listViewTodotask);
        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //String item = (String)listView.getAdapter().getItem(position);
                //Toast.makeText(getApplicationContext(), item, Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
