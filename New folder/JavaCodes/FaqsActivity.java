package sonatasomething.thesecond;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class FaqsActivity extends ActionBarActivity {
    HashMap<String, List<String>> Skills_Category;
    List<String> Skills_list;
    ExpandableListView exp_list;
    Skills_Adapter adapter;
    //Special_Adapter adapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faqs);
        setTitle("FAQS");
        exp_list = (ExpandableListView) findViewById(R.id.exp_list);
        Skills_Category = dataProvider.getInfo();
        Skills_list = new ArrayList<String>(Skills_Category.keySet());
        adapter = new Skills_Adapter(this, Skills_Category, Skills_list);
        exp_list.setAdapter(adapter);
        exp_list.setGroupIndicator(null);
    }
}