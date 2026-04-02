class Solution {
public int[] twoSum (int[] numbers, int target){
	int left = 0; //left pointer
	int right = numbers.length-1; //right pointer
	
	while (left < right){
		int sum = numbers[left] + numbers[right]; //adding predefined left and right pointers and check if they satisty target
			if(sum == target){
				return new int []{left + 1, right + 1};
			}
			if(sum < target){
				left++; //move left pointer forward to find appropriate number
			}else{
				right--; //move right pointer backward to find the appropriate number
			}
		}
		return new int[]{};
	}
}
		
		