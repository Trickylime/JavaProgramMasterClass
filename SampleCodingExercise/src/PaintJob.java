public class PaintJob {
    public static void main(String[] args) {
        System.out.println(getBucketCount(3.4, 1.5));
    }
    public static int getBucketCount(double width, double height, double areaPerBucket, int extraBucket){
        if(width <= 0 || height <= 0 || areaPerBucket <= 0 || extraBucket < 0){
            return -1;
        }

        extraBucket *= areaPerBucket;
        double area = width * height;
        double remainder = area - extraBucket;

        int buyBucket = 0;
        double buyBucketArea = 0;

        for(int i = 1; buyBucketArea < remainder; i++){
            buyBucket++;
            buyBucketArea += areaPerBucket;
        }
        return buyBucket;
    }

    public static int getBucketCount(double width, double height, double areaPerBucket){
        if(width <= 0 || height <= 0 || areaPerBucket <= 0){
            return -1;
        }

        double area = width * height;

        int buyBucket = 0;
        double buyBucketArea = 0;

        for(int i = 1; buyBucketArea < area; i++){
            buyBucket++;
            buyBucketArea += areaPerBucket;
        }
        return buyBucket;

    }

    public static int getBucketCount(double area, double areaPerBucket){
        if(area <= 0 || areaPerBucket <= 0){
            return -1;
        }

        int buyBucket = 0;
        double buyBucketArea = 0;

        for(int i = 1; buyBucketArea < area; i++){
            buyBucket++;
            buyBucketArea += areaPerBucket;
        }
        return buyBucket;

    }
}
