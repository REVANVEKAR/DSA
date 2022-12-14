package leetcode;

import Trees.BinaryTreeNode;

import java.util.*;

public class Array_Sols {

    public static void main(String[] args) {

        int[] arr = {1,8,6,2,5,4,8,3,7};
        int s = maxArea(arr);
        System.out.println(s);
    }

    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        for(int i = 0; i < nums.length ; i++){
            for (int j = 0;  j < nums.length ; j++){
                if (nums[i] + nums[j] == target){
                    ans[0] = i;
                    ans[1] = j;
                    break;
                }
            }
        }
        return ans;
    }

//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {} // kal karenge

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

//    public static int maxArea(int[] height) {
//            int max = Integer.MIN_VALUE;
//
//            int area = 0;
//            for (int i = 0; i < height.length ; i++) {
//                for (int j = i + 1; j < height.length; j++) {
//                    if (height[i] > height[j]) {
//                        area = height[j] * (j-i);
//                        if (area > max) {
//                            max = area;
//                        }
//                    }
//                    else {
//                        area = height[i] * (j-i); // length * breadth not l * l
//                        if (area > max) {
//                            max = area;
//                        }
//                    }
//                }
//            }
//            return max;
//    }
    // TLE error in leetcode lets see how we can improvise

    public static int maxArea(int[] height){
        int l = 0;
        int r = height.length - 1;
        int area = 0;

        while(l<r){
            area = Math.max(area, Math.min(height[l] , height[r]) * ( r - l));
            // we understand this line

            if (height[l] < height[r]){
                l += 1;
            }else{
                r -= 1;
            }

        }
        return area;
    } // answer with better time complexity
    //


    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer , Boolean> map = new HashMap<>();
        boolean duplicates = false;
        for (int i = 0; i< nums.length;i++){
            if (map.containsKey(nums[i])){
                duplicates = true;
                return duplicates;
            }
            else{
                map.put(nums[i] , false);
            }
        }
        return duplicates;
    }

//    Given an integer array nums and an integer k, return true if there are
//    two distinct indices i and j in the array such that nums[i] == nums[j]
//    and abs(i - j) <= k.


