package sonatasomething.thesecond;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class CertificationActivity extends ActionBarActivity {
    HashMap<String, List<String>> Skills_Category;
    List<String> Skills_list;
    ExpandableListView exp_list;
    Skills_Adapter1 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_certifications);
        setTitle("My Certifications");
        exp_list = (ExpandableListView) findViewById(R.id.exp_list);
        Skills_Category = dataProvider1.getInfo();


        Skills_list = new ArrayList<String>(Skills_Category.keySet());
        adapter = new Skills_Adapter1(this, Skills_Category, Skills_list);
        exp_list.setAdapter(adapter);
        exp_list.setGroupIndicator(null);
    }
}