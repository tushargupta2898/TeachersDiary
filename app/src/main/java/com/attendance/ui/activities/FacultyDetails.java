package com.attendance.ui.activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.attendance.R;

public class FacultyDetails extends AppCompatActivity {


    private Toolbar toolbar;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_details);


        setupUIViews();
        initToolbar();
        setupListView();
    }

    private void setupUIViews(){
        toolbar = (Toolbar)findViewById(R.id.ToolbarFacultytDetails);
        listView = (ListView)findViewById(R.id.lvFacultyDetails);

    }
    private void initToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("faculty");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }



    private void setupListView() {
        String faculty_selected = FacultyActivity.facultyPreferences.getString(FacultyActivity.FACULTY_PRE, null);
        String[] faculty = new String[]{};


        String[] fnames = getResources().getStringArray(R.array.fnames);


        if (faculty_selected.equalsIgnoreCase("harishg")) {
            faculty = getResources().getStringArray(R.array.harishg);
        }
        else if (faculty_selected.equalsIgnoreCase("praveen")) {
            faculty = getResources().getStringArray(R.array.praveen);
        }
        else if (faculty_selected.equalsIgnoreCase("harishkumar")) {
            faculty = getResources().getStringArray(R.array.harishkumar);
        }
        else if (faculty_selected.equalsIgnoreCase("vinodkumar")) {
            faculty = getResources().getStringArray(R.array.vinodkumar);
        }
        else if (faculty_selected.equalsIgnoreCase("madhu")) {
            faculty = getResources().getStringArray(R.array.madhu);
        }

        else {
            faculty = getResources().getStringArray(R.array.shylaja);
        }


        FacultyDetailsAdapter facultyDetailsAdapte=new FacultyDetailsAdapter(this,fnames,faculty);
        listView.setAdapter(facultyDetailsAdapte);
    }

    public  class FacultyDetailsAdapter extends BaseAdapter {

        private Context mContext;
        private LayoutInflater layoutInflater;
        private TextView title, faculty;
        private String[] titleArray;
        private String[] facultyArray;


        public FacultyDetailsAdapter(Context context, String[] title, String[] faculty){
            mContext = context;
            titleArray = title;
            facultyArray = faculty;
            layoutInflater = LayoutInflater.from(context);
        }


        @Override
        public int getCount() {
            return titleArray.length;
        }

        @Override
        public Object getItem(int position) {
            return titleArray[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                convertView = layoutInflater.inflate(R.layout.faculty_details_single_item, null);
            }

            title = (TextView)convertView.findViewById(R.id.tvFacultydetailsTitle);
            faculty= (TextView)convertView.findViewById(R.id.tvFacultydetails);


            title.setText(titleArray[position]);
            try{
                faculty.setText(facultyArray[position]);
            }catch (Exception exception){

                Log.e("error", String.valueOf(faculty));
            }



            return convertView;

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

