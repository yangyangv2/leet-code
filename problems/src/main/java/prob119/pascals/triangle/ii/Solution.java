package prob119.pascals.triangle.ii;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Solution
{
    /*
    0    1
    1    1 1
    2    1 2 1
    3    1 3 3 1

    4"   1 3 3 1 1
    4    1 4 6 4 1

        1 3 3 1
        1 4 6 4 1

        1 3 6 4 1

        d[i][j] = d[i - 1][j - 1] + d[i - 1][j]
    */
    public List<Integer> getRow(int rowIndex)
    {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++)
        {
            list.add(1);
            for (int j = i - 1; j > 0; j--)
            {
                list.set(j, list.get(j - 1) + list.get(j));
            }
        }
        return list;
    }
}
