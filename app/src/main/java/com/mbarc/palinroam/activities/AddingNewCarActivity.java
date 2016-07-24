package com.mbarc.palinroam.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.mbarc.palinroam.R;
import com.mbarc.palinroam.constants.Constants;
import com.mbarc.palinroam.util.Utils;

import java.io.IOException;
import java.lang.reflect.Field;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

public class AddingNewCarActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.base_button)
    Button joinButton;

    @OnClick(R.id.base_button)
    public void joinAction() {
    }

    @Bind(R.id.vehicle_edittext)
    EditText vehicle_registration;
    @Bind(R.id.vehicle_make)
    Spinner vehicleMakeSpin;
    @Bind(R.id.vehicle_model)
    Spinner vehicleModelSpin;
    @Bind(R.id.vehicle_color)
    Spinner vehicleColorSpin;
    @Bind(R.id.vehicle_comfort)
    Spinner vehicleComfortSpin;
    @Bind(R.id.vehicle_fuel_type)
    Spinner vehicleFuelType;
    @Bind(R.id.no_seat_text)
    TextView availableTextView;
    @Bind(R.id.seat_plus)
    ImageView seatPlus;
    @Bind(R.id.seat_minus)
    ImageView seatMinus;
    @Bind(R.id.wifi_switch)
    Switch wifiSwitch;

    @OnCheckedChanged(R.id.wifi_switch)
    public void wifiEnableAction(CompoundButton buttonView,
                                 boolean isChecked) {
        if (isChecked) {
            Log.d("Wi-fi Status", "Enabled");
        } else {
            Log.d("Wi-fi Status", "Disabled");
        }
    }

    String[] makeArray = {"Select Make", "Audi", "BMW", "Ford", "Benz", "Maruti"};
    String[] modelArray = {"Select Model", "Q6", "Q7", "5 Series", "3 Series", "fiesta", "ikon"};
    String[] colorArray = {"Select color", "Black", "Silver", "White", "Red", "Maroon", "Green"};
    String[] comfortArray = {"Select comfort", "Excutive", "Luxary", "Normal"};
    String[] fuelTypeArray = {"Select fuel type", "Diesel", "petrol", "Battery", "Gas"};
    int defaultValue = 1;

    @OnClick(R.id.seat_minus)
    public void minusAction(View v) {
        if (defaultValue == 0) {
            defaultValue = 1;
        } else {
            defaultValue = defaultValue - 1;
            availableTextView.setText(" " + defaultValue);
        }

    }

    @OnClick(R.id.seat_plus_button)
    public void plusAction(View v) {
        defaultValue = defaultValue + 1;
        availableTextView.setText(" " + defaultValue);
    }

    @Bind(R.id.vehicle_image_button)
    ImageView vehicleImage;
    @Bind(R.id.capture_Button)
    ImageView captureButton;

    @OnClick(R.id.capture_Button)
    public void popUpMenuAction(View view) {
        PopupMenu dropDownMenu = new PopupMenu(AddingNewCarActivity.this, captureButton);
        dropDownMenu.getMenuInflater().inflate(R.menu.image_capture_menu, dropDownMenu.getMenu());
        Object menuHelper;
        Class[] argTypes;
        try {
            Field fMenuHelper = PopupMenu.class.getDeclaredField("mPopup");
            fMenuHelper.setAccessible(true);
            menuHelper = fMenuHelper.get(dropDownMenu);
            argTypes = new Class[]{boolean.class};
            menuHelper.getClass().getDeclaredMethod("setForceShowIcon", argTypes).invoke(menuHelper, true);
        } catch (Exception e) {
            Log.w("ERROR MENU", "error forcing menu icons to show", e);
            dropDownMenu.show();
            return;
        }
        dropDownMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.capture_menu) {
                    Log.d("OPEN CAMERA", "Caputure");

                }
                if (item.getItemId() == R.id.gallery_access_menu) {
                    Intent intent = new Intent(Intent.ACTION_PICK,
                            MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        // Bring up gallery to select a photo
                        startActivityForResult(intent, Constants.PICK_PHOTO_CODE);
                    }
                    Log.d("OPEN GALLERY", "gallery");
                }
                return true;
            }
        });
        dropDownMenu.show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_new_car);
        ButterKnife.bind(this);
        toolbar.setTitle("Vehicle details");
        toolbar.setTitleTextColor(getResources().getColor(R.color.icons));
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(getResources().getDrawable(R.mipmap.backarrowicon));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        joinButton.setText("Add car");
        getSpinnerDatas(vehicleMakeSpin, makeArray);
        getSpinnerDatas(vehicleModelSpin, modelArray);
        getSpinnerDatas(vehicleColorSpin, colorArray);
        getSpinnerDatas(vehicleComfortSpin, comfortArray);
        getSpinnerDatas(vehicleFuelType, fuelTypeArray);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data != null) {
            Uri photoUri = data.getData();
            // Do something with the photo based on Uri
            Bitmap selectedImage = null;
            try {
                selectedImage = MediaStore.Images.Media.getBitmap(this.getContentResolver(), photoUri);
            } catch (IOException e) {
                e.printStackTrace();
            }
            // Load the selected image into a preview

            vehicleImage.setImageBitmap(selectedImage);
        }
    }

    public void getSpinnerDatas(Spinner spinner, String[] listOfData) {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(AddingNewCarActivity.this, android.R.layout.simple_dropdown_item_1line, listOfData);
        spinner.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();
    }
}
