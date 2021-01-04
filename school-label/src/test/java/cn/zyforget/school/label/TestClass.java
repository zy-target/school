package cn.zyforget.school.label;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestClass
{
    
    @Test
    public void testDemo()
    {
//        Long count = 1223423L;
//        String art = null;
//        char[] chars = art.toCharArray();
//        for (int i = 0;i<chars.length;i++) {
//            art.replaceAll("",String.valueOf(chars[i]));
//        }
//        int num = (int) (count%100);
//        final int[][] ps = new int[][]{new int[]{-1,-1}, new int[]{-1, 0}, new int[]{0, -1}, new int[]{0, 1}, new int[]{1,-1}, new int[]{1,0}, new int[]{1,1}};
//        System.out.println("输出：" + num);
//        String s = CharacterDeletion("They are students", "aeiou");
//        System.out.println("输出" + s);
//        int[] a = new int[] { 1,0,-1 };
//        int[] a = new int[]{1,1,2,2,3,4,4};
//        int i = singleNumber(a);
//        int[] ints = twoSum(a, 0);
//        int[] ints = twoSums(a, 0);
//        System.out.println(ints);
        Date date = new Date(1608183913366L);
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("sf.format(date)：" + sf.format(date));
        String sjhm = "13400688140|12421421412EFAEWRSAFAE";
        String s = sjhm.split("\\|")[0];
        System.out.println("测试AAA：" + s);
    }
    
    public int[][] matrix(int[][] arg)
    {
        int r = arg.length;
        if (r == 0)
        {
            return null;
        }
        int c = arg[0].length;
        if (c == 0)
        {
            return null;
        }
        int[][] newM = new int[r][c];
        for (int i = 0; i < r; i++)
        {
            for (int j = 0; j < c; j++)
            {
                int num = arg[i][j];
//                if (i)
            }
        }
        return null;
    }
    
    public String CharacterDeletion(String str, String sub)
    {
        // write your code here
        if (sub == null || "".equals(sub))
        {
            return str;
        }
        char[] chars = sub.toCharArray();
        ArrayList<String> charList = new ArrayList<>();
        for (int i = 0; i < chars.length; i++)
        {
            if (!charList.contains(String.valueOf(chars[i])))
            {
                str = str.replaceAll(String.valueOf(chars[i]), "");
                charList.add(String.valueOf(chars[i]));
            }
        }
        return str;
    }
    
    public int singleNumber(int[] A)
    {
        // write your code here
        Integer num = 0;
        if (A == null || A.length < 1)
        {
            return num;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int a : A)
        {
            if (map.containsKey(a))
            {
                map.remove(a);
            }
            else
            {
                map.put(a, 1);
            }
        }
        for (Map.Entry<Integer, Integer> m : map.entrySet())
        {
            num = m.getKey();
        }
        return num;
    }
    
    public int[] twoSum(int[] numbers, int target)
    {
        // write your code here
        if (numbers == null || numbers.length < 1)
        {
            return new int[] {};
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++)
        {
            for (Map.Entry<Integer, Integer> m : map.entrySet())
            {
                if ((numbers[i] + m.getValue()) == target)
                {
                    int[] result = {m.getKey(), i};
                    return result;
                }
            }
            map.put(i, numbers[i]);
        }
        return new int[] {};
    }

    public int[] twoSums(int[] numbers, int target)
    {
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            if (map.get(numbers[i]) != null) {
                int[] result = {map.get(numbers[i]), i};
                return result;
            }
            map.put(target - numbers[i], i);
        }

        int[] result = {};
        return result;
    }

    public int threeSumClosest(int[] numbers, int target) {
        // write your code here
        if (numbers == null || numbers.length < 1)
        {
            return 0;
        }
        TreeMap<Integer,Integer> map = new TreeMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<numbers.length;i++) {
            Collections.sort(list);
            for (Integer in:list) {
                if (in > Math.abs(numbers[i] - target) && list.size() == 3){
                    list.remove(2);
                    break;
                }
            }
            list.add(Math.abs(numbers[i] - target));
        }
        return 0;
    }
}
