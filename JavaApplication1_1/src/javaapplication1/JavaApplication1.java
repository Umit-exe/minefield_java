/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author HP
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        Scanner oku=new Scanner(System.in);
        System.out.print("Mayın tarlasının kaç satır olacağını giriniz: ");
        int satır=oku.nextInt();
        System.out.print("Mayın tarlasının kaç sütun olacağını giriniz: ");
        int sütun=oku.nextInt();
        System.out.print("Mayın tarlasının zorluğunu seçiniz(%20-%80 arasında bir değer giriniz): ");
        int zorluk=oku.nextInt();
        int mayinsayisi=(satır*sütun)*zorluk/100;
        String tarla[][]=new String[satır][sütun];
        Random rnd =new Random();
        System.out.println();
        
        for(int i=0;i<satır;i++)
        {
            for(int j=0;j<sütun;j++)
            {                
                tarla[i][j]=" *";
            }
        }        
        //   TARLAYI YAZDIRAN KOD
        for(int i=0;i<satır;i++)
        {
            for(int j=0;j<sütun;j++)
            {
                System.out.print(tarla[i][j]);
            }
            System.out.println();
        }
        
        //Mayınları Döşediğimiz Aşama
        for(int i=0;i<mayinsayisi;i++)
        {
            int a=rnd.nextInt(satır);
            int b=rnd.nextInt(sütun);
            tarla[a][b]=" 1";
        }
        int puan=0;
        String tarla2[][]=new String[satır][sütun];//Oyunda Gösterilecek Tarlayı Yaratıyoruz
        for(int i=0;i<satır;i++)
        {
            for(int j=0;j<sütun;j++)
            {
                tarla2[i][j]=" *";
            }
        }
        System.out.println();
        System.out.println("Oyun BAŞLIYOR...");
        System.out.println();
        //Oyunun Başladığı Aşama
        for(int i=0;i<mayinsayisi;i++)
        {
            System.out.println();
            System.out.print("Oyunun satır boyutunu giriniz: ");
            int a=oku.nextInt();
            System.out.print("Oyunun sütun boyutunu giriniz: ");
            int b=oku.nextInt();
            System.out.println();
            if(tarla[a][b]==" *")
            {
                puan+=5;
                for(int j=0;j<satır;j++)
                {
                    for(int k=0;k<sütun;k++)
                    {
                        if(j==a&&k==b)
                        {
                            tarla2[j][k]=" 0";
                            System.out.print(tarla2[j][k]);
                        }
                        else
                        {
                            System.out.print(tarla2[j][k]);
                        }
                    }
                    System.out.println();
                }
            }
            else if(tarla[a][b]==" 1")
            {
                System.out.println("Oyun Bitti ..!");
                System.out.println("Toplam Puanınız: "+puan);
                System.out.println();
                for(int j=0;j<satır;j++)
                {
                    for(int k=0;k<sütun;k++)
                    {
                        System.out.print(tarla[j][k]);
                    }
                    System.out.println();
                }
                break;
            }
        }        
    }
}