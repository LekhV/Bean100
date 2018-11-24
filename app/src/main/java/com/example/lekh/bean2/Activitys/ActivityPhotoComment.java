package com.example.lekh.bean2.Activitys;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.lekh.bean2.ActivityNavigator;
import com.example.lekh.bean2.Adapters.AdapterPhoto;
import com.example.lekh.bean2.Fragments.PhotosFragment;
import com.example.lekh.bean2.Models.CreateListPhoto;
import com.example.lekh.bean2.R;

import java.util.ArrayList;

public class ActivityPhotoComment extends AppCompatActivity {

    private ArrayList<CreateListPhoto> galleryListImage;

    private final int Pick_image = 100;
    private AdapterPhoto adapterPhoto;
    private Button PickImage ;

    private Button btnUpload;
    private Button btnCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_comment);


        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);

        photoPickerIntent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        photoPickerIntent.setAction(Intent.ACTION_GET_CONTENT);
        //Тип получаемых объектов - image:
        photoPickerIntent.setType("image/*");
        //Запускаем переход с ожиданием обратного результата в виде информации об изображении:
        startActivityForResult(photoPickerIntent, Pick_image);



        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvPhoto);
       // recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 1); // количество столбиков
        recyclerView.setLayoutManager(layoutManager);

        galleryListImage = new ArrayList<>();

        adapterPhoto = new AdapterPhoto(getApplicationContext(), galleryListImage);
        recyclerView.setAdapter(adapterPhoto);
        adapterPhoto.notifyDataSetChanged();

   /*     PickImage = (Button) findViewById(R.id.buttonNew);
        //Настраиваем для нее обработчик нажатий OnClickListener:
        PickImage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                //Вызываем стандартную галерею для выбора изображения с помощью Intent.ACTION_PICK:
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);

                photoPickerIntent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                photoPickerIntent.setAction(Intent.ACTION_GET_CONTENT);
                //Тип получаемых объектов - image:
                photoPickerIntent.setType("image/*");
                //Запускаем переход с ожиданием обратного результата в виде информации об изображении:
                startActivityForResult(photoPickerIntent, Pick_image);
                //startActivity(photoPickerIntent);

               // startActivity( new Intent(ActivityPhotoComment.this, ActivityPhotoComment.class));

            }
        });*/

        btnUpload = (Button) findViewById(R.id.buttonUpload);
        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ActivityPhotoComment.this, ActivityNavigator.class);
               // intent.putParcelableArrayListExtra("BookStatus", galleryListImage);
                //startActivity(intent);
              // startActivityForResult(intent, Pick_image);
                finish();
            }
        });

        btnCancel = (Button) findViewById(R.id.buttonCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ActivityPhotoComment.this, ActivityNavigator.class);
                // intent.putParcelableArrayListExtra("BookStatus", galleryListImage);
                //startActivity(intent);
                // startActivityForResult(intent, Pick_image);
                finish();
            }
        });


    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

        switch (requestCode) {
            case Pick_image:
                if (resultCode == RESULT_OK) {

                    //Получаем URI изображения,
                    if(requestCode == Pick_image) {

                        if(imageReturnedIntent.getClipData() != null) {
                            int count = imageReturnedIntent.getClipData().getItemCount();
                            int currentItem = 0;
                            while(currentItem < count) {
                                Uri imageUri = imageReturnedIntent.getClipData().getItemAt(currentItem).getUri();
                                //do something with the image (save it to some directory or whatever you need to do with it here)
                                currentItem = currentItem + 1;
                                galleryListImage.add(new CreateListPhoto(imageUri.toString()) );

                                adapterPhoto.updateList(galleryListImage);
                            }
                        } else {

                            Uri imageUri = imageReturnedIntent.getData(); // выбирает только одну картинку
                            // imageView.setImageURI(imageUri);
                            galleryListImage.add(new CreateListPhoto(imageUri.toString()));

                            // galleryListImage.add(new CreateList(imageUri.toString()) );
                            adapterPhoto.updateList(galleryListImage);

                        }
                    } else if(imageReturnedIntent.getData() != null) {
                        String imagePath = imageReturnedIntent.getData().getPath();
                        //do something with the image (save it to some directory or whatever you need to do with it here)

                    }
                }
        }
    }

}
