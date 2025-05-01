import java.util.Map;
import java.util.WeakHashMap;

public class JavaWeakHashMapExample {

    private static final Map<ImageKey, String> imageCache = new WeakHashMap<>();

    public static void main(String[] args) {
        ImageKey firstImageKey = new ImageKey("firstImage.jpg");
        ImageKey secondImageKey = new ImageKey("secondImage.jpg");

        imageCache.put(firstImageKey, "firstImageLocation");
        imageCache.put(secondImageKey, "secondImageLocation");

        System.out.println("Image Cache before GC: " + imageCache);

        // Simulate the first image key going out of scope
        firstImageKey = null;

        // Request garbage collection
        System.gc();

        // Give GC some time for cleanup
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Image Cache after GC: " + imageCache);
    }
}
