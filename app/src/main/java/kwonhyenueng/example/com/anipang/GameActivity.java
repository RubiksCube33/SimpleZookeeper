package kwonhyenueng.example.com.anipang;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

import static java.lang.Integer.parseInt;

public class GameActivity extends AppCompatActivity {

    int x = 10, y = 10;
    Random rand = new Random();
    Button gamepan[][];
    TextView counting[];
    boolean click = false;
    int value = 100;
    TextView TV7;
    EditText name;
    private final String FILE_NAME = "score.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameactivity);

        TV7 = findViewById(R.id.textView7);

        mHandler.sendEmptyMessage(0);

        gamepan = new Button[8][8];
        counting = new TextView[8];
        int[][] BID = {{R.id.BT00, R.id.BT01, R.id.BT02, R.id.BT03, R.id.BT04, R.id.BT05, R.id.BT06, R.id.BT07},
                {R.id.BT10, R.id.BT11, R.id.BT12, R.id.BT13, R.id.BT14, R.id.BT15, R.id.BT16, R.id.BT17},
                {R.id.BT20, R.id.BT21, R.id.BT22, R.id.BT23, R.id.BT24, R.id.BT25, R.id.BT26, R.id.BT27},
                {R.id.BT30, R.id.BT31, R.id.BT32, R.id.BT33, R.id.BT34, R.id.BT35, R.id.BT36, R.id.BT37},
                {R.id.BT40, R.id.BT41, R.id.BT42, R.id.BT43, R.id.BT44, R.id.BT45, R.id.BT46, R.id.BT47},
                {R.id.BT50, R.id.BT51, R.id.BT52, R.id.BT53, R.id.BT54, R.id.BT55, R.id.BT56, R.id.BT57},
                {R.id.BT60, R.id.BT61, R.id.BT62, R.id.BT63, R.id.BT64, R.id.BT65, R.id.BT66, R.id.BT67},
                {R.id.BT70, R.id.BT71, R.id.BT72, R.id.BT73, R.id.BT74, R.id.BT75, R.id.BT76, R.id.BT77}};
        int[] count = {R.id.TV0, R.id.TV1, R.id.TV2, R.id.TV3, R.id.TV4, R.id.TV5, R.id.TV6};

        for (int i = 0; i < 8; i++) {
            if(i < 7) {
                counting[i] = (TextView) findViewById(count[i]);
            }
            for (int j = 0; j < 8; j++) {
                gamepan[i][j] = (Button) findViewById(BID[i][j]);
            }
        }


