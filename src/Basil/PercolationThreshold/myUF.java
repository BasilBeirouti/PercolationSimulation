package Basil.PercolationThreshold;

/**
 * Created by basilbeirouti on 1/26/15.
 */
public class myUF {

    private int[] id;
    private int count;

    public myUF(int N) {
        id=new int[N];
        for (int i=0; i<N; i++) id[i] = i;
    }

    private int root(int i) {
        count=0;
        int holder = 0;
        while (i != id[i]) {
            holder=id[i];
            id[i]=id[id[i]]; //path compression. Makes i point directly to it's grandparent instead of it's parent.
            i=holder;
            count +=1;

        }
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p)==root(q);
    }

    public void union(int p, int q) {
        int i=root(p);
        int htp=this.count;
        int j=root(q);
        int htq=this.count;

        if (htp<htq) {id[i]=j; id[p]=j; id[q]=j;}
        else {id[j]=i; id[p]=i; id[q]=i;}
    }
}