
import java.util.Arrays;
import java.util.Comparator;


class 섬연결하기 {
    private int[] parents;
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1,int[] o2){
                if(o1[2]==o2[2]){
                    return o1[1]-o2[1];
                }else{
                    return o1[2]-o2[2];
                }
            }
        });
        // 가중치기준으로 정렬
        int answer = 0;


        parents = new int[n];

        for(int i=0;i<n;i++){
            parents[i] = i;
        }

        for(int i=0;i<costs.length;i++){
            int start = findRoot(costs[i][0]);
            int end = findRoot(costs[i][1]);
            if(start!=end){
                parents[end] = start;
                answer += costs[i][2];
            }
        }

        return answer;
    }

    public int findRoot(int child){
        if(parents[child]==child){
            return child;
        } else {
            return parents[child] = findRoot(parents[child]);
        }
    }
}