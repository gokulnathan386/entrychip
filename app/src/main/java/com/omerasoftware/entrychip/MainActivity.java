package com.omerasoftware.entrychip;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipDrawable;
import com.google.android.material.chip.ChipGroup;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button button;
    private ChipGroup chipGroup;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.edittext);
        button = findViewById(R.id.button);
        chipGroup = findViewById(R.id.chipgroup);

    }

    public void btnClick(View view){


        Chip chip =new Chip(this);
        ChipDrawable drawable = ChipDrawable.createFromAttributes(this,null,0,
                com.google.android.material.R.style.Widget_MaterialComponents_Chip_Entry
                );
        chip.setChipDrawable(drawable);
        chip.setCheckable(false);
        chip.setChipIconResource(R.drawable.ic_baseline_local_phone_24);
        chip.setIconStartPadding(3f);
        chip.setPadding(60,10,60,10);
        chip.setText(editText.getText().toString());
        chip.setOnCloseIconClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chipGroup.removeView(chip);
            }
        });

        chipGroup.addView(chip);
        editText.setText("");

    }

}