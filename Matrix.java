import java.util.Scanner;

public class Matrix {

//State Variables: Private state variables were created so that they could not be accidently accessed. Each iteration of the Matrix Class with have it's own m,numberOfRows and numberOfColumns.

    private double[][] m;
    public int numberOfRows;
    public int numberOfColumns;

//Constructors: Two constructors were created. The first, takes two ints as parameters for the shape of the matrix and initializes the elements to 0. The second has no parameters, but instead asks the user to supply the shape and element values via scanner.

    public Matrix(int rows, int columns) {
        numberOfRows = rows;
        numberOfColumns = columns;
        m = new double[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                m[i][j] = 0;
            }
        }
    }

    public Matrix() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println();
        System.out.print("Please enter the number of rows: ");
        numberOfRows = keyboard.nextInt();
        System.out.print("Please enter the number of columns: ");
        numberOfColumns = keyboard.nextInt();
        m = new double[numberOfRows][numberOfColumns];
        System.out.println("Please assign the following elements: ");
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                System.out.print("[" + i + "]" + "[" + j + "]: ");
                m[i][j] = keyboard.nextDouble();
            }
        }
    }


//Accessors: Private accessors were created in order to retrieve data for use elsewhere in the class.

    private int getRows() {
        return numberOfRows;
    }

    private int getColumns() {
        return numberOfColumns;
    }

    public double getElement(int rows, int columns) {
        // System.out.println("rows "+rows);
        // System.out.println("columns "+columns);

        return m[rows][columns];
    }

//Mutators: A private void mutator was created so that the value of a particular element within m, could be asigned a value later within the addition/subtraction/multiplication methods.

    public void assignElement(double value, int i, int j) {
        m[i][j] = value;
    }

    public static Matrix add(Matrix m1, Matrix m2) {
        Matrix m3 = new Matrix(m1.getRows(), m1.getColumns());
        for (int i = 0; i < m1.getRows(); i++) {
            for (int j = 0; j < m2.getColumns(); j++) {
                m3.m[i][j] = m1.m[i][j] + m2.m[i][j]; // m is the double[][] array for each Matrix instance
            }
        }
        return m3;
    }