//    public boolean containsNearbyDuplicate(int[] nums, int k) {
//        HashMap<Integer,Integer> map = new HashMap<>();
//        for (int i = 0; i< nums.length ; i++){
//            if (map.containsKey(nums[i])){
//                map.put(nums[i],( i - map.get(nums[i])));
//            }
//            else{
//                map.put(nums[i] , i);
//            }
//        }
//
//        for (int values : map.values()){   // not accepted
//            if (values == k){
//                return true;
//            }
//        }
//        return false;
//    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                int pre = map.get(nums[i]);
                if(i-pre<=k)
                    return true;
            }

            map.put(nums[i], i);
        }

        return false;
    } // instead of iterating i should have just taken the value there it self subtract and compare to
    // return . stupid me

    public List<Integer> findDisappearedNumbers(int[] nums) {

        boolean[] exists = new boolean[nums.length];
        for (int i = 0; i < nums.length;i++){
            exists[nums[i]-1] = true;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!exists[i])
                list.add(i+1);
        }
        return list;
    }

    // base ball points counting program
    public int calPoints(String[] operations) {
        Stack<Integer> ans = new Stack<>();
        for (String s : operations){
            if (s.equals("+")){
                int a = ans.pop();
                int newscore = a + ans.peek();
                ans.push(a);
                ans.push(newscore);
            }
            else if(s.equals("D")){
                ans.push(2* ans.peek());
            }
            else if(s.equals("C")){
                ans.pop();
            }
            else{
                ans.push(Integer.parseInt(s));
            }
        }
        int totalScore = 0;
        while (!ans.isEmpty()){
            totalScore += ans.pop();
        }
        return totalScore;
    }

    //merge sorted arrays

    public void merge(int[] nums1, int m, int[] nums2, int n) { //brute force
        int i = 0 , j=0, k = 0;
        int[] arr = new int[m+n];
        while (i < m && j < n){
            if (nums1[i] < nums2[j]){
                arr[k] = nums1[i];
                i++;
                k++;
            }
            else if (nums1[i] > nums2[j]){
                arr[k] = nums2[j];
                j++;
                k++;
            }
            else{
                arr[k] = nums1[i];
                i++;
                k++;
                arr[k] = nums2[j];
                j++;
                k++;
            }
        }
        while(i<m){
            arr[k] = nums1[i];
            i++;
            k++;
        }
        while(j<n){
            arr[k]=nums2[j];
            j++;
            k++;
        }

        for(i =0 ; i<nums1.length;i++)
        {
            nums1[i] = arr[i];
        }
    } //brute force accepted
    // idea was to create a new array just compare and add the samllest and increase the pointers

    public void mergee(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1;
        int p2 = n-1;
        int i = m+n -1;

        while (p2>=0){
            if (p1>=0 && nums1[p1] > nums2[p2]){
                nums1[i--] = nums1[p1--];
            }else{
                nums1[i--] = nums2[p2--];
            }
        }
    } // best solution with o(m+n) time complexity


    //sliding window
    public double findMaxAverage(int[] nums, int k) {
        int currsum = 0;
        for (int i = 0; i < k ; i++){
            currsum += nums[i];
        }

        double max = currsum;
        int l = 0;
        int r = k;

        while(r < nums.length){
            currsum += nums[r++] - nums[l++];
            max = Math.max(currsum,max);
        }
        return max/k;
    }

    //maximum product of three numbers in an array

    public int maximumProductt(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = Integer.MIN_VALUE;

        ans = Math.max(nums[0]*nums[1]*nums[n-1], nums[n-1]*nums[n-2]*nums[n-3]);

        return ans;
    }

    public int maximumProduct(int[] nums) {

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int n : nums){
            if (n> max1){
                max3 = max2 ;
                max2 = max1;
                max1 = n;
            }
            else if (n>max2){
                max3 = max2;
                max2 = n;
            }else if (n>max3){
                max3 = n;
            }

            if (n<min1){
                min2 = min1;
                min1 = n;
            }
            else if (n < min2){
                min2 = n;
            }
        }

        return Math.max(max1*max2*max3 , min1*min2*max1);
    }

    //print pascals triangle
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list =  new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();

        list1.add(1);
        list.add(list1);
        if (numRows==1){
            return list;
        }
        for (int i = 1; i < numRows; i++){
            List<Integer> temp = new ArrayList<>();

            temp.add(1);

            for (int j = 1; j < i ; j++){
                temp.add(list.get(i-1).get(j-1) + list.get(i-1).get(j));
            }
            temp.add(1);
            list.add(temp);
        }
        return list;
    }

//    Teemo Attacking
    public int findPoisonedDuration(int[] timeSeries, int duration) {

        int poisoned = duration;  // it starts from duration because we are starting from index number 1

        for (int i = 1; i < timeSeries.length ; i++){
            if (timeSeries[i-1]+duration-1<timeSeries[i]){ // this line is just adding previos number in the
                // array and see if it reaches the next number in the array or not
                poisoned = poisoned+duration;
            }else{
                poisoned = poisoned + timeSeries[i] - timeSeries[i-1];
            }
        }
        return poisoned;
    }

    // best time to buy and sell stocks
//    public int maxProfit(int[] prices) {
//        int i = 0;
//        int max = Integer.MIN_VALUE;
//
//        while (i< prices.length-1 ){
//            for (int j = prices.length-1;j>i ; j--){
//                if (prices[j] - prices[i] > max){
//                    max = prices[j] - prices[i];
//                }
//            }
//            i++;
//        }
//        if (max <= 0){
//            return 0;
//        }else {
//            return max;
//        }
//        // time limit exceeded itseems madarchodddddddd
//    }

    // alternate solution
    public int maxProfit(int[] prices) {
        int minbuy = prices[0];
        int maxpro = 0;
        for (int price : prices){
            minbuy = Math.min(minbuy, price);
            maxpro = Math.max(maxpro, price-minbuy);
        }

        return maxpro;
    }

    // find the third distinct maximum number

    public int thirdMax(int[] nums) {
        Integer max = null;
        Integer max2 = null;
        Integer max3 = null;

        for (Integer n : nums){
            if (n.equals(max) || n.equals(max2) || n.equals(max3)){
                continue;
            }

            if (max==null || n>max){
                max3 = max2;
                max2 = max;
                max = n;
            }
            if (max2==null || n>max2){
                max3 = max2;
                max2 = n;
            }
            if (max3==null || n>max3){
                max3 = n;
            }

        }
        return (max3 == null) ? max : max3;

    }

