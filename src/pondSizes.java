/**
 * @author lixuefeng
 * @date 2020-08-31 21:27
 * @description:并查集
 */
public class pondSizes {
    public int findCircleNum(int[][] M) {
        int len=M.length;
        UF uf=new UF(len);
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(M[i][j]==1) uf.connected(i,j);
            }
        }
        return uf.getCount();
    }
}
class UF{
    private int[] id;
    private int count;
    private int[] size;
    public UF(int N){
        count=N;
        id=new int[N];
        size=new int[N];
        for(int i=0;i<N;i++){
            id[i]=i;
            size[i]=1;
        }
    }
    public int getCount(){
        return count;
    }
    public boolean connected(int p,int q){
        return find(p)==find(q);
    }
    public int find(int q){
        if(q!=id[q]) id[q]=find(q);
        return id[q];
    }
    public void union(int q,int p){
        int qRoot=find(q);
        int pRoot=find(p);
        if(qRoot==pRoot) return;
        if(size[qRoot]>size[pRoot]){
            id[pRoot]=qRoot;
            size[qRoot]+=size[pRoot];
        }else{
            id[qRoot]=pRoot;
            size[pRoot]+=size[qRoot];
        }
        count--;
    }
}
