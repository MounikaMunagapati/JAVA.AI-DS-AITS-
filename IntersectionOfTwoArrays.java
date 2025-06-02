class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int i=0,j=0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n=nums1.length;
        int m=nums2.length;
        ArrayList<Integer> result = new ArrayList<>();
        while(i<n && j<m){
            if(nums1[i]<nums2[j]){
                i++;
            }
            else if(nums1[i]>nums2[j]){
                j++;
            }
            else{
                result.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] output = new int[result.size()];
        int k=0;
        while(k<result.size()){
            output[k]=result.get(k);
            k++;
        }
        return output;
    }
}