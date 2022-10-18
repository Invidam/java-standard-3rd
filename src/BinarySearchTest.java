public class BinarySearchTest {

    static int[] arr = {1, 2, 6, 11, 16, 31, 45, 77, 89, 93};

    //정렬된 arr 배열에서, 원하는 값의 인덱스를 찾는 이진 검색
    static int myBinarySearch(int num) {
        int lo = 0, hi = arr.length;

        while(lo + 1 < hi) {
            int mid = (lo + hi)/2;

//            if(arr[mid] == num) return mid;
            if(arr[mid] <= num) lo = mid;
            else hi = mid;
        }

//        return lo;
        return arr[lo] == num ? lo : -1;
    }
    static int javaBinarySearch(int num) {
        int lo = -1, hi = arr.length;

        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;

            if (arr[mid] == num) {
                return mid;
            } else
                if (arr[mid] <= num) {
                lo = mid;
            } else {
                hi = mid;
            }
        }

        return hi;
    }

    public static void main(String[] args) {
        for (int num: arr
        ) {
            System.out.println("myBinarySearch(" +num +") = " + myBinarySearch(num));
        }
        int num = 123;

        System.out.println("myBinarySearch(" +num +") = " + myBinarySearch(num));
        num = -3;
        System.out.println("myBinarySearch(" +num +") = " + myBinarySearch(num));
        num = 79;
        System.out.println("myBinarySearch(" +num +") = " + myBinarySearch(num));
    }
}
