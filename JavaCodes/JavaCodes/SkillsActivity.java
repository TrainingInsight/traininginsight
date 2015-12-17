package sonatasomething.thesecond;

import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class SkillsActivity extends ActionBarActivity {

    String LOGIN_URL="http://192.168.43.23/sonatalocal/skills.php";
    JSONObject json;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("My Skills");
        setContentView(R.layout.activity_skills);

        new Skillget().execute();

    }

    class Skillget extends AsyncTask<String,String,String>{

        @Override
    protected String doInBackground(String args[]) {

            json = JSONParser.getJSONFromUrl(LOGIN_URL);

            return null;
    }
        protected void onPostExecute(String args)
        {
            super.onPostExecute(args);
            /*JSONArray ja=null;
            JSONObject jx=null;
            try {
                ja = json.getJSONArray("message");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            String name[] = new String[ja.length()];
            int score[] = new int[ja.length()];
            for(int i=0;i<ja.length();i++)
            {
                try {
                    jx=ja.getJSONObject(i);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                try {
                    name[i]=jx.getString("skill");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                try {
                    score[i]=jx.getInt("value");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }*/
            String name[]={"C","C++","Java","Python","PHP"};
            int score[]={9,8,7,6,5};
            for(int i=0;i<5;i++)
            {
                TableLayout tl = (TableLayout) findViewById(R.id.thetable);
                TableRow tr = new TableRow(SkillsActivity.this);
                tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT));
                tr.setGravity(Gravity.CENTER);
                tr.setWeightSum(1f);

                if(i%2==0)
                {
                    tr.setBackgroundColor(Color.LTGRAY);
                }

                TableRow.LayoutParams lp1,lp2;
                lp1 = new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.7f);
                lp2 = new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 0.3f);
                TextView t1 = new TextView(SkillsActivity.this);
                TextView t2 = new TextView(SkillsActivity.this);
                t1.setText(name[i]);
                t1.setTextSize(25);
                t1.setLayoutParams(lp1);
                t2.setText(Integer.toString(score[i]));
                t2.setLayoutParams(lp2);
                t2.setTextSize(25);
                tr.addView(t1);
                tr.addView(t2);
                tl.addView(tr, new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.MATCH_PARENT));
            }
        }
}

}