//    Can Place Flowers 0 means khali 1 means full

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 1;
        int result = 0;

        for (int i = 0; i < flowerbed.length ; i++){
            if (flowerbed[i] == 0){
                count++;
            }else{
                result = result + (count-1)/2;
                count = 0;
            }
        }
        if (count!=0){
            result += count/2;
        }
        return result>=n;

    }

    //roman number to intergers

    public int romanToInt(String s) {

        int ans = 0;
        int numb = 0;
        int prev = 0;

        for (int i = s.length()-1;i>=0;i--){
            switch (s.charAt(i)){
                case 'M' -> numb = 1000;
                case 'D' -> numb = 500;
                case 'C' -> numb = 100;
                case 'L' -> numb = 50;
                case 'X' -> numb = 10;
                case 'V' -> numb = 5;
                case 'I' -> numb = 1;
            }
            if (prev>numb){
                ans -= numb;
            }
            else {
                ans += numb;
            }
            prev = numb;
        }
        return ans;
    }


    //same questio using hashmap

//    Remove Duplicates from Sorted Array and return an int

    public int removeDuplicates(int[] nums) {
        int i = 0;
        for(int n: nums){
            if(i == 0 || n > nums[i - 1]){
                nums[i] = n;
                i++;
            }
        }
        return i;
    }

    //pascals triangle returning only the line
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        double j = 1.0;
        for (int i = 0;i<=rowIndex;i++){
            row.add((int)j);
            j = (j * (rowIndex-i)) / (i+1);
        }
        return row;
    }

    public BinaryTreeNode<Integer> SortedtoBST(int nums[]){
        return SortedToBSTHelper(nums,0, nums.length-1);
    }

    public BinaryTreeNode<Integer> SortedToBSTHelper(int nums[], int si, int ei){
        if (si>ei){
            return null;
        }
        int mi = (si + (ei-si)/2);
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(nums[mi]);
        root.left = SortedToBSTHelper(nums,0,mi-1);
        root.right = SortedToBSTHelper(nums,mi+1,ei);

        return root;
    }


    public String intToRoman(int num) {

        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1}; // sasta wala hashmap basically
        String[] romanLetters = {"M","CM","D","CM","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder s = new StringBuilder();
        for (int i = 0; i< values.length;i++){
            while (num>=values[i]){
                num = num - values[i];
                s.append(romanLetters[i]);
            }
        }
        return s.toString();
    }

    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for (int i = 1 ; i< strs.length;i++){
            while(strs[i].indexOf(prefix)!=0){
                prefix = prefix.substring(0,prefix.length()-1);
            }
        }
        return prefix;  // explanation step 1 we take first string of the array as the prefix
        // step 2 we iterate over the rest of the array starting from 1 to length-1;
        // step 3 we see if the prefix is present till while is the prefix returns 0;
        // then when it is returning -1 we will keep on reducing th prefix length and update the prefix
        // then when it hits 0 (meaning it iis present ) we move to the next string of the array and so on
    }

    public List<List<Integer>> threeSumTLE(int[] nums) {
        int i = 0;
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();

        while(i<= nums.length-3){
            for (int j = 1 ; j<= nums.length-2;j++){
                for(int k = j ; k<= nums.length-1;k++){
                    if (nums[i] + nums[j] + nums[k] == 0){
                        list1.add(nums[i]);
                        list1.add(nums[i]);
                        list1.add(nums[i]);
                        list.add(list1);
                    }
                }
            }
        }
        return list;

    } // answer might be right but time limit exceeded

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i<nums.length-1;i++){
            int one = nums[i];
            for (int j = i ; j< nums.length;j++){
                if (i==j){
                    continue;
                }
                int two = nums[j];
                int three = 0 - one - two;
                int index3 = Arrays.binarySearch(nums,three);
                if (index3>=0 && index3 != i && index3!=j){
                    List<Integer> list1 = new ArrayList<>();
                    if (three<=one){
                        list1.add(three);
                        list1.add(one);
                        list1.add(two);
                    }
                    else if(three <=two){
                        list1.add(one);
                        list1.add(three);
                        list1.add(two);
                    }
                    else {
                        list1.add(one);
                        list1.add(two);
                        list1.add(three);
                    }
                    list.add(list1);
                }
            }

        }
        return list;
    }

    public int findTheWinner(int n, int k) {
        if (k==1){
            return n;
        }
        int deleted = 0;
        Node root = new Node(-1);
        Node head = root;

        for (int i = 0; i <=n; i++){
            Node node = new Node(i);
            head.next = node;
            head = head.next;
        }
        head.next = root.next;
        Node prev = head;
        head = head.next;
        int count = 1;
        while (deleted<n){
            if (count == k){
                head = head.next;
                prev.next = head;
                deleted++;
                count = 1;
            }
            head = head.next;
            prev = prev.next;
            count++;
        }
        return head.val;
    }

