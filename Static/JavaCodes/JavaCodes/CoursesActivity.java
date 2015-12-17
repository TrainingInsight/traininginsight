package sonatasomething.thesecond;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class CoursesActivity extends ActionBarActivity {

    String coursenames[];
    JSONArray inarray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);
        setTitle("Courses Being Offered");
        JSONArray ja = null;
        String test = "[{\"id\":1,\"shortname\":\"sonlms\",\"categoryid\":0,\"categorysortorder\":1,\"fullname\":\"Sonata Learning Management System\",\"idnumber\":\"\",\"summary\":\"\",\"summaryformat\":1,\"format\":\"site\",\"showgrades\":1,\"newsitems\":3,\"startdate\":0,\"numsections\":0,\"maxbytes\":0,\"showreports\":0,\"visible\":1,\"groupmode\":0,\"groupmodeforce\":0,\"defaultgroupingid\":0,\"timecreated\":1384922371,\"timemodified\":1426847644,\"enablecompletion\":0,\"completionnotify\":0,\"lang\":\"\",\"forcetheme\":\"\",\"courseformatoptions\":[{\"name\":\"numsections\",\"value\":0}]},{\"id\":6,\"shortname\":\"hybris Core Developer\",\"categoryid\":3,\"categorysortorder\":60002,\"fullname\":\"hybris Core Developer\",\"idnumber\":\"\",\"summary\":\"<p dir=\\\"ltr\\\">The <strong>hybris Core Developer\\u00a0<\\/strong> training course concentrateson the hybris Core Platform.<\\/p>\\r\\n<p dir=\\\"ltr\\\">The training has a very strong leaning towards Java J2EE developers, having an 50\\/50\\u00a0 hands-on \\/ lecture format for the duration of the course. All of the core functionality of the platform is covered as shown in the list below.This course also covers\\u00a0 e-commerce and WCMS.<\\/p>\\r\\n<table style=\\\"border-color: #09090b; border-width: 2px; border-style: solid; width: 473px; height: 244px;\\\" id=\\\"TBL1385422335359\\\" class=\\\"confluenceTable\\\">\\r\\n<tbody>\\r\\n<tr>\\r\\n<td class=\\\"confluenceTd\\\">\\r\\n<p>Course Duration :<\\/p>\\r\\n<\\/td>\\r\\n<td class=\\\"confluenceTd\\\">\\r\\n<p>10 days \\/ 80 hrs<\\/p>\\r\\n<\\/td>\\r\\n<\\/tr>\\r\\n<tr>\\r\\n<td class=\\\"confluenceTd\\\">\\r\\n<p>Target Group :<\\/p>\\r\\n<\\/td>\\r\\n<td class=\\\"confluenceTd\\\">\\r\\n<p>Software Developer , Software Architect<\\/p>\\r\\n<\\/td>\\r\\n<\\/tr>\\r\\n<tr>\\r\\n<td class=\\\"confluenceTd\\\">\\r\\n<p>Knowledge Requirements :<\\/p>\\r\\n<\\/td>\\r\\n<td class=\\\"confluenceTd\\\">\\r\\n<p>Excellent knowledge in Java J2EE concepts and patterns \\/ Spring Framework<\\/p>\\r\\n<\\/td>\\r\\n<\\/tr>\\r\\n<tr>\\r\\n<td class=\\\"confluenceTd\\\">\\r\\n<p>Technical Prerequisites\\u00a0 :<\\/p>\\r\\n<\\/td>\\r\\n<td class=\\\"confluenceTd\\\">\\r\\n<p>64 Machine with minimum 8GB RAM and local admin user rights and WLAN\\/LAN connection<\\/p>\\r\\n<\\/td>\\r\\n<\\/tr>\\r\\n<tr>\\r\\n<td class=\\\"confluenceTd\\\">\\r\\n<p>Pre-installed Software:<\\/p>\\r\\n<\\/td>\\r\\n<td class=\\\"confluenceTd\\\">\\r\\n<p>Most recent Java Development Kit 6 <br class=\\\"atl-forced-newline\\\" \\/>Most recent Eclipse SDK + Web Tools Platform<\\/p>\\r\\n<\\/td>\\r\\n<\\/tr>\\r\\n<tr>\\r\\n<td class=\\\"confluenceTd\\\">\\r\\n<p>Version :<\\/p>\\r\\n<\\/td>\\r\\n<td class=\\\"confluenceTd\\\">\\r\\n<p>hybris 5.0.2<\\/p>\\r\\n<\\/td>\\r\\n<\\/tr>\\r\\n<\\/tbody>\\r\\n<\\/table>\",\"summaryformat\":1,\"format\":\"topics\",\"showgrades\":1,\"newsitems\":5,\"startdate\":1385593200,\"numsections\":11,\"maxbytes\":0,\"showreports\":0,\"visible\":1,\"hiddensections\":0,\"groupmode\":0,\"groupmodeforce\":0,\"defaultgroupingid\":0,\"timecreated\":1385552729,\"timemodified\":1404296692,\"enablecompletion\":1,\"completionnotify\":0,\"lang\":\"\",\"forcetheme\":\"\",\"courseformatoptions\":[{\"name\":\"numsections\",\"value\":11},{\"name\":\"hiddensections\",\"value\":0},{\"name\":\"coursedisplay\",\"value\":0}]}]";
        try {
            ja = new JSONArray(test);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        coursenames = new String[ja.length()];

        for(int i=0;i<ja.length();i++)
        {
            try {
                coursenames[i]=(ja.getJSONObject(i)).getString("shortname");
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        final ListAdapter theAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,coursenames);
        final ListView theListView=(ListView) findViewById(R.id.zeListView);
        theListView.setAdapter(theAdapter);
        String s="";
        inarray=ja;

        ImageButton ib = (ImageButton) findViewById(R.id.searchexec);
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                searchupdate();

            }
        });

        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String url = "https://lms.sonata-software.com/lms/course/view.php?id=";
                int cid = 0;
                try {
                    JSONObject j = inarray.getJSONObject(position);
                    cid = j.getInt("id");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                url = url + Integer.toString(cid);

                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, url, duration);
                toast.show();

                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(browserIntent);

            }
        });

    }

    void searchupdate()
    {
        EditText etsearch = (EditText) findViewById(R.id.thesearch);

    }

}
