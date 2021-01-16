import java.util.*;
import java.lang.*;
import java.io.*;
class DFSTraversal{
	public static void dfs(int source,ArrayList<ArrayList<Integer>> adjList,ArrayList<Integer> res,boolean[] visited){
			visited[source]=true;
			res.add(source);
			for(Integer n: adjList.get(source)){
				if(!visited[n])
					dfs(n,adjList,res,visited);
			}
	}
	public static ArrayList<Integer> getDFS(ArrayList<ArrayList<Integer>> adjList,int ver){
		ArrayList<Integer> res=new ArrayList<Integer>();
		boolean[] visited=new boolean[ver];
		dfs(0,adjList,res,visited);
		
		return res;
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		String[] s=sc.nextLine().split(" ");
		int v=Integer.parseInt(s[0]);
		int e=Integer.parseInt(s[1]);
		ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<v;i++) adj.add(new ArrayList<Integer>());
		for(int i=0;i<e;i++){
			String[] si=sc.nextLine().split(" ");
			adj.get(Integer.parseInt(si[0])).add(Integer.parseInt(si[1]));
			adj.get(Integer.parseInt(si[1])).add(Integer.parseInt(si[0]));
		}
		ArrayList<Integer> ans=getDFS(adj,v);
		for(int i=0;i<ans.size();i++) System.out.print(ans.get(i)+" ");
	}
}
