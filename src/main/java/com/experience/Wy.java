package com.experience;

public class Wy {
    public static void main(String[] args) {
        double[] n = new double[]{0.0995,0.3769,0.5237};
        double[] u = new double[]{24,128,24,30,83,12,14,12,16,12,13,12,12,12,1,3,3,3,2,2,2,1,1};
        double[][] all = new double[n.length][u.length];
        double max = 0;
        for(int i = 0;i < n.length;i++){
            for(int j = 0;j < u.length;j++){
                all[i][j] = n[i] * u[j] / 422/0.1588;
                max = max > all[i][j] ? max : all[i][j];
            }
        }
        System.out.println(max);
        System.out.println("-----------------------");
        for(int i = 0;i < n.length;i++){
            for(int j = 0;j < u.length;j++){
                System.out.println(all[i][j]);
            }
            System.out.println("=========");
        }

    }
}
