package br.com.cpelegrin.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    private static final String TAG = "MyService";
    private boolean running = false;

    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate");
        super.onCreate();
        running = true;
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind");
        // null aqui porque não queremos interagir com o serviço (veremos um exemplo disso depois)
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, final int startId) {
        Log.d(TAG, "onStartCommand");

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i<10; i++){
                        if(running){
                            // Simula algum processamento
                            Thread.sleep(1000);
                            Log.i(TAG, "Thread "+ startId + " executando... " + i);
                        }
                    }
                    Log.e(TAG, "Thread "+ startId + " terminou!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.e(TAG, "onDestroy");
        running = false;
        super.onDestroy();
    }
}