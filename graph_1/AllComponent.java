//Problem statement
//Given an undirected graph G(V,E), find and print all the connected components of the given graph G.
//
//Note:
//
//1. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1. 
//2. E is the number of edges present in graph G.
//3. You need to take input in main and create a function which should return all the connected components. And then print them in the main, not inside function.
//Print different components in new line. And each component should be printed in increasing order (separated by space). Order of different components doesn't matter.
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints :
//0 <= V <= 1000
//0 <= E <= (V * (V - 1)) / 2
//0 <= a <= V - 1
//0 <= b <= V - 1
//Sample Input 1:
//4 2
//0 1
//2 3
//Sample Output 1:
//0 1 
//2 3 
//Sample Input 2:
//4 3
//0 1
//1 3 
//0 3
//Sample Output 2:
//0 1 3 
//2

//package graph_1;
//import java.util.Map;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//import java.io.IOException;
//
//class VertexOutOfRangeException extends Exception {
//	public String toString() {
//		return "Valid input for the vertex in specified range is expected!";
//	}
//}
//
//public class AllComponent {
//	static Scanner sc = new Scanner(System.in);
//
//	public static void connectedComponents(Map<Integer, ArrayList<Integer>> adjacencyList,
//			Map<Integer, Boolean> visited, ArrayList<Integer> smallOutput, int vertex) {
//		smallOutput.add(vertex);
//		visited.put(vertex, true);
//		ArrayList<Integer> adjVerticies = adjacencyList.get(vertex);
//		for (int i = 0; i < adjVerticies.size(); i++) {
//			if (!visited.containsKey(adjVerticies.get(i))) {
//				connectedComponents(adjacencyList, visited, smallOutput, adjVerticies.get(i));
//			}
//		}
//	}
//
//	public static ArrayList<ArrayList<Integer>> allConnectedComponents(Map<Integer, ArrayList<Integer>> adjacencyList) {
//		Map<Integer, Boolean> visited = new HashMap<>();
//		ArrayList<ArrayList<Integer>> output = new ArrayList<>();
//		int i = 0;
//		while (visited.size() != adjacencyList.size()) {
//			while (i < adjacencyList.size()) {
//				if (!visited.containsKey(i)) {
//					ArrayList<Integer> smallOutput = new ArrayList<>();
//					connectedComponents(adjacencyList, visited, smallOutput, i);
//					output.add(smallOutput);
//				}
//				i += 1;
//			}
//		}
//		return output;
//	}
//
//	public static void main(String[] args) throws VertexOutOfRangeException, IOException {
//		String[] strNums;
//		strNums = sc.nextLine().split("\\s");
//		int noOfVertices = Integer.parseInt(strNums[0]);
//		int noOfEdges = Integer.parseInt(strNums[1]);
//
//		Map<Integer, ArrayList<Integer>> adjacencyList = new HashMap<>();
//		for (int i = 0; i < noOfVertices; i++) {
//			adjacencyList.put(i, new ArrayList<>());
//		}
//		int currentEntry = 1;
//		while (currentEntry <= noOfEdges) {
//			String[] strNums1;
//			strNums1 = sc.nextLine().split("\\s");
//			int source = Integer.parseInt(strNums1[0]);
//			int destination = Integer.parseInt(strNums1[1]);
//			ArrayList<Integer> edgeListForDestination = adjacencyList.get(source);
//			ArrayList<Integer> edgeListForSource = adjacencyList.get(destination);
//			if (edgeListForDestination != null && edgeListForSource != null) {
//				edgeListForDestination.add(destination);
//				edgeListForSource.add(source);
//			} else {
//				throw new VertexOutOfRangeException();
//			}
//			currentEntry += 1;
//		}
//		ArrayList<ArrayList<Integer>> allConnectedComponents = allConnectedComponents(adjacencyList);
//		for (int i = 0; i < allConnectedComponents.size(); i++) {
//			ArrayList<Integer> components = allConnectedComponents.get(i);
//			Collections.sort(components);
//			for (int k = 0; k < components.size(); k++) {
//				System.out.print(components.get(k) + " ");
//			}
//			System.out.println();
//		}
//	}
//}