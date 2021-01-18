/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

*/
class Solution {
    boolean[] visited;
    boolean[] ancesters;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited=new boolean[numCourses];
        ancesters =new boolean[numCourses];
        ArrayList<ArrayList<Integer>> adjList=new ArrayList<ArrayList<Integer>>(numCourses);
        for(int i=0;i<numCourses;i++) adjList.add(new ArrayList<Integer>());
        for(int i=0;i<prerequisites.length;i++)
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        for(int i=0;i<numCourses;i++){
            if(!visited[i])
                if(isCycle(i,adjList)) return false;
        }
        return true;
        
    }
    public boolean isCycle(int node,ArrayList<ArrayList<Integer>> adj){
        visited[node]=true;
        ancesters[node]=true;
        boolean cycleexist=false;
        for(Integer neighbour:adj.get(node)){

            if(!visited[neighbour]){
                cycleexist=isCycle(neighbour,adj);
            }
            else if(ancesters[neighbour]) return true;
            if(cycleexist) return true;
        }
        ancesters[node]=false;
        return false;
    }
}
