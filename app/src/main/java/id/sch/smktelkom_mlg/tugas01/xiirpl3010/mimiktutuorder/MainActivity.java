package id.sch.smktelkom_mlg.tugas01.xiirpl3010.mimiktutuorder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText isinama;
    Button bOk;
    RadioButton cod, trf;
    TextView tvHasil;
    CheckBox cbStb, cbCklt, cbVn, cbOri, cbOreo;
    Spinner spJumlah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        isinama = (EditText) findViewById(R.id.editTextNama);
        bOk = (Button) findViewById(R.id.buttonSubmit);
        tvHasil = (TextView) findViewById(R.id.textViewPesan);
        cod = (RadioButton) findViewById(R.id.radioButtonCOD);
        trf = (RadioButton) findViewById(R.id.radioButtonBank);
        cbStb = (CheckBox) findViewById(R.id.checkBoxStw);
        cbCklt = (CheckBox) findViewById(R.id.checkBoxCklt);
        cbVn = (CheckBox) findViewById(R.id.checkBoxVanila);
        cbOri = (CheckBox) findViewById(R.id.checkBoxOri);
        cbOreo = (CheckBox) findViewById(R.id.checkBoxOreo);
        spJumlah = (Spinner) findViewById(R.id.spinnerJumlah);

        findViewById(R.id.buttonSubmit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doClick();
            }
        });
    }

    private void doClick() {
        if (isValid()) {
            String nama = isinama.getText().toString();

            String pay = "(Not choosen)";

            if (cod.isChecked()) {
                pay = cod.getText().toString();
            } else if (trf.isChecked()) {
                pay = trf.getText().toString();
            }

            String jumlah = spJumlah.getSelectedItem().toString();

            String rasa = "Rasa Susu Pilihanmu :\n";
            int startlen = rasa.length();
            if (cbStb.isChecked()) rasa += cbStb.getText() + "\n";
            if (cbCklt.isChecked()) rasa += cbCklt.getText() + "\n";
            if (cbVn.isChecked()) rasa += cbVn.getText() + "\n";
            if (cbOri.isChecked()) rasa += cbOri.getText() + "\n";
            if (cbOreo.isChecked()) rasa += cbOreo.getText() + "\n";

            if (rasa.length() == startlen) rasa += "(No object was choosen)";

            tvHasil.setText("Name        : " + nama + "\n" + "Pembayaran      : " + pay + "\n"
                    + "Jumlah Pesanan         : " + jumlah + "\n" + rasa);
        }
    }

    private boolean isValid() {
        boolean valid = true;

        String nama = isinama.getText().toString();
        String pay = "";

        if (nama.isEmpty()) {
            isinama.setError("Name must be filled!");
            valid = false;
        } else if (nama.length() < 3) {
            isinama.setError("Name min have 3 characters");
            valid = false;
        } else {
            isinama.setError(null);
        }

        if (pay == null) {
            cod.setError("");
            valid = false;
        } else {
            trf.setError(null);
        }
        return valid;
    }
}
