package com.blacklenspub.recyclerviewbug;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonHolder> {

    private List<Person> list;

    public PersonAdapter(@NonNull List<Person> list) {
        this.list = list;
    }

    @Override
    public PersonHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_person, parent, false);
        return new PersonHolder(view);
    }

    @Override
    public void onBindViewHolder(PersonHolder holder, int position) {
        Person person = list.get(position);
        holder.person = person;
        holder.textView.setText(String.format("%d %s(%d)", position, person.name, person.age));
        holder.checkBox.setChecked(person.isChecked);
        if (person.age >= 30) {
            holder.textView.setTextColor(Color.RED);
        } else {
            holder.textView.setTextColor(Color.GRAY);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class PersonHolder extends RecyclerView.ViewHolder {

        public CheckBox checkBox;
        public TextView textView;
        public Person person;

        public PersonHolder(View itemView) {
            super(itemView);
            checkBox = (CheckBox) itemView.findViewById(R.id.checkbox);
            textView = (TextView) itemView.findViewById(R.id.text);
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    person.isChecked = b;
                }
            });
        }
    }
}
