package splittask.app.com.splittask;

/**
 * Created by kvanwani on 10/6/16.
 */
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CustomList extends ArrayAdapter<String>{

    private final Activity context;
    private final String[] contacts;

    public CustomList(Activity context,
                      String[] contacts) {
        super(context, R.layout.list_single, contacts);
        this.context = context;
        this.contacts = contacts;


    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_single, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);
        txtTitle.setText(contacts[position]);


        return rowView;
    }
}
