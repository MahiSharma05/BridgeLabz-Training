// 11. Container with most water

class WaterContainer {
  public int maxArea(int[] height) {
     int n = height.length-1;
     int max = 0;
     int i = 0;
     int j = height.length-1;
     while(i<j){  
         int length = Math.min(height[i], height[j]);
         int width = j-i;
         int crr = length* width;
         max = Math.max(crr , max);
         if(height[i]<height[j]){
          i++;
          }
         else{
           j--;
         }
        }
        return max;
   }
}
