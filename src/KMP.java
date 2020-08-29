import java.util.Arrays;

/**
 * @author lixuefeng
 * @date 2020-08-29 16:23
 * @description:常用于匹配字符,设需要判断A.contains(B) 关键在于，不必每次都从头开始进行匹配；
 * 利用一个数组next存储B的部分匹配值，B:abcdabd next={0,0,0,0,1,2,0}; A:bbc abcdab abcdabcdabde
 * 一般来讲，abcdabd 匹配bbc abcd.. 从bbc开始，匹配不上就后移A一位，然后再从B的头部开始再次匹配。
 * KMP如果匹配不上，A简单后移一位，如果B匹配到bbc abcdab 的时候，后移的位数为以匹配字符串的长度-最后一个匹配的next值，
 * A匹配到ab abcdabcdabde 接着为 abcdabcdabde然后abcdabde 匹配完成ok
 * 部分匹配表next数组的来源于前后缀 所共有的长度。abcd
 */
public class KMP {
    //任务是在s前面加字符，使得成为回文串
        public String shortestPalindrome(String s) {
            int n = s.length();
            int[] fail = new int[n];
            Arrays.fill(fail, -1);
            for (int i = 1; i < n; ++i) {
                int j = fail[i - 1];
                while (j != -1 && s.charAt(j + 1) != s.charAt(i)) {
                    j = fail[j];
                }
                if (s.charAt(j + 1) == s.charAt(i)) {
                    fail[i] = j + 1;
                }
            }
            int best = -1;
            //aacecaaa
            for (int i = n - 1; i >= 0; --i) {
                while (best != -1 && s.charAt(best + 1) != s.charAt(i)) {
                    best = fail[best];
                }
                if (s.charAt(best + 1) == s.charAt(i)) {
                    ++best;
                }
            }
            String add = (best == n - 1 ? "" : s.substring(best + 1));
            StringBuffer ans = new StringBuffer(add).reverse();
            ans.append(s);
            return ans.toString();
        }

    public static void main(String[] args) {
        KMP a=new KMP();
        System.out.println(a.shortestPalindrome("aacecaaa"));
    }
}
