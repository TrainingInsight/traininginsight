/*
package sonatasomething.thesecond;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

*
 * Created by samhitha.l on 6/12/15.


public class Skills extends Activity {
    private ProgressDialog dialog;
    //private static final String TAG_USER = "user";
    private static final String TAG_course = "course";
    private static final String TAG_score = "score";
    JSONArray user = null;
    protected void OnCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skills);
    }
    void Skillget();

    public Skillget extends AsyncTask<String,Void,String>{
        protected void onPreExecute(){
            dialog = new ProgressDialog(Skills.this);
            dialog.setMessage("Async starts");
            dialog.show();
            //get the url
        }
        protected Void doInBackground(String... params) {
        dialog.dismiss();
        try {
              JSONObject j = user.getJSONObject(0);

            // Storing  JSON item in a Variable
            String course = j.getString(TAG_course);
            String score = j.getString(TAG_score);
          } catch (JSONException e) {
             e.printStackTrace();
          }
        }
        protected void onPostExecute() {
            dialog.setMessage("Async ends");
        }
    }
}
*/
