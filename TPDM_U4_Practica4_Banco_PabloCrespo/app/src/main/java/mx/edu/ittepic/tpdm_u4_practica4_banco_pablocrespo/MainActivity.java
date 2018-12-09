package mx.edu.ittepic.tpdm_u4_practica4_banco_pablocrespo;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    TextView totalRegistro1,totalRegistro2,totalRegistro3,ventanaT1,ventanaT2,ventanaT3,cola1T0,cola1T1,cola1T2,cola1T3,cola1T4,cola2T0,cola2T1,cola2T2,cola2T3,cola2T4,cola3T0,cola3T1,cola3T2,cola3T3,cola3T4;
    Button venta1,venta2,venta3;
    Thread thread,c1,c2,c3;
    int tr1=0,tr2=0,tr3=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalRegistro1 = findViewById(R.id.totalRegistro1);
        totalRegistro2 = findViewById(R.id.totalRegistro2);
        totalRegistro3 = findViewById(R.id.totalRegistro3);


        ventanaT1 = findViewById(R.id.ventanaT1);
        ventanaT2 = findViewById(R.id.ventanaT2);
        ventanaT3 = findViewById(R.id.ventanaT3);

        cola1T0 = findViewById(R.id.cola1T0);
        cola1T1 = findViewById(R.id.cola1T1);
        cola1T2 = findViewById(R.id.cola1T2);
        cola1T3 = findViewById(R.id.cola1T3);
        cola1T4 = findViewById(R.id.cola1T4);

        cola2T0 = findViewById(R.id.cola2T0);
        cola2T1 = findViewById(R.id.cola2T1);
        cola2T2 = findViewById(R.id.cola2T2);
        cola2T3 = findViewById(R.id.cola2T3);
        cola2T4 = findViewById(R.id.cola2T4);

        cola3T0 = findViewById(R.id.cola3T0);
        cola3T1 = findViewById(R.id.cola3T1);
        cola3T2 = findViewById(R.id.cola3T2);
        cola3T3 = findViewById(R.id.cola3T3);
        cola3T4 = findViewById(R.id.cola3T4);

        venta1 = findViewById(R.id.venta1);
        venta2 = findViewById(R.id.venta2);
        venta3 = findViewById(R.id.venta3);

        venta1.setEnabled(false);
        venta2.setEnabled(false);
        venta3.setEnabled(false);

        venta1.setBackgroundResource(R.drawable.ventana1);
        venta2.setBackgroundResource(R.drawable.ventana2);
        venta3.setBackgroundResource(R.drawable.ventana3);



        final int cola1[]=new int[6];
        final int cola2[]=new int[6];
        final int cola3[]=new int[6];

        for(int i=0;i<6;i++){
            int numero = (int) (Math.random() * 7) + 1;
            cola1[i]=numero;
            numero = (int) (Math.random() * 7) + 1;
            cola2[i]=numero;
            numero = (int) (Math.random() * 7) + 1;
            cola3[i]=numero;
        }

        ventanaT1.setText(""+cola1[0]);
        ventanaT2.setText(""+cola2[0]);
        ventanaT3.setText(""+cola3[0]);

        cola1T0.setText(""+cola1[1]);
        cola1T1.setText(""+cola1[2]);
        cola1T2.setText(""+cola1[3]);
        cola1T3.setText(""+cola1[4]);
        cola1T4.setText(""+cola1[5]);

        cola2T0.setText(""+cola2[1]);
        cola2T1.setText(""+cola2[2]);
        cola2T2.setText(""+cola2[3]);
        cola2T3.setText(""+cola2[4]);
        cola2T4.setText(""+cola2[5]);

        cola3T0.setText(""+cola3[1]);
        cola3T1.setText(""+cola3[2]);
        cola3T2.setText(""+cola3[3]);
        cola3T3.setText(""+cola3[4]);
        cola3T4.setText(""+cola3[5]);

        thread = new Thread(){
            public void run(){
                while(true){

                    //INICIA HILO DE COLA1
                    c1=new Thread(){
                        public void run(){
                            if(cola1[0]>=1){
                                cola1[0]=cola1[0]-1;
                                tr1=tr1+1;
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        totalRegistro1.setText("T.R.: "+tr1);
                                        ventanaT1.setText(""+cola1[0]);
                                    }
                                });
                            }

                            if(cola1[0]==0){
                                if(tr1>=20){
                                    tr1=0;
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            venta1.setBackgroundResource(R.drawable.v1cerrada);
                                        }
                                    });
                                    try {
                                        sleep(100000000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }

                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        venta1.setBackgroundResource(R.drawable.ventana1);
                                    }
                                });;

                                cola1[0]=cola1[1];
                                cola1[1]=cola1[2];
                                cola1[2]=cola1[3];
                                cola1[3]=cola1[4];
                                cola1[4]=cola1[5];
                                int numero = (int) (Math.random() * 7) + 1;
                                cola1[5]=numero;

                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        ventanaT1.setText(""+cola1[0]);
                                        cola1T0.setText(""+cola1[1]);
                                        cola1T1.setText(""+cola1[2]);
                                        cola1T2.setText(""+cola1[3]);
                                        cola1T3.setText(""+cola1[4]);
                                        cola1T4.setText(""+cola1[5]);
                                    }
                                });
                            }


                            //SLEEP DE COLA1
                            try {
                                sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    };
                    //TERMINA HILO DE COLA1

                    //INICIA HILO DE COLA2
                    c2=new Thread(){
                        public void run(){
                            if(cola2[0]>=1){
                                cola2[0]=cola2[0]-1;
                                tr2=tr2+1;
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        totalRegistro2.setText("T.R.: "+tr2);
                                        ventanaT2.setText(""+cola2[0]);
                                    }
                                });
                            }

                            if(cola2[0]==0){
                                if(tr2>=20){
                                    tr2=0;
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            venta2.setBackgroundResource(R.drawable.v2cerrada);
                                        }
                                    });
                                    try {
                                        sleep(100000000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }

                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        venta2.setBackgroundResource(R.drawable.ventana2);
                                    }
                                });;

                                cola2[0]=cola2[1];
                                cola2[1]=cola2[2];
                                cola2[2]=cola2[3];
                                cola2[3]=cola2[4];
                                cola2[4]=cola2[5];
                                int numero = (int) (Math.random() * 7) + 1;
                                cola2[5]=numero;

                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        ventanaT2.setText(""+cola2[0]);
                                        cola2T0.setText(""+cola2[1]);
                                        cola2T1.setText(""+cola2[2]);
                                        cola2T2.setText(""+cola2[3]);
                                        cola2T3.setText(""+cola2[4]);
                                        cola2T4.setText(""+cola2[5]);
                                    }
                                });
                            }


                            //SLEEP DE COLA2
                            try {
                                sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    };
                    //TERMINA HILO DE COLA1

                    //INICIA HILO DE COLA2
                    c3=new Thread(){
                        public void run(){
                            if(cola3[0]>=1){
                                cola3[0]=cola3[0]-1;
                                tr3=tr3+1;
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        totalRegistro3.setText("T.R.: "+tr3);
                                        ventanaT3.setText(""+cola3[0]);
                                    }
                                });
                            }

                            if(cola3[0]==0){
                                if(tr3>=20){
                                    tr3=0;
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            venta3.setBackgroundResource(R.drawable.v3cerrada);
                                        }
                                    });
                                    try {
                                        sleep(100000000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }

                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        venta3.setBackgroundResource(R.drawable.ventana3);
                                    }
                                });;

                                cola3[0]=cola3[1];
                                cola3[1]=cola3[2];
                                cola3[2]=cola3[3];
                                cola3[3]=cola3[4];
                                cola3[4]=cola3[5];
                                int numero = (int) (Math.random() * 7) + 1;
                                cola3[5]=numero;

                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        ventanaT3.setText(""+cola3[0]);
                                        cola3T0.setText(""+cola3[1]);
                                        cola3T1.setText(""+cola3[2]);
                                        cola3T2.setText(""+cola3[3]);
                                        cola3T3.setText(""+cola3[4]);
                                        cola3T4.setText(""+cola3[5]);
                                    }
                                });
                            }


                            //SLEEP DE COLA3
                            try {
                                sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    };
                    //TERMINA HILO DE COLA3




                    //SE EJECUTAN LAS COLAS
                    c1.start();
                    c2.start();
                    c3.start();


                    //SE DUERME EL HILO PRINCIPAL
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };//TERMINA EL HILO PRINCIPAL


        try{
            thread.start();
        }catch (Exception e){
            Toast.makeText(MainActivity.this,"EL HILO YA ESTABA EN EJECUCION",Toast.LENGTH_LONG).show();
        }

    }
}
