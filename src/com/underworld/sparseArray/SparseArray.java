package com.underworld.sparseArray;

public class SparseArray {
    public static void main(String[] args) {
        //先创建一个元素的二维数组
        //1. 0:表示没有棋子  1:表示黑子  2:表示蓝子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        System.out.println("原始的二维数组");
        //输出原始的二维数组
        for(int[] row : chessArr1){
            for(int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        //将二维数据转换成稀疏数组
        //1.先遍历二维数组,得到非0数据个数
        int sum = 0;
        for(int i = 0;i < chessArr1.length;i++){
            for(int j = 0;j < chessArr1.length;j++){
                if(chessArr1[i][j] != 0){
                    sum++;
                }
            }
        }
        //System.out.println("sum=" + sum);
        //2.创建对应的稀疏数组
        int sparseArray[][] = new int[sum+1][3];
        //给稀疏数组赋值
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;
        //遍历二维数组,将非0的值存放到稀疏数组中
        int count = 0;//count 用于记录是在第几个非0整数
        for(int i = 0;i < chessArr1.length;i++){
            for(int j = 0;j < chessArr1.length;j++){
                if(chessArr1[i][j] != 0){
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArr1[i][j];
                }
            }
        }
        //输出稀疏数组的形式
        System.out.println();
        System.out.println("得到的稀疏数组为~~~~~~");
        for(int i = 0;i < sparseArray.length;i++){
            System.out.printf("%d\t%d\t%d\t\n",sparseArray[i][0],sparseArray[i][1],sparseArray[i][2]);
        }
        System.out.println();
        //将稀疏数组 ===> 恢复成 原始的二维数组
        //1.先读取稀疏数组的第一行,根据第一行的数据,创建原始的二维数组
        int chessArray2[][] = new int[sparseArray[0][0]][sparseArray[0][1]];
        //2.在读取稀疏数组后几行的数据,并赋值原始的二维数组即可
        for(int i = 1;i < sparseArray.length;i++){
            chessArray2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        //输出恢复后的二维数组
        for(int[] row : chessArray2){
            for(int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        System.out.println("恢复后的二维数组");
    }
}
