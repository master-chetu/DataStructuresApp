package com.Felixpat.chetu.DataStructures;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Quiz extends AppCompatActivity {
    TextView question;
    RadioGroup group;
    RadioButton one,two,three, four;
    Button next,prev;
    SQLiteDatabase sqLiteDatabase;
    List<Question> quesList;
    SQLiteStatement sqLiteStatement;
    Question current;
    SharedPreferences sharedPreferences,flow;
    int index;
    int id;
    int multipier;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Intent in = getIntent();
        multipier = in.getIntExtra("number",0);
        sharedPreferences = this.getSharedPreferences("counter", Context.MODE_PRIVATE);
        sharedPreferences.edit().putInt("status", 0);
        flow = this.getSharedPreferences("com.Felixpat.chetu.DataStructures",Context.MODE_PRIVATE);
        flow.edit().putInt("flow",0);
        int status = sharedPreferences.getInt("status", 0);
        sqLiteDatabase = this.openOrCreateDatabase("quiz",MODE_PRIVATE,null);
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS questions(id INTEGER PRIMARY KEY AUTOINCREMENT" +
                ",question TEXT,one TEXT,two TEXT,three TEXT,four TEXT,answer INTEGER,given INTEGER)");

        if(status == 0) {
            insertfunction1();
            insertfunction2();
            insertfunction3();
            insertfunction4();
            insertfunction5();
        }

        id = multipier*6;



        quesList = getAllQuestions();
        current = quesList.get(id);
        question = (TextView) findViewById(R.id.question);
        group = (RadioGroup) findViewById(R.id.radiogroup);
        one = (RadioButton) findViewById(R.id.one);
        two = (RadioButton) findViewById(R.id.two);
        three = (RadioButton) findViewById(R.id.three);
        four = (RadioButton) findViewById(R.id.four);
        prev = (Button) findViewById(R.id.previous);
        next = (Button) findViewById(R.id.next);


        setQuestion();

        // Toast.makeText(this, "size of List"+Integer.toString(quesList.size()), Toast.LENGTH_SHORT).show();

        prev.setEnabled(false);



        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prev.setEnabled(true);
                int index = group.getCheckedRadioButtonId();
                View temp = findViewById(index);
                group.clearCheck();
                index = group.indexOfChild(temp);
                index++;

                current.setGiven(index);


                //Toast.makeText(MainActivity.this, Integer.toString(quesList.get(id).getGiven()), Toast.LENGTH_SHORT).show();

                id++;
                group.clearCheck();
                current = quesList.get(id);
                if(id==(multipier*6)+5){
                    next.setEnabled(false);
                    prev.setEnabled(true);
                }
                setQuestion();

            }
        });
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next.setEnabled(true);
                int index = group.getCheckedRadioButtonId();
                View temp = findViewById(index);
                group.clearCheck();
                index = group.indexOfChild(temp);
                index++;
                current.setGiven(index);

                id--;
                group.clearCheck();
                current = quesList.get(id);
                if(id==(multipier*6)){
                    next.setEnabled(true);
                    prev.setEnabled(false);
                }
                setQuestion();
            }
        });

    }
    private void insertfunction1() {
        SQLiteStatement insert = sqLiteDatabase.compileStatement("INSERT INTO questions (question, one, two, three,four, answer,given) VALUES (?,?,?,?,?,?,?)");
        int count = 1;
        for (String category : getResources().getStringArray(R.array.one))
        {

            insert.bindString(count,category);

            count++;
        }
        insert.executeInsert();
        insert = sqLiteDatabase.compileStatement("INSERT INTO questions (question, one, two, three,four, answer,given) VALUES (?,?,?,?,?,?,?)");
        count = 1;
        for (String category : getResources().getStringArray(R.array.two))
        {

            insert.bindString(count,category);

            count++;
        }
        insert.executeInsert();
        insert = sqLiteDatabase.compileStatement("INSERT INTO questions (question, one, two, three,four, answer,given) VALUES (?,?,?,?,?,?,?)");
        count = 1;
        for (String category : getResources().getStringArray(R.array.three))
        {

            insert.bindString(count,category);

            count++;
        }
        insert.executeInsert();
        insert = sqLiteDatabase.compileStatement("INSERT INTO questions (question, one, two, three,four, answer,given) VALUES (?,?,?,?,?,?,?)");
        count = 1;
        for (String category : getResources().getStringArray(R.array.four))
        {

            insert.bindString(count,category);

            count++;
        }
        insert.executeInsert();
        insert = sqLiteDatabase.compileStatement("INSERT INTO questions (question, one, two, three,four, answer,given) VALUES (?,?,?,?,?,?,?)");
        count = 1;
        for (String category : getResources().getStringArray(R.array.five))
        {

            insert.bindString(count,category);

            count++;
        }
        insert.executeInsert();
        insert = sqLiteDatabase.compileStatement("INSERT INTO questions (question, one, two, three,four, answer,given) VALUES (?,?,?,?,?,?,?)");
        count = 1;
        for (String category : getResources().getStringArray(R.array.six))
        {

            insert.bindString(count,category);

            count++;
        }
        insert.executeInsert();



    }


    private void insertfunction5() {
        SQLiteStatement insert = sqLiteDatabase.compileStatement("INSERT INTO questions (question, one, two, three,four, answer,given) VALUES (?,?,?,?,?,?,?)");
        int count = 1;
        for (String category : getResources().getStringArray(R.array.one5))
        {

            insert.bindString(count,category);

            count++;
        }
        insert.executeInsert();
        insert = sqLiteDatabase.compileStatement("INSERT INTO questions (question, one, two, three,four, answer,given) VALUES (?,?,?,?,?,?,?)");
        count = 1;
        for (String category : getResources().getStringArray(R.array.two5))
        {

            insert.bindString(count,category);

            count++;
        }
        insert.executeInsert();
        insert = sqLiteDatabase.compileStatement("INSERT INTO questions (question, one, two, three,four, answer,given) VALUES (?,?,?,?,?,?,?)");
        count = 1;
        for (String category : getResources().getStringArray(R.array.three5))
        {

            insert.bindString(count,category);

            count++;
        }
        insert.executeInsert();
        insert = sqLiteDatabase.compileStatement("INSERT INTO questions (question, one, two, three,four, answer,given) VALUES (?,?,?,?,?,?,?)");
        count = 1;
        for (String category : getResources().getStringArray(R.array.four5))
        {

            insert.bindString(count,category);

            count++;
        }
        insert.executeInsert();
        insert = sqLiteDatabase.compileStatement("INSERT INTO questions (question, one, two, three,four, answer,given) VALUES (?,?,?,?,?,?,?)");
        count = 1;
        for (String category : getResources().getStringArray(R.array.five5))
        {

            insert.bindString(count,category);

            count++;
        }
        insert.executeInsert();
        insert = sqLiteDatabase.compileStatement("INSERT INTO questions (question, one, two, three,four, answer,given) VALUES (?,?,?,?,?,?,?)");
        count = 1;
        for (String category : getResources().getStringArray(R.array.six5))
        {

            insert.bindString(count,category);

            count++;
        }
        insert.executeInsert();


    }
    private void insertfunction4() {
        SQLiteStatement insert = sqLiteDatabase.compileStatement("INSERT INTO questions (question, one, two, three,four, answer,given) VALUES (?,?,?,?,?,?,?)");
        int count = 1;
        for (String category : getResources().getStringArray(R.array.one4))
        {

            insert.bindString(count,category);

            count++;
        }
        insert.executeInsert();
        insert = sqLiteDatabase.compileStatement("INSERT INTO questions (question, one, two, three,four, answer,given) VALUES (?,?,?,?,?,?,?)");
        count = 1;
        for (String category : getResources().getStringArray(R.array.two4))
        {

            insert.bindString(count,category);

            count++;
        }
        insert.executeInsert();
        insert = sqLiteDatabase.compileStatement("INSERT INTO questions (question, one, two, three,four, answer,given) VALUES (?,?,?,?,?,?,?)");
        count = 1;
        for (String category : getResources().getStringArray(R.array.three4))
        {

            insert.bindString(count,category);

            count++;
        }
        insert.executeInsert();
        insert = sqLiteDatabase.compileStatement("INSERT INTO questions (question, one, two, three,four, answer,given) VALUES (?,?,?,?,?,?,?)");
        count = 1;
        for (String category : getResources().getStringArray(R.array.four4))
        {

            insert.bindString(count,category);

            count++;
        }
        insert.executeInsert();
        insert = sqLiteDatabase.compileStatement("INSERT INTO questions (question, one, two, three,four, answer,given) VALUES (?,?,?,?,?,?,?)");
        count = 1;
        for (String category : getResources().getStringArray(R.array.five4))
        {

            insert.bindString(count,category);

            count++;
        }
        insert.executeInsert();
        insert = sqLiteDatabase.compileStatement("INSERT INTO questions (question, one, two, three,four, answer,given) VALUES (?,?,?,?,?,?,?)");
        count = 1;
        for (String category : getResources().getStringArray(R.array.six4))
        {

            insert.bindString(count,category);

            count++;
        }
        insert.executeInsert();


    }

    private void insertfunction3() {
        SQLiteStatement insert = sqLiteDatabase.compileStatement("INSERT INTO questions (question, one, two, three,four, answer,given) VALUES (?,?,?,?,?,?,?)");
        int count = 1;
        for (String category : getResources().getStringArray(R.array.one3))
        {

            insert.bindString(count,category);

            count++;
        }
        insert.executeInsert();
        insert = sqLiteDatabase.compileStatement("INSERT INTO questions (question, one, two, three,four, answer,given) VALUES (?,?,?,?,?,?,?)");
        count = 1;
        for (String category : getResources().getStringArray(R.array.two3))
        {

            insert.bindString(count,category);

            count++;
        }
        insert.executeInsert();
        insert = sqLiteDatabase.compileStatement("INSERT INTO questions (question, one, two, three,four, answer,given) VALUES (?,?,?,?,?,?,?)");
        count = 1;
        for (String category : getResources().getStringArray(R.array.three3))
        {

            insert.bindString(count,category);

            count++;
        }
        insert.executeInsert();
        insert = sqLiteDatabase.compileStatement("INSERT INTO questions (question, one, two, three,four, answer,given) VALUES (?,?,?,?,?,?,?)");
        count = 1;
        for (String category : getResources().getStringArray(R.array.four3))
        {

            insert.bindString(count,category);

            count++;
        }
        insert.executeInsert();
        insert = sqLiteDatabase.compileStatement("INSERT INTO questions (question, one, two, three,four, answer,given) VALUES (?,?,?,?,?,?,?)");
        count = 1;
        for (String category : getResources().getStringArray(R.array.five3))
        {

            insert.bindString(count,category);

            count++;
        }
        insert.executeInsert();
        insert = sqLiteDatabase.compileStatement("INSERT INTO questions (question, one, two, three,four, answer,given) VALUES (?,?,?,?,?,?,?)");
        count = 1;
        for (String category : getResources().getStringArray(R.array.six3))
        {

            insert.bindString(count,category);

            count++;
        }
        insert.executeInsert();


    }

    private void insertfunction2() {
        SQLiteStatement insert = sqLiteDatabase.compileStatement("INSERT INTO questions (question, one, two, three,four, answer,given) VALUES (?,?,?,?,?,?,?)");
        int count = 1;
        for (String category : getResources().getStringArray(R.array.one2))
        {

            insert.bindString(count,category);

            count++;
        }
        insert.executeInsert();
        insert = sqLiteDatabase.compileStatement("INSERT INTO questions (question, one, two, three,four, answer,given) VALUES (?,?,?,?,?,?,?)");
        count = 1;
        for (String category : getResources().getStringArray(R.array.two2))
        {

            insert.bindString(count,category);

            count++;
        }
        insert.executeInsert();
        insert = sqLiteDatabase.compileStatement("INSERT INTO questions (question, one, two, three,four, answer,given) VALUES (?,?,?,?,?,?,?)");
        count = 1;
        for (String category : getResources().getStringArray(R.array.three2))
        {

            insert.bindString(count,category);

            count++;
        }
        insert.executeInsert();
        insert = sqLiteDatabase.compileStatement("INSERT INTO questions (question, one, two, three,four, answer,given) VALUES (?,?,?,?,?,?,?)");
        count = 1;
        for (String category : getResources().getStringArray(R.array.four2))
        {

            insert.bindString(count,category);

            count++;
        }
        insert.executeInsert();
        insert = sqLiteDatabase.compileStatement("INSERT INTO questions (question, one, two, three,four, answer,given) VALUES (?,?,?,?,?,?,?)");
        count = 1;
        for (String category : getResources().getStringArray(R.array.five2))
        {

            insert.bindString(count,category);

            count++;
        }
        insert.executeInsert();
        insert = sqLiteDatabase.compileStatement("INSERT INTO questions (question, one, two, three,four, answer,given) VALUES (?,?,?,?,?,?,?)");
        count = 1;
        for (String category : getResources().getStringArray(R.array.six2))
        {

            insert.bindString(count,category);

            count++;
        }
        insert.executeInsert();


    }



    private void setQuestion() {
        question.setText(current.getQuestion());
        one.setText(current.getOne());
        two.setText(current.getTwo());
        three.setText(current.getThree());
        four.setText(current.getFour());


        if(current.getGiven()!=0){
            int op = current.getGiven();
            op--;
            ((RadioButton)group.getChildAt(op)).setChecked(true);
        }



    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menufile,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id1 = item.getItemId();

        if(id1 == R.id.save){

            int index = group.getCheckedRadioButtonId();
            View temp = findViewById(index);

            index = group.indexOfChild(temp);
            index++;
            quesList.get(id).setGiven(index);



            for(int i=(multipier*6);i<(multipier*6)+6;i++){

                int given = quesList.get(i).getGiven();
                int no = quesList.get(i).getId();

                sqLiteDatabase.execSQL("UPDATE questions SET given="+given+" WHERE id="+no);



            }
            quesList.clear();
            quesList = getAllQuestions();

            Toast.makeText(this, "Saved!", Toast.LENGTH_SHORT).show();
        }
        else if(id1 == R.id.submit) {



            final int[] incorrect = new int[6];
            AlertDialog.Builder dailog = new AlertDialog.Builder(this);
            dailog.setTitle("Save")
                    .setMessage("Saved before Submit?")
                    .setPositiveButton("Saved", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i1) {
                            int correct = 0;
                            int j = 0;
                            for (int i = (multipier * 6); i < (multipier * 6) + 6; i++) {

                                int answer = quesList.get(i).getAnswer();
                                answer++;
                                int given = quesList.get(i).getGiven();
                                if (answer == given)
                                    correct++;
                                else {
                                    incorrect[j] = (i - (multipier * 6))+1;
                                    j++;
                                }


                            }



                            if (correct == 6) {


                                switch (multipier) {
                                    case 0:
                                        flow.edit().putInt("flow", 1).apply();
                                        break;
                                    case 1:
                                        flow.edit().putInt("flow", 2).apply();

                                        break;
                                    case 2:
                                        flow.edit().putInt("flow", 3).apply();

                                        break;
                                    case 3:
                                        flow.edit().putInt("flow", 4).apply();

                                        break;
                                    case 4:
                                        flow.edit().putInt("flow", 5).apply();

                                        break;
                                }
                                if (multipier < 4)

                                    Toast.makeText(Quiz.this, "\t\t\t\tSuccussfull!\nNext Chapter is unlocked!!", Toast.LENGTH_SHORT).show();
                                else
                                    Toast.makeText(Quiz.this, "Course Completed!!", Toast.LENGTH_SHORT).show();

                            } else {

                                String ic = "";
                                for (int i = 0; i < incorrect.length; i++) {
                                    if (incorrect[i] != 0)
                                        ic = ic + "\n" + Integer.toString(incorrect[i]);
                                }
                                AlertDialog.Builder builder = new AlertDialog.Builder(Quiz.this);
                                builder.setTitle("Incorrect Question numbers")
                                        .setMessage(ic)
                                        .setPositiveButton("Check it out", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {

                                            }
                                        });
                                AlertDialog alert1 = builder.create();
                                alert1.show();
                            }


                        }
                    })
                    .setNegativeButton("Not Saved", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i2) {

                        }
                    });

            AlertDialog alert = dailog.create();
            alert.show();





        }

        return true;
    }
    public List<Question> getAllQuestions() {
        List<Question> quesList = new ArrayList<Question>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + "questions";
        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setId(cursor.getInt(0));
                quest.setQuestion(cursor.getString(1));
                quest.setOne(cursor.getString(2));
                quest.setTwo(cursor.getString(3));
                quest.setThree(cursor.getString(4));
                quest.setFour(cursor.getString(5));
                quest.setAnswer(cursor.getInt(6));
                quest.setGiven(cursor.getInt(7));
                quesList.add(quest);
            } while (cursor.moveToNext());

        }
        // return quest list
        return quesList;
    }

   /* public void dialog(){
        String ic = "";
        for(int i=0;i<incorrect.length;i++){
            ic = ic+"\n"+Integer.toString(incorrect[i]);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Incorrect")
                .setMessage(ic);
        AlertDialog alert1 = builder.create();
        alert1.show();
    }
    */

}