//    public int search(int[] nums, int target) { // 33 q no. on leetcode
//
//    }

    public int[] minOperations(String boxes) { // q no 1769 leetcode
        List<Integer> balls = new ArrayList<>();
        for (int i = 0 ;i< boxes.length();i++){
            if (boxes.charAt(i)=='1'){
                balls.add(i);
            }
        }
        int[] output = new int[boxes.length()];

        for (int i = 0 ; i < boxes.length();i++)
        {
            int numOfMoves = 0;
            for (int ball : balls){
                if (ball> i){
                    numOfMoves += ball - i;
                }
                else{
                    numOfMoves += i - ball;
                }
            }
            output[i] = numOfMoves;
        }
        return output;
    }

    public int garbageCollection(String[] garbage, int[] travel) { // q no 2391
        int n = garbage.length;
        int minutes = 0;

        int[] prefix = new int[n];

        for (int i = 1; i < n; i++){
            prefix[i] +=  prefix[i-1] + travel[i-1]; // creating an array where i th index has the time it
            // takes to reach the i th house
        }

        boolean[] seen = new boolean[3]; // creating a boolean array to see whether the truck has collected that
        // particular item

        for (int i = n-1;i>=0;i++){
            for (char c : garbage[i].toCharArray()){
                minutes++; // one minute for each pickup
                switch (c){
                    case 'P':
                        if (!seen[0]){ // this condition checks whether the truck has already collected the item as
                            // we are iterating from the last garbage place if it has collected at the end it must have
                            // collected the garbage before that and we have included rhe pickup time by adding the
                            // condition minutes++
                            seen[0] = true;
                            minutes += prefix[i];
                        }
                    case 'G':
                        if (!seen[0]){
                            seen[1] = true;
                            minutes += prefix[i];
                        }
                    default: // for case M
                        if (!seen[0]){
                            seen[2] = true;
                            minutes += prefix[i];
                        }
                }
            }
        }
        return minutes;
    }


    public int[][] diagonalSort(int[][] mat) { // sort matrix diagonally 1329 leetcode
        int rows = mat.length;
        int colums = mat[0].length;
        int[][] output = new int[rows][colums];

        boolean[][] visited = new boolean[rows][colums];

        for (int i = 0;i<rows;i++){
            for (int j = 0; j< colums;j++){
                if (visited[i][j]){
                    continue;
                }
                else{
                    visited[i][j] = true;
                    int tempI = i;
                    int tempJ = j;
                    List<Integer> diagonalRow = new ArrayList<>();
                    while (tempI<rows && tempJ<colums){
                        diagonalRow.add(mat[tempI][tempJ]);
                        tempI++;
                        tempJ++;
                    }
                    Collections.sort(diagonalRow);
                    int count = diagonalRow.size();
                    while (count> 0){
                        mat[tempI--][tempJ--] = diagonalRow.get(count);
                        count--;

                    }
                }
            }
        }
        return mat;
    } // showing that this has bad time and space complexity maybe because lets write a better solution

    public int[][] diagonalSortt(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int[][] res = new int[row][col];

        int p = 0, q = 0;
        for (int i = 0; i<row ; i++){
            for (int j = 0; j< col; j++){
                p = i;
                q = j;
                List<Integer> list = new ArrayList<>();
                if (p ==0 || q == 0){ // this check here is smart as it doesnt allow repeated traversal
                    while(p<row&&q<col){
                        list.add(mat[p][q]);
                        p++;
                        q++;
                    }
                    p = i;
                    q = j;
                    Collections.sort(list);
                    int index = 0;
                    while(p<row && q<col){
                        res[p][q] = list.get(index++);
                        p++;
                        q++;
                    }
                }
            }
        }
        return res;
    }// better time and space complexity

    public int lengthOfLongestSubstringg(String s) { //3. Longest Substring Without Repeating Characters
        Queue<Character> queue = new LinkedList<>();
        int maxLength = 0;
        for(int i=0 ; i<s.length() ; i++){
            if(!queue.contains(s.charAt(i))){
                queue.add(s.charAt(i));
                if(queue.size() > maxLength){
                    maxLength = queue.size();
                }
            }else{
                while(queue.poll() != s.charAt(i)){

                }
                queue.add(s.charAt(i));
            }
        }
        return maxLength;
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0){
            return 0;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0,j=0; i < s.length(); i++){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max, i-j+1);
        }
        return max;
    }


    public int maxWidthOfVerticalArea(int[][] points) { // as always time limit exceeded maa ki chuttttt
        int maxWidth = 0;
        for (int i = 0; i<points.length-1;i++){
            for (int j = i+1; j<points.length;j++){
                if (points[i][0]>points[j][0]){
                    int tempX = points[i][0];
                    int tempX2 =points[j][0];
                    int tempY = points[i][1];
                    int tempY2 = points[j][1];
                    points[i][0] = tempX2;
                    points[j][0] = tempX;
                    points[i][1] = tempY2;
                    points[j][1] = tempY;
                }
            }
        } // this will sort

        for (int i = 0; i < points.length-1;i++){
            int j = i+1;
            if (points[j][0]-points[i][0]>maxWidth){
                maxWidth = points[j][0]-points[i][0];
            }
        }
        return maxWidth;
    }

    public int maxWidthOfVerticalAreaa(int[][] points) { //1637. Widest Vertical Area Between Two Points Containing No Points
        int ans=0;
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));//sorting based on x-coordinate as y-coordinate is not necessary
        for(int i=1;i<points.length;i++){
            ans=Math.max(ans,points[i][0]-points[i-1][0]);
        }
        return ans;
    }

    public List<Integer> partitionLabels(String s) { // 763. Partition Labels leetcode

        if (s.length()==0 || s == null){
            return null;
        }

        List<Integer> list = new ArrayList<>();
        int[] map = new int[26];

        for (int i = 0; i < s.length();i++){
            map[s.charAt(i)-'a'] = i;
        }

        int last = 0;
        int start = 0;

        for (int i = 0; i< s.length(); i++){
            last = Math.max(last, map[s.charAt(i)-'a']);
            if (last == i){ // when the i matches the last that means every character before that has the same last index
                // so now we can add it to the list
                list.add(last-start+1);
                start = last+1; // updating start to add the size
            }
        }
        return list;
    }

    //609. Find Duplicate File in System
    public List<List<String>> findDuplicate(String[] paths) { // TIME LIMIT EXCEEDED
        List<List<String>> list = new ArrayList<>();

        HashMap<String,List<String>> map = new HashMap<>();

        int l = paths.length;

        for (int i = 0; i<l;i++){
            String current = paths[i];
            StringBuilder sb = new StringBuilder();
            char[] stc = current.toCharArray();
            int m = current.length();
            int j = 0;
            while (stc[j] != ' '){
                sb.append(stc[j]);
            }
            String path = sb.toString(); // creating a path string from the string builder
            sb.setLength(0);
            j++; // to skip the initial space we are in
            String res = "";
            String name = "";
            while(j<m){
                if (stc[j] == ' '){
                    res = "";
                    name = "";
                }
                else if (stc[j] == '('){
                    name = path + '/' + res;
                    res = "";
                }
                else if (stc[j] == ')'){
                    if (map.containsKey(res)){
                        List<String> slist = map.get(res);
                        slist.add(name);
                        map.put(res,slist);
                    }
                    else{
                        List<String> slist = new ArrayList<>();
                        slist.add(name);
                        map.put(res,slist);
                    }
                }
                else{
                    res += stc[j];
                }
                j++;
            }

        }
        for (String s : map.keySet() ){ // so the plan is to iterate over the keyset of hashmap  and get list of string
            // associated to that key
            List<String> slist = map.get(s);
            if (slist.size()>1){
                list.add(slist);
            }
        }
        return list;
    }

    public List<List<String>> findDuplicateBetter(String[] paths) {

        List<List<String>> result = new ArrayList<>();

        Map<String, List<String>> m = new HashMap<>();
        for (String path : paths) {
            String[] p = path.split(" ");
            String dir = p[0];

            for (int i = 1; i < p.length; i++) {
                int j = p[i].indexOf('(');
                if (j != -1) {
                    j++;
                    int k = j;
                    while(k < p[i].length() && p[i].charAt(k) != ')') {
                        k++;
                    }
                    String content = p[i].substring(j, k);
                    if (!m.containsKey(content)) {
                        m.put(content, new ArrayList<>());
                    }
                    m.get(content).add(dir + "/" + p[i].substring(0, j-1));
                }
            }
        }

        for (String key : m.keySet()) {
            if (m.get(key).size() > 1) result.add(m.get(key));
        }

        return result;
    }

    //1222. Queens That Can Attack the King
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
       List<List<Integer>> list = new ArrayList<>();

       int[][] board = new int[8][8];
       for (int i = 0; i< queens.length;i++){
           int x = queens[i][0];
           int y = queens[i][1];
           board[x][y] = 1;
       }

       int x = king[0];
       int y = king[1];

       // right
        for (int i = x+1; i<8; i++){
            if (board[i][y] == 1){
                List<Integer> list1 = new ArrayList<>();
                list1.add(i,y);
                list.add(list1);
                break;
            }
        }

        //left
        for (int i = x-1; i>=0;i--){
            if (board[i][y] == 1){
                List<Integer> list1 = new ArrayList<>();
                list1.add(i,y);
                list.add(list1);
                break;
            }
        }

        //top
        for (int i = y+1;i <8;i++){
            if (board[x][i]== 1){
                List<Integer> list1 = new ArrayList<>();
                list1.add(x,i);
                list.add(list1);
                break;
            }
        }

        //bottom
        for (int i = y-1;i >=0;i--){
            if (board[x][i]== 1){
                List<Integer> list1 = new ArrayList<>();
                list1.add(x,i);
                list.add(list1);
                break;
            }
        }

        // diagonal top left
        for (int i = x-1 , j=y-1 ; i>=0 && j>=0; i--,j--){
            if (board[i][j]== 1){
                List<Integer> list1 = new ArrayList<>();
                list1.add(i,y);
                list.add(list1);
                break;
            }
        }

        // diagonal top right
        for(int i = x - 1, j = y + 1; i >= 0 && j < 8; i--, j++)
        {
            if (board[i][j]== 1){
                List<Integer> list1 = new ArrayList<>();
                list1.add(i,y);
                list.add(list1);
                break;
            }
        }

        // diagonal bottom left
        for(int i = x + 1, j = y - 1; i < 8 && j >= 0; i++, j--)
        {
            if (board[i][j]== 1){
                List<Integer> list1 = new ArrayList<>();
                list1.add(i,y);
                list.add(list1);
                break;
            }
        }

        //diagonal bottom right
        for(int i = x + 1, j = y + 1; i < 8 && j < 8; i++, j++)
        {
            if (board[i][j]== 1){
                List<Integer> list1 = new ArrayList<>();
                list1.add(i,y);
                list.add(list1);
                break;
            }
        }
        return list;
    }

    public List<List<Integer>> queensAttacktheKingg(int[][] queens, int[] king) {
        boolean[][] board = new boolean[8][8];
        for (int[] q : queens) {
            board[q[0]][q[1]] = true;
        }

        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1},{-1,1},{1,-1},{-1,-1},{1,1}};

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        for (int[] direction : directions) { // this iterates over the array of directons created
            // which helps us to iterate over all 8 directions
            int x = king[0];
            int y = king[1];
            while (x >= 0 && x < 8 && y >= 0 && y < 8) {
                if (board[x][y]) {
                    result.add(Arrays.asList(new Integer[]{x, y}));
                    break;
                }
                x += direction[0]; // this is how we change the values of pointers
                y += direction[1];
            }
        } //  true fucking king what an approach

        return result;
    }

