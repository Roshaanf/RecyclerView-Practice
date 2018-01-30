package com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen;

import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.models.ItemModel;
import com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.models.StaggeredItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roshaan on 1/25/2018.
 */

public class DataRepository {

    public static List<ItemModel> getItemData(){

        List<ItemModel> list=new ArrayList<>();
        String names[]={"ALi","Salman","Roshaan","Paul","Farhan","Cena","John"};
        int images[]={R.drawable.cargo_truck_icon,R.drawable.curbside_icon,R.drawable.helper_icon,R.drawable.image_2,R.drawable.image_3,
        R.drawable.delivery_icon,R.drawable.ic_launcher_background};

        for(int i=0;i<names.length;i++){
            list.add(new ItemModel(names[i],images[i]));
        }
        return list;
    }

    public static List<StaggeredItem> getStaggeredData(){

        List<StaggeredItem> list=new ArrayList<>();
        list.add(new StaggeredItem(R.drawable.st));
        list.add(new StaggeredItem(R.drawable.s2));
        list.add(new StaggeredItem(R.drawable.st3));
        list.add(new StaggeredItem(R.drawable.st4));
        list.add(new StaggeredItem(R.drawable.st5));
        list.add(new StaggeredItem(R.drawable.st6));
        list.add(new StaggeredItem(R.drawable.st7));
        list.add(new StaggeredItem(R.drawable.st8));

        return list;
    }
}
