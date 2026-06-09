import java.util.Scanner;

public class Question2 {
    // Same as Question but we should only make K partitions.
    //dp[i][k]---> This should give how many ways you can divide array till i where i is included and
    //can do exactly K partitions.
    //dp[i][k] = 1st option (dp[i-1][k-1] +
    //dp[i-2][k-1]+ dp[i-3][k-1] +......... (Till the valude of i where it is >=k)
    //Since only dp[i] cannot alone define exact answer for given question, we need dp[i][k]
    //1 2 3 4 4 m<=5 and k=3 (for this example give the dp table. Or animate if possible so it maps clearly in my brain)

    public static void solution(){
        Scanner sc = new Scanner(System.in);
        long n= sc.nextLong();
        long m= sc.nextLong();
        long k = sc.nextLong();
        long[] b = new long[(int)(n+1)];
        for(int i=1;i<=n;i++){
            b[i]=sc.nextLong();
        }
        long [][]dp = new long[105][105];
        for(int i=0;i<=100;i++){
            for(int j=0;j<=100;j++){
                dp[i][j]= -1_000_000_000_000L;
            }
        }
        dp[0][0]=1;
        dp[1][1]=1;
        //dp[1][2]=-inf
        //dp[1][3] = -inf
        //dp[1][4]=-inf
        //dp[2][1] = dp[1][0]() + (if possible dp[0][1])
        //dp[2][2] = dp[1][1] + dp[0][1]

        for(int i=2;i<=n;i++){

            int prt = 1;
            while(prt<=k){// This loop tells dp[i][1], dp[i][2], dp[i][3]...dp[i][k]
                long v=0;//v is temporary answer to calculate dp.
                int j=i;
                long sum = b[i];

                while(j>=1 && sum <=m ){
                    long g = dp[j-1][prt-1];
                    if(g>0){
                        v=v+g;
                    }
                    j--;
                    sum=sum+b[j];
                }
                if(v>0){
                    dp[i][prt] = v;
                }
                System.out.println(i + " " + prt + " " + dp[i][prt]) ;
                prt++;
            }

        }
        System.out.println(dp[(int )n][(int )k]);
    }
}
