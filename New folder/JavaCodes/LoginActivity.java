package sonatasomething.thesecond;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.annotation.MainThread;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class LoginActivity extends ActionBarActivity {

    String LOGIN_URL="http://192.168.43.23/sonatalocal/login.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Niit University Login");
        waiting();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.action_exit:

                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private void waiting() {
        SharedPreferences preferences = getSharedPreferences("SonataUserData", Context.MODE_PRIVATE);
        String empno = preferences.getString("username", null);
        String pass = preferences.getString("password", null);
        if(empno!=null&&pass!=null)
        {
            new AttemptLogin().execute();
        }


            Button button = (Button) findViewById(R.id.butlog);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {

                    new AttemptLogin().execute();

                }
            });

        /*Button button = (Button) findViewById(R.id.butlog);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                gotomain();

            }
        });*/

         }

private void gotomain()
{
    Intent I = new Intent(this,MainActivity.class);
    startActivity(I);
    finish();
}




    class AttemptLogin extends AsyncTask<String, String, String> {



        @Override
        protected void onPreExecute() {
            super.onPreExecute();



        }

        @Override
        protected String doInBackground(String args[]) {
            // TODO Auto-generated method stub
            // Check for success tag
            int success=-1;
            JSONObject j1 = new JSONObject();
            String empno,pass;
            SharedPreferences preferences = getApplicationContext().getSharedPreferences("SonataUserData", Context.MODE_PRIVATE);
            SharedPreferences.Editor edit = preferences.edit();
            empno=preferences.getString("username",null);
            pass=preferences.getString("password",null);
            edit.commit();
            if(empno==null&&pass==null) {
                EditText empno1 = (EditText) findViewById(R.id.etempno);
                empno = empno1.getText().toString();
                EditText pass1 = (EditText) findViewById(R.id.etpass);
                pass = pass1.getText().toString();
             }
            edit.putString("username", null);
            edit.putString("password", null);
            edit.commit();
                        try {
                // Building Parameters
                List<NameValuePair> params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("username", empno));
                params.add(new BasicNameValuePair("password", pass));


                // getting product details by making HTTP request
                /*j1 = JSONParser.makeHttpRequest(
                       LOGIN_URL, "POST", params);*/

                            //hardcoded
                if(empno.equals(pass)&&empno!=null&&pass!=null) {
                    j1.put("success", "1").put("message", "woot");
                }
                else {
                    j1.put("success", "0").put("message", "boo");
                }


                success=j1.getInt("success");
            }
            catch (JSONException e) {
                e.printStackTrace();
            }
            if (success==1) {
                edit.putString("username", empno);
                edit.putString("password", pass);
                edit.commit();
                gotomain();
            }
            else
            {

                runOnUiThread(new Runnable() {
                public void run() {

                    Toast.makeText(LoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                }
            });
            }

            try {
                return j1.getString("message");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }
        protected void onPostExecute(String result) {

            super.onPostExecute(result);

        }


    }

}