//    1877. Minimize Maximum Pair Sum in Array

    public int minPairSum(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        int left = 0;
        int right = n-1;

        List<Integer> pairSum = new ArrayList<>();

        while(left<right){
            pairSum.add(nums[left]+nums[right]);
            left++;
            right--;
        }

        int max = Integer.MIN_VALUE;

        for (int i : pairSum){
            if ( i > max){
                max = i;
            }
        }
        return max;
    }

    //1828. Queries on Number of Points Inside a Circle
//    public int[] countPoints(int[][] points, int[][] queries) {
//        List<Integer> result = new ArrayList<>();
//
//
//        for (int i = 0; i < queries.length;i++){
//            int count = 0;
//            for (int j = 0; j < points.length; j++){
//                if (points[i][0]-queries[j][0] < queries[j][2] && points[i][1]-queries[j][1] < queries[j][2]){
//                    count++;
//                }
//            }
//            result.add(count);
//        }
//
//        int[] sol = new int[result.size()];
//
//        for (int i = 0; i < sol.length;i++){
//            sol[i] = result.get(i);
//        }
//        return sol; // correct approach but i could have optimized in many places
//    }

    //1828. Queries on Number of Points Inside a Circle
//    public int[] countPoints(int[][] points, int[][] queries) {
//
//        int[] sol = new int[queries.length];
//        // like here instead of creating a list and doing all that bullshit
//        // i could have simply created an array of length equal to queries as that's the output length
//        // i simply update the sol[i] value ot count and return that array
//        int count, x1, x2, y1, y2;
//        double distance;
//
//        for (int i = 0 ; i < queries.length ; i++){
//            count = 0;
//            x1 = queries[i][0];
//            y1 = queries[i][1];
//            for (int j =0; j< points.length;j++){
//                x2 = points[j][0];
//                y2 = points[j][1];
//                distance = (x2-x1)*(x2-x1) + (y2-y1)*(y2-y1); //  simple 10th math to find the distance from centre
//
//
//                if (distance <= queries[i][2]*queries[i][2]){ // compare it with radius square
//                    count++;
//                }
//            }
//            sol[i] = count;
//        }
//        return sol;
//    }

