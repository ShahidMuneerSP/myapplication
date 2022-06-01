package com.example.myapplication.samples;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class CourseRVAdapter extends RecyclerView.Adapter<CourseRVAdapter.ViewHolder> {

    private ArrayList<CourseModel> courseModelArrayList;
    private Context context;
    public CourseRVAdapter(ArrayList<CourseModel> courseModelArrayList, Context context) {
        this.courseModelArrayList = courseModelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public CourseRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View  view= LayoutInflater.from(parent.getContext()).
                inflate(R.layout.course_rv_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseRVAdapter.ViewHolder holder, int position) {
        CourseModel model=courseModelArrayList.get(position);

        holder.courseNameTV.setText(model.getCourseName());
        holder.courseDescTV.setText(model.getCourseDescription());
        holder.courseDurationTV.setText(model.getCourseDuration());
        holder.courseTracksTV.setText(model.getCourseTracks());

    }
    @Override
    public int getItemCount() {
        return courseModelArrayList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView courseNameTV,courseDescTV,courseDurationTV,courseTracksTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            courseNameTV = itemView.findViewById(R.id.idTVCourseName);
            courseDescTV = itemView.findViewById(R.id.idTVCourseDesciption);
        }
    }
}
