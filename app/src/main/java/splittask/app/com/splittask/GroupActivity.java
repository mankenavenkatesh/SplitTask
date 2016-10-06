package splittask.app.com.splittask;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroupActivity extends AppCompatActivity {
    AutoCompleteTextView text;
    Button addBtn;
    String[] groups={"PCG-PD_India","Devopss","lacerte"};
    ArrayList<String> list = new ArrayList<String>();
    ArrayAdapter<String> listAdapter;
    EditText groupName;
    ListView listView;
    private List<String> mItems;
    private CompleteListAdapter mListAdapter;
    String[] ListElements = new String[] {};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final List<String> ListElementsArrayList = new ArrayList<String>(Arrays.asList(ListElements));

        mItems = new ArrayList<String>();
        addBtn = (Button)findViewById(R.id.addBtn);

        text=(AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,groups);
        mListAdapter = new CompleteListAdapter(this, mItems);
        text.setAdapter(adapter);
        listView = (ListView) findViewById(R.id.participantList);
        listView.setAdapter(mListAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        listView.setOnTouchListener(new View.OnTouchListener() {
            // Setting on Touch Listener for handling the touch inside ScrollView
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // Disallow the touch request for parent scroll on touch of child view
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });



    }

    public void addParticipant(View view){
        mItems.add(text.getText().toString());
        Log.d("debug",mItems.toString());
        text.setText("");
        mListAdapter.notifyDataSetChanged();


    }

    public void SaveToGroupList(View view){
        groupName = (EditText)findViewById(R.id.groupName);
        Log.d("DEBUG",groupName.getText().toString());
        Intent intent = new Intent(this, GroupListActivity.class);
        intent.putExtra("newGroup",groupName.getText().toString());
        startActivity(intent);




    }

}
