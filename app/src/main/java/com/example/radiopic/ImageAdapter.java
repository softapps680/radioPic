package com.example.radiopic;

import android.content.Context;


import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import android.widget.BaseAdapter;
import android.widget.Button;

import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ImageAdapter extends BaseAdapter {
    private final LayoutInflater mInflater;
    Context context;
    AppCompatActivity currentActivity;
    List<Pet> items;

    private int mSelectedPosition = -1;
    private RadioButton mSelectedRB;

    public ImageAdapter(MainActivity _context,List<Pet> _items) {

        currentActivity = _context;
        this.context = _context;
        this.items = _items;
        this.mInflater = (LayoutInflater) currentActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Pet getItem(int position) {
        return items.get(position);
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent)
    {

        //Om den inte finns fläta in den
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.gridchild, parent, false);
        //Vad som ska med i varje item dessa finns i gridchild
            RadioButton btn =  (RadioButton)convertView.findViewById(R.id.btnPet);
            ImageView image = (ImageView)convertView.findViewById(R.id.imgPet);

            btn.setOnClickListener(new Button.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Du klicka nu"+position, Toast.LENGTH_LONG).show();

                    if ((position != mSelectedPosition && mSelectedRB != null)) {
                        mSelectedRB.setChecked(false);
                        // Toast.makeText(context, "Du valde"+position, Toast.LENGTH_LONG).show();
                    }
                    mSelectedPosition = position;
                    mSelectedRB = (RadioButton) v;
                    }

                });

            //Hämtar petobjekt mall för varje  position vi är på i listan vi skicka
            Pet pet = items.get(position);
            btn.setText(pet.Name);
           // btn.setButtonDrawable(pet.Pic);
            //image.setImageResource(pet.Pic);
            //Drawable d= pet.PicName;
         //   btn.setBackground(pet.PicName);
           // android:button="@drawable/radio_selector"
            btn.setButtonDrawable(pet.Pic);
    }
        else {
            RadioButton btn = (RadioButton) convertView.getTag();
        }






        return convertView;
    }




    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        return true;
    }





}