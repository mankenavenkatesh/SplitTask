package splittask.app.com.splittask;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import splittask.app.com.splittask.fragments.ContactsFragment;
import splittask.app.com.splittask.fragments.GroupsFragment;
import splittask.app.com.splittask.fragments.TaskFragment;

/**
 * Created by vmankena on 10/6/16.
 */

public class Adapter extends FragmentPagerAdapter {
    String fragments[]={"Tasks", "Groups ","Contacts"};
    public Adapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int pos) {
        Log.d("DEBUG","GET Item - Inside Adapter");
        Fragment f=null;
        if(pos==0){
            f=new TaskFragment();
        }
        else if(pos==1){
            f=new GroupsFragment();
        }
        else if(pos==2){
            f=new ContactsFragment();
        }
        return f;
    }


    @Override
    public int getCount() {
        return fragments.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragments[position];
    }
}

