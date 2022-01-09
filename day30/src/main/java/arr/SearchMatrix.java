package arr;

/**
 * @author cm
 * @create 2022/1/9-1:06 下午
 * 74. 搜索二维矩阵
 */
public class SearchMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60},
        };
//        System.out.println(matrix.length);
//        System.out.println(matrix[0][matrix[0].length-1]);
        boolean b = searchMatrix(matrix, 70);
        System.out.println(b);
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        //表示列
        int i = matrix[0].length-1;
        //表示行
        int j = 0;
        while (i >= 0 && j < matrix.length){
            if (matrix[j][i] == target){
                return true;
            }
            if (matrix[j][i] < target){
                j++;
            }else {
                i--;
            }
        }
        return false;
    }
}
