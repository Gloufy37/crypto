package xyz.gloufy.crypto;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

/**
 * An activity representing a single Item detail screen. This
 * activity is only used narrow width devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a {@link ItemListActivity}.
 */
public class ItemDetailActivity extends AppCompatActivity {

    EditText text;
    EditText key;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        id = getIntent().getIntExtra("id",0);
        text = (EditText) findViewById(R.id.text);
        key = (EditText) findViewById(R.id.key);

        switch (id){
            case 0:
                setTitle("Caesar");
                key.setInputType(InputType.TYPE_CLASS_NUMBER);
                break;
            case 1:
                setTitle("Vigenere");
                break;
            case 2:
                setTitle("Playfair");
                break;
            case 3:
                setTitle("Hill");
                key.setText("3,5,1,2");
                break;
            case 4:
                setTitle("Homophonique (carré Polybe)");
                break;
            case 5:
                setTitle("Transposition rectangulaire");
                break;
            case 6:
                setTitle("DES");
                break;
        }
    }

    public String crypt(String msg, String secret,boolean encrypt){
        switch (id){
            case 0:
                return(crypto.caesar(msg,Integer.parseInt(secret),encrypt));
            case 1:
                return(crypto.vigenere(msg, secret, encrypt));
            case 2:
                return(crypto.playfair(msg, secret, encrypt));
            case 3:
                String [] s = secret.split(",");
                if(s.length>3){
                    int [] k = new int[4];
                    for (int i=0;i<k.length;i++){
                        k[i] = Integer.parseInt(s[i]);
                    }
                    return(crypto.hill(msg,k,encrypt,this));
                }
                else{
                    Toast.makeText(this,"La clé doit être sous la forme : a,b,c,d",Toast.LENGTH_LONG).show();
                    return(msg);
                }
            case 4:
                return(crypto.homophonique(msg, secret, encrypt));
            case 5:
                return(crypto.transposition_rect(msg, secret, encrypt));
            case 6:
                if(msg.length()==16 &&secret.length()==16) {
                    return (crypto.des(msg, secret, encrypt));
                }
                else{
                    Toast.makeText(this,"La clé et le message doivent être des mots binaires de 64 bits sour formes hexadécimales",Toast.LENGTH_LONG).show();
                    return(msg);
                }
            default:
                break;
        }
        return(msg);
    }

    public void encrypt(View v){
        String msg = text.getText().toString();
        String secret = key.getText().toString();
        if(!msg.equals("") && !secret.equals("")){
            msg = crypt(msg,secret,true);
            text.setText(msg);
        }else{
            Toast.makeText(this,"Tout les champs doivent être renseignés.",Toast.LENGTH_LONG).show();
        }
    }

    public void uncrypt(View v){
        String msg = text.getText().toString();
        String secret = key.getText().toString();
        if(!msg.equals("") && !secret.equals("")){
            msg = crypt(msg, secret, false);
            text.setText(msg);
        }else{
            Toast.makeText(this,"Tout les champs doivent être renseignés.",Toast.LENGTH_LONG).show();
        }
    }

}
