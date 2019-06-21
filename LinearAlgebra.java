// louis ferraro
// a library to do all my linear algebra computations for me
import java.util.*;
import java.lang.Math;
// needed for rref and anything w/ fraction...from "rosettacode.org"
// import org.apache.commons.math.fractions.Fraction;
// import org.apache.commons.math.fractions.FractionConversionException;

public class LinearAlgebra
{

  public static double[][] add(double[][] a, double[][] b) // 0(n^2) run/space
  {
    if (a == null || b == null)
      return null;

    // return null if matrices are not both m x m
    if (a.length != b.length || a[0].length != b[0].length) // a.length = row...a[0].length = col
      return null;

    double[][] sum = new double[a.length][a[0].length];

    // just add the ijth indice of a with the ijth indice of b
    for (int i = 0; i < a.length; i++)
      for (int j = 0; j < a[0].length; j++)
        sum[i][j] = a[i][j] + b[i][j];

    return sum;
  }

  public static double[][] mult(double[][] a, double[][] b) // 0(n^3) run...0(n^2) space
  {
    if (a == null || b == null)
      return null;

    // return null if this property isnt met...3x2 * 2x5 = 3x5
    if (a[0].length != b.length)
      return null;
    // create that 3x5 matrix
    double[][] product = new double[a.length][b[0].length];

    for (int i = 0; i < a.length; i++)
      for (int j = 0; j < b[0].length; j++)
        for (int k = 0; k < a[0].length; k++)
          product [i][j] += a[i][k] * b[k][j];


    // TO PRINT:
    for (int i = 0; i < a.length; i++)
      for (int j = 0; j < b[0].length; j++)
        System.out.println(product[i][j]);


    return product;
  }

  public static boolean isInNulSpace(double[][] a, double[][] x)
  {
    // this method checks if ax = 0 or if x is in nul space of a
    double[][] product = mult(a, x);

    for (int i = 0; i < product.length; i++)
      for (int j = 0; j < product[0].length; j++)
        if (product[i][j] != 0)
          return false;

    // all entries of resulting matrix are 0
    return true;


  }

  public static double[][] transpose(double[][] a)
  {
    // row i becomes col i...2x4 becomes 4x2
    if (a == null)
      return null;

    double[][] result = new double[a[0].length][a.length];

    for (int i = 0; i < a[0].length; i++)
      for (int j = 0; j < a.length; j++)
        result[i][j] = a[j][i];

    return result;
  }

  public static double[][] rref(double[][] a)
  {
    if (a == null)
      return null;

    double[][] result = new double[a.length][a[0].length];




    return result;
  }

  public static double determinant(double[][] a)
  {
    if (a == null)
      return Double.MIN_VALUE;

    // 2x2 matrix
    if (a.length == 2 && a[0].length == 2)
      return a[0][0]*a[1][1] - a[0][1]*a[1][0];



    return 1.0;
  }

  public static double[][] inverse(double[][] a)
  {
    if (a == null)
      return null;

    return a;
    // try do do this in place
  }



  public static void main(String []args)
  {
    double[][] matrix =
    {
      {1, 0, 5},
      {2, 1, 7},
      {5, 3, -1}
    };
    double[][] matrice =
    {
      {-4, 6, 3},
      {2, 10, -2},
      {40, -13, 6}
    };
    double[][] test1 =
    {
      {1, 0, 1.5},
      {47, 1, 4},
    };
    double[][] test2 =
    {
      {-4, 6, 3, 4, 0},
      {2, 10, -2, 53, -71},
      {40, -13, 6, 14, 3.7}
    };
    double[][] test3 =
    {
      {1, 0, -2, 4},
      {5, 17, 5, 6.2}
    };
    double[][] test4 =
    {
      {1, 0},
      {5, 17}
    };
    double[][] test5 =
    {
      {3, -2, 5},
      {2, -5, -1},
      {-6, 1, 3}
    };
    double[][] test6 =
    {
      {1},
      {1},
      {1}
    };


    System.out.println(isInNulSpace(test5, test6));
    System.out.println(mult(test5, test6));
    return;
  }
}
