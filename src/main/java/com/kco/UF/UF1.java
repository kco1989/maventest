package com.kco.UF;

import java.io.File;
import java.util.Scanner;

/**
 * Created by pc on 2017/4/4.
 */
public class UF1 {
    private int count;
    private int[] id;

    public UF1(int n){
        this.count = n;
        id = new int[n];
        for (int i = 0; i < n; i++){
            id[i] = i;
        }
    }

    /**
     *
     * @return 返回联通分量数
     */
    public int getCount(){
        return count;
    }

    /**
     * 查找x所属的连通分量
     */
    public int find(int x){
        return id[x];
    }

    //连通p,q(将取得分量改为p所在的分量)
    public void union(int p, int q){
        int pId = find(p);
        int qId = find(q);
        for (int i = 0; i < id.length; i ++){
            if (find(i) == pId){
                id[i] = qId;
            }
        }
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
