package fr.wildcodeschool.wildshare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class OwnItemList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_own_item_list);
        if (getIntent().getParcelableArrayExtra("new item") == null) {

            // Database objets de l'utilisateur
            final ArrayList<ItemModel> itemData = new ArrayList<>();
            itemData.add(new ItemModel("ObjetTest1", null, "Description", "ownerFirstame", "ownerLastame", R.color.orange));
            itemData.add(new ItemModel("ObjetTest2", null, "Description", "ownerFirstame", "ownerLastame", R.color.red));
            itemData.add(new ItemModel("ObjetTest3", null, "Description", "ownerFirstame", "ownerLastame", R.color.yellow));

            final ListAdapter adapter = new ListAdapter(this, itemData);
            ListView ownItemList = findViewById(R.id.lv_ownItemList);
            ownItemList.setAdapter(adapter);

        } else {

            ItemModel newItem = getIntent().getParcelableExtra("new item");

            // Database objets de l'utilisateur
            final ArrayList<ItemModel> itemData = new ArrayList<>();
            itemData.add(new ItemModel("ObjetTest1", null, "Description", "ownerFirstame", "ownerLastame", R.color.orange));
            itemData.add(new ItemModel("ObjetTest2", null, "Description", "ownerFirstame", "ownerLastame", R.color.red));
            itemData.add(new ItemModel("ObjetTest3", null, "Description", "ownerFirstame", "ownerLastame", R.color.yellow));

            //Récupération des données depuis AddItem
            itemData.add(newItem);

            final ListAdapter adapter = new ListAdapter(this, itemData);
            ListView ownItemList = findViewById(R.id.lv_ownItemList);
            ownItemList.setAdapter(adapter);

        }

        Button add = findViewById(R.id.b_addItem);


        add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(OwnItemList.this, AddItem.class);
                    startActivity(intent);
                }
            });



    }
}
