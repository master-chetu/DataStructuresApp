package com.Felixpat.chetu.DataStructures;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.IntegerRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstUnitFragment extends Fragment {

    View view;
    ArrayAdapter<String> arrayAdapter;
    ArrayList<String> arrayList0,arrayList1,arrayList2,arrayList3,arrayList4;
    ListView listView;
    int place;
    SharedPreferences pref,flow;




    public FirstUnitFragment(int place) {
        // Required empty public constructor
        this.place=place;
    }
    public FirstUnitFragment(){

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_first_unit, container, false);
        setRetainInstance(true);
        pref = view.getContext().getSharedPreferences("counters",Context.MODE_PRIVATE);
        flow = view.getContext().getSharedPreferences("com.Felixpat.chetu.DataStructures",Context.MODE_PRIVATE);
        listView=(ListView)view.findViewById(R.id.listview);
        arrayList0=new ArrayList<String>();
        arrayList1=new ArrayList<String>();
        arrayList2=new ArrayList<String>();
        arrayList3=new ArrayList<String>();
        arrayList4=new ArrayList<String>();



        arrayList0.add("1.1 Role of Algorithms in Computing");
        arrayList0.add("1.2 Algorithms as technology");
        arrayList0.add("1.3 Structures in C");
        arrayList0.add("1.4 Unions in C");
        arrayList0.add("1.5 Recursions");
        arrayList0.add("Quiz-I");





        arrayList1.add("2.1 Abstract Data Types");
        arrayList1.add("2.2 Stack");
        arrayList1.add("2.3 Stack applications");
        arrayList1.add("2.4 Queue");
        arrayList1.add("2.5 Hash Tables");
        arrayList1.add("Quiz-II");

        arrayList2.add("3.1 Trees");
        arrayList2.add("3.2 Binary Trees");
        arrayList2.add("3.3 Expression Tree");
        arrayList2.add("3.4 Binary Search Trees");
        arrayList2.add("3.5 AVL Trees");
        arrayList2.add("3.6 B-Trees");
        arrayList2.add("Quiz-III");

        arrayList3.add("4.1 Priority Queues - Heaps");
        arrayList3.add("4.2 Sorting");
        arrayList3.add("4.3 Searching");
        arrayList3.add("Quiz-IV");

        arrayList4.add("5.1 Graph Terminologies");
        arrayList4.add("5.2 Minimum Spanning Tree");
        arrayList4.add("5.3 Shortest Path Problems");
        arrayList4.add("Quiz-V");

        switch (place){
            case 0:
                arrayAdapter=new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_list_item_1, arrayList0);
                listView.setAdapter(arrayAdapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        if(arrayList0.size()-1==i){
                                Intent in = new Intent(getActivity(),Quiz.class);
                                in.putExtra("number",0);
                                getActivity().startActivity(in);
                            }
                            else {
                                Intent in = new Intent(getActivity(), DataActivity.class);
                                Bundle bundle = new Bundle();
                                bundle.putString("title", arrayList0.get(i));
                                bundle.putInt("number", i);
                                bundle.putInt("unit", place);
                                in.putExtras(bundle);


                                getActivity().startActivity(in);
                            }

                    }
                });
                break;
            case 1:
                arrayAdapter=new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_list_item_1, arrayList1);
                listView.setAdapter(arrayAdapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            if(i == arrayList1.size()-1) {
                                Intent in = new Intent(getActivity(), Quiz.class);
                                in.putExtra("number",1);
                                getActivity().startActivity(in);
                            }
                            else {
                                Intent in = new Intent(getActivity(), DataActivity.class);
                                Bundle bundle = new Bundle();
                                bundle.putString("title", arrayList1.get(i));
                                bundle.putInt("number", i);
                                bundle.putInt("unit", place);
                                in.putExtras(bundle);
                                getActivity().startActivity(in);
                            }

                    }
                });
                break;
            case 2:
                arrayAdapter=new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_list_item_1, arrayList2);
                listView.setAdapter(arrayAdapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        if(i == arrayList2.size()-1) {
                                Intent in = new Intent(getActivity(), Quiz.class);
                                in.putExtra("number",2);
                                getActivity().startActivity(in);
                            }
                            else {
                                Intent in = new Intent(getActivity(), DataActivity.class);
                                Bundle bundle = new Bundle();
                                bundle.putString("title", arrayList2.get(i));
                                bundle.putInt("number", i);
                                bundle.putInt("unit", place);
                                in.putExtras(bundle);
                                getActivity().startActivity(in);
                            }
                    }
                });
                break;
            case 3:
                arrayAdapter=new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_list_item_1, arrayList3);
                listView.setAdapter(arrayAdapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        if(i == arrayList3.size()-1) {
                                Intent in = new Intent(getActivity(), Quiz.class);
                                in.putExtra("number",3);
                                getActivity().startActivity(in);
                            }
                            else {
                                Intent in = new Intent(getActivity(), DataActivity.class);
                                Bundle bundle = new Bundle();
                                bundle.putString("title", arrayList3.get(i));
                                bundle.putInt("number", i);
                                bundle.putInt("unit", place);
                                in.putExtras(bundle);

                                getActivity().startActivity(in);
                            }

                    }
                });
                break;
            case 4:
                arrayAdapter=new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_list_item_1, arrayList4);
                listView.setAdapter(arrayAdapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        if(i == arrayList4.size()-1) {
                                Intent in = new Intent(getActivity(), Quiz.class);
                                in.putExtra("number",4);
                                getActivity().startActivity(in);
                            }
                            else {
                                Intent in = new Intent(getActivity(), DataActivity.class);
                                Bundle bundle = new Bundle();
                                bundle.putString("title", arrayList4.get(i));
                                bundle.putInt("number", i);
                                bundle.putInt("unit", place);
                                in.putExtras(bundle);

                                getActivity().startActivity(in);
                            }

                    }
                });
                break;

        }


        return view;
    }

}
