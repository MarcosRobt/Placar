package com.example.marcosfilho.placar;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void changeName(View view){

        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("Vou por o esquema de trocar o nome. Calma.");
        builder1.setCancelable(true);

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }


    private void newGame(){
        TextView teamA = findViewById(R.id.time3);
        TextView teamB = findViewById(R.id.time4);

        teamA.setText("0");
        teamB.setText("0");

        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("Acabou! Vamos jogar mais uma!");
        builder1.setCancelable(true);

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

    private int getPonto(){

        TextView pontoTruco = findViewById(R.id.textView3);
        int ponto = 1;

        if(pontoTruco.getText().toString() != ""){
            ponto = Integer.parseInt(pontoTruco.getText().toString().substring(1,pontoTruco.getText().toString().length()));
            this.resetTruco();
        }

        return ponto;
    }

    private String setPonto(int placar, int ponto){

        String pontuacao = "";
        if((placar + ponto) <= 12){
            pontuacao = (placar + ponto) + "";
        }else{
            //colocar funcao pra resetar
            this.newGame();
            pontuacao = "0";
        }



        return pontuacao;
    }

    public void resetTruco(){
        TextView pontoTruco = findViewById(R.id.textView3);
        TextView textoTruco = findViewById(R.id.textView2);

        pontoTruco.setText("");
        textoTruco.setText("TRUCO!!");
    }

    public void addTeamA(View view) {

        TextView teamA = findViewById(R.id.time3);
        teamA.setText(this.setPonto(Integer.parseInt(teamA.getText().toString()), this.getPonto()));

    }

    public void addTeamB(View view) {

        TextView teamB = findViewById(R.id.time4);
        teamB.setText(this.setPonto(Integer.parseInt(teamB.getText().toString()), this.getPonto()));

    }

    public void removeTeamA(View view) {

        TextView teamA = findViewById(R.id.time3);
        int scoreTeamA = Integer.parseInt(teamA.getText().toString()) - 1;
        if(scoreTeamA > -1){
            teamA.setText(scoreTeamA+"");
        }


    }

    public void removeTeamB(View view) {

        TextView teamB = findViewById(R.id.time4);
        int scoreTeamB = Integer.parseInt(teamB.getText().toString()) - 1;
        if(scoreTeamB > -1){
            teamB.setText(scoreTeamB+"");
        }


    }

    public void trucar(View view){

        TextView pontoTruo = findViewById(R.id.textView3);
        TextView textoTruco = findViewById(R.id.textView2);
//      btnTrucar.setTextColor(Color.parseColor("FF0A4604"));

        if(pontoTruo.getText() == ""){
            pontoTruo.setText("+3");
            textoTruco.setText("SEEEEIS");
        }else if(pontoTruo.getText() == "+3"){
            pontoTruo.setText("+6");
            textoTruco.setText("NOOOVE");
        }else if(pontoTruo.getText() == "+6"){
            pontoTruo.setText("+9");
            textoTruco.setText("DOZE!!");
        }else if(pontoTruo.getText() == "+9"){
            pontoTruo.setText("+12");
            textoTruco.setText("EITA");
        }


    }
}
