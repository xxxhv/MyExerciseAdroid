package com.none.w2048;

import java.util.Random;

/**
 * Created by Administrator on 2018/4/21.
 */
public class game {
    public int[][] xx=new int[][]{
            {0,0,0,0,0},
            {0,0,0,0,0},
            {0,0,0,0,0},
            {0,0,0,0,0},
            {0,0,0,0,0}
    };
    private static int[][] xy=new int[][]{
            {0,0,0,0,0},
            {0,0,0,0,0},
            {0,0,0,0,0},
            {0,0,0,0,0},
            {0,0,0,0,0}
    };
    private static int[] sx=new int[25];


    private static Random rand=new Random();
    //随机产生1 2
    private int raaaa(){
        int iasd=Math.abs(rand.nextInt())%2;
        return iasd+1;
    }



    //init
    public void init(){
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++) {
                xx[i][j]=0;
            }
        }
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++) {
                xy[i][j]=0;
            }
        }
        for(int i=0;i<25;i++){
            sx[i]=0;
        }
    }

    //数组有多少空位 记录空位
    private int find_0(){
        int val=0;
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++) {
                xy[i][j]=0;
            }
        }
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(0==xx[i][j]){
                    val++;
                }
                else{
                    xy[i][j]=-1;
                }
            }
        }
        return val;
    }
    //
    private void setsx(int n){
        for(int i=0;i<25;i++)
        {
            sx[i]=0;
        }
        if(n>12){
            for(int i=0;i<2;i++) {
                sx[i]=raaaa();
            }
        }else{
            for(int i=0;i<4;i++) {
                sx[i]=raaaa();
            }
        }
    }
    //
    private void setxy(){
        for(int i=0;i<5;i++) {
            for (int j = 0; j < 5; j++) {
                if(xy[i][j]==0)
                {
                    xy[i][j]=sx[Math.abs(rand.nextInt())%25];
                }
                if(xy[i][j]==-1)
                {
                    xy[i][j]=0;
                }
            }
        }
    }


    public void funnn(){
        //nn=空位数 有值的位置在xy用-1标记
        int nn = find_0();
        //初始化sx
        setsx(nn);
        //用sx初始化xy
        setxy();
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++) {
                xx[i][j]=xx[i][j]+xy[i][j];
            }
        }

    }

    public void vup(){
        int nu=4;
        for(int i=0;i<5;i++){
            for(int j=4;j>0;j--){
                if((xx[j][i]==xx[j-1][i])&&(xx[j][i]!=0)){
                    xx[j][i]++;
                    xx[j-1][i]=0;
                    j=j-1;
                }
            }
        }
        for(int i=0;i<5;i++){
            for(int j=4;j>=0;j--){
                if(xx[j][i]!=0){
                    xx[nu][i]=xx[j][i];
                    nu--;
                }
            }
            nu=4;
        }
        funnn();
    }
    public void vdown(){
        int nd=0;
        for(int i=0;i<5;i++){
            for(int j=0;j<4;j++){
                if((xx[j][i]==xx[j+1][i])&&(xx[j][i]!=0)){
                    xx[j][i]++;
                    xx[j+1][i]=0;
                    j=j+1;
                }
            }
        }
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(xx[j][i]!=0){
                    xx[nd][i]=xx[j][i];
                    nd++;
                }
            }
            nd=0;
        }
        funnn();
    }
    public void vright(){
        int nr=4;
        for(int i=0;i<5;i++){
            for(int j=4;j>0;j--){
                if((xx[i][j]==xx[i][j-1])&&(xx[i][j]!=0)){
                    xx[i][j]++;
                    xx[i][j-1]=0;
                    j=j-1;
                }
            }
        }
        for(int i=0;i<5;i++){
            for(int j=4;j>=0;j--){
                if(xx[i][j]!=0){
                    xx[i][nr]=xx[i][j];
                    nr--;
                }
            }
            nr=4;
        }
        funnn();
    }
    public void vlift(){
        int nl=0;
        for(int i=0;i<5;i++){
            for(int j=0;j<4;j++){
                if((xx[i][j]==xx[i][j+1])&&(xx[i][j]!=0)){
                    xx[i][j]++;
                    xx[i][j+1]=0;
                    j=j+1;
                }
            }
        }
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(xx[i][j]!=0){
                    xx[i][nl]=xx[i][j];
                    nl++;
                }
            }
            nl=0;
        }
        funnn();
    }



}
