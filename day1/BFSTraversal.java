import java.util.*;
import java.lang.*;
import java.io.*;
class BFSTraversal{
		
		
	public static ArrayList<Integer> getBFS(ArrayList<ArrayList<Integer>> adjList,int ver){
			ArrayList<Integer> result=new ArrayList<Integer>();
			boolean[] visited=new boolean[ver];
			Queue<Integer> queue=new LinkedList<Integer>();
			queue.add(0);
			visited[0]=true;
			result.add(0);
			while(!queue.isEmpty()){
				for(int i=0;i<queue.size();i++){
					int curr=queue.poll();
					for(Integer neighbour:adjList.get(curr)){
						if(!visited[neighbour]){
							visited[neighbour]=true;
							result.add(neighbour);
							queue.add(neighbour);
						}
					}
				}
			}
			return result;
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
			ArrayList<Integer> ans=getBFS(adj,v);
			for(int i=0;i<ans.size();i++) System.out.print(ans.get(i)+" ");
	}
}
