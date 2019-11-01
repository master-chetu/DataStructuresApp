package com.Felixpat.chetu.DataStructures;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProgrammsFragment extends Fragment {


    ArrayList<String> list,list1;
    ArrayAdapter<String> adapter;
    ListView programmslist;
    int position;
    private AdView mAdView;

    public ProgrammsFragment(int position){
        this.position=position;
    }
    public ProgrammsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_programms, container, false);
        setRetainInstance(true);
        mAdView = (AdView) v.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        programmslist=(ListView)v.findViewById(R.id.programmslist);
        list=new ArrayList<>();
        list1=new ArrayList<>();


        list.add("1. Find Factorial of a number Using Recursion");
        list.add("2. Find Fibonacci Series Using Recursion");
        list.add("3. Find GCD of two numbers Using Recursion");
        list1.add("1. Reversing of Array elements using Recursion");
        list.add("4. Book Database Using Structures and pointers");
        list.add("5. Employee Database Using Structures and pointers");
        list1.add("2. Bank Database Using Structures and pointers");
        list.add("6. Array Implementation of List ADT- Creation, Insertion, Deletion, Search, Display operations");
        list.add("7. Linked list Implementation of List ADT – Creation List, Add, Insert, Delete , Search given data");
        list.add("8. Array implementation of Stack ADT");
        list1.add("3. Array implementation of Queue ADT");
        list1.add("4. Linked List implementation of Stack ADT");
        list.add("9. Linked List implementation of Queue ADT");
        list.add("10. Applications of stack - a. Checking Balanced Parentheses using stack"
                );
        list.add("11. Applications of stack -b. Evaluating Postfix expressions using stack"
                );
        list1.add("5. Applications of stack - Converting Infix to Postfix form");
        list.add("12. Binary Search Trees – implementation");
        list.add("13. Program to sort set of elements using Heap sort");
        list1.add("6. Program to sort set of elements using Quick sort");
        list1.add("7. Program to search an element in a list using Linear search");
        list.add("14. Program to search an element in a list using Binary search.");
        list.add("15. Implementation of Dijkstra’s shortest path algorithm");
        list.add("16. Finding Minimum Spanning Tree using Kruskal’s algorithm"
                );

        list1.add("8. Finding Minimum Spanning Tree using Prim’s algorithm");
        if(position==0){

            adapter= new ArrayAdapter<String>(v.getContext(),android.R.layout.simple_list_item_1,list);
            programmslist.setAdapter(adapter);

            programmslist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    Intent code = new Intent(getActivity(),code.class);
                    Bundle pass = new Bundle();
                    pass.putInt("no",i);
                    code.putExtras(pass);
                    getActivity().startActivity(code);
                }
            });




        }
        else{

            adapter=new ArrayAdapter<String>(v.getContext(),android.R.layout.simple_list_item_1,list1);
            programmslist.setAdapter(adapter);

        }







        return v;

    }

}
