package tech.alvarez.tresenraya;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

import tech.alvarez.tresenraya.adapters.PartidasAdapter;
import tech.alvarez.tresenraya.models.Partida;

public class MainActivity extends AppCompatActivity {

    private EditText jugador1EdiText;
    private EditText jugador2EdiText;

    private RecyclerView historialRecyclerView;
    private PartidasAdapter partidasAdapter;

    private boolean tocaX = true;

    private Button[] botones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jugador1EdiText = (EditText) findViewById(R.id.jugador1EditText);
        jugador2EdiText = (EditText) findViewById(R.id.jugador2EditText);

        botones = new Button[9];
        botones[0] = (Button) findViewById(R.id.unoButton);
        botones[1] = (Button) findViewById(R.id.dosButton);
        botones[2] = (Button) findViewById(R.id.tresButton);
        botones[3] = (Button) findViewById(R.id.cuatroButton);
        botones[4] = (Button) findViewById(R.id.cincoButton);
        botones[5] = (Button) findViewById(R.id.seisButton);
        botones[6] = (Button) findViewById(R.id.sieteButton);
        botones[7] = (Button) findViewById(R.id.ochoButton);
        botones[8] = (Button) findViewById(R.id.nueveButton);

        historialRecyclerView = (RecyclerView) findViewById(R.id.historialRecyclerView);
        historialRecyclerView.setHasFixedSize(true);
        historialRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        partidasAdapter = new PartidasAdapter();
        historialRecyclerView.setAdapter(partidasAdapter);
    }

    public void seleccionar(View view) {
        Button button = (Button) view;
        if (button.getText().toString().equals("")) {
            if (tocaX) {
                button.setText("X");
                verificarSiGano("X");

            } else {
                button.setText("O");
                verificarSiGano("O");
            }
            tocaX = !tocaX;
        }
    }

    public void verificarSiGano(String simbolo) {
        if (gano(simbolo)) {
            Toast.makeText(getApplicationContext(), "Gano " + simbolo + "!!!", Toast.LENGTH_SHORT).show();

            String nombreJugador1 = jugador1EdiText.getText().toString();
            String nombreJugador2 = jugador2EdiText.getText().toString();

            int quienGano = 0;
            if (simbolo.equals("X")) {
                quienGano = 1;
            }
            if (simbolo.equals("O")) {
                quienGano = 2;
            }

            Date fechaActual = Calendar.getInstance().getTime();

            Partida partida = new Partida(nombreJugador1, nombreJugador2, quienGano, fechaActual);

            partidasAdapter.add(partida);

            limpiar();
        }
    }

    public boolean gano(String simbolo) {

        boolean siHayGanador = false;
        //  0   1   2
        //  3   4   5
        //  6   7   8

        // Horizontales
        if (botones[0].getText().equals(simbolo) && botones[1].getText().equals(simbolo) && botones[2].getText().equals(simbolo)) {
            siHayGanador = true;
        }
        if (botones[3].getText().equals(simbolo) && botones[4].getText().equals(simbolo) && botones[5].getText().equals(simbolo)) {
            siHayGanador = true;
        }
        if (botones[6].getText().equals(simbolo) && botones[7].getText().equals(simbolo) && botones[8].getText().equals(simbolo)) {
            siHayGanador = true;
        }
        // Verticales
        if (botones[0].getText().equals(simbolo) && botones[3].getText().equals(simbolo) && botones[6].getText().equals(simbolo)) {
            siHayGanador = true;
        }
        if (botones[1].getText().equals(simbolo) && botones[4].getText().equals(simbolo) && botones[7].getText().equals(simbolo)) {
            siHayGanador = true;
        }
        if (botones[2].getText().equals(simbolo) && botones[5].getText().equals(simbolo) && botones[8].getText().equals(simbolo)) {
            siHayGanador = true;
        }
        // Diagonales
        if (botones[0].getText().equals(simbolo) && botones[4].getText().equals(simbolo) && botones[8].getText().equals(simbolo)) {
            siHayGanador = true;
        }
        if (botones[2].getText().equals(simbolo) && botones[4].getText().equals(simbolo) && botones[6].getText().equals(simbolo)) {
            siHayGanador = true;
        }

        return siHayGanador;
    }

    private void limpiar() {
        for (int i = 0; i < botones.length; i++) {
            botones[i].setText("");
        }
        tocaX = true;
    }
}