//    2317. Maximum XOR After Operations

    public int maximumXOR(int[] nums) { // study bit manipulation didnt understand shit
        int res = 0;
        for(int n : nums) {
            res |= n;
        }

        return res;
    }

//    807. Max Increase to Keep City Skyline
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        // my approach is pick the min between row max and col max and replace  it with that new number
        // this won't change the skyline
        int res = 0, m = grid.length, n = grid[0].length;
        int[] side = new int[m];
        int[] top = new int[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                side[i] = Math.max(side[i],grid[i][j]);
                top[j] = Math.max(top[j],grid[i][j]);
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int min = Math.min(side[i],top[j]);
                if(grid[i][j] < min){
                    res += (min - grid[i][j]);
                }
            }
        }
        return res; //  i applied the same logic but god knows why I go t the wrong answer so fuck leetcodeeeee
    }


    //    56. Merge Intervals
    //    my solution approach was right but corner cases fucked me up pretty badly
//    public int[][] merge(int[][] intervals) {
//        Arrays.sort(intervals , Comparator.comparingInt(a -> a[0]));
//        List<List<Integer>> res = new ArrayList<>();
//
//        for (int i = 1; i<intervals.length;i++){
//            List<Integer> list1 = new ArrayList<>();
//            if (intervals[i-1][1]>=intervals[i][0]){
//                list1.add(intervals[i-1][0]);
//                list1.add(intervals[i][1]);
//            }
//            else{
//                list1.add(intervals[i][0]);
//                list1.add(intervals[i][1]);
//            }
//            res.add(list1);
//        }
//
//        int[][] tempArray = new int[res.size()][];
//        for (int i = 0; i < res.size(); i++) {
//            tempArray[i] = new int[res.get(i).size()];
//            for (int j = 0; j < tempArray[i].length; j++) {
//                tempArray[i][j] = res.get(i).get(j);
//            }
//        }
//        return tempArray;
//    }
    public int[][] merge(int[][] intervals) { // leetcode wale ka solution
        if(intervals.length == 1){
            return intervals;
        }

        Arrays.sort(intervals , Comparator.comparingInt(a -> a[0]));
        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        result.add(newInterval);
        for (int[] interval : intervals) {
            if (interval[0] <= newInterval[1]) // Overlapping intervals, move the end if needed
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            else {                             // Disjoint intervals, add the new interval to the list
                newInterval = interval;
                result.add(newInterval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }

//    1282. Group the People Given the Group Size They Belong To

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < groupSizes.length; i++){
            if (map.containsKey(groupSizes[i])){
                List<Integer> abc = map.get(groupSizes[i]);
                abc.add(i);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(groupSizes[i],list);
            }
            moveToList(result,groupSizes[i], map); //  i missed this line and the function as i was
            // not factoring the gact that the list size cant exceed the number
        }

        return result;
    }
    // right approach but we missed one thing which is the list size cant exceed the groupSizes[i] but we kept on
    // adding the index value to list , to overcome this we should update the hashmap and result list in the end of
    // every iteration and remove the key and value if its size gets more than the groupSizes[i]  value
    // lets create a helper to do this at the end of every iteration

    public void moveToList(List<List<Integer>> result , int groupSize , Map<Integer,List<Integer>> hashmap){
        if (hashmap.get(groupSize).size() == groupSize){
            result.add(hashmap.get(groupSize));
            hashmap.remove(groupSize);
        }
    }

    //1395. Count Number of Teams
    public int numTeams(int[] rating) {
        int count = 0;
        for (int i = 2; i < rating.length; i++) {
            for (int j = 1; j < i; j++) {
                for (int k = 0; k < j; k++) {
                    if ( (rating[i] > rating[j] && rating[i] > rating[k] && rating[j] > rating[k])
                            || ( rating[i] < rating[j] && rating[i] < rating[k] && rating[j] < rating[k])
                    ) {
                        count++;
                    }
                }
            }
        }
        return count;
    } // brute force ofcourse TLE

//    969. Pancake Sorting
    public List<Integer> pancakeSort(int[] arr) {

        List<Integer> result = new ArrayList<>();
        int n = arr.length;
        int largest = n;
        for (int i = 0; i<n;i++){
            int index = find(arr, largest);
            flip(arr,index);
            flip(arr,largest-1);
            result.add(index+1);
            result.add(largest--);

        }

        return result;

    }

    public int find(int[] arr , int largest){
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == largest){
                return i;
            }
        }
        return -1;
    }

    public void flip(int[] arr , int index){
        int i=0, j=index;

        while (i<j){
            int temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
    }

//    811. Subdomain Visit Count
    public List<String> subdomainVisits(String[] cpdomains) {

        Map<String, Integer> map = new HashMap();

        for(String str : cpdomains){
            String[] line = str.split(" ");
            int count = Integer.valueOf(line[0]);
            String[] domains = line[1].split("\\.");
            String temp = "";
            for(int i = domains.length - 1;i >= 0;i--){
                temp = domains[i] + (temp.equals("") ? temp : "." + temp);
                // disect this line and dry run tomorrow
                if(!map.containsKey(temp)){
                    map.put(temp, count);
                }else{
                    map.put(temp, map.get(temp) + count);
                }
            }
        }

        List<String> res = new ArrayList();
        for(String str : map.keySet()){
            res.add(map.get(str) + " " + str);
        }

        return res;
    }
    // basically same approach split till empty space then take the integer value of that string
    // then split again on the basis of '.' then add ternery operator to keep changing
    // the string and basics map .contains checks
    // at last add value + " " + key while iterating over the key set and return list


    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder,0, preorder.length-1);
    }

    public TreeNode helper(int[] preorder, int start, int end){
        if(start>end){
            return null;
        }
        TreeNode root = new TreeNode(preorder[start]);
        int i;
        for (i = start ; i <= end; i++ ){
            if (preorder[i] > root.val){
                break;
            }
        }

        root.left = helper(preorder,start+1,i-1);
        root.right = helper(preorder,i ,end);

        return root;
    }




}
class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }
}

 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }



