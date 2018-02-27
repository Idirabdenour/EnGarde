package com.example.abdenour.engarde;
import android.app.Activity;
import android.app.Dialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    //
    public static final int MESSAGE_STATE_CHANGE = 1;
    public static final int MESSAGE_READ = 2;
    public static final int MESSAGE_WRITE = 3;
    public static final int MESSAGE_DEVICE_OBJECT = 4;
    public static final int MESSAGE_TOAST = 5;
    public static final String DEVICE_OBJECT = "device_name";

    private static final int REQUEST_ENABLE_BLUETOOTH = 1;
    private BluetoothController chatController;
    private BluetoothDevice connectingDevice;
    private ArrayAdapter<String> discoveredDevicesAdapter;

    private TextView status;
    private Button btnConnect;
    private ListView listView;
    private Dialog dialog;
   // private TextInputLayout inputLayout;
    private ArrayAdapter<String> chatAdapter;
    private ArrayList<String> chatMessages;
    private BluetoothAdapter bluetoothAdapter;

    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5, action;

    TextView tChoix1;
    TextView tChoix2;
    TextView tChoix3;
    TextView tChoix4;
    TextView tChoix5;

    int nbrCarte = 0;

    HashMap<Integer, Integer> valueCarte = new HashMap<Integer, Integer>();


    //instancce class joueur
    Joueur j;
    //


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //partie bluetooth:
        /*bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter == null) {
            Toast.makeText(this, "Bluetooth is not available!", Toast.LENGTH_SHORT).show();
        }else {
           // showPrinterPickDialog();
            finish();
        }*/


        //////////////////////////////////////////

        j=new Joueur(0,1,23,1);

        initButtons();




        TextView tScore = (TextView)findViewById(R.id.Score);
        tScore.setText(j.getPaquet().toString());
        afficherCarte(j);






    }
    public void initButtons(){

        Button Piocher = (Button)findViewById(R.id.IdPiocher);
        TextView t1 = (TextView)findViewById(R.id.id1);
        TextView t2 = (TextView)findViewById(R.id.id2);
        TextView t3 = (TextView)findViewById(R.id.id3);
        TextView t4 = (TextView)findViewById(R.id.id4);
        TextView t5 = (TextView)findViewById(R.id.id5);
        TextView t6 = (TextView)findViewById(R.id.id6);
        TextView t7 = (TextView)findViewById(R.id.id7);
        TextView t8 = (TextView)findViewById(R.id.id8);
        TextView t9 = (TextView)findViewById(R.id.id9);
        TextView t10 = (TextView)findViewById(R.id.id10);
        TextView t11= (TextView)findViewById(R.id.id11);
        TextView t12 = (TextView)findViewById(R.id.id12);
        TextView t13 = (TextView)findViewById(R.id.id13);
        TextView t14 = (TextView)findViewById(R.id.id14);
        TextView t15 = (TextView)findViewById(R.id.id15);
        TextView t16 = (TextView)findViewById(R.id.id16);
        TextView t17 = (TextView)findViewById(R.id.id17);
        TextView t18 = (TextView)findViewById(R.id.id18);
        TextView t19 = (TextView)findViewById(R.id.id19);
        TextView t20 = (TextView)findViewById(R.id.id20);
        TextView t21 = (TextView)findViewById(R.id.id21);
        TextView t22 = (TextView)findViewById(R.id.id22);

        TextView t23 = (TextView)findViewById(R.id.id23);

        tChoix1 = (TextView)findViewById(R.id.choix1);
        tChoix2 = (TextView)findViewById(R.id.choix2);
        tChoix3 = (TextView)findViewById(R.id.choix3);
        tChoix4 = (TextView)findViewById(R.id.choix4);
        tChoix5 = (TextView)findViewById(R.id.choix5);

        btn1 = (Button) findViewById(R.id.Carte1);
        btn2 = (Button) findViewById(R.id.Carte2);
        btn3 = (Button) findViewById(R.id.Carte3);
        btn4 = (Button) findViewById(R.id.Carte4);
        btn5 = (Button) findViewById(R.id.Carte5);
        action = (Button) findViewById(R.id.action);
        action.setVisibility(View.INVISIBLE);

        t1.setText("X");
        t1.setTextColor(Color.WHITE);

        valueCarte.put(1,0);
        valueCarte.put(2,0);
        valueCarte.put(3,0);
        valueCarte.put(4,0);
        valueCarte.put(5,0);
    }



    public void GameToHome(View v){
        Intent in = new Intent(this, Home.class);
        startActivity(in);
    }

