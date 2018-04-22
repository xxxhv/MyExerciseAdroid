package com.none.w2048;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    int image[] = new int[]{
            R.drawable.im,
            R.drawable.p1,
            R.drawable.p3,
            R.drawable.p4,
            R.drawable.p5,
            R.drawable.p6,
            R.drawable.p7,
            R.drawable.p8,
            R.drawable.p9,
            R.drawable.p10,
            R.drawable.p11,
            R.drawable.in,
            R.drawable.ib,
            R.drawable.iv,
            R.drawable.ic
    };
    int count = 0;
    Random rand=new Random();
    private Button bb,bup,bdown,blift,bright;

    public int[][] a=new int[][]{
            { R.id.i11,R.id.i12,R.id.i13,R.id.i14,R.id.i15,},
            { R.id.i21,R.id.i22,R.id.i23,R.id.i24,R.id.i25,},
            { R.id.i31,R.id.i32,R.id.i33,R.id.i34,R.id.i35,},
            { R.id.i41,R.id.i42,R.id.i43,R.id.i44,R.id.i45,},
            { R.id.i51,R.id.i52,R.id.i53,R.id.i54,R.id.i55,},
    };
    public ImageView[][] ivvv=new ImageView[5][5];
    //图片id ---> ivvv数组

    private  game g;











    public int raaa(){
        int iasd=Math.abs(rand.nextInt())%4;
        return iasd;
    }
    public void initivvv(){
        //图片id ---> ivvv数组
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                ivvv[i][j] = (ImageView) findViewById(a[i][j]);
            }
        }
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                ivvv[i][j].setImageResource(image[raaa()]);
            }
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bb = (Button) findViewById(R.id.btn);
        bup = (Button) findViewById(R.id.up);
        bdown = (Button) findViewById(R.id.down);
        blift = (Button) findViewById(R.id.lift);
        bright = (Button) findViewById(R.id.right);

        bb.setOnClickListener(this);
        bdown.setOnClickListener(this);
        bup.setOnClickListener(this);
        blift.setOnClickListener(this);
        bright.setOnClickListener(this);

        initivvv();
        g = new game();
        g.funnn();
    }
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn:
                g.init();
                for(int i=0;i<5;i++){
                    for(int j=0;j<5;j++){
                        ivvv[i][j].setImageResource(image[g.xx[i][j]]);
                    }
                }
                break;
            case R.id.lift:
                g.vlift();
                for(int i=0;i<5;i++){
                    for(int j=0;j<5;j++){
                        ivvv[i][j].setImageResource(image[g.xx[i][j]]);
                    }
                }
                break;
            case R.id.right:
                g.vright();
                for(int i=0;i<5;i++){
                    for(int j=0;j<5;j++){
                        ivvv[i][j].setImageResource(image[g.xx[i][j]]);
                    }
                }
                break;
            case R.id.up:
                g.vdown();
                for(int i=0;i<5;i++){
                    for(int j=0;j<5;j++){
                        ivvv[i][j].setImageResource(image[g.xx[i][j]]);
                    }
                }
                break;
            case R.id.down:
                g.vup();
                for(int i=0;i<5;i++){
                    for(int j=0;j<5;j++){
                        ivvv[i][j].setImageResource(image[g.xx[i][j]]);
                    }
                }
                break;
        }
    }
}
