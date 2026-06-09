import java.util.Scanner;

public class Question1 {
    //Desc: Given an array. Find the number of ways you can partitoon it so that sum of each partition is less than M
    // 1 2 3 4 4. --> 1 2 3 4    4 ---> 1 + number of partitions till 4. M=5
    // 1 2 3   4 4 ---> 1 + dp[3]....(nt possible since 4=4 >=5)
    // So dp[5]== 1+ (dp[4],dp[3],dp[2],dp[1])
    //dp[1]=1;
    //dp[2] = 1+dp[1]--> if sum from i-1 till 2 is less than or equal to 5. So dp[2]=2
    //dp[3] = 1+dp[2], 1+dp[1]
    //
    //
    //
    //
    public static void solution(){
        Scanner sc = new Scanner(System.in);
        long n= sc.nextLong();
        long m= sc.nextLong();
        long[] b = new long[(int)(n+1)];
        for(int i=1;i<=n;i++){
            b[i]=sc.nextLong();
        }
        long[] dp = new long[105];
        dp[0] =1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            long v=0;
            long sum=b[i];
            for(int j=i;j>=1;j--){
                if(sum<=m){
                    long g= dp[j-1];
                    v=v+g;
                    sum+=b[j];
                }
            }
            dp[i]=v;
        }
        System.out.println(dp[(int)n]);
    }
}
