package sonatasomething.thesecond;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;


public class CalDisplayActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal_display);
        setTitle("Event");
        JSONObject j=null;
        try {
            j = new JSONObject(getIntent().getStringExtra("stuff"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {

            TextView tv = (TextView) findViewById(R.id.head);
            tv.setText(j.getString("name"));

            TextView tv1 = (TextView) findViewById(R.id.name);
            tv1.setText(j.getString("name"));

            TextView tv2 = (TextView) findViewById(R.id.startd);
            tv2.setText(j.getString("startdate"));

            TextView tv3 = (TextView) findViewById(R.id.endd);
            tv3.setText(j.getString("enddate"));

            TextView tv4 = (TextView) findViewById(R.id.startt);
            tv4.setText(j.getString("starttime"));

            TextView tv5 = (TextView) findViewById(R.id.endt);
            tv5.setText(j.getString("endtime"));

            TextView tv6 = (TextView) findViewById(R.id.host);
            tv6.setText(j.getString("host"));

            TextView tv7 = (TextView) findViewById(R.id.loca);
            tv7.setText(j.getString("location"));

            TextView tv8 = (TextView) findViewById(R.id.descrip);
            tv8.setText(j.getString("description"));

            TextView tv9 = (TextView) findViewById(R.id.prereq);
            tv9.setText(j.getString("prereq"));
        }
        catch(JSONException e)
        {
            e.printStackTrace();
        }
    }
}