/*
    public  void Piocher(View V){
        int val = j.piocher();
    }
*/

    public void afficherCarte(Joueur j){
        for (int i =0;i<j.getMain().size();i++){
            int b = i+1;
            String btn = "Carte" + b;
            int res = getResources().getIdentifier(btn, "id", getPackageName());
            Button Carte = (Button) findViewById(res);

            Carte.setText("t"+j.getMain().get(i));
            int img = getResources().getIdentifier("carte" + j.getMain().get(i), "drawable", getPackageName());
            Carte.setBackgroundResource(img);

        }
    }

    public  void clickCarte1(View V){

        if(nbrCarte == 1 && valueCarte.get(1) != 0){
            tChoix1.setText("");
            valueCarte.put(1, 0);
            nbrCarte--;
            action.setVisibility(View.INVISIBLE);
        }

        else if(nbrCarte < 2){
            tChoix1.setText("X");
            valueCarte.put(1, j.getMain().get(0));
            nbrCarte++;
            action.setVisibility(View.VISIBLE);
            if(nbrCarte == 2){
                for (int i = 1; i <= 5; i++){
                    if(valueCarte.get(i) == 0){
                        String btn = "Carte" + i;
                        int res = getResources().getIdentifier(btn, "id", getPackageName());
                        Button Carte = (Button) findViewById(res);
                        Carte.setVisibility(View.INVISIBLE);
                    }
                }
            }
        }else{
            tChoix1.setText("");
            valueCarte.put(1, 0);
            nbrCarte--;
            for (int i = 1; i <= 5; i++){
                if(valueCarte.get(i) == 0){
                    String btn = "Carte" + i;
                    int res = getResources().getIdentifier(btn, "id", getPackageName());
                    Button Carte = (Button) findViewById(res);
                    Carte.setVisibility(View.VISIBLE);
                }
            }

        }



    }

    public  void clickCarte2(View V){
        if(nbrCarte == 1 && valueCarte.get(2) != 0){
            tChoix2.setText("");
            valueCarte.put(2, 0);
            nbrCarte--;
            action.setVisibility(View.INVISIBLE);
        }

        else if(nbrCarte < 2){
            tChoix2.setText("X");
            valueCarte.put(2, j.getMain().get(0));
            nbrCarte++;
            action.setVisibility(View.VISIBLE);
            if(nbrCarte == 2){
                for (int i = 1; i <= 5; i++){
                    if(valueCarte.get(i) == 0){
                        String btn = "Carte" + i;
                        int res = getResources().getIdentifier(btn, "id", getPackageName());
                        Button Carte = (Button) findViewById(res);
                        Carte.setVisibility(View.INVISIBLE);
                    }
                }
            }
        }else {
            tChoix2.setText("");
            valueCarte.put(2, 0);
            nbrCarte--;
            for (int i = 1; i <= 5; i++) {
                if (valueCarte.get(i) == 0) {
                    String btn = "Carte" + i;
                    int res = getResources().getIdentifier(btn, "id", getPackageName());
                    Button Carte = (Button) findViewById(res);
                    Carte.setVisibility(View.VISIBLE);
                }
            }
        }

    }

    public  void clickCarte3(View V){
        if(nbrCarte == 1 && valueCarte.get(3) != 0){
            tChoix3.setText("");
            valueCarte.put(3, 0);
            nbrCarte--;
            action.setVisibility(View.INVISIBLE);
        }

        else if(nbrCarte < 2){
            tChoix3.setText("X");
            valueCarte.put(3, j.getMain().get(0));
            nbrCarte++;
            action.setVisibility(View.VISIBLE);
            if(nbrCarte == 2){
                for (int i = 1; i <= 5; i++){
                    if(valueCarte.get(i) == 0){
                        String btn = "Carte" + i;
                        int res = getResources().getIdentifier(btn, "id", getPackageName());
                        Button Carte = (Button) findViewById(res);
                        Carte.setVisibility(View.INVISIBLE);
                    }
                }
            }
        }else {
            tChoix3.setText("");
            valueCarte.put(3, 0);
            nbrCarte--;

            for (int i = 1; i <= 5; i++) {
                if (valueCarte.get(i) == 0) {
                    String btn = "Carte" + i;
                    int res = getResources().getIdentifier(btn, "id", getPackageName());
                    Button Carte = (Button) findViewById(res);
                    Carte.setVisibility(View.VISIBLE);
                }
            }
        }


    }

    public  void clickCarte4(View V){
        if(nbrCarte == 1 && valueCarte.get(4) != 0){
            tChoix4.setText("");
            valueCarte.put(4, 0);
            nbrCarte--;
            action.setVisibility(View.INVISIBLE);
        }

        else if(nbrCarte < 2){
            tChoix4.setText("X");
            valueCarte.put(4, j.getMain().get(0));
            nbrCarte++;
            action.setVisibility(View.VISIBLE);
            if(nbrCarte == 2){
                for (int i = 1; i <= 5; i++){
                    if(valueCarte.get(i) == 0){
                        String btn = "Carte" + i;
                        int res = getResources().getIdentifier(btn, "id", getPackageName());
                        Button Carte = (Button) findViewById(res);
                        Carte.setVisibility(View.INVISIBLE);
                    }
                }
            }
        }else {
            tChoix4.setText("");
            valueCarte.put(4, 0);
            nbrCarte--;
            for (int i = 1; i <= 5; i++) {
                if (valueCarte.get(i) == 0) {
                    String btn = "Carte" + i;
                    int res = getResources().getIdentifier(btn, "id", getPackageName());
                    Button Carte = (Button) findViewById(res);
                    Carte.setVisibility(View.VISIBLE);
                }
            }
        }


    }
    public  void clickCarte5(View V){
        if(nbrCarte == 1 && valueCarte.get(5) != 0){
            tChoix5.setText("");
            valueCarte.put(5, 0);
            nbrCarte--;
            action.setVisibility(View.INVISIBLE);
        }

        else if(nbrCarte < 2){
            tChoix5.setText("X");
            valueCarte.put(5, j.getMain().get(0));
            nbrCarte++;
            action.setVisibility(View.VISIBLE);
            if(nbrCarte == 2){
                for (int i = 1; i <= 5; i++){
                    if(valueCarte.get(i) == 0){
                        String btn = "Carte" + i;
                        int res = getResources().getIdentifier(btn, "id", getPackageName());
                        Button Carte = (Button) findViewById(res);
                        Carte.setVisibility(View.INVISIBLE);
                    }
                }
            }
        }else {
            tChoix5.setText("");
            valueCarte.put(5, 0);
            nbrCarte--;
            for (int i = 1; i <= 5; i++) {
                if (valueCarte.get(i) == 0) {
                    String btn = "Carte" + i;
                    int res = getResources().getIdentifier(btn, "id", getPackageName());
                    Button Carte = (Button) findViewById(res);
                    Carte.setVisibility(View.VISIBLE);
                }
            }
        }
    }
    private Handler handler = new Handler(new Handler.Callback() {

        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case MESSAGE_STATE_CHANGE:
                    switch (msg.arg1) {
                        case BluetoothController.STATE_CONNECTED:
                            setStatus("Connected to: " + connectingDevice.getName());
                            btnConnect.setEnabled(false);
                            break;
                        case BluetoothController.STATE_CONNECTING:
                            setStatus("Connecting...");
                            btnConnect.setEnabled(false);
                            break;
                        case BluetoothController.STATE_LISTEN:
                        case BluetoothController.STATE_NONE:
                            setStatus("Not connected");
                            break;
                    }
                    break;
                case MESSAGE_WRITE:
                    byte[] writeBuf = (byte[]) msg.obj;

                    String writeMessage = new String(writeBuf);
                    chatMessages.add("Me: " + writeMessage);
                    chatAdapter.notifyDataSetChanged();
                    break;
                case MESSAGE_READ:
                    byte[] readBuf = (byte[]) msg.obj;

                    String readMessage = new String(readBuf, 0, msg.arg1);
//****************** chatMessages.add(connectingDevice.getName() + ":  " + readMessage);//**************************
                    chatAdapter.notifyDataSetChanged();
                    break;
                case MESSAGE_DEVICE_OBJECT:
                    connectingDevice = msg.getData().getParcelable(DEVICE_OBJECT);
                    Toast.makeText(getApplicationContext(), "Connected to " + connectingDevice.getName(),
                            Toast.LENGTH_SHORT).show();
                    break;
                case MESSAGE_TOAST:
                    Toast.makeText(getApplicationContext(), msg.getData().getString("toast"),
                            Toast.LENGTH_SHORT).show();
                    break;
            }
            return false;
        }
    });

    private void showPrinterPickDialog() {
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.layout_bluetooth);
        dialog.setTitle("Bluetooth Devices");

        if (bluetoothAdapter.isDiscovering()) {
            bluetoothAdapter.cancelDiscovery();
        }
        bluetoothAdapter.startDiscovery();

        //Initializing bluetooth adapters
        ArrayAdapter<String> pairedDevicesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        discoveredDevicesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);

        //locate listviews and attatch the adapters
        ListView listView = (ListView) dialog.findViewById(R.id.pairedDeviceList);
        ListView listView2 = (ListView) dialog.findViewById(R.id.discoveredDeviceList);
        listView.setAdapter(pairedDevicesAdapter);
        listView2.setAdapter(discoveredDevicesAdapter);

        // Register for broadcasts when a device is discovered
        IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        registerReceiver(discoveryFinishReceiver, filter);

        // Register for broadcasts when discovery has finished
        filter = new IntentFilter(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
        registerReceiver(discoveryFinishReceiver, filter);

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        Set<BluetoothDevice> pairedDevices = bluetoothAdapter.getBondedDevices();

        // If there are paired devices, add each one to the ArrayAdapter
        if (pairedDevices.size() > 0) {
            for (BluetoothDevice device : pairedDevices) {
                pairedDevicesAdapter.add(device.getName() + "\n" + device.getAddress());
            }
        } else {
            pairedDevicesAdapter.add(getString(R.string.none_paired));
        }

        //Handling listview item click event
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                bluetoothAdapter.cancelDiscovery();
                String info = ((TextView) view).getText().toString();
                String address = info.substring(info.length() - 17);

                connectToDevice(address);
                dialog.dismiss();
            }

        });

        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                bluetoothAdapter.cancelDiscovery();
                String info = ((TextView) view).getText().toString();
                String address = info.substring(info.length() - 17);

                connectToDevice(address);
                dialog.dismiss();
            }
        });

        dialog.findViewById(R.id.cancelButton).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.setCancelable(false);
        dialog.show();
    }

    private void setStatus(String s) {
        status.setText(s);
    }

    private void connectToDevice(String deviceAddress) {
        bluetoothAdapter.cancelDiscovery();
        BluetoothDevice device = bluetoothAdapter.getRemoteDevice(deviceAddress);
        chatController.connect(device);
    }


    public void send(View view) {
            sendMessage("message a envoyer");
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case REQUEST_ENABLE_BLUETOOTH:
                if (resultCode == Activity.RESULT_OK) {
                    chatController = new BluetoothController(this, handler);
                } else {
                    Toast.makeText(this, "Bluetooth still disabled, turn off application!", Toast.LENGTH_SHORT).show();
                    finish();
                }
        }
    }

    private void sendMessage(String message) {
        if (chatController.getState() != BluetoothController.STATE_CONNECTED) {
            Toast.makeText(this, "Connection was lost!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (message.length() > 0) {
            byte[] send = message.getBytes();
            chatController.write(send);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
       /* if (!bluetoothAdapter.isEnabled()) {
            Intent enableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableIntent, REQUEST_ENABLE_BLUETOOTH);
        } else {
            chatController = new BluetoothController(this, handler);
        }*/
    }

    @Override
    public void onResume() {
        super.onResume();

        if (chatController != null) {
            if (chatController.getState() == BluetoothController.STATE_NONE) {
                chatController.start();
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (chatController != null)
            chatController.stop();
    }

    private final BroadcastReceiver discoveryFinishReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();

            if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                if (device.getBondState() != BluetoothDevice.BOND_BONDED) {
                    discoveredDevicesAdapter.add(device.getName() + "\n" + device.getAddress());
                }
            } else if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action)) {
                if (discoveredDevicesAdapter.getCount() == 0) {
                    discoveredDevicesAdapter.add(getString(R.string.none_found));
                }
            }
        }
    };
}