//Methods: Addition, subtraction and mutiplication operations were written as methods in order to operate on matricices. Both static and non-static methods were constructed. 
//The static versions take two matricies as parameters, while the non-static counterparts only take one and operate it against m. 
//Within all six methods a test is performed in order to check whether or not the two matrcicies are compatible or not. 
//For addiition and subtraction the number of rows and columns must be the same for both matricies and a temporary matrix is created to match those parameters. 
//For multiplication, the number of columns of the first matrix must be equivalent to the number of rows of the second matrix and a temporary matrix is created with the number of rows of the first matrix and 
//the number of columns of the second matrix as parameters. If the matricies are not compatable an error message is printed.

    public static Matrix staticAdd(Matrix x, Matrix y) {
        Matrix z = new Matrix(x.getRows(), x.getColumns());
        double value;
        System.out.println();
        System.out.println("The sum of the matricices is: ");

        if (x.getRows() == y.getRows() && x.getColumns() == y.getColumns()) {
            for (int i = 0; i < x.getRows(); i++) {
                for (int j = 0; j < y.getColumns(); j++) {
                    value = x.getElement(i, j) + y.getElement(i, j);
                    z.assignElement(value, i, j);
                    System.out.print("[" + z.getElement(i, j) + "]");
                }
                System.out.print('\n');
            }
            return z;
        } else {
            System.out.println("ERROR: The number of rows and columns of the matricies are not equal.");
            return z;
        }
    }


    public static Matrix staticSubtract(Matrix x, Matrix y) {
        Matrix z = new Matrix(x.getRows(), x.getColumns());
        double value;
        System.out.println();
        System.out.println("The difference of the two matricices is: ");

        if (x.getRows() == y.getRows() && x.getColumns() == y.getColumns()) {
            for (int i = 0; i < x.getRows(); i++) {
                for (int j = 0; j < y.getColumns(); j++) {
                    value = x.getElement(i, j) - y.getElement(i, j);
                    z.assignElement(value, i, j);
                    System.out.print("[" + z.getElement(i, j) + "]");
                }
                System.out.print('\n');
            }
            return z;
        } else {
            System.out.println("ERROR: The number of rows and columns of the matricies are not equal.");
            return z;
        }
    }

    public static Matrix staticMultiply(Matrix x, Matrix y) {
        Matrix z = new Matrix(x.getRows(), y.getColumns());
        double value;
        System.out.println();
        System.out.println("The product of the matricices is: ");

        if (x.getColumns() == y.getRows()) {
            for (int i = 0; i < x.getRows(); i++) {
                for (int j = 0; j < y.getColumns(); j++) {
                    double sum = 0;
                    for (int k = 0; k < x.getRows(); k++) {
                        sum += x.getElement(i, k) * y.getElement(k, j);
                    }
                    value = sum;
                    z.assignElement(value, i, j);
                    System.out.print("[" + z.getElement(i, j) + "]");
                }
                System.out.print('\n');
            }
            return z;
        } else {
            System.out.println("ERROR: The number of columns of the first matrix and the number of rows of the second matrix are not equivalent.");
            return z;
        }
    }


    public Matrix add(Matrix x) {
        Matrix z = new Matrix(numberOfRows, numberOfColumns);
        double value;
        System.out.println();
        System.out.println("The sum of the matricices is: ");

        if (numberOfRows == x.getRows() && numberOfColumns == x.getColumns()) {
            for (int i = 0; i < x.getRows(); i++) {
                for (int j = 0; j < x.getColumns(); j++) {
                    value = m[i][j] + x.getElement(i, j);
                    z.assignElement(value, i, j);
                    System.out.print("[" + z.getElement(i, j) + "]");
                }
                System.out.print('\n');
            }
            return z;
        } else {
            System.out.println("ERROR: The number of rows and columns of the matricies are not equivalent.");
            return z;
        }
    }


    public Matrix subtract(Matrix x) {
        Matrix z = new Matrix(numberOfRows, numberOfColumns);
        double value;
        System.out.println();
        System.out.println("The difference of the two matricices is: ");

        if (numberOfRows == x.getRows() && numberOfColumns == x.getColumns()) {
            for (int i = 0; i < x.getRows(); i++) {
                for (int j = 0; j < x.getColumns(); j++) {
                    value = m[i][j] - x.getElement(i, j);
                    z.assignElement(value, i, j);
                    System.out.print("[" + z.getElement(i, j) + "]");
                }
                System.out.print('\n');
            }
            return z;
        } else {
            System.out.println("ERROR: The number of rows and columns of the matricies are not equivalent.");
            return z;
        }
    }

    public Matrix multiply(Matrix x) {
        Matrix z = new Matrix(numberOfRows, x.getColumns());
        double value;
        //  System.out.println("numberOfRows: "+numberOfRows);
        // System.out.println("The product of the matrices is: ");

        if (numberOfColumns == x.getRows()) {
            for (int i = 0; i < numberOfRows; i++) {
                for (int j = 0; j < x.getColumns(); j++) {
                    double sum = 0;
                    for (int k = 0; k < numberOfColumns; k++) {
                        sum += m[i][k] * x.getElement(k, j);
                        //               System.out.println("m[i][k] "+m[i][k]);
                        //             System.out.println("x.getElement(k, j) "+x.getElement(k, j));
                        //           System.out.println("sum "+sum);
                    }
                    value = sum;
                    z.assignElement(value, i, j);
                    //  System.out.print("[" + z.getElement(i, j) + "]");
                }
                //  System.out.print('\n');
            }
            return z;
        } else {
            System.out.println("ERROR: The number of columns of the first matrix and the number of rows of the second matrix are not equivalent.");
            return z;
        }
    }

//toString: A to string was created to display the matrices and to prevent java from created its own version of a toString.

    public String toString() {
        String es = "";

        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                //       es += "[";
                es += Math.round(m[i][j] * 1000000) / 1000000.0;
                //     es += "]";
                es += " ";
            }
            es += '\n';
        }
        // System.out.println();
        //  System.out.println("Your matrix: ");
        return es;
    }
}