        initalize();
        for(int i = 0; i < 7; i++){
            counting[i].setText("0");
        }
    }

    //종료버튼 눌렀을때
    public void Gameset(View V) {
        value = 1;
    }

    public void Gameover(){
        int temp = 0;
        for (int i = 0; i < 7; i++){
            temp = temp + parseInt(counting[i].getText().toString());
        }
        LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
        View DialogView = (View) layoutInflater.inflate(R.layout.dialog, null);

        TextView jeomsu = (TextView) DialogView.findViewById(R.id.jeomsu);
        jeomsu.setText("" + temp);

        AlertDialog.Builder Builder = new AlertDialog.Builder(this);
        Builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        Builder.setNegativeButton("닫기", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        Builder.setTitle("게임 결과");
        Builder.setView(DialogView);

        Builder.create().show();
    }


    Handler mHandler = new Handler() {
        public void handleMessage(Message msg){
            value--;
            TV7.setText("남은시간 : " + value + "초");
            if (value > 0) {
                mHandler.sendEmptyMessageDelayed(0, 1000);
            }
            else {
                mHandler.sendEmptyMessageDelayed(2100000000, 2100000000);
                TV7.setText("게임 종료");
                Gameover();
            }
        }
    };

    public void onBT00(View v) {
        if (click) {
            if ((x == 0) && (y == 0)) {
                setBackgroundColorWhite();
            } else {
                setBackgroundColorWhite();
                gamechanger(0, 0);
            }
            click = false;
            x = 10;
            y = 10;
        } else {
            x = 0;
            y = 0;
            Setbackgroundred();
            click = true;
        }
    }

    public void onBT01(View v) {
        if (click) {
            if ((x == 0) && (y == 1)) {
                setBackgroundColorWhite();
            } else {
                setBackgroundColorWhite();
                gamechanger(0, 1);
            }
            click = false;
            x = 10;
            y = 10;
        } else {
            x = 0;
            y = 1;
            Setbackgroundred();
            click = true;
        }
    }

    public void onBT02(View v) {
        if (click) {
            if ((x == 0) && (y == 2)) {
                setBackgroundColorWhite();
            } else {
                setBackgroundColorWhite();
                gamechanger(0, 2);
            }
            click = false;
            x = 10;
            y = 10;
        } else {
            x = 0;
            y = 2;
            Setbackgroundred();
            click = true;
        }
    }

    public void onBT03(View v) {
        if (click) {
            if ((x == 0) && (y == 3)) {
                setBackgroundColorWhite();
            } else {
                setBackgroundColorWhite();
                gamechanger(0, 3);
            }
            click = false;
            x = 10;
            y = 10;
        } else {
            x = 0;
            y = 3;
            Setbackgroundred();
            click = true;
        }
    }

    public void onBT04(View v) {
        if (click) {
            if ((x == 0) && (y == 4)) {
                setBackgroundColorWhite();
            } else {
                setBackgroundColorWhite();
                gamechanger(0, 4);
            }
            click = false;
            x = 10;
            y = 10;
        } else {
            x = 0;
            y = 4;
            Setbackgroundred();
            click = true;
        }
    }

    public void onBT05(View v) {
        if (click) {
            if ((x == 0) && (y == 5)) {
                setBackgroundColorWhite();
            } else {
                setBackgroundColorWhite();
                gamechanger(0, 5);
            }
            click = false;
            x = 10;
            y = 10;
        } else {
            x = 0;
            y = 5;
            Setbackgroundred();
            click = true;
        }
    }

    public void onBT06(View v) {
        if (click) {
            if ((x == 0) && (y == 6)) {
                setBackgroundColorWhite();
            } else {
                setBackgroundColorWhite();
                gamechanger(0, 6);
            }
            click = false;
            x = 10;
            y = 10;
        } else {
            x = 0;
            y = 6;
            Setbackgroundred();
            click = true;
        }
    }

    public void onBT07(View v) {
        if (click) {
            if ((x == 0) && (y == 7)) {
                setBackgroundColorWhite();
            } else {
                setBackgroundColorWhite();
                gamechanger(0, 7);
            }
            click = false;
            x = 10;
            y = 10;
        } else {
            x = 0;
            y = 7;
            Setbackgroundred();
            click = true;
        }
    }

    public void onBT10(View v) {
        if (click) {
            if ((x == 1) && (y == 0)) {
                setBackgroundColorWhite();
            } else {
                setBackgroundColorWhite();
                gamechanger(1, 0);
            }
            click = false;
            x = 10;
            y = 10;
        } else {
            x = 1;
            y = 0;
            Setbackgroundred();
            click = true;
        }
    }

    public void onBT11(View v) {
        if (click) {
            if ((x == 1) && (y == 1)) {
                setBackgroundColorWhite();
            } else {
                setBackgroundColorWhite();
                gamechanger(1, 1);
            }
            click = false;
            x = 10;
            y = 10;
        } else {
            x = 1;
            y = 1;
            Setbackgroundred();
            click = true;
        }
    }

    public void onBT12(View v) {
        if (click) {
            if ((x == 1) && (y == 2)) {
                setBackgroundColorWhite();
            } else {
                setBackgroundColorWhite();
                gamechanger(1, 2);
            }
            click = false;
            x = 10;
            y = 10;
        } else {
            x = 1;
            y = 2;
            Setbackgroundred();
            click = true;
        }
    }

    public void onBT13(View v) {
        if (click) {
            if ((x == 1) && (y == 3)) {
                setBackgroundColorWhite();
            } else {
                setBackgroundColorWhite();
                gamechanger(1, 3);
            }
            click = false;
            x = 10;
            y = 10;
        } else {
            x = 1;
            y = 3;
            Setbackgroundred();
            click = true;
        }
    }

    public void onBT14(View v) {
        if (click) {
            if ((x == 1) && (y == 4)) {
                setBackgroundColorWhite();
            } else {
                setBackgroundColorWhite();
                gamechanger(1, 4);
            }
            click = false;
            x = 10;
            y = 10;
        } else {
            x = 1;
            y = 4;
            Setbackgroundred();
            click = true;
        }
    }

    public void onBT15(View v) {
        if (click) {
            if ((x == 1) && (y == 5)) {
                setBackgroundColorWhite();
            } else {
                setBackgroundColorWhite();
                gamechanger(1, 5);
            }
            click = false;
            x = 10;
            y = 10;
        } else {
            x = 1;
            y = 5;
            Setbackgroundred();
            click = true;
        }
    }

    public void onBT16(View v) {
        if (click) {
            if ((x == 1) && (y == 6)) {
                setBackgroundColorWhite();
            } else {
                setBackgroundColorWhite();
                gamechanger(1, 6);
            }
            click = false;
            x = 10;
            y = 10;
        } else {
            x = 1;
            y = 6;
            Setbackgroundred();
            click = true;
        }
    }

    public void onBT17(View v) {
        if (click) {
            if ((x == 1) && (y == 7)) {
                setBackgroundColorWhite();
            } else {
                setBackgroundColorWhite();
                gamechanger(1, 7);
            }
            click = false;
            x = 10;
            y = 10;
        } else {
            x = 1;
            y = 7;
            Setbackgroundred();
            click = true;
        }
    }

    public void onBT20(View v) {
        if (click) {
            if ((x == 2) && (y == 0)) {
                setBackgroundColorWhite();
            } else {
                setBackgroundColorWhite();
                gamechanger(2, 0);
            }
            click = false;
            x = 10;
            y = 10;
        } else {
            x = 2;
            y = 0;
            Setbackgroundred();
            click = true;
        }
    }

    public void onBT21(View v) {
        if (click) {
            if ((x == 2) && (y == 1)) {
                setBackgroundColorWhite();
            } else {
                setBackgroundColorWhite();
                gamechanger(2, 1);
            }
            click = false;
            x = 10;
            y = 10;
        } else {
            x = 2;
            y = 1;
            Setbackgroundred();
            click = true;
        }
    }

    public void onBT22(View v) {
        if (click) {
            if ((x == 2) && (y == 2)) {
                setBackgroundColorWhite();
            } else {
                setBackgroundColorWhite();
                gamechanger(2, 2);
            }
            click = false;
            x = 10;
            y = 10;
        } else {
            x = 2;
            y = 2;
            Setbackgroundred();
            click = true;
        }
    }

    public void onBT23(View v) {
        if (click) {
            if ((x == 2) && (y == 3)) {
                setBackgroundColorWhite();
            } else {
                setBackgroundColorWhite();
                gamechanger(2, 3);
            }
            click = false;
            x = 10;
            y = 10;
        } else {
            x = 2;
            y = 3;
            Setbackgroundred();
            click = true;
        }
    }

    public void onBT24(View v) {
        if (click) {
            if ((x == 2) && (y == 4)) {
                setBackgroundColorWhite();
            } else {
                setBackgroundColorWhite();
                gamechanger(2, 4);
            }
            click = false;
            x = 10;
            y = 10;
        } else {
            x = 2;
            y = 4;
            Setbackgroundred();
            click = true;
        }
    }

    public void onBT25(View v) {
        if (click) {
            if ((x == 2) && (y == 5)) {
                setBackgroundColorWhite();
            } else {
                setBackgroundColorWhite();
                gamechanger(2, 5);
            }
            click = false;
            x = 10;
            y = 10;
        } else {
            x = 2;
            y = 5;
            Setbackgroundred();
            click = true;
        }
    }

    public void onBT26(View v) {
        if (click) {
            if ((x == 2) && (y == 6)) {
                setBackgroundColorWhite();
            } else {
                setBackgroundColorWhite();
                gamechanger(2, 6);
            }
            click = false;
            x = 10;
            y = 10;
        } else {
            x = 2;
            y = 6;
            Setbackgroundred();
            click = true;
        }
    }

    public void onBT27(View v) {
        if (click) {
            if ((x == 2) && (y == 7)) {
                setBackgroundColorWhite();
            } else {
                setBackgroundColorWhite();
                gamechanger(2, 7);
            }
            click = false;
            x = 10;
            y = 10;
        } else {
            x = 2;
            y = 7;
            Setbackgroundred();
            click = true;
        }
    }

    public void onBT30(View v) {
        if (click) {
            if ((x == 3) && (y == 0)) {
                setBackgroundColorWhite();
            } else {
                setBackgroundColorWhite();
                gamechanger(3, 0);
            }
            click = false;
            x = 10;
            y = 10;
        } else {
            x = 3;
            y = 0;
            Setbackgroundred();
            click = true;
        }
    }

    public void onBT31(View v) {
        if (click) {
            if ((x == 3) && (y == 1)) {
                setBackgroundColorWhite();
            } else {
                setBackgroundColorWhite();
                gamechanger(3, 1);
            }
            click = false;
            x = 10;
            y = 10;
        } else {
            x = 3;
            y = 1;
            Setbackgroundred();
            click = true;
        }
    }

    public void onBT32(View v) {
        if (click) {
            if ((x == 3) && (y == 2)) {
                setBackgroundColorWhite();
            } else {
                setBackgroundColorWhite();
                gamechanger(3, 2);
            }
            click = false;
            x = 10;
            y = 10;
        } else {
            x = 3;
            y = 2;
            Setbackgroundred();
            click = true;
        }
    }

    public void onBT33(View v) {
        if (click) {
            if ((x == 3) && (y == 3)) {
                setBackgroundColorWhite();
            } else {
                setBackgroundColorWhite();
                gamechanger(3, 3);
            }
            click = false;
            x = 10;
            y = 10;
        } else {
            x = 3;
            y = 3;
            Setbackgroundred();
            click = true;
        }
    }

    public void onBT34(View v) {
        if (click) {
            if ((x == 3) && (y == 4)) {
                setBackgroundColorWhite();
            } else {
                setBackgroundColorWhite();
                gamechanger(3, 4);
            }
            click = false;
            x = 10;
            y = 10;
        } else {
            x = 3;
            y = 4;
            Setbackgroundred();
            click = true;
        }
    }

    public void onBT35(View v) {
        if (click) {
            if ((x == 3) && (y == 5)) {
                setBackgroundColorWhite();
            } else {
                setBackgroundColorWhite();
                gamechanger(3, 5);
            }
            click = false;
            x = 10;
            y = 10;
        } else {
            x = 3;
            y = 5;
            Setbackgroundred();
            click = true;
        }
    }

    public void onBT36(View v) {
        if (click) {
            if ((x == 3) && (y == 6)) {
                setBackgroundColorWhite();
            } else {
                setBackgroundColorWhite();
                gamechanger(3, 6);
            }
            click = false;
            x = 10;
            y = 10;
        } else {
            x = 3;
            y = 6;
            Setbackgroundred();
            click = true;
        }
    }

    public void onBT37(View v) {
        if (click) {
            if ((x == 3) && (y == 7)) {
                setBackgroundColorWhite();
            } else {
                setBackgroundColorWhite();
                gamechanger(3, 7);
            }
            click = false;
            x = 10;
            y = 10;
        } else {
            x = 3;
            y = 7;
            Setbackgroundred();
            click = true;
        }
    }

    public void onBT40(View v) {
        if (click) {
            if ((x == 4) && (y == 0)) {
                setBackgroundColorWhite();
            } else {
                setBackgroundColorWhite();
                gamechanger(4, 0);
            }
            click = false;
            x = 10;
            y = 10;
        } else {
            x = 4;
            y = 0;
            Setbackgroundred();
            click = true;
        }
    }

    public void onBT41(View v) {
        if (click) {
            if ((x == 4) && (y == 1)) {
                setBackgroundColorWhite();
            } else {
                setBackgroundColorWhite();
                gamechanger(4, 1);
            }
            click = false;
            x = 10;
            y = 10;
        } else {
            x = 4;
            y = 1;
            Setbackgroundred();
            click = true;
        }
    }

    public void onBT42(View v) {
        if (click) {
            if ((x == 4) && (y == 2)) {
                setBackgroundColorWhite();
            } else {
                setBackgroundColorWhite();
                gamechanger(4, 2);
            }
            click = false;
            x = 10;
            y = 10;
        } else {
            x = 4;
            y = 2;
            Setbackgroundred();
            click = true;
        }
    }

    public void onBT43(View v) {
        if (click) {
            if ((x == 4) && (y == 3)) {
                setBackgroundColorWhite();
            } else {
                setBackgroundColorWhite();
                gamechanger(4, 3);
            }
            click = false;
            x = 10;
            y = 10;
        } else {
            x = 4;
            y = 3;
            Setbackgroundred();
            click = true;
        }
    }

    public void onBT44(View v) {
        if (click) {
            if ((x == 4) && (y == 4)) {
                setBackgroundColorWhite();
            } else {
                setBackgroundColorWhite();
                gamechanger(4, 4);
            }
            click = false;
            x = 10;
            y = 10;
        } else {
            x = 4;
            y = 4;
            Setbackgroundred();
            click = true;
        }
    }

    public void onBT45(View v) {
        if (click) {
            if ((x == 4) && (y == 5)) {
                setBackgroundColorWhite();
            } else {
                setBackgroundColorWhite();
                gamechanger(4, 5);
            }
            click = false;
            x = 10;
            y = 10;
        } else {
            x = 4;
            y = 5;
            Setbackgroundred();
            click = true;
        }
    }

    public void onBT46(View v) {
        if (click) {
            if ((x == 4) && (y == 6)) {
                setBackgroundColorWhite();
            } else {
                setBackgroundColorWhite();
                gamechanger(4, 6);
            }
            click = false;
            x = 10;
            y = 10;
        } else {
            x = 4;
            y = 6;
            Setbackgroundred();
            click = true;
        }
    }

    public void onBT47(View v) {
        if (click) {
            if ((x == 4) && (y == 7)) {
                setBackgroundColorWhite();
            } else {
                setBackgroundColorWhite();
                gamechanger(4, 7);
            }
            click = false;
            x = 10;
            y = 10;
        } else {
            x = 4;
            y = 7;
            Setbackgroundred();
            click = true;
        }
    }

    public void onBT50(View v) {
        if (click) {
            if ((x == 5) && (y == 0)) {
                setBackgroundColorWhite();
            } else {
                setBackgroundColorWhite();
                gamechanger(5, 0);
            }
            click = false;
            x = 10;
            y = 10;
        } else {
            x = 5;
            y = 0;
            Setbackgroundred();
            click = true;
        }
    }

    public void onBT51(View v) {
        if (click) {
            if ((x == 5) && (y == 1)) {
                setBackgroundColorWhite();
            } else {
                setBackgroundColorWhite();
                gamechanger(5, 1);
            }
            click = false;
            x = 10;
            y = 10;
        } else {
            x = 5;
            y = 1;
            Setbackgroundred();
            click = true;
        }
    }

    public void onBT52(View v) {
        if (click) {
            if ((x == 5) && (y == 2)) {
                setBackgroundColorWhite();
            } else {
                setBackgroundColorWhite();
                gamechanger(5, 2);
            }
            click = false;
            x = 10;
            y = 10;
        } else {
            x = 5;
            y = 2;
            Setbackgroundred();
            click = true;
        }
    }

    public void onBT53(View v) {
        if (click) {
            if ((x == 5) && (y == 3)) {
                setBackgroundColorWhite();
            } else {
                setBackgroundColorWhite();
                gamechanger(5, 3);
            }
            click = false;
            x = 10;
            y = 10;
        } else {
            x = 5;
            y = 3;
            Setbackgroundred();
            click = true;
        }
    }

    public void onBT54(View v) {
        if (click) {
            if ((x == 5) && (y == 4)) {
                setBackgroundColorWhite();
            } else {
                setBackgroundColorWhite();
                gamechanger(5, 4);
            }
            click = false;
            x = 10;
            y = 10;
        } else {
            x = 5;
            y = 4;
            Setbackgroundred();
            click = true;
        }
    }

    public void onBT55(View v) {
        if (click) {
            if ((x == 5) && (y == 5)) {
                setBackgroundColorWhite();
            } else {
                setBackgroundColorWhite();
                gamechanger(5, 5);
            }
            click = false;
            x = 10;
            y = 10;
        } else {
            x = 5;
            y = 5;
            Setbackgroundred();
            click = true;
        }
    }

    public void onBT56(View v) {
        if (click) {
            if ((x == 5) && (y == 6)) {
                setBackgroundColorWhite();
            } else {
                setBackgroundColorWhite();
                gamechanger(5, 6);
            }
            click = false;
            x = 10;
            y = 10;
        } else {
            x = 5;
            y = 6;
            Setbackgroundred();
            click = true;
        }
    }

    public void onBT57(View v) {
        if (click) {
            if ((x == 5) && (y == 7)) {
                setBackgroundColorWhite();
            } else {
                setBackgroundColorWhite();
                gamechanger(5, 7);
            }
            click = false;
            x = 10;
            y = 10;
        } else {
            x = 5;
            y = 7;
            Setbackgroundred();
            click = true;
        }
    }

    public void onBT60(View v) {
        if (click) {
            if ((x == 6) && (y == 0)) {
                setBackgroundColorWhite();
            } else {
                setBackgroundColorWhite();
                gamechanger(6, 0);
            }
            click = false;
            x = 10;
            y = 10;
        } else {
            x = 6;
            y = 0;
            Setbackgroundred();
            click = true;
        }
    }

    public void onBT61(View v) {
        if (click) {
            if ((x == 6) && (y == 1)) {
                setBackgroundColorWhite();
            } else {
                setBackgroundColorWhite();
                gamechanger(6, 1);
            }
            click = false;
            x = 10;
            y = 10;
        } else {
            x = 6;
            y = 1;
            Setbackgroundred();
            click = true;
        }
    }

    public void onBT62(View v) {
        if (click) {
            if ((x == 6) && (y == 2)) {
                setBackgroundColorWhite();
            } else {
                setBackgroundColorWhite();
                gamechanger(6, 2);
            }
            click = false;
            x = 10;
            y = 10;
        } else {
            x = 6;
            y = 2;
            Setbackgroundred();
            click = true;
        }
    }

    public void onBT63(View v) {
        if (click) {
            if ((x == 6) && (y == 3)) {
                setBackgroundColorWhite();
            } else {
                setBackgroundColorWhite();
                gamechanger(6, 3);
            }
            click = false;
            x = 10;
            y = 10;
        } else {
            x = 6;
            y = 3;
            Setbackgroundred();
            click = true;
        }
    }

    public void onBT64(View v) {
        if (click) {
            if ((x == 6) && (y == 4)) {
                setBackgroundColorWhite();
            } else {
                setBackgroundColorWhite();
                gamechanger(6, 4);
            }
            click = false;
            x = 10;
            y = 10;
        } else {
            x = 6;
            y = 4;
            Setbackgroundred();
            click = true;
        }
    }

    public void onBT65(View v) {
        if (click) {
            if ((x == 6) && (y == 5)) {
                setBackgroundColorWhite();
            } else {
                setBackgroundColorWhite();
                gamechanger(6, 5);
            }
            click = false;
            x = 10;
            y = 10;
        } else {
            x = 6;
            y = 5;
            Setbackgroundred();
            click = true;
        }
    }

    public void onBT66(View v) {
        if (click) {
            if ((x == 6) && (y == 6)) {
                setBackgroundColorWhite();
            } else {
                setBackgroundColorWhite();
                gamechanger(6, 6);
            }
            click = false;
            x = 10;
            y = 10;
        } else {
            x = 6;
            y = 6;
            Setbackgroundred();
            click = true;
        }
    }

    public void onBT67(View v) {
        if (click) {
            if ((x == 6) && (y == 7)) {
                setBackgroundColorWhite();
            } else {
                setBackgroundColorWhite();
                gamechanger(6, 7);
            }
            click = false;
            x = 10;
            y = 10;
        } else {
            x = 6;
            y = 7;
            Setbackgroundred();
            click = true;
        }
    }

    public void onBT70(View v) {
        if (click) {
            if ((x == 7) && (y == 0)) {
                setBackgroundColorWhite();
            } else {
                setBackgroundColorWhite();
                gamechanger(7, 0);
            }
            click = false;
            x = 10;
            y = 10;
        } else {
            x = 7;
            y = 0;
            Setbackgroundred();
            click = true;
        }
    }

    public void onBT71(View v) {
        if (click) {
            if ((x == 7) && (y == 1)) {
                setBackgroundColorWhite();
            } else {
                setBackgroundColorWhite();
                gamechanger(7, 1);
            }
            click = false;
            x = 10;
            y = 10;
        } else {
            x = 7;
            y = 1;
            Setbackgroundred();
            click = true;
        }
    }

    public void onBT72(View v) {
        if (click) {
            if ((x == 7) && (y == 2)) {
                setBackgroundColorWhite();
            } else {
                setBackgroundColorWhite();
                gamechanger(7, 2);
            }
            click = false;
            x = 10;
            y = 10;
        } else {
            x = 7;
            y = 2;
            Setbackgroundred();
            click = true;
        }
    }

    public void onBT73(View v) {
        if (click) {
            if ((x == 7) && (y == 3)) {
                setBackgroundColorWhite();
            } else {
                setBackgroundColorWhite();
                gamechanger(7, 3);
            }
            click = false;
            x = 10;
            y = 10;
        } else {
            x = 7;
            y = 3;
            Setbackgroundred();
            click = true;
        }
    }

    public void onBT74(View v) {
        if (click) {
            if ((x == 7) && (y == 4)) {
                setBackgroundColorWhite();
            } else {
                setBackgroundColorWhite();
                gamechanger(7, 4);
            }
            click = false;
            x = 10;
            y = 10;
        } else {
            x = 7;
            y = 4;
            Setbackgroundred();
            click = true;
        }
    }

    public void onBT75(View v) {
        if (click) {
            if ((x == 7) && (y == 5)) {
                setBackgroundColorWhite();
            } else {
                setBackgroundColorWhite();
                gamechanger(7, 5);
            }
            click = false;
            x = 10;
            y = 10;
        } else {
            x = 7;
            y = 5;
            Setbackgroundred();
            click = true;
        }
    }

    public void onBT76(View v) {
        if (click) {
            if ((x == 7) && (y == 6)) {
                setBackgroundColorWhite();
            } else {
                setBackgroundColorWhite();
                gamechanger(7, 6);
            }
            click = false;
            x = 10;
            y = 10;
        } else {
            x = 7;
            y = 6;
            Setbackgroundred();
            click = true;
        }
    }

    public void onBT77(View v) {
        if (click) {
            if ((x == 7) && (y == 7)) {
                setBackgroundColorWhite();
            } else {
                setBackgroundColorWhite();
                gamechanger(7, 7);
            }
            click = false;
            x = 10;
            y = 10;
        } else {
            x = 7;
            y = 7;
            Setbackgroundred();
            click = true;
        }
    }


    public void gamechanger(int x_axis, int y_axis) {
        int temp = ((x_axis - x) * (x_axis - x)) + ((y_axis - y) * (y_axis - y));
        if (temp > 1) {
            x = 10;
            y = 10;
        } else {
            temp = parseInt(gamepan[x_axis][y_axis].getText().toString());
            gamepan[x_axis][y_axis].setText("" + gamepan[x][y].getText().toString());
            gamepan[x][y].setText("" + temp);

            int garodistance = -1, serodistance = -1;
            int garo_x = -1, garo_y = -1, sero_x = -1, sero_y = -1;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if((j < 7)&&(garodistance < 0)) {
                        if (gamepan[i][j].getText().toString().equals(gamepan[i][j + 1].getText().toString())) {
                            if (j == 6) ;
                            else if (gamepan[i][j].getText().toString().equals(gamepan[i][j + 2].getText().toString())) {
                                garodistance = 3;
                                garo_x = i;
                                garo_y = j;
                                if (j == 5) ;
                                else if (gamepan[i][j].getText().toString().equals(gamepan[i][j + 3].getText().toString())) {
                                    garodistance = 4;
                                    if (j == 4) ;
                                    else if (gamepan[i][j].getText().toString().equals(gamepan[i][j + 4].getText().toString())) {
                                        garodistance = 5;
                                        if (j == 3) ;
                                        else if (gamepan[i][j].getText().toString().equals(gamepan[i][j + 5].getText().toString())) {
                                            garodistance = 6;
                                        }
                                    }
                                }
                            }
                        }
                    }

                    if((i < 7)&&(serodistance < 0)) {
                        if (gamepan[i][j].getText().toString().equals(gamepan[i + 1][j].getText().toString())) {
                            if (i == 6) ;
                            else if (gamepan[i][j].getText().toString().equals(gamepan[i + 2][j].getText().toString())) {
                                serodistance = 3;
                                sero_x = i;
                                sero_y = j;
                                if (i == 5) ;
                                else if (gamepan[i][j].getText().toString().equals(gamepan[i + 3][j].getText().toString())) {
                                    serodistance = 4;
                                    if (i == 4) ;
                                    else if (gamepan[i][j].getText().toString().equals(gamepan[i + 4][j].getText().toString())) {
                                        serodistance = 5;
                                        if (i == 3) ;
                                        else if (gamepan[i][j].getText().toString().equals(gamepan[i + 5][j].getText().toString())) {
                                            serodistance = 6;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if((garodistance > 0) || (serodistance > 0)){
                pang(garodistance, serodistance, garo_x, garo_y, sero_x, sero_y);
            }
            else {
                temp = parseInt(gamepan[x_axis][y_axis].getText().toString());
                gamepan[x_axis][y_axis].setText("" + gamepan[x][y].getText().toString());
                gamepan[x][y].setText("" + temp);
            }
        }
    }

    public void panjeong() {
        int garodistance = -1, serodistance = -1;
        int garo_x = -1, garo_y = -1, sero_x = -1, sero_y = -1;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if((j < 7)&&(garodistance < 0)) {
                    if (gamepan[i][j].getText().toString().equals(gamepan[i][j + 1].getText().toString())) {
                        if (j == 6) ;
                        else if (gamepan[i][j].getText().toString().equals(gamepan[i][j + 2].getText().toString())) {
                            garodistance = 3;
                            garo_x = i;
                            garo_y = j;
                            if (j == 5) ;
                            else if (gamepan[i][j].getText().toString().equals(gamepan[i][j + 3].getText().toString())) {
                                garodistance = 4;
                                if (j == 4) ;
                                else if (gamepan[i][j].getText().toString().equals(gamepan[i][j + 4].getText().toString())) {
                                    garodistance = 5;
                                    if (j == 3) ;
                                    else if (gamepan[i][j].getText().toString().equals(gamepan[i][j + 5].getText().toString())) {
                                        garodistance = 6;
                                    }
                                }
                            }
                        }
                    }
                }

                if((i < 7)&&(serodistance < 0)) {
                    if (gamepan[i][j].getText().toString().equals(gamepan[i + 1][j].getText().toString())) {
                        if (i == 6) ;
                        else if (gamepan[i][j].getText().toString().equals(gamepan[i + 2][j].getText().toString())) {
                            serodistance = 3;
                            sero_x = i;
                            sero_y = j;
                            if (i == 5) ;
                            else if (gamepan[i][j].getText().toString().equals(gamepan[i + 3][j].getText().toString())) {
                                serodistance = 4;
                                if (i == 4) ;
                                else if (gamepan[i][j].getText().toString().equals(gamepan[i + 4][j].getText().toString())) {
                                    serodistance = 5;
                                    if (i == 3) ;
                                    else if (gamepan[i][j].getText().toString().equals(gamepan[i + 5][j].getText().toString())) {
                                        serodistance = 6;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        pang(garodistance, serodistance, garo_x, garo_y, sero_x, sero_y);
    }

    public void pang(int garodistance, int serodistance, int garo_x, int garo_y, int sero_x, int sero_y) {
        boolean isPang = false;
        if (garodistance >= 3) {
            for (int i = garo_y; i < garo_y + garodistance; i++) {
                if ((parseInt(gamepan[garo_x][i].getText().toString())) != (-1)) {
                    counting[parseInt(gamepan[garo_x][i].getText().toString())].setText("" + (parseInt(counting[parseInt(gamepan[garo_x][i].getText().toString())].getText().toString()) + 1));
                    gamepan[garo_x][i].setText("-1");
                }
                isPang = true;
            }
        }

        if (serodistance >= 3) {
            for (int i = sero_x; i < sero_x + serodistance; i++) {
                if ((parseInt(gamepan[i][sero_y].getText().toString())) != (-1)) {
                    counting[parseInt(gamepan[i][sero_y].getText().toString())].setText("" + (parseInt(counting[parseInt(gamepan[i][sero_y].getText().toString())].getText().toString()) + 1));
                    gamepan[i][sero_y].setText("-1");
                    }
            }
                isPang = true;
        }

        if (isPang) panset();
        else{
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    switch (parseInt(gamepan[i][j].getText().toString())){
                        case 0 :
                            gamepan[i][j].setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.img1));
                            break;
                        case 1 :
                            gamepan[i][j].setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.img2));
                            break;
                        case 2 :
                            gamepan[i][j].setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.img3));
                            break;
                        case 3 :
                            gamepan[i][j].setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.img4));
                            break;
                        case 4 :
                            gamepan[i][j].setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.img5));
                            break;
                        case 5 :
                            gamepan[i][j].setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.img6));
                            break;
                        case 6 :
                            gamepan[i][j].setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.img7));
                            break;
                    }
                }
            }
        }
    }


    public void initalize() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                int temp = rand.nextInt() % 7;
                if (temp < 0) temp = temp * -1;
                switch (temp){
                    case 0 :
                        gamepan[i][j].setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.img1));
                        break;
                    case 1 :
                        gamepan[i][j].setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.img2));
                        break;
                    case 2 :
                        gamepan[i][j].setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.img3));
                        break;
                    case 3 :
                        gamepan[i][j].setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.img4));
                        break;
                    case 4 :
                        gamepan[i][j].setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.img5));
                        break;
                    case 5 :
                        gamepan[i][j].setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.img6));
                        break;
                    case 6 :
                        gamepan[i][j].setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.img7));
                        break;
                }
                gamepan[i][j].setText("" + temp);

            }
        }
        panjeong();

    }

    public void panset() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (gamepan[i][j].getText().toString().equals("-1")) {
                    for (int k = i; k > 0; k--) {
                        gamepan[k][j].setText("" + (gamepan[k - 1][j].getText().toString()));
                    }
                    gamepan[0][j].setText("-1");
                }
            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (gamepan[i][j].getText().toString().equals("-1")) {
                    int temp = rand.nextInt() % 7;
                    if (temp < 0) temp = temp * -1;
                    gamepan[i][j].setText("" + temp);

                    switch (parseInt(gamepan[i][j].getText().toString())){
                        case 0 :
                            gamepan[i][j].setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.img1));
                            break;
                        case 1 :
                            gamepan[i][j].setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.img2));
                            break;
                        case 2 :
                            gamepan[i][j].setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.img3));
                            break;
                        case 3 :
                            gamepan[i][j].setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.img4));
                            break;
                        case 4 :
                            gamepan[i][j].setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.img5));
                            break;
                        case 5 :
                            gamepan[i][j].setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.img6));
                            break;
                        case 6 :
                            gamepan[i][j].setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.img7));
                            break;
                    }
                }
            }
        }
        panjeong();
    }

    public void Setbackgroundred(){
        switch (parseInt(gamepan[x][y].getText().toString())){
            case 0 :
                gamepan[x][y].setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.img1c));
                break;
            case 1 :
                gamepan[x][y].setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.img2c));
                break;
            case 2 :
                gamepan[x][y].setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.img3c));
                break;
            case 3 :
                gamepan[x][y].setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.img4c));
                break;
            case 4 :
                gamepan[x][y].setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.img5c));
                break;
            case 5 :
                gamepan[x][y].setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.img6c));
                break;
            case 6 :
                gamepan[x][y].setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.img7c));
                break;
        }
    }

    public void setBackgroundColorWhite(){
        switch (parseInt(gamepan[x][y].getText().toString())){
            case 0 :
                gamepan[x][y].setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.img1));
                break;
            case 1 :
                gamepan[x][y].setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.img2));
                break;
            case 2 :
                gamepan[x][y].setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.img3));
                break;
            case 3 :
                gamepan[x][y].setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.img4));
                break;
            case 4 :
                gamepan[x][y].setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.img5));
                break;
            case 5 :
                gamepan[x][y].setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.img6));
                break;
            case 6 :
                gamepan[x][y].setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.img7));
                break;
        }
    }

}
