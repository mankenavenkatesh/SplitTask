package splittask.app.com.splittask.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import splittask.app.com.splittask.CustomizedAdapter;
import splittask.app.com.splittask.GroupActivity;
import splittask.app.com.splittask.R;


public class GroupsFragment extends Fragment {
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    String[] groups={"PCG-PD_India","Devopss","lacerte"};
    ListView list;
    Toolbar toolbar;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.groups, container,false);
        //android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) rootView.findViewById(R.id.toolbar);
        //toolbar.setTitle("My Groups");


        expListView = (ExpandableListView) rootView.findViewById(R.id.lvExp);
        //CustomList adapter = new
          //      CustomList(getActivity(), groups);
        //list=(ListView)rootView.findViewById(R.id.list);

        //list.setAdapter(adapter);
        //list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

          //  @Override
           // public void onItemClick(AdapterView<?> parent, View view,
                                 //   int position, long id) {
          //      Toast.makeText(getActivity(), "You Clicked at " +groups[+ position], Toast.LENGTH_SHORT).show();

        //    }
        //});

            prepareListData();

            listAdapter = new CustomizedAdapter(this.getActivity(), listDataHeader, listDataChild);

            // setting list adapter
            expListView.setAdapter(listAdapter);



        FloatingActionButton myFab = (FloatingActionButton) rootView.findViewById(R.id.fab);
        myFab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), GroupActivity.class);

                startActivity(intent);
            }
        });







        return rootView;
    }

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("PCG-PD_India");
        listDataHeader.add("Devopss");
        listDataHeader.add("lacerte");

        // Adding child data
        List<String> pcg = new ArrayList<String>();
        pcg.add("task1");
        pcg.add("task2");
        pcg.add("task3");
        pcg.add("task4");
        List<String> devopss = new ArrayList<String>();

        devopss.add("task1");
        devopss.add("task2");
        devopss.add("task3");


        List<String> lacerte = new ArrayList<String>();
        lacerte.add("task1");
        lacerte.add("task2");

        listDataChild.put(listDataHeader.get(0), pcg); // Header, Child data
        listDataChild.put(listDataHeader.get(1), devopss);
        listDataChild.put(listDataHeader.get(2), lacerte);
    }



}



