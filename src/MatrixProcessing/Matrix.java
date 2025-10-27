package MatrixProcessing;

// Клас, що представляє матрицю та всі математичні операції
public class Matrix {
    private final double[][] data;

    public Matrix(double[][] data) {
        this.data = data;
    }

    public double[][] getData() {
        return data;
    }

    // Додавання матриць
    public Matrix add(Matrix other) {
        int n = data.length, m = data[0].length;
        double[][] result = new double[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                result[i][j] = data[i][j] + other.data[i][j];
        return new Matrix(result);
    }

    // Множення матриці на константу
    public Matrix multiplyByConstant(double k) {
        int n = data.length, m = data[0].length;
        double[][] result = new double[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                result[i][j] = data[i][j] * k;
        return new Matrix(result);
    }

    // Множення двох матриць
    public Matrix multiply(Matrix other) {
        int n1 = data.length, m1 = data[0].length, m2 = other.data[0].length;
        double[][] result = new double[n1][m2];
        for (int i = 0; i < n1; i++)
            for (int j = 0; j < m2; j++)
                for (int k = 0; k < m1; k++)
                    result[i][j] += data[i][k] * other.data[k][j];
        return new Matrix(result);
    }

    // Транспонування по головній діагоналі
    public Matrix transposeMain() {
        int n = data.length, m = data[0].length;
        double[][] t = new double[m][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                t[j][i] = data[i][j];
        return new Matrix(t);
    }

    // Транспонування по побічній діагоналі
    public Matrix transposeSide() {
        int n = data.length, m = data[0].length;
        double[][] t = new double[m][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                t[m - 1 - j][n - 1 - i] = data[i][j];
        return new Matrix(t);
    }

    // Транспонування по вертикалі
    public Matrix transposeVertical() {
        int n = data.length, m = data[0].length;
        double[][] t = new double[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                t[i][m - 1 - j] = data[i][j];
        return new Matrix(t);
    }

    // Транспонування по горизонталі
    public Matrix transposeHorizontal() {
        int n = data.length, m = data[0].length;
        double[][] t = new double[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                t[n - 1 - i][j] = data[i][j];
        return new Matrix(t);
    }

    // Обчислення визначника
    public double determinant() {
        int n = data.length;
        if (n == 1) return data[0][0];
        if (n == 2) return data[0][0] * data[1][1] - data[0][1] * data[1][0];

        double det = 0;
        for (int k = 0; k < n; k++) {
            double[][] minor = new double[n - 1][n - 1];
            for (int i = 1; i < n; i++) {
                int col = 0;
                for (int j = 0; j < n; j++) {
                    if (j == k) continue;
                    minor[i - 1][col++] = data[i][j];
                }
            }
            det += data[0][k] * Math.pow(-1, k) * new Matrix(minor).determinant();
        }
        return det;
    }

    // Обчислення оберненої матриці
    public Matrix inverse() {
        int n = data.length;
        double det = determinant();
        double[][] adj = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                double[][] minor = new double[n - 1][n - 1];
                int r = 0;
                for (int x = 0; x < n; x++) {
                    if (x == i) continue;
                    int c = 0;
                    for (int y = 0; y < n; y++) {
                        if (y == j) continue;
                        minor[r][c++] = data[x][y];
                    }
                    r++;
                }
                adj[i][j] = Math.pow(-1, i + j) * new Matrix(minor).determinant();
            }
        }

        Matrix adjT = new Matrix(adj).transposeMain();
        double[][] inv = new double[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                inv[i][j] = adjT.data[i][j] / det;

        return new Matrix(inv);
    }
}
