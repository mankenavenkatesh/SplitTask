package splittask.app.com.splittask.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.Toolbar;

import splittask.app.com.splittask.ContactActivity;
import splittask.app.com.splittask.CustomList;
import splittask.app.com.splittask.R;
import splittask.app.com.splittask.TaskActivity;


/**
 * Created by vmankena on 10/6/16.
 */

public class TaskFragment extends Fragment {
    String[] tasks={"Production Support","Regression Checks"};
    ListView list;
    Toolbar toolbar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.tasks, container,false);

        CustomList adapter = new
                CustomList(getActivity(), tasks);
        list=(ListView)rootView.findViewById(R.id.task_list);

        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(getActivity(), "OCT4" +tasks[+ position], Toast.LENGTH_SHORT).show();

            }
        });


        FloatingActionButton myFab = (FloatingActionButton) rootView.findViewById(R.id.fab);
        myFab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TaskActivity.class);

                startActivity(intent);
            }
        });

        return rootView;
    }
}
