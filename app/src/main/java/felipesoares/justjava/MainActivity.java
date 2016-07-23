package felipesoares.justjava;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Toast toast;
    Context context;
    int contCoffee = 0;
    float valueCoffee = 5;
    float contValue = 0;
    Toast toastOrder;
    Context contextOrder;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();
        toast = Toast.makeText(context, "Devagar e sempre", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.BOTTOM, 0, 65);
        contextOrder = getApplicationContext();
        toastOrder = Toast.makeText(contextOrder, "Pedido enviado", Toast.LENGTH_LONG);
        toastOrder.setGravity(Gravity.BOTTOM, 0, 65);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menujustjava, menu);
        return true;
    }

    public void displayCoffe(){
        TextView txtView= (TextView) findViewById(R.id.txtViewQuantity);
        txtView.setText("" + contCoffee);
    }

    public void displayValue(){
        TextView txtView = (TextView) findViewById(R.id.txtViewValue);
        txtView.setText(String.format("R$%4.2f", contValue));
    }


    public void viewDec(View view) {
        if(contCoffee == 0){
            toast.show();
        }else {
            contCoffee--;
            contValue-=valueCoffee;
            displayCoffe();
            displayValue();
        }
    }

    public void viewEnc(View view) {
        if(contCoffee == 99){
            toast.show();
        }else {
            contCoffee++;
            contValue+=valueCoffee;
            displayCoffe();
            displayValue();
        }
    }

    public void submitOrder(View view){
        contCoffee = 0;
        contValue = 0;
        displayCoffe();
        displayValue();
        toastOrder.show();
    }

    public void viewAbout(MenuItem item){
        Intent newAbout = new Intent(MainActivity.this, About.class);
        startActivity(newAbout);
    }


}
