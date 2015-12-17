package sonatasomething.thesecond;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class CalendarActivity extends ActionBarActivity {

    String trainings1[];
    String trainings2[];
    String trainings3[];
    ListView theListView;
    String tag=null;
    JSONArray ja=null;
    Button button1,button2,button3;

    String LOGIN_URL="http://192.168.43.23/sonatalocal/calendar.php";
    int t,c=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Training Calendar");
        setContentView(R.layout.activity_calendar);
        theListView=(ListView) findViewById(R.id.theListView);
        new AttemptLogin().execute();
    }

    class AttemptLogin extends AsyncTask<String, String, JSONObject> {



        @Override
        protected void onPreExecute() {
            super.onPreExecute();



        }

        @Override
        protected JSONObject doInBackground(String args[]) {
            // TODO Auto-generated method stub

            JSONObject event1 = new JSONObject();
            try {
                event1.put("name", "Basics of OOP");
                event1.put("startdate", "25/07/2015");
                event1.put("enddate", "01/08/2015");
                event1.put("starttime", "15:00");
                event1.put("endtime", "18:00");
                event1.put("host", "Someone");
                event1.put("location", "Somewhere");
                event1.put("description", "OOP and OOPS");
                event1.put("prereq", "C Syntax");

            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            JSONObject event2 = new JSONObject();
            try {
                event2.put("name", "C");
                event2.put("startdate", "01/06/2015");
                event2.put("enddate", "03/06/2015");
                event2.put("starttime", "23:00");
                event2.put("endtime", "23:30");
                event2.put("host", "Somebody");
                event2.put("location", "Somewhere");
                event2.put("description", "Some Stuff");
                event2.put("prereq", "None");

            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            JSONObject event3 = new JSONObject();
            try {
                event3.put("name", "C#");
                event3.put("startdate", "12/06/2015");
                event3.put("enddate", "17/06/2015");
                event3.put("starttime", "09:00");
                event3.put("endtime", "12:00");
                event3.put("host", "Samhitha");
                event3.put("location", "HO");
                event3.put("description", "She gonna teach you stuff");
                event3.put("prereq", "Tolerable to a loud voice");

            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            JSONObject event4 = new JSONObject();
            try {
                event4.put("name", "C++");
                event4.put("startdate", "11/06/2015");
                event4.put("enddate", "13/06/2015");
                event4.put("starttime", "09:00");
                event4.put("endtime", "15:00");
                event4.put("host", "Rohit");
                event4.put("location", "5th Floor HO");
                event4.put("description", "Rohit's gonna teach");
                event4.put("prereq", "Common Sense");

            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            JSONObject event5 = new JSONObject();
            try {
                event5.put("name", "DjkDSango");
                event5.put("startdate", "30/06/2015");
                event5.put("enddate", "03/07/2015");
                event5.put("starttime", "10:00");
                event5.put("endtime", "13:00");
                event5.put("host", "Madhuri");
                event5.put("location", "HO");
                event5.put("description", "Django programming interrupted by occasional movies");
                event5.put("prereq", "Python syntax and love for movies");

            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            JSONObject event6 = new JSONObject();
            try {
                event6.put("name", "Java");
                event6.put("startdate", "05/06/2015");
                event6.put("enddate", "07/06/2015");
                event6.put("starttime", "01:00");
                event6.put("endtime", "05:00");
                event6.put("host", "Somebody else");
                event6.put("location", "Somewhere else");
                event6.put("description", "Some other stuff");
                event6.put("prereq", "None");

            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();

            }

            JSONObject event7 = new JSONObject();
            try {
                event7.put("name", "JavascKdSript");
                event7.put("startdate", "25/06/2015");
                event7.put("enddate", "27/06/2015");
                event7.put("starttime", "13:00");
                event7.put("endtime", "16:00");
                event7.put("host", "Ganesh B M");
                event7.put("location", "HO 4th Floor");
                event7.put("description", "Javascript Stuff ya know");
                event7.put("prereq", "None");

            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();

            }

            JSONObject event8 = new JSONObject();
            try {
                event8.put("name", "Php");
                event8.put("startdate", "02/07/2015");
                event8.put("enddate", "05/07/2015");
                event8.put("starttime", "03:00");
                event8.put("endtime", "11:00");
                event8.put("host", "Ganesh");
                event8.put("location", "Sonata HO");
                event8.put("description", "Training\\");
                event8.put("prereq", "None");

            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();

            }

            JSONObject event9 = new JSONObject();
            try {
                event9.put("name", "Python");
                event9.put("startdate", "09/07/2015");
                event9.put("enddate", "11/07/2015");
                event9.put("starttime", "05:00");
                event9.put("endtime", "07:00");
                event9.put("host", "Rohit");
                event9.put("location", "Sonata HO");
                event9.put("description", "Assisted by Samhitha and Madhuri");
                event9.put("prereq", "Be their friend");

            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();

            }

            JSONObject event10 = new JSONObject();
            try {
                event10.put("name", "Rubykds");
                event10.put("startdate", "06/07/2015");
                event10.put("enddate", "06/07/2015");
                event10.put("starttime", "13:50");
                event10.put("endtime", "16:00");
                event10.put("host", "Sonata");
                event10.put("location", "HO");
                event10.put("description", "Ruby stuff");
                event10.put("prereq", "Common Sense");

            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();

            }

            JSONArray jsonArray = new JSONArray();

            jsonArray.put(event1);
            jsonArray.put(event2);
            jsonArray.put(event3);
            jsonArray.put(event4);
            jsonArray.put(event5);
            jsonArray.put(event6);
            jsonArray.put(event7);
            jsonArray.put(event8);
            jsonArray.put(event9);
            jsonArray.put(event10);

            ja=jsonArray;

            JSONObject jsonobj = JSONParser.getJSONFromUrl(LOGIN_URL);

            try {
                ja = jsonobj.getJSONArray("message");
            } catch (JSONException e) {
                e.printStackTrace();
            }

            JSONObject j = null;
            int x,y,z;
            x=y=z=0;

            for(int i=0;i<ja.length();i++)
            {
                try {
                    j=ja.getJSONObject(i);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                try {
                    if( Pattern.compile(Pattern.quote("kds"), Pattern.CASE_INSENSITIVE).matcher(j.getString("name")).find())
                    {
                        x++;
                    }
                    else if(j.getString("startdate").substring(3, 5).equalsIgnoreCase("06"))
                    {
                        y++;
                    }
                    else
                    {
                        z++;
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
            trainings1= new String[y];
            trainings2= new String[z];
            trainings3= new String[x];

            x=y=z=0;

            for(int i=0;i<ja.length();i++)
            {
                try {
                    j=ja.getJSONObject(i);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                try {
                    if( Pattern.compile(Pattern.quote("kds"), Pattern.CASE_INSENSITIVE).matcher(j.getString("name")).find())
                    {
                        trainings3[x++]=j.getString("name");
                    }
                    else if(j.getString("startdate").substring(3, 5).equalsIgnoreCase("06"))
                    {
                        trainings1[y++]=j.getString("name");
                    }
                    else
                    {
                        trainings2[z++]=j.getString("name");
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            return null;

        }
        protected void onPostExecute(JSONObject jsonobj) {




            button1 = (Button) findViewById(R.id.thismonth);
            button2 = (Button) findViewById(R.id.nextmonth);
            button3 = (Button) findViewById(R.id.kds);



            button1.setOnClickListener(new View.OnClickListener() {

                public void onClick(View view) {


                    button1.setBackgroundColor(Color.LTGRAY);
                    button2.setBackgroundColor(Color.WHITE);
                    button3.setBackgroundColor(Color.WHITE);
                    first();
                    t=1;

                    if(c==0)
                    {
                        setonselect();
                        c=1;
                    }

                }

            });
            button2.setOnClickListener(new View.OnClickListener() {

                public void onClick(View view) {


                    button1.setBackgroundColor(Color.WHITE);
                    button2.setBackgroundColor(Color.LTGRAY);
                    button3.setBackgroundColor(Color.WHITE);
                    second();
                    t=2;

                    if(c==0)
                    {
                        setonselect();
                        c=1;
                    }

                }
            });
            button3.setOnClickListener(new View.OnClickListener() {

                public void onClick(View view) {

                    button1.setBackgroundColor(Color.WHITE);
                    button2.setBackgroundColor(Color.WHITE);
                    button3.setBackgroundColor(Color.LTGRAY);

                    third();
                    t=3;

                    if (c == 0) {
                        setonselect();
                        c = 1;
                    }

                }

            });


        }


    }

    void first()
    {
        final ListAdapter theAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,trainings1);
        theListView.setAdapter(theAdapter);
    }

    void second()
    {
        final ListAdapter theAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,trainings2);
        theListView.setAdapter(theAdapter);
    }

    void third()
    {
        final ListAdapter theAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,trainings3);
        theListView.setAdapter(theAdapter);
    }

    void setonselect()
    {


        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                switch(t)
                {
                    case 1: tag=trainings1[position]; break;
                    case 2: tag=trainings2[position]; break;
                    case 3: tag=trainings3[position]; break;
                }

                JSONObject jx=null;
                int f=0;
                for(int i=0;i<ja.length()&&f==0;i++)
                {
                    try {
                        jx=ja.getJSONObject(i);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    try {
                        if(tag.equals(jx.getString("name")))
                        {
                            f=1;
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                Intent I = new Intent(CalendarActivity.this, CalDisplayActivity.class);
                I.putExtra("stuff",jx.toString());
                startActivity(I);

            }
        });
    }
}

