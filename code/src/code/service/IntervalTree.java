package code.service;

import java.time.LocalTime;

import code.common.IntervalNode;
import code.common.Satellite;

/**
 * @author Cesar Augusto Guzman Alvarez
 * @date Sep 28, 2020
 *
 */
public class IntervalTree {
	
	/**
	 * root node of the interval tree
	 */
	private IntervalNode root = null;

	/**
	 * Function to store 
	 * @param satellite
	 */
	public void insert(Satellite satellite) {
		
		root = insert(root, satellite);
		
	}
	
	/**
	 * Function to insert a new interval search tree node
	 * 
	 * This is similar to BST insert. 
	 * The low value of interval is used to maintain BST property
	 * 
	 * @param node IntervalNode to insert the Satellite
	 * @param satellite Satellite that contains the interval period
	 * @return
	 */
	private IntervalNode insert(IntervalNode node, Satellite satellite) {
		
		// base case: Tree is empty, new node becomes root
		if (node == null) {
			return createNode(satellite);
		}
		
		// get low value of interval at root
		LocalTime low = node.satellite.getFirstTimeInterval().getStart();
		
		// if root's value is smaller, then new interval goes to left subtree
		if (satellite.getFirstTimeInterval().getStart().isBefore(low)) {			
			node.left = insert(node.left, satellite);		
		} else {
			// else, new node goes to right subtree			
			node.right = insert(node.right, satellite);			
		}
		
		// update the max value of this ancestor if needed
		LocalTime high = satellite.getFirstTimeInterval().getEnd();
		if( node.max.isBefore(high)) {
			node.max = high;
		}
		
		return node;
	}
	
	/**
	 * Function to create a node
	 * 
	 * @param satellite Satellite that contain the information of the interval period
	 * @return IntervalNode created 
	 */
	private IntervalNode createNode(Satellite satellite) {
		
		IntervalNode temp = new IntervalNode();
		temp.satellite = satellite;
		temp.max = satellite.getFirstTimeInterval().getEnd();
		temp.left = temp.right = null;
		
		return temp;
	}

	/**
	 * Function to calculate the add of the bandwidth of all overlap periods
	 * 
	 * @param period LocalTime to search
	 * @return Integer add of the bandwidth of all overlap periods
	 */
	public int findTotalBandwidth(LocalTime period) {
		
		return findTotalBandwidth(root, period);
	}

	/**
	 * Function that works recursively to calculate the add of the bandwidth of all overlap periods
	 * 
	 * @param node IntervalNode to check whether it overlaps
	 * @param period LocalTime to search
	 * @return Integer add of the bandwidth of all overlap periods
	 */
	private int findTotalBandwidth(IntervalNode node, LocalTime period) {
		
		int totalBandwidth = 0;
		
		// base case, tree is empty
		if (node == null) return totalBandwidth;
		
		// if given interval overlaps with node
		if (node.satellite.overlap(period)) {
			totalBandwidth = node.satellite.getBandwidth();
		}
		
		// if left child of root is present and max of left child is
		// greater than or equal to given interval, then I may overlap with an interval is left subtree
		if (node.left != null && (node.left.max.equals(period) || node.left.max.isAfter(period))) 
			totalBandwidth += findTotalBandwidth(node.left, period);
		
		// else interval can only overlap with right subtree
		totalBandwidth+=findTotalBandwidth(node.right, period);
		
		// return the add of the bandwidth of all total overlap periods
		return totalBandwidth;
		
	}

	/**
	 * Function to print the tree inorder
	 */
	public void inorder() {
		inorder(root);
	}
	
	/**
	 * Function to iterate recursively the tree inorder
	 * @param node IntervalNode that represents the root node of the tree or subtree
	 */
	private void inorder(IntervalNode node) {
		if (node == null)
			return;
		
		inorder(node.left);
		
		System.out.println(node.satellite.getName()+" "+node.satellite.getBandwidth()+" ["+node.satellite.getFirstTimeInterval().getStart()+", "+node.satellite.getFirstTimeInterval().getEnd()+"] "+node.max);
		
		inorder(node.right);
	}
	
}
