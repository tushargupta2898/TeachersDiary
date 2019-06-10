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

public class SubjectDetails extends AppCompatActivity {


    private Toolbar toolbar;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_details);


        setupUIViews();
        initToolbar();
        setupListView();
    }

    private void setupUIViews(){
        toolbar = (Toolbar)findViewById(R.id.ToolbarSubjectDetails);
        listView = (ListView)findViewById(R.id.lvSubjectDetails);

    }
    private void initToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("subjects");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }



    private void setupListView() {
        String subject_selected = SubjectActivity.subjectPreferences.getString(SubjectActivity.SUB_PRE, null);
        String[] syllabus = new String[]{};
        String[] title = getResources().getStringArray(R.array.titles);


        if (subject_selected.equalsIgnoreCase("networks")) {
            syllabus= getResources().getStringArray(R.array.networks);
        } else if (subject_selected.equalsIgnoreCase("compiler_design")) {
            syllabus = getResources().getStringArray(R.array.compiler_design);
        } else if (subject_selected.equalsIgnoreCase("management")) {
            syllabus = getResources().getStringArray(R.array.management);
        } else if (subject_selected.equalsIgnoreCase("webtechnologies")) {
            syllabus = getResources().getStringArray(R.array.webtechnologies);
        } else if (subject_selected.equalsIgnoreCase("unixshellprograming")) {
            syllabus = getResources().getStringArray(R.array.unixshellprograming);
        } else if(subject_selected.equalsIgnoreCase("computergraphics")){
            syllabus= getResources().getStringArray(R.array.computergraphics);
        } else if (subject_selected.equalsIgnoreCase("cgvlab")) {
            syllabus = getResources().getStringArray(R.array.cgvlab);
        } else {
            syllabus = getResources().getStringArray(R.array.wtlab);
        }


        SubjectDetailsAdapter subjectDetailsAdapter=new SubjectDetailsAdapter(this,title,syllabus);
        listView.setAdapter(subjectDetailsAdapter);
    }

    public  class SubjectDetailsAdapter extends BaseAdapter {

        private Context mContext;
        private LayoutInflater layoutInflater;
        private TextView title, subject;
        private String[] titleArray;
        private String[] subjectArray;


        public SubjectDetailsAdapter(Context context, String[] title, String[] subject){
            mContext = context;
            titleArray = title;
            subjectArray = subject;
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
                convertView = layoutInflater.inflate(R.layout.subject_detail_single_item, null);
            }

            title = (TextView)convertView.findViewById(R.id.tvSubjectTitle);
            subject= (TextView)convertView.findViewById(R.id.tvSyllabus);


            title.setText(titleArray[position]);
            try{
                subject.setText(subjectArray[position]);
            }catch (Exception exception){

                Log.e("error", String.valueOf(subject));
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

