package dsa;

public class bitonicArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11};
		System.out.println(solve(arr, 12));
	}
	
	public static int solve(int[] A, int B) {
        int l = 0;
        int r = A.length-1;
        int peak = -1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(A[mid] > A[mid-1] && A[mid] > A[mid+1]){
                peak = mid;
                break;
            }
            if(A[mid] < A[mid+1]){
                l=mid+1;
            }
            if(A[mid] > A[mid+1]){
                r = mid-1;
            }
        }
        System.out.println(peak);
        l = 0;
        r = peak;
        while(l<=r){
            int mid  = l+(r-l)/2;
            if(A[mid] == B)
                return mid;
            if(A[mid] > B){
                r = mid-1;
            } else {
                l = mid+1;
            }
        }

        l = peak+1;
        r = A.length-1;
        while(l<=r){
            int mid  = l+(r-l)/2;
            if(A[mid] == B)
                return mid;
            if(A[mid] > B){
                l = mid+1;
            } else {
                r = mid-1;
            }
        }

        return -1;
    }

}
