package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class result  extends AppCompatActivity {
    ImageView im1, im2, im3,im4,im5,im6,im7,im8,im9;
    List<Integer> card;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultpenalty);
        im1 = findViewById(R.id.im1);
        im2 = findViewById(R.id.im2);
        im3 = findViewById(R.id.im3);
        im4 = findViewById(R.id.im4);
        im5 = findViewById(R.id.im5);
        im6 = findViewById(R.id.im6);
        im7 = findViewById(R.id.im7);
        im8 = findViewById(R.id.im8);
        im9 = findViewById(R.id.im9);
        init();
        onPlay();


    }

    private void onPlay() {
        Collections.shuffle(card);
        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                im1.setImageResource(setCard(card.get(0)));

            }
        });
        im2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                im2.setImageResource(setCard(card.get(1)));

            }
        });
        im3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                im3.setImageResource(setCard(card.get(2)));

            }
        });
        im4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                im4.setImageResource(setCard(card.get(5)));

            }
        });
        im5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                im5.setImageResource(setCard(card.get(6)));

            }
        });
        im6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                im6.setImageResource(setCard(card.get(3)));

            }
        });
        im7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                im7.setImageResource(setCard(card.get(4)));

            }
        });
        im8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                im8.setImageResource(setCard(card.get(7)));

            }
        });
        im9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                im9.setImageResource(setCard(card.get(8)));
            }
        });
    }

    private void init() {
        card = new ArrayList<>();
        card.add(11);
        card.add(22);
        card.add(33);
        card.add(44);
        card.add(55);
        card.add(66);
        card.add(77);
        card.add(88);
        card.add(99);
        card.add(100);
        card.add(110);
        card.add(120);
        card.add(130);
    }
    private int setCard(int bai){
        int im = 0 ;
        switch (bai){
            case 11 :
                im = R.drawable.motlybia;
                new AlertDialog.Builder(this)
                        .setTitle("Hình phạt sương sương")
                        .setMessage("Hãy uống hết 1 ly bia/rượu/rhum/...!")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(result.this, MenuGameActivity.class);
                                startActivity(intent);
                            }
                        })

                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
                break;
            case 22 :
                im = R.drawable.motchaibia;
                new AlertDialog.Builder(this)
                        .setTitle("Hình phạt sương sương")
                        .setMessage("Hãy uống hết 1 chai bia/rượu/rhum/...!")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(result.this, MenuGameActivity.class);
                                startActivity(intent);
                            }
                        })

                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
                break;
            case 33 :
                im = R.drawable.saulybia;
                new AlertDialog.Builder(this)
                        .setTitle("Hình phạt nhè nhẹ")
                        .setMessage("Hãy uống hết 6 ly bia !")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(result.this, MenuGameActivity.class);
                                startActivity(intent);
                            }
                        })

                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
                break;
            case 44 :
                im = R.drawable.motlyruou;
                new AlertDialog.Builder(this)
                        .setTitle("Hình phạt sương sương")
                        .setMessage("Hãy uống hết 1 ly rượu/bia/rhum...... !")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(result.this, MenuGameActivity.class);
                                startActivity(intent);
                            }
                        })

                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
                break;
            case 55 :
                im = R.drawable.cabancungvo;
                new AlertDialog.Builder(this)
                        .setTitle("Cả bàn cùng vui")
                        .setMessage("Cả bàn cùng vô hết mình !")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(result.this, MenuGameActivity.class);
                                startActivity(intent);
                            }
                        })

                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
                break;
            case 66 :
                im = R.drawable.sauchaibia;
                new AlertDialog.Builder(this)
                        .setTitle("Hình phạt nhè nhẹ")
                        .setMessage("Hãy uống hết 6 chai bia/ ly rhum/ ly rượu...... !")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(result.this, MenuGameActivity.class);
                                startActivity(intent);
                            }
                        })

                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
                break;
            case 77 :
                im = R.drawable.bachaibia;
                new AlertDialog.Builder(this)
                        .setTitle("Hình phạt sương sương")
                        .setMessage("Hãy uống hết 3 chai bia/ ly rhum/ ly rượu...... !")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(result.this, MenuGameActivity.class);
                                startActivity(intent);
                            }
                        })

                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
                break;
            case 88 :
                im = R.drawable.lykhong;
                new AlertDialog.Builder(this)
                        .setTitle("Chúc mừng")
                        .setMessage("Miễn uống 1 lượt !")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(result.this, MenuGameActivity.class);
                                startActivity(intent);
                            }
                        })

                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
                break;
            case 99 :
                im = R.drawable.bachaibia;
                new AlertDialog.Builder(this)
                        .setTitle("Hình phạt sương sương")
                        .setMessage("Hãy uống hết 3 chai bia/ ly rhum/ ly rượu...... !")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(result.this, MenuGameActivity.class);
                                startActivity(intent);
                            }
                        })

                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
                break;
            case 100:
                im = R.drawable.lykhong;
                new AlertDialog.Builder(this)
                        .setTitle("Chúc mừng")
                        .setMessage("Miễn uống 1 lượt !")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(result.this, MenuGameActivity.class);
                                startActivity(intent);
                            }
                        })

                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
                break;
            case 110 :
                im = R.drawable.motlyruou;
                new AlertDialog.Builder(this)
                        .setTitle("Hình phạt sương sương")
                        .setMessage("Hãy uống hết 1 ly rượu/bia/rhum...... !")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(result.this, MenuGameActivity.class);
                                startActivity(intent);
                            }
                        })

                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
                break;
            case 120 :
                im = R.drawable.motlybia;
                new AlertDialog.Builder(this)
                        .setTitle("Hình phạt sương sương")
                        .setMessage("Hãy uống hết 1 ly bia/rượu/rhum...... !")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(result.this, MenuGameActivity.class);
                                startActivity(intent);
                            }
                        })

                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
                break;
            case 130 :
                im = R.drawable.lykhong;
                new AlertDialog.Builder(this)
                        .setTitle("Chúc mừng")
                        .setMessage("Miễn uống 1 lượt !")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(result.this, MenuGameActivity.class);
                                startActivity(intent);
                            }
                        })

                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
                break;
        }
        return im;
    }

}
