/*

There are a total of n courses you have to take labelled from 0 to n - 1.

Some courses may have prerequisites, for example, if prerequisites[i] = [ai, bi] this means you must take the course bi before the course ai.

Given the total number of courses numCourses and a list of the prerequisite pairs, return the ordering of courses you should take to finish all courses.

If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.

*/
class Solution {
    boolean[] visited;
    boolean[] ancesters;
    Stack<Integer> st=new Stack<Integer>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        visited=new boolean[numCourses];
        ancesters=new boolean[numCourses];
        ArrayList<ArrayList<Integer>> adjList=new ArrayList<ArrayList<Integer>>(numCourses);
        for(int i=0;i<numCourses;i++) adjList.add(new ArrayList<Integer>());
        for(int i=0;i<prerequisites.length;i++){
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int[] arr=new int[numCourses];
        boolean cycleexist=false;
        for(int i=0;i<numCourses;i++){
            if(!visited[i]) if(dfs(i,adjList)) return new int[0];
        }
        
        int k=0;
        while(!st.isEmpty())
            arr[k++]=st.pop();
        return arr;
    }
    public boolean dfs(int node,ArrayList<ArrayList<Integer>> adj){
        visited[node]=true;
        ancesters[node]=true;
        boolean cycle=false;
        for(Integer neighbour:adj.get(node)){
            if(!visited[neighbour]) cycle=dfs(neighbour,adj);
            else if(ancesters[neighbour]) return true;
            if(cycle) { return true;}
        }
        ancesters[node]=false;
        st.push(node);
        return false;
    }
}
