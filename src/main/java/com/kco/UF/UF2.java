package com.kco.UF;

import java.io.File;
import java.util.Scanner;

/**
 * Created by pc on 2017/4/4.
 */
public class UF2 {
    private int count;
    private int[] id;

    public UF2(int n){
        this.count = n;
        id = new int[n];
        for (int i = 0; i < n;i ++){
            id[i] = 1;
        }
    }
    public int getCount(){
        return count;
    }
    public int find(int x){
        while (x != id[x]) x = id[x];
        return x;
    }
    public void union(int p, int q){
        int pId = find(p);
        int qId = find(q);
        if(pId == qId) return;
        id[q] = pId;
        count --;
    }
    public boolean connected(int p, int q){
        return find(p) == find(q);
    }
    public static void main(String[] args) throws Exception {
        File file = new File(UF1.class.getResource("/uf1.txt").getFile());

        System.out.println(file.getAbsolutePath());
        Scanner input = new Scanner(file);
        int N = input.nextInt();
        UF1 uf1 = new UF1(N);
        while (input.hasNext()){
            int p = input.nextInt();
            int q = input.nextInt();
            if (uf1.connected(p, q)) continue;
            uf1.union(p, q);
            System.out.println(p + "-" + q);
        }
        System.out.println("中连通分量数:" + uf1.getCount());
    }
}
