package com.example.readingjsonapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
public class MainActivity extends AppCompatActivity
    {@Override
    protected void onCreate(Bundle savedInstanceState)
    {   super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String json_stu="{ \"Students\" :[" + "{\"name\":\" Raja \",\"Branch\":\"Computer Science\"}" +
                ",{\"name\":\"Jai \",\"Branch\":\"Civil\"}" + ",{\"name\":\" Rahul \",\"Branch\":\"Information Technology\"}" +
                ",{\"name\":\" Sweety \",\"Branch\":\"Mechanical\"}" + ",{\"name\":\" Sai \",\"Branch\":\"Textile\"}" +
                ",{\"name\":\" Phani \",\"Branch\":\"Electrical\"}" + ",{\"name\":\" Ravi \",\"Branch\":\"Mechanical\"}] }";
    try {
            ArrayList<HashMap<String, String>> userList = new ArrayList<>();
            ListView listview = findViewById(R.id.students);
            JSONObject jsObj = new JSONObject(json_stu);
            JSONArray jsArray = jsObj.getJSONArray("Students");
            for (int i = 0; i < jsArray.length(); i++)
            {   HashMap<String, String> stu = new HashMap<>();
                JSONObject obj = jsArray.getJSONObject(i);
                stu.put("name", obj.getString("name"));
                stu.put("Branch", obj.getString("Branch"));
                userList.add(stu);
            }
            SimpleAdapter simpleAdapter =
                    new SimpleAdapter(MainActivity.this, userList, R.layout.list, new String[]{"name", "Branch", "institute"},
                                        new int[]{R.id.StudentName, R.id.Branch});
            listview.setAdapter(simpleAdapter);
        }     catch(Exception ex){Log.e("JSON FILE READ", "onCreate: "+ ex.getMessage()); }
    } }
