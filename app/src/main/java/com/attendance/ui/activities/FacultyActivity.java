package com.attendance.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.attendance.R;

public class FacultyActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private ListView listView;
    private  String[] faculty;
    public static SharedPreferences facultyPreferences;
    public static String FACULTY_PRE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty);


        setupUIViews();
        initToolbar();
        setupListViews();
    }

    private void setupUIViews(){
        toolbar = (Toolbar)findViewById(R.id.ToolbarFaculty);
        listView = (ListView)findViewById(R.id.lvFaculty);
        facultyPreferences=getSharedPreferences("Faulty",MODE_PRIVATE);


    }
    private void initToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Faculty");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    private void setupListViews(){
        faculty=getResources().getStringArray(R.array.Faculty);

        FacultyAdapter facultyAdapter=new FacultyAdapter(this,R.layout.faculty_single_item,faculty);

        listView.setAdapter(facultyAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:{

                        facultyPreferences.edit().putString(FACULTY_PRE,"harishg").apply();
                        Intent intent=new Intent(FacultyActivity.this,FacultyDetails.class);
                        startActivity(intent);
                        break;
                    }
                    case 1:{
                        facultyPreferences.edit().putString(FACULTY_PRE,"praveen").apply();
                        Intent intent=new Intent(FacultyActivity.this,FacultyDetails.class);
                        startActivity(intent);
                        break;
                    }
                    case 2:{
                        facultyPreferences.edit().putString(FACULTY_PRE,"harishkumar").apply();
                        Intent intent=new Intent(FacultyActivity.this,FacultyDetails.class);
                        startActivity(intent);
                        break;
                    }
                    case 3:{

                        facultyPreferences.edit().putString(FACULTY_PRE,"vinodkumar").apply();
                        Intent intent=new Intent(FacultyActivity.this,FacultyDetails.class);
                        startActivity(intent);
                        break;
                    }
                    case 4:{
                        facultyPreferences.edit().putString(FACULTY_PRE,"madhu").apply();
                        Intent intent=new Intent(FacultyActivity.this,FacultyDetails.class);
                        startActivity(intent);
                        break;
                    }
                    case 5:{
                        facultyPreferences.edit().putString(FACULTY_PRE,"shylaja").apply();
                        Intent intent=new Intent(FacultyActivity.this,FacultyDetails.class);
                        startActivity(intent);
                        break;
                    }
                    default:break;

                }
            }
        });
    }


    public class FacultyAdapter extends ArrayAdapter {

        private int resource;
        private LayoutInflater layoutInflater;
        private String[] faculties =new String[]{};

        public FacultyAdapter(Context context, int resource, String[] objects) {
            super(context, resource, objects);
            this.resource = resource;
            this.faculties = objects;
            layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            FacultyActivity.FacultyAdapter.ViewHolder holder;
            if(convertView == null){
                holder = new FacultyActivity.FacultyAdapter.ViewHolder();
                convertView = layoutInflater.inflate(resource, null);
                holder.ivLogo = (LetterImageView)convertView.findViewById(R.id.ivLetterFaculty);
                holder.tvFaculty = (TextView)convertView.findViewById(R.id.tvFaculty);
                convertView.setTag(holder);
            }else{
                holder = (FacultyActivity.FacultyAdapter.ViewHolder)convertView.getTag();
            }

            holder.ivLogo.setOval(true);
            holder.ivLogo.setLetter(faculties[position].charAt(0));
            holder.tvFaculty.setText(faculties[position]);

            return convertView;
        }

        class ViewHolder{
            private LetterImageView ivLogo;
            private TextView tvFaculty;
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home : {
                onBackPressed();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
