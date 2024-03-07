import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        char[][] gridtrue = {
                {'.', '.', '.', '1', '4', '.', '.', '2', '.'},
                {'.', '.', '6', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '1', '.', '.', '.', '.', '.', '.'},
                {'.', '6', '7', '.', '.', '.', '.', '.', '9'},
                {'.', '.', '.', '.', '.', '.', '8', '1', '.'},
                {'.', '3', '.', '.', '.', '.', '.', '.', '6'},
                {'.', '.', '.', '.', '.', '7', '.', '.', '.'},
                {'.', '.', '.', '5', '.', '.', '.', '7', '.'}};


        char[][] grid = {
                {'.', '.', '.', '.', '2', '.', '.', '9', '.'},
                {'.', '.', '.', '.', '6', '.', '.', '.', '.'},
                {'7', '1', '.', '.', '7', '5', '.', '.', '.'},
                {'.', '7', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '8', '3', '.', '.', '.'},
                {'.', '.', '8', '.', '.', '7', '.', '6', '.'},
                {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                {'.', '1', '.', '2', '.', '.', '.', '.', '.'},
                {'.', '2', '.', '.', '3', '.', '.', '.', '.'}
        };

        System.out.println(solution(gridtrue));
    }

    static boolean solution(char[][] grid) {

        for (int i = 0; i < grid[0].length; i++) {

            Set<Character> row = new HashSet<>();
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] != '.') {
                    if (!row.add(grid[i][j])) return false;
                }

                Set<Character> col = new HashSet<>();
                for (int k = 0; k < grid[0].length; k++) {
                    if (grid[k][j] != '.') {
                        if (!col.add(grid[k][j])) return false;
                    }
                }
            }
            Set<Character> subgrid = new HashSet<>();
            int rowSubgrid = (i / 3) * 3;
            int colSubgrid = (i % 3) * 3;
            for (int j = rowSubgrid; j <= rowSubgrid + 2; j++) {
                for (int k = colSubgrid; k <= colSubgrid + 2; k++) {
                    if (grid[j][k] != '.') {
                        if (!subgrid.add(grid[j][k])) return false;
                    }
                }

            }
        }
        return true;
    }
}