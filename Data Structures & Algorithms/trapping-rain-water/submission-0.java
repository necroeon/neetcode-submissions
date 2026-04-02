class Solution{
	public int trap(int[] height){
		if (height == null || height.length == 0){
			return 0;
		}

		int l = 0, r = height.length-1;
		int lMax = height[l], rMax = height[r];
		int res = 0;
		
		while (l < r){
			if (lMax < rMax){
				l+=1;
				lMax = Math.max(lMax, height[l]);
				res += lMax - height[l];
			}else{
				r-=1;
				rMax = Math.max(rMax, height[r]);
				res += rMax - height[r];
			}
		}
		return res;
	}
}
