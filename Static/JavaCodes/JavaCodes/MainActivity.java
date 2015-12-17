package sonatasomething.thesecond;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        setTitle("Welcome");
            waiting();

    }

    private void waiting()
    {

        ImageButton button1 = (ImageButton) findViewById(R.id.imageButton1);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                todashboard();
            }
        });

        ImageButton button2 = (ImageButton) findViewById(R.id.imageButton2);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                totraining();
            }
        });

        ImageButton button3 = (ImageButton) findViewById(R.id.imageButton3);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                tocertifications();
            }
        });

        ImageButton button4 = (ImageButton) findViewById(R.id.imageButton4);
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                toskills();
            }
        });

        ImageButton button5 = (ImageButton) findViewById(R.id.imageButton5);
        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                tocalendar();
            }
        });

        ImageButton button6 = (ImageButton) findViewById(R.id.imageButton6);
        button6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                tocourses();
            }
        });

        ImageButton button7 = (ImageButton) findViewById(R.id.imageButton7);
        button7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                totestmyskills();
            }
        });

        ImageButton button8 = (ImageButton) findViewById(R.id.imageButton8);
        button8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                tofaqs();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

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
            case R.id.action_sign_out:
                tologin();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

   @Override
   protected void onResume() {
        super.onResume();

       waiting();

        SharedPreferences sharedPref = this.getSharedPreferences("SonataUserData",Context.MODE_PRIVATE);
        String empno=sharedPref.getString("usename", null);
        String pass=sharedPref.getString("password",null);
        if(empno==(null)&&pass==(null)) {
            tologin();
        }

    }

    private void totraining()
    {
        Intent I = new Intent(this,TrainingActivity.class);
        startActivity(I);
    }

    private void todashboard()
    {
        Intent I = new Intent(this,DashboardActivity.class);
        startActivity(I);
    }

    private void tocertifications()
    {
        Intent I = new Intent(this,CertificationActivity.class);
        startActivity(I);
    }

    private void toskills()
    {
        Intent I = new Intent(this,SkillsActivity.class);
        startActivity(I);
    }

    private void tocalendar()
    {
        Intent I = new Intent(this,CalendarActivity.class);
        startActivity(I);
    }

    private void tocourses()
    {
        Intent I = new Intent(this,CoursesActivity.class);
        startActivity(I);
    }

    private void totestmyskills()
    {
        Intent I = new Intent(this,TestSkillsActivity.class);
        startActivity(I);
    }

    private void tofaqs()
    {
        Intent I = new Intent(this,FaqsActivity.class);
        startActivity(I);
    }

    private void tologin()
    {
        Context context = getApplicationContext();
        CharSequence text = "Potato";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();

        SharedPreferences preferences = getSharedPreferences("SonataUserData", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = preferences.edit();
        edit.putString("username", null);
        edit.putString("password", null);
        edit.commit();
        Intent I = new Intent(this,LoginActivity.class);
        startActivity(I);
        finish();
    }



}
